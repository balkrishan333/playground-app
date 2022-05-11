package com.nagpal.bala.playgroundapp.graphql.repository;

import com.nagpal.bala.playgroundapp.graphql.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
