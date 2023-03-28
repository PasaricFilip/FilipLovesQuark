package org.acme.ride;


import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class RideRepository implements PanacheMongoRepository<Ride> {

    public Ride findByName(String name) {
        return find("name", name).firstResult();
    }

    public List<Ride> findOrderedName() {
        return listAll(Sort.by("name"));
    }
    
}
