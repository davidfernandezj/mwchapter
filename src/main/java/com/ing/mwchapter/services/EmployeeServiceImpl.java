package com.ing.mwchapter.services;

import com.ing.mwchapter.domain.Employee;
import com.ing.mwchapter.domain.Gender;
import com.ing.mwchapter.domain.Seniority;
import com.ing.mwchapter.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Component
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<String> getListOfEmployeeNames() {
        //TODO: Implement me
        return null;
    }

    @Override
    public List<String> getListOfEmployeeFullNames() {
        //TODO: Implement me
        return null;
    }

    @Override
    public List<Employee> getEmployeesWithSeniority(Seniority seniority) {
        //TODO: Implement me
        return null;
    }

    @Override
    public Map<Gender, List<Employee>> getEmployeesByGender() {
        //TODO: Implement me
        return null;
    }

    @Override
    public Double getAverageSalary() {
        //TODO: Implement me
        return null;
    }

    @Override
    public Map<Seniority, Double> getAverageSalaryBySeniority() {
        //TODO: Implement me
        return null;
    }

    @Override
    public Optional<Employee> getEmployee(String name, String surname) {
        //TODO: Implement me
        return null;
    }

    @Override
    public Set<String> getSkills() {
        //TODO: Implement me
        return null;
    }
}
