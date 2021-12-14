package com.example.demo.serviceAndRepo;

import com.example.demo.contract.MovieDto;
import com.example.demo.model.Film;
import com.example.demo.contract.MovieConventer;
import com.example.demo.serviceAndRepo.Repositories.FilmRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Service {
    final String API_URL = "https://api.themoviedb.org/3/movie/";
    final String API_KEY = System.getenv("TheMovieDbApiKey");
    RestTemplate rest;
    MovieConventer movieConventer;
    FilmRepository filmRepository;

    public Service(RestTemplate rest, MovieConventer movieConventer, FilmRepository filmRepository) {
        this.rest = rest;
        this.movieConventer = movieConventer;
        this.filmRepository = filmRepository;
    }

    public MovieDto getMovie(int id){
        MovieDto movie = rest.getForEntity( API_URL+
                id +
                "?api_key=" + API_KEY, MovieDto.class).getBody();
        return movie;
    }

    public void moviedtoTOFilmAndSave(MovieDto movieDto){
        Film film = movieConventer.dtoToEntity(movieDto);
        System.out.println(film.toString());
        // filmRepository.save(film);
    }

}
