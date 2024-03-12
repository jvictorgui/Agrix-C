package com.betrybe.agrix.service;


import com.betrybe.agrix.controller.dto.FarmDto;
import com.betrybe.agrix.controller.dto.FertilizerDto;
import com.betrybe.agrix.controller.exception.CropNotFoundException;
import com.betrybe.agrix.controller.exception.FarmNotFoundException;
import com.betrybe.agrix.controller.exception.FertilizerNotFoundException;
import com.betrybe.agrix.model.entities.Crops;
import com.betrybe.agrix.model.entities.Farm;
import com.betrybe.agrix.model.entities.Fertilizer;
import com.betrybe.agrix.model.repository.CropRepository;
import com.betrybe.agrix.model.repository.FarmRepository;
import com.betrybe.agrix.model.repository.FertilizerRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * The type Farm service.
 */
@Service
public class CropService {


  private final CropRepository cropsRepository;
  private final FertilizerRepository fertilizerRepository;


  @Autowired
  public CropService(CropRepository cropsRepository, FertilizerRepository fertilizerRepository) {
    this.cropsRepository = cropsRepository;
    this.fertilizerRepository = fertilizerRepository;
  }

  // Methods should operate on Crops instead of Farm
  public Crops createCrop(Crops crop) {

    return cropsRepository.save(crop);
  }

  public List<Crops> getAllCrops() {
    return cropsRepository.findAll();
  }

  public Crops getCropById(Long id) {
    return cropsRepository.findById(id).orElseThrow(CropNotFoundException::new);
  }

  public List<Crops> getCropsByDateBetween(LocalDate start, LocalDate end) {
    return cropsRepository.findByHarvestDateBetween(start, end);
  }

  /**
   * Associate fertilizer string.
   *
   * @param cropId       the crop id
   * @param fertilizerId the fertilizer id
   * @return the string
   */
  public String associateFertilizer(Long cropId, Long fertilizerId) {

    Crops crop = cropsRepository.findById(cropId).orElseThrow(CropNotFoundException::new);
    Fertilizer fertilizer = fertilizerRepository.findById(fertilizerId)
        .orElseThrow(FertilizerNotFoundException::new);
    crop.getFertilizers().add(fertilizer);
    cropsRepository.save(crop);
    return "Fertilizante e plantação associados com sucesso!";
  }

  public List<FertilizerDto> getFertilizersByCropId(Long cropId) {
    Crops crop = cropsRepository.findById(cropId).orElseThrow(CropNotFoundException::new);
    return crop.getFertilizers().stream().map(FertilizerDto::fromEntity).toList();
  }


}
