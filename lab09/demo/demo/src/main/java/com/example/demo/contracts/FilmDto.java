package com.example.demo.contracts;

import com.example.demo.model.Film;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmDto {
    private Integer id;
    private String title;
    private Integer releaseYear;
    private LanguageDto language;
    private Integer rentalDuration;
    private BigDecimal rentalRate;
    private BigDecimal replacementCosts;

    public Film dtoTOEntity( ){
        Film film = new Film();
        film.setFilmId(this.getId());
        film.setTitle(this.getTitle());
        film.setReleaseYear(this.getReleaseYear());
        film.setRentalDuration(this.rentalDuration);
        film.setRentalRate(this.rentalRate);
        film.setReplacementCost(this.replacementCosts);
        film.setLastUpdate(Timestamp.from(Instant.now()));
        film.setLanguage(this.language.dtoToEntity());
        return film;
    }
}
