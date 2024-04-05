package Model;

import Database.CRUDVuelo;
import Database.ConfigDB;
import Entity.EntityVuelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ModelVuelo implements CRUDVuelo {


    @Override
    public Object insertarVuelo(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        EntityVuelo objModelos = (EntityVuelo) object;

        try {

            String SQL = "INSERT INTO Vuelo(destino,fecha_salida,hora_salida, FK_id_avion) VALUES(?,?,?,?);";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objModelos.getDestino());
            objPrepare.setString(2, objModelos.getFecha_Salida());
            objPrepare.setInt(3,objModelos.getHora_Salida());
            objPrepare.setInt(4,objModelos.getFk_ID_Avion());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objModelos.setID_Vuelo(objResult.getInt(1));
            }

            objPrepare.close();
            JOptionPane.showMessageDialog(null, "El vuelo a sido registrado exitosamente. ツ");


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "( ˘︹˘ ) Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objModelos;
    }

    @Override
    public List<Object> listarVuelo() {
        return null;
    }

    @Override
    public boolean actualizarVuelo(Object object) {
        return false;
    }

    @Override
    public boolean eliminarVuelo(Object object) {
        return false;
    }
}
