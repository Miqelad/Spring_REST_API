package com.paatamikeladze.spring.rest.exception_handling;
/*Будет отображать, что не так с HTTP запросом
* объект данного класса будет преобразовываться в JSON
* и выводиться на экран*/
public class EmployeeIncorrectData {
    private String info;

    public EmployeeIncorrectData(){

    }
    public String getInfo(){
        return info;
    }
    public void setInfo(String info){
        this.info = info;
    }

}
