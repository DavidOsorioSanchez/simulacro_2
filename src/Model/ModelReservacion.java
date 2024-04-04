package Model;

import Database.CRUDReservacion;
import Database.ConfigDB;
import Entity.EntityReservacion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ModelReservacion implements CRUDReservacion {

    @Override
    public Object insertarReservacion(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        List<Object> listaReservacion = new ArrayList<>();

        try {
            String SQL = "SELECT * FROM Reservacion BY Reservacion.id_Reservacion ASC;";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(SQL);

            ResultSet objResult = (ResultSet) objPrepare.executeQuery();

            while (objResult.next()){
                EntityReservacion objModelos = new EntityReservacion();

                objModelos.setID_Reservacion(objResult.getInt("id_Reservacion"));
                objModelos.setFecha_reservacion(objResult.getString("fecha_reservacion"));
                objModelos.setAsiento(objResult.getString("asiento"));

                listaReservacion.add(objModelos);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"invalido " + e.getMessage()) ;
        }

        ConfigDB.closeConnection();
        return listaReservacion;
    }

    @Override
    public List<Object> listarReservacion() {
        Connection objConnection = ConfigDB.openConnection();

        List<Object> listaReservacion = new ArrayList<>();

        try {
            String SQL = "SELECT * FROM Reservacion BY Reservacion.id_Reservacion ASC;";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(SQL);

            ResultSet objResult = (ResultSet) objPrepare.executeQuery();

            while (objResult.next()){
                EntityReservacion objModelos = new EntityReservacion();

                objModelos.setID_Reservacion(objResult.getInt("id_Reservacion"));
                objModelos.setFecha_reservacion(objResult.getString("fecha_reservacion"));
                objModelos.setAsiento(objResult.getString("asiento"));

                listaReservacion.add(objModelos);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"invalido " + e.getMessage()) ;
        }

        ConfigDB.closeConnection();
        return listaReservacion;
    }

    @Override
    public boolean actualizarReservacion(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        EntityReservacion objModelos = (EntityReservacion) object;

        boolean isUpdated=false;

        try {

            String SQL  = "UPDATE Reservacion SET fecha_reservacion = ?, asiento = ? WHERE id_Reservacion = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(SQL,PreparedStatement.RETURN_GENERATED_KEYS);


            objPrepare.setString(1,objModelos.getFecha_reservacion());
            objPrepare.setString(2,objModelos.getAsiento());
            objPrepare.setInt(4,objModelos.getID_Reservacion());


            int lineasAfectadas  = objPrepare.executeUpdate();
            if (lineasAfectadas > 0){
                isUpdated= true;
                JOptionPane.showMessageDialog(null,"la actualizacion de la reservacion fue un exito. ^_^");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"(T-T) Error: " + e.getMessage());
        }finally {

            ConfigDB.closeConnection();
        }
        return isUpdated;
    }

    @Override
    public boolean eliminarReservacion(Object object) {
        EntityReservacion objModelos = (EntityReservacion) object;


        boolean isDeleted = false;


        Connection objConnection = ConfigDB.openConnection();

        try {

            String SQL = "DELETE FROM Reservacion WHERE  id_Reservacion = ?;";


            PreparedStatement objPrepare = objConnection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);


            objPrepare.setInt(1, objModelos.getID_Reservacion());

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
