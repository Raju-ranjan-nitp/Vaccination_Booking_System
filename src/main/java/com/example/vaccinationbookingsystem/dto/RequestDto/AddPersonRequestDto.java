package com.example.vaccinationbookingsystem.dto.RequestDto;

import com.example.vaccinationbookingsystem.Enum.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class AddPersonRequestDto {
    String name;
    int age;
    //@Column(unique = true, nullable = false) // email can't be duplicate and can't be null
    String emailId;
   // @Enumerated(EnumType.STRING) //no need to write in dto
    Gender gender;
}
