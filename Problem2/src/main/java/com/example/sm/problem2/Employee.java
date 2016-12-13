package com.example.sm.problem2;


//public class Employee /* extends something1 implements something2 */ {
public class Employee extends Person implements Payment{

    private int salary;

    public Employee(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public void increase() {
        salary+=10000;
    }

    @Override
    public void decrease() {
        if(salary<0)
            salary=0;
        else
            salary-=10000;
    }

    // need something here
}
