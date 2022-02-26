package com.example.projectNC.repos;

import com.example.projectNC.domain.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface MaterialRepo extends CrudRepository<Material, Long> {

    List<Material> findByYearsOfStudying(Set<YearOfStudying> yearsOfStudying);
    List<Material> findByPrimaryCourse(Course primaryCourse);
    List<Material> findByTypesOfLessons(Set<TypeOfLesson> typesOfLessons);
    List<Material> findByDate(String date);

    List<Material> findByYearsOfStudyingAndPrimaryCourse(Set<YearOfStudying> yearsOfStudying, Course primaryCourse);
    List<Material> findByYearsOfStudyingAndTypesOfLessons(Set<YearOfStudying> yearsOfStudying, Set<TypeOfLesson> typesOfLessons);
    List<Material> findByYearsOfStudyingAndDate(Set<YearOfStudying> yearsOfStudying, String date);
    List<Material> findByPrimaryCourseAndTypesOfLessons(Course primaryCourse, Set<TypeOfLesson> typesOfLessons);
    List<Material> findByPrimaryCourseAndDate(Course primaryCourse, String Date);
    List<Material> findByTypesOfLessonsAndDate(Set<TypeOfLesson> typesOfLessons, String Date);




    List<Material> findAllBy();
}

