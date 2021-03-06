package com.example.projectNC.repos;


import com.example.projectNC.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {

    List<Message> findByTag(String tag);
    List<Message> findByDate(String date);
    List<Message> findByTagAndDate(String tag, String date);

}
