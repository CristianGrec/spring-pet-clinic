package com.springtraining.springpetclinic.services.map;

import com.springtraining.springpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


class OwnerServiceMapTest {
    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(),new PetServiceMap());
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setLastName("cristi");
        ownerServiceMap.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1,owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(1L);
        assertEquals(1,owner.getId());
    }

    @Test
    void save() {
        Owner owner2 = new Owner();
        owner2.setId(2L);
        ownerServiceMap.save(owner2);
        assertEquals(2,ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
      Owner owner = new Owner();
      owner.setId(1L);
        ownerServiceMap.delete(ownerServiceMap.findById(1L));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(1L);
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
       Owner owner = ownerServiceMap.findByLastName("cristi");
        assertEquals("cristi",owner.getLastName());
    }
}