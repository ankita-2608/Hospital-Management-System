import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DoctorModule {
    private JFrame frame;
    private JPanel Main;
    private JButton ADDDOCTORButton;
    private JButton EDITDOCTORDETAILSButton;
    private JButton FIREDOCTORButton;
    private JButton VIEWDOCTORDETAILSButton;
    private JButton LOGOUTButton;
    private JButton BACKButton;

    public DoctorModule(){
        frame = new JFrame("DoctorModule");
        frame.setContentPane(Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        ADDDOCTORButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDoctor addDoctorWindow = new addDoctor();
                addDoctorWindow.show();
                frame.dispose();
            }
        });
        EDITDOCTORDETAILSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editDoctor editDoctorWindow = new editDoctor();
                editDoctorWindow.show();
                frame.dispose();
            }
        });
        FIREDOCTORButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireDoctor fireDoctorWindow = new fireDoctor();
                fireDoctorWindow.show();
                frame.dispose();
            }
        });
        VIEWDOCTORDETAILSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewDoctor viewDoctorWindow = new viewDoctor();
                viewDoctorWindow.show();
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
