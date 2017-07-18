package com.distrilledsch.randombeer.repository;

import org.springframework.data.repository.CrudRepository;

import com.distrilledsch.randombeer.models.Beer;

public interface BeerRepository extends CrudRepository<Beer, Long> {

}
