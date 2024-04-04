package Database;

import java.util.List;

public interface CRUDPasajero {

    public Object insertarPasajero(Object object);
    public List<Object> listarPasajero();
    public boolean actualizarPasajero(Object object);
    public boolean eliminarPasajero(Object object);

}
