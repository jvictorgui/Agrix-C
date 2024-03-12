package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.entities.Farm;

/**
 * The type Farm response dto.
 */
public record FarmDto(Long id, String name, double size) {

  /**
   * Creates a new FarmDto instance from a Farm entity.
   *
   * @param farm the Farm entity to convert
   * @return a new FarmDto instance
   */
  public static FarmDto fromEntity(Farm farm) {
    return new FarmDto(farm.getId(), farm.getName(), farm.getSize());
  }

  /**
   * To entity farm.
   * Returns a new Farm
   *
   * @return the farm
   *
   */
  public Farm toEntity() {
    Farm farm = new Farm();
    farm.setName(name);
    farm.setSize(size);
    return farm;
  }
}

