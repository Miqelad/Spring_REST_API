package com.paatamikeladze.spring.rest.service;
//бизнеслогика(типо :D)

import com.paatamikeladze.spring.rest.dao.EmployeeDAO;
import com.paatamikeladze.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    //зависимость от DAO
    @Autowired
    private EmployeeDAO employeeDAO;
    @Override
    @Transactional // убрали из дао  и поместим в сервис
    /*Транзакционность будет соблюдаться на уровне сервиса*/
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional// чтобы дакже не заморачиваться с транзакцией
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);

    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);

    }
}
