package com.example.projectNC.repos;


import com.example.projectNC.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long>
{
    Course findByName(String name);
}
