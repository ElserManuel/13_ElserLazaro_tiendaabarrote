import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Font;



/*Eventos de pantalla*/
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;
import java.awt.event.*;
import java.awt.event.ActionListener;


interface Resetear{
    void reseteando(int n);
}

public class Productos {
    static int n1=0;

    static void activar(JPanel panel,JLabel texto){
        panel.setBackground(new Color(0xE4B438));
        texto.setForeground(Color.BLACK);
    }

    private void desactivar(JPanel panel,JLabel texto){
        panel.setBackground(Color.BLACK);
        texto.setForeground(Color.WHITE);
    }


    Productos(JPanel panel_derecha) throws IOException {

        /*Insertando Titulo*/

        Font venta_label2_font3=new Font("Roboto",Font.PLAIN,30);
        JLabel titulo=new JLabel("CATEGORIA-PRODUCTOS");
        titulo.setBounds(150,75,410,30);
        titulo.setForeground(Color.BLACK);
        titulo.setFont(venta_label2_font3);


        BufferedImage logo_producto= ImageIO.read(new File("img/Productos/categoria_logo.png"));
        JLabel label_logo_producto  = new JLabel(new ImageIcon(logo_producto ));
        label_logo_producto.setBounds(30, 40, 100, 80);
        panel_derecha.add(label_logo_producto);
        

        /*Barra de Busqueda*/

        JTextField buscar = new JTextField();
        buscar.setText("");
        buscar.setBounds(761, 34, 205, 43);
        panel_derecha.add(buscar);

        BufferedImage buscar_opciones = ImageIO.read(new File("img/Empleados/opciones.png"));
        JLabel label_buscar_opciones = new JLabel(new ImageIcon(buscar_opciones));
        label_buscar_opciones.setBounds(947, 33, 58, 42);
        panel_derecha.add(label_buscar_opciones);

        BufferedImage buscar_barra = ImageIO.read(new File("img/Empleados/buscar.png"));
        JLabel label_buscar_barra = new JLabel(new ImageIcon(buscar_barra));
        label_buscar_barra.setBounds(710, 34, 58, 42);
        panel_derecha.add(label_buscar_barra);

        BufferedImage buscar_alreves = ImageIO.read(new File("img/Empleados/alreves.png"));
        JLabel label_buscar_alreves = new JLabel(new ImageIcon(buscar_alreves));
        label_buscar_alreves.setBounds(940, 34, 58, 42);
        panel_derecha.add(label_buscar_alreves);




        /********************************CATEGORIA************************************/



        /*Paneles-Categoria*/

        JPanel vegetales_categoria=new JPanel();
        vegetales_categoria.setBackground(Color.BLACK);
        vegetales_categoria.setBounds(90,160,122,30);

        JPanel confiteria_categoria=new JPanel();
        confiteria_categoria.setBackground(Color.BLACK);
        confiteria_categoria.setBounds(242,160,122,30);

        JPanel carne_categoria=new JPanel();
        carne_categoria.setBackground(Color.BLACK);
        carne_categoria.setBounds(394,160,122,30);

        JPanel limpieza_categoria=new JPanel();
        limpieza_categoria.setBackground(Color.BLACK);
        limpieza_categoria.setBounds(546,160,122,30);



        /*Label-Categoria*/

        Font venta_label2_font4=new Font("Roboto",Font.PLAIN,13);

        JLabel vegetales_label=new JLabel("Vegetales");
        vegetales_label.setForeground(Color.WHITE);
        vegetales_label.setFont(venta_label2_font4);
        vegetales_categoria.add(vegetales_label);


        JLabel confiteria_label=new JLabel("Confiteria");
        confiteria_label.setForeground(Color.WHITE);
        confiteria_label.setFont(venta_label2_font4);
        confiteria_categoria.add(confiteria_label);

        JLabel carne_label=new JLabel("Carne");
        carne_label.setForeground(Color.WHITE);
        carne_label.setFont(venta_label2_font4);
        carne_categoria.add(carne_label);

        JLabel limpieza_label=new JLabel("Limpieza");
        limpieza_label.setForeground(Color.WHITE);
        limpieza_label.setFont(venta_label2_font4);
        limpieza_categoria.add(limpieza_label);



        /**********************************  SECCIONES  ***********************************/



        /*Panel Contenedor de secciones*/

        RoundedPanel contenedor_secciones=new RoundedPanel(25);
        contenedor_secciones.setBounds(60,230,651,45);
        contenedor_secciones.setForeground(Color.WHITE);
        contenedor_secciones.setOpaque(false);
        contenedor_secciones.setBackground(Color.WHITE);

        JPanel contenedor_secciones2=new JPanel();
        contenedor_secciones2.setBounds(60,255,651,65);
        contenedor_secciones2.setBackground(Color.WHITE);



        /*Barrita debajo de las secciones*/

        RoundedPanel barra=new RoundedPanel(25);
        barra.setBounds(90,320,88,3);
        barra.setForeground(new Color(0xE5D32D));
        barra.setOpaque(false);
        barra.setBackground(new Color(0xE5D32D));



        /*Flechas indicadoras*/

        BasicArrowButton derecha=new BasicArrowButton(BasicArrowButton.EAST);
        derecha.setBounds(660,290,20,20);
        panel_derecha.add(derecha);

        BasicArrowButton izquierda=new BasicArrowButton(BasicArrowButton.WEST);
        izquierda.setBounds(620,290,20,20);
        panel_derecha.add(izquierda);



        /*********************************   ITEMS   *****************************************/

        
        /*Secciones */

        

        /*Panel de secciones*/

        int coord[][][]={
            {{90,290,88,23},{90,320,88,3}},
            {{220,290,88,23},{220,320,88,3}},
            {{350,290,88,23},{350,320,88,3}},
            {{480,290,88,23},{480,320,88,3}},
        };


        int longitud =Conexiones.obtener_numero_columna("PRODUCTO");
        int longitud_total=(longitud/24+1)*24;


        /*Agregando secciones */
        Seccion objeto_seccion[]=new Seccion[(longitud/24+1)*4];

        for(int i=0;i<objeto_seccion.length;i++){

            Seccion obj2;

            if(i%4==0){
                obj2= new Seccion(i+1,coord[0][0],coord[0][1]);

            }else{
                obj2= new Seccion(i+1,coord[i%4][0],coord[i%4][1]);
            }

            objeto_seccion[i]=obj2;
        }


        String id[] =new String[longitud];
        String name[] =new String[longitud];
        String cantidad[] =new String[longitud];
        String medida[] =new String[longitud];
        String precio[] =new String[longitud];
        String marca[] =new String[longitud];
        String categoria[] =new String[longitud];
        String estado[] =new String[longitud];

    
        try {
            /*Colocando los datos respectivo de la base de datos*/
            System.out.println("La longitus es "+longitud);
            id=Conexiones.toda_columna(id,"PRODUCTO", "IDPRODUCTO"); 
            name=Conexiones.toda_columna(name,"PRODUCTO","NOMPROD");
            cantidad=Conexiones.toda_columna(cantidad,"PRODUCTO","CANTIPRODU");
            medida=Conexiones.toda_columna(medida,"PRODUCTO","UNIMEDIPRODUCTO");
            precio=Conexiones.toda_columna(precio,"PRODUCTO","PRECIOPROD");
            categoria=Conexiones.toda_columna(categoria,"PRODUCTO","CATEGORIA");
            estado=Conexiones.toda_columna(estado,"PRODUCTO","ESTDCUENT");

        }catch(Exception ex){
            System.out.println("Error +");
        }
              



        int maps[][][]={
        {{255,490,11,29},{100,360,171,121},{200,340,78,84},{140,480,100,40}},
        {{455,490,11,29},{300,360,171,121},{400,340,78,84},{340,480,100,40}},
        {{655,490,11,29},{500,360,171,121},{600,340,78,84},{540,480,100,40}},
        {{255,695,11,29},{100,565,171,121},{200,545,78,84},{140,700,100,40}},
        {{455,695,11,29},{300,565,171,121},{400,545,78,84},{340,700,100,40}},
        {{655,695,11,29},{500,565,171,121},{600,545,78,84},{540,700,100,40}},
        {{455,695,11,29},{500,565,171,121},{400,545,78,84},{340,700,100,40}}};


        Item_Producto objetos_item[]=new Item_Producto[longitud_total];

        for (int i = 0; i <objetos_item.length; i++){

            Item_Producto item;
            
            if(i<longitud){
                if(i%6==0){
                    item= new Item_Producto(panel_derecha,id[i],name[i],cantidad[i],medida[i],precio[i],marca[i],categoria[i],estado[i],maps[0][0], maps[0][1],maps[0][2],maps[0][3]);
    
                }else{
                    item= new Item_Producto(panel_derecha,id[i],name[i],cantidad[i],medida[i],precio[i],marca[i],categoria[i],estado[i],maps[i%6][0], maps[i%6][1],maps[i%6][2],maps[i%6][3]);
                }

            }else{

                if(i%6==0){
                    item= new Item_Producto(panel_derecha,"none","Item","none","none","none","none","none","1",maps[0][0], maps[0][1],maps[0][2],maps[0][3]);
    
                }else{
                    item= new Item_Producto(panel_derecha,"none","none","none","none","none","none","none","1",maps[i%6][0], maps[i%6][1],maps[i%6][2],maps[i%6][3]);
                }

            }
    
            objetos_item[i]=item;
        }



        
        final JPopupMenu menu = new JPopupMenu("Menu");
        menu.add("Editar").addActionListener(e-> {
            try{
                ProductosForm objto2=new ProductosForm();
            }catch(Exception es){}
        });
        
        menu.add("Eliminar");

        menu.add("Agregar").addActionListener(e-> {
            try{
                ProductosForm objto=new ProductosForm();
            }catch(Exception es){}
            
        });



        for(int i = 0; i <objetos_item.length;i++){
            panel_derecha.add(objetos_item[i].label_image_stock);
            panel_derecha.add(objetos_item[i].item);
            panel_derecha.add(objetos_item[i].label_nombre);
            panel_derecha.add(objetos_item[i].opciones1);

            objetos_item[i].label_image_stock.setVisible(false);
            objetos_item[i].item.setVisible(false);
            objetos_item[i].label_nombre.setVisible(false);
            objetos_item[i].opciones1.setVisible(false);



            JLabel opciones=objetos_item[i].opciones1;
            opciones.addMouseListener( new MouseAdapter() {
                public void mouseClicked(MouseEvent e)  {
                    menu.show(opciones, opciones.getWidth()/2, opciones.getHeight()/2);
                }
            } );


            /*Agregando eventos */
            Patrones.evento_mouse(objetos_item[i].opciones1,"opciones","img/Productos/");
        }


        for(int i = 0; i <6;i++){
            objetos_item[i].label_image_stock.setVisible(true);
            objetos_item[i].item.setVisible(true);
            objetos_item[i].label_nombre.setVisible(true);
            objetos_item[i].opciones1.setVisible(true);
        }

        
        /*Agregando las seccion */

        for(int i=0;i<objeto_seccion.length;i++){
            panel_derecha.add(objeto_seccion[i].contenedor);
            objeto_seccion[i].contenedor.setVisible(false);

            Patrones.evento_seccion_producto(objeto_seccion[i].contenedor,objeto_seccion[i].texto,barra,objeto_seccion[i].posicion_estado,objetos_item,objeto_seccion[i]);
        }


        for(int i=0;i<4;i++){
            objeto_seccion[i].contenedor.setVisible(true);
        }

          



              /*******SECCION PREVIEW********/

        /*Vista Previa de los Items*/
        RoundedPanel preview=new RoundedPanel(25);
        preview.setBounds(800,230,186,217);
        preview.setForeground(new Color(0xC4C4C4));
        preview.setOpaque(false);
        preview.setBackground(new Color(0xC4C4C4));

        /*Estado de la Imagen*/

        RoundedPanel barra1_preview=new RoundedPanel(5);
        barra1_preview.setBounds(810,460,51,7);
        barra1_preview.setForeground(new Color(0xE4B438));
        barra1_preview.setOpaque(false);
        barra1_preview.setBackground(new Color(0xE4B438));


        RoundedPanel barra2_preview=new RoundedPanel(5);
        barra2_preview.setBounds(870,460,51,7);
        barra2_preview.setForeground(new Color(0xC4C4C4));
        barra2_preview.setOpaque(false);
        barra2_preview.setBackground(new Color(0xC4C4C4));


        RoundedPanel barra3_preview=new RoundedPanel(5);
        barra3_preview.setBounds(930,460,51,7);
        barra3_preview.setForeground(new Color(0xC4C4C4));
        barra3_preview.setOpaque(false);
        barra3_preview.setBackground(new Color(0xC4C4C4));



        /*Titulo*/
        Font venta_label2_font6=new Font("Roboto",Font.BOLD,15);
        JLabel titulo_preview=new JLabel("Nombre del Producto");
        titulo_preview.setFont(venta_label2_font6);
        titulo_preview.setBounds(800,480,160,36);


        /*Descripcion*/
        Font venta_label2_font7=new Font("Roboto",Font.PLAIN,13);
        String texto="descripcion acerca del producto \nque se ha seleccionado\nactualmente puede cualquier \ncosa lorem ipsun etc ";
        JTextArea descripcion_preview=new JTextArea(texto,5,5);
        descripcion_preview.setFont(venta_label2_font7);
        descripcion_preview.setBackground(new Color(0XE7E7E7));
        descripcion_preview.setBounds(800,550,196,71);
        descripcion_preview.setEditable(false);


        /*COSTO*/

                    /*Costo-Panel*/
        RoundedPanel costo_preview=new RoundedPanel(25);
        costo_preview.setBounds(800,640,186,51);
        costo_preview.setForeground(new Color(0xE4B438));
        costo_preview.setOpaque(false);
        costo_preview.setBackground(new Color(0xE4B438));

                     /*Costo Texto*/
        Font costo_texto_preview2=new Font("Roboto",Font.BOLD,36);
        JLabel costo_texto_preview=new JLabel("$ 15");
        costo_texto_preview.setFont(costo_texto_preview2);
        costo_preview.add(costo_texto_preview);

        

        /*BOTON Agregar*/

                 /*Boton Agregar-Panel*/
        JPanel modificar_preview=new JPanel();
        modificar_preview.setBounds(800,730,176,33);
        modificar_preview.setForeground(new Color(0xAEADAB));
        modificar_preview.setBackground(new Color(0xAEADAB));

                 /*Boton Agregar-Texto*/
        Font modificar_texto_preview2=new Font("Roboto",Font.PLAIN,20);
        JLabel modificar_texto_preview=new JLabel("Agregar");
        modificar_texto_preview.setFont(modificar_texto_preview2);
        modificar_preview.add(modificar_texto_preview);



        /*Panel Contenedor Productos*/
        JPanel contenedor_secciones3=new JPanel();
        contenedor_secciones3.setBounds(60,324,651,491);
        contenedor_secciones3.setBackground(Color.WHITE);



        /*****************************  EVENTOS  *********************************/



        /*Agregando Escuchadores*/
        Resetear obj1=new Resetear() {
            @Override
            public void reseteando(int n) {
                if(n1==1){desactivar(vegetales_categoria,vegetales_label);
                }else if(n1==2){desactivar(confiteria_categoria,confiteria_label);
                }else if (n1==3){desactivar(carne_categoria,carne_label);
                }else if (n1==4){desactivar(limpieza_categoria,limpieza_label);}
           }
        };


                      /*Categoria*/

        Patrones.evento_mouse_producto(vegetales_categoria, vegetales_label, obj1, 1);
        Patrones.evento_mouse_producto(confiteria_categoria, confiteria_label, obj1, 2);
        Patrones.evento_mouse_producto(carne_categoria, carne_label, obj1, 3);
        Patrones.evento_mouse_producto(limpieza_categoria, limpieza_label, obj1, 4);


        /*Botones */

        /*Agregando al panel*/
        panel_derecha.add(titulo);


        /*Categoria*/
        panel_derecha.add(vegetales_categoria);
        panel_derecha.add(confiteria_categoria);
        panel_derecha.add(carne_categoria);
        panel_derecha.add(limpieza_categoria);

        /*Secciones*/

        panel_derecha.add(barra);

        /*Items*/

        panel_derecha.add(preview);

        /*preview*/
        panel_derecha.add(titulo_preview);
        panel_derecha.add(descripcion_preview);
        panel_derecha.add(costo_preview);
        panel_derecha.add(barra1_preview);
        panel_derecha.add(barra2_preview);
        panel_derecha.add(barra3_preview);
        panel_derecha.add(modificar_preview);

        panel_derecha.add(contenedor_secciones);
        panel_derecha.add(contenedor_secciones2);
        panel_derecha.add(contenedor_secciones3);
    }
}




class RoundJTextField extends JTextField {

    private Shape shape;
    public RoundJTextField(int size) {
        super(size);
        setOpaque(false); // As suggested by @AVD in comment.
    }
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        return shape.contains(x, y);
    }
}


class Item_Producto{

    JLabel label_nombre =new JLabel();

    RoundedPanel item=new RoundedPanel(25);

    BufferedImage costo2_image = ImageIO.read(new File("img/Productos/opciones.png"));
    JLabel opciones1 = new JLabel(new ImageIcon(costo2_image));

    BufferedImage costo1_image = ImageIO.read(new File("img/Productos/stock.png"));
    JLabel label_image_stock = new JLabel(new ImageIcon(costo1_image));

    /*Preview */
    String id_dato;
    String nombre_dato;
    String cantidad_dato;
    String medida_dato;
    String precio_dato;
    String marca_dato;
    String categoria_dato;
    String estado_dato;
    String descripcion;
    String img_direccion;



    Item_Producto(JPanel panel_derecha,String id,String nombre,String cantidad,String medida,String precio,String marca,String categoria,String estado,int op_dir[],int panel_dir[],int stock_dir[],int nombres[])throws IOException{


        /*Rellenando propiedades */
        id_dato=id;
        nombre_dato=nombre;
        cantidad_dato=cantidad;
        medida_dato=medida;
        precio_dato=precio;
        marca_dato=marca;
        categoria_dato=categoria;
        estado_dato=estado;

        img_direccion="img/Productos/img-productos/"+id+".png";

        /*Comprobando si existe la imagen */
        File tempFile= new File(img_direccion);
        boolean existe= tempFile.exists();


        if(existe){
            BufferedImage rounded= Patrones.makeRoundedCorner( 180,img_direccion,"png");
            item.insertar_imagen(rounded, panel_derecha);

        }else{
            String error_found="img/Productos/img-productos/error.png";
            BufferedImage rounded= Patrones.makeRoundedCorner( 180,error_found,"png");
            item.insertar_imagen(rounded, panel_derecha);
        }




        label_image_stock.setBounds(stock_dir[0],stock_dir[1],stock_dir[2],stock_dir[3]);
        

        item.setBounds(panel_dir[0],panel_dir[1],panel_dir[2],panel_dir[3]);
        item.setForeground(new Color(0xC4C4C4));
        item.setOpaque(false);
        item.setBackground(new Color(0xC4C4C4));


        Font venta_label2_font6=new Font("Roboto",Font.BOLD,15);
        label_nombre.setText(nombre);
        label_nombre.setFont(venta_label2_font6);
        label_nombre.setBounds(nombres[0],nombres[1],nombres[2],nombres[3]);
    

        opciones1.setBounds(op_dir[0],op_dir[1],op_dir[2],op_dir[3]);

    }
}


class Seccion{

    JPanel contenedor=new JPanel();
    JLabel texto=new JLabel();

    int numero_seccion;
    int posicion_estado[];


    Seccion(int seccion_actual,int coord_contenedor[],int coord_estado[]){


        numero_seccion=seccion_actual;
        posicion_estado=coord_estado;
        

        contenedor.setBackground(new Color(0xC4C4C4));
        contenedor.setBounds(coord_contenedor[0],coord_contenedor[1], coord_contenedor[2], coord_contenedor[3]);


        Font venta_label2_font5=new Font("Roboto",Font.PLAIN,12);
        texto.setForeground(Color.BLACK);
        texto.setText("Seccion"+numero_seccion);
        texto.setFont(venta_label2_font5);
        contenedor.add(texto);

    }
}