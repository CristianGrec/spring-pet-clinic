package com.springtraining.springpetclinic.services;

import com.springtraining.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String lastName);
}
