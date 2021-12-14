package com.example.demo.contract;




import com.example.demo.model.FilmCategory;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class MovieDto {

    int id;
    @JsonProperty("original_title")
    String title;
    @JsonProperty("overview")
    private String description;
    @JsonProperty("release_date")
    private String releaseYear;
    @JsonProperty("runtime")
    private int length;
    @JsonProperty("spoken_languages")
    private List<LanguageDTO> language;




}
