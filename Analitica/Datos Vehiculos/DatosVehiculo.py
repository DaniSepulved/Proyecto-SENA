import csv
import random
from faker import Faker
import random
import json

with open('c:/Users/danie/Desktop/Proyecto SENA/Analitica/Datos Vehiculos/vehiculos.json', 'r', encoding='utf-8') as f:
    vehiculos = json.load(f)

fake = Faker('es_ES')

Colores = ['Rojo', 'Azul', 'Negro', 'Blanco', 'Gris', 'Verde', 'Amarillo', 'Naranja', 'Plateado', 'Café']

Vehiculos = []

for i in range(2000):
    idVehiculo = i + 100
    idUsuario = i + 1
    placa = fake.license_plate()
    tipoVehiculo = random.choice(list(vehiculos.keys()))
    marca = random.choice(list(vehiculos[tipoVehiculo].keys()))
    modelo = random.choice(vehiculos[tipoVehiculo][marca])
    color = random.choice(Colores)
    Vehiculos.append([idVehiculo, idUsuario, placa, tipoVehiculo, marca, modelo, color])

rutacsv = 'vehiculos.csv'

with open('vehiculos.csv', mode='w', newline='', encoding='utf-8') as file:
    writer = csv.writer(file)
    writer.writerow(['idVehiculo', 'idUsuario', 'placa', 'tipoVehiculo', 'marca', 'modelo', 'color'])
    writer.writerows(Vehiculos)