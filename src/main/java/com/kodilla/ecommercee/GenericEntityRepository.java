package com.kodilla.ecommercee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenericEntityRepository extends JpaRepository<GenericEntity, Long> {

    Optional<GenericEntity> findById(Long id);

    GenericEntity save(GenericEntity genericEntity);

    void deleteById(Long id);
}
