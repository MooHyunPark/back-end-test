package co.kr.metacoding.backendtest._core.error;

import co.kr.metacoding.backendtest._core.error.ex.Exception400;
import co.kr.metacoding.backendtest._core.error.ex.Exception404;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyControllerAdvice {

    // 400 예외가 던져지면 작동하는 메서드
    @ExceptionHandler(Exception400.class)
    public ResponseEntity<?> err400(Exception400 e) {
        Map<String, String> response = new HashMap<>();
        response.put("reason", "body 값이 잘못되었다");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    // 404 예외가 던져지면 작동하는 메서드
    @ExceptionHandler(Exception404.class)
    public ResponseEntity<?> err404(Exception404 e) {
        Map<String, String> response = new HashMap<>();
        response.put("reason", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}
