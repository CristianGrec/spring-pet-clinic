package com.springtraining.springpetclinic.bootstrap;

import com.springtraining.springpetclinic.model.Owner;
import com.springtraining.springpetclinic.model.Pet;
import com.springtraining.springpetclinic.model.PetType;
import com.springtraining.springpetclinic.model.Vet;
import com.springtraining.springpetclinic.services.OwnerService;
import com.springtraining.springpetclinic.services.PetTypeService;
import com.springtraining.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService,VetService vetService,PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType dogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType catPetType = petTypeService.save(cat);


        Owner firstOwner = new Owner();
        firstOwner.setFirstName("cristi");
        firstOwner.setLastName("grec");
        firstOwner.setAddress("str.FirstStreet");
        firstOwner.setCity("NewYork");
        firstOwner.setTelephone("488585");

        Pet firstPet = new Pet();
        firstPet.setPetType(dogPetType);
        firstPet.setOwner(firstOwner);
        firstPet.setBirthday(LocalDate.now());
        firstPet.setName("Rosco ");
        firstOwner.getPets().add(firstPet);
        ownerService.save(firstOwner);

        Owner secondOwner = new Owner();
        secondOwner.setFirstName("ovidiu");
        secondOwner.setLastName("johnson");
        secondOwner.setAddress("str.SecondStreet");
        secondOwner.setCity("Barcelona");
        secondOwner.setTelephone("58483");

        Pet secondPet = new Pet();
        secondPet.setPetType(catPetType);
        secondPet.setOwner(secondOwner);
        secondPet.setBirthday(LocalDate.now());
        secondPet.setName("SomeCat");
        secondOwner.getPets().add(secondPet);
        ownerService.save(secondOwner);

        System.out.println("---Loaded Owners---");

        Vet firstVet = new Vet();
        firstVet.setFirstName("luci");
        firstVet.setLastName("smith");

        vetService.save(firstVet);

        Vet secondVet = new Vet();
        secondVet.setFirstName("mircea");
        secondVet.setLastName("doe");

        vetService.save(secondVet);

        System.out.println("---Loaded Vets---");
    }
}
