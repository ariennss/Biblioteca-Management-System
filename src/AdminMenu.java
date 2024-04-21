import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AdminMenu {

    public AdminMenu (Connection connection) {
        JFrame menu = new JFrame("Admin Menu");
        menu.setSize(800, 400);


        JButton libri = new JButton("Elenco Libri");
        libri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame elencoLibri = new JFrame("Elenco Libri");
                String sql = "SELECT * from library.libro";
                try {
                    Statement statement = connection.createStatement();
                    ResultSet risultati = statement.executeQuery(sql);
                    JTable totaleLibri = new JTable();
                    totaleLibri.setModel(DbUtils.resultSetToTableModel(risultati));
                    JScrollPane scroll = new JScrollPane(totaleLibri);

                    elencoLibri.add(scroll);
                    elencoLibri.setSize(800,400);
                    elencoLibri.setVisible(true);
                    elencoLibri.setLocationRelativeTo(null);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
       // libri.setBounds(450,60,120,25);
        JButton utenti = new JButton("Utenti");
        utenti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame elencoUtenti = new JFrame("Elenco Utenti");
                String sql = "SELECT * from library.user";
                try {
                    Statement statement = connection.createStatement();
                    ResultSet risultati = statement.executeQuery(sql);
                    JTable totaleUtenti = new JTable();
                    totaleUtenti.setModel(DbUtils.resultSetToTableModel(risultati));
                    JScrollPane scroll = new JScrollPane(totaleUtenti);

                    elencoUtenti.add(scroll);
                    elencoUtenti.setSize(800,400);
                    elencoUtenti.setVisible(true);
                    elencoUtenti.setLocationRelativeTo(null);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
       // utenti.setBounds(20,20,120,25);
        JButton addUtente = new JButton("Aggiungi Utente");
        addUtente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame aggiungiUtente = new JFrame("Aggiungi utente");
                JLabel utente = new JLabel("Username");
                JLabel password = new JLabel("Password");
                utente.setBounds(30,15,100,30);
                password.setBounds(30,50,100,30);
                JTextField user = new JTextField();
                user.setBounds(110,15,200,30);
                JPasswordField pwd = new JPasswordField();
                pwd.setBounds(110,50,200,30);
                JButton create = new JButton("Aggiungi");
                create.setBounds(130,130,80,25);
                create.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nuovoUtente = user.getText();
                        String pwdNuovoUtente = pwd.getText();
                        try {
                            Statement statement = connection.createStatement();
                            String sql = "INSERT INTO USER(username, password, admin) VALUES('" + nuovoUtente + "', '" + pwdNuovoUtente + "', '0')";
                            statement.executeUpdate(sql);
                            JOptionPane.showMessageDialog(null, "Utente aggiunto");
                            aggiungiUtente.dispose();
                            System.out.println("Aggiunto");
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });

                aggiungiUtente.add(utente);
                aggiungiUtente.add(password);
                aggiungiUtente.add(user);
                aggiungiUtente.add(pwd);
                aggiungiUtente.add(create);
                aggiungiUtente.setSize(350,200);
                aggiungiUtente.setLayout(null);
                aggiungiUtente.setVisible(true);
                aggiungiUtente.setLocationRelativeTo(null);
            }
        });
       // addUtente.setBounds(150,20,120,25);
        JButton addLibro = new JButton("Aggiungi Libro");
        addLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame aggiungiLibro = new JFrame("Aggiungi Libro");

                JLabel titoloLibro = new JLabel("Titolo");
                titoloLibro.setBounds(30,15, 100,30);
                JLabel autoreLibro = new JLabel("Autore");
                autoreLibro.setBounds(30, 53, 100,30);
                JLabel genereLibro = new JLabel("Genere");
                genereLibro.setBounds(30,90, 100,30);
                JTextField titoloL = new JTextField();
                titoloL.setBounds(110, 15, 200, 30);
                JTextField autoreL = new JTextField();
                autoreL.setBounds(110, 53, 200, 30);
                JTextField genereL = new JTextField();
                genereL.setBounds(110, 90, 200, 30);
                JButton add = new JButton("Aggiungi Libro");
                add.setBounds(130,130,80,25);
                add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nome = titoloL.getText();
                        String autore = autoreL.getText();
                        String genere = genereL.getText();

                        try {
                            Statement statement = connection.createStatement();
                            String sql = "INSERT INTO LIBRO (titolo, autore, genere, disponibilealprestito) VALUES ('" + nome + "', '" + autore + "', '" + genere + "', '1')";
                            statement.executeUpdate(sql);
                            JOptionPane.showMessageDialog(null, "Libro aggiunto!");
                            System.out.println("Libro aggiunto!");
                            aggiungiLibro.dispose();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });

                aggiungiLibro.add(titoloLibro);
                aggiungiLibro.add(autoreLibro);
                aggiungiLibro.add(genereLibro);
                aggiungiLibro.add(titoloL);
                aggiungiLibro.add(autoreL);
                aggiungiLibro.add(genereL);
                aggiungiLibro.add(add);
                aggiungiLibro.setSize(350, 200);
                aggiungiLibro.setLocationRelativeTo(null);
                aggiungiLibro.setLayout(null);
                aggiungiLibro.setVisible(true);
            }
        });
       // addLibro.setBounds(280,20,160,25);
        JButton presta = new JButton("Presta Libro");
        presta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame presta = new JFrame("Aggiungi prestito");
                JLabel cheLibro = new JLabel("ID Libro");
                JLabel cheUtente = new JLabel("ID Utente");
                JLabel dataPrestito = new JLabel("Data Prestito");
                JLabel periodoPrestito = new JLabel("N. giorni di prestito");
                cheLibro.setBounds(30,15, 100,30);
                cheUtente.setBounds(30,53, 100,30);
                dataPrestito.setBounds(30,90, 100,30);
                periodoPrestito.setBounds(30,127, 150,30);
                JTextField id_libro = new JTextField();
                JTextField id_utente = new JTextField();
                JTextField dataInizio = new JTextField();
                JTextField numGiorni = new JTextField();
                id_libro.setBounds(110, 15, 200, 30);
                id_utente.setBounds(110, 53, 200, 30);
                dataInizio.setBounds(110, 90, 200, 30);
                numGiorni.setBounds(180, 130, 130, 30);
                JButton creaPrestito = new JButton("Presta");
                creaPrestito.setBounds(130,170,80,25);
                creaPrestito.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String idlibro = id_libro.getText();
                        String iduser = id_utente.getText();
                        String dataPrestito = dataInizio.getText();
                        String quantiGiorni = numGiorni.getText();


                        try {
                            Statement statement = connection.createStatement();
                            String available = "SELECT libro.disponibilealprestito FROM libro WHERE ID = '" + idlibro + "'";
                            ResultSet risultato = statement.executeQuery(available);

                            if (risultato.next() && risultato.getInt(1) == 1) {
                                String sql = "INSERT INTO prestito(id_libro, id_user, data_prestato, periodo_prestito) VALUES('" + idlibro + "', '" + iduser + "', '" + dataPrestito + "', '" + quantiGiorni + "')";
                                statement.executeUpdate(sql);
                                System.out.println("Fatto");
                                statement.executeUpdate("UPDATE libro SET disponibilealprestito = '0' WHERE libro.ID = '" + idlibro + "'");
                                JOptionPane.showMessageDialog(null, "Prestito effettuato");
                            } else {
                                JOptionPane.showMessageDialog(null, "Il libro è già in prestito!");
                            }
                            presta.dispose();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });

                presta.add(cheLibro);
                presta.add(cheUtente);
                presta.add(dataPrestito);
                presta.add(periodoPrestito);
                presta.add(id_libro);
                presta.add(id_utente);
                presta.add(dataInizio);
                presta.add(numGiorni);
                presta.add(creaPrestito);
                presta.setSize(350,250);//400 width and 500 height
                presta.setLayout(null);//using no layout managers
                presta.setVisible(true);//making the frame visible
                presta.setLocationRelativeTo(null);

            }
        });



       // presta.setBounds(20,60,120,25);
        JButton restituisci = new JButton("Restituisci libro");
       // restituisci.setBounds(150,60,120,25);
        restituisci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame restituisci = new JFrame("Restituisci Libro");

                JLabel idPrestito = new JLabel("ID Prestito");
                JLabel idLibro = new JLabel("ID Libro");

                JLabel dataRitorno = new JLabel("Data di restituzione");
                idPrestito.setBounds(30,90, 100,30);
                idLibro.setBounds(30,50,150,30);
                dataRitorno.setBounds(30,15, 100,30);
                JTextField idPrest = new JTextField();
                JTextField idBook = new JTextField();
                JTextField date = new JTextField();
                idPrest.setBounds(110, 90, 200, 30);
                idBook.setBounds(110, 50, 200, 30);
                date.setBounds(110, 15, 200, 30);
                JButton restituzione = new JButton("Restituisci");
                restituzione.setBounds(130,170,80,25);
                restituzione.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            String prestito = idPrest.getText();
                            String dataRitorno = date.getText();
                            String idlibro = idBook.getText();
                        System.out.println("id prestito = " + prestito);
                        System.out.println("id libro = " + idlibro);
                        System.out.println("data ritorno = " + dataRitorno);

                        try {
                            Statement statement = connection.createStatement();
                            statement.executeUpdate("USE library");
                            String sql2 = "SELECT * FROM prestito WHERE prestito.ID = '" + prestito + "'";
                            ResultSet risultato = statement.executeQuery(sql2);
                            if (risultato.next() != false) {
                                statement.executeUpdate("UPDATE library.prestito SET prestito.data_restituito = '" + dataRitorno + "' WHERE prestito.ID = '" + prestito + "'");
                                System.out.println(dataRitorno);
                                String sql1 = "SELECT data_restituito FROM prestito WHERE prestito.ID = '" + prestito + "'";
                                ResultSet risultati = statement.executeQuery(sql1);
                                statement.executeUpdate("UPDATE libro SET libro.disponibilealprestito = '1' WHERE libro.ID = '" + idlibro + "'");
                                JOptionPane.showMessageDialog(null, "Libro restituito!");
                                restituisci.dispose();

                            }
                            else {
                                System.out.println("Non ci sono risultati");
                                JOptionPane.showMessageDialog(null, "Nessun prestito a questo ID");

                            }



                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                });

                restituisci.add(idPrestito);
                restituisci.add(idLibro);
                restituisci.add(dataRitorno);
                restituisci.add(idPrest);
                restituisci.add(idBook);
                restituisci.add(date);
                restituisci.add(restituzione);
                restituisci.setSize(350,250);
                restituisci.setLayout(null);
                restituisci.setVisible(true);
                restituisci.setLocationRelativeTo(null);
            }
        });


        JButton libriPrestati = new JButton("Elenco Prestiti");
        libriPrestati.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame elencoPrestati = new JFrame("Elenco Libri");
                String sql = "SELECT * from library.prestito";
                try {
                    Statement statement = connection.createStatement();
                    ResultSet risultati = statement.executeQuery(sql);
                    JTable totPrestati = new JTable();
                    totPrestati.setModel(DbUtils.resultSetToTableModel(risultati));
                    JScrollPane scroll = new JScrollPane(totPrestati);

                    elencoPrestati.add(scroll);
                    elencoPrestati.setSize(800,400);
                    elencoPrestati.setVisible(true);
                    elencoPrestati.setLocationRelativeTo(null);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
       // libriPrestati.setBounds(450,20,120,25);

        JButton libriFuori = new JButton("Libri da restituire");
        libriFuori.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame libriInPrestito = new JFrame("Elenco Libri in Prestito");
                String sql = "SELECT * from library.prestito WHERE prestito.data_restituito IS NULL";
                try {
                    Statement statement = connection.createStatement();
                    ResultSet risultati = statement.executeQuery(sql);
                    JTable totaleLibriFuori = new JTable();
                    totaleLibriFuori.setModel(DbUtils.resultSetToTableModel(risultati));
                    JScrollPane scroll = new JScrollPane(totaleLibriFuori);

                    libriInPrestito.add(scroll);
                    libriInPrestito.setSize(800,400);
                    libriInPrestito.setVisible(true);
                    libriInPrestito.setLocationRelativeTo(null);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        menu.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        menu.add(libri);
        menu.add(utenti);
        menu.add(addUtente);
        menu.add(addLibro);
        menu.add(presta);
        menu.add(restituisci);
        menu.add(libriPrestati);
        menu.add(libriFuori);
        menu.setVisible(true);
        menu.setLayout(null); //necessario definire manualmente posizione e dimensione di ogni componente del frame
        menu.setLocationRelativeTo(null);
    }


}
