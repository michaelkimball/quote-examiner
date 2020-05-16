package dev.michaelkimball.opennlp.repositories;

import dev.michaelkimball.opennlp.models.ExaminedQuote;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class MockExaminedQuoteRepository implements ExaminedQuoteRepository {

    @Override
    public List<ExaminedQuote> findAll() {
        return null;
    }

    @Override
    public List<ExaminedQuote> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ExaminedQuote> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ExaminedQuote> findAllById(Iterable<Long> iterable) {
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

    @Override
    public <S extends ExaminedQuote> S save(S s) {
        return null;
    }

    @Override
    public <S extends ExaminedQuote> List<S> saveAll(Iterable<S> iterable) {
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
    public void flush() {

    }

    @Override
    public <S extends ExaminedQuote> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<ExaminedQuote> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ExaminedQuote getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends ExaminedQuote> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ExaminedQuote> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ExaminedQuote> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ExaminedQuote> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ExaminedQuote> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ExaminedQuote> boolean exists(Example<S> example) {
        return false;
    }
}
