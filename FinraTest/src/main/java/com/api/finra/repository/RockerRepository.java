package com.api.finra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.finra.model.Rockers;
@Repository
public interface RockerRepository extends JpaRepository<Rockers, Long> {

}
