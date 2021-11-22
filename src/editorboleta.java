import javax.swing.*;
import java.awt.*;

public class editorboleta {
    public static void main(String args[]) {
        
        JFrame ventana_comprobante = new JFrame();
        ventana_comprobante.setVisible(true);
        ventana_comprobante.setSize(593, 762);
        ventana_comprobante.setLayout(null);
        ventana_comprobante.getContentPane().setBackground(new Color(0x383241));


        Font titulo_font = new Font("cooper black", Font.PLAIN, 40);
        JLabel formulario = new JLabel();
        formulario.setBounds(60, 10, 600, 100);
        formulario.setText("EDITOR BOLETA");
        formulario.setFont(titulo_font);
        formulario.setForeground(new Color(0XF15959));
        Font cliente_font = new Font("Roboto", Font.PLAIN, 20);
        JLabel cliente = new JLabel();
        cliente.setBounds(15, 110, 200, 50);
        cliente.setText("Cliente:");
        cliente.setFont(cliente_font);
        cliente.setForeground(Color.white);

        Font factura_font = new Font("Roboto", Font.PLAIN, 20);
        JLabel factura = new JLabel();
        factura.setBounds(15, 180, 200, 50);
        factura.setText("N°Factura:");
        factura.setFont(factura_font);
        factura.setForeground(Color.white);

        Font total_font = new Font("Roboto", Font.PLAIN, 20);
        JLabel total = new JLabel();
        total.setBounds(300, 110, 200, 50);
        total.setText("Total:");
        total.setFont(total_font);
        total.setForeground(Color.white);

        Font emision_font = new Font("Roboto", Font.PLAIN, 20);
        JLabel emision = new JLabel();
        emision.setBounds(15, 250, 200, 50);
        emision.setText("F.De Emision:");
        emision.setFont(emision_font);
        emision.setForeground(Color.white);

        Font pago_font = new Font("Roboto", Font.PLAIN, 20);
        JLabel pago = new JLabel();
        pago.setBounds(15, 320, 200, 50);
        pago.setText("Estado De Pago:");
        pago.setFont(pago_font);
        pago.setForeground(Color.white);

        Font campo_font = new Font("Roboto", Font.PLAIN, 20);
        JLabel campo = new JLabel();
        campo.setBounds(15, 380, 200, 50);
        campo.setText("Campo:");
        campo.setFont(campo_font);
        campo.setForeground(Color.white);


        JTextField cliente_entrada = new JTextField(20);
        cliente_entrada.setBounds(90, 120, 200, 29);

    
        JTextField factura_entrada = new JTextField(20);
        factura_entrada.setBounds(110, 190, 450, 29);

        JTextField  emision_entrada = new JTextField(20);
        emision_entrada.setBounds(140, 260, 420, 29);

        JTextField total_entrada = new JTextField(20);
        total_entrada.setBounds(360, 120,200, 29);

        JTextField pago_entrada = new JTextField(20);
        pago_entrada.setBounds(170, 330, 390, 29);

        JTextField campo_entrada = new JTextField(20);
        campo_entrada.setBounds(90, 390, 470, 29);

      
        JButton boton1 = new JButton("CREAR");
        boton1.setBounds(440,550,100,40);
        boton1.setForeground(Color.WHITE);
        boton1.setFont(new Font("cooper black",Font.BOLD,15));
        boton1.setBackground(new Color(0xF15959));

        JButton boton2 = new JButton("CANCELAR");
        boton2.setBounds(20,550,130,40);
        boton2.setForeground(Color.WHITE);
        boton2.setFont(new Font("cooper black",Font.BOLD,15));
        boton2.setBackground(new Color(0xF15959));


        ventana_comprobante.add(formulario);
        ventana_comprobante.add(cliente);
        ventana_comprobante.add(factura);
        ventana_comprobante.add(total);
        ventana_comprobante.add(emision);
        ventana_comprobante.add(pago);
        ventana_comprobante.add(campo);
        ventana_comprobante.add(cliente_entrada);
        ventana_comprobante.add(factura_entrada);
        ventana_comprobante.add(total_entrada);
        ventana_comprobante.add(emision_entrada);
        ventana_comprobante.add(pago_entrada);
        ventana_comprobante.add(campo_entrada);
        ventana_comprobante.add(boton1);
        ventana_comprobante.add(boton2);
        ventana_comprobante.repaint();
    }
}