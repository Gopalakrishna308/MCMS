package com.Mgcs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Mgcs.Entity.Doctor;

public interface IdoctorRepository extends JpaRepository<Doctor,Long > {

}
