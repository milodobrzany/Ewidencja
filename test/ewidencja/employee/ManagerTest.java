package ewidencja.employee;

import ewidencja.LoginScreen;
import ewidencja.employee.Manager;
import org.junit.Test;

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
    public void process_leave_requestTrue() { //mock - pracownik + raport + absencja(?)
        // give
        int input = 1;
        // when

        // then
    }

    @Test
    public void process_leave_requestFalse() { //mock - pracownik + raport + absencja(?)
        // give
        int input = 0;
        // when

        // then
    }
}