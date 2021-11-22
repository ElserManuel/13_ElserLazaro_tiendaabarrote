/*Herramientas de pantalla*/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

/*Manejo de archivos*/
import java.awt.image.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.io.File;
import javax.imageio.ImageIO;

/*Componenestes de la Interfaz*/
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.*;

import java.awt.*;
/*Eventos de pantalla*/
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Cursor;


class Resumen {

    
    Resumen(JPanel ventana) throws IOException {
        super();


        /*Textos*/

        Font titulo = new Font("Roboto", Font.BOLD, 25);
        JLabel text_1 = new JLabel("DIA");
        JLabel text_2 = new JLabel("SEMANA");
        JLabel text_3 = new JLabel("MES");
        text_1.setFont(titulo);
        text_2.setFont(titulo);
        text_3.setFont(titulo);


        // DIAS
        JPanel ventana_dia = new RoundedPanel(30);
        ventana_dia.setBounds(148, 24, 234, 75);
        ventana_dia.setBackground(new Color(0xE7E7E7));
        ventana_dia.setForeground(new Color(0xE7E7E7));
        ventana_dia.setOpaque(false);
        ventana_dia.add(text_1);


        // SEMANA
        JPanel ventana_semana = new RoundedPanel(30);
        ventana_semana.setBounds(398, 24, 234, 75);
        ventana_semana.setBackground(Color.WHITE);
        ventana_semana.setForeground(new Color(0xE7E7E7));
        ventana_semana.setOpaque(false);
        ventana_semana.add(text_2);


        // MES
        JPanel ventana_mes = new RoundedPanel(30);
        ventana_mes.setBounds(654,24, 234, 75);
        ventana_mes.setBackground(new Color(0xE7E7E7));
        ventana_mes.setForeground(new Color(0xE7E7E7));
        ventana_mes.setOpaque(false);
        ventana_mes.add(text_3);


        /*Panel Contenedor Grafica*/
        JPanel contendor_grafica=new RoundedPanel(90);
        contendor_grafica.setBackground(Color.WHITE);
        contendor_grafica.setLayout(null);
        contendor_grafica.setBounds(153,90,752,392);
        contendor_grafica.setOpaque(false);
        contendor_grafica.setForeground(Color.WHITE);

        ventana.add(contendor_grafica);

        /*Insertando Imagen*/

        BufferedImage puesto1 = ImageIO.read(new File("img/Resumen/primero.png"));
        JLabel puesto1_imagen = new JLabel(new ImageIcon(puesto1));
        puesto1_imagen.setBounds(631,510,220,220);
        

        BufferedImage puesto2 = ImageIO.read(new File("img/Resumen/segundo.png"));
        JLabel puesto2_imagen = new JLabel(new ImageIcon(puesto2));
        puesto2_imagen.setBounds(394,510,220,220);
        

        BufferedImage puesto3 = ImageIO.read(new File("img/Resumen/tercero.png"));
        JLabel puesto3_imagen = new JLabel(new ImageIcon(puesto3));
        puesto3_imagen.setBounds(151,510,220,220);

        /*Botones */

        BufferedImage img_derecha = ImageIO.read(new File("img/Resumen/derecha.png"));
        JLabel boton_derecha = new JLabel(new ImageIcon(img_derecha));
        boton_derecha.setBounds(944,258,60,60);
        

        BufferedImage img_izquierda = ImageIO.read(new File("img/Resumen/izquierda.png"));
        JLabel boton_izquierda = new JLabel(new ImageIcon(img_izquierda));
        boton_izquierda.setBounds(50,258,60,60);


        /*Texto de las Imagenes */
        Font subtitulo = new Font("Roboto",Font.BOLD,18);
        JLabel ganador3= new JLabel("TOP");
        ganador3.setFont(subtitulo);
        ganador3.setBounds(244,579,76,37);

        JLabel ganador2= new JLabel("TOP");
        ganador2.setFont(subtitulo);
        ganador2.setBounds(489,579,76,37);

        JLabel ganador1= new JLabel("TOP");
        ganador1.setFont(subtitulo);
        ganador1.setBounds(725,579,76,37);

        /*Texto de las Imagenes */
        Font parrafo_estilo = new Font("Roboto",Font.PLAIN,10);
        JLabel parrafo3= new JLabel("Lorem ipsum texto de prueba");
        parrafo3.setFont(parrafo_estilo);
        parrafo3.setBounds(219,614,100,71);

        JLabel parrafo2= new JLabel("Lorem ipsum texto de prueba");
        parrafo2.setFont(parrafo_estilo);
        parrafo2.setBounds(462,614,100,71);

        JLabel parrafo1= new JLabel("Lorem ipsum texto de prueba");
        parrafo1.setFont(parrafo_estilo);
        parrafo1.setBounds(699,614,100,71);

        MyPanel grafica;
        grafica = new MyPanel();
        
        grafica.setBackground(Color.CYAN);


        /*Especificando el tipo de grafica*/
                /*Ganancias */
                
        grafica.tipo="dispersion";
        grafica.cambiar_color_datos(new Color(0x08CCD5),new Color(0xA67896));
        String encabezado[] ={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        grafica.cambiar_encabezado(encabezado);


        double ganancias[]= {100,900,500,8000,2000,800,1500};

        double perdidas[]= {900,1500,600,700,2500,900,2000};




        grafica.datos=grafica.agregar_Array(ganancias, grafica.datos, 1);
        grafica.datos=grafica.agregar_Array(perdidas, grafica.datos, 2);

        grafica.datos_copia=grafica.agregar_Array(ganancias,grafica.datos_copia,1);
        grafica.datos_copia=grafica.agregar_Array(perdidas,grafica.datos_copia,2);




        grafica.setBounds(50,40,640,320);


        /*Agregando Eventos */

        boton_izquierda.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                grafica.tipo="dispersion";
                grafica.datos=grafica.agregar_Array(ganancias, grafica.datos, 1);
                grafica.datos=grafica.agregar_Array(perdidas, grafica.datos, 2);
                ventana.repaint();
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
            
        });
        boton_derecha.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                grafica.tipo="Barras";
                grafica.datos=grafica.agregar_Array(ganancias, grafica.datos, 1);
                grafica.datos=grafica.agregar_Array(perdidas, grafica.datos, 2);
                ventana.repaint();

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
            
        });
        





        contendor_grafica.add(grafica);
        
        ventana.add(boton_derecha);
        ventana.add(boton_izquierda);

        ventana.add(parrafo1);
        ventana.add(parrafo2);
        ventana.add(parrafo3);


        ventana.add(ganador3);
        ventana.add(ganador2);
        ventana.add(ganador1);
        
        ventana.add(puesto3_imagen);
        ventana.add(puesto2_imagen);
        ventana.add(puesto1_imagen);
        
        ventana.add(ventana_semana);
        ventana.add(ventana_dia);
        ventana.add(ventana_mes);

        ventana.repaint();


    }

}

class MyPanel extends JPanel {

    double datos[][]= new double[1][1];
    double datos_copia[][]=new double[1][1];
    String tipo;
    String[] eje_x;
    Color colores_dato[];
    Color colores_encabezado[]={Color.BLACK};
    

    public void cambiar_color_datos(Color... args){
        System.out.println("verificando algo"+ args.length);
        colores_dato= new Color[args.length];
        for(int i=0;i<args.length;i++){
            colores_dato[i]=args[i];
        }
        
    }


    public void cambiar_encabezado(String... args){
        eje_x= new String[args.length];
        for(int i=0;i<args.length;i++){
            eje_x[i]=args[i];
        }
    }

    MyPanel(){

        
        this.setPreferredSize(new Dimension(600,100));
  
  
    }
    public double obtener_mayor(double[] dato){

        double temp;

        /*Obteniendo el dato mayor */
        double ganancias_temp[]=dato.clone();
        

        for (int i = 0; i < ganancias_temp.length; i++) 
        {
            for (int j = i + 1; j < ganancias_temp.length; j++) { 
                if (ganancias_temp[i] > ganancias_temp[j]) 
                {
                    temp = ganancias_temp[i];
                    ganancias_temp[i] = ganancias_temp[j];
                    ganancias_temp[j] = temp;
                }
            }
        }

        return ganancias_temp[ganancias_temp.length-1];
    }


    public double[] ordenacion_ascendente(double[] dato){

            double temp;
    
            /*Obteniendo el dato mayor */
            double ganancias_temp[]=dato.clone();
            
    
            for (int i = 0; i < ganancias_temp.length; i++) 
            {
                for (int j = i + 1; j < ganancias_temp.length; j++) { 
                    if (ganancias_temp[i] > ganancias_temp[j]) 
                    {
                        temp = ganancias_temp[i];
                        ganancias_temp[i] = ganancias_temp[j];
                        ganancias_temp[j] = temp;
                    }
                }
            }
    
            return ganancias_temp;
    }


    public double[][] agregar_Array(double dato[], double objetivo[][],int fila){
        double temp[][]= new double[fila][dato.length];
        double copy[][]= objetivo.clone();

        for(int i=0;i<fila;i++){
            for(int j=0;j<dato.length;j++){
                if(i!=fila-1){
                    temp[i][j]=copy[i][j];
                }
                
            }
        }


        for(int i=0;i<dato.length;i++){
            temp[fila-1][i]=dato[i];
        }


        return temp;
    }
    

    public void paint(Graphics g){

        
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(new Color(0xC1EF0A));
    
        int rows = 10;

        int cols = 10;
        int widths = getSize().width;
        int heights = getSize().height;
    
        // draw the rows
        int rowHt = heights / (rows);
        for (int i = 0; i < rows; i++){
            g2D.drawLine(0, i * rowHt, widths, i * rowHt);
        }
          
    
        // draw the columns
        int rowWid = widths / (cols);
        for (int i = 0; i < cols; i++){
            g2D.drawLine(i * rowWid, 0, i * rowWid, heights);
        }


        /*Estableciendo largo respecto al ancho del contenedor */
        double buscando_mayor[]= new double[datos.length];
        


        for(int i=0; i<datos.length; i++){
            
            double temp[]= new double[datos[0].length];
            int contador=0;

            for(double j:datos[i]){
                temp[contador]=j;
                contador++;
            }

            double temp_mayor=obtener_mayor(temp);
            buscando_mayor[i]=temp_mayor;
        }

        double mayor_definitivo=obtener_mayor(buscando_mayor);
 
        /*Colocando Alturas respectivas al de la ventana */
        for (int i=0;i<datos.length;i++){
             for(int j=0;j<datos[0].length;j++){
                 datos[i][j]=(datos[i][j]*heights)/mayor_definitivo;
                 if(datos[i][j]==heights){
                    datos[i][j]=heights-30;
                 }
             }
         }

    
        double posicion_ejex[]=new double[datos[0].length];
        double posicion_ejey[]=new double[datos[0].length];
        /*Calculando ancho de las barras */
        int ancho =widths/(eje_x.length*(datos.length+1));
        ancho=ancho-(int)ancho/8;

        if(tipo=="Barras"){
            
  
            /* Creando el Grafico de barras*/
            

            for(int i =0;i<datos.length;i++){
    
                for(int j=0;j<datos[0].length; j++){
    
                   int altura=(int) datos[i][j];
                   int x= ((ancho)*i+(ancho*(datos.length+1)*j))+ancho*(datos.length+1);
                   g2D.setPaint(colores_dato[i]);
                   g2D.fillRect(x, ((heights-20)-altura), ancho,altura);
    
                   posicion_ejex[j]+=x;
                } 
            }



    }else if(tipo=="dispersion"){

        /* Creando el Grafico de dispersion*/
        

        for(int i =0;i<datos.length;i++){

            for(int j=0;j<datos[0].length; j++){
                int x= ((ancho)*i+(ancho*(datos.length+1)*j))+ancho*(datos.length+1);
               posicion_ejex[j]+=x;
            } 
        }
                
             /*Graficando lines */   

        for(int i=0;i<datos.length;i++){
            
            for(int j=0;j<eje_x.length; j++){
            if(j!=0){
                g2D.setStroke(new BasicStroke(3));
                int altura=(heights-20)-(int) datos[i][j-1];
                int altura2=(heights-20)-(int) datos[i][j];;
                int ancho_x=(int) posicion_ejex[j-1]/(datos.length) +(ancho)/2;
                int ancho_x2=(int) posicion_ejex[j]/(datos.length) +(ancho)/2;

                g2D.setPaint(colores_dato[i]);
                g2D.drawLine(ancho_x,altura,ancho_x2,altura2);


                g2D.setStroke(new BasicStroke(5));
                g2D.drawOval(ancho_x2-5,altura2-5,10,10);


                
            }
            }
        }


    }
 
                /*Agregando encabezado eje_x */
                for(int i=0;i<eje_x.length;i++){
                    posicion_ejex[i]=posicion_ejex[i]/(datos.length);
        
                    g2D.setPaint(colores_encabezado[0]);
                    g2D.drawString(eje_x[i],(int)posicion_ejex[i],heights-3);
                    
                }
    
                
    
                /*Agregando encabezado eje_y */
                double datos_ejey[]=new double[datos[0].length];
    
                double resultado=0;
    
                for(int i=0;i<datos_copia.length;i++){
    
                    double temp=obtener_mayor(datos_copia[i]);
                    
                    if(temp>resultado){
                        resultado=temp;
                    }
                }
    
                for(int i=0;i<posicion_ejey.length;i++){
                    posicion_ejey[i]=(heights-20)-((heights-20)/posicion_ejey.length)*(i);
                    datos_ejey[i]=(resultado-20)-((resultado-20)/posicion_ejey.length)*(i);
                }
             
                for(int i=0;i<posicion_ejey.length;i++){
                    
                    String dato_y=String.valueOf(datos_ejey[i]);
         
                    int posicion_definitiva=heights -(int)posicion_ejey[i];
        
                    g2D.drawString(dato_y,10,posicion_definitiva);
                }
    
    
                int sepatacion_enx=ancho*(datos.length+1);
            
                g2D.setPaint(Color.BLACK);
                g2D.setStroke(new BasicStroke(4));
                g2D.drawLine(sepatacion_enx, heights-20, widths, heights-20);
        
        
                g2D.setPaint(Color.BLACK);
                g2D.setStroke(new BasicStroke(4));
                g2D.drawLine(sepatacion_enx, (heights-20), sepatacion_enx,- (heights-20));
  }
}
