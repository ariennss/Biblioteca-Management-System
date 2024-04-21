Ho creato questo semplice Management System di una Biblioteca per imparare a connettere un programma a un database utilizzando JDBC. <br>
Accanto all'utilizzo di JDBC (che era ciò che volevo principalmente imparare con questo progetto) ho anche implementato una semplice interfaccia grafica, acquisendo così minime basi di Swing. <br>
Ho iniziato questo progetto basandomi su questo progetto esistente (https://www.edureka.co/blog/library-management-system-project-in-java) per poi però modificarne in buona parte la struttura. <br>
La classe LoginManagement genera una prima finestra di login in cui viene richiesto l'inserimento di username e password. <br>
Inserendo il valore "admin" sia nel campo username che nel campo password, si aprirà il menu riservato agli amministratori del programma. <br>
Il menu Admin permette (tramite vari Button) di: <br>
- visualizzare l'elenco completo dei libri; <br>
- visualizzare l'elenco completo degli utenti;<br>
- aggiungere un utente nel database (per ora può solo aggiungere utenti "normali", cioè non-admin);<br>
- aggiungere un nuovo libro nel database;<br>
- prestare un libro a un utente (inserendo ID del libro, ID dell'utente e data del prestito);<br>
- segnalare che un libro è stato restituito (inserendo ID libro, ID utente e data della restituzione);<br>
- visualizzare l'elenco totale dei prestiti (anche dei libri già restituiti);<br>
- visualizzare l'elenco dei libri attualmente in prestito (non ancora restituiti);<br><br>

Tramite il menu Admin è possibile creare un nuovo utente e una nuova password per accedere al menu Utenti; in alternativa è possibile digitare "arianna" come username e "gatto" come password nella finestra di Login per visualizzare il menu degli utenti, che possono semplicemente: <br>
- visualizzare l'elenco dei libri totale; <br>
- visualizzare l'elenco dei libri che hanno preso in prestito; <br>
<br>

Il progetto è work in progress.
<br> Altre cose che vorrei implementare: <br>
- controlli su username e password per evitare SQL Injection;<br>
- nuovi button nella finestra di menu degli utenti per poter cercare un libro per titolo per vedere se è disponibile nella biblioteca e un button per cercare l'elenco dei libri di un determinato autore;<br>
- controllo dei ritardi nella restituzione dei prestiti all'interno del menu Admin.<br>

Attualmente il database utilizzato funziona in locale. Se si vuole provare il programma, è necessario scaricare il file library.sql presente nella repository, creare un database con nome "library" ed importare al suo interno il file library.sql <br>
Successivamente aprire il programma e modificare la funzione connetti() nella classe LoginManagement.java con username e password personali di accesso al database.
