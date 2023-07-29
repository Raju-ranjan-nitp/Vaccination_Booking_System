package com.example.vaccinationbookingsystem.repository;

import com.example.vaccinationbookingsystem.Model.VaccinationCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer> {

}
