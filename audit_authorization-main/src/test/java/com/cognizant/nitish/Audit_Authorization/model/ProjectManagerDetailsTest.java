package com.cognizant.nitish.Audit_Authorization.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProjectManagerDetails.class})
@ExtendWith(SpringExtension.class)
class ProjectManagerDetailsTest {
    @Autowired
    private ProjectManagerDetails projectManagerDetails;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ProjectManagerDetails#ProjectManagerDetails(int, String, String, String, String)}
     *   <li>{@link ProjectManagerDetails#getName()}
     *   <li>{@link ProjectManagerDetails#getPassword()}
     *   <li>{@link ProjectManagerDetails#getProjectName()}
     *   <li>{@link ProjectManagerDetails#getUsername()}
     *   <li>{@link ProjectManagerDetails#isAccountNonExpired()}
     *   <li>{@link ProjectManagerDetails#isAccountNonLocked()}
     *   <li>{@link ProjectManagerDetails#isCredentialsNonExpired()}
     *   <li>{@link ProjectManagerDetails#isEnabled()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ProjectManagerDetails actualProjectManagerDetails = new ProjectManagerDetails(1, "Name", "janedoe", "iloveyou",
                "Project Name");

        assertEquals("Name", actualProjectManagerDetails.getName());
        assertEquals("iloveyou", actualProjectManagerDetails.getPassword());
        assertEquals("Project Name", actualProjectManagerDetails.getProjectName());
        assertEquals("janedoe", actualProjectManagerDetails.getUsername());
        assertTrue(actualProjectManagerDetails.isAccountNonExpired());
        assertTrue(actualProjectManagerDetails.isAccountNonLocked());
        assertTrue(actualProjectManagerDetails.isCredentialsNonExpired());
        assertTrue(actualProjectManagerDetails.isEnabled());
    }

    /**
     * Method under test: {@link ProjectManagerDetails#getAuthorities()}
     */
    @Test
    void testGetAuthorities() {
        assertTrue(projectManagerDetails.getAuthorities().isEmpty());
    }
}

