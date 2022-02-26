package com.example.projectNC.controller;


import com.example.projectNC.domain.Course;
import com.example.projectNC.domain.Material;
import com.example.projectNC.domain.User;
import com.example.projectNC.domain.Message;
import com.example.projectNC.repos.CourseRepo;
import com.example.projectNC.repos.MaterialRepo;
import com.example.projectNC.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
/* Контроллер - это программный модуль, который по пути /...
* слушает запросы от пользователя и возвращает какие-то данные */
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private MaterialRepo materialRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/abstracts")
    public String abstracts(Map<String, Object> model) {
        Iterable<Material> materials = materialRepo.findAllBy();

        model.put("materials", materials);

        return "abstracts";
    }

    @PostMapping("/abstracts")
    public String add(@RequestParam String course, @RequestParam String type, @RequestParam String date, @RequestParam String tag, @RequestParam String text, @RequestParam String link, @RequestParam String task, @RequestParam String deadline,  Map<String, Object> model) {
       // ВОПРОС. Откуда мы берем пользователя и год обучения?

        Material material = new Material(text, tag, date, user, year, course, type);

        materialRepo.save(material);

        Iterable<Material> materials = materialRepo.findAllBy();

        model.put("materials", materials);

        return "abstracts";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filteryear, @RequestParam String filtercourse, @RequestParam String filtertype, @RequestParam String filterdate, @RequestParam String filterlist,  Map<String, Object> model) {
        Iterable<Material> materials;

        /*
        if (filteryear != null && !filteryear.isEmpty()) {
            if (filtercourse != null && !filtercourse.isEmpty()) {
                materials = materialRepo.findByYearsOfStudyingAndPrimaryCourse(filteryear, filtercourse);
            }
            else {
                materials = materialRepo.findByTag(filtertag);
            }
        } else {
            if (filterdate != null && !filterdate.isEmpty()) {
                messages = messageRepo.findByDate(filterdate);
            }
            else {
                materials = materialRepo.findAll();
            }
        }
        
         */

        model.put("materials", materials);

        return "filters";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        return "main";
    }

    @GetMapping("/schedule")
    public String schedule(Map<String, Object> model) {
        return "schedule";
    }

    @PostMapping("/schedule")
    public String add_course(@RequestParam String course, @RequestParam String type, @RequestParam String number, @RequestParam String day, Map<String, Object> model) {

        Course course1 = new Course(course);
        courseRepo.save(course1);


        /*
        Message message = new Message(text, tag, date);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

         */

        return "schedule";
    }

    @GetMapping("/filters")
    public String filters(Map<String, Object> model) {
        return "filters";
    }

    @GetMapping("/statistics")
    public String statistics(Map<String, Object> model) {
        return "statistics";
    }


 /*   @PostMapping("/news")
    public String addLink(@RequestParam String year, @RequestParam String course, @RequestParam String type, @RequestParam String date, @RequestParam String link, Map<String, Object> model) {
        Material material = new Material(year, course, type, date, link);

        materialRepo.save(material);

        Iterable<Material> materials = materialRepo.findAll();

        model.put("materials", materials);

        return "news";
    }

*/
}
