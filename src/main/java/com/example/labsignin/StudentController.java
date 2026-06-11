package com.example.labsignin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "index";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute Student student, Model model) {
        // Validate email domain
        if (!student.getEmail().endsWith("@mail.valenciacollege.edu")) {
            model.addAttribute("error", "Email must end with @mail.valenciacollege.edu");
            return "index";
        }

        studentRepository.save(student);
        model.addAttribute("student", student);
        return "success";
    }
}
