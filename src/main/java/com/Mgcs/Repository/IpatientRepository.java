package com.Mgcs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Mgcs.Entity.Patient;

public interface IpatientRepository extends JpaRepository<Patient, Long> {

}
