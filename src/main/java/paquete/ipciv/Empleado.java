/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.ipciv;

/**
 *
 * @author Cris
 */
public class Empleado extends Usuario {
    
    public Empleado(Usuario User){
        super(User.getID(),User.getName(), User.getFecha(), User.getCorreo(), User.getTipo(), User.getContra());
    }  
    public Empleado(int Ced, String Nombre, String Fecha, String Correo, String Tipo, String Contrase){
        super(Ced, Nombre, Fecha, Correo, Tipo, Contrase);
    }  
        public boolean Menu(){
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
        Main.Usuarios.add(newUser);
     }
     
     public static void ReaFinPed(){
         int opt;
            System.out.println("Realizar Pedido (1)");
            System.out.println("Finalizar Pedido (2)");
            System.out.println("Salirr (3)");
        opt = lee.nextInt();
        switch (opt) {
            case 1:
                System.out.println("Digite la Cédula del cliente: ");
                String IDC = lee.next();
                String name = getNameClient(IDC);

                String state = "En revision";
                System.out.println("Ingrese el material del mueble 1-Madera 2-Metal");
                int material = lee.nextInt();
                System.out.println("Digite el color de la pintura");
                String pintura = lee.next();
                System.out.println("Ingrese el material a utilizar 1-Tornillos 2-Clavos");
                int un = lee.nextInt();
                Pedidos pedido = new Pedidos(name, state, material, pintura, un);
                Main.Pedidos.add(pedido);

            case 2:
                int cont = 0;
                for (int i = 0; i < Main.Pedidos.size(); i++) {
                    if ("Aprovado".equals(Main.Pedidos.get(i).Estado)) {
                        cont += 1;
                        System.out.print(cont + Main.Pedidos.get(i).getInfoPedido());
                    }
                }
                break;
            case 3:
                break;
        }         
         
     }


     
     
     public static void PrintEti(){
        
     }
     
}
