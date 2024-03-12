package com.betrybe.agrix.controller.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Farm not found exception.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FertilizerNotFoundException extends RuntimeException {

  /**
   * Instantiates a new Fertilizer not found exception.
   */
  public FertilizerNotFoundException() {
    super("Fertilizante não encontrado!");
  }
}
