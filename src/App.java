import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class App extends JFrame implements ActionListener {
    private JPanel pnlMain;
    private JRadioButton rbCustomer;
    private JRadioButton rbClerk;
    private JRadioButton rbManager;
    private JTextField tfName;
    private JTextArea taPersons;
    private JButton btnSave;
    private JTextField tfAge;
    private JTextField tfMonths;
    private JTextField tfSalary;
    private JButton btnClear;
    private JTextField tfLoad;
    private JButton btnLoad;
    private JButton btnSayHi;
    private JButton btnSavePerson;
    private JButton btnLoadPerson;
    private JButton btnReward;

    private List<Person> persons;


    public App() {
        persons = new ArrayList<>();
        // TODO add implementations for all milestones here

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int age = 0;
                int months_worked = 0;
                double salary = 0;
                String name = String.valueOf(tfName.getText());

                if(rbCustomer.isSelected()){
                    if(tfName.getText().equals("") || tfAge.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Empty Text Field(s)", "Invalid TextFields", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    try{
                        age = Integer.parseInt(tfAge.getText());

                    } catch (NumberFormatException numberFormatException){
                        JOptionPane.showMessageDialog(null, "String Instead of a Number!","Incorrect Input!", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (age < 0) {
                        JOptionPane.showMessageDialog(null, "Negative Numerical Input(s)!", "Incorrect Input!", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                else if(rbClerk.isSelected()){
                    if(tfName.getText().equals("") || tfAge.getText().equals("") || tfMonths.getText().equals("") || tfSalary.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Empty Text Field(s)", "Invalid TextFields", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    try{
                        age = Integer.parseInt(tfAge.getText());
                        months_worked = Integer.parseInt(tfMonths.getText());
                        salary = Double.parseDouble(tfSalary.getText());

                    } catch (NumberFormatException numberFormatException){
                        JOptionPane.showMessageDialog(null, "String Instead of a Number!","Incorrect Input!", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (age < 0 || months_worked < 0 || salary < 0) {
                        JOptionPane.showMessageDialog(null, "Negative Numerical Input(s)!", "Incorrect Input!", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                else if(rbManager.isSelected()){

                    if(tfName.getText().equals("") || tfAge.getText().equals("") || tfMonths.getText().equals("") || tfSalary.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Empty Text Field(s)", "Invalid TextFields", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    try{
                        age = Integer.parseInt(tfAge.getText());
                        months_worked = Integer.parseInt(tfMonths.getText());
                        salary = Double.parseDouble(tfSalary.getText());

                    } catch (NumberFormatException numberFormatException){
                        JOptionPane.showMessageDialog(null, "String Instead of a Number!","Incorrect Input!", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (age < 0 || months_worked < 0 || salary < 0) {
                        JOptionPane.showMessageDialog(null, "Negative Numerical Input(s)!", "Incorrect Input!", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                taPersons.append(String.valueOf( name + " (" + age + ")"));
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tfName.setText("");
                tfAge.setText("");
                tfMonths.setText("");
                tfSalary.setText("");
                tfLoad.setText("");
                taPersons.setText("");
            }
        });

        btnLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int n = Integer.parseInt(tfLoad.getText());

                    if (rbCustomer.isSelected()) {
                        Person.Customer cus = (Person.Customer) persons.get(n - 1);
                        tfName.setText(persons.get(n - 1).getName());
                        tfAge.setText(String.valueOf(persons.get(n - 1).getAge()));
                    }
                    else if (rbClerk.isSelected()) {
                        Person.Employee.Clerk c = (Person.Employee.Clerk) persons.get(n - 1);
                        tfName.setText(persons.get(n - 1).getName());
                        tfAge.setText(String.valueOf(persons.get(n - 1).getAge()));
                        tfMonths.setText(String.valueOf(persons.get(n - 1).getMonths()));
                        tfSalary.setText(String.valueOf(persons.get(n - 1).getSalary()));
                    }
                    else if (rbManager.isSelected()) {
                        Person.Employee.Manager m = (Person.Employee.Manager) persons.get(n - 1);
                        tfName.setText(persons.get(n - 1).getName());
                        tfAge.setText(String.valueOf(persons.get(n - 1).getAge()));
                        tfMonths.setText(String.valueOf(persons.get(n - 1).getMonths()));
                        tfSalary.setText(String.valueOf(persons.get(n - 1).getSalary()));
                    }

                } catch (ClassCastException c) {
                    JOptionPane.showMessageDialog(null, "Something went wrong.");
                } catch (NumberFormatException n) {
                    JOptionPane.showMessageDialog(null, "Input Invalid.");
                } catch (IndexOutOfBoundsException i) {
                    JOptionPane.showMessageDialog(null, "Data does not exist.");
                }
            }
        });

        btnSayHi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbCustomer.isSelected()){
                    for (Person cus : persons) {
                        if (cus instanceof Person.Customer) {
                            System.out.println(cus.toString());
                        }
                    }
                }
                if(rbClerk.isSelected()){
                    for (Person c : persons) {
                        if (c instanceof Person.Employee.Clerk) {
                            System.out.println(c.toString());
                        }
                    }
                }
                if(rbManager.isSelected()){
                    for (Person m : persons) {
                        if (m instanceof Person.Employee.Manager) {
                            System.out.println(m.toString());
                        }
                    }
                }
            }
        });

        btnReward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giveReward();
            }
        });
        rbCustomer.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                tfMonths.setEditable(false);
                tfSalary.setEditable(false);
            }
        });
        rbClerk.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                tfMonths.setEditable(true);
                tfSalary.setEditable(true);
            }
        });
        rbManager.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                tfMonths.setEditable(true);
                tfSalary.setEditable(true);
            }
        });
    }

    public static void main(String[] args) {
        // add here how to make GUI visible
        App app = new App();
        app.setTitle("CSIT227Finals-Opleda");
        app.setContentPane(app.pnlMain);
        app.setSize(700, 500);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setLocationRelativeTo(null);
        app.taPersons.setEditable(false);
    }

     public void giveReward() {
         int age = 0;
         int months_worked = 0;
         double salary = 0;
         String name = String.valueOf(tfName.getText());

         if(tfMonths.getText().equals("") || tfSalary.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Empty Text Field(s)", "Invalid TextFields", JOptionPane.ERROR_MESSAGE);
             return;
         }
         try{
             age = Integer.parseInt(tfAge.getText());
             months_worked = Integer.parseInt(tfMonths.getText());
             salary = Double.parseDouble(tfSalary.getText());

         } catch (NumberFormatException numberFormatException){
             JOptionPane.showMessageDialog(null, "Invalid Input","Invalid Input", JOptionPane.ERROR_MESSAGE);
             return;
         }

         if(rbCustomer.isSelected()){
             JOptionPane.showMessageDialog(null, "This Person isn't an Employee", "Sorry", JOptionPane.ERROR_MESSAGE);
             return;
         }

         double result;
         for (Person c : persons) {
             result = (c.getSalary() * c.getMonths()) / 12;
             JOptionPane.showMessageDialog(null,String.format("%.2f",result),"Thirteenth Month Pay", JOptionPane.INFORMATION_MESSAGE);
         }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
