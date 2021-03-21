package com.springtraining.springpetclinic.bootstrap;

import com.springtraining.springpetclinic.model.Owner;
import com.springtraining.springpetclinic.model.Vet;
import com.springtraining.springpetclinic.services.OwnerService;
import com.springtraining.springpetclinic.services.VetService;
import com.springtraining.springpetclinic.services.map.OwnerServiceMap;
import com.springtraining.springpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {

        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner firstOwner = new Owner();
        firstOwner.setId(1L);
        firstOwner.setFirstName("cristi");
        firstOwner.setLastName("grec");

        ownerService.save(firstOwner);

        Owner secondOwner = new Owner();
        secondOwner.setId(2L);
        secondOwner.setFirstName("ovidiu");
        secondOwner.setLastName("grecu");

        ownerService.save(secondOwner);

        System.out.println("---Loaded Owners---");

        Vet firstVet = new Vet();
        firstVet.setId(1L);
        firstVet.setFirstName("luci");
        firstVet.setLastName("smith");

        vetService.save(firstVet);

        Vet secondVet = new Vet();
        secondVet.setId(1L);
        secondVet.setFirstName("mircea");
        secondVet.setLastName("doe");

        vetService.save(secondVet);

        System.out.println("---Loaded Vets---");
    }
}
