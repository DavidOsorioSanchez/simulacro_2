package Controller;

import Entity.EntityAvion;
import Model.ModelAvion;
import Util.Iterador;

import javax.swing.*;
import java.util.List;

public class AvionController {
    //    insertar
    public static void insert(){
        String modelo = JOptionPane.showInputDialog(null,"ingresa el modelo del avion");
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog(null,"ingresa la capacidad maxima del avion"));
        instaceModel().insertarAvion(new EntityAvion(modelo, capacidad));
    }

//    crear una nueva instancia
    public static ModelAvion instaceModel(){
        return new ModelAvion();
    }

//    obtener

    public static  void listar(){

        String list = listar(instaceModel().listarAvion());

        JOptionPane.showMessageDialog(null, list);
    }

//    listar
    public static String listar(List<Object> listado){
        String lista = "Listado de aviones";

        for (Object obj : listado){
            EntityAvion objModelos = (EntityAvion) obj;

            lista += objModelos.toString() + "\n";
        }
        return lista;
    }

//    borrar
    public static void borrar(){
        Object[] options = Iterador.listArray(instaceModel().listarAvion());

        EntityAvion objSelected = (EntityAvion) JOptionPane.showInputDialog(null, "selecciona un avion","",JOptionPane.QUESTION_MESSAGE, null,options,options[0]);

        instaceModel().eliminarAvion(objSelected);
    }

//    actualizar
    public static void update(){
        Object[] options = Iterador.listArray(instaceModel().listarAvion());
        EntityAvion objSelected = (EntityAvion) JOptionPane.showInputDialog(null, "selecciona el avion que se requiera actualizar","",JOptionPane.QUESTION_MESSAGE, null,options,options[0]);
        objSelected.setModelo(JOptionPane.showInputDialog(null, "Ingresa el modelo del avion: ", objSelected.getModelo()));
        objSelected.setCapacidad(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la capacidad maxima del avion: ",objSelected.getCapacidad())));
        instaceModel().actualizarAvion(objSelected);
    }
}
