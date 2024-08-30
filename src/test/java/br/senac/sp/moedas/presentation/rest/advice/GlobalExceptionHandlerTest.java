package br.senac.sp.moedas.presentation.rest.advice;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    @Test
    void testHandleAllExceptions() {
        // Arrange
        Exception ex = new Exception("Test exception message");
        WebRequest request = mock(WebRequest.class);

        // Act
        ResponseEntity<Object> responseEntity = globalExceptionHandler.handleAllExceptions(ex, request);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("INTERNAL_SERVER_ERROR", ((GlobalExceptionHandler.ErrorResponse) responseEntity.getBody()).getErrorCode());
        assertEquals("Test exception message", ((GlobalExceptionHandler.ErrorResponse) responseEntity.getBody()).getErrorMessage());
    }
}
