package com.triptech.mocks;

import com.triptech.entities.TourOrder;
import com.triptech.entities.Travel;
import com.triptech.repositories.TravelRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TravelRepositoryMock implements TravelRepository {
    @Override
    public List<Travel> findAll() {
        return null;
    }

    @Override
    public List<Travel> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Travel> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Travel> findAllById(Iterable<Long> iterable) {
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
    public void delete(Travel travel) {

    }

    @Override
    public void deleteAll(Iterable<? extends Travel> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Travel> S save(S s) {
        return null;
    }

    @Override
    public <S extends Travel> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Travel> findById(Long aLong) {
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
    public <S extends Travel> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Travel> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Travel getOne(Long aLong) {
        Travel travel = new Travel();
        travel.setMaxNumber(3);
        TourOrder order = new TourOrder();
        order.setAdultCount(3);
        order.setChildCount(0);
        order.setCancelled(false);
        travel.setTourOrderList(Arrays.asList(order));

        return travel;
    }

    @Override
    public <S extends Travel> Optional<S> findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Travel> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Travel> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Travel> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Travel> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Travel> boolean exists(Example<S> example) {
        return false;
    }
}
