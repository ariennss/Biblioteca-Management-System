import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//il menu Utenti può mostrare l'elenco dei libri agli utenti e l'elenco dei libri presi in prestito
public class UserMenu {

    public UserMenu(String userID, Connection connection) {
        JFrame menu = new JFrame("User Menu");
        menu.setSize(300, 100);
        JButton button_elenco = new JButton("Elenco Libri");
        button_elenco.setBounds(20,20,120,25);
        button_elenco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Funziona?");
                JFrame elenco = new JFrame("Elenco dei libri");
                String sql = "SELECT * FROM library.libro";
                try {
                    Statement statement = connection.createStatement();
                    ResultSet risultati = statement.executeQuery(sql);
                    JTable listaLibri = new JTable();
                    listaLibri.setModel(DbUtils.resultSetToTableModel(risultati));
                    JScrollPane scrollPane = new JScrollPane(listaLibri);

                    elenco.add(scrollPane);
                    elenco.setSize(800,400);
                    elenco.setVisible(true);
                    elenco.setLocationRelativeTo(null);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JButton mieiLibri = new JButton("I miei libri");
        mieiLibri.setBounds(150, 20, 120, 25);
        mieiLibri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame elenco = new JFrame("I miei libri");
                String sql = "SELECT * from library.libro JOIN library.prestito WHERE prestito.id_user = '" + userID + "'";
                try {
                    Statement statement = connection.createStatement();
                    ResultSet risultati = statement.executeQuery(sql);
                    JTable myBooks = new JTable();
                    myBooks.setModel(DbUtils.resultSetToTableModel(risultati));
                    JScrollPane scroll = new JScrollPane(myBooks);

                    elenco.add(scroll);
                    elenco.setSize(800,400);
                    elenco.setVisible(true);
                    elenco.setLocationRelativeTo(null);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        menu.add(button_elenco);
        menu.add(mieiLibri);
        menu.setSize(300,100);
        menu.setLayout(null); //necessario definire manualmente posizione e dimensione di ogni componente del frame
        menu.setLocationRelativeTo(null); //frame al centro dello schermo
        menu.setVisible(true);

    }
}


//TODO cerca per titolo button
//todo cerca per autore button
