package com.ing.mwchapter.repository;

import com.ing.mwchapter.domain.Employee;
import com.ing.mwchapter.domain.PersonId;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.ing.mwchapter.domain.Gender.*;
import static com.ing.mwchapter.domain.Seniority.*;

@Component
public class EmployeeRepository {

    private static AtomicInteger COUNTER = new AtomicInteger(1);

    public static final Employee MARIO = new Employee(generatePersonId(), "Mario", "Jimenez", 20, MALE, 18200.0, JUNIOR);
    public static final Employee JUAN = new Employee(generatePersonId(), "Juan", "Gomez", 30, MALE, 2500.0, MIDDLE);
    public static final Employee ELENA = new Employee(generatePersonId(), "Elena", "Perez", 60, FEMALE, 100000.0, SENIOR);
    public static final Employee SOFIA = new Employee(generatePersonId(), "Sofia", "Mateos", 55, FEMALE, 44200.0, SENIOR);
    public static final Employee NURIA = new Employee(generatePersonId(), "Nuria", "Toledano", 45, FEMALE, 41200.0, MIDDLE);
    public static final Employee PEDRO = new Employee(generatePersonId(), "Pedro", "Fernandez", 39, MALE, 35200.0, MIDDLE);
    public static final Employee CARLOS = new Employee(generatePersonId(), "Carlos", "Gomez", 18, MALE, 9900.0, JUNIOR);

    private static final List<Employee> EMPLOYEES = Arrays.asList(
            MARIO, JUAN, ELENA, SOFIA, NURIA, PEDRO, CARLOS
    );

    public List<Employee> getAllEmployees() {
        return EMPLOYEES;
    }

    private static PersonId generatePersonId() {
        return new PersonId(String.valueOf(COUNTER.getAndIncrement()));
    }
}
