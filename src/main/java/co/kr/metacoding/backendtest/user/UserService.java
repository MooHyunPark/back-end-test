package co.kr.metacoding.backendtest.user;

import co.kr.metacoding.backendtest._core.error.ex.Exception404;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserService {
    // DTO로 변경하는 로직은 Service에서 모두 변경합니다.


    private final UserRepository userRepository;

    public UserResponse.UserDetailDTO selectUser(String id) {
        User user = userRepository.selectUser(id)
                .orElseThrow(() -> new Exception404("해당 id의 게시글이 없습니다 : " + id));

        return new UserResponse.UserDetailDTO(user);

    }

    @Transactional
    public UserResponse.SaveUserIdDTO saveUser(User user) {

        userRepository.saveUser(user);

        return new UserResponse.SaveUserIdDTO(user);

    }
}
