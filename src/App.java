import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

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
    }

     public void giveReward() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
