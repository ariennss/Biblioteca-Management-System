-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Apr 22, 2024 alle 00:47
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `libro`
--

CREATE TABLE `libro` (
  `ID` int(11) NOT NULL,
  `titolo` varchar(255) NOT NULL,
  `autore` varchar(255) NOT NULL,
  `genere` varchar(255) NOT NULL,
  `disponibilealprestito` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `libro`
--

INSERT INTO `libro` (`ID`, `titolo`, `autore`, `genere`, `disponibilealprestito`) VALUES
(1, 'Hidden Pictures', 'Jason Rekulak', 'Thriller', 1),
(2, 'Harry Potter e la Pietra Filosofale', 'J.K. Rowling', 'Fantasy', 0),
(3, 'The Lord of the Rings: The Fellowship of the Ring', 'J.R.R. Tolkien', 'Fantasy', 1),
(4, 'The Alchemist', 'Paulo Coelho', 'Fantasy', 1),
(5, 'To Kill a Mockingbird', 'Harper Lee', 'Fiction', 1),
(6, 'Pride and Prejudice', 'Jane Austen', 'Romance', 1),
(7, 'One Hundred Years of Solitude', 'Gabriel García Márquez', 'Magical Realism', 1),
(8, 'The Great Gatsby', 'F. Scott Fitzgerald', 'Fiction', 1),
(9, 'Moby Dick', 'Herman Melville', 'Adventure', 1),
(10, 'Harry Potter and the Sorcerer\'s Stone', 'J.K. Rowling', 'Fantasy', 1),
(11, 'The Catcher in the Rye', 'J.D. Salinger', 'Coming-of-Age', 1),
(12, '1984', 'George Orwell', 'Dystopian Fiction', 1),
(13, 'The Handmaid\'s Tale', 'Margaret Atwood', 'Dystopian Fiction', 1),
(14, 'Animal Farm', 'George Orwell', 'Allegorical Fiction', 1),
(15, 'Invisible Man', 'Ralph Ellison', 'Bildungsroman', 1),
(16, 'Fahrenheit 451', 'Ray Bradbury', 'Dystopian Fiction', 1),
(17, 'Crime and Punishment', 'Fyodor Dostoevsky', 'Psychological Fiction', 1),
(18, 'The Metamorphosis', 'Franz Kafka', 'Absurdist Fiction', 1),
(19, 'The Book Thief', 'Markus Zusak', 'Historical Fiction', 1),
(20, 'Gone With the Wind', 'Margaret Mitchell', 'Historical Fiction', 1),
(21, 'The Hitchhiker\'s Guide to the Galaxy', 'Douglas Adams', 'Science Fiction', 1),
(22, 'The Martian', 'Andy Weir', 'Science Fiction', 1),
(23, 'Where the Crawdads Sing', 'Delia Owens', 'Fiction', 1),
(24, 'Americanah', 'Chimamanda Ngozi Adichie', 'Intercultural Fiction', 1),
(25, 'Normal People', 'Sally Rooney', 'Coming-of-Age', 1),
(26, 'A Gentleman in Moscow', 'Amor Towles', 'Historical Fiction', 1),
(27, 'Circe', 'Madeline Miller', 'Mythological Fiction', 1),
(28, 'Project Hail Mary', 'Andy Weir', 'Science Fiction', 1),
(29, 'The House in the Cerulean Sea', 'T.J. Klune', 'Fantasy', 1),
(30, 'Cloud Cuckoo Land', 'Anthony Doerr', 'Historical Fiction', 1),
(31, 'Lessons in Chemistry', 'Bonnie Garmus', 'Historical Fiction', 1),
(32, 'Piranesi', 'Susanna Clarke', 'Fantasy', 1),
(33, 'Shuggie Bain', 'Douglas Stuart', 'Coming-of-Age', 1),
(34, 'The Midnight Library', 'Matt Haig', 'Fantasy', 1),
(35, 'Klara and the Sun', 'Kazuo Ishiguro', 'Science Fiction', 1),
(36, 'The Ministry for the Future', 'Kim Stanley Robinson', 'Science Fiction', 1),
(37, 'The Testaments', 'Margaret Atwood', 'Dystopian Fiction', 1),
(38, 'Exit West', 'Mohsin Hamid', 'Magical Realism', 1),
(39, 'There There', 'Tommy Orange', 'Fiction', 1),
(40, 'Eleanor Oliphant is Completely Fine', 'Gail Honeyman', 'Fiction', 1),
(41, 'Little Fires Everywhere', 'Celeste Ng', 'Fiction', 1),
(42, 'Sapiens: A Brief History of Humankind', 'Yuval Noah Harari', 'Nonfiction', 1),
(43, 'A Brief History of Nearly Everything', 'Bill Bryson', 'Science', 1),
(44, 'The Martian', 'Andy Weir', 'Science Fiction', 1),
(45, 'The Hunger Games', 'Suzanne Collins', 'Dystopian Fiction', 1),
(46, 'Twilight', 'Stephenie Meyer', 'Fantasy Romance', 1),
(47, 'The Fault in Our Stars', 'John Green', 'Coming-of-Age', 1),
(48, 'To All the Boys I\'ve Loved Before', 'Jenny Han', 'Young Adult Fiction', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `prestito`
--

CREATE TABLE `prestito` (
  `ID` int(11) NOT NULL,
  `id_libro` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `data_prestato` date NOT NULL,
  `periodo_prestito` int(11) NOT NULL,
  `data_restituito` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `prestito`
--

INSERT INTO `prestito` (`ID`, `id_libro`, `id_user`, `data_prestato`, `periodo_prestito`, `data_restituito`) VALUES
(5, 2, 1, '2022-09-03', 11, '2023-09-09'),
(7, 2, 4, '2023-09-09', 30, NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `admin` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `user`
--

INSERT INTO `user` (`ID`, `username`, `password`, `admin`) VALUES
(1, 'admin', 'admin', 1),
(3, 'arianna', 'gatto', 0),
(4, 'valentina', 'papera', 0);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `prestito`
--
ALTER TABLE `prestito`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_libro` (`id_libro`);

--
-- Indici per le tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `libro`
--
ALTER TABLE `libro`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT per la tabella `prestito`
--
ALTER TABLE `prestito`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT per la tabella `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `prestito`
--
ALTER TABLE `prestito`
  ADD CONSTRAINT `prestito_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`ID`),
  ADD CONSTRAINT `prestito_ibfk_2` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
