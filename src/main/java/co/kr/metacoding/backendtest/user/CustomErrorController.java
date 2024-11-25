package co.kr.metacoding.backendtest.user;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {

    // 없는 경로를 요청하면 아래 메서드가 실행됩니다.
    @RequestMapping("/error")
    public ResponseEntity<Map<String, Object>> handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("jakarta.servlet.error.status_code");

        Map<String, Object> response = new HashMap<>();
        response.put("reason", "없는 경로를 요청하였습니다.");
        return new ResponseEntity<>(response, HttpStatus.valueOf(statusCode));
    }
}
