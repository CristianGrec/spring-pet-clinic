package com.springtraining.springpetclinic.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "vets")
public class Vet extends Person{
    @ManyToMany()
    @JoinTable(name="vets_specialties",joinColumns = @JoinColumn(name ="vet_id"), inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialties = new HashSet<>( );

}
