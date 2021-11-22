import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*Eventos de pantalla*/
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;

public class Empleados {

    static int vista_actual=1;
    static Carta_Empleado item_seleccionado;

    Empleados(JPanel ventana) throws IOException {
        super();
        /* Creando Fondo Boleta */
        
        JPanel fondo_boleta = new JPanel();
        fondo_boleta.setBounds(30, 100, 930, 250);
        fondo_boleta.setBackground(new Color(0x1F2A40));
        ventana.setLayout(null);
        ventana.setBounds(229, 0, 1025, 823);

        BufferedImage logo_empleado = ImageIO.read(new File("img/Empleados/logo_empleado.png"));
        JLabel label_logo_empleado  = new JLabel(new ImageIcon(logo_empleado ));
        label_logo_empleado.setBounds(60, 10, 100, 100);
        ventana.add(label_logo_empleado);

        Font titulo_font = new Font("cooper black", Font.PLAIN, 30);

        JLabel text_usuario = new JLabel();
        text_usuario.setText("Empleado");
        text_usuario.setBounds(160, 0, 200, 100);
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

        /*Empleado Extrayendo de la base de datos */
        int longitud =Conexiones.obtener_numero_columna("EMPLEADO");

        String id[]=new String[longitud];
        String nombre[]=new String[longitud];
        String apellido[]=new String[longitud];
        String dni[]=new String[longitud];
        String ubigeo[]=new String[longitud];
        String bonus[]=new String[longitud];
        String calificacion[]=new String[longitud];
        String direccion[]=new String[longitud];
        String usuario[]=new String[longitud];
        String password[]=new String[longitud];
        String cuenta[]=new String[longitud];
        String email[]=new String[longitud];
        String celular[]=new String[longitud];

        /*Insertando los datos en sus repesctivos arrays */
        System.out.println("La longitus es "+longitud);
        id=Conexiones.toda_columna(id,"EMPLEADO","IDEMPLEA");
        nombre=Conexiones.toda_columna(nombre,"EMPLEADO","NOMREEMPLE");
        apellido=Conexiones.toda_columna(apellido,"EMPLEADO","APELLIDOEMPLE");
        dni=Conexiones.toda_columna(dni,"EMPLEADO","DNIEMPLE");
        ubigeo=Conexiones.toda_columna(ubigeo,"EMPLEADO","CODUBIEMPLE");
        bonus=Conexiones.toda_columna(bonus,"EMPLEADO","BONUS");
        calificacion=Conexiones.toda_columna(calificacion,"EMPLEADO","CALIFICACION");
        direccion=Conexiones.toda_columna(direccion,"EMPLEADO","UBICACION");
        usuario=Conexiones.toda_columna(usuario,"EMPLEADO","USUARIO");
        password=Conexiones.toda_columna(password,"EMPLEADO","PASSWORD");
        cuenta=Conexiones.toda_columna(cuenta,"EMPLEADO","ESTDCUENT");
        email=Conexiones.toda_columna(email,"EMPLEADO","EMAILEMPLE");
        celular=Conexiones.toda_columna(celular,"EMPLEADO","CELULAREMPLE");


        /*Ubicacion de los items */
        int maps[][][]={
            {{324, 130, 100, 100},{324, 175, 140, 100},{324, 224, 140, 100},{330, 110, 100, 40},{100, 100, 409, 232}},
            {{730, 130, 100, 100},{730, 175, 140, 100},{730, 224, 140, 100},{730, 110, 100, 40},{500, 100, 409, 232}},
            {{324, 400, 100, 100},{324, 440, 140, 100},{324, 495, 140, 100},{330, 380, 100, 40},{100, 370, 409, 232}},
            {{730, 400, 100, 100},{730, 440, 140, 100},{730, 495, 140, 100},{730, 380, 100, 40},{500, 370, 409, 232}}};

        Carta_Empleado objetos_empleados[]=new Carta_Empleado[longitud];

        for(int i=0; i<objetos_empleados.length; i++){

            Carta_Empleado objt1;

            if(i%4==0){
                objt1= new Carta_Empleado(id[i],nombre[i],apellido[i],dni[i],ubigeo[i],bonus[i],calificacion[i],direccion[i],usuario[i],password[i],cuenta[i],email[i],celular[i],maps[0][0],maps[0][1],maps[0][2],maps[0][3],maps[0][4]);
                
            }else{
                objt1= new Carta_Empleado(id[i],nombre[i],apellido[i],dni[i],ubigeo[i],bonus[i],calificacion[i],direccion[i],usuario[i],password[i],cuenta[i],email[i],celular[i],maps[i%4][0],maps[i%4][1],maps[i%4][2],maps[i%4][3],maps[i%4][4]);
            }

            objetos_empleados[i]=objt1;
        }


        for(int i=0;i<objetos_empleados.length;i++){

            ventana.add(objetos_empleados[i].celular);
            ventana.add(objetos_empleados[i].correo);
            ventana.add(objetos_empleados[i].direccion);
            ventana.add(objetos_empleados[i].empleado);
            ventana.add(objetos_empleados[i].label_atras);
            ventana.add(objetos_empleados[i].label_usuario);

            objetos_empleados[i].celular.setVisible(false);
            objetos_empleados[i].correo.setVisible(false);
            objetos_empleados[i].direccion.setVisible(false);
            objetos_empleados[i].empleado.setVisible(false);
            objetos_empleados[i].label_atras.setVisible(false);
            objetos_empleados[i].label_usuario.setVisible(false);

        }


        for(int i=0;i<4; i++){
            objetos_empleados[i].celular.setVisible(true);
            objetos_empleados[i].correo.setVisible(true);
            objetos_empleados[i].direccion.setVisible(true);
            objetos_empleados[i].empleado.setVisible(true);
            objetos_empleados[i].label_atras.setVisible(true);
            objetos_empleados[i].label_usuario.setVisible(true);
        }       


        for(Carta_Empleado i : objetos_empleados){
            JLabel datos_label[] = {i.celular,i.correo,i.direccion,i.label_usuario,i.empleado};
            Patrones.evento_item_seleccionar_empleado(datos_label,i);
        }


        /* flechas */
        BufferedImage derecha_flecha = ImageIO.read(new File("img/Empleados/derecha.png"));
        JLabel label_derecha_flecha = new JLabel(new ImageIcon(derecha_flecha));
        label_derecha_flecha.setBounds(880, 325, 180, 40);
        ventana.add(label_derecha_flecha);

        BufferedImage izquierda_flecha = ImageIO.read(new File("img/Empleados/izquierda.png"));
        JLabel label_izquierda_flecha = new JLabel(new ImageIcon(izquierda_flecha));
        label_izquierda_flecha.setBounds(0, 325, 180, 40);
        ventana.add(label_izquierda_flecha);

        /* BOTONES */

        /* Botones-Paneles */
        RoundedPanel boton_eliminar = new RoundedPanel(40);
        boton_eliminar.setBounds(250, 720, 130, 45);
        boton_eliminar.setBackground(new Color(0xF9E76D));
        boton_eliminar.setOpaque(false);
        ventana.add(boton_eliminar);

        RoundedPanel boton_editar = new RoundedPanel(40);
        boton_editar.setBounds(430, 720, 130, 45);
        boton_editar.setBackground(new Color(0xF9E76D));
        boton_editar.setOpaque(false);
        ventana.add(boton_editar);

        RoundedPanel boton_agregar = new RoundedPanel(40);
        boton_agregar.setBounds(600, 720, 130, 45);
        boton_agregar.setBackground(new Color(0xF9E76D));
        boton_agregar.setOpaque(false);
        ventana.add(boton_agregar);

        /* Texto Botones */
        Font font_botones = new Font("Roboto", Font.PLAIN, 20);
        JLabel texto_eliminar = new JLabel("Eliminar");
        texto_eliminar.setFont(font_botones);
        boton_eliminar.add(texto_eliminar);

        JLabel texto_editar = new JLabel("Editar");
        texto_editar.setFont(font_botones);
        boton_editar.add(texto_editar);

        JLabel texto_agregar = new JLabel("Agregar");
        texto_agregar.setFont(font_botones);
        boton_agregar.add(texto_agregar);

        
        /* Agregando Eventos */
        
        Patrones.evento_flechas_empleado(label_derecha_flecha, 1,objetos_empleados);
        Patrones.evento_flechas_empleado(label_izquierda_flecha,-1,objetos_empleados);


        /* Paneles de los botones */
        boton_agregar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    EmpleadosForm objeto1 = new EmpleadosForm(item_seleccionado,false,ventana);
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
                    EmpleadosForm objeto1 = new EmpleadosForm(item_seleccionado,true,ventana);
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
                String query="UPDATE EMPLEADO SET ESTDCUENT ="+0+ " WHERE IDEMPLEA="+item_seleccionado.id_dato;
                Conexiones.modificar_tablas(query);
                
                ventana.removeAll();
                ventana.revalidate();
                ventana.repaint();

                try {
                    Empleados obj1 = new Empleados(ventana);
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

    }

}

class Carta_Empleado {
    /* Variables */
    JLabel celular = new JLabel();
    JLabel correo = new JLabel();
    JLabel direccion = new JLabel();
    JLabel empleado = new JLabel();

    BufferedImage usuario = ImageIO.read(new File("img/Empleados/ficha_empleado.png"));
    JLabel label_usuario = new JLabel(new ImageIcon(usuario));

    BufferedImage atras_img = ImageIO.read(new File("img/Usuario/vuelta_atras.png"));
    JLabel label_atras = new JLabel(new ImageIcon(atras_img));

    /*Datos del DB */

    String id_dato;
    String nombre_dato;
    String apellido_dato;
    String dni_dato;
    String ubigeo_dato;
    String bonus_dato;
    String calificacion_dato;
    String direccion_dato;
    String usuario_dato;
    String password_dato;
    String cuenta_dato;
    String email_dato;
    String celular_dato;


    Carta_Empleado(String id,String empleados,String apellido,String dni,String ubigeo,String bonus,String calificacion,String direccion,String usuario,String password,String estado,String email,String celular, int posicion_celular[] ,int posicion_correo[],int posicion_direccion[],int posicion_empleado[] ,int posicion_imgusuario[]) throws IOException{


        /*Rellenando Dato */
        id_dato=id;
        nombre_dato=empleados;
        apellido_dato=apellido;
        dni_dato=dni;
        ubigeo_dato=ubigeo;
        bonus_dato=bonus;
        calificacion_dato=calificacion;
        direccion_dato=direccion;
        usuario_dato=usuario;
        password_dato=password;
        cuenta_dato=estado;
        email_dato=email;
        celular_dato=celular;


        /*Evento abrir carta trasera*/
        Patrones.evento_atrascarta_empleado(label_atras,dni_dato,direccion_dato,bonus_dato,calificacion_dato);
        

        this.celular.setText(celular);
        this.celular.setBounds(posicion_celular[0],posicion_celular[1], posicion_celular[2], posicion_celular[3]);
        this.celular.setForeground(Color.white);


        correo.setText(email);
        correo.setBounds(posicion_correo[0], posicion_correo[1], posicion_correo[2], posicion_correo[3]);
        correo.setForeground(Color.white);
        
    
        
        this.direccion.setText(direccion);
        this.direccion.setBounds(posicion_direccion[0], posicion_direccion[1], posicion_direccion[2], posicion_direccion[3]);
        this.direccion.setForeground(Color.white);
        
    
                
        empleado.setText(empleados);
        empleado.setBounds(posicion_empleado[0], posicion_empleado[1] ,posicion_empleado[2], posicion_empleado[3]);
        empleado.setForeground(Color.white);

        
        label_atras.setBounds(posicion_empleado[0] +90, posicion_empleado[1]+160,posicion_empleado[2], posicion_empleado[3]);
        
        
    
        label_usuario.setBounds(posicion_imgusuario[0], posicion_imgusuario[1], posicion_imgusuario[2], posicion_imgusuario[3]);
        
    }

}