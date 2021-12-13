package com.example.demo.services;

import com.example.demo.contract.*;
import com.example.demo.model.Actor;
import com.example.demo.model.Category;
import com.example.demo.model.Film;
import com.example.demo.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class ExternalAPIFetcher {
    private final WebClient webClient;
    private final String apiKey;

    public ExternalAPIFetcher(@Value("${themoviedb.api.key}") final String apiKey, @Autowired WebClient webClient) {
        this.apiKey = apiKey;
        this.webClient = webClient;
    }

    public Genre[] fetchGenre() {
        return webClient
                .get()
                .uri("/genre/movie/list?api_key=%s".formatted(apiKey))
                .retrieve()
                .bodyToMono(GenreList.class)
                .blockOptional()
                .orElse(new GenreList(new Genre[0]))
                .getGenres();
    }

    public List<Movie> fetchNowPlayingMovies(int maximumPage) {
        return IntStream.rangeClosed(1, maximumPage)
                .boxed()
                .map(page -> webClient
                        .get()
                        .uri("/movie/now_playing?page=%d&api_key=%s".formatted(page, apiKey))
                        .retrieve()
                        .bodyToMono(PagedMovies.class)
                        .blockOptional()
                        .orElse(new PagedMovies())
                        .getResults())
                .flatMap(Arrays::stream)
                .toList();
    }

    public List<Movie> fetchMoviesForYear(int year, int maximumPage) {
        return IntStream.rangeClosed(1, maximumPage)
                .boxed()
                .map(page -> webClient
                        .get()
                        .uri("/discover/movie?primary_release_year=%d&page=%d&api_key=%s".formatted(year, page, apiKey))
                        .retrieve()
                        .bodyToMono(PagedMovies.class)
                        .blockOptional()
                        .orElse(new PagedMovies())
                        .getResults())
                .flatMap(Arrays::stream)
                .toList();
    }

    public List<Category> fetchCategories() {
        return Stream.of(fetchGenre())
                .map(Category::fromGenre)
                .toList();
    }

    public List<Language> fetchLanguages() {
        return fetchNowPlayingMovies(100)
                .stream()
                .map(Language::fromMovie)
                .distinct()
                .toList();
    }

    public List<Person> fetchPeople(int howMany) {
        var latestId = Objects.requireNonNull(webClient.get().uri("/person/latest?api_key=%s".formatted(apiKey)).retrieve().bodyToMono(Person.class).block()).getId();

        return IntStream.rangeClosed(1, howMany)
                .boxed()
                .map(dec -> webClient.get().uri("/person/%d?api_key=%s".formatted(latestId - dec, apiKey)).retrieve().bodyToMono(Person.class).block())
                .toList();
    }

    public List<Actor> fetchActors() {
        return fetchPeople(100)
                .stream()
                .map(Actor::fromPerson)
                .toList();
    }

    public List<Film> fetchFilms() {

        return IntStream.rangeClosed(1980, Calendar.getInstance().get(Calendar.YEAR))
                .boxed()
                .map(year -> fetchMoviesForYear(year, 1))
                .flatMap(List::stream)
                .map(Film::fromMovie)
                .toList();
    }
}
