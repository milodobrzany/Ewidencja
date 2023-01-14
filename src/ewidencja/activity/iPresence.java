package ewidencja.activity;

import ewidencja.employee.Employee;

public interface iPresence {
    void create_presence(Employee employee);
    void update_presence();
    void create_subordinate_presence();
}
