import com.toedter.calendar.JDateChooser;
/*Manejo de archivos*/
import java.awt.image.*;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;


/*Eventos de pantalla*/
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;

/*Herramientas de pantalla*/
import java.awt.Color;
import java.io.File;

/*Componenestes de la Interfaz*/
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


public class Venta {

    void Seleccionar_imagen() {
        File archivo_seleccionado;
        JFileChooser seleccionar;
        seleccionar = new JFileChooser();
        seleccionar.showOpenDialog(null);
        archivo_seleccionado = seleccionar.getSelectedFile();

    }

    public static JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x1F2A40));
        panel.setLayout(new GridLayout(31, 7, 80, 60));
        for (int i=0; i < 31; i++) {

            for (int j=0; j < 7; j++) {
                JLabel label = new JLabel("label"+i+","+j);
                label.setFont(new Font("Arial", Font.PLAIN, 15));
                label.setForeground(Color.WHITE);
                panel.add(label);
            }

  
        }
        return panel;
     }


    Venta(JPanel ventana,JFrame principal) throws IOException {
        super();

        /* Creando Fondo Boleta */
        JPanel fondo_boleta = new JPanel();
        fondo_boleta.setBounds(30, 100, 930, 250);
        fondo_boleta.setBackground(new Color(0x1F2A40));
        ventana.setLayout(null);
        ventana.setBounds(229, 0, 1025, 823);

        /* Calendario-Emision-Vencimiento */

        /* Emision */

        /* Texto */
        JLabel fech_emision_texto = new JLabel();
        fech_emision_texto.setText("Fec. Emision");
        fech_emision_texto.setBounds(600, 10, 80, 60); /* x, y , w , h */
        ventana.add(fech_emision_texto);
        /* Calendario */
        JDateChooser fech_emision_calendario = new JDateChooser();
        fech_emision_calendario.setBounds(580, 60, 120, 30);
        fech_emision_calendario.getDateEditor().setEnabled(false);
        ventana.add(fech_emision_calendario);

        /* Vencimiento */

        /* Calendario-Emision-Vencimiento */

        /* Emision */

        /* Texto */
        JLabel fech_vencimiento_texto = new JLabel();
        fech_vencimiento_texto.setText("Fec. Vencimiento");
        fech_vencimiento_texto.setBounds(800, 10, 100, 60);
        ventana.add(fech_vencimiento_texto);
        /* Calendario */
        JDateChooser fech_vencimiento_calendario = new JDateChooser();
        fech_vencimiento_calendario.setBounds(790, 60, 120, 30);
        fech_vencimiento_calendario.getDateEditor().setEnabled(false);
        ventana.add(fech_vencimiento_calendario);

        /*************************** Contenido *************************/

        /**************************** Columna1 **************************/

        /* COMPROBANTE */

        /* Comprobante-Label */
        JLabel comprobante_texto = new JLabel();
        comprobante_texto.setText("Tipo de comprobante");
        comprobante_texto.setBounds(40, 10, 160, 250);
        comprobante_texto.setForeground(Color.white);
        ventana.add(comprobante_texto);

        /* Comprobante-Combobox */
        String[] comprobante_lista = { "Factura electronica", "Boleta de venta electronica" };
        JComboBox comprobante_combobox = new JComboBox(comprobante_lista);
        comprobante_combobox.setBounds(40, 150, 160, 30);
        ventana.add(comprobante_combobox);

        /* SERIE */

        /* Serie-Label */
        JLabel serie_texto = new JLabel();
        serie_texto.setText("Serie");
        serie_texto.setBounds(250, 10, 160, 250);
        serie_texto.setForeground(Color.white);
        ventana.add(serie_texto);

        /* Serie-Combobox */
        String[] serie_lista = { "V001" };
        JComboBox lista_combobox = new JComboBox(serie_lista);
        lista_combobox.setBounds(230, 150, 100, 30);
        ventana.add(lista_combobox);

        /* OPERACION */

        /* Operacion-Label */
        JLabel operacion_texto = new JLabel();
        operacion_texto.setText("Tipo de operacion ");
        operacion_texto.setBounds(400, 10, 160, 250);
        operacion_texto.setForeground(Color.white);
        ventana.add(operacion_texto);

        /* Operacion-Combobox */
        String[] operacion_lista = { "venta interna", "Exportacion de Bienes", "Venta pir delivery" };
        JComboBox operacion_combobox = new JComboBox(operacion_lista);
        operacion_combobox.setBounds(370, 150, 160, 30);
        ventana.add(operacion_combobox);

        /* MONEDA */

        /* Moneda-Label */
        JLabel moneda_texto = new JLabel();
        moneda_texto.setText("F. Pago");
        moneda_texto.setBounds(600, 10, 160, 250);
        moneda_texto.setForeground(Color.white);
        ventana.add(moneda_texto);

        /* Moneda-Combobox */
        String[] moneda_lista = { "tarjeta", "monera" };
        JComboBox moneda_combobox = new JComboBox(moneda_lista);
        moneda_combobox.setBounds(570, 150, 120, 30);
        ventana.add(moneda_combobox);

        /* CAMBIO */

        /* Cambio-Label */
        JLabel cambio_texto = new JLabel();
        cambio_texto.setText("Monto");
        cambio_texto.setBounds(800, 10, 160, 250);
        cambio_texto.setForeground(Color.white);
        ventana.add(cambio_texto);

        /* Cambio-TextField */
        JTextField cambio_textfield = new JTextField();
        cambio_textfield.setText("");
        cambio_textfield.setBounds(760, 150, 120, 30);
        ventana.add(cambio_textfield);




        BufferedImage logo = ImageIO.read(new File("img/Venta/logo.png"));
        JLabel labe_logo = new JLabel(new ImageIcon(logo));
        labe_logo.setBounds(9, 0,100,120);
        ventana.add(labe_logo);



        JLabel text_direccion = new JLabel();
        text_direccion.setText("direccion Mz#### Lt #### ");
        text_direccion.setBounds(110,42,180,50);
        ventana.add(text_direccion);




        /***************************** Columna 2 *********************************/

        /* CLIENTE */

        /* Cliente-Label */
        JLabel cliente_texto = new JLabel();
        cliente_texto.setText("Cliente  ( + nuevo )");
        cliente_texto.setBounds(40, 10, 160, 400);
        cliente_texto.setForeground(Color.RED);
        ventana.add(cliente_texto);

        /* Cliente-TextField */

        JTextField cliente_textfield = new JTextField();
        cliente_textfield.setText("Escriba el nombre ");
        cliente_textfield.setBounds(40, 230, 350, 30);
        ventana.add(cliente_textfield);

        /***************************** Columna 3 *********************************/

               Font encabezado = new Font("Roboto", Font.PLAIN,14);
         /* Cantidad-Label */
               JLabel cantidad_texto = new JLabel();
               cantidad_texto.setText("# Cantidad ");
               cantidad_texto.setBounds(40, 10, 160, 550);
               cantidad_texto.setForeground(Color.white);
               cantidad_texto.setFont(encabezado);
               ventana.add(cantidad_texto);
       
               /* MEDIDA */
       
               /* Medida-Label */
               JLabel medida_texto = new JLabel();
               medida_texto.setText("Unidad  Medida ");
               medida_texto.setForeground(Color.white);
               medida_texto.setBounds(156, 10, 160, 550);
               medida_texto.setFont(encabezado);
               ventana.add(medida_texto);
       
               /* CODIGO */
       
               /* Codigo-Label */
               JLabel codigo_texto = new JLabel();
               codigo_texto.setText("Codigo");
               codigo_texto.setForeground(Color.white);
               codigo_texto.setBounds(322, 10, 120, 550);
               codigo_texto.setFont(encabezado);
               ventana.add(codigo_texto);
       
               /* DESCRIPCION */
       
               /* igv */
       
               /* Subtotal-Label */
               JLabel subtotal_label = new JLabel();
               subtotal_label.setText("IGV");
               subtotal_label.setBounds(467, 10, 120, 550);
               subtotal_label.setForeground(Color.white);
               subtotal_label.setFont(encabezado);
               ventana.add(subtotal_label);
       
               /* DESCUENTO */
       
               /* Descuento-Label */
               JLabel descuento_texto = new JLabel();
               descuento_texto.setText(" Descuento.%");
               descuento_texto.setBounds(580, 10, 160, 550);
               descuento_texto.setForeground(Color.white);
               descuento_texto.setFont(encabezado);
               ventana.add(descuento_texto);
       
               /* vuelto */
       
               /* vuelto-Label */
               JLabel vuelto_texto = new JLabel();
               vuelto_texto.setText("Prec.Unitario");
               vuelto_texto.setBounds(720, 10, 160, 550);
               vuelto_texto.setForeground(Color.white);
               vuelto_texto.setFont(encabezado);
               ventana.add(vuelto_texto);
       
               /* total */
       
       
               /* total-Label */
               JLabel total_texto = new JLabel();
               total_texto.setText("Precio total");
               total_texto.setBounds(870, 10, 160, 550);
               total_texto.setForeground(Color.white);
               total_texto.setFont(encabezado);
               ventana.add(total_texto);
       
        

        /***************************** Columna 3 *********************************/

        /* AGREGAR-BOTON */

        /* Agregar-Boton */
        JButton agregar_boton = new JButton();
        agregar_boton.setText("(+) Emitir Boleta ");
        agregar_boton.setBounds(100, 700, 250, 30);
        agregar_boton.setForeground(Color.white);
        agregar_boton.setBackground(new Color(0x1F339A));
        ventana.add(agregar_boton);

        /* CANCELAR */


        /* Cancelar-Boton */
        JButton cancelar_boton = new JButton();
        cancelar_boton.setText("Cancelar");
        cancelar_boton.setBounds(780, 700, 100, 30);
        cancelar_boton.setBackground(new Color(0xE05E5E));
        ventana.add(cancelar_boton);
        ventana.add(fondo_boleta);

        /*Datos  */
        /*Contenedir de Datos */
        
        JPanel contenedor_datos = createPanel();



        final JScrollPane scrollPanel = new JScrollPane(
            contenedor_datos,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollPanel.setBounds(30, 320, 932, 380);
        contenedor_datos.setBounds(30, 320, 932, 380);

        ventana.add(scrollPanel);



        BufferedImage flecha_derecha = ImageIO.read(new File("img/Venta/derecha.png"));
        JLabel label_flecha_derecha = new JLabel(new ImageIcon(flecha_derecha));
        label_flecha_derecha.setBounds(400, 730, 180, 40);
        ventana.add(label_flecha_derecha);

        BufferedImage flecha_izquierda = ImageIO.read(new File("img/Venta/izquierda.png"));
        JLabel label_flecha_izquierda = new JLabel(new ImageIcon(flecha_izquierda));
        label_flecha_izquierda.setBounds(300, 730, 180, 40);
        ventana.add(label_flecha_izquierda);

        ventana.repaint();

        









        /*Agregando Eventos */
        label_flecha_izquierda.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Cursor cursor=new Cursor(Cursor.HAND_CURSOR);
                label_flecha_izquierda.setCursor(cursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        label_flecha_derecha.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.removeAll();
                ventana.revalidate();
                ventana.repaint();
                try{
                    Boleta obj2=new Boleta(ventana);
                }catch (Exception ex){
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
                Cursor cursor=new Cursor(Cursor.HAND_CURSOR);
                label_flecha_derecha.setCursor(cursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
}