import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class LoginManagement {

    public static void login() {
        JFrame frame = new JFrame("Login");
        frame.setSize(400,180);
        JLabel l1,l2;
        JLabel label1 = new JLabel("Username");
        label1.setBounds(30,15,100,30);
        JLabel label2 = new JLabel("Password");
        label2.setBounds(30,50,100,30);
        JTextField inputUser = new JTextField();
        inputUser.setBounds(110, 15, 200, 30);

        JPasswordField inputPassword=new JPasswordField();
        inputPassword.setBounds(110, 50, 200, 30);

        JButton loginButton=new JButton("Login");
        loginButton.setBounds(130,90,80,25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String utente = inputUser.getText();
                String pwd = inputPassword.getText();

                //se manca utente
                if (utente.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Inserisci Username");

                }
                //se manca password
                else if (pwd.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Inserisci Password");
                }

                //se ci sono utente e password
                else {
                    Connection connection = connetti();
                    try {
                        assert connection != null; //RIVEDERE!
                        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        String query = ("SELECT * FROM user WHERE username='" + utente + "' AND password='" + pwd + "'");
                        ResultSet risultati = statement.executeQuery(query);
                        boolean cisonorighe = risultati.next();
                        if (cisonorighe==false) { //tento di passare alla riga successiva; se non ci sono rige, la funzione restituisce "false"
                            System.out.println("No User");

                            JOptionPane.showMessageDialog(null, "Username e/o Password errati");
                        }
                        else { //quindi se l'utente è corretto
                            frame.dispose(); //nasconde il frame che ho creato prima
                            System.out.println("nome e pwd corretti.");
                            System.out.println(cisonorighe);
                            risultati.beforeFirst(); //assicura che l'iterazione avvenga dalla prima riga

                            while (risultati.next()) {
                                int isadmin =  risultati.getInt("admin");
                                System.out.println(isadmin);
                                String user = risultati.getString("ID");
                                System.out.println(user);
                                if (isadmin == 1)  {
                                    // mostrare il menu degli admin: menuAdmin();
                                    AdminMenu menu = new AdminMenu(connection);
                                    System.out.println("Ciao Admin");
                                }
                                else {
                                    // mostrare il menu dell'utente: menuUtente(user);
                                    UserMenu menu = new UserMenu(utente, connection);
                                    System.out.println("ciao utente normale");
                                }
                            }

                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }

            }
        });





        frame.add(label1);
        frame.add(label2);
        frame.add(inputUser);
        frame.add(inputPassword);
        frame.add(loginButton);
        frame.setLayout(null); //necessario definire manualmente posizione e dimensione di ogni componente del frame
        frame.setLocationRelativeTo(null); //frame al centro dello schermo
        frame.setVisible(true);
    }

    public static Connection connetti() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mysql?user=root&password=");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/library?user=root&password=");

            System.out.println("connesso!");
            return connection;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
