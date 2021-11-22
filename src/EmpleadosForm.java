import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;

public class EmpleadosForm{
    EmpleadosForm(Carta_Empleado data,boolean editar,JPanel actualizar)throws IOException{
        
        JFrame ventana_comprobante = new JFrame();
        ventana_comprobante.setVisible(true);
        ventana_comprobante.setSize(593, 762);
        ventana_comprobante.setLayout(null);
        ventana_comprobante.getContentPane().setBackground(new Color(0x383241));


        Font titulo_font = new Font("Roboto", Font.PLAIN, 40);
        JLabel formulario = new JLabel();
        formulario.setBounds(215, 16, 259, 48);
        formulario.setText("Formulario");
        formulario.setFont(titulo_font);
        formulario.setForeground(new Color(0XF15959));

        JLabel formulario_2 = new JLabel();
        formulario_2.setBounds(205, 71, 200, 48);
        formulario_2.setText("Empleados");
        formulario_2.setFont(titulo_font);
        formulario_2.setForeground(new Color(0XF15959));

        BufferedImage editar_image = ImageIO.read(new File("img/Usuario/editar.png"));
        JLabel editable = new JLabel(new ImageIcon(editar_image));
        editable.setBounds(472,42,52,64);


        
        Font nombre_font = new Font("Roboto", Font.PLAIN, 24);
        JLabel nombre = new JLabel();
        nombre.setBounds(11, 167, 100, 29);
        nombre.setText("Nombre:");
        nombre.setFont(nombre_font);
        nombre.setForeground(Color.white);

        Font apellido_font = new Font("Roboto", Font.PLAIN, 24);
        JLabel apellido = new JLabel();
        apellido.setBounds(294, 167, 105, 29);
        apellido.setText("Apellido:");
        apellido.setFont(apellido_font);
        apellido.setForeground(Color.white);

        Font celular_font = new Font("Roboto", Font.PLAIN, 24);
        JLabel celular = new JLabel();
        celular.setBounds(11, 221, 87, 29);
        celular.setText("Celular:");
        celular.setFont(celular_font);
        celular.setForeground(Color.white);

        Font DNI_font = new Font("Roboto", Font.PLAIN, 24);
        JLabel DNI = new JLabel();
        DNI.setBounds(336, 221, 56, 29);
        DNI.setText("DNI:");
        DNI.setFont(DNI_font);
        DNI.setForeground(Color.white);

        Font ubicacion_font = new Font("Roboto", Font.PLAIN, 24);
        JLabel ubicacion = new JLabel();
        ubicacion.setBounds(11, 313, 120, 29);
        ubicacion.setText("Ubicacion:");
        ubicacion.setFont(ubicacion_font);
        ubicacion.setForeground(Color.white);

        Font Email_font = new Font("Roboto", Font.PLAIN, 24);
        JLabel Email = new JLabel();
        Email.setBounds(11, 390, 69, 29);
        Email.setText("Email:");
        Email.setFont(Email_font);
        Email.setForeground(Color.white);





        JTextField nombre_entrada = new JTextField();
        nombre_entrada.setBounds(116, 169, 166, 29);

        JTextField apellido_entrada = new JTextField();
        apellido_entrada.setBounds(405, 169, 166, 29);

        JTextField celular_entrada = new JTextField(15);
        celular_entrada.setBounds(116, 221, 166, 29);
        
        JTextField DNI_entrada = new JTextField(15);
        DNI_entrada.setBounds(405, 221, 166, 29);

        JTextField ubicacion_entrada = new JTextField(15);
        ubicacion_entrada.setBounds(157, 310, 404, 29);

        JTextField Email_entrada = new JTextField(15);
        Email_entrada.setBounds(157, 390, 404, 29);



        Patrones.evento_entrada(nombre_entrada);
        Patrones.evento_entrada(apellido_entrada);
        Patrones.evento_entrada(celular_entrada);
        Patrones.evento_entrada(DNI_entrada);
        Patrones.evento_entrada(ubicacion_entrada);
        Patrones.evento_entrada(Email_entrada);



        JButton boton1 = new JButton("Crear");
        boton1.setBounds(22,670,135,27);
        boton1.setForeground(Color.WHITE);
        boton1.setFont(new Font("Roboto",Font.PLAIN,24));
        boton1.setBackground(new Color(0xF15959));

        JButton boton2 = new JButton("Cancelar");
        boton2.setBounds(422,670,135,27);
        boton2.setForeground(Color.WHITE);
        boton2.setFont(new Font("Roboto",Font.PLAIN,24));
        boton2.setBackground(new Color(0xF15959));

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(editar){

                    
                    String query="UPDATE EMPLEADO SET NOMREEMPLE ='"+nombre_entrada.getText()+ "' WHERE IDEMPLEA="+Integer.parseInt(data.id_dato);

                    String query2="UPDATE EMPLEADO SET APELLIDOEMPLE ='"+apellido_entrada.getText()+ "' WHERE IDEMPLEA="+Integer.parseInt(data.id_dato);

                    String query3="UPDATE EMPLEADO SET CELULAREMPLE ='"+celular_entrada.getText()+ "' WHERE IDEMPLEA="+Integer.parseInt(data.id_dato);

                    String query4="UPDATE EMPLEADO SET EMAILEMPLE ='"+Email_entrada.getText()+ "' WHERE IDEMPLEA="+Integer.parseInt(data.id_dato);

                    String query5="UPDATE EMPLEADO SET DNIEMPLE ='"+DNI_entrada.getText()+ "' WHERE IDEMPLEA="+Integer.parseInt(data.id_dato);

                    String query6="UPDATE EMPLEADO SET UBICACION ='"+ubicacion_entrada.getText()+ "' WHERE IDEMPLEA="+Integer.parseInt(data.id_dato);

                    System.out.println(query);

                    Conexiones.modificar_tablas(query);
                    Conexiones.modificar_tablas(query2);
                    Conexiones.modificar_tablas(query3);
                    Conexiones.modificar_tablas(query4);
                    Conexiones.modificar_tablas(query5);
                    Conexiones.modificar_tablas(query6);

                    actualizar.removeAll();
                    actualizar.revalidate();
                    actualizar.repaint();

                    try {
                        Empleados obj1 = new Empleados(actualizar);
                    } catch (IOException e1) {

                        e1.printStackTrace();
                    }


                    ventana_comprobante.dispose();

                }else{
                    int longitud =Conexiones.obtener_numero_columnaall("EMPLEADO");
                    longitud +=1;

                    String queryi="INSERT INTO EMPLEADO VALUES("+longitud+",'"+nombre_entrada.getText()+"','"+apellido_entrada.getText()+"','"+DNI_entrada.getText()+"','6789',"+100+","+4.7+",'"+ubicacion_entrada.getText()+"','usuario','1234',"+1+ ",'"+Email_entrada.getText()+"','"+celular_entrada.getText()+"')";

                    System.out.println(queryi);
                    Conexiones.modificar_tablas(queryi);

                    
                    actualizar.removeAll();
                    actualizar.revalidate();
                    actualizar.repaint();

                    try {
                        Empleados obj1 = new Empleados(actualizar);
                    } catch (IOException e1) {

                        e1.printStackTrace();
                    }


                    ventana_comprobante.dispose();

                }
                System.out.println("Hola Carnal");
            }
        });
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_comprobante.dispose();
            }
        });



        if(editar){
            nombre_entrada.setText(data.nombre_dato);
            apellido_entrada.setText(data.apellido_dato);
            celular_entrada.setText(data.celular_dato);
            DNI_entrada.setText(data.dni_dato);
            ubicacion_entrada.setText(data.direccion_dato);
            Email_entrada.setText(data.email_dato);
            boton1.setText("Guardar");
        }else{}

        ventana_comprobante.add(formulario);
        ventana_comprobante.add(formulario_2);
        ventana_comprobante.add(editable);
        ventana_comprobante.add(nombre);
        ventana_comprobante.add(apellido);
        ventana_comprobante.add(celular);
        ventana_comprobante.add(DNI);
        ventana_comprobante.add(ubicacion);
        ventana_comprobante.add(Email);

        ventana_comprobante.add(nombre_entrada);
        ventana_comprobante.add(apellido_entrada);
        ventana_comprobante.add(celular_entrada);
        ventana_comprobante.add(DNI_entrada);
        ventana_comprobante.add(ubicacion_entrada);
        ventana_comprobante.add(Email_entrada);

        ventana_comprobante.add(boton1);
        ventana_comprobante.add(boton2);
        ventana_comprobante.repaint();
    }
}