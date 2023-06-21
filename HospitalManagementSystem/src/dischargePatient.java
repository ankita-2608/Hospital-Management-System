import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class dischargePatient {
    private JFrame frame;
    private JButton BACKButton;
    private JButton LOGOUTButton;
    private JTable table1;
    private JButton VIEWDETAILSButton;
    private JPanel Main;
    private JTextField txtId;
    private JButton DISCHARGEButton;
    Connection con;
    PreparedStatement pst;
    public void connect() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","");
            System.out.println("success");
        }
        catch (ClassNotFoundException ex) {

        }
        catch (SQLException ex) {

        }
    }
    void table_load() {
        try {
            pst = con.prepareStatement("select * from patient_record");
            ResultSet rs = pst.executeQuery(); //this method will load all the details to the table.
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public dischargePatient() {
        connect();
        frame = new JFrame("dischargePatient");
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
        VIEWDETAILSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table_load();
            }
        });
        DISCHARGEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Id;
                Id = txtId.getText();
                try{
                    pst = con.prepareStatement("delete from patient_record where Id = ?");
                    pst.setString(1, Id);
                    pst.executeUpdate();
                    table_load();
                    JOptionPane.showMessageDialog(null,"Record deleted!!!");
                    txtId.setText("");
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
