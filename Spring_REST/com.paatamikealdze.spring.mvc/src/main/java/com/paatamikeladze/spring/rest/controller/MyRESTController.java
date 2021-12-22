package com.paatamikeladze.spring.rest.controller;

import com.paatamikeladze.spring.rest.entity.Employee;
import com.paatamikeladze.spring.rest.exception_handling.EmployeeIncorrectData;
import com.paatamikeladze.spring.rest.exception_handling.NoSuchEmployeeException;
import com.paatamikeladze.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;
    //метод будет возвращать список всех работников
    @GetMapping("/employees")
    public List<Employee> showAllEmployees (){
        List<Employee> allEmployees= employeeService.getAllEmployees();
        return allEmployees;
        /*Спринг с помощью Джаксон, конвертирует список сотрудников в json формат*/
    }
/*Получение одного работника */
    //{id} - pathVariable
    //@PathVariable int id
    //с помощью id, которое мы получаем из URL
    //мы может найти соответвующий id в бд
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if (employee==null){
            throw new NoSuchEmployeeException(
                    "There is no employee with ID= "+id+
                            "in Database"
            );
        }
        return employee;
    }
    @PostMapping("/employees")
    public  Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return "Employee with id: "+id+" deleted";

    }


}
