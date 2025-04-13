package Vehiculos;

public interface Auto{

    // Implementaciones para auto

    double TarifaHora = 10000;
    default double getTarifa(){
        return TarifaHora;
    }
}