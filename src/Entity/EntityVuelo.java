package Entity;

public class EntityVuelo {

    private int ID_Vuelo;
    private String Destino;
    private String Fecha_Salida;
    private int Hora_Salida;
    private int fk_ID_Avion;
    private EntityAvion avionEntidad;

    public EntityVuelo() {
    }

    public EntityVuelo(String destino, String fecha_Salida, int hora_Salida, int fk_ID_Avion, EntityAvion avionEntidad) {
        Destino = destino;
        Fecha_Salida = fecha_Salida;
        Hora_Salida = hora_Salida;
        this.fk_ID_Avion = fk_ID_Avion;
        this.avionEntidad = avionEntidad;
    }

    public int getID_Vuelo() {
        return ID_Vuelo;
    }

    public void setID_Vuelo(int ID_Vuelo) {
        this.ID_Vuelo = ID_Vuelo;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String destino) {
        Destino = destino;
    }

    public String getFecha_Salida() {
        return Fecha_Salida;
    }

    public void setFecha_Salida(String fecha_Salida) {
        Fecha_Salida = fecha_Salida;
    }

    public int getHora_Salida() {
        return Hora_Salida;
    }

    public void setHora_Salida(int hora_Salida) {
        Hora_Salida = hora_Salida;
    }

    public int getFk_ID_Avion() {
        return fk_ID_Avion;
    }

    public void setFk_ID_Avion(int fk_ID_Avion) {
        this.fk_ID_Avion = fk_ID_Avion;
    }

    public EntityAvion getAvionEntidad() {
        return avionEntidad;
    }

    public void setAvionEntidad(EntityAvion avionEntidad) {
        this.avionEntidad = avionEntidad;
    }

    @Override
    public String toString() {
        return "EntityVuelo{" +
                "ID_Vuelo=" + ID_Vuelo +
                ", Destino='" + Destino + '\'' +
                ", Fecha_Salida='" + Fecha_Salida + '\'' +
                ", Hora_Salida=" + Hora_Salida +
                ", fk_ID_Avion=" + fk_ID_Avion +
                ", avionEntidad=" + avionEntidad +
                '}';
    }
}
