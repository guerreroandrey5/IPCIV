/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.ipciv;

import java.util.ArrayList;
import java.util.Scanner;
import static paquete.ipciv.Main.Usuarios;

/**
 *
 * @author Cris
 */
public class Empleado extends Usuario {
    public static Scanner lee = new Scanner(System.in);
    public static ArrayList<Usuario> Usuarios = new ArrayList();
    
    public Empleado(Usuario user){
        boolean control = true;
        while(control){
            control = menu();
        }
    }  
    public Empleado(int Ced, String Nombre, String Fecha, String Correo, String Tipo, String Contrase){
        super(Ced, Nombre, Fecha, Correo, Tipo, Contrase);
    }  
        public boolean menu(){
        int opt;
            System.out.println("Registrar Clientes (1)");
            System.out.println("Realizar/Finalizar Pedido (2)");
            System.out.println("Imprimir Váucher/Etiqueta (3)");
            System.out.println("Regresar al inicio de sesión (4)");
        opt = lee.nextInt();
        switch (opt) {
            case 1:
                RegClient();         
                break;
            case 2:
                ReaFinPed();
                break;
            case 3:
                PrintEti();
                break;
            case 4:
                return false;
        }
        return true;
    }
     public static void RegClient() {
        int ID; String nombre, fnac, email, direcc;
        String pass = "";
        System.out.println("Digite la Cédula del cliente: ");
        ID = lee.nextInt();
        System.out.println("Digite el nombre completo del cliente (Si desea usar espacios, utlice guiones en lugar de espacios)");
        nombre = lee.next();
        System.out.println("Digite la fecha de nacimiento del cliente (dd/mm/aaaa): ");
        fnac = lee.next();
        System.out.println("Digite el correo electrónico del cliente: ");
        email = lee.next();
        System.out.println("Digite la dirección del domicilio del cliente: ");
        direcc = lee.next();
        Cliente newUser = new Cliente(ID, nombre, fnac, email, "Cliente", direcc, pass);
        Usuarios.add(newUser);
     }
     public static void ReaFinPed(){   
     }
     
     public static void PrintEti(){
        
     }
     
}
