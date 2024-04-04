package Controller;

import Entity.EntityPasajero;
import Model.ModelPasajero;
import Util.Iterador;

import javax.swing.*;
import java.util.List;

public class PasajeroController {
    //    insertar
    public static void insert(){
        String nombre = JOptionPane.showInputDialog(null,"ingresa el nombre del pasajero");
        String apellido = JOptionPane.showInputDialog(null,"ingresa el apellido del pasajero");
        String documento = JOptionPane.showInputDialog(null,"ingresa el documento del pasajero");
        instaceModel().insertarPasajero(new EntityPasajero(nombre, apellido, documento));
    }

    //    crear una nueva instancia
    public static ModelPasajero instaceModel(){
        return new ModelPasajero();
    }

//    obtener

    public static  void listar(){

        String list = listar(instaceModel().listarPasajero());

        JOptionPane.showMessageDialog(null, list);
    }

    //    listar
    public static String listar(List<Object> listado){
        String lista = "Listado de aviones";

        for (Object obj : listado){
            EntityPasajero objModelos = (EntityPasajero) obj;

            lista += objModelos.toString() + "\n";
        }
        return lista;
    }

    //    borrar
    public static void borrar(){
        Object[] options = Iterador.listArray(instaceModel().listarPasajero());

        EntityPasajero objSelected = (EntityPasajero) JOptionPane.showInputDialog(null, "selecciona un pasajero","",JOptionPane.QUESTION_MESSAGE, null,options,options[0]);

        instaceModel().eliminarPasajero(objSelected);
    }

    //    actualizar
    public static void update(){
        Object[] options = Iterador.listArray(instaceModel().listarPasajero());
        EntityPasajero objSelected = (EntityPasajero) JOptionPane.showInputDialog(null, "selecciona el pasajero que se requiera actualizar","",JOptionPane.QUESTION_MESSAGE, null,options,options[0]);
        objSelected.setNombrePasajero(JOptionPane.showInputDialog(null, "Ingresa el nombre del pasajero: ", objSelected.getNombrePasajero()));
        objSelected.setApellidoPasajero(JOptionPane.showInputDialog(null, "Ingresa el apellido del pasajero: ",objSelected.getApellidoPasajero()));
        objSelected.setDocumento_Identidad(JOptionPane.showInputDialog(null, "Ingresa el documento del pasajero: ",objSelected.getDocumento_Identidad()));
        instaceModel().actualizarPasajero(objSelected);
    }
}
