package com.example.demo.model;

import com.example.demo.contract.Movie;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collection;
import java.util.Locale;
import java.util.Objects;

@Entity
public class Language {
    private int languageId;
    private String name;
    private Timestamp lastUpdate;
    private Collection<Film> films;

    public Language(String name, Timestamp lastUpdate) {
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public Language() {
    }

    public static Language fromMovie(Movie movie) {
        var loc = new Locale(movie.getLanguage());
        return new Language(loc.getDisplayLanguage(loc), Timestamp.from(Instant.now()));
    }

    @Id
    @Column(name = "language_id")
    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Language language = (Language) o;

        if (languageId != language.languageId) return false;
        return name.equalsIgnoreCase(language.name);
    }

    @Override
    public int hashCode() {
        int result = languageId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "language")
    public Collection<Film> getFilms() {
        return films;
    }

    public void setFilms(Collection<Film> films) {
        this.films = films;
    }
}
