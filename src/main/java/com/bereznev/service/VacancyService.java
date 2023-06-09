package com.bereznev.service;
/*
    =====================================
    @author Bereznev Nikita @CreativeWex
    =====================================
 */

import com.bereznev.dto.vacancies.SalaryDTO;
import com.bereznev.model.Employer;
import com.bereznev.model.Vacancy;

import java.util.List;

public interface VacancyService {

    public List<Vacancy> getVacanciesByName(String vacancyName);

    public Vacancy getById(long vacancyId);
}
