package ewidencja.activity;

import ewidencja.employee.Employee;

public interface iPresence {
    void create_presence(Employee employee);
    void create_subordinate_presence(Employee employee);
}
