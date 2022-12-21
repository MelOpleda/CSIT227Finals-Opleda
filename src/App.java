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

    }

    public static void main(String[] args) {
        // add here how to make GUI visible
        App app = new App();
        app.setTitle("Leap Year Checker");
        app.setContentPane(app.pnlMain);
        app.setSize(700, 500);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setLocationRelativeTo(null);
        app.taPersons.setEditable(false);


        String name = app.tfName.getText();;
        int age;
        double months_worked;
        double salary;

        try {
            age = Integer.parseInt(app.tfAge.getText());
            months_worked = Double.parseDouble(app.tfMonths.getText());
            salary = Double.parseDouble(app.tfSalary.getText());

        } catch (NumberFormatException numberFormatException) {
            return;
        }

        if (app.rbCustomer.isSelected()){
            app.tfMonths.setEditable(false);
            app.tfSalary.setEditable(false);
        }
        else if (app.rbClerk.isSelected()){
            app.tfName.setText("(" + name + ")");
            app.tfName.setText("(" + age + ")");
        }


        app.btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    app.taPersons.setText(String.valueOf(name));
                    app.taPersons.setText(String.valueOf(age));
                    app.taPersons.setText(String.valueOf(months_worked));
                    app.taPersons.setText(String.valueOf(salary));

            }
        });

        app.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                app.tfName.setText("");
                app.tfAge.setText("");
                app.tfMonths.setText("");
                app.tfSalary.setText("");
                app.tfLoad.setText("");

            }
        });






    }

    static void giveReward(int n) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
