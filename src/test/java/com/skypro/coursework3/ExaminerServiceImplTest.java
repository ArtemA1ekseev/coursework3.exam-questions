package com.skypro.coursework3;

import com.skypro.coursework3.exception.IncorrectAmountOfQuestionsException;
import com.skypro.coursework3.model.Question;
import com.skypro.coursework3.service.ExaminerServiceImpl;
import com.skypro.coursework3.service.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    JavaQuestionService javaQuestionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
        Question question = new Question("q1", "a1");
        javaQuestionService.add(question);
        Question question1 = new Question("q2", "a2");
        javaQuestionService.add(question1);
        Question question2 = new Question("q3", "a3");
        javaQuestionService.add(question2);
        Question question3 = new Question("q4", "a4");
        javaQuestionService.add(question3);
        Question question4 = new Question("q5", "a5");
        javaQuestionService.add(question4);
    }

    @Test
    void getQuestions() {
        assertEquals(javaQuestionService.getAll().size(), 5);
        examinerService = new ExaminerServiceImpl(javaQuestionService);
        assertEquals(examinerService.getQuestions(2).size(),2);
        assertThrows(IncorrectAmountOfQuestionsException.class,() -> examinerService.getQuestions(6));
    }
}
