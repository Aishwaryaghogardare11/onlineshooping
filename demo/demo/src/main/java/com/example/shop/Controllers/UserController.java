package com.example.shop.Controllers;

import com.example.shop.model.User;
import com.example.shop.repository.UserRepository;
import com.example.shop.dto.ApiResponse;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ApiResponse<List<User>> all() {
        List<User> users = userRepository.findAll();
        return new ApiResponse<>(true, "Users fetched successfully", users);
    }

    @PostMapping
    public ApiResponse<User> add(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return new ApiResponse<>(true, "User added successfully", savedUser);
    }
}
