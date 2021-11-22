import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JFileChooser;

/*Eventos de pantalla*/
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;


public class ProductosForm {



    ProductosForm()throws IOException {

        JFrame ventana_comprobante = new JFrame();
        ventana_comprobante.setVisible(true);
        ventana_comprobante.setSize(593, 762);
        ventana_comprobante.setLayout(null);
        ventana_comprobante.getContentPane().setBackground(new Color(0x383241));

        Font titulo_font = new Font("Roboto", Font.PLAIN, 48);
        JLabel formulario = new JLabel();
        formulario.setBounds(165, 52, 253, 34);
        formulario.setText("Formulario");
        formulario.setFont(titulo_font);
        formulario.setForeground(new Color(0XF15959));

        JLabel formulario_2 = new JLabel();
        formulario_2.setBounds(185, 104, 199, 34);
        formulario_2.setText("Producto");
        formulario_2.setFont(titulo_font);
        formulario_2.setForeground(new Color(0XF15959));

        BufferedImage editar2_image = ImageIO.read(new File("img/Usuario/editar.png"));
        JLabel editable2 = new JLabel(new ImageIcon(editar2_image));
        editable2.setBounds(460, 69, 52, 64);

        Font nombre_font = new Font("Roboto", Font.PLAIN, 24);
        JLabel nombre = new JLabel();
        nombre.setBounds(18, 208, 98, 24);
        nombre.setText("Nombre:");
        nombre.setFont(nombre_font);
        nombre.setForeground(Color.white);

        Font precio_font = new Font("Roboto", Font.PLAIN, 24);
        JLabel precio = new JLabel();
        precio.setBounds(18, 270, 79, 24);
        precio.setText("Precio:");
        precio.setFont(precio_font);
        precio.setForeground(Color.white);

        Font cantidad_font = new Font("Roboto", Font.PLAIN, 24);
        JLabel cantidad = new JLabel();
        cantidad.setBounds(286, 270, 119, 24);
        cantidad.setText("Cantidad:");
        cantidad.setFont(cantidad_font);
        cantidad.setForeground(Color.white);

        Font marca_font = new Font("Roboto", Font.PLAIN, 24);
        JLabel marca = new JLabel();
        marca.setBounds(18, 348, 86, 24);
        marca.setText("Marca:");
        marca.setFont(marca_font);
        marca.setForeground(Color.white);

        Font categoria_font = new Font("Roboto", Font.PLAIN, 24);
        JLabel categoria = new JLabel();
        categoria.setBounds(18, 411, 119, 24);
        categoria.setText("categoria:");
        categoria.setFont(categoria_font);
        categoria.setForeground(Color.white);

        JTextField nombre_entrada = new JTextField();
        nombre_entrada.setBounds(118, 208, 448, 29);

        JTextField precio_entrada = new JTextField();
        precio_entrada.setBounds(118, 270, 166, 29);

        JTextField cantidad_entrada = new JTextField();
        cantidad_entrada.setBounds(403, 270, 166, 29);

        JTextField marca_entrada = new JTextField();
        marca_entrada.setBounds(146, 352, 420, 29);

        JTextField categoria_entrada = new JTextField();
        categoria_entrada.setBounds(146, 411, 420, 29);

        Patrones.evento_entrada(nombre_entrada);
        Patrones.evento_entrada(precio_entrada);
        Patrones.evento_entrada(cantidad_entrada);
        Patrones.evento_entrada(marca_entrada);
        Patrones.evento_entrada(categoria_entrada);

        JButton boton1 = new JButton("Crear");
        boton1.setBounds(30, 675, 134, 27);
        boton1.setForeground(Color.WHITE);
        boton1.setFont(new Font("Roboto", Font.PLAIN, 24));
        boton1.setBackground(new Color(0xF15959));
        

        JButton boton2 = new JButton("<html>Añadir<br/>Imagen</html>");
        boton2.setBounds(216, 528, 140, 62);
        boton2.setForeground(Color.WHITE);
        boton2.setFont(new Font("Roboto", Font.PLAIN, 24));
        boton2.setBackground(new Color(0xF15959));
        boton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            File archivo_seleccionado;   
            JFileChooser seleccionar=new JFileChooser();
            seleccionar.setFileSelectionMode(JFileChooser.FILES_ONLY);
    
            seleccionar.showOpenDialog(null);
    
            /*Cambiando destino del archivo*/
    
            archivo_seleccionado=seleccionar.getSelectedFile();
            String ruta=archivo_seleccionado.getAbsolutePath();
    
            Path origen= Path.of(ruta);
            Path destino=Path.of("img/Productos/img-productos");
    
            try{
                Path copiar= Files.copy(origen,destino.resolve(origen.getFileName()));
                System.out.println("Este es el nombre de la imagen "+ origen.getFileName());
            }catch(Exception ex){
                System.out.println("Error copying "+ e);
            }
    
                }
        });


        JButton boton3 = new JButton("Cancelar");
        boton3.setBounds(385, 675, 134, 27);
        boton3.setForeground(Color.WHITE);
        boton3.setFont(new Font("Roboto", Font.PLAIN, 24));
        boton3.setBackground(new Color(0xF15959));

        ventana_comprobante.add(formulario);
        ventana_comprobante.add(formulario_2);
        ventana_comprobante.add(editable2);
        ventana_comprobante.add(nombre);
        ventana_comprobante.add(precio);
        ventana_comprobante.add(cantidad);
        ventana_comprobante.add(marca);
        ventana_comprobante.add(categoria);
        ventana_comprobante.add(nombre_entrada);
        ventana_comprobante.add(precio_entrada);
        ventana_comprobante.add(cantidad_entrada);
        ventana_comprobante.add(marca_entrada);
        ventana_comprobante.add(categoria_entrada);
        ventana_comprobante.add(boton1);
        ventana_comprobante.add(boton2);
        ventana_comprobante.add(boton3);
        ventana_comprobante.repaint();
    }
}
