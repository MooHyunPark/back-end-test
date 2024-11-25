package co.kr.metacoding.backendtest.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;



}


