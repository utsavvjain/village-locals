package com.village.locals.village_locals.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.village.locals.village_locals.beans.Locality;

public interface LocalityRepository  extends JpaRepository<Locality,Integer> {

}
