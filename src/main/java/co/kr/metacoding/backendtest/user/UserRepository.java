package co.kr.metacoding.backendtest.user;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@RequiredArgsConstructor // final이 붙어있는 변수의 생성자를 만들어준다
@Repository
public class UserRepository {

    private final EntityManager em;

    // 유저 조회
    public Optional<User> selectUser(Integer id) {
            // null 처리를 하기 위해 Optional 처리를 하였음
        return Optional.ofNullable(em.find(User.class, id));
    }

    // 유저 저장
    public void saveUser(User user) {
        em.persist(user);
    }


}
