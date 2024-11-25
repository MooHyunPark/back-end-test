package co.kr.metacoding.backendtest.user;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;



@RequiredArgsConstructor // final이 붙어있는 변수의 생성자를 만들어준다
@Repository
public class UserRepository {

    private final EntityManager em;


}
