USE ecommerce;

CREATE TABLE `ecommerce`.`customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
  CONSTRAINT customer_pk PRIMARY KEY (`customerid`),
  CONSTRAINT customer_country_fk FOREIGN KEY (country_id)
    REFERENCES country (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE KEY `UNIQUE_INDX1` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `ecommerce`.`country` (
 `id` int NOT NULL,
 `name` varchar(100) NOT NULL,
 CONSTRAINT country PRIMARY KEY (`countryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;