drop table m_user if exists;

create table m_user (
    id INT PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(255) NOT NULL
) engine=InnoDB;

