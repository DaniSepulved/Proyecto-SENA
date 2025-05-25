create database db_parquedero;
use db_parquedero;

create table Usuarios(
	Id_usuario int auto_increment primary key,
    Nombre varchar(30) not null,
    Apellido varchar(30) not null,
    Email varchar(250) not null,
    Password varchar(250) not null,
    Rol enum('Cliente', 'Empleado', 'Administrador') not null
);

create table Vehiculos(
    Id_vehiculo int auto_increment primary key,
    Id_usuario int not null,
    foreign key (Id_usuario) references Usuarios(Id_usuario),
    Placa varchar(10) unique not null,
    Tipo_Vehiculo enum('Auto', 'Moto', 'Bus', 'Bicicleta') not null,
    Marca varchar(30) not null,
    Modelo varchar(30) not null,
    Color varchar(30) not null
);

create table Espacios_Parqueo(
    Id_Espacio int auto_increment primary key,
    Ubicacion varchar(50) not null,
    Numero_Espacio int not null
);

create table Reservas(
    Id_Reserva int auto_increment primary key,
    Id_usuario int not null,
    foreign key (Id_usuario) references Usuarios(Id_usuario),
    Id_Espacio int not null,
    foreign key (Id_Espacio) references Espacios_Parqueo(Id_Espacio),
    Fecha_Reserva date not null,
    Hora_Inicio datetime not null,
    Hora_Fin datetime not null
);

create table Tarifas(
    Id_Tarifa int auto_increment primary key,
    Tipo_Vehiculo enum('Auto', 'Moto', 'Bus') not null,
    Costo_Hora decimal(10,2) not null,
    Costo_Dia decimal(10,2) not null
);

create table Pagos(
    Id_Pago int auto_increment primary key,
    Id_Reserva int not null,
    foreign key (Id_Reserva) references Reservas(Id_Reserva),
    Monto decimal(10,2) not null,
    Fecha_Pago date not null,
    Metodo_Pago enum('Efectivo', 'Tarjeta de Crédito', 'Transferencia') not null
);