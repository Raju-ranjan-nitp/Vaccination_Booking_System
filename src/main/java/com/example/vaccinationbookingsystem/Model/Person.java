package com.example.vaccinationbookingsystem.Model;

import com.example.vaccinationbookingsystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public
class Person {
    @Id
            @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String name;
    int age;
    @Column(unique = true, nullable = false) // email can't be duplicate and can't be null
    String emailId;
    @Enumerated(EnumType.STRING) //to tell data base store my enum as string because data base doesn't understand enum
    Gender gender;

    boolean Dose1Taken;
    boolean Dose2Taken;
    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    List<Dose> dosesTaken = new ArrayList<>();

    @OneToOne(mappedBy = "persom",cascade = CascadeType.ALL)
    Certificate certificate;

    @OneToMany(mappedBy ="person", cascade = CascadeType.ALL)
    List<Appointment>appointments = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    Doctor doctor;

}
