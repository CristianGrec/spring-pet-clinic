package com.springtraining.springpetclinic.services.springdatajpa;

import com.springtraining.springpetclinic.model.Visit;
import com.springtraining.springpetclinic.repositories.VisitRepository;
import com.springtraining.springpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {
    private final VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visists = new HashSet<>();
        visitRepository.findAll().forEach(visists ::add);

        return visists;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
visitRepository.deleteById(aLong);
    }
}
