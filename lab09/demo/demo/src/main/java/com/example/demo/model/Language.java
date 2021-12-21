package com.example.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Language {
    private Integer languageId;
    private String name;
    private Timestamp lastUpdate;
    private Collection<Film> films;

    public Language() {
    }

    public Language(Integer languageId, String name) {
        this.languageId = languageId;
        this.name = name;
    }

    @Id
    @Column(name = "language_id")
    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
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

        if (languageId != null ? !languageId.equals(language.languageId) : language.languageId != null) return false;
        if (name != null ? !name.equals(language.name) : language.name != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(language.lastUpdate) : language.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = languageId != null ? languageId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
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
