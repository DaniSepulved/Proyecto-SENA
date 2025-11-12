import csv
import random
from faker import Faker


fake = Faker('es_ES')

Pagos = []

Metodo_Pago = ['Tarjeta de crédito', 'Transferencia', 'Efectivo', ]

for i in range(2000):
    idPago = i + 1
    idReserva = i + 500
    monto = round(random.uniform(5000, 1000000), 2)
    fechaPago = fake.date_between(start_date='-1y', end_date='today')
    metodoPago = random.choice(Metodo_Pago)
    Pagos.append([idPago, idReserva, monto, fechaPago, metodoPago])

rutacsv = 'pagos.csv'

with open(rutacsv, mode='w', newline='', encoding='utf-8') as file:
    writer = csv.writer(file)
    writer.writerow(['idPago', 'idReserva', 'monto', 'fechaPago', 'metodoPago'])
    writer.writerows(Pagos)