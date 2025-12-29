package com.example.FirstApp.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddStudentRequestDto {
   @Size(min= 3,max=20,message = "Must be greater then 3 char")
   private String name;
   @Email
   @NotBlank(message = "The message should not be blank")
   private String email;
}
