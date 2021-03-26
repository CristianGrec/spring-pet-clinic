package com.springtraining.springpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "specialties")
public class Specialty extends BaseEntity{
    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "specialties")
    private Set<Vet> vets;

    public Specialty() {
    }

    public String getDescription() {
        return this.description;
    }

    public Set<Vet> getVets() {
        return this.vets;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVets(Set<Vet> vets) {
        this.vets = vets;
    }

    public String toString() {
        return "Specialty(description=" + this.getDescription() + ", vets=" + this.getVets() + ")";
    }
}
