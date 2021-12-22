package com.paatamikeladze.spring.rest.service;

import com.paatamikeladze.spring.rest.entity.Employee;

import java.util.List;

    public interface EmployeeService{
        public List<Employee> getAllEmployees();
//добавляет метод для работы с новым сотрудником
        public void saveEmployee(Employee employee);
//метод возвращает работника и принимает в параметры int id
        public Employee getEmployee(int id);
        //метод удаляет сотрудника по id
        public void deleteEmployee(int id);
    }
