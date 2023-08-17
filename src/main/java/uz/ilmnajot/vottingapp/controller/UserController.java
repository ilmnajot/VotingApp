package uz.ilmnajot.vottingapp.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ilmnajot.vottingapp.dto.UserForm;
import uz.ilmnajot.vottingapp.entity.User;
import uz.ilmnajot.vottingapp.message.ApiResponse;
import uz.ilmnajot.vottingapp.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/vote")
    public HttpEntity<ApiResponse> registerVote(@RequestBody UserForm form) {
        ApiResponse apiResponse = userService.addVote(form);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
    @GetMapping("/{id}")
    public HttpEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }
}
