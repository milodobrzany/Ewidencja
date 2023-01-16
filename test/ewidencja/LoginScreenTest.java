package ewidencja;

import ewidencja.employee.Manager;
import ewidencja.employee.Employee;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginScreenTest {
    private Manager manager;

    @Test
    public void verifyCorrect() {
        // give
        manager = new Manager();
        LoginScreen login_screen = new LoginScreen("student", "Student123#");

        // when
        Employee result = login_screen.verify(manager);
        String[] expected = new String[] { "Michal", "Sikacki" };
        String[] received = new String[] { result.getName(), result.getSurname() };

        // then
        assertArrayEquals(expected, received);
    }

    @Test
    public void verifyWrong() {
        // give
        manager = new Manager();
        LoginScreen login_screen = new LoginScreen("student", "Student123");

        // when
        Employee result = login_screen.verify(manager);

        // then
        assertNull(result);
    }
}