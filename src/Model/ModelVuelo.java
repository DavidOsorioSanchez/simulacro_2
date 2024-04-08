package Model;

import Database.CRUDVuelo;
import Database.ConfigDB;
import Entity.EntityAvion;
import Entity.EntityPasajero;
import Entity.EntityVuelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelVuelo implements CRUDVuelo {


    @Override
    public Object insertarVuelo(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        EntityVuelo objModelos = (EntityVuelo) object;

        try {

            String SQL = "INSERT INTO Vuelo(destino,fecha_salida,hora_salida, FK_id_avion) VALUES(?,?,?,?);";

            PreparedStatement objPrepare = objConnection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

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

        Connection objConnection = ConfigDB.openConnection();

        List<Object> listaVuelo = new ArrayList<>();

        try {
            String SQL = "SELECT * FROM Vuelo ORDER BY Vuelo.destino ASC;";

            PreparedStatement objPrepare = objConnection.prepareStatement(SQL);

            ResultSet objResult = (ResultSet) objPrepare.executeQuery();

            while (objResult.next()){
                EntityVuelo objModelos = new EntityVuelo();

                objModelos.setID_Vuelo(objResult.getInt("id_Vuelo"));
                objModelos.setDestino(objResult.getString("destino"));
                objModelos.setFecha_Salida(objResult.getString("fecha_salida"));
                objModelos.setHora_Salida(objResult.getInt("hora_salida"));
                objModelos.setFk_ID_Avion(objResult.getInt("FK_id_avion"));

                listaVuelo.add(objModelos);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"invalido " + e.getMessage()) ;
        }

        ConfigDB.closeConnection();
        return listaVuelo;
    }

    @Override
    public boolean actualizarVuelo(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        EntityVuelo objModelos = (EntityVuelo)object;

        boolean isUpdated=false;

        try {

            String SQL  = "UPDATE Vuelo SET destino = ?, fecha_salida = ?, hora_salida = ?, FK_id_avion = ?; ";

            PreparedStatement objPrepare = objConnection.prepareStatement(SQL);


            objPrepare.setString(1,objModelos.getDestino());
            objPrepare.setString(2,objModelos.getFecha_Salida());
            objPrepare.setInt(3,objModelos.getHora_Salida());
            objPrepare.setInt(4,objModelos.getFk_ID_Avion());


            int lineasAfectadas  = objPrepare.executeUpdate();
            if (lineasAfectadas > 0){
                isUpdated= true;
                JOptionPane.showMessageDialog(null,"la actualizacion fue exitosa. ^_^");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"(T-T) Error: " + e.getMessage());
        }finally {

            ConfigDB.closeConnection();
        }
        return isUpdated;
    }

    @Override
    public boolean eliminarVuelo(Object object) {
        EntityVuelo objModelos = (EntityVuelo) object;


        boolean isDeleted = false;


        Connection objConnection = ConfigDB.openConnection();

        try {

            String SQL = "DELETE FROM Vuelo WHERE id_Vuelo = ?;";


            PreparedStatement objPrepare = objConnection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);


            objPrepare.setInt(1, objModelos.getID_Vuelo());

            int totalAfectado = objPrepare.executeUpdate();

            if (totalAfectado>0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null, "Se a eliminado efectivamente. (^_^)");
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ಥ_ಥ Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return isDeleted;
    }
}
