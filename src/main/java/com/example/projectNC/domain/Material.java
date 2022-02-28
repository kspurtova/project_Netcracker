package com.example.projectNC.domain;


import javax.persistence.*;
import java.util.Set;

import com.example.projectNC.domain.*;


@Entity // сущность, которую нужно сохранять в БД
@Table(name = "materials")
public class Material {
    @Id  // идентификатор
    @GeneratedValue(strategy = GenerationType.AUTO) // автоматическая генерация с помощью фреймворка и БД
    private Long id;
    private String text;
    private String tag;
    private String date;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User primaryUser;

    @ElementCollection(targetClass = YearOfStudying.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "material_year", joinColumns = @JoinColumn(name = "id_material"))
    @Enumerated(EnumType.STRING)
    private Set<YearOfStudying> yearsOfStudying;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "COURSE_ID")
    private Course primaryCourse;

    @ElementCollection(targetClass = TypeOfLesson.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "material_type", joinColumns = @JoinColumn(name = "id_material"))
    @Enumerated(EnumType.STRING)
    private Set<TypeOfLesson> typesOfLessons;



    public Material(String text, String tag, String date, User primaryUser, Set<YearOfStudying> yearsOfStudying, Course primaryCourse, Set<TypeOfLesson> typesOfLessons) {
        this.text = text;
        this.tag = tag;
        this.date = date;
        this.primaryUser = primaryUser;
        this.yearsOfStudying = yearsOfStudying;
        this.primaryCourse = primaryCourse;
        this.typesOfLessons = typesOfLessons;
    }

    public Material(String text, String tag, String date, User primaryUser, Course primaryCourse) {
        this.text = text;
        this.tag = tag;
        this.date = date;
        this.primaryUser = primaryUser;
        this.primaryCourse = primaryCourse;
    }

    public Material() {
    }

    public Long getId_material() {
        return id;
    }

    public void setId_material(Long id_material) {
        this.id = id_material;
    }

    public User getPrimaryUser() {
        return primaryUser;
    }

    public void setPrimaryUser(User primaryUser) {
        this.primaryUser = primaryUser;
    }

    public Set<YearOfStudying> getYearsOfStudying() {
        return yearsOfStudying;
    }

    public void setYearsOfStudying(Set<YearOfStudying> yearsOfStudying) {
        this.yearsOfStudying = yearsOfStudying;
    }

    public Course getPrimaryCourse() {
        return primaryCourse;
    }

    public void setPrimaryCourse(Course primaryCourse) {
        this.primaryCourse = primaryCourse;
    }

    public Set<TypeOfLesson> getTypesOfLessons() {
        return typesOfLessons;
    }

    public void setTypesOfLessons(Set<TypeOfLesson> typesOfLessons) {
        this.typesOfLessons = typesOfLessons;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
