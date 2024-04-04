package Model;

import Database.CRUDPasajero;
import Database.ConfigDB;
import Entity.EntityPasajero;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ModelPasajero implements CRUDPasajero {
    @Override
    public Object insertarPasajero(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        EntityPasajero objModelos = (EntityPasajero) object;

        try {

            String SQL = "INSERT INTO Pasajero(nombrePasajero,apellidoPasajero,documento_identidad) VALUES(?,?,?);";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objModelos.getNombrePasajero());
            objPrepare.setString(2, objModelos.getApellidoPasajero());
            objPrepare.setString(3, objModelos.getDocumento_Identidad());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objModelos.setID_Pasajero(objResult.getInt(1));
            }

            objPrepare.close();
            JOptionPane.showMessageDialog(null, "El pasajero a sido registrado sin problemas. ツ");


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "( ˘︹˘ ) Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objModelos;
    }

    @Override
    public List<Object> listarPasajero() {
        Connection objConnection = ConfigDB.openConnection();

        List<Object> listaPasajero = new ArrayList<>();

        try {
            String SQL = "SELECT * FROM Pasajero BY Pasajero.id_Pasajero ASC;";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(SQL);

            ResultSet objResult = (ResultSet) objPrepare.executeQuery();

            while (objResult.next()){
                EntityPasajero objModelos = new EntityPasajero();

                objModelos.setID_Pasajero(objResult.getInt("id_Pasajero"));
                objModelos.setNombrePasajero(objResult.getString("nombrePasajero"));
                objModelos.setApellidoPasajero(objResult.getString("apellidoPasajero"));
                objModelos.setDocumento_Identidad(objResult.getString("documento_identidad"));

                listaPasajero.add(objModelos);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"invalido " + e.getMessage()) ;
        }

        ConfigDB.closeConnection();
        return listaPasajero;
    }

    @Override
    public boolean actualizarPasajero(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        EntityPasajero objModelos = (EntityPasajero) object;

        boolean isUpdated=false;

        try {

            String SQL  = "UPDATE Pasajero SET nombrePasajero = ?, apellidoPasajero = ?, documento_identidad = ? WHERE id_Pasajero = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(SQL,PreparedStatement.RETURN_GENERATED_KEYS);


            objPrepare.setString(1,objModelos.getNombrePasajero());
            objPrepare.setString(2,objModelos.getApellidoPasajero());
            objPrepare.setString(3,objModelos.getDocumento_Identidad());
            objPrepare.setInt(4,objModelos.getID_Pasajero());


            int lineasAfectadas  = objPrepare.executeUpdate();
            if (lineasAfectadas > 0){
                isUpdated= true;
                JOptionPane.showMessageDialog(null,"la actualizacion del pasajero fue un exito. ^_^");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"(T-T) Error: " + e.getMessage());
        }finally {

            ConfigDB.closeConnection();
        }
        return isUpdated;
    }

    @Override
    public boolean eliminarPasajero(Object object) {
        EntityPasajero objModelos = (EntityPasajero) object;


        boolean isDeleted = false;


        Connection objConnection = ConfigDB.openConnection();

        try {

            String SQL = "DELETE FROM Pasajero WHERE  id_Pasajero = ?;";


            PreparedStatement objPrepare = objConnection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);


            objPrepare.setInt(1, objModelos.getID_Pasajero());

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
