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
    public UserResponse.SaveUserIdDTO saveUser(@Valid @RequestBody UserRequest.SaveUserDTO saveUserDTO, Errors errors) {
        return userService.saveUser(saveUserDTO);
    }

    // 유저 수정
    @PutMapping("/users/{id}")
    public UserResponse.UpdateUserDTO update(@Valid @RequestBody UserRequest.UpdateUserDTO updateUserDTO, Errors errors, @PathVariable("id") Integer id) {
        return userService.updateUser(updateUserDTO, id);
    }

}


