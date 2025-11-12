import csv
import pymysql
import bcrypt

conexion = pymysql.connect(host='localhost', user='root', password='4334', db='db_parqueadero')
cursor = conexion.cursor()

# with open('usuarios.csv', newline='', encoding='utf-8') as csvfile:
#     reader = csv.reader(csvfile)
#     next(reader)  # Saltar cabecera
#     for fila in reader:
#         if len(fila) == 6:
#             # Encriptar la contraseña
#             fila[4] = bcrypt.hashpw(fila[4].encode('utf-8'), bcrypt.gensalt(rounds=4)).decode('utf-8')
#             cursor.execute(
#                 'INSERT INTO usuarios (id_usuario, nombre, apellido, email, password, rol) VALUES (%s, %s, %s, %s, %s, %s)',
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
                'INSERT INTO vehiculos (id_vehiculo, id_usuario, placa, tipo_vehiculo, marca, modelo, color) VALUES (%s, %s, %s, %s, %s, %s, %s)',
                fila
            )
        else:
            print("Fila inválida (saltada):", fila)

with open('reservas.csv', newline='', encoding='utf-8') as csvfile:
    reader = csv.reader(csvfile)
    next(reader)
    for fila in reader:
        if len(fila) == 7:
            cursor.execute(
                'INSERT INTO reservas (id_reserva, id_usuario, id_espacio, fecha_reserva, id_tarifa, hora_inicio, hora_fin) VALUES (%s, %s, %s, %s, %s, %s, %s)',
                fila
            )
        else:
            print("Fila inválida (saltada):", fila)

conexion.commit()
conexion.close()