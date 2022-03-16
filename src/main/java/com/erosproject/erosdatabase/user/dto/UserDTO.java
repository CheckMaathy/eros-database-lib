package com.erosproject.erosdatabase.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
  private String name;
  private String username;
  private String passcode;
  private Boolean isAdmin;
  private String email;
  private String cpf;
  private LocalDate createdAt;
  private LocalDate updatedAt;
}
