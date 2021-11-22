/*Eventos de pantalla*/
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;
import java.awt.AlphaComposite;
/*Herramientas de pantalla*/
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


/*Manejo de archivos*/
import java.awt.image.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.imageio.ImageIO;

/*Componenestes de la Interfaz*/
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

class ColorArrowUI extends BasicComboBoxUI {

    public static ComboBoxUI createUI(JComponent c) {
        return new ColorArrowUI();
    }

    @Override
    protected JButton createArrowButton() {
        return new BasicArrowButton(BasicArrowButton.SOUTH, new Color(0x2A2C3C), new Color(0x2A2C3C), Color.WHITE,
                new Color(0x2A2C3C));
    }
}

interface Accion_Modificar {
    void resetear(int n1);
}

public class Principal {

    static JFrame ventana = new JFrame();
    String[] Usuarios = { "Username" };
    static int estado_actual = 1;

    private Principal() {
        super();
    }

    public static void activar(JPanel ezquinas, JPanel fondo) {
        fondo.setBackground(new Color(0x353F52));
        ezquinas.setBackground(new Color(0xDC576A));
    }

    public void desactivar(JPanel ezquina, JPanel fondo) {
        ezquina.setBackground(new Color(0x2A2C3C));
        fondo.setBackground(new Color(0x2A2C3C));
    }

    private void insertando_datos(String archivo,String name) throws FileNotFoundException{
        Conexiones base_datos = new Conexiones();
        
        if(base_datos.crear_registro){
            FileReader lector=new FileReader("data/tablas.txt");
            BufferedReader lectura=new BufferedReader(lector);
            
            try {
                String query = lectura.readLine();
                while(query!=null){
                    base_datos.modificar_tablas(query);
                    query = lectura.readLine();
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


        String cadena;
        try{
            FileReader lector=new FileReader(archivo);
            BufferedReader lectura=new BufferedReader(lector);
            cadena = lectura.readLine();
            

            while(cadena!=null){
                String query="INSERT INTO "+name+" VALUES"+cadena;
                base_datos.modificar_tablas(query);
                cadena = lectura.readLine();
            }


        }catch(FileNotFoundException ex){
            System.out.println("Error"+ ex);
        }catch (IOException e) {
            e.printStackTrace();
        }


    }


    void creaGui() throws IOException {
        
        try{
            insertando_datos("data/usuario.txt","CLIENTE");
            insertando_datos("data/empleado.txt","EMPLEADO");
            insertando_datos("data/producto.txt","PRODUCTO");
        }catch(IOException e) {
            System.out.println("ya existen los datos");
        }



        


        /* Configurando ventana principal */

        ventana.setDefaultLookAndFeelDecorated(true);
        ventana.setSize(1254, 823);
        ventana.setLayout(null);
        ventana.setMinimumSize(new Dimension(1254, 823));
        ventana.setResizable(false);

        /* Centrando Ventana */
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.setTitle("Tienda de Abarrotes");

        /* Creando paneles */

        /* Fondo-ToolMenu */
        JPanel panel_ezquina = new RoundedPanel(15);
        panel_ezquina.setBackground(new Color(0x2A2C3C));
        panel_ezquina.setBounds(0, 0, 229, 823);
        panel_ezquina.setOpaque(false);

        /* Fondo2-Contenido-del-menu-seleccionado */
        JPanel panel_derecha = new JPanel();
        panel_derecha.setBackground(new Color(0XE7E7E7));
        panel_derecha.setBounds(229, 0, 1025, 823);
        panel_derecha.setBorder(new EmptyBorder(0, 0, 0, 0));
        panel_derecha.setLayout(null);

        /***************************************************************************************************/
        /***************************************************************************************************/
        /***********************************
         * TollMenu
         **********************************/

        /* Imagen de Inicio de session */

        BufferedImage image_inicio = ImageIO.read(new File("img/Principal/logo.png"));
        JLabel label_image_inicio = new JLabel(new ImageIcon(image_inicio));
        label_image_inicio.setBounds(70, 30, 78, 84);
        ventana.add(label_image_inicio);

        /* Insertando Combobox de inicio de session */

        Font venta_label2_font2 = new Font("Roboto", Font.PLAIN, 18);
        JComboBox user_list = new JComboBox(Usuarios);
        user_list.setBounds(65, 120, 114, 20);
        user_list.setBackground(new Color(0x2A2C3C));
        user_list.setForeground(Color.WHITE);
        user_list.setFont(venta_label2_font2);
        UIManager.put("ComboBox.selectionBackground", new Color(0x2A2C3C));
        UIManager.put("ComboBox.selectionForeground", Color.WHITE);
        user_list.updateUI();
        user_list.setBorder(null);
        ColorArrowUI obj2 = new ColorArrowUI();
        user_list.setUI(obj2);
        ventana.add(user_list);

        /* Separador */
        JPanel separador1_panel = new JPanel();
        separador1_panel.setBounds(0, 196, 229, 4);
        separador1_panel.setBackground(new Color(0x605959));

        /* Panel-Botones */

        JPanel venta_panel = new JPanel();
        venta_panel.setBounds(0, 200, 229, 67);
        venta_panel.setBackground(new Color(0x353F52));

        JPanel usuario_panel = new JPanel();
        usuario_panel.setBounds(0, 267, 229, 67);
        usuario_panel.setBackground(new Color(0x2A2C3C));

        JPanel producto_panel = new JPanel();
        producto_panel.setBounds(0, 334, 229, 67);
        producto_panel.setBackground(new Color(0x2A2C3C));

        JPanel resumen_panel = new JPanel();
        resumen_panel.setBounds(0, 401, 229, 67);
        resumen_panel.setBackground(new Color(0x2A2C3C));

        JPanel empleados_panel = new JPanel();
        empleados_panel.setBounds(0, 468, 229, 67);
        empleados_panel.setBackground(new Color(0x2A2C3C));

        /*---------------Segunda parte----------------*/

        JPanel about_panel = new JPanel();
        about_panel.setBounds(0, 539, 229, 67);
        about_panel.setBackground(new Color(0x2A2C3C));

        JPanel help_panel = new JPanel();
        help_panel.setBounds(0, 606, 229, 67);
        help_panel.setBackground(new Color(0x2A2C3C));

        JPanel soporte_panel = new JPanel();
        soporte_panel.setBounds(0, 673, 229, 67);
        soporte_panel.setBackground(new Color(0x2A2C3C));

        /* Separador2 */
        JPanel separador2_panel = new JPanel();
        separador2_panel.setBounds(0, 535, 229, 4);
        separador2_panel.setBackground(new Color(0x605959));

        /* Estado de los paneles(panel rojo que aparece cuando selecciona el menu) */

        JPanel venta_estado = new JPanel();
        venta_estado.setBounds(0, 200, 17, 67);
        venta_estado.setBackground(new Color(0xDC576A));

        JPanel usuario_estado = new JPanel();
        usuario_estado.setBounds(0, 267, 17, 67);
        usuario_estado.setBackground(new Color(0x2A2C3C));

        JPanel producto_estado = new JPanel();
        producto_estado.setBounds(0, 334, 17, 67);
        producto_estado.setBackground(new Color(0x2A2C3C));

        JPanel resumen_estado = new JPanel();
        resumen_estado.setBounds(0, 401, 17, 67);
        resumen_estado.setBackground(new Color(0x2A2C3C));

        JPanel empleados_estado = new JPanel();
        empleados_estado.setBounds(0, 468, 17, 67);
        empleados_estado.setBackground(new Color(0x2A2C3C));

        /*---------------Segunda parte Estado----------------*/

        JPanel about_estado = new JPanel();
        about_estado.setBounds(0, 539, 17, 67);
        about_estado.setBackground(new Color(0x2A2C3C));

        JPanel help_estado = new JPanel();
        help_estado.setBounds(0, 606, 17, 67);
        help_estado.setBackground(new Color(0x2A2C3C));

        JPanel soporte_estado = new JPanel();
        soporte_estado.setBounds(0, 673, 17, 67);
        soporte_estado.setBackground(new Color(0x2A2C3C));

        /* Insertando Texto */

        Font venta_label2_font = new Font("Roboto", Font.PLAIN, 18);

        JLabel venta_label = new JLabel("Venta-Boleta");
        venta_label.setForeground(Color.WHITE);
        venta_label.setBounds(60, 220, 160, 30);
        venta_label.setFont(venta_label2_font);

        JLabel usuario_label = new JLabel("Clientes");
        usuario_label.setForeground(Color.WHITE);
        usuario_label.setBounds(60, 287, 160, 30);
        usuario_label.setFont(venta_label2_font);

        JLabel producto_label = new JLabel("Productos");
        producto_label.setForeground(Color.WHITE);
        producto_label.setBounds(60, 354, 160, 30);
        producto_label.setFont(venta_label2_font);

        JLabel resumen_label = new JLabel("Resumen");
        resumen_label.setForeground(Color.WHITE);
        resumen_label.setBounds(60, 421, 160, 30);
        resumen_label.setFont(venta_label2_font);

        JLabel empleados_label = new JLabel("Empleados");
        empleados_label.setForeground(Color.WHITE);
        empleados_label.setBounds(60, 488, 160, 30);
        empleados_label.setFont(venta_label2_font);

        /*---------------Segunda parte Texto----------------*/

        JLabel about_label = new JLabel("About");
        about_label.setForeground(Color.WHITE);
        about_label.setBounds(60, 559, 160, 30);
        about_label.setFont(venta_label2_font);

        JLabel help_label = new JLabel("Help");
        help_label.setForeground(Color.WHITE);
        help_label.setBounds(60, 625, 160, 30);
        help_label.setFont(venta_label2_font);

        JLabel soporte_label = new JLabel("Soporte");
        soporte_label.setForeground(Color.WHITE);
        soporte_label.setBounds(60, 692, 160, 30);
        soporte_label.setFont(venta_label2_font);

        try {
            Venta venta_objeto = new Venta(panel_derecha,ventana);
        } catch (Exception ex) {

        }

        /*********************************************************/
        /****************** Agregando Escuchadores *****************/
        /*********************************************************/

        Accion_Modificar obj1 = new Accion_Modificar() {
            @Override
            public void resetear(int n1) {

                panel_derecha.removeAll();
                panel_derecha.revalidate();
                panel_derecha.repaint();
                ventana.repaint();

                if (n1 == 1) {
                    desactivar(venta_estado, venta_panel);
                } else if (n1 == 2) {
                    desactivar(usuario_estado, usuario_panel);
                } else if (n1 == 3) {
                    desactivar(producto_estado, producto_panel);
                } else if (n1 == 4) {
                    desactivar(resumen_estado, resumen_panel);
                } else if (n1 == 5) {
                    desactivar(empleados_estado, empleados_panel);
                } else if (n1 == 6) {
                    desactivar(about_estado, about_panel);
                } else if (n1 == 7) {
                    desactivar(help_estado, help_panel);
                } else if (n1 == 8) {
                    desactivar(soporte_estado, soporte_panel);
                }
            }
        };


        Patrones.evento_mouse_principal(venta_panel, venta_estado, venta_label, 1, obj1, panel_derecha);

        Patrones.evento_mouse_principal(usuario_panel,usuario_estado,usuario_label, 2, obj1, panel_derecha);

        Patrones.evento_mouse_principal(producto_panel,producto_estado,producto_label, 3, obj1, panel_derecha);

        Patrones.evento_mouse_principal(resumen_panel,resumen_estado,resumen_label, 4, obj1, panel_derecha);

        Patrones.evento_mouse_principal(empleados_panel,empleados_estado,empleados_label, 5, obj1, panel_derecha);


        /*--------------Segunda parte Escuchadores---------------------*/
        Patrones.evento_mouse_principal(about_panel,about_estado,about_label,6, obj1, panel_derecha);

        Patrones.evento_mouse_principal(help_panel,help_estado,help_label,7, obj1, panel_derecha);

        Patrones.evento_mouse_principal(soporte_panel,soporte_estado,soporte_label,8, obj1, panel_derecha);



        /*****************************************************************/
        /*****************************************************************/
        /*****************************************************************/

        /* Orden en el que se colocan los paneles */

        /* Insertando textos */
        ventana.add(venta_label);
        ventana.add(usuario_label);
        ventana.add(producto_label);
        ventana.add(resumen_label);
        ventana.add(about_label);
        ventana.add(help_label);
        ventana.add(soporte_label);
        ventana.add(empleados_label);

        /* Insertando estados */
        ventana.add(venta_estado);
        ventana.add(usuario_estado);
        ventana.add(producto_estado);
        ventana.add(resumen_estado);
        ventana.add(about_estado);
        ventana.add(help_estado);
        ventana.add(soporte_estado);
        ventana.add(empleados_estado);

        /* Insertando paneles */
        ventana.add(separador1_panel);
        ventana.add(venta_panel);
        ventana.add(usuario_panel);
        ventana.add(producto_panel);
        ventana.add(resumen_panel);
        ventana.add(empleados_panel);
        ventana.add(about_panel);
        ventana.add(help_panel);
        ventana.add(soporte_panel);
        ventana.add(separador2_panel);

        ventana.add(panel_ezquina);
        ventana.add(panel_derecha);

    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Principal().creaGui();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}


class RoundedPanel extends JPanel {
    private Color backgroundColor;
    private int cornerRadius = 15;
    boolean agregar=false;
    BufferedImage image;

    public RoundedPanel(LayoutManager layout, int radius) {
        super(layout);
        cornerRadius = radius;
    }

    public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
        super(layout);
        cornerRadius = radius;
        backgroundColor = bgColor;
    }

    public RoundedPanel(int radius) {
        super();
        cornerRadius = radius;
    }

    public RoundedPanel(int radius, Color bgColor) {
        super();
        cornerRadius = radius;
        backgroundColor = bgColor;
    }

    public void insertar_imagen(BufferedImage paths,JPanel ventana){
        agregar=true;
        image=paths;
        ventana.repaint();
  }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draws the rounded panel with borders.
        if (backgroundColor != null) {
            graphics.setColor(backgroundColor);
        } else {
            graphics.setColor(getBackground());
        }
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // pintar background
        graphics.setColor(getForeground());
        graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // pintar borde
        if(agregar){
            g.drawImage(image, 0, 0, this);
        }
    }
}

