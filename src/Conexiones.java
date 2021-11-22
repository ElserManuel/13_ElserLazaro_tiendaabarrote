import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;






public class Conexiones {
    private static final String URL = "jdbc:mysql://localhost:3306/abarrote";
    private static final String usuario = "root";
    private static final String contraseña="";
    static boolean crear_registro=false;


    Conexiones(){
        super();
        getConnection();
    }

    public static Connection getConnection(){
        Connection conexion=null;

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion =(Connection) DriverManager.getConnection(URL,usuario,contraseña);
            
            crear_registro=false;
            
        }catch(Exception e){
            String DBS = "jdbc:mysql://localhost:3306/";

            try{

                conexion = (Connection) DriverManager.getConnection(DBS, usuario, contraseña);
                Statement stmt = conexion.createStatement();
                String sql = "CREATE DATABASE abarrote";
                stmt.executeUpdate(sql);

                JOptionPane.showMessageDialog(null,"Creacion de Base de datos Exitosa");
                conexion =(Connection) DriverManager.getConnection(URL,usuario,contraseña);
                crear_registro=true;

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"No se pudo crear la base de datos");
                System.out.println("Error "+ex);

            }

        }
        return conexion;
    }

    public static ResultSet consultar(String query){
        Connection conexion=getConnection();
        java.sql.PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            ps= conexion.prepareStatement(query);
            rs=ps.executeQuery();


            if(rs.next()){
            }else{
                JOptionPane.showMessageDialog(null,"Esta vacio este campo");
            }
            
         
        }catch(Exception e){
            rs=null;
            System.out.println("Error "+e);
       

        }finally{
            return rs;
        }
        
    }

    public static void modificar_tablas(String query){
        Connection conexion=getConnection();
        java.sql.PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            ps= conexion.prepareStatement(query);
            int resultado = ps.executeUpdate();


            if(resultado>0){
                JOptionPane.showMessageDialog(null,"Se Completo la transaccion correctamente");
            }else{
   
            }
            
            conexion.close();
            
        }catch(Exception e){
            rs=null;
            System.out.println("Error "+e);

        }
    }

    static String[] toda_columna(String[] data,String tabla,String columna){
        
        String query="SELECT * FROM "+tabla;
        ResultSet resultado=consultar(query);

        try{
            int contador=0;
            do{
                if(resultado.getInt("ESTDCUENT")==1){
                    data[contador]=resultado.getString(columna);
                    contador++;
                }else{}

            }while(resultado.next());
        }catch(Exception e){
        }

        return data;
    }

    public static int obtener_numero_columna(String tabla) {
        
        int contador=0;
        String query="SELECT * FROM "+tabla;
        ResultSet resultado=consultar(query);
        try {
            contador=0;
            do{
                if(resultado.getInt("ESTDCUENT")==1){
                    contador++;
                }else{
}
                
            }while(resultado.next());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contador;
    }

    public static int obtener_numero_columnaall(String tabla) {
        
        int contador=0;
        String query="SELECT * FROM "+tabla;
        ResultSet resultado=consultar(query);
        try {
            contador=0;
            do{
     
                contador++;

                
            }while(resultado.next());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contador;
    }
    
}


