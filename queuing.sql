-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 15, 2020 at 05:42 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `queuing`
--

-- --------------------------------------------------------

--
-- Table structure for table `ad_tbl`
--

CREATE TABLE `ad_tbl` (
  `ID` int(11) NOT NULL,
  `Ad_num` varchar(225) NOT NULL,
  `Client` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ad_ticket`
--

CREATE TABLE `ad_ticket` (
  `ID` int(11) NOT NULL,
  `Ticket` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `assessment_tbl`
--

CREATE TABLE `assessment_tbl` (
  `ID` int(11) NOT NULL,
  `Assessment_num` varchar(225) NOT NULL,
  `Client` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `asse_ticket`
--

CREATE TABLE `asse_ticket` (
  `ID` int(11) NOT NULL,
  `Ticket` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `cashier_tbl`
--

CREATE TABLE `cashier_tbl` (
  `ID` int(11) NOT NULL,
  `Cashier_num` varchar(225) NOT NULL,
  `Client` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cash_ticket`
--

CREATE TABLE `cash_ticket` (
  `ID` int(11) NOT NULL,
  `Ticket` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `dis_ad_tbl`
--

CREATE TABLE `dis_ad_tbl` (
  `ID` int(11) NOT NULL,
  `Ad_num` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `dis_asse1_tbl`
--

CREATE TABLE `dis_asse1_tbl` (
  `ID` int(11) NOT NULL,
  `Assessment_num` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dis_asse2_tbl`
--

CREATE TABLE `dis_asse2_tbl` (
  `ID` int(11) NOT NULL,
  `Assessment_num` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dis_cash1_tbl`
--

CREATE TABLE `dis_cash1_tbl` (
  `ID` int(11) NOT NULL,
  `Cashier_num` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dis_cash2_tbl`
--

CREATE TABLE `dis_cash2_tbl` (
  `ID` int(11) NOT NULL,
  `Cashier_num` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dis_enco1_tbl`
--

CREATE TABLE `dis_enco1_tbl` (
  `ID` int(11) NOT NULL,
  `Encoding_num` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dis_enco2_tbl`
--

CREATE TABLE `dis_enco2_tbl` (
  `ID` int(11) NOT NULL,
  `Encoding_num` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dis_enco3_tbl`
--

CREATE TABLE `dis_enco3_tbl` (
  `ID` int(11) NOT NULL,
  `Encoding_num` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dis_esd_tbl`
--

CREATE TABLE `dis_esd_tbl` (
  `ID` int(11) NOT NULL,
  `Esd_num` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `dis_fd_tbl`
--

CREATE TABLE `dis_fd_tbl` (
  `ID` int(11) NOT NULL,
  `Fd_num` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `dis_marn_tbl`
--

CREATE TABLE `dis_marn_tbl` (
  `ID` int(11) NOT NULL,
  `Marine_num` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dis_opm_tbl`
--

CREATE TABLE `dis_opm_tbl` (
  `ID` int(11) NOT NULL,
  `Opm_num` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `dis_ppd_tbl`
--

CREATE TABLE `dis_ppd_tbl` (
  `ID` int(11) NOT NULL,
  `Ppd_num` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `dis_psd_tbl`
--

CREATE TABLE `dis_psd_tbl` (
  `ID` int(11) NOT NULL,
  `Psd_num` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `dis_term_tbl`
--

CREATE TABLE `dis_term_tbl` (
  `ID` int(11) NOT NULL,
  `Terminal_num` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `encoding_tbl`
--

CREATE TABLE `encoding_tbl` (
  `ID` int(11) NOT NULL,
  `Encoding_num` varchar(225) NOT NULL,
  `Client` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `enco_ticket`
--

CREATE TABLE `enco_ticket` (
  `ID` int(11) NOT NULL,
  `Ticket` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `esd_tbl`
--

CREATE TABLE `esd_tbl` (
  `ID` int(11) NOT NULL,
  `Esd_num` varchar(225) NOT NULL,
  `Client` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `esd_ticket`
--

CREATE TABLE `esd_ticket` (
  `ID` int(11) NOT NULL,
  `Ticket` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `exchange_tbl`
--

CREATE TABLE `exchange_tbl` (
  `ID` int(11) NOT NULL,
  `Rate` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `exchange_tbl`
--

INSERT INTO `exchange_tbl` (`ID`, `Rate`, `Date`, `Time`) VALUES
(1, '50.5040', '02/14/2020', '1:21:53 PM'),
(2, '50.5556', '02/15/2020', '15:01:35');

-- --------------------------------------------------------

--
-- Table structure for table `fd_tbl`
--

CREATE TABLE `fd_tbl` (
  `ID` int(11) NOT NULL,
  `Fd_num` varchar(225) NOT NULL,
  `Client` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `fd_ticket`
--

CREATE TABLE `fd_ticket` (
  `ID` int(11) NOT NULL,
  `Ticket` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `marine_tbl`
--

CREATE TABLE `marine_tbl` (
  `ID` int(11) NOT NULL,
  `Marine_num` varchar(225) NOT NULL,
  `Client` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `marn_ticket`
--

CREATE TABLE `marn_ticket` (
  `ID` int(11) NOT NULL,
  `Ticket` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `opm_tbl`
--

CREATE TABLE `opm_tbl` (
  `ID` int(11) NOT NULL,
  `Opm_num` varchar(225) NOT NULL,
  `Client` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `opm_ticket`
--

CREATE TABLE `opm_ticket` (
  `ID` int(11) NOT NULL,
  `Ticket` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ppd_tbl`
--

CREATE TABLE `ppd_tbl` (
  `ID` int(11) NOT NULL,
  `Ppd_num` varchar(225) NOT NULL,
  `Client` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ppd_tbl`
--

INSERT INTO `ppd_tbl` (`ID`, `Ppd_num`, `Client`, `Date`, `Time`) VALUES
(1, 'PPD-1', 'dsa', '02/15/2020', 'R20:37:15');

-- --------------------------------------------------------

--
-- Table structure for table `ppd_ticket`
--

CREATE TABLE `ppd_ticket` (
  `ID` int(11) NOT NULL,
  `Ticket` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ppd_ticket`
--

INSERT INTO `ppd_ticket` (`ID`, `Ticket`) VALUES
(1, 'PPD-1');

-- --------------------------------------------------------

--
-- Table structure for table `priority_tbl`
--

CREATE TABLE `priority_tbl` (
  `ID` int(11) NOT NULL,
  `Priority_num` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `prio_ticket`
--

CREATE TABLE `prio_ticket` (
  `ID` int(11) NOT NULL,
  `Ticket` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `psd_tbl`
--

CREATE TABLE `psd_tbl` (
  `ID` int(11) NOT NULL,
  `Psd_num` varchar(225) NOT NULL,
  `Client` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `psd_ticket`
--

CREATE TABLE `psd_ticket` (
  `ID` int(11) NOT NULL,
  `Ticket` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `role_tbl`
--

CREATE TABLE `role_tbl` (
  `ID` int(11) NOT NULL,
  `Role` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role_tbl`
--

INSERT INTO `role_tbl` (`ID`, `Role`, `Date`) VALUES
(8, '--SELECT ROLE--', ''),
(9, 'SITE ADMIN', ''),
(10, 'ASSESSMENT', ''),
(11, 'ENCODING', ''),
(12, 'MARINE', ''),
(13, 'CASHIER', ''),
(15, 'TERMINAL', ''),
(17, 'AD-Records', ''),
(18, 'FD-Disbursement', ''),
(19, 'OPM-Permits', ''),
(20, 'PSD-Safety', ''),
(21, 'PPD', ''),
(22, 'ESD', '');

-- --------------------------------------------------------

--
-- Table structure for table `terminal_tbl`
--

CREATE TABLE `terminal_tbl` (
  `ID` int(225) NOT NULL,
  `Terminal_num` varchar(225) NOT NULL,
  `Client` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `term_ticket`
--

CREATE TABLE `term_ticket` (
  `ID` int(11) NOT NULL,
  `Ticket` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user_tbl`
--

CREATE TABLE `user_tbl` (
  `ID` int(11) NOT NULL,
  `Employee_ID` varchar(225) NOT NULL,
  `Employee_Name` varchar(225) NOT NULL,
  `Role` varchar(225) NOT NULL,
  `Password` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_tbl`
--

INSERT INTO `user_tbl` (`ID`, `Employee_ID`, `Employee_Name`, `Role`, `Password`) VALUES
(2, '0359-2020', 'Cris admin', 'SITE ADMIN', 'open'),
(4, '00361-2020', 'kurisuu', 'TERMINAL', 'open'),
(5, '0362-2020', 'cris', 'MARINE', 'open'),
(6, '0363-2020', 'cris', 'ENCODING', 'open'),
(7, '0364-2020', 'Cris', 'CASHIER', 'open'),
(8, '0365-2020', 'cris', 'ASSESSMENT', 'open'),
(9, 'test1111', 'cccc', 'AD-Records', 'open'),
(10, 'test111', 'ccccc', 'FD-Disbursement', 'open'),
(11, 'test2222', 'ccccc', 'OPM-Permits', 'open'),
(12, 'test2222', 'cccc', 'PSD-Safety', 'open'),
(13, 'tes22332', 'ccsscs', 'PPD', 'open'),
(14, 'test2324435', 'dasdasda', 'ESD', 'open');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ad_tbl`
--
ALTER TABLE `ad_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `ad_ticket`
--
ALTER TABLE `ad_ticket`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `assessment_tbl`
--
ALTER TABLE `assessment_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `asse_ticket`
--
ALTER TABLE `asse_ticket`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `cashier_tbl`
--
ALTER TABLE `cashier_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `cash_ticket`
--
ALTER TABLE `cash_ticket`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `dis_ad_tbl`
--
ALTER TABLE `dis_ad_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `dis_asse1_tbl`
--
ALTER TABLE `dis_asse1_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `dis_asse2_tbl`
--
ALTER TABLE `dis_asse2_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `dis_cash1_tbl`
--
ALTER TABLE `dis_cash1_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `dis_cash2_tbl`
--
ALTER TABLE `dis_cash2_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `dis_enco1_tbl`
--
ALTER TABLE `dis_enco1_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `dis_enco2_tbl`
--
ALTER TABLE `dis_enco2_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `dis_enco3_tbl`
--
ALTER TABLE `dis_enco3_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `dis_esd_tbl`
--
ALTER TABLE `dis_esd_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `dis_fd_tbl`
--
ALTER TABLE `dis_fd_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `dis_marn_tbl`
--
ALTER TABLE `dis_marn_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `dis_opm_tbl`
--
ALTER TABLE `dis_opm_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `dis_ppd_tbl`
--
ALTER TABLE `dis_ppd_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `dis_psd_tbl`
--
ALTER TABLE `dis_psd_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `dis_term_tbl`
--
ALTER TABLE `dis_term_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `encoding_tbl`
--
ALTER TABLE `encoding_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `enco_ticket`
--
ALTER TABLE `enco_ticket`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `esd_tbl`
--
ALTER TABLE `esd_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `esd_ticket`
--
ALTER TABLE `esd_ticket`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `exchange_tbl`
--
ALTER TABLE `exchange_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `fd_tbl`
--
ALTER TABLE `fd_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `fd_ticket`
--
ALTER TABLE `fd_ticket`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `marine_tbl`
--
ALTER TABLE `marine_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `marn_ticket`
--
ALTER TABLE `marn_ticket`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `opm_tbl`
--
ALTER TABLE `opm_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `opm_ticket`
--
ALTER TABLE `opm_ticket`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `ppd_tbl`
--
ALTER TABLE `ppd_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `ppd_ticket`
--
ALTER TABLE `ppd_ticket`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `priority_tbl`
--
ALTER TABLE `priority_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `prio_ticket`
--
ALTER TABLE `prio_ticket`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `psd_tbl`
--
ALTER TABLE `psd_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `psd_ticket`
--
ALTER TABLE `psd_ticket`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `role_tbl`
--
ALTER TABLE `role_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `terminal_tbl`
--
ALTER TABLE `terminal_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `term_ticket`
--
ALTER TABLE `term_ticket`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user_tbl`
--
ALTER TABLE `user_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ad_tbl`
--
ALTER TABLE `ad_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ad_ticket`
--
ALTER TABLE `ad_ticket`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `assessment_tbl`
--
ALTER TABLE `assessment_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `asse_ticket`
--
ALTER TABLE `asse_ticket`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cashier_tbl`
--
ALTER TABLE `cashier_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cash_ticket`
--
ALTER TABLE `cash_ticket`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `dis_ad_tbl`
--
ALTER TABLE `dis_ad_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `dis_asse1_tbl`
--
ALTER TABLE `dis_asse1_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `dis_asse2_tbl`
--
ALTER TABLE `dis_asse2_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `dis_cash1_tbl`
--
ALTER TABLE `dis_cash1_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `dis_cash2_tbl`
--
ALTER TABLE `dis_cash2_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `dis_enco1_tbl`
--
ALTER TABLE `dis_enco1_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `dis_enco2_tbl`
--
ALTER TABLE `dis_enco2_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `dis_enco3_tbl`
--
ALTER TABLE `dis_enco3_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `dis_esd_tbl`
--
ALTER TABLE `dis_esd_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `dis_fd_tbl`
--
ALTER TABLE `dis_fd_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `dis_marn_tbl`
--
ALTER TABLE `dis_marn_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `dis_opm_tbl`
--
ALTER TABLE `dis_opm_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `dis_ppd_tbl`
--
ALTER TABLE `dis_ppd_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `dis_psd_tbl`
--
ALTER TABLE `dis_psd_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `dis_term_tbl`
--
ALTER TABLE `dis_term_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `encoding_tbl`
--
ALTER TABLE `encoding_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `enco_ticket`
--
ALTER TABLE `enco_ticket`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `esd_tbl`
--
ALTER TABLE `esd_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `esd_ticket`
--
ALTER TABLE `esd_ticket`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `exchange_tbl`
--
ALTER TABLE `exchange_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `fd_tbl`
--
ALTER TABLE `fd_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `fd_ticket`
--
ALTER TABLE `fd_ticket`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `marine_tbl`
--
ALTER TABLE `marine_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `marn_ticket`
--
ALTER TABLE `marn_ticket`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `opm_tbl`
--
ALTER TABLE `opm_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `opm_ticket`
--
ALTER TABLE `opm_ticket`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ppd_tbl`
--
ALTER TABLE `ppd_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `ppd_ticket`
--
ALTER TABLE `ppd_ticket`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `priority_tbl`
--
ALTER TABLE `priority_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `prio_ticket`
--
ALTER TABLE `prio_ticket`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `psd_tbl`
--
ALTER TABLE `psd_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `psd_ticket`
--
ALTER TABLE `psd_ticket`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role_tbl`
--
ALTER TABLE `role_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `terminal_tbl`
--
ALTER TABLE `terminal_tbl`
  MODIFY `ID` int(225) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `term_ticket`
--
ALTER TABLE `term_ticket`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user_tbl`
--
ALTER TABLE `user_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
