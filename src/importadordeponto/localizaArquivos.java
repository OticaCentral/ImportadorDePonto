package importadordeponto;


import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.UIManager;


/**
 * Classe para Localização de Arquivos
 * @author Moises
 */
public class localizaArquivos
{

    private String end = "";

    /**
     * Classe Construtor localiza arquivo Parametro Tipo integer
     * 1 = Zip,
     * 2 = Jpg
     * @param Tipo Integer
     */

    public localizaArquivos (Integer Tipo)
    {

    ajustanomesChoser();

    JFileChooser localiza = new JFileChooser(new File("c:/"));
    localiza.setDialogTitle("Selecione o arquivo que sera restaurado.");
    localiza.setFileSelectionMode(JFileChooser.FILES_ONLY);
    localiza.setMultiSelectionEnabled(false);


    switch (Tipo)
    {
        case 1:
            localiza.addChoosableFileFilter(new zipfiltro());
            break;
         case 2:
            localiza.addChoosableFileFilter(new imageJPG());
            break;
         case 3:
            localiza.addChoosableFileFilter(new imagePng());
            break;
         case 4:
            localiza.addChoosableFileFilter(new textFile());
            break;              
         default:
            localiza.addChoosableFileFilter(new zipfiltro());
            break;
    }


   int status = localiza.showOpenDialog(null);

   if(status==JFileChooser.APPROVE_OPTION)
   {
        try {
            end = (localiza.getSelectedFile().getCanonicalPath());
        } catch (IOException ex) {
            Logger.getLogger(localizaArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
   }


    }


    public String getEndereçoArquivo()
    {
        return end;
    }



    private void ajustanomesChoser()
    {
        UIManager.put("FileChooser.lookInLabelMnemonic", "E");
        UIManager.put("FileChooser.lookInLabelText", "Examinar em");

        UIManager.put("FileChooser.saveInLabelMnemonic", "S");
        UIManager.put("FileChooser.saveInLabelText", "Salvar em");

        UIManager.put("FileChooser.upFolderToolTipText", "Um nível acima");
        UIManager.put("FileChooser.upFolderAccessibleName", "Um nível acima");

        UIManager.put("FileChooser.homeFolderToolTipText", "Desktop");
        UIManager.put("FileChooser.homeFolderAccessibleName", "Desktop");

        UIManager.put("FileChooser.newFolderToolTipText", "Criar nova pasta");
        UIManager.put("FileChooser.newFolderAccessibleName", "Criar nova pasta");

        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "Lista");

        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalhes");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Detalhes");

        UIManager.put("FileChooser.fileNameLabelMnemonic", "N");
        UIManager.put("FileChooser.fileNameLabelText", "Nome do arquivo");

        UIManager.put("FileChooser.filesOfTypeLabelMnemonic", "A");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Arquivos do tipo");

        UIManager.put("FileChooser.fileNameHeaderText", "Nome");
        UIManager.put("FileChooser.fileSizeHeaderText", "Tamanho");
        UIManager.put("FileChooser.fileTypeHeaderText", "Tipo");
        UIManager.put("FileChooser.fileDateHeaderText", "Data");
        UIManager.put("FileChooser.fileAttrHeaderText", "Atributos");

        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.cancelButtonMnemonic", "C");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");

        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.openButtonMnemonic", "A");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir");

        UIManager.put("FileChooser.saveButtonText", "Salvar");
        UIManager.put("FileChooser.saveButtonToolTipText", "S");
        UIManager.put("FileChooser.saveButtonToolTipText", "Salvar");

        UIManager.put("FileChooser.updateButtonText", "Alterar");
        UIManager.put("FileChooser.updateButtonToolTipText", "A");
        UIManager.put("FileChooser.updateButtonToolTipText", "Alterar");

        UIManager.put("FileChooser.helpButtonText", "Ajuda");
        UIManager.put("FileChooser.helpButtonToolTipText", "A");
        UIManager.put("FileChooser.helpButtonToolTipText", "Ajuda");

        UIManager.put("FileChooser.acceptAllFileFilterText", "Todos os arquivos");
    }


    public static void main(String args[])
{

    localizaArquivos a = new localizaArquivos(2);

}

}
class zipfiltro extends javax.swing.filechooser.FileFilter
{

        public boolean accept(File f){
                boolean accept = f.isDirectory();

                if(!accept){
                        String suffix = getSuffix(f);
                        if(suffix != null)
                                accept = suffix.equals("zip");
                }

                return accept;
        }


        public String getDescription(){
                return "Backups (*.zip)";
        }

        private String getSuffix(File f){
                String s = f.getPath(), suffix = null;
                int i = s.lastIndexOf('.');

                if(i > 0 && i < s.length() -1)
                        suffix = s.substring(i+1).toLowerCase();

                return suffix;
        }

}

class imageJPG extends javax.swing.filechooser.FileFilter
{

        public boolean accept(File f){
                boolean accept = f.isDirectory();

                if(!accept){
                        String suffix = getSuffix(f);
                        if(suffix != null)
                                accept = suffix.equals("jpg");
                }

                return accept;
        }


        public String getDescription(){
                return "Imagem (*.jpg)";
        }

        private String getSuffix(File f){
                String s = f.getPath(), suffix = null;
                int i = s.lastIndexOf('.');

                if(i > 0 && i < s.length() -1)
                        suffix = s.substring(i+1).toLowerCase();

                return suffix;
        }

}

class imagePng extends javax.swing.filechooser.FileFilter
{

        public boolean accept(File f){
                boolean accept = f.isDirectory();

                if(!accept){
                        String suffix = getSuffix(f);
                        if(suffix != null)
                                accept = suffix.equals("png");
                }

                return accept;
        }


        public String getDescription(){
                return "Imagem (*.pmg)";
        }

        private String getSuffix(File f){
                String s = f.getPath(), suffix = null;
                int i = s.lastIndexOf('.');

                if(i > 0 && i < s.length() -1)
                        suffix = s.substring(i+1).toLowerCase();

                return suffix;
        }

}

class textFile extends javax.swing.filechooser.FileFilter
{

        public boolean accept(File f){
                boolean accept = f.isDirectory();

                if(!accept){
                        String suffix = getSuffix(f);
                        if(suffix != null)
                                accept = suffix.equals("txt");
                }

                return accept;
        }


        public String getDescription(){
                return "Text (*.txt)";
        }

        private String getSuffix(File f){
                String s = f.getPath(), suffix = null;
                int i = s.lastIndexOf('.');

                if(i > 0 && i < s.length() -1)
                        suffix = s.substring(i+1).toLowerCase();

                return suffix;
        }

}