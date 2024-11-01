/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cnames;

import java.io.*;
import java.nio.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

/**
 *
 * @author Alvar
 */
public class Cnames {

    //Parametros
    Cnames MN =  new Cnames();
    
        public static File Mroute = new File("E:\\Descargas\\PruebasAnime");
        public static Path Origen;
        public static Path Destino;
    
    
    //Fin Parametros
    
    
    
    public static void main(String[] args) {
            
      Cnames.Menu();
    }
    
    
    public static void Menu(){
    
            int Continuar = 1;
       do{
           
            Cnames.getName(Mroute);       
       
        
        
        System.out.println("Marque 1 para reintentar o 2  para SALIR");
        String Edata = "";
        Scanner EntradaEscaner = new Scanner(System.in);
        Edata = EntradaEscaner.nextLine();
        if (Edata !=  null){
            Continuar = Integer.parseInt(Edata);        
            
        }else{
        Edata = "1";
        Continuar = Integer.parseInt(Edata);
       
        };
        
        
       }while(Continuar == 1 );
    
    }
    
    
    
    
    
    public static void getName(File dir){
         String TempName;
        int dig = 0,dog = 0;
                
                
         
        String[] ListFiles = dir.list();
        
        if (ListFiles.length > 0) {
            
            System.out.println(ListFiles[0]+ "Prueba Primer Nombre del Listado");
           
           
            for (int i=0; i<ListFiles.length; i++){
                
                TempName = ListFiles[i];
                if (ListFiles[i].length() > 11 ) {
                    dig++;
                    
                   Cnames.Gen_Name(TempName);
                    
                System.out.println(TempName+ "Test  numero mayor " + dig);
                }else{
                    dog++;
                    System.out.println(TempName+ "Test  numero MENOR  " + dog);
                
                }   
                
            
            }  
        } else {
            System.out.println("Empty");
            
            
        }
        
           
        
        
        
        
        
}
    
    public static  void Gen_Name(String Name){
     char Fsplit = '_', LSplit = '.';
     int FMarker = 0;
     int Lmarker = 0;
     int Cont1 = 0 ;
     String NewName = "";
     String FSubString = "";
     String ESubString = "";
     
            
        char[] GenName = Name.toCharArray();
        
        //System.out.println(Name + " :Funcion Gen_Name ");
        
        for(int x=0; x<GenName.length; x++){
           
            if(GenName[x]== Fsplit){
                Cont1 ++;
                if(Cont1 == 2){
                   
                    FMarker = x;
                
                System.out.println(FMarker + "  Prueba Marcador inicial _");
                System.out.println(GenName[x] + "  Posicion del Primer Marcador Encontrado");
                }
                
            }
        
        }
        
        
         for(int z=0;z<GenName.length; z++){
           
            if(GenName[z]== LSplit){
                                   
                    Lmarker = z;
                    
                System.out.println(Lmarker + " Prueba Marcador Secundario -.-");
                System.out.println(GenName[z] + " Posicion del Segundo Marcador Encontrado");              
                
            }
        
        }
         
         FSubString = Name.toString().substring(0,FMarker );
         
         System.out.println(FSubString + ":Primera parte del Nombre del Archivo");
         
         ESubString = Name.toString().substring(Lmarker );
         
         System.out.println(ESubString + ": Ultima parte del nombre del Archivo");
         
         NewName = FSubString +ESubString;
         
         System.out.println(NewName + ": Compilado del Nombre del Archivo");
         
         Cnames.RenameFile(NewName,Name);
         
         
         
         
        
        
        
    }
    
    
    public static void RenameFile(String EndName, String TempName){
        
        String PathEnd =  Mroute.getAbsolutePath() + "\\"  + EndName;
        System.out.println(PathEnd + "Pruba nombre Final del Archivo");
        
        String PathStart =  Mroute.getAbsolutePath() + "\\"  + TempName;
        System.out.println(PathStart + "Prueba nombre inicial del Archivo");
        
        Origen = FileSystems.getDefault().getPath(PathStart);
        Destino = FileSystems.getDefault().getPath(PathEnd);
        
        System.out.println("Prueba Ruta Origen: " + Origen);
        System.out.println("Prueba Ruta Destino:  " +  Destino);
        
        
        try {
            
            Files.move(Origen, Destino, StandardCopyOption.REPLACE_EXISTING);
            
        } catch (IOException e) {
            
            System.err.println(e);
        }
           
        
    }
         
    
    
}


