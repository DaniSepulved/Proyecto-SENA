import csv
import random
from faker import Faker

fake = Faker('es_ES')

roles = ['Cliente', 'Empleado']

usuarios = []

for i in range(2000):
    idUsuario = i + 1
    nombre = fake.name()
    apellido = fake.last_name()
    email = fake.email()
    password = fake.password(length=10)
    rol = random.choice(roles)
    usuarios.append([idUsuario, nombre, apellido, email, password, rol])

rutacsv = 'usuarios.csv'    

# Guardar los datos en un archivo CSV
with open('usuarios.csv', mode='w', newline='', encoding='utf-8') as file:
    writer = csv.writer(file)
    writer.writerow(['idUsuario', 'nombre', 'apellido', 'email', 'password', 'rol'])
    writer.writerows(usuarios)
    