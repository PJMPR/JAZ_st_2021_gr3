package com.example.demo.repositories;

import com.example.demo.contracts.FilmDto;
import com.example.demo.contracts.LanguageDto;
import com.example.demo.model.Film;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class FilmsRepository {

    private final EntityManager entityManager;
    Calendar timestamp = Calendar.getInstance();


    private FilmDto createFilmDto(Film film) {
        return FilmDto.builder()
                .id(film.getFilmId())
                .title(film.getTitle())
                .releaseYear(film.getReleaseYear())
                .language(LanguageDto.builder().id(film.getLanguage().getLanguageId()).name(film.getLanguage().getName()).build())
                .rentalDuration(new BigDecimal(film.getRentalDuration())).rentalRate(film.getRentalRate())
                .replacementCosts(film.getReplacementCost()).build();
    }

    private String appendToQuery(FilmDto film){
        String str = "";

        if(film.getId() != null ){
            str+="film_id="+film.getId().toString()+" and ";
        }
        if(film.getTitle() != null && !Objects.equals(film.getTitle(), "")){
            str+="title='"+film.getTitle()+ "' and ";
        }
        if(film.getReleaseYear() != null){
            str+="release_year="+film.getReleaseYear().toString()+" and ";
        }
        if(film.getRentalDuration() != null){
            str+="rental_duration="+film.getRentalDuration().toString()+" and ";
        }
        if(film.getRentalRate() != null){
            str+="rental_rate="+film.getRentalRate().toString()+" and ";
        }
        if(film.getReplacementCosts() != null){
            str+="replacement_cost="+film.getReplacementCosts().toString()+" and ";
        }
        if(film.getLanguage().getId() != null && film.getLanguage().getId() !=7){
            str+="language_id="+film.getLanguage().getId().toString()+" and ";
        }

        if(!str.equals("")){
            return "where "+str+"true";
        }else return str;
    }
    @Transactional
    public HttpStatus updateFilm(FilmDto film) throws Exception {
        try {
            entityManager.joinTransaction();
            entityManager.createQuery("update Film a set " + "a.title=:title," + "a.language.languageId=:languageId," + "a.releaseYear=:releaseYear," +
                    "a.rentalDuration=:rentalDuration," + "a.rentalRate=:rentalRate," + "a.replacementCost=:replacementCost," + "a.lastUpdate=:lastUpdate " +
                    "where a.filmId=:id").setParameter("title", film.getTitle()).setParameter("languageId", film.getLanguage().getId())
                    .setParameter("releaseYear", film.getReleaseYear()).setParameter("rentalDuration", film.getRentalDuration().intValue())
                    .setParameter("rentalRate", film.getRentalRate()).setParameter("replacementCost", film.getReplacementCosts())
                    .setParameter("lastUpdate", Timestamp.from(timestamp.getTime().toInstant()))
                    .setParameter("id", film.getId()).executeUpdate();
            return HttpStatus.OK;
        } catch (Exception e) {
            throw new Exception();
        }
    }

    public List<FilmDto> getFilmsByPage(int page, int size,FilmDto film) throws Exception {
        String query="Select * From film "+appendToQuery(film);

        try {
            return (List<FilmDto>) entityManager.createNativeQuery(query+ " limit " +size+ " offset " +(page-1)*size,Film.class)
                    .getResultStream().map(f -> createFilmDto((Film) f)).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception();
        }
    }

    @Transactional
    public HttpStatus createFilm(FilmDto newFilm) {
        try {
            entityManager.joinTransaction();
            entityManager.createNativeQuery("INSERT INTO Film " +
                            "(title,release_year,rental_duration,rental_rate,replacement_cost,last_update,language_id)" +
                            "VALUES (?,?,?,?,?,?,?)").setParameter(1, newFilm.getTitle()).setParameter(2, newFilm.getReleaseYear())
                    .setParameter(3, newFilm.getRentalDuration()).setParameter(4, newFilm.getRentalRate())
                    .setParameter(5, newFilm.getReplacementCosts()).setParameter(6, Timestamp.from(timestamp.getTime().toInstant()))
                    .setParameter(7, newFilm.getLanguage().getId())
                    .executeUpdate();
            return HttpStatus.CREATED;
        } catch (Exception e) {
            return HttpStatus.I_AM_A_TEAPOT;
        }
    }


    @Transactional
    public HttpStatus deleteFilmById(int id) throws Exception {
        try {
            entityManager.joinTransaction();
            entityManager.createQuery("SET FOREIGN_KEY_CHECKS=0").executeUpdate();
            entityManager.createQuery("DELETE from Film a where a.filmId=:id").setParameter("id", id).executeUpdate();
            entityManager.createQuery("SET FOREIGN_KEY_CHECKS=1").executeUpdate();
            return HttpStatus.OK;
        } catch (Exception e) { throw new Exception();
        }
    }


}