package com.bereznev.repository;
/*
    =====================================
    @author Bereznev Nikita @CreativeWex
    =====================================
 */

import com.bereznev.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    @Query(value = "SELECT v FROM Vacancy v WHERE v.name LIKE %?1% AND v.location LIKE %?2%")
    public List<Vacancy> getAllByNameAndLocation(String vacancyName, String location);
    @Query(value = "SELECT v FROM Vacancy v WHERE v.name LIKE %?1%")
    public List<Vacancy> getAllByName(String vacancyName);

    @Query(value = "DELETE FROM vacancies WHERE id >= 0", nativeQuery = true)
    public void deleteAll();

    public long count();
}
