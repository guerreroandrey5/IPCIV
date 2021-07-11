/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.ipciv;

import java.util.ArrayList;

/**
 *
 * @author Cris
 */
public class Administrador extends Usuario {
     
    public Administrador(Usuario User){
       super(User.getID(),User.getName(), User.getFecha(), User.getCorreo(), User.getTipo(), User.getContra());
    }   
    public Administrador(int Ced, String Nombre, String Fecha, String Correo, String Tipo, String Contrase){
       super(Ced, Nombre, Fecha, Correo, Tipo, Contrase);
    }   
    public boolean Menu(){
        int opt;
            System.out.println("Leer Pedidos (1)");
            System.out.println("Aprobar/Rechazar Cartas (2)");
            System.out.println("Pedidos (3)");
            System.out.println("Recetas (4)");
            System.out.println("Consultas (5)");
            System.out.println("Regresar al inicio de sesión (6)");
            opt = lee.nextInt();
            switch (opt) {
                case 1:
                    LeerPedidos();
                    
                    break;
                case 2:
                    AdministrarPedidos();
                    
                    break;
                case 3:
                    Pedidos();
                    
                    break;
                case 4:
                    Recetas();
                    
                    break;
                case 5:
                    Consultas();
                    
                    break;
                case 6:
                    return false;
            }
            return true;
    }
    
//<editor-fold defaultstate="collapsed" desc="Métodos">
    public static void LeerPedidos() {
        if (Main.Pedidos.isEmpty()) {
            System.out.println("                \nNo hay pedidos para visualizar.                   \n");   
        } else {
            for (int i = 0; i < Main.Pedidos.size(); i++) {
                System.out.println("<--------------------------------------------------->");
                System.out.println(Main.Pedidos.get(i).getInfoPedido());
            }
        }
    }
     public static void AdministrarPedidos(){
         
     }
     
     public static void Pedidos(){
         Boolean ciclo = true;
         while(ciclo) {
             System.out.println("<--------------------------------------------------->");
             for (int i = 0; i < Main.Pedidos.size(); i++) {
                 System.out.println((i+1)+"- Pedido " + Main.Pedidos.get(i).getID());
             }
             if(Main.Pedidos.isEmpty()) {
                 System.out.println("\n       Sin pedidos para visualizar           \n");
             }
             System.out.println("<--------------------------------------------------->");
             System.out.println("1-Agregar nuevo pedido\n2-Cancelar Pedido\n3-Salir");
            int o = lee.nextInt();
            if (o == 1){
                NPedido();
            } else if (o == 2) {
                while (true){
                    if (Main.Pedidos.isEmpty()) {
                        System.out.println("\n          \033[31m No hay pedidos para cancelar        \n");
                        break;
                    }
                    System.out.println("Seleccione el ID del pedido. Los ID estan listados arriba ");
                    int ID = (lee.nextInt()-1);
                    System.out.println("<--------------------------------------------------->");
                    System.out.println(Main.Pedidos.get(ID).getInfoPedido());
                    System.out.println("<--------------------------------------------------->");
                    System.out.println("1-Cancelar Pedido\n2-Volver");
                    int opt = lee.nextInt();
                    if (opt == 1){
                        System.out.println("Seguro que desea cancelar el pedido " + Main.Pedidos.get(ID).getID() + " Hecho por " + Main.Pedidos.get(ID).getNombre_Cliente() + "?");
                        System.out.println("1-Cancelar Pedido\n2-Volver");
                        int opt2 = lee.nextInt();
                        if (opt2 == 1) {
                            Main.Pedidos.remove(ID);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                ciclo = false;
            }
         }
     }
     
     public static void Recetas(){
         for (int i = 0; i < Main.Recetas.size(); i++) {
                System.out.println("<--------------------------------------------------->");
                System.out.println(Main.Recetas.get(i).toString());
        }
     }
     
     public static void Consultas(){
        int opt;
            System.out.println("Consultar Inventario de Insumos (1)");
            System.out.println("Consultar Muebles terminados (2)");
            System.out.println("Volver (3)");
        opt = lee.nextInt();
        switch (opt) {
            case 1:  
                String sInv = Main.Inventarios.toString().replace("[", "").replace("]", "");
                System.out.println(sInv);
                CompararPM(false);
                System.out.println("\n (1)Comparar pedidos con materiales disponibles\n (2)Salir");
                int ac = lee.nextInt();
                switch(ac) {
                    case 1:
                        if (Main.Pedidos.isEmpty()) {
                            System.out.println("                \nNo hay pedidos en estado de revisión.     \n");   
                        } else {
                         CompararPM(true); 
                        }
                        break;
                    case 2:
                        break;
                }
                break;
                
            case 2:
                ArrayList<Pedido> terminados = new ArrayList<Pedido>();
                for (int i = 0; i < Main.Pedidos.size(); i++) {
                    if ("Terminado".equals(Main.Pedidos.get(i).getEstado())){
                        terminados.add(Main.Pedidos.get(i));
                    }
                }
                if (terminados.isEmpty()) {
                    System.out.println("\n    No hay muebles terminados    \n");
                } else {
                    for (int j = 0; j < terminados.size(); j++) {
                        System.out.println("<--------------------------------------------------->");
                        System.out.println(terminados.get(j).getInfoPedido());
                    }
                    System.out.println("<--------------------------------------------------->");
                    System.out.println("\n (1)Comparar pedidos con materiales disponibles\n (2)Salir");
                    int act = lee.nextInt();
                    switch(act) {
                    case 1:
                        if (Main.Pedidos.isEmpty()) {
                            System.out.println("                \nNo hay pedidos en estado de revisión.     \n");   
                        } else {
                         CompararPM(true);   
                        }
                        break;
                    case 2:
                        break;
                }
                }
                break;
            case 3:
                break;
        }   
     }
     
     public static void CompararPM(boolean condition){
        int madera = 0;
        int metal = 0;
        int pintura = 0;
        int clavos = 0;
        int tornillos = 0;
        int invMadera = 0;
        int invMetal = 0;
        int invPintura = 0;
        int invClavos = 0;
        int invTornillos = 0;
        for (int k = 0; k < Main.Inventarios.size(); k++) {
             invMadera = invMadera + Main.Inventarios.get(k).getMadera();
             invMetal = invMetal + Main.Inventarios.get(k).getMetal();
             invPintura = invPintura + Main.Inventarios.get(k).getPintura();
             invClavos = invClavos + Main.Inventarios.get(k).getClavos();
             invTornillos = invTornillos + Main.Inventarios.get(k).getTornillos();
         }
        if(condition) {
         for (int i = 0; i < Main.Pedidos.size(); i++) {
             if ("En revisión.".equals(Main.Pedidos.get(i).getEstado())) {
                 int mueble = Main.Pedidos.get(i).getTipo_muebleIndx();
                 for (int j = 0; j < Main.Recetas.size(); j++) {
                     if (j == mueble) {
                         madera = madera + Main.Recetas.get(j).getRmadera();
                         metal = metal + Main.Recetas.get(j).getRmadera();
                         pintura = pintura + Main.Recetas.get(j).getRmadera();
                         clavos = clavos + Main.Recetas.get(j).getRmadera();
                         tornillos = tornillos + Main.Recetas.get(j).getRtornillos();
                     }
                 }
             }
         }
         
         System.out.println("\nCantidad de Madera necesaria para los pedidos: " + madera            
             + "\nCantidad de Metal necesaria para los pedidos: " + metal
             + "\nCantidad de Pintura necesaria para los pedidos: " + pintura 
             + "\nCantidad de Clavos necesaria para los pedidos: " + clavos
             + "\nCantidad de Tornillos nesearia para los pedidos: " + tornillos);
         System.out.println("\nCantidad de Madera necesaria disponible: " + invMadera            
             + "\nCantidad de Metal necesaria disponible: " + invMetal
             + "\nCantidad de Pintura necesaria disponible: " + invPintura 
             + "\nCantidad de Clavos necesaria disponible: " + invClavos
             + "\nCantidad de Tornillos nesearia disponible: " + invTornillos);
            alert(invMadera, madera, "Madera");
            alert(invMetal, metal, "Metal");
            alert(invPintura, pintura, "Pintura");
            alert(invClavos, clavos, "Clavos");
            alert(invTornillos, tornillos, "Tornillos");
            
        } else {
            
            for (int i = 0; i < Main.Recetas.size(); i++) {
             int[] inventario = {invMadera, invMetal, invPintura, invClavos, invTornillos};
             int[] receta = {Main.Recetas.get(i).getRmadera(), Main.Recetas.get(i).getRmetal(), Main.Recetas.get(i).getRpintura(), Main.Recetas.get(i).getRclavos(), Main.Recetas.get(i).getRtornillos()};
             String mueble = Main.Recetas.get(i).getNmueble();
             cantM(inventario, receta, mueble);
             }
        }
         
    }
     
     public static void alert(int av, int ned, String fur) {
         if (av < ned) {
             System.out.println("\033[31m No hay suficientes materiales");
             System.out.println("   \033[32m Se necesitan" + (ned - av) + " " + fur);
         }
     }
     
     public static void cantM(int[] av, int[] ned, String mueble) {
         int cantidad = 0;
         for (int i = 0; i < av.length; i++) {
          if(ned[i] == 0) {
              continue;
             } else if (ned[i] > av[i]) {
                 cantidad = 0;
                 break;
             } else {
                 if (i == 0 || cantidad == 0) {
                     cantidad = av[i]/ned[i];    
                 } else if (cantidad > (av[i]/ned[i])){
                    cantidad = av[i]/ned[i];
                 }                
                
             }   
         }
         if (cantidad == 0) {
             System.out.println("No es posible crear " + mueble);
         } else {            
            System.out.println("La cantidad de " + mueble + " que se pueden crear es de: " + cantidad);
         }
     }
     
    
     
//</editor-fold>
}
