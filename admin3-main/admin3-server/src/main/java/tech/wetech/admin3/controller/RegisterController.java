package tech.wetech.admin3.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.admin3.sys.model.User;
import tech.wetech.admin3.sys.service.UserService;

/**
 * 注册接口
 */
@RestController
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    private ResponseEntity<User> register(@RequestBody @Valid RegisterRequest request) {
        return new ResponseEntity<>(
            userService.register(
                request.username(),
                request.password(),
                request.gender()
            ),
            HttpStatus.CREATED
        );
    }

    record RegisterRequest(
        @NotBlank String username,
        @NotBlank String password,
        @NotNull User.Gender gender
    ) {}

}
