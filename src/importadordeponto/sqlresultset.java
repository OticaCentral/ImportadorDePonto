/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package importadordeponto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Classe que clia um resulte set no dao
 * @author Usuario
 */
public class sqlresultset 
{

    public Statement statement;
    public ResultSet resultset;
    private int recorCont = 0;

    /**
     * Retorno um result Set com uma consulta se não existir uma conexão ativa cria a conexão automaticamente
     * Paramentro String Sql com algum consulta
     * @param ExecultaConsult 
     * 
     */
    public sqlresultset(String ExecultaConsult)
    {
        
        try
        {
                if(ExecultaConsult != null )
                {
                    if(!ExecultaConsult.trim().equals(""))
                    {
                        if(!ExecultaConsult.isEmpty())
                        {
                            execconsulta(ExecultaConsult);
                        }
                    }
                }
        }catch(Exception erro)
        {
            
        }
    }

    /**
     *
     * @return um <code>integer</code> especificando o numero de registros.
     */
    public int getTotalDadosResultSet()
    {
        return recorCont;
    }

    private void setTotalDadosResultset()
    {
        int contagem = 0;

        try
        {
         resultset.beforeFirst();
         if(resultset.next())
            resultset.last();
            contagem = resultset.getRow();
        }
        catch(Exception erro){}
        finally
        {
            recorCont = contagem;
        }
    }


      /**
     *
     * @return um <code>ResultSet</code> especificando com os dados do banco de dados.
     * @param uma String com o sql de seleção
     */

public ResultSet getResultSet(String Sql)
    {

    if(!DAO.getEstaConectado())
        DAO.iniciaConexão();
        
        try
        {
        statement = DAO.getConexao().createStatement(resultset.TYPE_SCROLL_SENSITIVE,resultset.CONCUR_READ_ONLY );
        if(DAO.bancoComEsquema)
        statement.execute(DAO.nomedoesquema);
        resultset = statement.executeQuery(Sql);
        resultset.beforeFirst();
        setTotalDadosResultset();
        }
        catch(SQLException erro)
        {
            System.out.println(Sql);
            System.out.println("Sql erro: " + String.valueOf(erro.getErrorCode()));
            
            JOptionPane.showMessageDialog(null, erro);
            return null;
        }

        return resultset;
    }

    /**
     * Execulta um Update no banco de dados
     * @return um <code>Booleam</code> 1 ok 0 erro
     * @param uma String com o sql de Update
     */

public boolean salvaBancoDados(String sql)
    {
    boolean retorno = false;
        try
        {
            String sqlInsert = sql;
            statement = DAO.getConexao().createStatement(resultset.TYPE_SCROLL_SENSITIVE,resultset.CONCUR_READ_ONLY );
            if(DAO.bancoComEsquema)
            statement.execute(DAO.nomedoesquema);
            statement.executeUpdate(sqlInsert);
            retorno = true;
        }catch(SQLException erro)
        {
            System.out.println(sql);
            System.out.println("Erro no acesso a dados: "+   String.valueOf(erro.getErrorCode()));

            if(erro.getErrorCode() == 1451)
            {
                JOptionPane.showMessageDialog(null, "Não é possível excluir este registro, ele esta relacionado com outros lançamentos no sistema.","Erro",JOptionPane.ERROR_MESSAGE);
            }
            else
                {
                    if(erro.getErrorCode() == 1062)
                    {
                        JOptionPane.showMessageDialog(null, "Não foi possível salvar ou alterar os dados porque a identificação deve ser única.","Erro",JOptionPane.ERROR_MESSAGE);
                    }
                     else
                    {
                        JOptionPane.showMessageDialog(null, erro.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
                    }
                }
        }
        catch(Exception e){JOptionPane.showMessageDialog(null, e.getMessage());}
    finally
            {
            return retorno;
         }

    }


   /**
     * Verifica se a tabela existe
     * @return um <code>Booleam</code> 1 existe 0 Não existe
     * @param uma String com o sql de seleção
     */

public boolean getTabelaExiste(String sql)
{
    
    if(!DAO.getEstaConectado())
        DAO.iniciaConexão();
    
    try
        {
            statement = DAO.getConexao().createStatement(resultset.TYPE_SCROLL_SENSITIVE,resultset.CONCUR_READ_ONLY );
            if(DAO.bancoComEsquema);
            statement.execute(DAO.nomedoesquema);
            resultset = statement.executeQuery(sql);
        }
        catch(SQLException erro){return false;}

        return true;
    }


   /**
     * Cria uma tabela
     * @return um <code>Booleam</code> 1 ok 0 erro
     * @param uma String com o sql de criação de tabela
     */

 public boolean criaTabela(String sql)
    {
    if(!DAO.getEstaConectado())
        DAO.iniciaConexão();
        try
            {
                statement = DAO.getConexao().createStatement(resultset.TYPE_SCROLL_SENSITIVE,resultset.CONCUR_READ_ONLY );
                if(DAO.bancoComEsquema)
                statement.execute(DAO.nomedoesquema);
                statement.execute(sql);
            }
            catch(SQLException erro){
                JOptionPane.showMessageDialog(null, erro);
                return false;}
            return true;
    }

   /**
     * Exeulta uma consulta Query no banco de dados
     * @param uma String com o sql de criação de Consulta Query
     */
    public void execultaConsulta(String Sql)
    {
        execconsulta(Sql);
    }

    private void execconsulta(String Sql)
    {
        
    if(!DAO.getEstaConectado())
        DAO.iniciaConexão();
        
         try
        {
            statement = DAO.getConexao().createStatement(resultset.TYPE_SCROLL_SENSITIVE,resultset.CONCUR_READ_ONLY );
            resultset = statement.executeQuery(Sql);
            setTotalDadosResultset();
        }
        catch(SQLException erro)
        {
            System.out.println(Sql);
            System.out.println("Erro no acesso a dados: "+   String.valueOf(erro.getErrorCode()));
            System.out.println("Erro no acesso a dados: "+   String.valueOf(erro.getMessage()));
            if(erro.getErrorCode() ==-1)
            {
                   JOptionPane.showMessageDialog(null, "Não foi possível encontrar uma tabela do banco de dados.\nO sistema sera fechado.\nSe o erro persistir contate o suporte.");
                if(JOptionPane.showConfirmDialog(null, "Deseja Ver as configurações do sistema ?","",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
                {
                    chamaalteraConfigurações();
                }
                else
                {
                     System.exit(0);
                }
            }
            System.out.println("Execulta consulta Sql erro: " + String.valueOf(erro.getErrorCode()));
            JOptionPane.showMessageDialog(null, erro);
        }
    }

    private void chamaalteraConfigurações()
    {

        if(JOptionPane.showConfirmDialog(null, "Deseja alterar a configuração do sistema ?\nObs Será necessario contato com o suporte para esta tarefa.Qualquer configuração errada pode impricar na perda de todos os dados do sistema.\nDeseja Continuar?","Continuar",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
                 {

                    JOptionPane.showMessageDialog(null," Erro ao se conctar o sistema sera fechado.");
                    System.exit(0);
                     

                 }
                 else
                 {
                    JOptionPane.showMessageDialog(null,"O sistema sera fechado.");
                    System.exit(0);
                 }

    }

    public void finalizaConexão() 
    {
        try
        {
            resultset.close();    
        }catch(Exception erro)
        {
            
        }
    }
   
}
