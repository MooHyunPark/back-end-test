package co.kr.metacoding.backendtest._core.error;

import co.kr.metacoding.backendtest._core.error.ex.Exception400;
import co.kr.metacoding.backendtest._core.error.ex.Exception404;
import co.kr.metacoding.backendtest._core.util.Resp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyControllerAdvice {


    @ExceptionHandler(Exception400.class)
    public ResponseEntity<?> err400(Exception400 e) {
        ResponseEntity rn = new ResponseEntity(Resp.fail(e.getMessage()), HttpStatus.BAD_REQUEST);
        return rn;
    }



    @ExceptionHandler(Exception404.class)
    public ResponseEntity<?> err404(Exception404 e) {
        ResponseEntity rn = new ResponseEntity(Resp.fail(e.getMessage()), HttpStatus.NOT_FOUND);
        return rn;
    }

}
