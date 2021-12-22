package com.paatamikeladze.spring.rest;

import com.paatamikeladze.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/*Именно с помощью объекта и его методов мы будем
* общаться с REST сервисом, получать запросы и ответы*/
@Component
//всех работников
public class Communication {
    @Autowired
    private RestTemplate restTemplate;
    /*Создаем константу URL */
    private final String URL = "http://localhost:8080/api/employees/";
    /*Будет посылать HTTP запрос и от нашего сервиса список всех сотрудников*/
    public List<Employee> showAllEmployees(){
        //ответ на наш http запрос
        //(адресс, метод, тело, и дженерик типа передать)
        //ParameterizedTypeReference - цель передача дженерик типа
        ResponseEntity<List<Employee>> responseEntity=
                restTemplate.exchange(URL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Employee>>() {
                        });
        List<Employee> allEmployees=responseEntity.getBody();
            //возвращаем список работников

        return allEmployees;
    }
    /*конкретного работника по id*/
    public  Employee getEmployee(int id){
        //getForObject(url+id,и кого хотим получить)
        Employee employee = restTemplate.getForObject(URL+"/"+id, Employee.class);
        return employee;
    }
    /*Сохраняем нового или апдейтим существующего, если id
    будет равен 0, тоо создание нового сотрудника, а если нет, то изменение
    существующего*/
    public void saveEmployee(Employee employee){
        int id = employee.getId();
        if(id==0){
            //указываем какого типа будет тело респонса <>
            //чтобы мы добавляем в тело метода POST
            ResponseEntity<String> responseEntity=
                    restTemplate.postForEntity(URL,employee,String.class);
            System.out.println("New employee added: " + responseEntity.getBody());
        }
        else {
            restTemplate.put(URL,employee);
            System.out.println("Employee with id: "+id+" was updated: " +
                    restTemplate.getForObject(URL+"/"+id, Employee.class) );
        }

    }
    /*Удаляеи сотрудника по его id  */
    public void deleteEmployee(int id){
        restTemplate.delete(URL+"/"+id);
        System.out.println("Employee with id: "+id+" was deleted ");

    }
}
