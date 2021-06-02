package lesson5.Dz;

public class Employee {

    protected String fullName;
    protected int age;
    protected String position;
    protected String email;
    protected String telNumber;
    protected double salary;

    public Employee(String fullName, int age, String position, String email, String telNumber, double salary) {
        this.fullName = fullName;
        this.age = age;
        this.position = position;
        this.email = email;
        this.telNumber = telNumber;
        this.salary = salary;
    }

    public Employee(String fullName, int age) {
        this(fullName, age, "Претендент", "не указан", "не указан", 0);
    }

    protected void getInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return fullName + ", " + age + " лет, занимает должность " + position + " c размером оплаты: " + salary + " руб, телефон: " + telNumber + ", email: " + email;
    }

}
