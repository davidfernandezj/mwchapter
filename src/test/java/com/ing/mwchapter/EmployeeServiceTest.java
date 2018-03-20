package com.ing.mwchapter;

import com.ing.mwchapter.domain.Employee;
import com.ing.mwchapter.domain.Gender;
import com.ing.mwchapter.domain.Seniority;
import com.ing.mwchapter.repository.EmployeeRepository;
import com.ing.mwchapter.services.EmployeeServiceImpl;
import com.ing.mwchapter.services.IEmployeeService;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ing.mwchapter.repository.EmployeeRepository.*;

public class EmployeeServiceTest {

    private IEmployeeService employeeService = new EmployeeServiceImpl(new EmployeeRepository());


    @Test
    public void testGetListOfEmployeeNames() {
        //Given

        //When
        List<String> listOfEmployeeNames = employeeService.getListOfEmployeeNames();

        //Then
        Assert.assertEquals(listOfEmployeeNames, Arrays.asList(
                "Mario", "Juan", "Elena", "Sofia", "Nuria", "Pedro", "Carlos"));

    }

    @Test
    public void testGetListOfEmployeeFullNames() {
        //Given

        //When
        List<String> listOfEmployeeNames = employeeService.getListOfEmployeeFullNames();

        //Then
        Assert.assertEquals(listOfEmployeeNames, Arrays.asList(
                "Mario Jimenez", "Juan Gomez", "Elena Perez", "Sofia Mateos", "Nuria Toledano", "Pedro Fernandez", "Carlos Gomez"));
    }

    @Test
    public void testGetEmployeesWithSeniority_Junior() {
        //Given
        Seniority seniority = Seniority.JUNIOR;
        //When
        List<Employee> employees = employeeService.getEmployeesWithSeniority(seniority);
        //Then
        Assert.assertEquals(employees, Arrays.asList(MARIO, CARLOS));
    }

    @Test
    public void testGetEmployeesWithSeniority_Middle() {
        //Given
        Seniority seniority = Seniority.MIDDLE;
        //When
        List<Employee> employees = employeeService.getEmployeesWithSeniority(seniority);
        //Then
        Assert.assertEquals(employees, Arrays.asList(JUAN, NURIA, PEDRO));
    }

    @Test
    public void testGetEmployeesWithSeniority_Senior() {
        //Given
        Seniority seniority = Seniority.SENIOR;
        //When
        List<Employee> employees = employeeService.getEmployeesWithSeniority(seniority);
        //Then
        Assert.assertEquals(employees, Arrays.asList(ELENA, SOFIA));
    }

    @Test
    public void testGetEmployeesByGender() {
        //Given
        Map<Gender, List<Employee>> expectedResult = new HashMap<>();
        expectedResult.put(Gender.FEMALE, Arrays.asList(ELENA, SOFIA, NURIA));
        expectedResult.put(Gender.MALE, Arrays.asList(MARIO, JUAN, PEDRO, CARLOS));
        //When
        Map<Gender, List<Employee>> employeesByGender = employeeService.getEmployeesByGender();
        //Then
        Assert.assertEquals(employeesByGender, expectedResult);
    }


}
