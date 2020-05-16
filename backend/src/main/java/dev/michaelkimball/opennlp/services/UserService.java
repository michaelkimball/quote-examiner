package dev.michaelkimball.opennlp.services;

import dev.michaelkimball.opennlp.models.User;
import dev.michaelkimball.opennlp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user){
        this.userRepository.save(user);
    }

    public Optional<User> getUserById(String id){
        return this.userRepository.findById(id);
    }
    public static class UserNotFound extends RuntimeException{ }
}
