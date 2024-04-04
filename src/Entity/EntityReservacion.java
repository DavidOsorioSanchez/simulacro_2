package Entity;

public class EntityReservacion {
    private int ID_Reservacion;
    private String fecha_reservacion;
    private String Asiento;

    public EntityReservacion() {
    }

    public EntityReservacion(String fecha_reservacion, String asiento) {
        this.fecha_reservacion = fecha_reservacion;
        Asiento = asiento;
    }

    public int getID_Reservacion() {
        return ID_Reservacion;
    }

    public void setID_Reservacion(int ID_Reservacion) {
        this.ID_Reservacion = ID_Reservacion;
    }

    public String getFecha_reservacion() {
        return fecha_reservacion;
    }

    public void setFecha_reservacion(String fecha_reservacion) {
        this.fecha_reservacion = fecha_reservacion;
    }

    public String getAsiento() {
        return Asiento;
    }

    public void setAsiento(String asiento) {
        Asiento = asiento;
    }

    @Override
    public String toString() {
        return "EntityReservacion{" +
                "ID_Reservacion=" + ID_Reservacion +
                ", fecha_reservacion='" + fecha_reservacion + '\'' +
                ", Asiento='" + Asiento + '\'' +
                '}';
    }
}
