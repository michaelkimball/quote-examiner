package dev.michaelkimball.opennlp.controllers;

import dev.michaelkimball.opennlp.models.ExaminedQuote;
import dev.michaelkimball.opennlp.models.User;
import dev.michaelkimball.opennlp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Set;

@RestController
@RequestMapping("/examinedQuotes")
public class ExaminedQuoteController {
    private final UserService userService;

    @Autowired
    public ExaminedQuoteController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<Set<ExaminedQuote>> getAllUserExaminedQuotes(Principal principal){
        User user = this.userService.getUserById(principal.getName()).orElse(new User());
        return new ResponseEntity<>(user.getQuotes(), HttpStatus.OK);
    }
}
