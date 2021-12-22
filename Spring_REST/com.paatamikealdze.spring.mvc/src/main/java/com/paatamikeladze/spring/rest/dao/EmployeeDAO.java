package com.paatamikeladze.spring.rest.dao;

import com.paatamikeladze.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
//здесь будет 1 метод, return type будет
    //список сотрудников
    public List<Employee> getAllEmployees();
//добавляем этот метод в DAO
    public void saveEmployee(Employee employee);
//
    public Employee getEmployee(int id);

   public void deleteEmployee(int id);
}