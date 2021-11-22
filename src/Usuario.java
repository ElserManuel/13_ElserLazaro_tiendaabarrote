/*Manejo de archivos*/
import java.awt.image.*;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*Herramientas de pantalla*/
import java.awt.Color;
import java.io.File;

/*Componenestes de la Interfaz*/
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.JTextField;

/*Eventos de pantalla*/
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;

import java.awt.*;
import javax.swing.*;

public class Usuario {

    static int vista_actual=1;
    static Carta_Usuario item_seleccionado;



    Usuario(JPanel ventana) throws IOException{
        super();

        /* Creando Fondo Boleta */
        JPanel fondo_boleta = new JPanel();
        fondo_boleta.setBounds(30, 100, 930, 250);
        fondo_boleta.setBackground(new Color(0x1F2A40));
        ventana.setLayout(null);
        ventana.setBounds(229, 0, 1025, 823);


        BufferedImage logo_usuario = ImageIO.read(new File("img/Usuario/usuario.png"));
        JLabel label_logo_usuario  = new JLabel(new ImageIcon(logo_usuario ));
        label_logo_usuario.setBounds(30, 10, 100, 80);
        ventana.add(label_logo_usuario);


        Font titulo_font = new Font("cooper black", Font.PLAIN, 30);
        JLabel text_usuario = new JLabel();
        text_usuario.setText("Usuario");
        text_usuario.setBounds(150, 22, 150, 60);
        text_usuario.setFont(titulo_font);
        ventana.add(text_usuario);


        JTextField buscar = new JTextField();
        buscar.setText("");
        buscar.setBounds(651, 30, 200, 43);
        ventana.add(buscar);

        
        BufferedImage buscar_opciones = ImageIO.read(new File("img/Empleados/opciones.png"));
        JLabel label_buscar_opciones = new JLabel(new ImageIcon(buscar_opciones));
        label_buscar_opciones.setBounds(834, 30, 58, 42);
        ventana.add(label_buscar_opciones);
        
        BufferedImage buscar_barra = ImageIO.read(new File("img/Empleados/buscar.png"));
        JLabel label_buscar_barra = new JLabel(new ImageIcon(buscar_barra));
        label_buscar_barra.setBounds(600, 30, 58, 42);
        ventana.add(label_buscar_barra);

        BufferedImage buscar_alreves = ImageIO.read(new File("img/Empleados/alreves.png"));
        JLabel label_buscar_alreves = new JLabel(new ImageIcon(buscar_alreves));
        label_buscar_alreves.setBounds(830, 30, 58, 42);
        ventana.add(label_buscar_alreves);
        
        
        /*Usuario Extrayendo de la base de datos */
        int longitud =Conexiones.obtener_numero_columna("CLIENTE");
        

        String celular[]=new String[longitud];
        String gmail[]=new String[longitud];
        String direccion[]=new String[longitud];        
        String nombre[]=new String[longitud];
        String dni[]=new String[longitud];
        String apellido[]=new String[longitud];
        String cuenta[]=new String[longitud];
        String id[]=new String[longitud];


        try {
            
            /*Colocando los datos respectivo de la base de datos*/
            System.out.println("La longitus es "+longitud);
            celular=Conexiones.toda_columna(celular,"CLIENTE", "CELULARCLIE"); 
            gmail=Conexiones.toda_columna(gmail,"CLIENTE","EMAILCLIE");
            direccion=Conexiones.toda_columna(direccion,"CLIENTE","UBICACION");
            nombre=Conexiones.toda_columna(nombre,"CLIENTE","NOMBRECLIE");
            dni=Conexiones.toda_columna(dni,"CLIENTE","DNICLIE");
            apellido=Conexiones.toda_columna(apellido,"CLIENTE","APELLIDOCLIE");
            cuenta=Conexiones.toda_columna(cuenta,"CLIENTE","ESTDCUENT");
            id=Conexiones.toda_columna(id,"CLIENTE","IDCLIENTE");
            
        }catch(Exception ex){
            System.out.println("Error +");
        }
          

        int maps[][][]={
            {{350, 130, 100, 100},{350, 160, 140, 100},{350, 197, 140, 100},{160, 200, 100, 100},{100, 100, 396, 227}},
            {{750, 130, 100, 100},{750, 160, 140, 100},{750, 197, 140, 100},{559, 200, 100, 100},{500, 100, 396, 227}},
            {{350, 400, 100, 100},{350, 430, 140, 100},{350, 470, 140, 100},{160, 470, 100, 100},{100, 370, 396, 227}},
            {{750, 400, 100, 100},{750, 430, 140, 100},{750, 470, 140, 100},{559, 470, 100, 100},{500, 370, 396, 227}}};


        Carta_Usuario obj_usuario[]=new Carta_Usuario[longitud];


        /*Creando e insertando los items cartas en un array */
        for (int i = 0; i <obj_usuario.length;i++){

            Carta_Usuario objt1;
                if(i%4==0){
                    objt1= new Carta_Usuario(id[i],cuenta[i],dni[i],apellido[i],celular[i],gmail[i],direccion[i],nombre[i],maps[0][0],maps[0][1],maps[0][2],maps[0][3],maps[0][4]);

                }else{
                    objt1= new Carta_Usuario(id[i],cuenta[i],dni[i],apellido[i],celular[i],gmail[i],direccion[i],nombre[i],maps[i%4][0],maps[i%4][1],maps[i%4][2],maps[i%4][3],maps[i%4][4]);
                }

                obj_usuario[i]=objt1;

        }
            

         /*Añadiendo al panel y haciendolos invisible */
        for(int i=0;i<obj_usuario.length; i++){

            ventana.add(obj_usuario[i].celular);
            ventana.add(obj_usuario[i].correo);
            ventana.add(obj_usuario[i].direccion);
            ventana.add(obj_usuario[i].usuarios);
            ventana.add(obj_usuario[i].label_atras);
            ventana.add(obj_usuario[i].label_usuario);

            obj_usuario[i].celular.setVisible(false);
            obj_usuario[i].correo.setVisible(false);
            obj_usuario[i].direccion.setVisible(false);
            obj_usuario[i].usuarios.setVisible(false);
            obj_usuario[i].label_atras.setVisible(false);
            obj_usuario[i].label_usuario.setVisible(false);
        }


        /*Haciendo visible solo los 4 primeros items */

        for(int i=0;i<4; i++){
            obj_usuario[i].celular.setVisible(true);
            obj_usuario[i].correo.setVisible(true);
            obj_usuario[i].direccion.setVisible(true);
            obj_usuario[i].usuarios.setVisible(true);
            obj_usuario[i].label_atras.setVisible(true);
            obj_usuario[i].label_usuario.setVisible(true);
        }


        /*Agregando el evento de seleccion de carta */
        for(Carta_Usuario i : obj_usuario){
            JLabel datos_label[] = {i.celular,i.correo,i.direccion,i.label_usuario,i.usuarios};
            Patrones.evento_item_seleccionar_usuario(datos_label,i);
        }



        /*flechas */
        BufferedImage derecha_flecha = ImageIO.read(new File("img/Usuario/derecha.png"));
        JLabel label_derecha_flecha = new JLabel(new ImageIcon(derecha_flecha));
        label_derecha_flecha.setBounds(880, 325, 180, 40);
        ventana.add(label_derecha_flecha);

        BufferedImage izquierda_flecha = ImageIO.read(new File("img/Usuario/izquierda.png"));
        JLabel label_izquierda_flecha = new JLabel(new ImageIcon(izquierda_flecha));
        label_izquierda_flecha.setBounds(0, 325, 180, 40);
        ventana.add(label_izquierda_flecha);


        Patrones.evento_flechas_usuario(label_derecha_flecha, 1,obj_usuario);
        Patrones.evento_flechas_usuario(label_izquierda_flecha,-1,obj_usuario);




        /* BOTONES */

        /* Botones-Paneles */
        RoundedPanel boton_eliminar = new RoundedPanel(40);
        boton_eliminar.setBounds(250, 650, 130, 45);
        boton_eliminar.setBackground(new Color(0xF9E76D));
        boton_eliminar.setOpaque(false);
        ventana.add(boton_eliminar);

        RoundedPanel boton_editar = new RoundedPanel(40);
        boton_editar.setBounds(430, 650, 130, 45);
        boton_editar.setBackground(new Color(0xF9E76D));
        boton_editar.setOpaque(false);
        ventana.add(boton_editar);

        RoundedPanel boton_agregar = new RoundedPanel(40);
        boton_agregar.setBounds(600, 650, 130, 45);
        boton_agregar.setBackground(new Color(0xF9E76D));
        boton_agregar.setOpaque(false);
        ventana.add(boton_agregar);


        /* Texto Botones */

        Font font_botones = new Font("Roboto", Font.PLAIN, 20);
        JLabel texto_eliminar = new JLabel("Eliminar");
        texto_eliminar.setFont(font_botones);
        boton_eliminar.add(texto_eliminar);
        boton_eliminar.revalidate();


        JLabel texto_editar = new JLabel("Editar");
        texto_editar.setFont(font_botones);
        boton_editar.add(texto_editar);


        JLabel texto_agregar = new JLabel("Agregar");
        texto_agregar.setFont(font_botones);
        boton_agregar.add(texto_agregar);


        /* Agregando Eventos */

        /* Paneles de los botones */
        boton_agregar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    UsuarioForm objeto1 = new UsuarioForm(item_seleccionado,false,ventana);
                } catch (Exception ex) {

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
                boton_agregar.setBackground(new Color(0xEC9626));
                boton_agregar.setCursor(cursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {

                boton_agregar.setBackground(new Color(0xF9E76D));
            }
        });

        boton_editar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    UsuarioForm objeto = new UsuarioForm(item_seleccionado,true,ventana);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
                boton_editar.setBackground(new Color(0xEC9626));
                boton_editar.setCursor(cursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {

                boton_editar.setBackground(new Color(0xF9E76D));
            }
        });

        boton_eliminar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String query="UPDATE CLIENTE SET ESTDCUENT ="+0+ " WHERE IDCLIENTE="+item_seleccionado.id_dato;
                Conexiones.modificar_tablas(query);
                
                ventana.removeAll();
                ventana.revalidate();
                ventana.repaint();

                try {
                    Usuario obj1 = new Usuario(ventana);
                } catch (IOException e1) {

                    e1.printStackTrace();
                }


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
                boton_eliminar.setBackground(new Color(0xEC9626));
                boton_eliminar.setCursor(cursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {

                boton_eliminar.setBackground(new Color(0xF9E76D));
            }
        });
        
        ventana.repaint();

    }
}


class Carta_Usuario {
    /* Variables */
    JLabel celular = new JLabel();
    JLabel correo = new JLabel();
    JLabel direccion = new JLabel();
    JLabel usuarios = new JLabel();

    BufferedImage usuario_img = ImageIO.read(new File("img/Usuario/ficha_usuario.jpeg"));
    JLabel label_usuario = new JLabel(new ImageIcon(usuario_img));

    BufferedImage atras_img = ImageIO.read(new File("img/Usuario/vuelta_atras.png"));
    JLabel label_atras = new JLabel(new ImageIcon(atras_img));


    /*Datos que contiene la base de datos */

    String id_dato;
    String apellido_dato;
    String dni_dato;
    String estado_cuenta_dato;
    String nombre_dato;
    String celular_dato;
    String correo_dato;
    String direccion_dato;




    Carta_Usuario(String id,String cuentas,String dnis,String apellidos,String celulars,String correos, String direcciones, String usuario, int posicion_celular[] , int posicion_correo[],int posicion_direccion[],int posicion_usuario[] ,int posicion_imgusuario[]) throws IOException{


        apellido_dato=apellidos;
        dni_dato=dnis;
        estado_cuenta_dato=cuentas;
        nombre_dato=usuario;
        celular_dato=celulars;
        correo_dato=correos;
        direccion_dato=direcciones;
        id_dato=id;



        /*Evento abrir carta trasera*/
        Patrones.evento_atrascarta_usuarios(label_atras,direcciones,dni_dato,apellido_dato,estado_cuenta_dato);
        
    
        celular.setText(celulars);
        celular.setBounds(posicion_celular[0],posicion_celular[1], posicion_celular[2], posicion_celular[3]);
        celular.setForeground(Color.BLACK);
  
        
        correo.setText(correos);
        correo.setBounds(posicion_correo[0], posicion_correo[1], posicion_correo[2], posicion_correo[3]);
        correo.setForeground(Color.BLACK);

    
        direccion.setText(direcciones);
        direccion.setBounds(posicion_direccion[0], posicion_direccion[1], posicion_direccion[2], posicion_direccion[3]);
        direccion.setForeground(Color.BLACK);
   
    
        usuarios.setText(usuario);
        usuarios.setBounds(posicion_usuario[0]+10, posicion_usuario[1] ,posicion_usuario[2], posicion_usuario[3]);
        usuarios.setForeground(Color.BLACK);


        label_atras.setBounds(posicion_usuario[0]+245, posicion_usuario[1]+43 ,posicion_usuario[2], posicion_usuario[3]);

    
        label_usuario.setBounds(posicion_imgusuario[0], posicion_imgusuario[1], posicion_imgusuario[2], posicion_imgusuario[3]);


    }

}