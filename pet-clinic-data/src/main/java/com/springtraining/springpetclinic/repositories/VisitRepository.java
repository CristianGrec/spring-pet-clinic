package com.springtraining.springpetclinic.repositories;

import com.springtraining.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;


public interface VisitRepository extends CrudRepository<Visit,Long> {
}
