import csv 
import pymysql

conexion = pymysql.connect(host='localhost', user='root', password='4334', db='db_parqueadero')
cursor = conexion.cursor()

# with open('usuarios.csv ', newline='', encoding='utf-8') as csvfile:
#     reader = csv.reader(csvfile)
#     next(reader)  # Saltar la cabecera
#     for fila in reader:
#         if len(fila) == 6:
#             cursor.execute(
#                 'INSERT INTO usuarios (Id_usuario, Nombre, Apellido, Correo, Contrasenia, Rol) VALUES (%s, %s, %s, %s, %s, %s)',
#                 fila
#             )
#         else:
#             print("Fila inválida (saltada):", fila)

with open('vehiculos.csv', newline='', encoding='utf-8') as csvfile:
    reader = csv.reader(csvfile)
    next(reader)
    for fila in reader:
        if len(fila) == 7:
            cursor.execute(
                'INSERT INTO vehiculos (Id_vehiculo, Id_usuario, Placa, Tipo_Vehiculo, Marca, Modelo, Color) VALUES (%s, %s, %s, %s, %s, %s, %s)',
                fila
            )
        else:
            print("Fila inválida (saltada):", fila)

conexion.commit()
conexion.close()