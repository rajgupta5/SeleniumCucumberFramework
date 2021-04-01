package model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class EmployeeModel {

    public String Name;
    public String Salary;
    public String DurationWorked;
    public String Grade;
    public String Email;

    public static EmployeeModel createEmployeeModel(Map<String, String> entry) {
        EmployeeModel employeeModel = new EmployeeModel();

        employeeModel.setDurationWorked(entry.get("DurationWorked"));
        employeeModel.setEmail(entry.get("Email"));
        employeeModel.setGrade(entry.get("Grade"));
        employeeModel.setSalary(entry.get("Salary"));
        employeeModel.setName(entry.get("Name"));

        return employeeModel;
    }


}
