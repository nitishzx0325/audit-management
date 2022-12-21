package com.cognizant.nitish.Audit_Authorization.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuthenticationResponse.class})
@ExtendWith(SpringExtension.class)
class AuthenticationResponseTest {
    @Autowired
    private AuthenticationResponse authenticationResponse;

    /**
     * Method under test: {@link AuthenticationResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(authenticationResponse.canEqual("Other"));
        assertTrue(authenticationResponse.canEqual(authenticationResponse));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationResponse#AuthenticationResponse(String, String, boolean)}
     *   <li>{@link AuthenticationResponse#setName(String)}
     *   <li>{@link AuthenticationResponse#setProjectName(String)}
     *   <li>{@link AuthenticationResponse#setValid(boolean)}
     *   <li>{@link AuthenticationResponse#toString()}
     *   <li>{@link AuthenticationResponse#getName()}
     *   <li>{@link AuthenticationResponse#getProjectName()}
     *   <li>{@link AuthenticationResponse#isValid()}
     * </ul>
     */
    @Test
    void testConstructor() {
        AuthenticationResponse actualAuthenticationResponse = new AuthenticationResponse("Name", "Project Name", true);
        actualAuthenticationResponse.setName("Name");
        actualAuthenticationResponse.setProjectName("Project Name");
        actualAuthenticationResponse.setValid(true);
        String actualToStringResult = actualAuthenticationResponse.toString();
        assertEquals("Name", actualAuthenticationResponse.getName());
        assertEquals("Project Name", actualAuthenticationResponse.getProjectName());
        assertTrue(actualAuthenticationResponse.isValid());
        assertEquals("AuthenticationResponse(name=Name, projectName=Project Name, isValid=true)", actualToStringResult);
    }

    /**
     * Method under test: {@link AuthenticationResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new AuthenticationResponse("Name", "Project Name", true), null);
        assertNotEquals(new AuthenticationResponse("Name", "Project Name", true),
                "Different type to AuthenticationResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationResponse#equals(Object)}
     *   <li>{@link AuthenticationResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("Name", "Project Name", true);
        assertEquals(authenticationResponse, authenticationResponse);
        int expectedHashCodeResult = authenticationResponse.hashCode();
        assertEquals(expectedHashCodeResult, authenticationResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationResponse#equals(Object)}
     *   <li>{@link AuthenticationResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("Name", "Project Name", true);
        AuthenticationResponse authenticationResponse1 = new AuthenticationResponse("Name", "Project Name", true);

        assertEquals(authenticationResponse, authenticationResponse1);
        int expectedHashCodeResult = authenticationResponse.hashCode();
        assertEquals(expectedHashCodeResult, authenticationResponse1.hashCode());
    }

    /**
     * Method under test: {@link AuthenticationResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("Project Name", "Project Name", true);
        assertNotEquals(authenticationResponse, new AuthenticationResponse("Name", "Project Name", true));
    }

    /**
     * Method under test: {@link AuthenticationResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(null, "Project Name", true);
        assertNotEquals(authenticationResponse, new AuthenticationResponse("Name", "Project Name", true));
    }

    /**
     * Method under test: {@link AuthenticationResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("Name", "Name", true);
        assertNotEquals(authenticationResponse, new AuthenticationResponse("Name", "Project Name", true));
    }

    /**
     * Method under test: {@link AuthenticationResponse#equals(Object)}
     */
    @Test
    void testEquals7() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("Name", null, true);
        assertNotEquals(authenticationResponse, new AuthenticationResponse("Name", "Project Name", true));
    }

    /**
     * Method under test: {@link AuthenticationResponse#equals(Object)}
     */
    @Test
    void testEquals8() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("Name", "Project Name", false);
        assertNotEquals(authenticationResponse, new AuthenticationResponse("Name", "Project Name", true));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationResponse#equals(Object)}
     *   <li>{@link AuthenticationResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(null, "Project Name", true);
        AuthenticationResponse authenticationResponse1 = new AuthenticationResponse(null, "Project Name", true);

        assertEquals(authenticationResponse, authenticationResponse1);
        int expectedHashCodeResult = authenticationResponse.hashCode();
        assertEquals(expectedHashCodeResult, authenticationResponse1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationResponse#equals(Object)}
     *   <li>{@link AuthenticationResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("Name", null, true);
        AuthenticationResponse authenticationResponse1 = new AuthenticationResponse("Name", null, true);

        assertEquals(authenticationResponse, authenticationResponse1);
        int expectedHashCodeResult = authenticationResponse.hashCode();
        assertEquals(expectedHashCodeResult, authenticationResponse1.hashCode());
    }
}

