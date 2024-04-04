package Database;

import java.util.List;

public interface CRUDReservacion {

    public Object insertarReservacion(Object object);
    public List<Object> listarReservacion();
    public boolean actualizarReservacion(Object object);
    public boolean eliminarReservacion(Object object);

}
