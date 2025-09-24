import csv
import random
from faker import Faker

fake = Faker('es_ES')

tarifas = []

for i in range(2000):
    idTarifa = i + 1000
    tipoVehiculo = random.choice(['Auto', 'Moto', 'Bus'])
    precio = round(random.uniform(10000, 50000), 2)  # Precio entre 10,000 y 50,000
    tarifas.append([idTarifa, tipoVehiculo, precio])
    
rutacsv = 'tarifas.csv'

# Guardar los datos en un archivo CSV
with open(rutacsv, mode='w', newline='', encoding='utf-8') as file:
    writer = csv.writer(file)
    writer.writerow(['idTarifa', 'tipoVehiculo', 'precio'])
    writer.writerows(tarifas)