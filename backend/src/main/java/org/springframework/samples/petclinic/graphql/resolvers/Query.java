/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.Lists;
import org.springframework.samples.petclinic.graphql.types.VisitConnection;
import org.springframework.samples.petclinic.model.*;
import org.springframework.samples.petclinic.repository.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Resolver for PetClinic Queries
 *
 * @author Nils Hartmann (nils@nilshartmann.net)
 */
@Component
@SuppressWarnings("unused")
public class Query implements GraphQLQueryResolver {

    private final PetTypeRepository petTypeRepository;
    private final VetRepository vetRepository;
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final SpecialtyRepository specialtyRepository;

    public Query(PetTypeRepository petTypeRepository, VetRepository vetRepository, OwnerRepository ownerRepository, PetRepository petRepository, SpecialtyRepository specialtyRepository) {
        this.petTypeRepository = petTypeRepository;
        this.vetRepository = vetRepository;
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.specialtyRepository = specialtyRepository;
    }

    public List<PetType> pettypes() {
        return Lists.newArrayList(petTypeRepository.findAll());
    }

    public List<Vet> vets() {
        return Lists.newArrayList(vetRepository.findAll());
    }

    public List<Owner> owners() {
        return Lists.newArrayList(ownerRepository.findAll());
    }

    public List<Owner> ownersByLastName(String lastName) {
        return Lists.newArrayList(ownerRepository.findByLastName(lastName));
    }

    public Owner owner(int id) {
        return ownerRepository.findById(id);
    }

    public Pet pet(int id) {
        return petRepository.findById(id);
    }

    public List<Pet> pets() {
        return Lists.newArrayList(petRepository.findAll());
    }

    public List<Specialty> specialties() {
        return Lists.newArrayList(specialtyRepository.findAll());
    }

    public VisitConnection getVisitConnection() {
        return new VisitConnection(null);
    }

}
