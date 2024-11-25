package co.kr.metacoding.backendtest._core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

@Component
@Aspect
public class MyAspect {

    @Autowired
    private HttpServletRequest request;

    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.GetMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PutMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    private void logClientAgent(JoinPoint jp) throws Throwable {
        String userAgent = request.getHeader("User-Agent");
        System.out.println("Client User-Agent 출력 결과 : " + userAgent);
    }
}
