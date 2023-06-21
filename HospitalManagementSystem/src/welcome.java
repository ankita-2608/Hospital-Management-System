import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class welcome {
    private JFrame frame;
    private JPanel Main;
    private JButton doctorSRecordButton;
    private JButton patientSRecordButton;
    private JButton LOGOUTButton;
    private JButton BACKButton;

    public welcome() {
        frame = new JFrame("Welcome");
        frame.setContentPane(Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        doctorSRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoctorModule doctorModuleWindow = new DoctorModule();
                doctorModuleWindow.show();
                frame.dispose();
            }
        });
        patientSRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PatientModule patientModuleWindow = new PatientModule();
                patientModuleWindow.show();
                frame.dispose();
            }
        });
        LOGOUTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPage loginPageWindow = new LoginPage();
                loginPageWindow.show();
                frame.dispose();
            }
        });
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new welcome();
    }
}
