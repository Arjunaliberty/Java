package javaClass;

import java.io.Serializable;

public class Worker implements Serializable {

    private int id;
    private String name;
    private String surName;
    private int age;
    private String departments;
    private double salary;
    private double premium;

    /**
     * Конструктор
     * @param id Регистрационный номер
     * @param name Имя
     * @param surName Фамилиф
     * @param age Возраст
     * @param departments Отдел
     * @param salary Жалование
     * @param premium Премия
     */
    public Worker(int id, String name, String surName, int age, String departments, double salary, double premium){
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.departments = departments;
        this.salary = salary;
        this.premium = premium;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", departments='" + departments + '\'' +
                ", salary=" + salary +
                ", premium=" + premium +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;

        if (id != worker.id) return false;
        if (age != worker.age) return false;
        if (Double.compare(worker.salary, salary) != 0) return false;
        if (Double.compare(worker.premium, premium) != 0) return false;
        if (name != null ? !name.equals(worker.name) : worker.name != null) return false;
        if (surName != null ? !surName.equals(worker.surName) : worker.surName != null) return false;
        return departments != null ? departments.equals(worker.departments) : worker.departments == null;
    }
}
