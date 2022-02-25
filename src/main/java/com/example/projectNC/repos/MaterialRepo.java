package com.example.projectNC.repos;

import com.example.projectNC.domain.Material;
import com.example.projectNC.domain.Message;
import com.example.projectNC.domain.YearOfStudying;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface MaterialRepo extends CrudRepository<Material, Long> {

    List<Material> findByYearsOfStudying(Set<YearOfStudying> yearsOfStudying);
    List<Material> findByDate(String date);
    List<Material> findByTagAndDate(String tag, String date);
}

