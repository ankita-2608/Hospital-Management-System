import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class viewPatient {
    private JFrame frame;
    private JButton BACKButton;
    private JButton LOGOUTButton;
    private JTable table1;
    private JButton VIEWDETAILSButton;
    private JPanel Main;
    Connection con;
    PreparedStatement pst;
    public void connect() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","");
            System.out.println("success");
        }
        catch(ClassNotFoundException ex) {

        }
        catch (SQLException ex) {

        }
    }
    public void table_load() {
        try{
            pst = con.prepareStatement("select * from patient_record");
            ResultSet rs = pst.executeQuery(); //this method will load all the details to the table.
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException ex) {

        }
    }

    public viewPatient() {
        connect();
        frame = new JFrame("viewPatient");
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
    }
    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new welcome();
    }
}
