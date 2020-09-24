package tranminhduc.project.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tranminhduc.project.com.demo.model.User;
import tranminhduc.project.com.demo.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUser() {
        List<User> users = userService.findAll();
        if(users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("user/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody User user){
        Optional<User> currentUser = userService.findById(id);
         if(currentUser.isPresent()){
             currentUser.get().setName(user.getName());
             currentUser.get().setPassword(user.getPassword());
             userService.save(currentUser.get());
             return new ResponseEntity<>(currentUser.get(), HttpStatus.OK);
         }
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
}
