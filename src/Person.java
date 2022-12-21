public abstract class Person{
    // TODO implement Person and its subclasses in other Java files
    String myName;

    String name;
    int age;
    int months_worked;
    double salary;
    double thirteenthMonth;

    public Person(String color) {
        this.myName = color;
    }
    @Override
    public String toString() {
        return "Hello, my name is " + myName;
    }

    public String Clerk() {
        return "How may I help you?";
    }

    public abstract String name();
    public abstract int age();
    public abstract int months_worked();
    public abstract double salary();
    public abstract double thirteenthMonth();

}
