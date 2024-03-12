package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CropDto;
import com.betrybe.agrix.controller.dto.FarmDto;
import com.betrybe.agrix.model.entities.Crops;
import com.betrybe.agrix.model.entities.Farm;
import com.betrybe.agrix.service.CropService;
import com.betrybe.agrix.service.FarmService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * The type Farm controller.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {


  /**
   * The Service.
   */
  FarmService farmService;
  /**
   * The Crops farmService.
   */
  CropService cropsService;

  /**
   * Instantiates a new Farm controller.
   *
   * @param farmService the farmService
   */
  @Autowired
  public FarmController(FarmService farmService, CropService cropsService) {
    this.farmService = farmService;
    this.cropsService = cropsService;

  }

  /**
   * Gets farms.
   *
   * @return the farms
   */
  @GetMapping()
  public List<FarmDto> getAllFarms() {
    List<Farm> farms = farmService.getAllFarms();
    return farms.stream().map(FarmDto::fromEntity).collect(Collectors.toList());
  }

  /**
   * Gets farm.
   *
   * @param id the id
   * @return the farm
   */
  @GetMapping("{id}")
  public ResponseEntity<FarmDto> getFarmById(@PathVariable Long id) {
    Farm farm = farmService.getFarmById(id);
    return ResponseEntity.status(HttpStatus.OK).body(FarmDto.fromEntity(farm));
  }

  /**
   * Create farm response entity.
   *
   * @param farmDto the farm dto
   * @return the response entity
   */
  @PostMapping()
  public ResponseEntity<Farm> createFarm(@RequestBody FarmDto farmDto) {
    return new ResponseEntity<>(farmService.createFarm(farmDto.toEntity()), HttpStatus.CREATED);
  }

  /**
   * Create crop response entity.
   *
   * @param farmId  the farm id
   * @param cropDto the crop dto
   * @return the response entity
   */
  @PostMapping("{farmId}/crops")
  public ResponseEntity<CropDto> createCrop(@PathVariable Long farmId,
      @RequestBody CropDto cropDto) {
    Farm getFarm = farmService.getFarmById(farmId);

    Crops crop = cropDto.toEntity();
    crop.setFarm(getFarm);

    Crops newCrop = cropsService.createCrop(crop);

    return ResponseEntity.status(HttpStatus.CREATED).body(CropDto.fromEntity(newCrop));
  }

  @GetMapping("{farmId}/crops")
  public ResponseEntity<List<CropDto>> getAllCrops(@PathVariable Long farmId) {
    return ResponseEntity.status(HttpStatus.OK).body(farmService.getFarmCrops(farmId).stream()
        .map(CropDto::fromEntity).collect(Collectors.toList()));
  }


}
