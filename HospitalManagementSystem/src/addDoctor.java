import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class addDoctor {
    private JTextField txtName;
    private JTextField txtSpe;
    private JTextField txtDoj;
    private JTextField txtMobile;
    private JButton BACKButton;
    private JButton LOGOUTButton;
    private JPanel Main;
    private JButton ADDButton;

    private JFrame frame;

    Connection con;
    PreparedStatement pst;
    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
            System.out.println("success");
        }
        catch(ClassNotFoundException ex) {

        }
        catch (SQLException ex) {

        }
    }

    public addDoctor() {
        connect();
        frame = new JFrame("addDoctor");
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

        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String DoctorName, Specialisation, DOJ, Mobile;
                DoctorName = txtName.getText();
                Specialisation = txtSpe.getText();
                DOJ = txtDoj.getText();
                Mobile = txtMobile.getText();
                try {
                    pst = con.prepareStatement("insert into doctor_record(DoctorName, Specialisation, DOJ, Mobile)value(?,?,?,?)");
                    pst.setString(1, DoctorName);
                    pst.setString(2, Specialisation);
                    pst.setString(3, DOJ);
                    pst.setString(4, Mobile);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Added!!");
                    txtName.setText("");
                    txtSpe.setText("");
                    txtDoj.getText();
                    txtMobile.getText();
                }
                catch (SQLException e1) {
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
