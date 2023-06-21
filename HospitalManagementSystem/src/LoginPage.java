import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

public class LoginPage {
    private JFrame frame;
    private JPanel Main;
    private JTextField txtUser;
    private JButton loginButton;
    private JPasswordField txtpass;


    Connection con;
    PreparedStatement pst;
    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
            System.out.println("success");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
    public LoginPage() {
        connect();
        frame = new JFrame("User Login");
        frame.setContentPane(Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUser.getText();
                String password = new String(txtpass.getPassword());

                boolean found = false;
                try {
                    pst = con.prepareStatement("select * from user_login where username=? and password=?");
                    pst.setString(1, username);
                    pst.setString(2, password);
                    ResultSet rs = pst.executeQuery();
                    while(rs.next() == true) {
                        username = rs.getString("username");
                        password = rs.getString("password");

                        if(username.equals(username) && password.equals(password)) {
                            found = true;
                            welcome welcomeWindow = new welcome();
                            welcomeWindow.show();
                            frame.dispose();
                        }
                    }
                    if(!found){
                            JOptionPane.showMessageDialog(null,"Invalid username or password!!");
                   }
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
        new LoginPage();
    }
}
