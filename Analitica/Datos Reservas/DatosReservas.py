import csv
import random
from faker import Faker

fake = Faker('es_ES')

reservas = []

for i in range(2000):
    idReserva = i + 500
    idUsuario = i + 1
    idEspacio = i + 1
    fechaReserva = fake.date_between(start_date='-1y', end_date='today')
    idTarifa = i + 1000
    horaInicio = fake.time()
    horaFin = fake.time()
    reservas.append([idReserva, idUsuario, idEspacio, fechaReserva, idTarifa, horaInicio, horaFin])

rutacsv = 'reservas.csv'

with open(rutacsv, mode='w', newline='', encoding='utf-8') as file:
    writer = csv.writer(file)
    writer.writerow(['idReserva', 'idUsuario', 'idEspacio', 'fechaReserva', 'idTarifa', 'horaInicio', 'horaFin'])
    writer.writerows(reservas)