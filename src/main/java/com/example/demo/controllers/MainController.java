package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @Autowired
    private StudentRepository studentRepository;


    @GetMapping("/")
    public String home( Model model) {
        model.addAttribute("title", "Главная страница");
        model.addAttribute("world", "World");
        Iterable<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "home";
    }

    @PostMapping("/")
    public String home(@RequestParam String studentName, @RequestParam String studentAge,  Model model) {
        Student student = new Student(studentName, Integer.parseInt(studentAge));
        studentRepository.save(student);
        return "home";
    }

}
