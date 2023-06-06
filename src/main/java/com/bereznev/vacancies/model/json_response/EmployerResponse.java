package com.bereznev.vacancies.model.json_response;
/*
    =====================================
    @author Bereznev Nikita @CreativeWex
    =====================================
 */

import com.bereznev.vacancies.entity.Employer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerResponse {

    @JsonProperty("vacancy")
    private String vacancyName;

    @JsonProperty("found")
    private int employersNumber;

    @JsonProperty("items")
    private Set<Employer> employers;
}