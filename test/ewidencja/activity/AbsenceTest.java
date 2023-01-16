package ewidencja.activity;

import ewidencja.employee.Employee;
import ewidencja.employee.Manager;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbsenceTest {

    @Test
    public void left_vacation_daysCorrect() {
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
    public void left_vacation_daysWrong() {
        // give
        Absence absence = new Leave();
        String start = "2023-03-01";
        String end = "2024-03-01";

        // when
        long result = absence.left_vacation_days(start, end);

        // then
        assertEquals(366, result);
    }
}