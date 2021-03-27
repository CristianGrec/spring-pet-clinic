package com.springtraining.springpetclinic.services.springdatajpa;

import com.springtraining.springpetclinic.model.Owner;
import com.springtraining.springpetclinic.repositories.OwnerRepository;
import com.springtraining.springpetclinic.repositories.PetRepository;
import com.springtraining.springpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByLastName() {
        Owner returnOwner = new Owner();
        returnOwner.setId(1L);
        returnOwner.setLastName("smith");
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = service.findByLastName("smith");
        assertEquals("smith",returnOwner.getLastName());
        verify(ownerRepository).findByLastName(any());


    }
}