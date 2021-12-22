package com.paatamikeladze.spring.rest.dao;
/*За связь в конечном итоге отвечает репозиторий!*/
import com.paatamikeladze.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
//Для того, чтобы DAO мог подключаться посредством Hibernate
//должен иметь доступ к SessionFactory

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired // внедряем зависимость
    /*Теперь при запуске приложения будут созданы бины из Application context
    * и будет внедрена зависимость от SessionFactory*/
    private SessionFactory sessionFactory;
    @Override
    //доверяем открытие и закрытие транзакции Spring
    public List<Employee> getAllEmployees() {
        Session session  = sessionFactory.getCurrentSession();
        //получаем список сотрудников
        List<Employee> allEmployees= session.createQuery("from Employee"
                ,Employee.class)
                .getResultList();
        return allEmployees;
    }
//тут прописывает логику добавления сотрудника в бд
    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        //если id!=0 давайте изменять сотрудника
        //saveOrUpdate работает по такой логике
        session.saveOrUpdate(employee);

    }
    //тут прописывает логику изменения сотрудника в бд
    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get( Employee.class,id);
        return employee;

    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> qurery= session.createQuery("delete from Employee " +
                "where id =:employeeId");
        //:employeeId - вместо этого пропишется
        //в нашем запросе, произайдет замена названия параметра на само
        //значение этого параметра setParameter
        qurery.setParameter("employeeId",id);
        qurery.executeUpdate();

    }
}
