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
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/userLogin")
    public ResponseEntity<Account> getUserDetails(@RequestBody Account userCredentials) throws UserCollectionException{
        return new ResponseEntity<>(userService.getUserDetails(userCredentials), HttpStatus.OK);
    }


}
