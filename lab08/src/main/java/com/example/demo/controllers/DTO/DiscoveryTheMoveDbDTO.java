package com.example.demo.controllers.DTO;


import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class DiscoveryTheMoveDbDTO {
    @JsonAlias({"page"})
    int page;

    @JsonAlias({"results"})
    List<TheMoveDbDTO> results;

    @JsonAlias({"total_pages"})
    int total_pages;
}