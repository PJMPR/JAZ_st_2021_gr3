CREATE TABLE CREDIT (
    id INT AUTO_INCREMENT PRIMARY KEY,
    amount decimal (10, 4) NOT NULL,
    installmentCount int (10) NOT NULL,
    installmentType varchar (10) NOT NULL,
    percentage decimal (10, 10) NOT NULL,
    fixedRate decimal (10, 10) NOT NULL
);