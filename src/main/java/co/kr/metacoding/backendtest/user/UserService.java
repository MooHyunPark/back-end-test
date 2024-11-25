package co.kr.metacoding.backendtest.user;

import co.kr.metacoding.backendtest._core.error.ex.Exception404;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UserService {
    // DTO로 변경하는 로직은 Service에서 모두 변경합니다.


    private final UserRepository userRepository;

    // 유저 조회
    public UserResponse.UserDetailDTO selectUser(Integer id) {
        User user = userRepository.selectUser(id)
                .orElseThrow(() -> new Exception404("해당 id의 유저가 없습니다 : " + id));
        return new UserResponse.UserDetailDTO(user);
    }

    // 유저 추가
    @Transactional
    public UserResponse.SaveUserIdDTO saveUser(User user) {
        userRepository.saveUser(user);
        return new UserResponse.SaveUserIdDTO(user);
    }

    // 유저 수정
    @Transactional
    public UserResponse.UpdateUserDTO updateUser(User user, Integer id) {
        User promiseUser = userRepository.selectUser(id).orElseThrow(() -> new Exception404("해당 id의 유저가 없습니다 : " + id));;
        promiseUser.update(user.getName());
        return new UserResponse.UpdateUserDTO(promiseUser);
    }
}
