package ewidencja.employee;

import ewidencja.LoginScreen;
import ewidencja.activity.Absence;
import ewidencja.activity.Leave;
import ewidencja.employee.Manager;
import ewidencja.entry.Report;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ManagerTest {

    @Test
    public void choose_employeeCorrect() {
        // give
        Manager manager = new Manager();
        String name = "Lena";
        String surname = "Kuźma";

        // when
        Employee result = manager.choose_employee(name, surname);
        String[] expected = new String[] { "Lena", "Kuźma" };
        String[] received = new String[] { result.getName(), result.getSurname() };

        // then
        assertArrayEquals(expected, received);
    }

    @Test
    public void choose_employeeWrong() {
        // give
        Manager manager = new Manager();
        String name = "Lena";
        String surname = "Kuzma";

        // when
        Employee result = manager.choose_employee(name, surname);

        // then
        assertNull(result);
    }

    @Test
    public void process_leave_requestTrue() {  // zapis do objectIO zwraca błędy, ale tu testujemy coś innego
        // give
        Manager manager = new Manager();
        String input = "1";
        int number = 1;
        Employee employee = Mockito.mock(Employee.class);
        Report report = new Report();
        Absence absence = new Leave();
        report.add_absence(absence);

        // when
        Mockito.when(employee.getReport()).thenReturn(report);
        manager.process_leave_request(employee, number, input);
        boolean isConfirmed = absence.getIsConfirmed();

        // then
        assertTrue(isConfirmed);
    }

    @Test
    public void process_leave_requestFalse() { //można dodać kolejny test: sprawdzanie usuwania dla więcej niż jednej absencji
        // give
        Manager manager = new Manager();
        String input = "0";
        int number = 1;
        Employee employee = Mockito.mock(Employee.class);
        Report report = new Report();
        Absence absence = new Leave();
        report.add_absence(absence);

        // when
        Mockito.when(employee.getReport()).thenReturn(report);
        manager.process_leave_request(employee, number, input);
        Absence result = report.choose_absence(1);

        // then
        assertNull(result);
    }
}