package io.github.krzysiekporwol.mushroomatlas.exception;

public class MushroomAlreadyExistsException extends RuntimeException {
  public MushroomAlreadyExistsException(String message, Throwable cause) {
    super(message, cause);
  }
}
