package Database;

import java.util.List;

public interface CRUDVuelo {

    public Object insertarVuelo(Object object);
    public List<Object> listarVuelo();
    public boolean actualizarVuelo(Object object);
    public boolean eliminarVuelo(Object object);

}
