package dev.michaelkimball.opennlp.repositories;

import dev.michaelkimball.opennlp.models.ExaminedQuote;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ExaminedQuoteRepository extends PagingAndSortingRepository<ExaminedQuote, Long> {
}
