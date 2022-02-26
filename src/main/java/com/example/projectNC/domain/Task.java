package com.example.projectNC.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String date;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User primaryUser;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "COURSE_ID")
    private Course primaryCourse;

    @ElementCollection(targetClass = TypeOfLesson.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "material_type", joinColumns = @JoinColumn(name = "id_material"))
    @Enumerated(EnumType.STRING)
    private Set<TypeOfLesson> typesOfLessons;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "LINK_ID")
    private Link link;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getPrimaryUser() {
        return primaryUser;
    }

    public void setPrimaryUser(User primaryUser) {
        this.primaryUser = primaryUser;
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

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }
}
