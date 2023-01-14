package ewidencja.activity;

import ewidencja.employee.Employee;

public interface iAbsence {
    void create_absence(Employee employee);
    boolean process_subordinate_absence();
}
