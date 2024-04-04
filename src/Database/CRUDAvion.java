package Database;

import java.util.List;

public interface CRUDAvion {

    public Object insertarAvion(Object object);
    public List<Object> listarAvion();
    public boolean actualizarAvion(Object object);
    public boolean eliminarAvion(Object object);

}
