package com.skypro.coursework3;

import com.skypro.coursework3.model.Question;
import com.skypro.coursework3.service.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService = new JavaQuestionService();

    @BeforeEach
    void setUp() {
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
    void questionAdd() {
        javaQuestionService.add("q6", "a6");
        assertTrue(javaQuestionService.getAll().toString().contains("Question{question='q6', answer='a6'}"));
        assertEquals(javaQuestionService.getAll().size(), 6);
    }

    @Test
    void testQuestionAdd() {
        Question question = new Question("q6", "a6");
        javaQuestionService.add(question);
        assertTrue(javaQuestionService.getAll().toString().contains("Question{question='q6', answer='a6'}"));
        assertEquals(javaQuestionService.getAll().size(), 6);
    }

    @Test
    void questionRemove() {
        Question question = new Question("q6", "a6");
        javaQuestionService.add(question);
        assertEquals(javaQuestionService.getAll().size(), 6);
        javaQuestionService.remove(question);
        assertEquals(javaQuestionService.getAll().size(), 5);
        assertFalse(javaQuestionService.getAll().toString().contains("Question{question='q6', answer='a6'}"));
    }

    @Test
    void getAll() {
        assertEquals(javaQuestionService.getAll().size(), 5);
        assertTrue(javaQuestionService.getAll().toString().contains("Question{question='q1', answer='a1'}"));
        assertTrue(javaQuestionService.getAll().toString().contains("Question{question='q2', answer='a2'}"));
        assertTrue(javaQuestionService.getAll().toString().contains("Question{question='q3', answer='a3'}"));
        assertTrue(javaQuestionService.getAll().toString().contains("Question{question='q4', answer='a4'}"));
        assertTrue(javaQuestionService.getAll().toString().contains("Question{question='q5', answer='a5'}"));
    }

    @Test
    void getRandomQuestion() {
        assertNotNull(javaQuestionService.getRandomQuestion());
    }
}
