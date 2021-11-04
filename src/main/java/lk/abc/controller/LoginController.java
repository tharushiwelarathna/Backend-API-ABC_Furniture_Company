package lk.abc.controller;

import lk.abc.service.LoginService;
import lk.abc.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author Tharushi Welarathna <nirmanitharushi1@gmail.com>
 * @since 10/25/2021
 */
@RestController
@RequestMapping("api/v1/login")
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService login;



    @GetMapping("/admin/{email}/{password}")
    public ResponseEntity admin(@PathVariable String email,@PathVariable String password){
        Enum anEnum = login.checkAdmin(email, password);
        return new ResponseEntity(new StandardResponse("200", "Done", anEnum), HttpStatus.OK);
    }




}
