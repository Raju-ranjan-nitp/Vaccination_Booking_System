package com.example.vaccinationbookingsystem.Model;

import com.example.vaccinationbookingsystem.Enum.DoseType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Dose {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
     String doseId;
     @Enumerated(value = EnumType.STRING)
     DoseType doseType;
     @CreationTimestamp
     Date vaccinationdoseDate;
     @ManyToOne
     @JoinColumn //introduce foreign key in child table
     Person person;

}
