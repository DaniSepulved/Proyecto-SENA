import google.generativeai as genai
from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from pydantic import BaseModel
import requests
import pandas as pd
import uvicorn
# from datetime import datetime, timedelta


genai.configure(api_key="AIzaSyCwgnsvj4MayXej8LHWxhcyc-6E9qim8oo")

app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=["http://localhost:5173"],  # o ["*"] para permitir todo
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

class ChatRequest(BaseModel):
    message: str
    lat: float | None = None
    lon: float | None = None

@app.post("/chat")
def chat(req: ChatRequest):
    msg = req.message.lower()
    
    if "tarifa" in msg or "precio" in msg or "costo" in msg:
        tarifa = requests.get("http://localhost:8080/api/tarifa").json()
        return {"reply": f"Las tarifas actuales son: {tarifa}"}

    if "cercano" in msg or "ubicación" in msg or "lugar" in msg or "carrera" in msg or "calle" in msg:
        direccion = None

        if "carrera" in msg or "mi ubicacion" in msg:
            direccion = msg.lower().split("carrera")[-1].strip() if "carrera" in msg else msg.lower().split("mi ubicacion")[-1].strip()
        
        if direccion:
            link = f"https://www.google.com/maps/search/parqueaderos+cerca+de+{direccion.replace(' ', '+')}"
            return {"reply": f"Aquí tienes los parqueaderos más cercanos a **{direccion}**:\n{link}"}
    
        if req.lat and req.lon:
            return {"reply": f"Buscando ubicaciones cercanas a latitud {req.lat} y longitud {req.lon}..."}
        return {"reply": "Por favor, proporciona tu dirección o tus coordenadas (latitud y longitud) para buscar parqueaderos cercanos."}
    
    if "horario" in msg or "contacto" in msg or "información" in msg:
        return {"reply": "Nuestro horario de atención es de 8 AM a 6 PM de lunes a viernes y de sabado a domingo de 8 AM a 10 PM. Puedes contactarnos al 313-762-0698."}

    model = genai.GenerativeModel("gemini-1.5-flash")
    response = model.generate_content(req.message)
    return {"reply": response.text}

if __name__ == "__main__":
    uvicorn.run("ChatBot:app", host="0.0.0.0", port=5000, reload=True)

# Ejecutar entorno virtual
# ChatBot\Scripts\activate
# python ChatBot.py