import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.io.File;

/*Manejo de archivos*/
import java.awt.image.*;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

/*Eventos de pantalla*/
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;

public class Boleta {

        Boleta(JPanel ventana_venta) throws IOException {
                super();
                String[] filtro = { "Estado Pago", "Cliente" };

                Font titulo_font = new Font("Roboto", Font.PLAIN, 48);
                JLabel titulo = new JLabel();
                titulo.setBounds(100, 20, 190, 66);
                titulo.setText("BOLETA");
                titulo.setFont(titulo_font);

                BufferedImage boleta_logo = ImageIO.read(new File("img/Boleta/boleta_logo.png"));
                JLabel label_boleta_logo = new JLabel(new ImageIcon(boleta_logo));
                label_boleta_logo.setBounds(20, 9,91, 85);
                ventana_venta.add(label_boleta_logo);


                /* Filtro */
                Font etiquetas_font = new Font("Roboto", Font.PLAIN, 18);
                JLabel nombre = new JLabel();
                nombre.setBounds(24, 104, 104, 33);
                nombre.setText("Filtrar por");
                nombre.setFont(etiquetas_font);

                JTextField filtrar_entradas = new JTextField();
                filtrar_entradas.setBounds(131, 102, 350, 36);

                JComboBox filtrar = new JComboBox(filtro);
                filtrar.setSelectedItem("");
                filtrar.setBounds(24, 138, 104, 20);

                /* Emision */

                JLabel emision = new JLabel();
                emision.setBounds(516, 102, 102, 33);
                emision.setText("F.Emision");
                emision.setFont(etiquetas_font);

                JTextField emision_entradas = new JTextField();
                emision_entradas.setBounds(619, 104, 115, 27);

                /* Hasta */

                JLabel hasta = new JLabel();
                hasta.setBounds(790, 102, 102, 33);
                hasta.setText("hasta");
                hasta.setFont(etiquetas_font);

                JTextField hasta_entradas = new JTextField();
                hasta_entradas.setBounds(860, 104, 115, 27);

                /* JPanel */
                JPanel registro = new JPanel();
                registro.setBounds(22, 163, 963, 630);
                registro.setBackground(Color.WHITE);

                /** Estado de Cuentas */
                JPanel paga_panel = new RoundedPanel(15);
                paga_panel.setBounds(30, 177, 227, 87);
                paga_panel.setBackground(new Color(0xE2FBDF));

                JPanel pendiente_panel = new RoundedPanel(15);
                pendiente_panel.setBounds(266, 177, 227, 87);
                pendiente_panel.setBackground(new Color(0xFBEFDF));

                JPanel bono_panel = new RoundedPanel(15);
                bono_panel.setBounds(504, 177, 227, 87);
                bono_panel.setBackground(new Color(0xDFFBF4));

                JPanel vencido_panel = new RoundedPanel(15);
                vencido_panel.setBounds(742, 177, 227, 87);
                vencido_panel.setBackground(new Color(0xFBE5DF));

                /* Etiquetas de los Estados */
                JLabel paga_etiquetas = new JLabel("Pagado");
                paga_etiquetas.setFont(etiquetas_font);
                paga_etiquetas.setBounds(89, 188, 104, 38);

                JLabel pendientes_etiquetas = new JLabel("Pendientes");
                pendientes_etiquetas.setFont(etiquetas_font);
                pendientes_etiquetas.setBounds(317, 188, 114, 38);

                JLabel bonada_etiquetas = new JLabel("Bonadas");
                bonada_etiquetas.setFont(etiquetas_font);
                bonada_etiquetas.setBounds(579, 188, 90, 38);

                JLabel vencida_etiquetas = new JLabel("Vencidas");
                vencida_etiquetas.setFont(etiquetas_font);
                vencida_etiquetas.setBounds(801, 188, 100, 38);

                /* Columnas Encabezado */
                JLabel cliente_encabezado = new JLabel("Cliente");
                cliente_encabezado.setFont(etiquetas_font);
                cliente_encabezado.setBounds(45, 286, 63, 39);

                JLabel factura_encabezado = new JLabel("NºFactura");
                factura_encabezado.setFont(etiquetas_font);
                factura_encabezado.setBounds(169, 286, 111, 39);

                JLabel emision_encabezado = new JLabel("<html>Fecha de<br/>Emision</html>", SwingConstants.CENTER);
                emision_encabezado.setFont(etiquetas_font);
                emision_encabezado.setBounds(341, 284, 134, 39);

                JLabel total_encabezado = new JLabel("Total");
                total_encabezado.setFont(etiquetas_font);
                total_encabezado.setBounds(536, 286, 80, 39);

                JLabel estado_encabezado = new JLabel("<html>Estado<br/>Pago</html>", SwingConstants.CENTER);
                estado_encabezado.setFont(etiquetas_font);
                estado_encabezado.setBounds(669, 270, 100, 80);

                JLabel acciones_encabezado = new JLabel("acciones");
                acciones_encabezado.setFont(etiquetas_font);
                acciones_encabezado.setBounds(839, 291, 93, 39);

                JLabel separador1_panel = new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                separador1_panel.setFont(etiquetas_font);
                separador1_panel.setBounds(45,319,923,38);

                int posicion[][][]= {
                {{831,361,33,27},{876,359,33,32},{922,364,38,21}},
                {{831,493,33,27},{876,490,33,32},{922,495,38,21}},
                {{831,609,33,27},{876,606,33,32},{922,612,38,21}},
                {{831,723,33,27},{876,720,33,32},{922,726,38,21}}};

                Boleta_item arr_boleta[]=new Boleta_item[4];
                for (int i = 0; i <4;i++){
                        Boleta_item obj1 = new Boleta_item(posicion[i][0],posicion[i][1],posicion[i][2]);
                        arr_boleta[i] = obj1;
                }

                for (int i = 0; i <4; i++){
                        ventana_venta.add(arr_boleta[i].label_image_editar);
                        ventana_venta.add(arr_boleta[i].label_image_eliminar);
                        ventana_venta.add(arr_boleta[i].label_image_observar);

                        /*Agregando Eventos */
                        
                        Patrones.evento_mouse(arr_boleta[i].label_image_editar,"editar","img/Boleta/");
                        Patrones.evento_mouse(arr_boleta[i].label_image_eliminar,"eliminar","img/Boleta/");
                        Patrones.evento_mouse(arr_boleta[i].label_image_observar,"observar","img/Boleta/");
                }

                

                JLabel separador2_panel = new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                separador2_panel.setFont(etiquetas_font);
                separador2_panel.setBounds(45,434,923,38);


                JLabel separador3_panel = new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                separador3_panel.setFont(etiquetas_font);
                separador3_panel.setBounds(45,552,923,38);

                JLabel separador4_panel = new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                separador4_panel.setFont(etiquetas_font);
                separador4_panel.setBounds(45,670,923,38);



                /* Agregando componentes */
                ventana_venta.add(separador4_panel);
                ventana_venta.add(separador3_panel);
                ventana_venta.add(separador2_panel);
                ventana_venta.add(separador1_panel);


                ventana_venta.add(cliente_encabezado);
                ventana_venta.add(factura_encabezado);
                ventana_venta.add(emision_encabezado);
                ventana_venta.add(total_encabezado);
                ventana_venta.add(estado_encabezado);
                ventana_venta.add(acciones_encabezado);

                ventana_venta.add(paga_etiquetas);
                ventana_venta.add(pendientes_etiquetas);
                ventana_venta.add(bonada_etiquetas);
                ventana_venta.add(vencida_etiquetas);

                ventana_venta.add(paga_panel);
                ventana_venta.add(pendiente_panel);
                ventana_venta.add(bono_panel);
                ventana_venta.add(vencido_panel);

                ventana_venta.add(titulo);

                ventana_venta.add(nombre);

                ventana_venta.add(filtrar);
                ventana_venta.add(filtrar_entradas);

                ventana_venta.add(emision);
                ventana_venta.add(emision_entradas);

                ventana_venta.add(hasta);
                ventana_venta.add(hasta_entradas);

                ventana_venta.add(registro);

                ventana_venta.repaint();

        }
}

 class Boleta_item{

        BufferedImage image_editar = ImageIO.read(new File("img/Boleta/editar.png"));
        JLabel label_image_editar = new JLabel(new ImageIcon(image_editar));

        BufferedImage image_eliminar = ImageIO.read(new File("img/Boleta/eliminar.png"));
        JLabel label_image_eliminar = new JLabel(new ImageIcon(image_eliminar));
        
        BufferedImage image_observar = ImageIO.read(new File("img/Boleta/observar.png"));
        JLabel label_image_observar = new JLabel(new ImageIcon(image_observar));

        /*Datos Boleta */
        int id_client;
        int n_factura;
        String fech_emision;
        int n_total;
        String estado;


         Boleta_item(int editar[],int eliminar[],int observar[])throws IOException{

                label_image_editar.setBounds(editar[0],editar[1], editar[2], editar[3]);
                

                label_image_eliminar.setBounds(eliminar[0],eliminar[1], eliminar[2], eliminar[3]);
                

                label_image_observar.setBounds(observar[0],observar[1], observar[2], observar[3]);


         }
 }