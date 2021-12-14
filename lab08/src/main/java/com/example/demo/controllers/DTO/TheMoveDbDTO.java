package com.example.demo.controllers.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TheMoveDbDTO {
    private int id;

    @JsonAlias({"imdb_id"})
    private String imdbId;

    @JsonAlias({"original_title"})
    private String title;

    @JsonAlias({"overview"})
    private String description;

    @JsonAlias({"runtime"})
    private int length;
}