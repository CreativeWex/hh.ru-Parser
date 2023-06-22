package com.bereznev.service;
/*
    =====================================
    @author Bereznev Nikita @CreativeWex
    =====================================
 */

import com.bereznev.dto.SalaryDto;
import com.bereznev.entity.Salary;

import java.util.List;
import java.util.Optional;

public interface SalaryService {

    public SalaryDto getSalaryStatistics(String vacancyName, Optional<String> location);

    public void deleteAll();

    public Salary save(Salary salary);

    public long countDatabaseLinesAmount();

    public void saveAll(List<Salary> salaries);

}
