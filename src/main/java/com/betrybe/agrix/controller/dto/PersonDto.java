package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.security.Role;

/**
 * The type Person dto.
 */
public record PersonDto(Long id, String username, Role role) {

  /**
   * From entity person dto.
   *
   * @param person the person
   * @return the person dto
   */
  public static PersonDto fromEntity(com.betrybe.agrix.model.entities.Person person) {
    return new PersonDto(person.getId(), person.getUsername(), person.getRole());
  }

  /**
   * To entity com . betrybe . agrix . model . entities . person.
   *
   * @return the com . betrybe . agrix . model . entities . person
   */
  public com.betrybe.agrix.model.entities.Person toEntity() {
    com.betrybe.agrix.model.entities.Person person = new com.betrybe.agrix.model.entities.Person();
    person.setUsername(username);
    person.setRole(role);
    return person;
  }

}
