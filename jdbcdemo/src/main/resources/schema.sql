CREATE TABLE account
(
    id bigint NOT NULL,
    type varchar(50) NOT NULL,
    status varchar(50) NOT NULL,
    balance decimal(20,2) NOT NULL,
    PRIMARY KEY (id)
);
