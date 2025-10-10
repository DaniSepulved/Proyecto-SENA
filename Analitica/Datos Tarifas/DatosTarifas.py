import csv
import random

# Definir rangos de precios en pesos colombianos (COP)
rangosHora = {
    "AUTO": (3000, 6000),
    "MOTO": (1000, 3000),
    "BUS": (5000, 12000),
    "BICICLETA": (500, 1500)
}

rangosDia = {
    "AUTO": (20000, 40000),
    "MOTO": (10000, 20000),
    "BUS": (40000, 80000),
    "BICICLETA": (3000, 8000)
}

tarifas = []

for i in range(2000):
    idTarifa = i + 1000
    tipoVehiculo = random.choice(list(rangosHora.keys()))
    costoHora = random.randint(*rangosHora[tipoVehiculo])
    costoDia = random.randint(*rangosDia[tipoVehiculo])
    tarifas.append([idTarifa, tipoVehiculo, costoHora, costoDia])

# Guardar en CSV con columnas separadas
rutacsv = 'tarifas.csv'

with open(rutacsv, mode='w', newline='', encoding='utf-8') as file:
    writer = csv.writer(file)
    writer.writerow(['idTarifa', 'tipoVehiculo', 'costoHora', 'costoDia'])
    writer.writerows(tarifas)

# print("✅ Archivo 'tarifas.csv' generado correctamente con columnas costoHora y costoDia.")
