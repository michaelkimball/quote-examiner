package dev.michaelkimball.opennlp.repositories;

import dev.michaelkimball.opennlp.models.ExaminedQuote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminedQuoteRepository extends JpaRepository<ExaminedQuote, Long> {

}
