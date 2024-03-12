package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.entities.Crops;
import java.time.LocalDate;

/**
 * The type Crop dto.
 */
public record CropDto(Long id, String name, double plantedArea, Long farmId, LocalDate plantedDate,
                      LocalDate harvestDate) {

  /**
   * From entity crop dto.
   *
   * @param crop the crop
   * @return the crop dto
   */
  public static CropDto fromEntity(Crops crop) {
    return new CropDto(
        crop.getId(),
        crop.getName(),
        crop.getPlantedArea(),
        crop.getFarm().getId(),
        crop.getPlantedDate(),
        crop.getHarvestDate()
    );

  }

  /**
   * To entity crops.
   *
   * @return the crops
   */
  public Crops toEntity() {
    Crops crop = new Crops();
    crop.setName(name);
    crop.setPlantedArea(plantedArea);
    crop.setPlantedDate(plantedDate);
    crop.setHarvestDate(harvestDate);
    return crop;
  }
}
