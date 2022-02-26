package com.example.projectNC.domain;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "primaryCourse", fetch = FetchType.EAGER)
    private Collection<Material> abstracts;

    @OneToMany(mappedBy = "primaryCourse", fetch = FetchType.EAGER)
    private Collection<Task> tasks;

    public Course() {
    }

    public Course( String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Material> getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(Collection<Material> abstracts) {
        this.abstracts = abstracts;
    }
}
