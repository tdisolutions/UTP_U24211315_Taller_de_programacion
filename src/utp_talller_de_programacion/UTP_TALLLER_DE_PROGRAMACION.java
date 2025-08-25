/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utp_talller_de_programacion;

/**
 *
 * @author David Buleje Diaz
 * @codigo U24211315
 */
public class UTP_TALLLER_DE_PROGRAMACION {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //  ejecucion del ejercicio 01
        ejercicio01();
        
        //  ejecucion del ejercicio 02
        ejercicio02();
        
        //  ejecucion del ejercicio 03
        ejercicio03();
        
        
    }
    
    private static void ejercicio01(){
        System.out.println("Ejercicio 01\n==============");
        System.out.format("Mi nombre es%s, mi codigo es:%s, y ni edad es:%d%n",  "David Buleje Diaz", "U24211315", 48);
    }
    private static void ejercicio02(){
        System.out.println("\nEjercicio 02\n==============");

        //  declaracion e inicializacion de variable nombre
        String nombre = "David Buleje Diaz";

        //  declaracion e inicializacion de variable codigo
        String codigo = "U24211315";

        //  declaracion e inicializacion de variable edad
        byte edad   = 48;

        //  declaracion e inicializacion de variable es_estudiante
        boolean es_estudiante = true;
        
        System.out.format("Mi nombre es %s, y mi codigo:%s%n", nombre, codigo);
        System.out.format("Mi edad es:%d%n", edad);
        System.out.format("Es estudiante?:%b%n", es_estudiante);
    }
    private static void ejercicio03(){
        /*  Ejercicio para calcular el area de un circulo
         *  donde se muestra la declaracion de una constante con "final", 
         *  y su uso para realizar operaciones aritmeticas
         */
        
        System.out.println("\nEjercicio 03\n==============");

        //  declaracion de constante PI
        final double PI = 3.1416;
        
        //  declaracion de radio
        double radio = 5.0;
        
        //calculo del area con la formula: area=PI*radio^2
        double area = PI * radio * radio;
        
        //  mostramos el resultado
        System.out.format("El area del cirlulo de radio %.1f es:%.2f%n", radio, area);
        
        
    }

}
