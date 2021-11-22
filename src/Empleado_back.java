import javax.swing.*;
import java.awt.*;
/*Manejo de archivos*/
import java.awt.image.*;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import javax.management.remote.JMXConnector;
import javax.swing.ImageIcon;

/*Herramientas de pantalla*/
import java.awt.Color;
import java.io.File;

/*Componenestes de la Interfaz*/
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Empleado_back {
    Empleado_back(String dni,String dir,String bonu,String Calificacion) throws IOException {       
        JFrame venta_empleado = new JFrame();
        venta_empleado.setVisible(true);
        venta_empleado.setSize(424, 267);
        venta_empleado.setLayout(null);
    
    
    
        Font titulo_text_claver = new Font("cooper black", Font.PLAIN, 27);

        Font datos_text = new Font("cooper black", Font.PLAIN, 20);

        Font datos_text_max = new Font("cooper black", Font.PLAIN, 15);
        
        JLabel Datos = new JLabel();
        Datos.setBounds(150, 0, 100, 50);
        Datos.setText("Datos:");
        Datos.setForeground(Color.white);
        Datos.setFont(titulo_text_claver);
        venta_empleado.add(Datos);

    
        /*DNI */
    
        JLabel DNI = new JLabel();
        DNI.setBounds(10, 30, 100, 50);
        DNI.setText("DNI:");
        DNI.setForeground(Color.white);
        DNI.setFont(datos_text);
        venta_empleado.add(DNI);



        JLabel dni_text = new JLabel();
        dni_text.setBounds(70, 30, 180, 50 );
        dni_text.setText(dni);
        dni_text.setForeground(Color.white);
        dni_text.setFont(datos_text_max);
        venta_empleado.add(dni_text);

        /*Direccion */
    
        JLabel direccion = new JLabel();
        direccion.setBounds(10, 60, 180, 50);
        direccion.setText("Direccion:");
        direccion.setForeground(Color.white);
        direccion.setFont(datos_text);
        venta_empleado.add(direccion);


        JLabel direccion_tex = new JLabel();
        direccion_tex.setBounds(140, 60, 250, 50);
        direccion_tex.setText(dir);
        direccion_tex.setForeground(Color.white);
        direccion_tex.setFont(datos_text_max);
        venta_empleado.add(direccion_tex);

        /*Bonus */

        JLabel bonus = new JLabel();
        bonus.setBounds(10, 100, 180, 50);
        bonus.setText("Bonus:");
        bonus.setForeground(Color.white);
        bonus.setFont(datos_text);
        venta_empleado.add(bonus);
    
        
        JLabel bonus_text = new JLabel();
        bonus_text.setBounds(110, 100, 280, 50);
        bonus_text.setText(bonu);
        bonus_text.setForeground(Color.white);
        bonus_text.setFont(datos_text_max);
        venta_empleado.add(bonus_text);

        /*Calificacion */


        JLabel calificacion = new JLabel();
        calificacion.setBounds(10, 140, 200, 50);
        calificacion.setText("Calificacion :");
        calificacion.setForeground(Color.white);
        calificacion.setFont(datos_text);
        venta_empleado.add(calificacion);



        JLabel calificacion_text = new JLabel();
        calificacion_text.setBounds(160, 140, 280, 50);
        calificacion_text.setText(Calificacion);
        calificacion_text.setForeground(Color.white);
        calificacion_text.setFont(datos_text_max);
        venta_empleado.add(calificacion_text);


        
        /*Cantidad Ventas */
    
        JLabel ventas = new JLabel();
        ventas.setBounds(10, 180, 180, 50);
        ventas.setText("Cant.Ventas:");
        ventas.setForeground(Color.white);
        ventas.setFont(datos_text);
        venta_empleado.add(ventas);

        JLabel ventas_text = new JLabel();
        ventas_text.setBounds(160, 180, 280, 50);
        ventas_text.setText("xxxxxxxxxxxxxxxxx");
        ventas_text.setForeground(Color.white);
        ventas_text.setFont(datos_text_max);
        venta_empleado.add(ventas_text);
    
        BufferedImage empleado = ImageIO.read(new File("img/Empleados/empleado.jpeg"));
        JLabel labe_empleado = new JLabel(new ImageIcon(empleado));
        labe_empleado.setBounds(0, 0,408, 228);
        venta_empleado.add(labe_empleado);

        venta_empleado.repaint();
    }

}