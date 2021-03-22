package com.springtraining.springpetclinic.repositories;

import com.springtraining.springpetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty,Long> {
}
