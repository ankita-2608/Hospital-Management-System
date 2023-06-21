import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PatientModule {
    private JFrame frame;
    private JPanel Main;
    private JButton ADMITNEWPATIENTButton;
    private JButton EDITPATIENTDETAILSButton;
    private JButton DISCHARGEPATIENTButton;
    private JButton VIEWPATIENTDETAILSButton;
    private JButton LOGOUTButton;
    private JButton BACKButton;

    public PatientModule(){
        frame = new JFrame("PatientModule");
        frame.setContentPane(Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        ADMITNEWPATIENTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPatient addPatientWindow = new addPatient();
                addPatientWindow.show();
                frame.dispose();
            }
        });
        EDITPATIENTDETAILSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editPatient editPatientWindow = new editPatient();
                editPatientWindow.show();
                frame.dispose();
            }
        });
        DISCHARGEPATIENTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dischargePatient dischargePatientWindow = new dischargePatient();
                dischargePatientWindow.show();
                frame.dispose();
            }
        });
        VIEWPATIENTDETAILSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPatient viewPatientWindow = new viewPatient();
                viewPatientWindow.show();
                frame.dispose();
            }
        });
        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcome welcomeWindow = new welcome();
                welcomeWindow.show();
                frame.dispose();
            }
        });
        LOGOUTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
