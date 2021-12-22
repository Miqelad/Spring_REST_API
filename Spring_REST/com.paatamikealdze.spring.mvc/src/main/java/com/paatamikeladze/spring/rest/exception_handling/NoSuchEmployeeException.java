package com.paatamikeladze.spring.rest.exception_handling;
/*Создадим исключение*/
public class NoSuchEmployeeException extends RuntimeException {
    //переопределим его конструктор, который выводить только сообщение
    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
