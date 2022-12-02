package com.skypro.coursework3.controller;

import com.skypro.coursework3.model.Question;
import com.skypro.coursework3.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/java")
    public Collection<Question> getQuestions() {
        return this.questionService.getAll();
    }

    @PutMapping("/java/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return this.questionService.add(question, answer);
    }

    @DeleteMapping("/java/remove")
    public Question removeQuestion(@RequestBody Question question) {
        return this.questionService.remove(question);
    }
}
