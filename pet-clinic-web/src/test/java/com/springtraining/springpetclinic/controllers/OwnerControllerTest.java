package com.springtraining.springpetclinic.controllers;

import com.springtraining.springpetclinic.model.Owner;
import com.springtraining.springpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController controller;

    Set<Owner> owners;

    MockMvc mockMvc;
    @BeforeEach
    void setUp(){
        owners = new HashSet<>();
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        owners.add(owner1);
        owners.add(owner2);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    }

    @Test
    void listOwners() throws Exception{
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get("/")).andExpect(status().is(200));
    }

    @Test
    void findOwners() {
    }
}