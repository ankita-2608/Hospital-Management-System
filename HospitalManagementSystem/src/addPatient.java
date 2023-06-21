import javax.naming.ldap.PagedResultsControl;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class addPatient {
    private JFrame frame;
    private JPanel Main;
    private JButton BACKButton;
    private JButton LOGOUTButton;
    private JButton ADDButton;
    private JTextField txtName;
    private JTextField txtAge;
    private JTextField txtGender;
    private JTextField txtDisease;
    private JTextField txtAddress;
    private JTextField txtDoc;
    Connection con;
    PreparedStatement pst;
    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","");
            System.out.println("success");
        }
        catch(ClassNotFoundException ex) {

        }
        catch (SQLException ex) {

        }
    }


    public addPatient() {
        connect();
        frame = new JFrame("addPatient");
        frame.setContentPane(Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        BACKButton.addActionListener(new ActionListener() {
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
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String PName, Age, Gender, Disease, Address, doctor_id;
                PName = txtName.getText();
                Age = txtAge.getText();
                Gender = txtGender.getText();
                Disease = txtDisease.getText();
                Address = txtAddress.getText();
                doctor_id = txtDoc.getText();
                try {
                    pst = con.prepareStatement("insert into patient_record(PName,Age,Gender,Disease,Address,doctor_id)values(?,?,?,?,?,?)");
                    pst.setString(1,PName);
                    pst.setString(2,Age);
                    pst.setString(3,Gender);
                    pst.setString(4,Disease);
                    pst.setString(5,Address);
                    pst.setString(6,doctor_id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Inserted!!!");
                    txtName.setText("");
                    txtAge.setText("");
                    txtGender.setText("");
                    txtDisease.setText("");
                    txtAddress.setText("");
                    txtDoc.setText("");
                }
                catch(SQLException e1) {
                    e1.printStackTrace();
                }
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
