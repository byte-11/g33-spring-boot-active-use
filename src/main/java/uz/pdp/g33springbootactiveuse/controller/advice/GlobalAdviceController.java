package uz.pdp.g33springbootactiveuse.controller.advice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.pdp.g33springbootactiveuse.dto.web.ErrorResponse;
import uz.pdp.g33springbootactiveuse.exception.UserNotFoundException;

@RestControllerAdvice
public class GlobalAdviceController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(final UserNotFoundException e, final HttpServletRequest request) {
        return ResponseEntity
                .badRequest()
                .body(ErrorResponse.builder()
                        .errorConde("USER_NOT_FOUND")
                        .errorMessage(e.getMessage())
                        .path(request.getServletPath())
                        .build());
    }
}
