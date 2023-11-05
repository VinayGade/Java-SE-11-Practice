package beans;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String departmentName;
    private List<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        employees = new ArrayList<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployees(Employee employee) {
        employees.add(employee);
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", employees=" + employees +
                '}';
    }
}
