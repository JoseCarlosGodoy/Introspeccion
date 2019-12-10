/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introspeccion;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class UsoEmpleado {

    public static void main(String[] args) throws NoSuchMethodException {
        // TODO code application ogic here
      Scanner entrada =new Scanner(System.in);
        System.out.println("Introduce la clase");
       
        String nombreClase = entrada.nextLine();
        Class cl1;
        try {
            cl1 = Class.forName(nombreClase);
            System.out.println(cl1.getName());
            
            Constructor[] c=cl1.getConstructors();  
            System.out.println("Constructores: \n");
            for(int i=0;i<c.length;i++){
                
                System.out.println(c[i].toGenericString());
            }
            
            System.out.println("Atributos: \n");
            Field[] f=cl1.getDeclaredFields();
             for(int i=0;i<f.length;i++){
                
                System.out.println(f[i].toGenericString());
            }
            
            System.out.println("Metodos: \n");
            Method[] m=cl1.getDeclaredMethods();
             for(int i=0;i<m.length;i++){
                
                System.out.println(m[i].toGenericString());
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsoEmpleado.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }
}
    class Persona {

        private String nombre;

        public Persona(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }
    }

    class Empleado extends Persona {

        private double salario;

        public Empleado(String nombre, double salario) {
            super(nombre);
            this.salario = salario;
        }

        public void setIncentivo(double incentivo) {
            salario = salario + incentivo;
        }

        public String getSalario() {
            return "El salario es: " + salario;
        }
    }

