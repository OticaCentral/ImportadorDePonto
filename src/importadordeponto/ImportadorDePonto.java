/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importadordeponto;

import javax.swing.JOptionPane;

/**
 *
 * @author administrador
 */
public class ImportadorDePonto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//       if (iniciaServidor() == false)
//        {
//            JOptionPane.showMessageDialog(null, "O servidor não pode ser iniciado. O sistema sera fechado.");
//            System.exit(0);
//        }
        
        
        ImportarPonto p = new importadordeponto.ImportarPonto();
        p.setVisible(true);
    }
    
        private static boolean iniciaServidor()
    {
        /** tente iniciar o servidor de banco de dados 3 vezes se não conseguir sai do sistema */

        for(int i = 0; i<3;i++)
        {
            iniciaServidorJavaDb inicia = new iniciaServidorJavaDb(true);
            if(inicia.getServidorOnline() == true)
            {
                return true;
            }
        }
        return false;
    }
    
    
    
    
    
    
    
    
    
    
 
}
