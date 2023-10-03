create table usuarios{
id BIGINT not null auto_increment,
nombre VARCHAR(100) not null,
email VARCHAR(100) not null,
contraseña VARCHAR(300) not null,
primary key(id)
};