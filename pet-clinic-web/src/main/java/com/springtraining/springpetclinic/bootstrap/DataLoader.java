package com.springtraining.springpetclinic.bootstrap;

import com.springtraining.springpetclinic.model.Owner;
import com.springtraining.springpetclinic.model.Vet;
import com.springtraining.springpetclinic.services.OwnerService;
import com.springtraining.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService,VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner firstOwner = new Owner();
        firstOwner.setFirstName("cristi");
        firstOwner.setLastName("grec");

        ownerService.save(firstOwner);

        Owner secondOwner = new Owner();
        secondOwner.setFirstName("ovidiu");
        secondOwner.setLastName("johnson");

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
