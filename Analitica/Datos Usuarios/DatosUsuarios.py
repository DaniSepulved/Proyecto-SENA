import csv
import random
from faker import Faker

fake = Faker('es_ES')

roles = ['Cliente', 'Empleado']

usuarios = []

for i in range(2000):
    Id_usuario = i + 1
    Nombre = fake.name()
    Apellido = fake.last_name()
    Correo = fake.email()
    Contrasenia = fake.password(length=10)
    rol = random.choice(roles)
    usuarios.append([Id_usuario, Nombre, Apellido, Correo, Contrasenia, rol])

rutacsv = 'usuarios.csv'    

# Guardar los datos en un archivo CSV
with open('usuarios.csv', mode='w', newline='', encoding='utf-8') as file:
    writer = csv.writer(file)
    writer.writerow(['Id_usuario', 'Nombre', 'Apellido', 'Correo', 'Contrasenia', 'Rol'])
    writer.writerows(usuarios)
    