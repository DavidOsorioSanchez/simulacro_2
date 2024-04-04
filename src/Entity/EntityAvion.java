package Entity;

public class EntityAvion {
    private int ID_Avion;
    private String Modelo;
    private String Capacidad;

    public EntityAvion() {
    }

    public EntityAvion(String modelo, String capacidad) {
        Modelo = modelo;
        Capacidad = capacidad;
    }

    public int getID_Avion() {
        return ID_Avion;
    }

    public void setID_Avion(int id_Avion) {
        ID_Avion = id_Avion;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(String capacidad) {
        Capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "EntityAvion{" +
                "ID_Avion=" + ID_Avion +
                ", Modelo='" + Modelo + '\'' +
                ", Capacidad='" + Capacidad + '\'' +
                '}';
    }
}
