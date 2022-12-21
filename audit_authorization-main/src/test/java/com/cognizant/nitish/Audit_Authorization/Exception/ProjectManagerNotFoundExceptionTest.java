package com.cognizant.nitish.Audit_Authorization.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ProjectManagerNotFoundExceptionTest {
    /**
     * Method under test: {@link ProjectManagerNotFoundException#ProjectManagerNotFoundException(String)}
     */
    @Test
    void testConstructor() {
        ProjectManagerNotFoundException actualProjectManagerNotFoundException = new ProjectManagerNotFoundException(
                "An error occurred");
        assertNull(actualProjectManagerNotFoundException.getCause());
        assertEquals(0, actualProjectManagerNotFoundException.getSuppressed().length);
        assertEquals("An error occurred", actualProjectManagerNotFoundException.getMessage());
        assertEquals("An error occurred", actualProjectManagerNotFoundException.getLocalizedMessage());
    }
}

