package com.skypro.coursework3.service;

import com.skypro.coursework3.exception.QuestionAlreadyExistsException;
import com.skypro.coursework3.exception.QuestionNotExistException;
import com.skypro.coursework3.model.Question;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{

    private Random random = new Random();

    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question questionObj = new Question(question, answer);
        if (questions.contains(questionObj)) {
            throw new QuestionAlreadyExistsException();
        }
        this.questions.add(questionObj);
        return questionObj;
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyExistsException();
        }
        this.questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotExistException();
        }
        this.questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return this.questions;
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            return null;
        }
        return this.questions.stream()
                .skip(random.nextInt(this.questions.size()))
                .findFirst()
                .orElse(null);
    }
}
