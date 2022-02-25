package com.example.projectNC.repos;


import com.example.projectNC.domain.YearOfStudying;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YearRepo extends JpaRepository<YearOfStudying, Long> {
    YearOfStudying findByName(String name);
}