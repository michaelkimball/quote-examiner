package dev.michaelkimball.opennlp.repositories;

import dev.michaelkimball.opennlp.models.ExaminedQuote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public class MockExaminedQuoteRepository implements ExaminedQuoteRepository {
    @Override
    public Iterable<ExaminedQuote> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ExaminedQuote> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ExaminedQuote> S save(S s) {
        return s;
    }

    @Override
    public <S extends ExaminedQuote> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<ExaminedQuote> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<ExaminedQuote> findAll() {
        return null;
    }

    @Override
    public Iterable<ExaminedQuote> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(ExaminedQuote examinedQuote) {

    }

    @Override
    public void deleteAll(Iterable<? extends ExaminedQuote> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
