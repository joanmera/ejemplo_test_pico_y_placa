
package com.mycompany.pico_y_placa;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Pico_y_placa {

   
    public static void main(String[] args) {
        //this checks will helps us with different validations
        boolean check2=false, check3=false,check4=false ;
       
        int type=0;
        boolean check=false;
       //y=years m=months d=days     
        int y=0,m=0,d=0,minutes=0,hours=0,allmin=0;

        Scanner src = new Scanner (System.in);

         System.out.println("Bienvenido Usuario"+"\n"+"este es el programa de Pico y Placa");
         Placa pl =new Placa();
         Placa pl2=new Placa();
         
         do{
                try{ 
                
                System.out.println("porfavor selecciona el tipo de vehiculo");
        
                System.out.println("-------------------------------------");
                System.out.println("1-automovil");
                System.out.println("2-motocicleta");
                System.out.println("3-salir");
                System.out.println("-------------------------------------");
                type=src.nextInt();
                check=true;            
                     if(type<1 || type>3){
                     System.out.println("opcion no valida, porfavor selecciona entre (1 o 2)");
                     check=false;
                     System.out.println();
                                         }
                }
                catch(Exception e){
               System.out.println("Error: Ingresa un valor numerico valido.");
               src.nextLine(); 
               check=false;
               System.out.println();
                }
                
        }while(!check);
         
         
            switch(type){
        
              case 1:
                 do{
                     try{
                          System.out.println(); 
                          System.out.println("Escriba la placa de su auto en el siguiente formato AAA-0000");
                          pl.setplaca(src.next());
                        //this line allows the user type in capital letters or not
                          pl.setplaca(pl.getplaca().toUpperCase());
                        //lplaca means "letters placa" -->AAA
                          String lplaca=pl.getplaca().substring(1, 3);
                          //nplaca means "number placa" -->0000/000
                          String nplaca=pl.getplaca().substring(4, pl.getplaca().length());
                          
                          
                          //restriction if the String is longer or shorter than expected
                          if(pl.getplaca().length()>8 || pl.getplaca().length()<7){
                              System.out.println("Error: placa muy larga o demasiado corta");
                              check2=false;
                              System.out.println();
                          //restriction if "AAA" are not letters
                             //I used "[^a-zA-Z]*$", this sing "^" is used inside the brakects to get false as answer
                          }else if(lplaca.matches("[^a-zA-Z]*$")){
                              System.out.println("Error: los tres primeros espacios deben ser letras");
                              check2=false;
                              System.out.println();
                             //restriction if "-" is not inside the Sring
                          }else if(pl.getplaca().charAt(3)!='-'){
                              System.out.println("Error: debe ingresar la placa con el formato AAA-0000");
                              check2=false;
                              System.out.println();
                         //restriction if "0000" are not numbers 
                          }else if(!(nplaca.chars().allMatch(Character::isDigit))){
                              System.out.println("Error: los ultimos cuatro o tres espacios deben ser numeros");
                              check2=false;
                              System.out.println();
                          }
                          
                          
                          //show String and validation
                          else{
                              System.out.println();
                              System.out.println("Placa ingresada: "+pl.getplaca());
                              try{
                                  System.out.println("desea continuar? (1-Si/2-No)");
                                  int next=src.nextInt();
                                  if(next==2){
                                      check2=false;
                                  }else{
                                      check2=true;
                                  }
                              }catch(Exception e){
                                   System.out.println("Error: ingrese una de las opciones");
                                   src.nextLine();
                                   System.out.println();
                                   
                              }
                              
                              
                          }
                          
                        
                          /
                     } 
                     catch(Exception e){
                         System.out.println("Error: ingrese una placa valida");
                         src.nextLine();
                         System.out.println();
                     }
                 }while(!check2); 
              
                do{   //upload date
                    try{
                        System.out.println("-------------------");
                        System.out.println("Ingrese la fecha");
                        System.out.println("-------------------");
                        
                        System.out.println("Ingrese el año");
                        y=src.nextInt();
                        System.out.println("Ingrese el mes");
                        m=src.nextInt();   //restriction
                        if(m<1 || m>12){
                            System.out.println("Error: mes invalido");
                             check3=false;
                             System.out.println();
                        }
                        System.out.println("Ingrese el dia");
                        d=src.nextInt(); //restriction
                        if(d<1 || d>31){
                            System.out.println("Error: dia invalido");
                             check3=false;
                             System.out.println();
                        }

                        else{    //the last check with "true" always help us to get out of the bucle
                            check3=true;
                        }
                    }
                    catch(Exception e){
                         System.out.println("Error: ingrese una fecha valida");
                         src.nextLine();
                         System.out.println();
                    }
                }while(!check3);
                 
                 do{                        //upload time
                            try {         //ONLY HOURS IN 24H FORMAT
                               System.out.print("Ingresa unicamente la hora (formato 24 horas): ");
                                hours = src.nextInt();  //restriction
                                if (hours<0 || hours > 23 ) {
                                    System.out.println("Error: hora invalida");
                                    check4=false;
                                    System.out.println();
                                }
                                
                               System.out.print("Ingresa los minutos: ");
                               minutes = src.nextInt();  //restriction

                               if (minutes < 0 || minutes > 59) {
                                    System.out.println("Error: hora invalida");
                                    check4=false;
                                    System.out.println();
                                    
                                } else {
                                   System.out.println();  //restriction
                                   System.out.println("Hora ingresada: " + hours + ":" + minutes);
                                    check4=true;
                                    allmin=hours*60+minutes;
                                }
                               
                            } catch (Exception e) {
                                System.out.println("Error: ingrese una hora valida");
                                src.nextLine();
                                System.out.println();
                            }
                         
                 }while(!check4);
                 
                 //with java libaries we can get the date according to the user
              LocalDate Date = LocalDate.of(y,m,d);
              DayOfWeek diaDeLaSemana = Date.getDayOfWeek(); 
                  //we create the String with the name of the day but with LA Spanish
              String nombreDia = diaDeLaSemana.getDisplayName(TextStyle.FULL, new Locale("es", "LA"));
              
              
              //validation of the day, placa and time
              if(diaDeLaSemana==DayOfWeek.MONDAY ){
                  if(pl.getplaca().charAt(pl.getplaca().length()-1)=='1' || pl.getplaca().charAt(pl.getplaca().length()-1)=='2'){
                      if(allmin>=7*60 && allmin<=9*60+30 || allmin>=16*60 && allmin<=19*60+30){
                          System.out.println();
                          System.out.println("La placa: "+pl.getplaca()+" no puede circular los dias: "+nombreDia);
                          donotallow();
                      }else{
                          System.out.println();
                          System.out.println("La placa: "+pl.getplaca()+" tiene pico y placa los "+nombreDia+ " sin embargo puede circular");
                          allow();
                          
                      }
                 }
               }
              
              
              if(diaDeLaSemana==DayOfWeek.TUESDAY ){
                  if(pl.getplaca().charAt(pl.getplaca().length()-1)=='3' || pl.getplaca().charAt(pl.getplaca().length()-1)=='4'){
                      if(allmin>=7*60 && allmin<=9*60+30 || allmin>=16*60 && allmin<=19*60+30){
                          System.out.println();
                          System.out.println("La placa: "+pl.getplaca()+" no puede circular los dias: "+nombreDia);
                          donotallow();
                      }else{
                          System.out.println();
                          System.out.println("La placa: "+pl.getplaca()+" tiene pico y placa los martes sin embargo puede circular");
                          allow();
                          
                      }
                 }
               }
              
              
              if(diaDeLaSemana==DayOfWeek.THURSDAY ){
                  if(pl.getplaca().charAt(pl.getplaca().length()-1)=='5' || pl.getplaca().charAt(pl.getplaca().length()-1)=='6'){
                      if(allmin>=7*60 && allmin<=9*60+30 || allmin>=16*60 && allmin<=19*60+30){
                          System.out.println();
                          System.out.println("La placa: "+pl.getplaca()+" no puede circular los dias: "+nombreDia);
                          donotallow();
                      }else{
                          System.out.println();
                          System.out.println("La placa: "+pl.getplaca()+" tiene pico y placa los miercoles sin embargo puede circular");
                          allow();
                          
                      }
                 }
               }
              
              
              if(diaDeLaSemana==DayOfWeek.WEDNESDAY ){
                  if(pl.getplaca().charAt(pl.getplaca().length()-1)=='7' || pl.getplaca().charAt(pl.getplaca().length()-1)=='8'){
                      if(allmin>=7*60 && allmin<=9*60+30 || allmin>=16*60 && allmin<=19*60+30){
                          System.out.println();
                          System.out.println("La placa: "+pl.getplaca()+" no puede circular los dias: "+nombreDia);
                          donotallow();
                      }else{
                          System.out.println();
                          System.out.println("La placa: "+pl.getplaca()+" tiene pico y placa los jueves sin embargo puede circular");
                          allow();
                      }
                 }
               }
              
              
              if(diaDeLaSemana==DayOfWeek.FRIDAY ){
                  if(pl.getplaca().charAt(pl.getplaca().length()-1)=='9' || pl.getplaca().charAt(pl.getplaca().length()-1)=='0'){
                      if(allmin>=7*60 && allmin<=9*60+30 || allmin>=16*60 && allmin<=19*60+30){
                          System.out.println();
                          System.out.println("La placa: "+pl.getplaca()+" no puede circular los dias: "+nombreDia);
                          donotallow();
                      }else{
                          System.out.println();
                          System.out.println("La placa: "+pl.getplaca()+" tiene pico y placa los viernes sin embargo puede circular");
                          allow();
                          
                      }
                 }
               }
              else{
                  System.out.println("La placa: "+pl.getplaca()+" tiene libre circulación ");
              }
              break;
              
              
              
              
              
                       //same as before with case two
              case 2:
                    do{
                     try{
                          System.out.println(); 
                          System.out.println("Escriba la placa de su motocicleta en el siguiente formato AA-000A");
                          pl2.setplaca(src.next());
                          pl2.setplaca(pl2.getplaca().toUpperCase());
                        //String of "AA"
                          String lplaca=pl2.getplaca().substring(1, 2);
                          //String of "000"
                          String nplaca=pl2.getplaca().substring(4, 6);

                          if(pl2.getplaca().length()>7 || pl2.getplaca().length()<7){ //restriction of size
                              System.out.println("Error: placa muy larga o demasiado corta");
                              check2=false;
                              System.out.println();
                          }else if(lplaca.matches("[^a-zA-Z]*$")){ //restriction of first letters
                              System.out.println("Error: los dos primeros espacios deben ser letras");
                              check2=false;
                              System.out.println();
                          }else if(pl2.getplaca().charAt(2)!='-'){ //restriction of "-" inside String
                              System.out.println("Error: debe ingresar la placa con el formato AA-000A");
                              check2=false;
                              System.out.println();
                          }else if(!(nplaca.chars().allMatch(Character::isDigit))){ //restriction of numbers after "-"
                              System.out.println("Error: deben existir almenos tres numeros despues del guion");
                              check2=false;
                              System.out.println();
                          }
                          
                          
                          else{
                              System.out.println();
                              System.out.println("Placa ingresada: "+pl2.getplaca());
                              try{
                                  System.out.println("desea continuar? (1-Si/2-No)");
                                  int next=src.nextInt();
                                  if(next==2){
                                      check2=false;
                                  }else{
                                      check2=true;
                                  }
                              }catch(Exception e){
                                   System.out.println("Error: ingrese una de las opciones");
                                   src.nextLine();
                                   System.out.println();
                                   
                              }
                              
                              
                          }
                          
                        
                          
                     } 
                     catch(Exception e){
                         System.out.println("Error: ingrese una placa valida");
                         src.nextLine();
                         System.out.println();
                     }
                 }while(!check2); 
              
                do{
                    try{
                        System.out.println("-------------------");
                        System.out.println("Ingrese la fecha");
                        System.out.println("-------------------");
                        
                        System.out.println("Ingrese el año");
                        y=src.nextInt();
                        System.out.println("Ingrese el mes");
                        m=src.nextInt();
                        if(m<1 || m>12){
                            System.out.println("Error: mes invalido");
                             check3=false;
                             System.out.println();
                        }
                        System.out.println("Ingrese el dia");
                        d=src.nextInt();
                        if(d<1 || d>31){
                            System.out.println("Error: dia invalido");
                             check3=false;
                             System.out.println();
                        }

                        else{
                            check3=true;
                        }
                    }
                    catch(Exception e){
                         System.out.println("Error: ingrese una fecha valida");
                         src.nextLine();
                         System.out.println();
                    }
                }while(!check3);
                 
                 do{
                            try {
                               System.out.print("Ingresa unicamente la hora (formato 24 horas): ");
                                hours = src.nextInt();
                                if (hours<0 || hours > 23 ) {
                                    System.out.println("Error: hora invalida");
                                    check4=false;
                                    System.out.println();
                                }
                                
                               System.out.print("Ingresa los minutos: ");
                               minutes = src.nextInt();

                               if (minutes < 0 || minutes > 59) {
                                    System.out.println("Error: hora invalida");
                                    check4=false;
                                    System.out.println();
                                    
                                } else {
                                   System.out.println(); 
                                   System.out.println("Hora ingresada: " + hours + ":" + minutes);
                                    check4=true;
                                    allmin=hours*60+minutes;
                                }
                               
                            } catch (Exception e) {
                                System.out.println("Error: ingrese una hora valida");
                                src.nextLine();
                                System.out.println();
                            }
                         
                 }while(!check4);
                 
                 
              LocalDate Date2 = LocalDate.of(y,m,d);
              DayOfWeek diaDeLaSemana2 = Date2.getDayOfWeek();
              String nombreDia2 = diaDeLaSemana2.getDisplayName(TextStyle.FULL, new Locale("es", "LA"));
              
              
              
              if(diaDeLaSemana2==DayOfWeek.MONDAY ){
                 //we need to use .length()-2 because the last digit in case of motorcycles is a letter and we need to analyze numbers
                  if(pl2.getplaca().charAt(pl2.getplaca().length()-2)=='1' || pl2.getplaca().charAt(pl2.getplaca().length()-2)=='2'){
                      if(allmin>=7*60 && allmin<=9*60+30 || allmin>=16*60 && allmin<=19*60+30){
                          System.out.println();
                          System.out.println("La placa: "+pl2.getplaca()+" no puede circular los dias: "+nombreDia2);
                          donotallow();
                      }else{
                          System.out.println();
                          System.out.println("La placa: "+pl2.getplaca()+" tiene pico y placa los "+nombreDia2+ " sin embargo puede circular");
                          allow();
                          
                      }
                 }
               }
              
              
              if(diaDeLaSemana2==DayOfWeek.TUESDAY ){
                  if(pl2.getplaca().charAt(pl2.getplaca().length()-2)=='3' || pl2.getplaca().charAt(pl2.getplaca().length()-2)=='4'){
                      if(allmin>=7*60 && allmin<=9*60+30 || allmin>=16*60 && allmin<=19*60+30){
                          System.out.println();
                          System.out.println("La placa: "+pl2.getplaca()+" no puede circular los dias: "+nombreDia2);
                          donotallow();
                      }else{
                          System.out.println();
                          System.out.println("La placa: "+pl2.getplaca()+" tiene pico y placa los martes sin embargo puede circular");
                          allow();
                          
                      }
                 }
               }
              
              
              if(diaDeLaSemana2==DayOfWeek.THURSDAY ){
                  if(pl2.getplaca().charAt(pl2.getplaca().length()-2)=='5' || pl2.getplaca().charAt(pl2.getplaca().length()-2)=='6'){
                      if(allmin>=7*60 && allmin<=9*60+30 || allmin>=16*60 && allmin<=19*60+30){
                          System.out.println();
                          System.out.println("La placa: "+pl2.getplaca()+" no puede circular los dias: "+nombreDia2);
                          donotallow();
                      }else{
                          System.out.println();
                          System.out.println("La placa: "+pl2.getplaca()+" tiene pico y placa los miercoles sin embargo puede circular");
                          allow();
                          
                      }
                 }
               }
              
              
              if(diaDeLaSemana2==DayOfWeek.WEDNESDAY ){
                  if(pl2.getplaca().charAt(pl2.getplaca().length()-2)=='7' || pl2.getplaca().charAt(pl2.getplaca().length()-2)=='8'){
                      if(allmin>=7*60 && allmin<=9*60+30 || allmin>=16*60 && allmin<=19*60+30){
                          System.out.println();
                          System.out.println("La placa: "+pl2.getplaca()+" no puede circular los dias: "+nombreDia2);
                          donotallow();
                      }else{
                          System.out.println();
                          System.out.println("La placa: "+pl2.getplaca()+" tiene pico y placa los jueves sin embargo puede circular");
                          allow();
                      }
                 }
               }
              
              
              if(diaDeLaSemana2==DayOfWeek.FRIDAY ){
                  if(pl2.getplaca().charAt(pl2.getplaca().length()-2)=='9' || pl2.getplaca().charAt(pl2.getplaca().length()-2)=='0'){
                      if(allmin>=7*60 && allmin<=9*60+30 || allmin>=16*60 && allmin<=19*60+30){
                          System.out.println();
                          System.out.println("La placa: "+pl2.getplaca()+" no puede circular los dias: "+nombreDia2);
                          donotallow();
                      }else{
                          System.out.println();
                          System.out.println("La placa: "+pl2.getplaca()+" tiene pico y placa los viernes sin embargo puede circular");
                          allow();
                          
                      }
                 }
               }
              else{
                  System.out.println("La placa: "+pl2.getplaca()+" tiene libre circulación ");
              }
                  
                  
              break;    
             
              case 3: //exit of program
                  System.out.println("Saliendo del programa...");
              break;
              
              
              
              default:
                  
              break; 
             }
           
       
        

        
    }
  
   //funtions to save lines 
   public static void donotallow(){
       System.out.println("su pico y plata empieza de:");
       System.out.println("7:00 am - 9:30 am:");
       System.out.println("4:00 pm - 7:30 pm");
   }
   public static void allow(){
       System.out.println("usuario ,recuerde que su pico y plata empieza de:");
       System.out.println("7:00 am - 9:30 am:");
       System.out.println("4:00 pm - 7:30 pm");
   } 
   
}
