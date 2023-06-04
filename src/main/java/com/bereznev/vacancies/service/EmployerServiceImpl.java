package com.bereznev.vacancies.service;
/*
    =====================================
    @author Bereznev Nikita @CreativeWex
    =====================================
 */

import com.bereznev.vacancies.entity.Employer;
import com.bereznev.vacancies.entity.Vacancy;
import com.bereznev.vacancies.utils.HttpUtils;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Log4j
@Service
public class EmployerServiceImpl implements EmployerService{
    private final VacancyService vacancyService;
    private final String EMPLOYERS_API_URL = "https://api.hh.ru/employers/";

    @Autowired
    public EmployerServiceImpl(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    private Employer convertJsonEmployersToList(String jsonResponse) {
        Gson gson = new Gson();
        return gson.fromJson(jsonResponse, Employer.class);
    }

    //TODO: добавить area
    @Override
    public Employer getById(long employerId) {
        String response = HttpUtils.sendHttpRequest(EMPLOYERS_API_URL + employerId,
                "EmployerServiceImpl (getById)");
        return convertJsonEmployersToList(response);
    }

    @Override
    public Set<Employer> getEmployersByVacancy(String vacancyName) {
        List<Vacancy> vacancies = vacancyService.getVacanciesByName(vacancyName);
        Set<Employer> employers = new HashSet<>();
        for (Vacancy vacancy : vacancies) {
            employers.add(getById(vacancy.getEmployer().getId()));
        }
        return employers;
    }
}
