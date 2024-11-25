package co.kr.metacoding.backendtest.user;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@RequiredArgsConstructor // final이 붙어있는 변수의 생성자를 만들어준다
@Repository
public class UserRepository {

    private final EntityManager em;


    public Optional<User> selectUser(String id) {
            // null 처리를 하기 위해 Optional 처리를 하였음
        return Optional.ofNullable(em.find(User.class, id));
    }



    public void saveUser(User user) {
        em.persist(user);
    }


}
