package com.cognizant.nitish.Audit_Authorization.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cognizant.nitish.Audit_Authorization.model.AuthenticationResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;

class ExceptionHandlerAdviceTest {
    /**
     * Method under test: {@link ExceptionHandlerAdvice#validationExceptions(MethodArgumentNotValidException)}
     */
    @Test
    void testValidationExceptions() {
        ExceptionHandlerAdvice exceptionHandlerAdvice = new ExceptionHandlerAdvice();
        ResponseEntity<String> actualValidationExceptionsResult = exceptionHandlerAdvice
                .validationExceptions(new MethodArgumentNotValidException(null, new BindException("Target", "Object Name")));
        assertEquals("Give Username and Password in proper-format", actualValidationExceptionsResult.getBody());
        assertEquals(HttpStatus.FORBIDDEN, actualValidationExceptionsResult.getStatusCode());
        assertTrue(actualValidationExceptionsResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link ExceptionHandlerAdvice#validationExceptions(MethodArgumentNotValidException)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testValidationExceptions2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.web.bind.MethodArgumentNotValidException.getBindingResult()" because "ex" is null
        //       at com.cognizant.nitish.Audit_Authorization.Exception.ExceptionHandlerAdvice.validationExceptions(ExceptionHandlerAdvice.java:22)
        //   In order to prevent validationExceptions(MethodArgumentNotValidException)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   validationExceptions(MethodArgumentNotValidException).
        //   See https://diff.blue/R013 to resolve this issue.

        (new ExceptionHandlerAdvice()).validationExceptions(null);
    }

    /**
     * Method under test: {@link ExceptionHandlerAdvice#exception(Exception)}
     */
    @Test
    void testException() {
        ExceptionHandlerAdvice exceptionHandlerAdvice = new ExceptionHandlerAdvice();
        ResponseEntity<Object> actualExceptionResult = exceptionHandlerAdvice.exception(new Exception("An error occurred"));
        assertTrue(actualExceptionResult.hasBody());
        assertTrue(actualExceptionResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualExceptionResult.getStatusCode());
        assertEquals("Invalid", ((AuthenticationResponse) actualExceptionResult.getBody()).getName());
        assertEquals("Invalid", ((AuthenticationResponse) actualExceptionResult.getBody()).getProjectName());
        assertFalse(((AuthenticationResponse) actualExceptionResult.getBody()).isValid());
    }

    /**
     * Method under test: {@link ExceptionHandlerAdvice#exception(Exception)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testException2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.lang.Exception.getMessage()" because "e" is null
        //       at com.cognizant.nitish.Audit_Authorization.Exception.ExceptionHandlerAdvice.exception(ExceptionHandlerAdvice.java:30)
        //   In order to prevent exception(Exception)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   exception(Exception).
        //   See https://diff.blue/R013 to resolve this issue.

        (new ExceptionHandlerAdvice()).exception(null);
    }
}

