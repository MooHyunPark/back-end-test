package co.kr.metacoding.backendtest.user;

import co.kr.metacoding.backendtest._core.util.Resp;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

//    @GetMapping("/users")
//    public Resp<?> findUser() {
//        List<> boardList = boardService.게시글목록보기();
//        User user = new User();
//        user.setId(1);
//        user.setName("test");
//
//        return Resp.ok(user);
//    }

    @GetMapping("/users/{id}")
    public UserResponse.UserDetailDTO selectUser(@PathVariable("id") String id) {
        System.out.println(id);
        return userService.selectUser(id);
    }

    @PostMapping("/users")
    public UserResponse.SaveUserIdDTO saveUser(@RequestBody User user, Errors errors) {
        return userService.saveUser(user);
    }

}


