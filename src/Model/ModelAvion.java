package Model;

import Database.CRUDAvion;
import Database.ConfigDB;
import Entity.EntityAvion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ModelAvion implements CRUDAvion {


    @Override
    public Object insertarAvion(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        EntityAvion objModelos = (EntityAvion) object;

        try {

            String SQL = "INSERT INTO Avion(modelo,capacidad) VALUES(?,?);";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objModelos.getModelo());
            objPrepare.setInt(2, objModelos.getCapacidad());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objModelos.setID_Avion(objResult.getInt(1));
            }

            objPrepare.close();
            JOptionPane.showMessageDialog(null, "El avion a sido añadido sin problemas. ツ");


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "( ˘︹˘ ) Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objModelos;
    }

    @Override
    public List<Object> listarAvion() {
        Connection objConnection = ConfigDB.openConnection();

        List<Object> listaAvion = new ArrayList<>();


        try {

            String SQL = "SELECT * FROM Avion ORDER BY Avion.id_Avion ASC;";

            PreparedStatement objPrepareStatement = (PreparedStatement) objConnection.prepareStatement(SQL);

            ResultSet objResult = (ResultSet) objPrepareStatement.executeQuery();

            while (objResult.next()) {

                EntityAvion objModelos = new EntityAvion();

                objModelos.setID_Avion(objResult.getInt("id_Avion"));
                objModelos.setModelo(objResult.getString("modelo"));
                objModelos.setCapacidad(objResult.getInt("capacidad"));

                listaAvion.add(objModelos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ಠ_ಠ Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return listaAvion;
    }

    @Override
    public boolean actualizarAvion(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        EntityAvion objModelos = (EntityAvion) object;

        boolean isUpdated=false;

        try {

            String SQL  = "UPDATE Avion SET modelo = ?, capacidad = ? WHERE id_Avion = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(SQL,PreparedStatement.RETURN_GENERATED_KEYS);


            objPrepare.setString(1,objModelos.getModelo());
            objPrepare.setInt(2,objModelos.getCapacidad());
            objPrepare.setInt(3,objModelos.getID_Avion());


            int lineasAfectadas  = objPrepare.executeUpdate();
            if (lineasAfectadas > 0){
                isUpdated= true;
                JOptionPane.showMessageDialog(null,"la actualizacion de los avion fue un exito. ^_^");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"(T-T) Error: " + e.getMessage());
        }finally {

            ConfigDB.closeConnection();
        }
        return isUpdated;
    }

    @Override
    public boolean eliminarAvion(Object object) {
        EntityAvion objModelos = (EntityAvion) object;


        boolean isDeleted = false;


        Connection objConnection = ConfigDB.openConnection();

        try {

            String SQL = "DELETE FROM Avion WHERE  id_Avion = ?;";


            PreparedStatement objPrepare = objConnection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);


            objPrepare.setInt(1, objModelos.getID_Avion());

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
