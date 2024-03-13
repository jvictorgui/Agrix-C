package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CropDto;
import com.betrybe.agrix.controller.dto.FertilizerDto;
import com.betrybe.agrix.model.entities.Crops;
import com.betrybe.agrix.model.entities.Farm;
import com.betrybe.agrix.service.CropService;
import com.betrybe.agrix.service.FarmService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Crops controller.
 */
@RestController
@RequestMapping("/crops")
public class CropsController {

  FarmService farmService;
  CropService cropService;

  /**
   * Instantiates a new Crops controller.
   *
   * @param farmService the farm service
   * @param cropService the crop service
   */
  @Autowired
  public CropsController(FarmService farmService, CropService cropService) {
    this.farmService = farmService;
    this.cropService = cropService;
  }

  /**
   * Gets all crops.
   *
   * @return the all crops
   */
  @GetMapping()
  @Secured({"ROLE_ADMIN", "ROLE_MANAGER"})
  public List<CropDto> getAllCrops() {

    List<Crops> allCrops = cropService.getAllCrops();
    return allCrops.stream().map(CropDto::fromEntity).toList();
  }

  @GetMapping("/{id}")
  public ResponseEntity<CropDto> getCropById(@PathVariable Long id) {
    Crops crop = cropService.getCropById(id);
    return ResponseEntity.status(HttpStatus.OK).body(CropDto.fromEntity(crop));
  }

  /**
   * Gets crops by date between.
   *
   * @param start the start
   * @param end   the end
   * @return the crops by date between
   */
  @GetMapping("/search")
  public ResponseEntity<List<CropDto>> getCropsByDateBetween(LocalDate start, LocalDate end) {
    List<Crops> crops = cropService.getCropsByDateBetween(start, end);
    List<CropDto> cropDtos = crops.stream().map(CropDto::fromEntity).collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(cropDtos);
  }

  /**
   * Add fertilizer to crop response entity.
   *
   * @param id           the id
   * @param fertilizerId the fertilizer id
   * @return the response entity
   */
  @PostMapping("/{id}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> addFertilizerToCrop(@PathVariable Long id,
      @PathVariable Long fertilizerId) {
    cropService.associateFertilizer(id, fertilizerId);
    String message = "Fertilizante e plantação associados com sucesso!";
    return ResponseEntity.status(HttpStatus.CREATED).body(message);

  }

  @GetMapping("/{id}/fertilizers")
  public ResponseEntity<List<FertilizerDto>> getFertilizersByCrop(@PathVariable Long id) {
    List<FertilizerDto> fertilizers = cropService.getFertilizersByCropId(id);
    return ResponseEntity.status(HttpStatus.OK).body(fertilizers);
  }
}
