import csv
import random
from faker import Faker


fake = Faker('es_ES')

Pagos = []

Metodo_Pago = ['Tarjeta de crédito', 'Transferencia', 'Efectivo', ]

for i in range(2000):
    Id_Pago = i + 1
    Id_Reserva = i + 1000
    Monto = round(random.uniform(5000, 1000000), 2)
    Fecha_Pago = fake.date_between(start_date='-1y', end_date='today')
    Metodo_Pago = random.choice(Metodo_Pago)
    Pagos.append([Id_Pago, Id_Reserva, Monto, Fecha_Pago, Metodo_Pago])

rutacsv = 'pagos.csv'

with open(rutacsv, mode='w', newline='', encoding='utf-8') as file:
    writer = csv.writer(file)
    writer.writerow(['Id_Pago', 'Id_Reserva', 'Monto', 'Fecha_Pago', 'Metodo_Pago'])
    writer.writerows(Pagos)