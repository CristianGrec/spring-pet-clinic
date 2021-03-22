package com.springtraining.springpetclinic.repositories;

import com.springtraining.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface  PetRepository extends CrudRepository<Pet,Long> {
}
