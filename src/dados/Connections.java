/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class Connections {
    
    //Construtor da classe
    public Connections() {}
    
    public static Connection con = null;
    public static PreparedStatement stmt = null;
    
    public static Connection Conectar () throws Exception {
       Class.forName("com.mysql.jdbc.Driver");
       con = DriverManager.getConnection("jdbc:mysql://localhost/store_cd?autoReconnect=true&useSSL=false","banco","042980");
        //System.out.println("Conectado ao Banco de Dados! ");
        return con;
        
   }
    
    
    public static void Desconectar () throws Exception {
       Class.forName("com.mysql.jdbc.Driver");
       Connections.con.close();
       System.out.println("Conexão Encerrada");}
}
    
    
    
       /*
        TESTE DE CONEXAO
           public static void main (String args[]) throws Exception {
           Connections conn = new Connections();
           conn.Conectar();
           conn.Desconectar();
       
       }*/
       
      
       
  