package com.ing.mwchapter;

import com.ing.mwchapter.domain.Employee;
import com.ing.mwchapter.domain.Gender;
import com.ing.mwchapter.domain.Seniority;
import com.ing.mwchapter.repository.EmployeeRepository;
import com.ing.mwchapter.services.EmployeeServiceImpl;
import com.ing.mwchapter.services.IEmployeeService;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

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

    @Test
    public void testGetAverageSalary() {
        //Given

        //When
        Double averageSalary = employeeService.getAverageSalary();
        //Then
        Assert.assertEquals((Double) 35885.71428571428, averageSalary);
    }

    @Test
    public void testGetAverageSalaryBySeniority() {
        //Given
        Map<Seniority, Double> expectedResult = new HashMap<>();
        expectedResult.put(Seniority.JUNIOR, 14050.0);
        expectedResult.put(Seniority.MIDDLE, 26300.0);
        expectedResult.put(Seniority.SENIOR, 72100.0);
        //When
        Map<Seniority, Double> averageSalaryBySeniority = employeeService.getAverageSalaryBySeniority();
        //Then
        Assert.assertEquals(expectedResult, averageSalaryBySeniority);
    }

    @Test
    public void testEmployee_ok() {
        //Given

        //When
        Optional<Employee> employee = employeeService.getEmployee("Juan", "Gomez");
        //Then
        Assert.assertTrue(employee.isPresent());
        Employee juanGomez = employee.get();
        Assert.assertEquals(juanGomez, JUAN);
    }

    @Test
    public void testEmployee_error() {
        //Given

        //When
        Optional<Employee> employee = employeeService.getEmployee("Juan", "Fernandez");
        //Then
        Assert.assertFalse(employee.isPresent());

    }


    @Test
    public void testEmployeesSkills() {
        //Given

        //When
        Set<String> skills = employeeService.getSkills();

        //Then
        Assert.assertThat(skills, Matchers.hasSize(7));
        Assert.assertThat(skills, Matchers.containsInAnyOrder("Java", "Javascript", "TDD", "Spring", "F2E", "Polymer", "Cassandra"));
    }
}
