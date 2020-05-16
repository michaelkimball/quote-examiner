package dev.michaelkimball.opennlp.controllers;

import dev.michaelkimball.opennlp.models.User;
import dev.michaelkimball.opennlp.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        log.info("principal {}", principal.getAttributes());
        Optional<User> user = this.userService.getUserById(principal.getName());
        if(!user.isPresent()){
            User newUser = new User();
            newUser.setName(principal.getAttribute("name"));
            newUser.setId(principal.getName());
            this.userService.save(newUser);
        }
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }
}
