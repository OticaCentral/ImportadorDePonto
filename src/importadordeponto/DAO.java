package importadordeponto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Classe de Conexão com banco de dados
 * @author Moisés Alves Costa
 * @version 1.0.1
 *  
 */

public class DAO
{ 
     
    final private static String endereco = dadosSistema.getIP();
    final private static String driver = "com.mysql.jdbc.Driver";
    final private static String porta = dadosSistema.getPorta();
    final private static String u = dadosSistema.getUsuario();
    final private static String s = dadosSistema.getSenha();
    final private static String url = "jdbc:mysql://" + endereco + ":" + porta + "?autoReconnect=true&useSSL=false" ;
    final static boolean bancoComEsquema = false;
    final static String nomedoesquema = "";
    public static Connection conexao;
    private static boolean conectadoaoBancodedados = false;
    private String nomebd = "";

    public static Connection getConexao() 
    {
        try
        { // se a conecxão estiver offliene reconecta
            if(!conexao.isValid(0))
                iniciaConexão(); 
        }catch(Exception erro)
        {
            iniciaConexão();
        }
        return conexao;
    }
    
    public static boolean iniciaConexão()
    {
        try
        {
            Object newInstance;
            newInstance = Class.forName(driver);
            //Loader para carregar a class
            // metodo estatico que registra o driver automaticamente
            System.out.println(url);
            conexao = DriverManager.getConnection(url,u,s);
            conectadoaoBancodedados = true;
         }catch(SQLException sqlerro)
         {
             System.out.println("Erro no acesso a dados: " + String.valueOf(sqlerro.getErrorCode()));
             if(sqlerro.getErrorCode() == 40000)
             { 
                JOptionPane.showMessageDialog(null, "Usuário ou senha do banco de dados configurados incorretamente.");
                return false;
             } 
             System.out.println(sqlerro.getMessage());
             if(sqlerro.getErrorCode()==-1023)
             {
                JOptionPane.showMessageDialog(null, "Não foi possivel se conectar ao banco de dados. Verifique o servidor.\nSe o erro persistir contate o suporte.","Erro",JOptionPane.ERROR_MESSAGE);
                chamaalteraConfigurações();
             } 
             else
             {
                JOptionPane.showMessageDialog(null, sqlerro.getMessage() + ".Código:" + sqlerro.getErrorCode());
             }
         } 
        catch(Exception erro){JOptionPane.showMessageDialog(null, erro);
        conectadoaoBancodedados = false;
        chamaalteraConfigurações();
        }
        finally
        {
            return conectadoaoBancodedados;
        }
    }

    /**
     * Finaliza conexão com banco de dados.
     * @return um <code>integer</code> especificando a hora.
     */
    
    public void finalizaConexão()
    { 
    try {
            conexao.close();
            conectadoaoBancodedados = false;
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
    }

   /**
     * Retorna se esta conectado ou não ao banco de dados
     * @return um <code>Booleam</code> 1 Conectado 0 Não conectado
     * @param uma String com o sql de criação de tabela
    **/
    
    public static boolean getEstaConectado()
    {
        return conectadoaoBancodedados;
    }

    private static void chamaalteraConfigurações()
    {
        if(JOptionPane.showConfirmDialog(null, "Deseja alterar a configuração do sistema ?\nObs Será necessario contato com o suporte para esta tarefa.Qualquer configuração errada pode impricar na perda de todos os dados do sistema.\nDeseja Continuar?","Continuar",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
         {
            JOptionPane.showMessageDialog(null,"O sistema sera fechado.");
            System.exit(0);
         }
         else
         {
            JOptionPane.showMessageDialog(null,"O sistema sera fechado.");
            System.exit(0);
         }
        
    }
    
}