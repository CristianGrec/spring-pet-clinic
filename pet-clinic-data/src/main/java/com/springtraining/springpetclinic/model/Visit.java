package com.springtraining.springpetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name= "visit")
public class Visit extends BaseEntity{
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Visit() {
    }

    public LocalDate getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.description;
    }

    public Pet getPet() {
        return this.pet;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String toString() {
        return "Visit(date=" + this.getDate() + ", description=" + this.getDescription() + ", pet=" + this.getPet() + ")";
    }
}
