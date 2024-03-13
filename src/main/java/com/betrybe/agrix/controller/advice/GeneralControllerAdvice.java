package com.betrybe.agrix.controller.advice;


import com.betrybe.agrix.controller.exception.CropNotFoundException;
import com.betrybe.agrix.controller.exception.FarmNotFoundException;
import com.betrybe.agrix.controller.exception.FertilizerNotFoundException;
import com.betrybe.agrix.controller.exception.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type General controller advice.
 */
@ControllerAdvice
public class GeneralControllerAdvice {

  /**
   * Handle farm not found exception response entity.
   *
   * @param e the e
   * @return the response entity
   */
  @ExceptionHandler({
      FarmNotFoundException.class,
  })
  public ResponseEntity<String> handleFarmNotFoundException(FarmNotFoundException e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({
      CropNotFoundException.class,
  })
  public ResponseEntity<String> handleCropNotFoundException(CropNotFoundException e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({
      FertilizerNotFoundException.class,
  })
  public ResponseEntity<String> handleFertilizerNotFound(FertilizerNotFoundException e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({
      PersonNotFoundException.class,
  })
  public ResponseEntity<String> handlePersonNotFoundException(PersonNotFoundException e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
  }


}
