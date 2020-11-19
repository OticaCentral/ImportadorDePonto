/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importadordeponto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author administrador
 */
public class leArquivoTxt 
{
   private String conteudoTexto;

   
       public leArquivoTxt(String endereco)
       {
           File arquivoALer = new File(endereco);
           FileReader fileReader;

           try 
           {
               fileReader = new FileReader(arquivoALer);
               
               File f = new File(endereco);
               
                if(f.exists())
                {
                    BufferedReader reader = new BufferedReader(fileReader);
                    String data = null;

                         while((data = reader.readLine()) != null)
                         {
                             conteudoTexto = data;
                             System.out.println(data);

                         }
                     fileReader.close();
                     reader.close();
                }
                else
                {
                    System.out.println("Arqivo: " + arquivoALer + " nao existe" );
                }

           } catch (Exception e) {
           }
           }

	

    public String getConteudoTexto() 
    {
        return conteudoTexto;
    }

	public static void main(String[] args) 
        {
                leArquivoTxt l = new leArquivoTxt("Teste.txt");
	}
    
}
