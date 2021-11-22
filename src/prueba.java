import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JFileChooser;

public class prueba {
    public static void main(String[] args) throws IOException{
        

        File archivo_seleccionado;   
        JFileChooser seleccionar=new JFileChooser();
        seleccionar.setFileSelectionMode(JFileChooser.FILES_ONLY);

        seleccionar.showOpenDialog(null);

        /*Cambiando destino del archivo*/

        archivo_seleccionado=seleccionar.getSelectedFile();
        String ruta=archivo_seleccionado.getAbsolutePath();

        Path origen= Path.of(ruta);
        Path destino=Path.of("img/Productos");

        try{
            Path copiar= Files.copy(origen,destino.resolve(origen.getFileName()));
            System.out.println("Este es el nombre de la imagen "+ origen.getFileName());
        }catch(Exception e){
            System.out.println("Error copying "+ e);
        }

        
    }
    
}

