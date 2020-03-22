package com.fz6m.answer.fz6m.controller;



import com.fz6m.answer.fz6m.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(headers="Accept=application/json",produces="application/json;charset=UTF-8")
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping("/login")
    public Object userLogin(@RequestParam(value = "id") Integer id) {
        return userService.login(id);
    }

    @GetMapping("/token")
    public Object userTokenVerification(@RequestParam(value = "token") String token) {
        return userService.token(token);
    }

    @PostMapping("/answer")
    public Object userAnswer(@RequestParam(value = "token") String token,
                             @RequestParam(value = "id") Integer id,
                             @RequestParam(value = "answer") Integer answer) {
        return userService.answer(token, id, answer);
    }

    @GetMapping("/stata")
    public Object userStata(@RequestParam(value = "id") Integer id) {
        return userService.stata(id);
    }

    
}
