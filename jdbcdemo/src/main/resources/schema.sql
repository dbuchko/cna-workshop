DROP TABLE IF EXISTS account;

CREATE TABLE account
(
    id long NOT NULL,
    type varchar(50) NOT NULL,
    status varchar(50) NOT NULL,
    balance decimal(20,2) NOT NULL,
    PRIMARY KEY (id)
);
