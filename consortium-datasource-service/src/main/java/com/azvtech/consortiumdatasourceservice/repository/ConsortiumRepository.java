package com.azvtech.consortiumdatasourceservice.repository;

import com.azvtech.consortiumdatasourceservice.model.Consortium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fellipe Toledo
 */
@Repository
public interface ConsortiumRepository extends JpaRepository<Consortium, Long> {
}
