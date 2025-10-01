/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utp_talller_de_programacion;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author TDIS
 */
public class Semana6_PC1 {
    public static void main(String[] args) {
        ejercicio_p1_01();
        ejercicio_p1_02();
        ejercicio_p1_03();
        ejercicio_p1_03_b();
        
        ejercicio_p2_01();
        ejercicio_p2_02();
        ejercicio_p2_03();
    }

    private static void ejercicio_p1_01(){
        Scanner scanner = new Scanner(System.in);
        Matcher matcher;
        int numero;
        String sino;    
        String continuar = "si";
        
        System.out.println("Ejercicio 01\n==============");
        
        do{
            do{
                System.out.print("Ingrese un numero del 1 al 100: ");  //  pedir numero del 1 al 100
                numero = Integer.valueOf(scanner.nextLine());
            }while(numero < 1 || numero > 100);

            System.out.println("El usuario ingreso el numero:" + numero);   //  imprimir qque numero ingreso el usuario
            
            do{
                System.out.print("Desea continuar Si/No ?: ");  //  preguntar si desea continuar
                sino = scanner.nextLine();
                Pattern patron = Pattern.compile("(?i)\\b(s[ií]|no)\\b", Pattern.CASE_INSENSITIVE); // el patron
                matcher = patron.matcher(sino);
            }while(!matcher.matches());  //  repite si no cumple con el patron
            
            continuar = sino.toLowerCase(); //continuar es igual a la decision ingresada pero sera en minusculas
            
        }while(continuar.equals("si")); //  si continuar es "si", vuelve a repetir todo        
    }
    private static void ejercicio_p1_02(){
        Scanner scanner = new Scanner(System.in);
        Matcher matcher;
        int numero;
        String sino;    
        String continuar = "si";
        
        System.out.println("Ejercicio 02\n==============");
        
        int numero_de_estudiantes=0;
        double promedio_global=0;
        double suma_global=0;
        
        int estudiantes_aprobados=0;
        
        do{
            numero_de_estudiantes++;
            System.out.format("Ingrese notas para el estudiante %d :", numero_de_estudiantes);  //  pedir numero del 1 al 100
            int numero_de_nota=0;
            int suma_de_notas=0;
            int nota_ingresada=0;
            double promedio_de_notas;
            
            do{
                numero_de_nota++;
                System.out.format("%nIngrese nota %02d: ", numero_de_nota);  //  pedir numero del 1 al 100
                
                nota_ingresada = Integer.valueOf(scanner.nextLine());
                
                if(nota_ingresada==-1){
                    continuar="no";
                }else{
                    suma_de_notas +=nota_ingresada;
                    do{
                        System.out.println("Desea ingresar mas notas Si/No ?: ");  //  preguntar si desea continuar
                        sino = scanner.nextLine();
                        Pattern patron = Pattern.compile("(?i)\\b(s[ií]|no)\\b", Pattern.CASE_INSENSITIVE); // el patron
                        matcher = patron.matcher(sino);
                    }while(!matcher.matches());  //  repite si no cumple con el patron
                    continuar = sino.toLowerCase(); //"continuar" es igual a la decision ingresada pero sera en minusculas
                }
            }while(continuar.equals("si"));
            promedio_de_notas = suma_de_notas / numero_de_nota;
            if(promedio_de_notas>=10.5)estudiantes_aprobados++;
            
            System.out.format("%nSu promedio de notas es: %s%n", promedio_de_notas);
            
            //
            do{
                System.out.println("Desea continuar con otro alumno Si/No ?: ");  //  preguntar si desea continuar
                sino = scanner.nextLine();
                Pattern patron = Pattern.compile("(?i)\\b(s[ií]|no)\\b", Pattern.CASE_INSENSITIVE); // el patron
                matcher = patron.matcher(sino);
            }while(!matcher.matches());  //  repite si no cumple con el patron
            continuar = sino.toLowerCase(); //"continuar" es igual a la decision ingresada pero sera en minusculas
            
            suma_global += promedio_de_notas;
            promedio_global +=suma_global/numero_de_estudiantes;
            
        }while(continuar.equals("si")); //  si continuar es "si", vuelve a repetir todo        
        
        System.out.format("%nPromedio global: %s%n", promedio_global);
        System.out.format("Estudiantes_aprobados: %s%n", estudiantes_aprobados);
    }
    private static void ejercicio_p1_03(){
        Scanner scanner = new Scanner(System.in);
        Matcher matcher;
        int numero;
        String correo;    
        String passwd="";
        boolean ingresar = false;
        int numero_intentos=0;
        
        System.out.println("Ejercicio 03\n==============");
        
        do{
            numero_intentos++;
            System.out.format("Intento numero %02d%n", numero_intentos);  //  
            System.out.print("Ingrese la direccion de su correo electronico: ");  //  preguntar el correo
            correo = scanner.nextLine();
            
            System.out.print("Ingrese el Password: ");  //  preguntar el passwd
            passwd = scanner.nextLine();

            String patron_correo = "\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\b";
            Pattern patron = Pattern.compile(patron_correo, Pattern.CASE_INSENSITIVE); // el patron
            matcher = patron.matcher(correo);
        
            if(!passwd.equals("P@55w0rd") || !matcher.matches()){
                ingresar=false;
                System.out.println("Acceso denegado");
            }else{
                ingresar=true;
            }
                
            if(numero_intentos==5){
                System.out.println("Cuenta suspendida");
                return;
            }
        }while(!ingresar);  //  repite si no cumple con el patron
        
        System.out.println("Bienvenido al Sistema");
    }
    
    private static void ejercicio_p1_03_b(){
        Scanner scanner = new Scanner(System.in);
        Matcher matcher_fact, matcher_primo, matcher_sino;
        String expresion;    
        String sino="";
        boolean ingresar = false;
        String continuar="";
        int numero = 0;
        boolean es_primo = false;
        
        
        System.out.println("Ejercicio 03b\n==============");
        
        do{
            System.out.print("Ingrese una expresion: ");  //  pedir la expresion
            expresion = scanner.nextLine();
            
            String patron_factorial = "^\\d+!$";
            String patron_primo = "^P+\\d";

            matcher_fact = Pattern.compile(patron_factorial, Pattern.CASE_INSENSITIVE).matcher(expresion);
            matcher_primo = Pattern.compile(patron_primo, Pattern.CASE_INSENSITIVE).matcher(expresion);
            
            if(matcher_fact.matches()){
                //  entra si es factorial
                numero = Integer.valueOf(expresion.substring(0,expresion.length()-1));
                ///////////////////////////////////////
                //  calculo del factorial de un numero
                long fact = 1;

                for (int i = 1; i <= numero; i++) {
                    fact *= i;
                }                
                System.out.format("es factorial de %s, es %s",numero, fact);  //  pedir la expresion
                ///////////////////////////////////////
                
            }
            if(matcher_primo.matches()){
                //  entra si es primo
                numero = Integer.valueOf(expresion.substring(1));
                // Recorre desde 2 hasta n-1
                es_primo = true;
                for (int i = 2; i < numero; i++) {
                    if (numero % i == 0) {
                        es_primo = false; // si encuentra un divisor, no es primo
                    }
                }
                if(es_primo){
                    System.out.format("el numero %s SI es primo:%n",numero);  //  pedir la expresion
                }else{
                    System.out.format("el numero %s, NO es primo%n",numero);  //  pedir la expresion
                }
            }
            
            do{
                System.out.println("Desea continuar Si/No ?: ");  //  preguntar si desea continuar
                sino = scanner.nextLine();
                String patron_sino = "(?i)\\b(s[ií]|no)\\b";
                matcher_sino = Pattern.compile(patron_sino, Pattern.CASE_INSENSITIVE).matcher(sino);
            }while(!matcher_sino.matches());  //  repite si no cumple con el patron
            continuar = sino.toLowerCase(); //"continuar" es igual a la decision ingresada pero sera en minusculas
            
        }while(continuar.equals("si"));  //  repite si no cumple con el patron        
    }
    private static void ejercicio_p2_01(){
        Scanner scanner = new Scanner(System.in);
        String nombres="", apellidos="";    
        boolean salir = false;
        int opcion = 0;
        double [] salario_mes = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        String[] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Set", "Oct", "Nov", "Dic"};
        
        
        System.out.println("Ejercicio p2 01\n==============");
        do{
            do{
                System.out.println("########################################");
                System.out.println("#         MENU DE OPCIONES             #");
                System.out.println("########################################");
                System.out.println("#  1. Ingrese Empleado                 #");
                System.out.println("#  2. Ingresar salario mensual         #");
                System.out.println("#  3. Emitir Boleta                    #");
                System.out.println("#  4. Salir                            #");
                System.out.println("########################################");

                System.out.print("Elija una opcion: ");
                opcion = Integer.parseInt(scanner.nextLine());
                if(opcion<1 || opcion>4)System.out.println("opcion invalida");
            }while(opcion<1 || opcion>4);
            
            //  opcion 1
            if(opcion==1){
                System.out.print("Ingrese nombre del empleado: ");
                nombres = scanner.nextLine();
                System.out.print("Ingrese apellidos del empleado: ");
                apellidos = scanner.nextLine();
                System.out.println("Empleado registrado");
            }else if(opcion==2){
                for(int m=0; m<12; m++){
                    System.out.format("Ingrese salario de %s: ", meses[m]);
                    salario_mes[m]=Double.parseDouble(scanner.nextLine());
                }
            }else if(opcion==3){
                System.out.println("########################################");
                System.out.println("#         RESUMEN BOLETA DE PAGO       #");
                System.out.println("########################################");
                System.out.format ("#  Nombre del empleado:%s      #%n", nombres);
                System.out.format ("#  Apellidos del empleado:%s      #%n", apellidos);
                System.out.println("#  Tipo: Contratado               #");
                for(int m=0; m<12; m=m+2){
                    System.out.format("Salario %s: %s  Salario %s: %s%n", meses[m], salario_mes[m], meses[m+1], salario_mes[m+1]);
                }                
                System.out.println("########################################");                
            }else if(opcion==4){
                salir=true;
            }
            
        }while(!salir);
    }
    private static void ejercicio_p2_02(){
        Scanner scanner = new Scanner(System.in);
        Matcher matcher_fact, matcher_primo, matcher_sino;
        String nombres="", apellidos="";    
        String sino="";
        boolean salir = false, finalizado=false;
        String numero_binario="";
        int numero = 0;
        int opcion = 0;
        boolean es_primo = false, opcion_valida=false;
        
        
        System.out.println("Ejercicio p2 02\n==============");
        
        do{
            numero_binario = "";
            System.out.print("Ingrese un numero para convertir a binario: ");
            numero = Integer.parseInt(scanner.nextLine());
            
            do{
                if(numero%2==0){
                    numero_binario = "0" + numero_binario;
                }else{
                    numero_binario = "1" + numero_binario;
                }
                numero = (int)(numero/2);
                
            }while(numero>=1);
            System.out.format("El numero convertido a binario es: %s%n", numero_binario);
            
        }while(!salir);
    }
    
    private static void ejercicio_p2_03(){
        Scanner scanner = new Scanner(System.in);
        Matcher matcher_fact, matcher_primo, matcher_sino;
        String nombres="", apellidos="";    
        String sino="";
        boolean salir = false, finalizado=false;
        String expresion="";
        int numero = 0;
        int opcion = 0;
        boolean es_primo = false, opcion_valida=false;
        Matcher matcher;
        
        System.out.println("Ejercicio p2 03\n==============");
        
        do{
            do{
                System.out.print("Ingrese una expresion de la forma ab=N: ");
                expresion = scanner.nextLine();
                String patron = "[a-zA-Z]{2}=[0-9]+";
                matcher = Pattern.compile(patron, Pattern.CASE_INSENSITIVE).matcher(expresion);
            }while(!matcher.matches());
            
            String[] aexp = expresion.split("=");
            
            int filas = Integer.parseInt(aexp[1]);
            int i=0;
            for(int f=0; f < filas ; f++){
                i=0;
                for(int c=0; c<=f; c++){
                    System.out.print(aexp[0].charAt(i));
                    i++;
                    if(i>1)i=0;
                }
                System.out.println("");
                //System.out.println(aexp[0]);
            }
            
            
        }while(!salir);
    }    
}


