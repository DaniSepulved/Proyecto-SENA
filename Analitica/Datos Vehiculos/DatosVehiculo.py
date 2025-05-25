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
    Id_Vehiculo = i + 100
    Id_Usuario = i + 1
    Placa = fake.license_plate()
    Tipo_vehiculo = random.choice(list(vehiculos.keys()))
    Marca = random.choice(list(vehiculos[Tipo_vehiculo].keys()))
    Modelo = random.choice(vehiculos[Tipo_vehiculo][Marca])
    Color = random.choice(Colores)
    Vehiculos.append([Id_Vehiculo, Id_Usuario, Placa, Tipo_vehiculo, Marca, Modelo, Color])

rutacsv = 'vehiculos.csv'

with open('vehiculos.csv', mode='w', newline='', encoding='utf-8') as file:
    writer = csv.writer(file)
    writer.writerow(['Id_Vehiculo', 'Id_Usuario', 'Placa', 'Tipo_vehiculo', 'Marca', 'Modelo', 'Color'])
    writer.writerows(Vehiculos)