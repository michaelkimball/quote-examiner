package dev.michaelkimball.opennlp.repositories;

import dev.michaelkimball.opennlp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
