USE dsw;

CREATE TABLE `dsw`.`country` (
 `id` int AUTO_INCREMENT,
 `name` varchar(100) NOT NULL,
 CONSTRAINT country PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `dsw`.`country` (name) VALUES
('españa'),
('alemania'),
('francia');

CREATE TABLE `dsw`.`customer` (
  `id` int(11) AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NULL,
  `birthdate` date NOT NULL,
  `address` varchar(150) NOT NULL,
  `phone_number1` varchar(10) NOT NULL,
  `phone_number2` varchar(10) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `country_id` int,
  `created_at` datetime NOT NULL DEFAULT NOW(),
  CONSTRAINT customer_pk PRIMARY KEY (`id`),
  CONSTRAINT customer_country_fk FOREIGN KEY (country_id)
    REFERENCES country (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT customer_uq_username UNIQUE (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `dsw`.`customer` (
    username,
    password,
    first_name,
    last_name,
    birthdate,
    address,
    phone_number1,
    email,
    country_id
) VALUES
('foo', 'foo', 'john', 'doe', '2000-12-12', 'some address, 12', '333222333', 'johndoe@x.com', 1),
('bar', 'bar', 'jane', 'doe', '1998-12-12', 'another address, 11', '222555777', 'janedoe@x.com', 2);