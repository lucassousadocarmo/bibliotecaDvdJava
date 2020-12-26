/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author lucas
 */
public class Dvd {

    
    //Atributos
    private int codigo;
    private String banda;
    private String album;
    private int ano;
    private int estoque;

   
 //Criação do construtor
    public Dvd(int codigo, String banda, String album, int ano, int estoque){
        this.codigo = codigo;
        this.banda = banda;
        this.album = album;
        this.ano = ano;
        this.estoque += estoque;
        System.out.println("Dvd cadastrado com sucesso! ");
    }

    public Dvd(int i, String angra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //Metodos acessores
     public int getCodigo() {
        return codigo;
    }

     //Não definido o metodo SET codigo devido a privação de alteração
    /*public void setCodigo(int codigo) {
        this.codigo = codigo;
    }*/

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getEstoque() {
        return estoque;
    }

    
    //Metodos proprios
    public void incluiEstoque (int valor){
        this.estoque += valor;
        System.out.println("Estoque atualizado! ");
    }
    
    public void retiraEstoque (int valor){
        this.estoque -= valor;
        System.out.println("Estoque atualizado! ");
    }
    
    //Impressão da Classe
    @Override
    public String toString (){
        return "---------------------------------- \n"
             + "Codigo: " + this.getCodigo() + "\n"
             + "Banda: " + this.getBanda() + "\n"
             + "Álbum: " + this.getAlbum() + "\n"
             + "Ano: "   + this.getAno() + "\n"
             + "Estoque: " + this.getEstoque() + "\n"   
             + "---------------------------------- \n"   ;
    }


}
