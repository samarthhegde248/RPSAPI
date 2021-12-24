package com.vocera.RPSAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vocera.RPSAPI.entity.RPAData;

@Repository
public interface RPARepository extends JpaRepository<RPAData, String> {

}
