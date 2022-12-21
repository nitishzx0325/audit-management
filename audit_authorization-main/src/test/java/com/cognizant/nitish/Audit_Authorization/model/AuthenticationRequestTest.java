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

@ContextConfiguration(classes = {AuthenticationRequest.class})
@ExtendWith(SpringExtension.class)
class AuthenticationRequestTest {
    @Autowired
    private AuthenticationRequest authenticationRequest;

    /**
     * Method under test: {@link AuthenticationRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(authenticationRequest.canEqual("Other"));
        assertTrue(authenticationRequest.canEqual(authenticationRequest));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link AuthenticationRequest}
     *   <li>{@link AuthenticationRequest#setPassword(String)}
     *   <li>{@link AuthenticationRequest#setUsername(String)}
     *   <li>{@link AuthenticationRequest#toString()}
     *   <li>{@link AuthenticationRequest#getPassword()}
     *   <li>{@link AuthenticationRequest#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        AuthenticationRequest actualAuthenticationRequest = new AuthenticationRequest();
        actualAuthenticationRequest.setPassword("iloveyou");
        actualAuthenticationRequest.setUsername("janedoe");
        String actualToStringResult = actualAuthenticationRequest.toString();
        assertEquals("iloveyou", actualAuthenticationRequest.getPassword());
        assertEquals("janedoe", actualAuthenticationRequest.getUsername());
        assertEquals("AuthenticationRequest(username=janedoe, password=iloveyou)", actualToStringResult);
    }

    /**
     * Method under test: {@link AuthenticationRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new AuthenticationRequest(), null);
        assertNotEquals(new AuthenticationRequest(), "Different type to AuthenticationRequest");
        assertNotEquals(new AuthenticationRequest(), 1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationRequest#equals(Object)}
     *   <li>{@link AuthenticationRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        assertEquals(authenticationRequest, authenticationRequest);
        int expectedHashCodeResult = authenticationRequest.hashCode();
        assertEquals(expectedHashCodeResult, authenticationRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationRequest#equals(Object)}
     *   <li>{@link AuthenticationRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        AuthenticationRequest authenticationRequest1 = new AuthenticationRequest();
        assertEquals(authenticationRequest, authenticationRequest1);
        int expectedHashCodeResult = authenticationRequest.hashCode();
        assertEquals(expectedHashCodeResult, authenticationRequest1.hashCode());
    }

    /**
     * Method under test: {@link AuthenticationRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setUsername("janedoe");
        assertNotEquals(authenticationRequest, new AuthenticationRequest());
    }

    /**
     * Method under test: {@link AuthenticationRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setPassword("iloveyou");
        assertNotEquals(authenticationRequest, new AuthenticationRequest());
    }

    /**
     * Method under test: {@link AuthenticationRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();

        AuthenticationRequest authenticationRequest1 = new AuthenticationRequest();
        authenticationRequest1.setUsername("janedoe");
        assertNotEquals(authenticationRequest, authenticationRequest1);
    }

    /**
     * Method under test: {@link AuthenticationRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();

        AuthenticationRequest authenticationRequest1 = new AuthenticationRequest();
        authenticationRequest1.setPassword("iloveyou");
        assertNotEquals(authenticationRequest, authenticationRequest1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationRequest#equals(Object)}
     *   <li>{@link AuthenticationRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals8() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setUsername("janedoe");

        AuthenticationRequest authenticationRequest1 = new AuthenticationRequest();
        authenticationRequest1.setUsername("janedoe");
        assertEquals(authenticationRequest, authenticationRequest1);
        int expectedHashCodeResult = authenticationRequest.hashCode();
        assertEquals(expectedHashCodeResult, authenticationRequest1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationRequest#equals(Object)}
     *   <li>{@link AuthenticationRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setPassword("iloveyou");

        AuthenticationRequest authenticationRequest1 = new AuthenticationRequest();
        authenticationRequest1.setPassword("iloveyou");
        assertEquals(authenticationRequest, authenticationRequest1);
        int expectedHashCodeResult = authenticationRequest.hashCode();
        assertEquals(expectedHashCodeResult, authenticationRequest1.hashCode());
    }
}

