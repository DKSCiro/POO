//package practica11;

import java.io.Console;

public class EjConsole {
    public static void main(String[] args){
        Console con = System.console();
        System.out.println("Usuario: ");
        String s = con.readLine();
        System.out.println("Contraseña: ");
        char[] s2 = con.readPassword();
        System.out.println(s2);
    }
}