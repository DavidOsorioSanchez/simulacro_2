package Controller;

import Entity.EntityAvion;
import Entity.EntityVuelo;
import Model.ModelPasajero;
import Model.ModelVuelo;
import Util.Iterador;

import javax.swing.*;
import java.util.List;

public class VueloController {

    public static void insert() {
        String destiny = JOptionPane.showInputDialog(null, "Digite su destino");
        String date = JOptionPane.showInputDialog(null, "Digite la fecha de su vuelo");
        int hour = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la hora de su vuelo"));

        Object[] optionAvion = Iterador.listArray(AvionController.instaceModel().listarAvion());

        EntityAvion objAvion = (EntityAvion) JOptionPane.showInputDialog(null, "Selecciona el avion correspondiente", "sin titulo", JOptionPane.QUESTION_MESSAGE, null, optionAvion, optionAvion[0]);

    }

    public static ModelVuelo insetaceModel() {
        return new ModelVuelo();
    }

//    hacer toda la lista
    public  static void listar(){
        String lista = listar(insetaceModel().listarVuelo());

        JOptionPane.showMessageDialog(null, lista);
    }

    public static String listar(List<Object> listaGrande){
        String listado = "Listado de vuelos";
        for (Object iterable: listaGrande){
            EntityVuelo objMoldelos = (EntityVuelo) iterable;
            listado += objMoldelos.toString() + "\n";
        }
        return listado;
    }

//    borrar cosas

    public static void borrar(){
        Object[] opcionesBorrar = Iterador.listArray(insetaceModel().listarVuelo());

        EntityVuelo optionAvion = (EntityVuelo) JOptionPane.showInputDialog(null, "selecciona un vuelo","",JOptionPane.QUESTION_MESSAGE, null,opcionesBorrar,opcionesBorrar[0]);

        insetaceModel().eliminarVuelo(optionAvion);
    }

    public static void update(){
        Object[] opcionesActual = Iterador.listArray(insetaceModel().listarVuelo());
        EntityVuelo optionAvion = (EntityVuelo) JOptionPane.showInputDialog(null, "selecciona un vuelo","",JOptionPane.QUESTION_MESSAGE, null,opcionesActual,opcionesActual[0]);

        String NewDestiny = JOptionPane.showInputDialog(null, "Digite su nuevo destino", optionAvion.getDestino());
        String NewDate = JOptionPane.showInputDialog(null, "Digite la nueva fecha de su vuelo", optionAvion.getFecha_Salida());
        int NewHour = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la nueva hora de su vuelo", optionAvion.getHora_Salida()));
        Object[] AvionOpcionado = Iterador.listArray(AvionController.instaceModel().listarAvion());
        EntityAvion objAvion= (EntityAvion) JOptionPane.showInputDialog(null, "selecciona un avion","",JOptionPane.QUESTION_MESSAGE, null,AvionOpcionado,AvionOpcionado[0]);


        insetaceModel().actualizarVuelo(new EntityVuelo(NewDestiny,NewDate,NewHour,objAvion.getID_Avion(),objAvion));
    }

}