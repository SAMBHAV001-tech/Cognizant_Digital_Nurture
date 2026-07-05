package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.*;
import com.cognizant.ormlearn.service.AttemptService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrmLearnApplicationTests {

    @Autowired
    private AttemptService attemptService;

    @Test
    void testGetAttempt() {
        Attempt attempt = attemptService.getAttempt(1, 1);
        assertNotNull(attempt);
        assertEquals(1, attempt.getId());
        assertEquals("Sambhav Das", attempt.getUser().getName());
        assertEquals(2, attempt.getAttemptQuestions().size());

        for (AttemptQuestion aq : attempt.getAttemptQuestions()) {
            Question q = aq.getQuestion();
            System.out.println("Question text: " + q.getText());
            for (Options opt : q.getOptionsList()) {
                boolean isSelected = aq.getAttemptOptions().stream().anyMatch(ao -> ao.getOptions().getId() == opt.getId());
                System.out.println("  Option: " + opt.getText() + (isSelected ? " (Selected)" : ""));
            }
        }
    }
}
