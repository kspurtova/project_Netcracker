package com.example.projectNC.domain;


import javax.persistence.*;
import java.util.Set;

import com.example.projectNC.domain.*;


@Entity
@Table(name = "materials")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_material;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
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


    public Long getId_material() {
        return id_material;
    }

    public void setId_material(Long id_material) {
        this.id_material = id_material;
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


}
