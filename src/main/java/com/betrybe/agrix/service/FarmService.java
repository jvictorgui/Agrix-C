package com.betrybe.agrix.service;


import com.betrybe.agrix.controller.exception.FarmNotFoundException;
import com.betrybe.agrix.model.entities.Crops;
import com.betrybe.agrix.model.entities.Farm;
import com.betrybe.agrix.model.repository.FarmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Farm service.
 */
@Service
public class FarmService {

  private final FarmRepository farmRepository;
  private final CropService cropsService;

  @Autowired
  public FarmService(FarmRepository farmRepository, CropService cropsService) {
    this.farmRepository = farmRepository;
    this.cropsService = cropsService;
  }

  public Farm createFarm(Farm farm) {
    return farmRepository.save(farm);
  }

  public List<Farm> getAllFarms() {
    return farmRepository.findAll();
  }

  public Farm getFarmById(Long id) {
    return farmRepository.findById(id).orElseThrow(FarmNotFoundException::new);
  }

  public List<Crops> getFarmCrops(Long id) {
    Farm farm = farmRepository.findById(id).orElseThrow(FarmNotFoundException::new);
    return farm.getCrops();
  }


}
