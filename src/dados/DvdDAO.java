//Ínicio do código
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import entidades.Dvd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



/**
 *
 * @author lucas
 */
public class DvdDAO {
    public Connection con = null;
    public PreparedStatement stmt = null;
    
    
    //Cadastrar DVD
    public void CadastraDvd(Dvd dvd) throws Exception{
    String sql ="insert into biblioteca_dvd (cod,banda,album,ano,estoque) values (?,?,?,?,?) ";
    
    //Efetua a conexão com obanco
    con = Connections.Conectar();
    
    //Executa o Prepare Statement
    stmt = con.prepareStatement(sql);
    // Prepara o primeiro parametro
    stmt.setInt   (1, dvd.getCodigo());
    // Prepara o  segundo parametro
    stmt.setString(2, dvd.getBanda());
    // Prepara o terceiro parametro
    stmt.setString(3, dvd.getAlbum());
    // Prepara o quarto parametro
    stmt.setInt   (4, dvd.getAno());
    // Prepara o quinto parametro
    stmt.setInt   (5, dvd.getEstoque());
    
    //Executa a query 
    stmt.execute();
    
    //Encerra a conexão com o banco
    Connections.Desconectar();
    
    
    }
    
    public Dvd PesquisaDvd(int codigo) throws Exception {
        
        String banda = "";
        String album = "";
        int ano = 0;
        int estoque = 0;
        
        String sql= "select * from biblioteca_dvd where cod = " + codigo;
        //Efetua a conexão com obanco
        con = Connections.Conectar();
    
       
        stmt = con.prepareStatement(sql);
        
        //stmt.setInt(1, codigo);
        
        
        
         
        //Executa o Prepare Statement
        ResultSet rs = stmt.executeQuery(sql);
        
        
        while(rs.next()) {
        banda = rs.getString("banda");
        album = rs.getString("album");
        ano = rs.getInt("ano");
        estoque = rs.getInt("estoque");
        
        
        }
        Dvd dvd;
        dvd = new Dvd(codigo, banda, album, ano, estoque);
        
        Connections.Desconectar();
        
        return dvd;
    }
    
    
    public void AtualizarEstoque(int codigo, String banda, String album, int ano, int estoque) throws Exception {
    
        String sql = "UPDATE biblioteca_dvd SET banda = ?, album = ?, ano = ?, estoque = ? WHERE cod = ?";
    
    //Efetua a conexão com o banco
    con = Connections.Conectar();
    
    //Executa o Prepare Statement
    stmt = con.prepareStatement(sql);
    
    // Prepara o primeiro parametro
    stmt.setString(1, banda);
    // Prepara o  segundo parametro
    stmt.setString(2, album);
    // Prepara o terceiro parametro
    stmt.setInt   (3, ano);
    // Prepara o quarto parametro
    stmt.setInt   (4, estoque);
    // Prepara o quinto parametro
    stmt.setInt   (5, codigo);
    
    //Executa a query 
    stmt.execute();
    
    //Encerra a conexão com o banco
    Connections.Desconectar();
    
    }
    
    
    public void ExcluirDvd(int codigo) throws Exception{
     String sql = "DELETE FROM biblioteca_dvd WHERE cod = ? ";
     
     //Efetua a conexão com o banco
    con = Connections.Conectar();
    
    //Executa o Prepare Statement
    stmt = con.prepareStatement(sql);
    
    
    stmt.setInt(1, codigo);
    
    
    //Executa a query 
    stmt.execute();
    
    //Encerra a conexão com o banco
    Connections.Desconectar();
    
    }
    
/*
    //Teste de conexão com inserção de dados na tabela
    public static void main (String args[]) throws Exception {
    
        Dvd d = new Dvd(552345, "Angra", "Evil Warning", 1994, 10 );
        DvdDAO dao = new DvdDAO();
        
        dao.CadastraDvd(d);
    }
    */
 
    /*
        //TESTE DE CONEXAO
           public static void main (String args[]) throws Exception {
           Connections conn = new Connections();
           conn.Conectar();
           conn.Desconectar();
       
       } 
*/
    
}

//Fim do código