/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;
import entidades.Dvd;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class AppBibliotecaDvd {

    /**
     * @param args the command line arguments
     */
   

    public static void main(String[] args) {
        
        int estoque; 
        
        Scanner sc = new Scanner(System.in);
    
         Locale.setDefault(new Locale("pt", "BR"));
        
         System.out.println("Informe os dados do DVD");
         
         System.out.print("Informe o código do DVD: ");
         int codigo = sc.nextInt();
         
         System.out.print("Informe o nome da Banda: ");
         String banda = sc.next();
         
         System.out.println("Informe o nome do Álbum: ");
         String album = sc.next();
         
         System.out.println("informe o ano do álbum: ");
         int ano = sc.nextInt();
         
         System.out.println("Haverá inclusão de DVD no esoque? S/N  ");
         String resp = sc.next();
         
         if (!resp.equalsIgnoreCase("S"))  {
             estoque = 0;
             
             
          } else {
             System.out.println("Informe o valor: ");
             estoque = sc.nextInt();
             
             }
         
         Dvd d = new Dvd (codigo, banda, album, ano, estoque);
         System.out.println(d.toString());
         
         System.out.println("Informe a quantidade de DVD'S");
         estoque = sc.nextInt();
         d.incluiEstoque(estoque);
         System.out.println(d.toString());
         
         System.out.println("Informe a quantidade de retirada de  DVD'S");
         estoque = sc.nextInt();
         d.retiraEstoque(estoque);
         System.out.println(d.toString());
         
         
         
         
        
        
    }
    
}
