package co.kr.metacoding.backendtest._core.aop;

import co.kr.metacoding.backendtest._core.error.ex.Exception400;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;

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
        // 기본적으로 유저 에이전트를 출력
        System.out.println("Client User-Agent 출력 결과 : " + userAgent);

        Object[] args = jp.getArgs();

        for (Object arg : args) {
            if(arg instanceof Errors){
                Errors errors = (Errors) arg;

                // 에러가 발생하면 메세지와 함께 예외 throw
                // 해당 예제에서는 name 값을 "" 빈문자열로 주게 되면 400 예외를 발생시킴
                if(errors.hasErrors()) {
                    String errMsg = errors.getFieldErrors().get(0).getField() +" : "+ errors.getFieldErrors().get(0).getDefaultMessage();
                    throw new Exception400(errMsg);
                }
            }
        }

    }
}
