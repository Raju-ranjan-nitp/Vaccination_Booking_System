package com.example.vaccinationbookingsystem.service;

import com.example.vaccinationbookingsystem.Model.Person;
import com.example.vaccinationbookingsystem.dto.RequestDto.AddPersonRequestDto;
import com.example.vaccinationbookingsystem.dto.ResponseDto.AddPersonResponseDto;
import com.example.vaccinationbookingsystem.exception.PersonNotFoundException;
import com.example.vaccinationbookingsystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PersonService {
    @Autowired
    PersonRepository personRepository;
    public AddPersonResponseDto addPerson(AddPersonRequestDto addPersonRequestDto) {
//        person.setDose1Taken(false);
//        person.setDose2Taken(false);
//        person.setCertificate(null);


        //convert RequestDto -> Entity
        Person person = new Person();
        person.setName(addPersonRequestDto.getName());
        person.setAge(addPersonRequestDto.getAge());
        person.setEmailId(addPersonRequestDto.getEmailId());
        person.setGender(addPersonRequestDto.getGender());
        person.setDose1Taken(false);
        person.setDose2Taken(false);
        person.setCertificate(null);

       Person savedPerson =  personRepository.save(person);

     // return savedPerson;
        //convert entity -> responseDto
        AddPersonResponseDto addPersonResponseDto = new AddPersonResponseDto();
        addPersonResponseDto.setName(savedPerson.getName());
        addPersonResponseDto.setMessage("Congrats! you have been registered");
        return addPersonResponseDto;


    }
    public String updateEmail(String oldEmail, String newEmail){
        Person person = personRepository.findByEmail(oldEmail);
        if(person == null){
            throw new PersonNotFoundException("Sorry email doesn't exist");
        }
        person.setEmailId(newEmail);
        personRepository.save(person);
        return "Congrats! youe email has been updated successfully";
    }




}
