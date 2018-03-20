package com.ing.mwchapter.services;

import com.ing.mwchapter.domain.Employee;
import com.ing.mwchapter.domain.Gender;
import com.ing.mwchapter.domain.Seniority;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IEmployeeService {

    List<String> getListOfEmployeeNames();

    List<String> getListOfEmployeeFullNames();

    List<Employee> getEmployeesWithSeniority(Seniority seniority);

    Map<Gender, List<Employee>> getEmployeesByGender();

    Double getAverageSalary();

    Map<Seniority, Double> getAverageSalaryBySeniority();

    Optional<Employee> getEmployee(String name, String surname);

}
