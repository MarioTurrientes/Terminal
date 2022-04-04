
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Arrays;



public class MiniFile_Manager {
    
    
    //Metodo cd:
    public static void cd_info(String dir) { 
        
            File file_nuevo = new File(""+ dir);
                    
            if(file_nuevo.exists()){
                file_nuevo = file_nuevo.getAbsoluteFile(); //Se actualiza la ruta.
                System.out.println("Se encuentra en: "+dir);
            }else{
                System.out.println("No existe el directorio");
            }
        }
    
    
    //Metodo cd ..
    public static void cd_Puntos(){
        
        File file = new File("");
        file = file.getParentFile();
    }
    
    
    //Metodo ls para mostrar los directorios y archivos:
    public static void ls(File carpeta) throws Exception{

        if (carpeta.isDirectory()) {
            File[] vectorArchivos = carpeta.listFiles();

            for (int i = 0; i < vectorArchivos.length; i++) {

                File f = vectorArchivos[i];

                if (f.isDirectory()) {

                    System.out.println("*: " + f.getName());
                }
            }

            for (int z = 0; z< vectorArchivos.length; z++) {
                File f = vectorArchivos[z];
                if (f.isFile()) {
                    System.out.println("A: " + f.getName());
                }
            }
            
            Arrays.sort(vectorArchivos);
            for(int i = 0; i < vectorArchivos.length; i++)
            {
                System.out.println(vectorArchivos[i] + " ");
            }
        } else {
            throw new FileNotFoundException("La ruta introducida no es correcta");
        }
    }
    
    //Metodo ls para mostrar los directorios y archivos:
    public static void ll(File carpeta) throws Exception{

        if (carpeta.isDirectory()) {
            File[] vectorArchivos = carpeta.listFiles();
            SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

            for (int i = 0; i < vectorArchivos.length; i++) {

                File f = vectorArchivos[i];

                    if (f.isDirectory()) {

                        System.out.println("*: " + f.getName() +" "+ formato.format(f.lastModified()));
                    }
            }

            for (int z = 0; z< vectorArchivos.length; z++) {
                File f = vectorArchivos[z];
                
                
                if (f.isFile()) {
                    System.out.println("A: " + f.getName() +" " + f.length() +" bytes     "+ formato.format(f.lastModified()));
                }
            }
            
            Arrays.sort(vectorArchivos);
            for(int i = 0; i < vectorArchivos.length; i++)
            {
                System.out.println(vectorArchivos[i]);
            }
        } else {
            throw new FileNotFoundException("La ruta introducida no es correcta");
        }
    }
    

    //metod para renombrar:
    public static void mv(){
        
        File carpeta = new File("Documentos");
        File carpeta1 = new File("Info_Project");
        
        //guardamos en una variable a el boolean que nos devuelve el renaTo():
        boolean a = carpeta.renameTo(carpeta1);
            //realizamos un if ya que el renameto devuelve un boolean y si es true se hizo el cambio si no no se realizÃ³:
            if(a == true){
                System.out.println("El renombrado ha sido correcto");
            }else{
            System.out.println("El renombrado no se ha podido realizar");
            }
    }
    
    
    //Metodo para eliminar un fichero o directorio:
    public static void rm(){
        
        File carpeta = new File("Documentos");
        File carpeta1 = new File("Info_Project");
        
            //realizamos un if si se ha producido la eliminacion de uno de los dos archivos que usamos para renombrar dira si lo hizo o no:
            if(carpeta.delete() || carpeta1.delete()){
                  System.out.println("La eliminacion ha sido correcto");
            }else{
               System.out.println("La eliminacion no se ha podido realizar");
            }
    }
    
    
    //Metodo para indicar el directorio de trabajo actual:
    public static void info_pwd(){
        
        File file = new File("");
        String directoryName = file.getAbsoluteFile().toString();
        System.out.println("El directorio de trabajo es: " +directoryName);
    }
    
    
    //Metodo para mkdir:
    public static void info_mkdir(){
        
        File directorio = new File("Fotos");
        boolean crear_d = directorio.mkdir();
                
            if (crear_d){
                System.out.println("Se creo correctamente");
            }else{
                System.out.println("Error. No se creo la carpeta.");
            }
    }
    
    
    //Metodo de help:
    public static void info_help(){
        
        System.out.println("pwd: te indica el espacio de trabajo actual.\n"
                + "cd: cambia la carpeta actual a DIR\n"
                + "cd .. : cambia a la carpeta superior.\n"
                + "ls: muestra los directorios y despues los archivos de la carpeta actual.\n"
                + "ll: igual que ls pero muestra la hora y el tamaÃ±o de cada uno.\n"
                + "mkdir: crea un directorio o carpeta nuevo.\n"
                + "rm : elimina el directorio y los archivos de dentro.\n"
                + "mv: mueve o renombra un archivo.\n"
                + "exit: Salir del terminal.");
    }  
}
