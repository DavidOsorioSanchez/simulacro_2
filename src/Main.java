import Controller.AvionController;
import Controller.PasajeroController;
import Controller.VueloController;
import Database.ConfigDB;

import javax.swing.*;
import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int option1 = 0, option2 = 0;

        do {
            option1 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    1. Administrar aviones
                    2. Administrar pasajeros
                    3. Administrar Citas
                    4. Administrar Pacientes
                    5. Salir
                    
                    Eligue la opcion que mas te conviene.
                    """));
            switch (option1){
                case 1:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                1. Añadir informacion a aviones
                                2. Modificar aviones
                                3. Borrar aviones
                                4. Listar aviones
                                5. Salir 
                                
                                Elige la opcion que mas te conviene.
                                """));
                        switch (option2){
                            case 1:
                                AvionController.insert();
                                break;
                            case 2:
                                AvionController.update();
                                break;
                            case 3:
                                AvionController.borrar();
                                break;
                            case 4:
                                AvionController.listar();
                                break;
                        }
                    }while (option2 != 5);

                    break;
                case 2:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                1. Añadir informacion a pasajeros
                                2. Modificar pasajeros
                                3. Borrar pasajeros
                                4. Listar pasajeros
                                5. Salir

                                Elige la opcion que mas te conviene.
                                """));
                        switch (option2){
                            case 1:
                                PasajeroController.insert();
                                break;
                            case 2:
                                PasajeroController.update();
                                break;
                            case 3:
                                PasajeroController.borrar();
                                break;
                            case 4:
                                PasajeroController.listar();
                                break;
                        }
                    }while (option2 != 5);
                    break;
                case 3:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                1. Añadir informacion a Vuelo
                                2. Modificar Vuelo
                                3. Borrar Vuelo
                                4. Listar Vuelo
                                5. Salir

                                Elige la opcion que mas te conviene.
                                """));
                        switch (option2){
                            case 1:
                                VueloController.insert();
                                break;
                            case 2:
                                VueloController.update();
                                break;
                            case 3:
                                VueloController.borrar();
                                break;
                            case 4:
                                VueloController.listar();
                                break;
                        }
                    }while (option2 != 5);
                    break;
                case 4:
//                    do {
//                        option2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
//                                1. Añadir informacion a paciente
//                                2. Modificar paciente
//                                3. Borrar paciente
//                                4. Listar paciente
//                                5. Salir
//
//                                Elige la opcion que mas te conviene.
//                                """));
//                        switch (option2){
//                            case 1:
//                                PacienteController.insert();
//                                break;
//                            case 2:
//                                PacienteController.update();
//                                break;
//                            case 3:
//                                PacienteController.borrar();
//                                break;
//                            case 4:
//                                PacienteController.listar();
//                                break;
//                        }
//                    }while (option2 != 5);
                    break;
            }
        }while (option1 != 5);
    }
}