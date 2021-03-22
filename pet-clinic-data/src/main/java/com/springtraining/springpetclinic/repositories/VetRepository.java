package com.springtraining.springpetclinic.repositories;

import com.springtraining.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
