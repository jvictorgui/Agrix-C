package com.betrybe.agrix.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Farm not found exception.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FarmNotFoundException extends RuntimeException {

  /**
   * Instantiates a new Farm not found exception.
   */
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}