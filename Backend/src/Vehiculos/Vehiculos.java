package Vehiculos;

public class Vehiculos implements Bus, Moto, Auto{
    private String Id_vehiculo;
    private int Id_usuario;
    private String Placa;
    private String Marca;
    private String Modelo;

    // Constructor

    public Vehiculos(String id_vehiculo, int id_usuario, String placa, String marca, String modelo) {
        Id_vehiculo = id_vehiculo;
        Id_usuario = id_usuario;
        Placa = placa;
        Marca = marca;
        Modelo = modelo;
    }

    // Getters y Setters

    public String getId_vehiculo() {
        return Id_vehiculo;
    }

    public void setId_vehiculo(String id_vehiculo) {
        Id_vehiculo = id_vehiculo;
    }

    public int getId_usuario() {
        return Id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        Id_usuario = id_usuario;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }


    // Implementación de la interfaz Auto

    @Override
    public double getTarifa() {
        return Auto.TarifaHora;
    }
}
