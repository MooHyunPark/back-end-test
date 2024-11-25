package co.kr.metacoding.backendtest._core.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.regex.Pattern;

@Component
public class MyFilter implements Filter {

    // 허용된 문자만 포함하는 정규식 패턴
    private static final Pattern SPECIAL_CHARACTER_PATTERN = Pattern.compile("[^\\w\\d?&=:/]+");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestURL = httpRequest.getRequestURL().toString();
        System.out.println(requestURL);
        if (SPECIAL_CHARACTER_PATTERN.matcher(requestURL).find()) {
            // 특수문자가 포함된 경우 응답 스트림을 통해 직접 오류 메시지 전송
            httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpResponse.setContentType("application/json");
            httpResponse.getWriter().write("{\"message\": \"URL에는 ? & = : //를 제외한 특수문자를 사용할 수 없습니다.\"}");
            return;
        }

        // 특수문자가 없는 경우 계속 진행
        chain.doFilter(request, response);
    }

}
