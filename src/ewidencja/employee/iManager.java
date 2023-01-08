package ewidencja.employee;

public interface iManager {
    void add_employee();
    void remove_employee();
    void set_personal_data();
    Employee choose_employee(String name, String surname);
}
