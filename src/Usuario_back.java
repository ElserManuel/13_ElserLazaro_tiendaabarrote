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


public class Usuario_back {

    Usuario_back(String dir,String appe,String dn,String estd) throws IOException {       
    JFrame venta_usuario = new JFrame();
    venta_usuario.setVisible(true);
    venta_usuario.setSize(420, 274);
    venta_usuario.setLayout(null);


    

    JLabel dato = new JLabel();
    dato.setBounds(180,5, 100, 50);
    dato.setForeground(Color.white);
    dato.setText("Datos:");

    venta_usuario.add(dato);


    /*Direccion */

    JLabel direccion = new JLabel();
    direccion.setBounds(30, 30, 100, 50);
    direccion.setText("direccion:");
    direccion.setForeground(Color.white);
    venta_usuario.add(direccion);

    
    JLabel interactiva = new JLabel();
    interactiva.setBounds(90, 30, 100, 50);
    interactiva.setForeground(Color.white);
    interactiva.setText(dir);
    venta_usuario.add(interactiva);

    /*Apellido */

    JLabel Apellido = new JLabel();
    Apellido.setBounds(30, 70, 100, 50);
    Apellido.setText("Apellido:");
    Apellido.setForeground(Color.white);
    venta_usuario.add(Apellido);

    JLabel elapellido = new JLabel();
    elapellido.setBounds(85, 70, 100, 50);
    elapellido.setForeground(Color.white);
    elapellido.setText(appe);
    venta_usuario.add(elapellido);

    /*DNI*/

    JLabel DNI = new JLabel();
    DNI.setBounds(30, 110, 100, 50);
    DNI.setText("DNI:");
    DNI.setForeground(Color.white);
    venta_usuario.add(DNI);

    JLabel eldni = new JLabel();
    eldni.setBounds(55, 110, 100, 50);
    eldni.setForeground(Color.white);
    eldni.setText(dn);
    venta_usuario.add(eldni);


    /*Estado*/

    JLabel estado = new JLabel();
    estado.setBounds(30, 150, 150, 50);
    estado.setText(" ESTADO DE CUENTA :");
    estado.setForeground(Color.white);
    venta_usuario.add(estado);

    JLabel elestado = new JLabel();
    elestado.setBounds(160, 150, 100, 50);
    elestado.setForeground(Color.white);
    elestado.setText(estd);
    venta_usuario.add(elestado);

    /*Cantidad*/

    JLabel cantidad = new JLabel();
    cantidad.setBounds(30, 190, 150, 50);
    cantidad.setText("CANTIDAD DE COMPRAS  :");
    cantidad.setForeground(Color.white);
    venta_usuario.add(cantidad);

    JLabel lacantidad = new JLabel();
    lacantidad.setBounds(180, 190, 100, 50);
    lacantidad.setForeground(Color.white);
    lacantidad.setText("por definir");
    venta_usuario.add(lacantidad);


    /*Fondo carta */

    BufferedImage usuario = ImageIO.read(new File("img/Usuario/datos_usuario.jpeg"));
    JLabel labe_usuario = new JLabel(new ImageIcon(usuario));
    labe_usuario.setBounds(2,0,400,240);
    venta_usuario.add(labe_usuario);


    venta_usuario.repaint();


}

}