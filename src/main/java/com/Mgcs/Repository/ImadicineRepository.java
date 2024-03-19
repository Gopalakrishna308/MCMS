package com.Mgcs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Mgcs.Entity.Medicine;

public interface ImadicineRepository extends JpaRepository<Medicine,Long> {

}
