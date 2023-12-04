package repositories;

import entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepositoryInterface {
    public List<Employee> getAllEmployees();
    public Optional<Employee> getEmployeeById(long id);
    public Optional<Employee> getEmployeeByEmail(String email);
    public boolean save(Employee e);
    public Employee update(Employee e);
    public boolean remove(Employee e);
}
