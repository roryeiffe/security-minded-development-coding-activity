CREATE TABLE IF NOT EXISTS users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100),
    fname VARCHAR(100),
    lname VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    role VARCHAR(100)
);
