package com.cognizant.junitassertions;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

public class AssertionsTest {

    @Test
    public void testAssertEquals() {
        StudentManager manager = new StudentManager();
        manager.addStudent(101, "Aarav");
        assertEquals(1, manager.getStudentCount());
    }

    @Test
    public void testAssertTrue() {
        StudentManager manager = new StudentManager();
        assertTrue(manager.isStudentActive(3.8));
    }

    @Test
    public void testAssertFalse() {
        StudentManager manager = new StudentManager();
        assertFalse(manager.isStudentActive(1.5));
    }

    @Test
    public void testAssertNull() {
        StudentManager manager = new StudentManager();
        assertNull(manager.getStudentName(999));
    }

    @Test
    public void testAssertNotNull() {
        StudentManager manager = new StudentManager();
        manager.addStudent(102, "Priya");
        assertNotNull(manager.getStudentName(102));
    }
}
