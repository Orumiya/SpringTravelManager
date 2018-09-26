package com.triptech.mocks;

import com.triptech.entities.TourOrder;
import com.triptech.repositories.TourOrderRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class OrderRepositoryMock implements TourOrderRepository {
    @Override
    public List<TourOrder> findAll() {
        return null;
    }

    @Override
    public List<TourOrder> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<TourOrder> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<TourOrder> findAllById(Iterable<Long> iterable) {
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
    public void delete(TourOrder tourOrder) {

    }

    @Override
    public void deleteAll(Iterable<? extends TourOrder> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends TourOrder> S save(S s) {
        return null;
    }

    @Override
    public <S extends TourOrder> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<TourOrder> findById(Long aLong) {
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
    public <S extends TourOrder> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<TourOrder> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public TourOrder getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends TourOrder> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends TourOrder> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends TourOrder> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends TourOrder> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TourOrder> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends TourOrder> boolean exists(Example<S> example) {
        return false;
    }
}
