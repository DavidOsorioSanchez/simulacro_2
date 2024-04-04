package Entity;

public class EntityAvion {
    private int ID_Avion;
    private String Modelo;
    private int Capacidad;

    public EntityAvion() {
    }

    public EntityAvion(String modelo, int capacidad) {
        Modelo = modelo;
        Capacidad = capacidad;
    }

    public int getID_Avion() {
        return ID_Avion;
    }

    public void setID_Avion(int ID_Avion) {
        this.ID_Avion = ID_Avion;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(int capacidad) {
        Capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "EntityAvion{" +
                "ID_Avion=" + ID_Avion +
                ", Modelo='" + Modelo + '\'' +
                ", Capacidad=" + Capacidad +
                '}';
    }
}
