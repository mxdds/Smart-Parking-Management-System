package lk.ijse.user_service.controller;

import lk.ijse.user_service.entity.User;
import lk.ijse.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

        @Autowired
        private UserService service;

        @PostMapping("/register")
        public User register(@RequestBody User user) {
            return service.register(user);
        }

        @PutMapping("/{id}")
        public User update(@PathVariable Long id, @RequestBody User updated) {
            return service.update(id, updated);
        }

        @GetMapping("/{id}")
        public User get(@PathVariable Long id) {
            return service.repo.findById(id).orElseThrow();
        }

        @GetMapping("/all")
        public List<User> all() {
            return service.repo.findAll();
        }

        @DeleteMapping("delete/{id}")
        public String delete(@PathVariable Long id) {
            service.repo.deleteById(id);
            return "User deleted successfully.";
        }

        @PostMapping("/update/{id}")
        public User updateUser(@PathVariable Long id, @RequestBody User updated) {
            return service.update(id, updated);
        }

        @GetMapping("/username/{username}")
        public User findByUsername(@PathVariable String username) {
            return service.findByUsername(username);
        }


    }