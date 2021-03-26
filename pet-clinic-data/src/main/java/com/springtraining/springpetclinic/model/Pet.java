package com.springtraining.springpetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name="type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate birthday;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")
    private Set<Visit> visists = new HashSet<>( );

    public Pet() {
    }

    public String getName() {
        return this.name;
    }

    public PetType getPetType() {
        return this.petType;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public Set<Visit> getVisists() {
        return this.visists;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setVisists(Set<Visit> visists) {
        this.visists = visists;
    }

    public String toString() {
        return "Pet(name=" + this.getName() + ", petType=" + this.getPetType() + ", owner=" + this.getOwner() + ", birthday=" + this.getBirthday() + ", visists=" + this.getVisists() + ")";
    }
}
