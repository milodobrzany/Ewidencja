package ewidencja.activity;

import ewidencja.employee.Employee;
import ewidencja.entry.Report;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PresenceTest {

    @Test
    public void create_presenceFinished() {  //aktualizacja obecności
        // give
        Employee employee = Mockito.mock(Employee.class);
        Presence presence = new Presence();
        presence.set_presence(true);
        Report report = new Report();

        // when
        Mockito.when(employee.getReport()).thenReturn(report);
        presence.create_presence(employee);

        // then
        assertTrue(presence.getPresenceFinished());
    }

    @Test
    public void create_presenceUnfinished() {  //wprowadzenie nowej obecności
        // give
        Employee employee = Mockito.mock(Employee.class);
        Presence presence = new Presence();
        Report report = new Report();

        // when
        Mockito.when(employee.getReport()).thenReturn(report);
        presence.create_presence(employee);

        // then
        assertTrue(presence.getPresence());
        assertFalse(presence.getPresenceFinished());
    }
}