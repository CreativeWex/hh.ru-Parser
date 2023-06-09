package com.bereznev.entity;
/*
    =====================================
    @author Bereznev Nikita @CreativeWex
    =====================================
 */

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "vacancies")
public class Vacancy {
    @Id
    private long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "vacancy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Skill> skills = new ArrayList<>();

    @SerializedName("alternate_url")
    @Column(columnDefinition = "TEXT")
    private String url;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salary_id")
    private Salary salary;

    @JsonProperty("work_experience")
    @Column(name = "experience_amount", nullable = false)
    private String experienceAmount;

    @JsonProperty("schedule")
    @Column(name = "schedule", nullable = false)
    private String workSchedule;

    @JsonProperty("employment")
    @Column(name = "employment", nullable = false)
    private String workEmployment;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String location;

    @JsonProperty("full_address")
    @Column(columnDefinition = "TEXT")
    public String fullAddress;

    //TODO: поправить отображение работодателей для каждой вакансии
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employer_id", nullable = false)
    private Employer employer;
}

