package com.betrybe.agrix.model.repository;

import com.betrybe.agrix.model.entities.Crops;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Crop repository.
 */
public interface CropRepository extends JpaRepository<Crops, Long> {

  List<Crops> findByHarvestDateBetween(LocalDate start, LocalDate end);

}
