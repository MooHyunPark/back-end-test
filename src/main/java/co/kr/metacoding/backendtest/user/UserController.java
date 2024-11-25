package co.kr.metacoding.backendtest.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    // 유저 조회
    @GetMapping("/users/{id}")
    public UserResponse.UserDetailDTO selectUser(@PathVariable("id") Integer id) {
        return userService.selectUser(id);
    }

    // 유저 추가
    @PostMapping("/users")
    public UserResponse.SaveUserIdDTO saveUser(@Valid @RequestBody User user, Errors errors) {
        return userService.saveUser(user);
    }

    // 유저 수정
    @PutMapping("/users/{id}")
    public UserResponse.UpdateUserDTO update(@Valid @RequestBody User user, Errors errors, @PathVariable("id") Integer id) {

        return userService.updateUser(user, id);
    }

}


