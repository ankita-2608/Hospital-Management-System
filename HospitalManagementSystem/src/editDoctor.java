import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class editDoctor {
    private JFrame frame;
    private JButton BACKButton;
    private JButton LOGOUTButton;
    private JTextField txtid;
    private JTextField txtMobile;
    private JTextField txtSpe;
    private JTextField txtDoj;
    private JButton CLEARALLButton;
    private JButton UPDATEButton;
    private JPanel Main;
    private JTextField txtName;

    Connection con;
    PreparedStatement pst;
    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
            System.out.println("Success");
        }
        catch (ClassNotFoundException ex) {

        }
        catch (SQLException ex) {

        }
    }

    public editDoctor() {
        connect();
        frame = new JFrame("editDoctor");
        frame.setContentPane(Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoctorModule DoctorModuleWindow = new DoctorModule();
                DoctorModuleWindow.show();
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
                String Id, DoctorName, Specialisation, DOJ, Mobile;
                Id = txtid.getText();
                DoctorName = txtName.getText();
                Specialisation = txtSpe.getText();
                DOJ = txtDoj.getText();
                Mobile = txtMobile.getText();
                try {
                    pst = con.prepareStatement("update doctor_record set DoctorName=?, Specialisation=?, DOJ=?, Mobile=? where Id=?");
                    pst.setString(1, DoctorName);
                    pst.setString(2, Specialisation);
                    pst.setString(3, DOJ);
                    pst.setString(4, Mobile);
                    pst.setString(5, Id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Updated!!");
                    txtName.setText("");
                    txtSpe.setText("");
                    txtDoj.setText("");
                    txtMobile.setText("");
                }
                catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        CLEARALLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editDoctor editDoctorWindow = new editDoctor();
                editDoctorWindow.show();
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
