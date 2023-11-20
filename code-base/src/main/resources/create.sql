-- write SQL to create a table to match your data model from SystemUser.java
CREATE TABLE SYSTEM_USER
(
    ID BIGINT NOT NULL PRIMARY KEY,
    FIRST_NAME VARCHAR(100) NOT NULL,
    LAST_NAME VARCHAR(100) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL,
    PASSWORD VARCHAR(100) NOT NULL,
    ROLE VARCHAR(100) NOT NULL
);
