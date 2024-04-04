package Entity;

public class EntityPasajero {

    private int ID_Pasajero;
    private String NombrePasajero;
    private String ApellidoPasajero;
    private String Documento_Identidad;

    public EntityPasajero(String nombrePasajero, String apellidoPasajero, String documento_Identidad) {
        NombrePasajero = nombrePasajero;
        ApellidoPasajero = apellidoPasajero;
        Documento_Identidad = documento_Identidad;
    }

    public int getID_Pasajero() {
        return ID_Pasajero;
    }

    public void setID_Pasajero(int ID_Pasajero) {
        this.ID_Pasajero = ID_Pasajero;
    }

    public String getNombrePasajero() {
        return NombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        NombrePasajero = nombrePasajero;
    }

    public String getApellidoPasajero() {
        return ApellidoPasajero;
    }

    public void setApellidoPasajero(String apellidoPasajero) {
        ApellidoPasajero = apellidoPasajero;
    }

    public String getDocumento_Identidad() {
        return Documento_Identidad;
    }

    public void setDocumento_Identidad(String documento_Identidad) {
        Documento_Identidad = documento_Identidad;
    }

    @Override
    public String toString() {
        return "EntityPasajero{" +
                "ID_Pasajero=" + ID_Pasajero +
                ", NombrePasajero='" + NombrePasajero + '\'' +
                ", ApellidoPasajero='" + ApellidoPasajero + '\'' +
                ", Documento_Identidad='" + Documento_Identidad + '\'' +
                '}';
    }
}

