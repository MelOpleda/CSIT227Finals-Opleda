import javax.swing.*;

public abstract class Person {
    // TODO implement Person and its subclasses in other Java files
    String name;
    int age;
    int months_worked;
    double salary;

//    double thirteenthMonth;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person(String name, int age, int months_worked, double salary) {
        this.name = name;
        this.age = age;
        this.months_worked = months_worked;
        this.salary = salary;
    }

    protected Person() {
    }



    @Override
    public String toString() {
        return "Hello, my name is " + name + " ";
    }

    public abstract String getName();
    public abstract int getAge();
    public abstract int getMonths();
    public abstract double getSalary();



    public static class Customer extends Person {
        public Customer(String name, int age) {
            super(name, age);
        }

        @Override
        public String toString() {
            return "Hello, my name is " + name + " ";
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public int getAge() {
            return age;
        }

        @Override
        public int getMonths() {
            return months_worked;
        }

        @Override
        public double getSalary() {
            return salary;
        }


    }

    public static class Employee extends Person {

        public Employee(String name, int age, int months_worked, double salary) {
            super(name, age,months_worked, salary);
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public int getAge() {
            return age;
        }

        @Override
        public int getMonths() {
            return months_worked;
        }

        @Override
        public double getSalary() {
            return salary;
        }
        public String toString() {
            return "Hello, my name is " + name + " ";
        }


        public static class Clerk extends Employee {

            public Clerk(String name, int age, int months_worked, double salary) {
                super(name, age,months_worked, salary);
            }

            @Override
            public String toString() {
                return "How may I help you?";
            }
            @Override
            public String getName() {
                return name;
            }

            @Override
            public int getAge() {
                return age;
            }

            @Override
            public int getMonths() {
                return months_worked;
            }

            @Override
            public double getSalary() {
                return salary;
            }

        }
        public static class Manager extends Employee {

            public Manager(String name, int age, int months_worked, double salary) {
                super(name, age,months_worked, salary);
            }
            @Override
            public String toString() {
                return "Hello, my name is " + name + " ";
            }
            @Override
            public String getName() {
                return name;
            }

            @Override
            public int getAge() {
                return age;
            }

            @Override
            public int getMonths() {
                return months_worked;
            }

            @Override
            public double getSalary() {
                return salary;
            }

        }
    }



}

