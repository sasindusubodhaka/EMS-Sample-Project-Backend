package admin.demo.controller;

import admin.demo.exception.UserCollectionException;
import admin.demo.model.Account;
import admin.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "demo")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<Account> saveNewUser(@RequestBody Account user) throws UserCollectionException {
        return new ResponseEntity<>(userService.saveNewUser(user), HttpStatus.OK);
    }

    @GetMapping("/getUserList")
    public List<Account> getUserList() throws UserCollectionException {
        return userService.getUserAccounts();
    }

    @PostMapping("/updateUser")
    public ResponseEntity<Integer> updateUser(@RequestBody Account user) throws UserCollectionException {
        Integer result = userService.updateUser(user);
        System.out.println("result"+ result);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable Integer userId) throws UserCollectionException {
        return userService.deleteUser(userId);
    }

}
