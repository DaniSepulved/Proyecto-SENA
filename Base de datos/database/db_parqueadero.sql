create database db_parquedero;
use db_parquedero;

create table Usuarios(
	Id_usuario int auto_increment primary key,
    Nombre varchar(30) not null,
    Apellido varchar(30) not null,
    Correo varchar(250) not null,
    Contrasenia varchar(250) not null,
    Rol enum('Cliente', 'Empleado', 'Administrador') not null
);

create table Vehiculos(
    Id_vehiculo int auto_increment primary key,
    Placa varchar(10) not null,
    Marca varchar(30) not null,
    Modelo varchar(30) not null,
    Color varchar(30) not null,
    Id_usuario int not null,
    foreign key (Id_usuario) references Usuarios(Id_usuario)
);

create table Espacios_Parqueo(
    Id_Espacio int auto_increment primary key,
    Ubicacion varchar(50) not null,
    Numero_Espacio int not null,
)