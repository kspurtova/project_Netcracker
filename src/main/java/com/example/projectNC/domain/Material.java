package com.example.projectNC.domain;


import javax.persistence.*;

@Entity
@Table(name = "link")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_material;




}
