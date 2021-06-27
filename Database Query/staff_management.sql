--
-- Database: `staff_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `ID` varchar(30) NOT NULL,
  `Password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`ID`, `Password`) VALUES
('admin', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `Class_id` int(5) NOT NULL,
  `Class_Name` varchar(30) NOT NULL,
  `Basic_pay` int(8) NOT NULL,
  `ta` int(8) NOT NULL,
  `ma` int(8) NOT NULL,
  `ra` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`Class_id`, `Class_Name`, `Basic_pay`, `ta`, `ma`, `ra`) VALUES
(1001, 'Grade A', 50000, 5000, 3000, 1000),
(1002, 'Grade B', 35000, 2000, 1500, 800);

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `s_id` int(20) NOT NULL,
  `Staff_id` int(20) NOT NULL,
  `Month` varchar(20) NOT NULL,
  `Basic_pay` int(20) NOT NULL,
  `ta` int(20) NOT NULL,
  `ma` int(20) NOT NULL,
  `ra` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salary`
--

INSERT INTO `salary` (`s_id`, `Staff_id`, `Month`, `Basic_pay`, `ta`, `ma`, `ra`) VALUES
(100001, 102, 'JANUARY-2021', 30000, 2000, 1500, 800),
(100002, 102, 'FEBRUARY-2021', 35000, 2000, 1500, 800),
(100003, 101, 'JANUARY-2020', 50000, 5000, 3000, 2000),
(100004, 103, 'JANUARY-2021', 50000, 5000, 3000, 500),
(100005, 101, 'JANUARY-2021', 50000, 5000, 3000, 1000);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `Staff_id` int(5) NOT NULL,
  `Class_id` int(5) NOT NULL,
  `Name` char(50) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Mobile` bigint(11) NOT NULL,
  `Degree` varchar(20) NOT NULL,
  `Designation` varchar(20) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `City` varchar(20) NOT NULL,
  `DOB` varchar(20) NOT NULL,
  `Gender` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`Staff_id`, `Class_id`, `Name`, `Email`, `Mobile`, `Degree`, `Designation`, `Address`, `City`, `DOB`, `Gender`) VALUES
(101, 1001, 'Abhi', 'ashi@gmail.com', 8759876478, 'Btech', 'Project Manager', '22 Vijay Nagar', 'Mumbai', '6/7/1994', 'Male'),
(102, 1001, 'Lav', 'lav@gmail.com', 8796574325, 'Btech', 'Project Head', '24 Vijay Nagar', 'Indore', '1/4/1987', 'Male'),
(103, 1001, 'Neha', 'nehu@gmail.com', 9876546572, 'btech', 'manager', '23 kalani nagar', 'pune', '1/7/1992', 'Female'),
(104, 1002, 'Ram', 'ram12@gmail.com', 9756748394, 'b.tech', 'Manager', '23 vijay nagar', 'Banglore', '7/7/1998', 'Male'),
(105, 1002, 'Ravina', 'ravin23@gmail.com', 7865467890, 'Bsc', 'Head of department', '34 Vijay Nagar', 'Pune', '19/7/1996', 'Female'),
(106, 1002, 'Kalash Gangwal', 'kalash3030@gmail.com', 8764567892, 'Btech', 'xyz', '23 Vijay Nagar', 'Pune', '6/1/1997', 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE `task` (
  `Task_id` int(10) NOT NULL,
  `Staff_id` int(10) NOT NULL,
  `Assign_date` datetime NOT NULL,
  `Task_name` varchar(50) NOT NULL,
  `Task_description` varchar(200) NOT NULL,
  `Task_status` varchar(20) NOT NULL,
  `Last_update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`Task_id`, `Staff_id`, `Assign_date`, `Task_name`, `Task_description`, `Task_status`, `Last_update_date`) VALUES
(30001, 101, '2021-04-29 20:12:20', 'abc', 'complete these task as soon as possible.', 'Complete', '2021-04-29 22:36:29'),
(30002, 101, '2021-04-29 22:38:54', 'xyz', 'please complete it ', 'Decline', '2021-04-29 22:41:29'),
(30003, 101, '2021-04-29 22:57:14', 'zyt', 'complete this task', 'Complete', '2021-04-29 22:58:09'),
(30004, 104, '2021-05-02 22:44:53', 'LMN', 'complete it before deadline.', 'Complete', '2021-05-02 22:45:56'),
(30005, 101, '2021-05-08 22:34:25', 'ghj', 'wkenffcnwelknclkscnldnd', 'Complete', '2021-05-08 22:35:45'),
(30006, 106, '2021-05-15 12:33:20', 'asksdnd', 'sdfksfmsfv', 'Complete', '2021-05-15 12:34:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`Class_id`);

--
-- Indexes for table `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`s_id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`Staff_id`);

--
-- Indexes for table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`Task_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
