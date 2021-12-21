package com.example.demo.contracts;

import com.example.demo.model.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDto {
    private Integer id;
    private String name;

    public Language dtoToEntity(){
        Language language = new Language();
        language.setLanguageId(this.id);
        language.setName(this.name);
        language.setLastUpdate(Timestamp.from(Instant.now()));
        return language;
    }
}
