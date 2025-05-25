import csv
import random
from faker import Faker

fake = Faker('es_ES')

reservas = []

for i in range(2000):
    Id_Reserva = i + 500
    Id_Usuario = i + 1
    Id_Espacio = i + 1
    Fecha_Reserva = fake.date_between(start_date='-1y', end_date='today')
    Hora_Inicios = fake.time()
    Hora_Fin = fake.time()
    reservas.append([Id_Reserva, Id_Usuario, Id_Espacio, Fecha_Reserva, Hora_Inicios, Hora_Fin])

rutacsv = 'reservas.csv'

with open(rutacsv, mode='w', newline='', encoding='utf-8') as file:
    writer = csv.writer(file)
    writer.writerow(['Id_Reserva', 'Id_Usuario', 'Id_Espacio', 'Fecha_Reserva', 'Hora_Inicio', 'Hora_Fin'])
    writer.writerows(reservas)