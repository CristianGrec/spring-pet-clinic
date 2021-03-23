package com.springtraining.springpetclinic.bootstrap;

import com.springtraining.springpetclinic.model.*;
import com.springtraining.springpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService,
                      SpecialtiesService specialtiesService,VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
int count = petTypeService.findAll().size();

if(count ==0){
        loadData();}
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType dogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType catPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtiesService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtiesService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        Specialty savedDentistry = specialtiesService.save(dentistry);


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
Visit visit = new Visit();
visit.setPet(firstPet);
visit.setDate(LocalDate.now());
visit.setDescription("dogvisit");
visitService.save(visit);
        Vet firstVet = new Vet();
        firstVet.setFirstName("luci");
        firstVet.setLastName("smith");
        firstVet.getSpecialties().add(savedDentistry);
        vetService.save(firstVet);

        Vet secondVet = new Vet();
        secondVet.setFirstName("mircea");
        secondVet.setLastName("doe");
        secondVet.getSpecialties().add(savedRadiology);
        vetService.save(secondVet);

        System.out.println("---Loaded Vets---");
    }
}
