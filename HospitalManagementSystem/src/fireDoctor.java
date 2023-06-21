import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

public class fireDoctor {
    private JPanel Main;
    private JFrame frame;
    private JTable table1;
    private JTextField txtId;
    private JButton FIREButton;
    private JButton LOGOUTButton;
    private JButton BACKButton;
    private JButton VIEWDETAILSButton;

    Connection con;
    PreparedStatement pst;
    public void connect() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
            System.out.println("success");
        }
        catch(ClassNotFoundException ex) {

        }
        catch(SQLException ex) {

        }
    }
    void table_load() {
        try {
            pst = con.prepareStatement("select * from doctor_record");
            ResultSet rs = pst.executeQuery(); //this method will load all the details to the table.
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public fireDoctor() {
        connect();
        frame = new JFrame("fireDoctor");
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
        VIEWDETAILSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table_load();
            }
        });
        FIREButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Id;
                Id = txtId.getText();
                try {
                    pst = con.prepareStatement("delete from doctor_record where Id = ?");
                    pst.setString(1, Id);
                    pst.executeUpdate();
                    table_load();
                    JOptionPane.showMessageDialog(null, "Record deleted!!");
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
