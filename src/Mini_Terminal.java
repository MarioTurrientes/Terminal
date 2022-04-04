
import java.io.*;
import java.util.*;

//enlace de github:

public class Mini_Terminal {

    public static void main(String[] args) throws Exception {
        
        //Variable:
        String teclado = "";
  
        //Objetyo Scanner:
        Scanner terminal = new Scanner(System.in);
        
        
        //bucle para que se repita:
        do{
            System.out.print("~$> ");
            
            //lee el comando elegido:
            teclado = terminal.nextLine();
            
            //creamos un array String y con split corta hasta que exista un espacio y te lo cuenta como posicion 0:
            String[] comando = teclado.split(" ");
            
            
            //Dependiendo de lo que el usuario escriba realiza una opcion u otra:
            //Opcion para ver el directorio actual de trabajo:
            if (comando[0].equals("pwd")){
                
                MiniFile_Manager.info_pwd();
            }
            
            if (comando[0].equals("cd") && comando[1].equals("..")){
                
                MiniFile_Manager.cd_Puntos();
            
            }else if(comando[0].equals("cd")){
                
                MiniFile_Manager.cd_info(comando[1]);
            }
            
            if(comando[0].equals("ls")){
                
                try{
                    File file = new File("");
                    String directoryName = file.getAbsoluteFile().toString();
                    File carpeta = new File(directoryName);
                    MiniFile_Manager.ls(carpeta);
                }catch(Exception e){
                    System.out.println("La ruta no existe");
                }
            }
            
            if(comando[0].equals("ll")){
                
                try{
                    File file = new File("");
                    String directoryName = file.getAbsoluteFile().toString();
                    File carpeta = new File(directoryName);
                    MiniFile_Manager.ll(carpeta);
                }catch(Exception e){
                    System.out.println("La ruta no existe");
                }
            }
            
            //Opcion para crear un directorio nuevo con metodo mkdir():
            if(comando[0].equals("mkdir")){
                
               MiniFile_Manager.info_mkdir();
            }
            
            if(comando[0].equals("rm")){
                
                MiniFile_Manager.rm();
            }
            
            if(comando[0].equals("mv")){
             
                MiniFile_Manager.mv();
            }
            
            //Opcion para ver los comando para poder usar y lo que hacen:
            if(comando[0].equals("help")){
                
               MiniFile_Manager.info_help();
            }
                    
        }while(!"exit".equals(teclado));
    }
}
