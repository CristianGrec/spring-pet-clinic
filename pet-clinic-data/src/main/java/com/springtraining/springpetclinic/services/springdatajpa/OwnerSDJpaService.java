package com.springtraining.springpetclinic.services.springdatajpa;

import com.springtraining.springpetclinic.model.Owner;
import com.springtraining.springpetclinic.repositories.OwnerRepository;
import com.springtraining.springpetclinic.repositories.PetRepository;
import com.springtraining.springpetclinic.repositories.PetTypeRepository;
import com.springtraining.springpetclinic.services.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
@Profile("springdatajpa")
@Slf4j
public class OwnerSDJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
     private final PetTypeRepository petTypeRepository;
    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;

    }

    //@Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
         ownerRepository.findAll().forEach(owners :: add);
         return owners;
    }

   // @Override
    public Owner findById(Long aLong) {
        Optional<Owner> owner = ownerRepository.findById(aLong);
        return owner.orElse(null);
    }

  //  @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

  //  @Override
    public void delete(Owner object) {
ownerRepository.delete(object);
    }

  //  @Override
    public void deleteById(Long aLong) {
ownerRepository.deleteById(aLong);
    }

  //  @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
