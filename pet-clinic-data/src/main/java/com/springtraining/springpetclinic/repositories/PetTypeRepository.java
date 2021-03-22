package com.springtraining.springpetclinic.repositories;

import com.springtraining.springpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long > {
}
