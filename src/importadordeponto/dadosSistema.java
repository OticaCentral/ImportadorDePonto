/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package importadordeponto;

import importadordeponto.cripitografiaBlowFish;
import importadordeponto.frConfiguracao;
import importadordeponto.frSenhaDeManutenção;
import javax.swing.JOptionPane;

/**
 *
 * @author Moises
 */
public class dadosSistema
{
    private static String  Ipbanco = null;
    private static String  UsuarioBanco = null;
    private static String  SenhaBanco = null;
    private static String  Porta = null;
    
    
    

  public static void setDadosSistema()
  {
      DAOLOCAL d = new DAOLOCAL(true, true, "select * from APP.DADOSSISTEMA");

      try
      {
         
        d.resultset.first();
        System.out.println("ip");
        Ipbanco =  (d.resultset.getString("IPBANCO"));
        UsuarioBanco = (d.resultset.getString("USUARIOBANCO"));
        SenhaBanco = (d.resultset.getString("SENHA"));
        Porta = (d.resultset.getString("PORTA"));


      }catch(Exception erro)
      {
          JOptionPane.showMessageDialog(null, "Erro ao acessar configurações o sistema será fechado");
          System.exit(0);
          return;
      }
  }
  
  
    /**
   * Metodo statico que retorna String com Porta do banco
   * @return String
   */
      public static String getPorta() {
        return Porta;
    }
  
  /**
   * Metodo statico que retorna String com ip do banco
   * @return String
   */
    public static String getIP()
    {return Ipbanco;}

  /**
   * Metodo statico que retorna String com Usuario do banco
   * @return String
   */
    public static String getUsuario()
    {return UsuarioBanco;}

  /**
   * Metodo statico que retorna String com Senha do banco
   * @return String
   */
    public static String getSenha()
    {return SenhaBanco;}

   
    
    
    
    

}
