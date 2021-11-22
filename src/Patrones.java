import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.border.Border;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.io.File;

/*Manejo de archivos*/
import java.awt.image.*;
import java.io.IOException;

/*Eventos de pantalla*/
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Cursor;



import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

import java.awt.Font;



public class Patrones {


    public static void evento_entrada(JTextField dato){

        FocusListener highlighter = new FocusListener() {
            @Override


            public void focusGained(FocusEvent e) {

                Border border = BorderFactory.createLineBorder(new Color(0x579AFF), 3);
                dato.setBorder(border);
        
            }

            @Override
            public void focusLost(FocusEvent e) {
                ((JComponent) e.getComponent()).setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            }
        };

        dato.addFocusListener(highlighter);
    }


    public static void evento_mouse(JLabel dato,String imagen,String directorio){
        dato.addMouseListener(new MouseListener() {
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
                BufferedImage image=null ;
            try{
                    image = ImageIO.read(new File(directorio+imagen+"_na.png"));
            }catch(IOException ex){}

            dato.setIcon(new ImageIcon(image));
            dato.setCursor(cursor);
            
                        
            }

            @Override
            public void mouseExited(MouseEvent e) {
                    BufferedImage image=null ;
                    try{
                            image = ImageIO.read(new File(directorio+imagen+".png"));
                    }catch(IOException ex){}
                    
                    dato.setIcon(new ImageIcon(image));
            }
            
        });
    }


    public static void evento_mouse_principal(JPanel dato1, JPanel dato2, JLabel dato3,int valor,Accion_Modificar restaurar,JPanel dato4){

        dato1.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                restaurar.resetear(Principal.estado_actual);
                Principal.activar(dato2, dato1);
                
                try {
                    if(valor==1){
                        Venta venta_objeto = new Venta(dato4,Principal.ventana);
                    }else if(valor==2){
                        Usuario objt1 = new Usuario(dato4);
                    }else if(valor==3){
                        Productos producto_objeto = new Productos(dato4);
                    }else if(valor==4){
                        Resumen resumen_objeto = new Resumen(dato4);
                    }else if(valor==5){
                        Empleados empleados_objeto = new Empleados(dato4);
                    }

                } catch (Exception ex) {

                }

                Principal.estado_actual=valor;
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
                dato1.setCursor(cursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        });
 
        dato2.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                restaurar.resetear(Principal.estado_actual);
                Principal.activar(dato2, dato1);
                
                try {
                    if(valor==1){
                        Venta venta_objeto = new Venta(dato4,Principal.ventana);
                    }else if(valor==2){
                        Usuario objt1 = new Usuario(dato4);
                    }else if(valor==3){
                        Productos producto_objeto = new Productos(dato4);
                    }else if(valor==4){
                        Resumen resumen_objeto = new Resumen(dato4);
                    }else if(valor==5){
                        Empleados empleados_objeto = new Empleados(dato4);
                    }

                } catch (Exception ex) {

                }

                Principal.estado_actual=valor;
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
                dato2.setCursor(cursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        });

        dato3.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                restaurar.resetear(Principal.estado_actual);
                Principal.activar(dato2, dato1);
                
                try {
                    if(valor==1){
                        Venta venta_objeto = new Venta(dato4,Principal.ventana);
                    }else if(valor==2){
                        Usuario objt1 = new Usuario(dato4);
                    }else if(valor==3){
                        Productos producto_objeto = new Productos(dato4);
                    }else if(valor==4){
                        Resumen resumen_objeto = new Resumen(dato4);
                    }else if(valor==5){
                        Empleados empleados_objeto = new Empleados(dato4);
                    }

                } catch (Exception ex) {

                }

                Principal.estado_actual=valor;
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
                dato3.setCursor(cursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        });
    }


    public static BufferedImage toBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }
    
        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
    
        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
    
        // Return the buffered image
        return bimage;
    }


    public static BufferedImage makeRoundedCorner(int cornerRadius,String patch,String extension)throws IOException{
        
            BufferedImage image= ImageIO.read(new File(patch));
            int w = image.getWidth();
            int h = image.getHeight();
            BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        
            Graphics2D g2 = output.createGraphics();
            
            // This is what we want, but it only does hard-clipping, i.e. aliasing
            // g2.setClip(new RoundRectangle2D ...)
        
            // so instead fake soft-clipping by first drawing the desired clip shape
            // in fully opaque white with antialiasing enabled...
            g2.setComposite(AlphaComposite.Src);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.WHITE);
            g2.fill(new RoundRectangle2D.Float(0, 0, w, h, cornerRadius, cornerRadius));
            
            // ... then compositing the image on top,
            // using the white shape from above as alpha source
            g2.setComposite(AlphaComposite.SrcAtop);
            g2.drawImage(image, 0, 0, null);
            
            g2.dispose();
            Image resultado=output.getScaledInstance(171, 121, Image.SCALE_SMOOTH);
            output=toBufferedImage(resultado);

            ImageIO.write(output, extension, new File(patch));
            return output;
        }


    public static void evento_mouse_producto(JPanel contenedor,JLabel etiqueta,Resetear obj1,int n1){
        contenedor.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                obj1.reseteando(Productos.n1);
                Productos.activar(contenedor,etiqueta);
                Productos.n1=n1;

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
                contenedor.setCursor(cursor);

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        etiqueta.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                obj1.reseteando(Productos.n1);
                Productos.activar(contenedor,etiqueta);
                Productos.n1=n1;
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
                etiqueta.setCursor(cursor);

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


    public static void evento_seccion_producto(JPanel contenedor,JLabel etiqueta,RoundedPanel barra2,int posicion[],Item_Producto data[],Seccion dato){
       
        contenedor.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                barra2.setBounds(posicion[0],posicion[1],posicion[2],posicion[3]);

                int inicio=dato.numero_seccion-1;
                int finals=dato.numero_seccion;
                

                for(int i=0;i<data.length; i++){
                    data[i].label_image_stock.setVisible(false);
                    data[i].item.setVisible(false);
                    data[i].label_nombre.setVisible(false);
                    data[i].opciones1.setVisible(false);

                }
                try{
                    for(int i=(inicio)*6;i< finals*6; i++){
                        data[i].label_image_stock.setVisible(true);
                        data[i].item.setVisible(true);
                        data[i].label_nombre.setVisible(true);
                        data[i].opciones1.setVisible(true);
                    }
                }catch(Exception ex){}
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
                contenedor.setCursor(cursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        
        etiqueta.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                barra2.setBounds(posicion[0],posicion[1],posicion[2],posicion[3]);
                int inicio=dato.numero_seccion-1;
                int finals=dato.numero_seccion;
                

                for(int i=0;i<data.length; i++){
                    data[i].label_image_stock.setVisible(false);
                    data[i].item.setVisible(false);
                    data[i].label_nombre.setVisible(false);
                    data[i].opciones1.setVisible(false);

                }
                try{
                    for(int i=(inicio)*6;i< finals*6; i++){
                        data[i].label_image_stock.setVisible(true);
                        data[i].item.setVisible(true);
                        data[i].label_nombre.setVisible(true);
                        data[i].opciones1.setVisible(true);
                    }
                }catch(Exception ex){}
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
                etiqueta.setCursor(cursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


    public static void evento_flechas_usuario(JLabel flecha,int n,Carta_Usuario[] data){
  
        flecha.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int limite=0;
                Usuario.vista_actual+=n;

                if((data.length)%4==0){
                    limite=data.length/4;
                }else{
                    limite=data.length/4+1;
                }

                if(Usuario.vista_actual>limite || Usuario.vista_actual==0){
                    Usuario.vista_actual-=n;
                }else{

                }


                for(int i=0;i<data.length; i++){
                    data[i].celular.setVisible(false);
                    data[i].correo.setVisible(false);
                    data[i].direccion.setVisible(false);
                    data[i].usuarios.setVisible(false);
                    data[i].label_atras.setVisible(false);
                    data[i].label_usuario.setVisible(false);
                }


                try{
                    for(int i=(Usuario.vista_actual-1)*4;i< Usuario.vista_actual*4; i++){
                        data[i].celular.setVisible(true);
                        data[i].correo.setVisible(true);
                        data[i].direccion.setVisible(true);
                        data[i].usuarios.setVisible(true);
                        data[i].label_atras.setVisible(true);
                        data[i].label_usuario.setVisible(true);
                    }
                }catch(Exception ex){}
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
                flecha.setCursor(cursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


    public static void evento_atrascarta_usuarios(JLabel carta,String direccion,String dni,String apellido,String estado){
        carta.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                try {
                    Usuario_back llamar=new Usuario_back(direccion,apellido,dni,estado);
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
                Cursor cursor=new Cursor(Cursor.HAND_CURSOR);
                carta.setCursor(cursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


    public static void evento_item_seleccionar_usuario(JLabel args[],Carta_Usuario objeto){
        for (JLabel etiqueta : args){
            etiqueta.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    try{
                        Usuario.item_seleccionado.label_usuario.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                    }catch (Exception ex){}

                    Usuario.item_seleccionado=objeto;
                    Border border = BorderFactory.createLineBorder(new Color(0x579AFF), 3);
                    objeto.label_usuario.setBorder(border);

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
                    etiqueta.setCursor(cursor);
                }
    
                @Override
                public void mouseExited(MouseEvent e) {
    
                }
            });
        }
    }


    public static void evento_item_seleccionar_empleado(JLabel args[],Carta_Empleado objeto){
        for (JLabel etiqueta : args){
            etiqueta.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    try{
                        Empleados.item_seleccionado.label_usuario.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                    }catch (Exception ex){}

                    Empleados.item_seleccionado=objeto;
                    Border border = BorderFactory.createLineBorder(new Color(0x579AFF), 3);
                    objeto.label_usuario.setBorder(border);

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
                    etiqueta.setCursor(cursor);
                }
    
                @Override
                public void mouseExited(MouseEvent e) {
    
                }
            });
        }
    }


    public static void evento_flechas_empleado(JLabel flecha,int n,Carta_Empleado[] data){
  
        flecha.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int limite=0;
                Empleados.vista_actual+=n;

                if((data.length)%4==0){
                    limite=data.length/4;
                }else{
                    limite=data.length/4+1;
                }

                if(Empleados.vista_actual>limite || Empleados.vista_actual==0){
                    Empleados.vista_actual-=n;
                }else{

                }


                for(int i=0;i<data.length; i++){
                    data[i].celular.setVisible(false);
                    data[i].correo.setVisible(false);
                    data[i].direccion.setVisible(false);
                    data[i].empleado.setVisible(false);
                    data[i].label_atras.setVisible(false);
                    data[i].label_usuario.setVisible(false);
                }


                try{
                    for(int i=(Empleados.vista_actual-1)*4;i< Empleados.vista_actual*4; i++){
                        data[i].celular.setVisible(true);
                        data[i].correo.setVisible(true);
                        data[i].direccion.setVisible(true);
                        data[i].empleado.setVisible(true);
                        data[i].label_atras.setVisible(true);
                        data[i].label_usuario.setVisible(true);
                    }
                }catch(Exception ex){}
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
                flecha.setCursor(cursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
    

    public static void evento_atrascarta_empleado(JLabel carta,String dni,String dir,String bonu,String Calificacion){
        carta.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                try {
                    Empleado_back llamar=new Empleado_back(dni,dir,bonu,Calificacion);
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
                Cursor cursor=new Cursor(Cursor.HAND_CURSOR);
                carta.setCursor(cursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


}
    


    





