package com.springtraining.springpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person{
    @ManyToMany()
    @JoinTable(name="vets_specialties",joinColumns = @JoinColumn(name ="vet_id"), inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialties = new HashSet<>( );

    public Vet() {
    }

    public Set<Specialty> getSpecialties() {
        return this.specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    public String toString() {
        return "Vet(specialties=" + this.getSpecialties() + ")";
    }
}
