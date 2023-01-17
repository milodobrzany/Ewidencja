package ewidencja.employee;

import ewidencja.activity.Absence;
import ewidencja.activity.Leave;
import ewidencja.entry.Report;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ManagerTest {

    @Test
    public void choose_employeeCorrect() {  //wybranie istniejacego pracownika
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
    public void choose_employeeWrong() {  //wybranie nieistniejacego pracownika
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
    public void process_leave_requestTrue() {  //potwierdzenie wniosku
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
    public void process_leave_requestFalseOne() {  //sprawdzanie usuwania dla jednego wniosku
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

    @Test
    public void process_leave_requestFalseMany() {  //sprawdzanie usuwania dla więcej niż jednego wniosku
        // give
        Manager manager = new Manager();
        String input = "0";
        Employee employee = Mockito.mock(Employee.class);
        Report report = new Report();
        for (int i=0;i<3;i++) {
            Absence absence = new Leave();
            report.add_absence(absence);
        }

        // when
        Mockito.when(employee.getReport()).thenReturn(report);
        for (int i=1;i<4;i++) {
            manager.process_leave_request(employee, i, input);
        }

        // then
        assertEquals(0, report.getAbsences().size()); //report.absences
    }
}