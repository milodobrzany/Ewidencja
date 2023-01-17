package ewidencja.activity;

import ewidencja.employee.Employee;
import ewidencja.entry.Report;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AbsenceTest {

    @Test
    public void left_vacation_daysCorrect() {  //poprawna ilość dni urlopowych (< 26)
        // give
        Absence absence = new Leave();
        String start = "2023-03-01";
        String end = "2023-03-12";

        // when
        long result = absence.left_vacation_days(start, end);

        // then
        assertEquals(11, result);
    }

    @Test
    public void left_vacation_daysWrong() {  //niepoprawna ilość dni urlopowych (różny rok)
        // give
        Absence absence = new Leave();
        String start = "2023-03-01";
        String end = "2024-03-01";

        // when
        long result = absence.left_vacation_days(start, end);

        // then
        assertEquals(366, result);
    }

    @Test
    public void create_absence() {  //sprawdzamy dodawanie stworzonej obecności do raportu
        // give
        Employee employee = Mockito.mock(Employee.class);
        employee.setName("absence");
        employee.setSurname("test");
        Absence absence = new Leave();
        Report report = new Report();

        // when
        Mockito.when(employee.getReport()).thenReturn(report);
        absence.create_absence(employee);
        Absence result = report.choose_absence(1);

        // then
        assertNotNull(result);
    }
}