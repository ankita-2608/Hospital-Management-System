import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class editPatient {
    private JFrame frame;
    private JButton BACKButton;
    private JButton LOGOUTButton;
    private JTextField txtName;
    private JTextField txtAge;
    private JTextField txtGender;
    private JTextField txtDisease;
    private JTextField txtAddress;
    private JTextField txtDoc;
    private JButton CLEARALLButton;
    private JButton UPDATEButton;
    private JPanel Main;
    private JTextField txtId;

    Connection con;
    PreparedStatement pst;
    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","");
            System.out.println("success");
        }
        catch (ClassNotFoundException ex) {

        }
        catch (SQLException ex) {

        }
    }


    public editPatient() {
        connect();
        frame = new JFrame("editPatient");
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
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Id, PName, Age, Gender, Disease, Address, doctor_id;
                Id = txtId.getText();
                PName = txtName.getText();
                Age = txtAge.getText();
                Gender = txtGender.getText();
                Disease = txtDisease.getText();
                Address = txtAddress.getText();
                doctor_id = txtDoc.getText();
                try {
                    pst = con.prepareStatement("update patient_record set PName=?,Age=?,Gender=?,Disease=?,Address=?,doctor_id=? where Id=?");
                    pst.setString(1, PName);
                    pst.setString(2,Age);
                    pst.setString(3,Gender);
                    pst.setString(4,Disease);
                    pst.setString(5,Address);
                    pst.setString(6,doctor_id);
                    pst.setString(7,Id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Updated!!!");
                    txtName.setText("");
                    txtAge.setText("");
                    txtGender.setText("");
                    txtDisease.setText("");
                    txtAddress.setText("");
                    txtDoc.setText("");
                }
                catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        CLEARALLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editPatient editPatientWindow = new editPatient();
                editPatientWindow.show();
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
