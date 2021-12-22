package com.paatamikeladze.spring.rest;

import com.paatamikeladze.spring.rest.configuration.MyConfig;
import com.paatamikeladze.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
        //всех работников
        List<Employee> allEmployees=communication.showAllEmployees();
        System.out.println(allEmployees);
        //одного работника
        Employee empById= communication.getEmployee(1);
        System.out.println(empById);
        //добавляем или изменяем
        /* Employee emp = new Employee("Pasha","Yakovlev","Hr",900);
        communication.saveEmployee(emp);*/
       /* Изменяекм сотрудника по id
       Employee emp = new Employee("Pasha","Yakovlev","IT",900);
        emp.setId(1);
       communication.saveEmployee(emp);*/
        //удаляем
        communication.deleteEmployee(4);




    }
}
