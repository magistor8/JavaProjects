package lesson5.Dz;

public class Main {

    public static void main(String[] args) {

        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Петров Петр Петрович", 33, "Специалист", "email@email.ru", "+7555111444", 45000.00);
        employees[1] = new Employee("Иванов Иван Иванович", 46, "Инженер", "email1@email1.ru", "+755558844", 65010.00);
        employees[2] = new Employee("Селиванов Иван Иванович", 47, "Технолог", "email2@email2.ru", "+799558844", 25800.10);
        employees[3] = new Employee("Сидоров Петр Алексеевич", 22, "Рабочий", "email3@email3.ru", "+3545451125", 44400.20);
        employees[4] = new Employee("Богданов Леонид Ильич", 50);

        for (Employee employee : employees) {
            if (employee.age >= 40) {
                System.out.println(employee);
            }
        }
    }
}
