package com.betrybe.agrix.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Crop not found exception.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CropNotFoundException extends RuntimeException {

  /**
   * Instantiates a new Crop not found exception.
   */
  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }

}
