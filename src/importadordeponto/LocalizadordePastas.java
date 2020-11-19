package importadordeponto;

import java.io.File;
import java.io.FileFilter;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author pc
 */
public class LocalizadordePastas extends javax.swing.JDialog {


    private  DefaultMutableTreeNode pc = new DefaultMutableTreeNode("Meu Computador");
    private DefaultTreeModel modelo = new DefaultTreeModel(pc);
    private String endereçoSelecionado = "";
    private String endereçoBarrasDobradas = "";

    public LocalizadordePastas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        montaUnidades();
    }

public String getEndereçoSelecionado()
{
   return endereçoSelecionado;
}



    private void montaSubDiretorios()
    {


            DefaultMutableTreeNode no = (DefaultMutableTreeNode) ArvoreSeleção.getLastSelectedPathComponent() ;


            if (no.getChildCount() > 0 )
            {
                return;
            }



            String dir = EndereçoAtual.getText();
            java.io.File diretorio = new java.io.File(dir);
            File[] arquivos = diretorio.listFiles(new FileFilter(){
                    public boolean accept(File dir) {
                         return dir.isDirectory(); // porque somente são desejados arquivos, e não diretórios
                 }}
            );



            DefaultMutableTreeNode subdiretorio[] = new DefaultMutableTreeNode[arquivos.length];


            for(int i=0;i<subdiretorio.length;i++)
            {
                subdiretorio[i] = new DefaultMutableTreeNode(arquivos[i].getName());
                modelo.insertNodeInto(subdiretorio[i], no, i);
            }

     ArvoreSeleção.expandPath(ArvoreSeleção.getSelectionPath());

    }

    private void montaEndereço()
    {

        String dados = ArvoreSeleção.getAnchorSelectionPath().toString();

        if (dados.trim().equals("[Meu Computador]"))
        {
            EndereçoAtual.setText("Meu Computador");
            return;
        }


        dados = dados.substring(17);
        int fim = dados.length() -1;
        dados = dados.substring(0 , fim);

        String semVirgula = "";
        for(int i = 0; i<dados.length();i++ )
        {
            if(dados.charAt(i) != ",".charAt(0))
            {
               semVirgula += dados.charAt(i);
            }
            else
            {
               i++;
                   if (semVirgula.length() > 3)
                   {
                       semVirgula = semVirgula +"\\";
                   }
                        
            }
        }

        EndereçoAtual.setText(semVirgula);
        montaSubDiretorios();
    }


    private void montaUnidades()
    {
         ArvoreSeleção.setModel(modelo);

        // pegas as unidades
        FileSystemView fs = FileSystemView.getFileSystemView();
         File[] roots = File.listRoots();
         //for (File file : roots) {System.out.println(file + "  " + fs.getSystemTypeDescription(file));}
         // fim pega unidades


//passa unidades
DefaultMutableTreeNode Unidades[] = new DefaultMutableTreeNode[roots.length];


for(int i=0;i<Unidades.length;i++)
{
    Unidades[i] = new DefaultMutableTreeNode(roots[i]);
    modelo.insertNodeInto(Unidades[i], pc, i);
}

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        EndereçoAtual = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ArvoreSeleção = new javax.swing.JTree();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selecione a pasta desejada");

        jLabel1.setText("Endereço Selecionado");
        jLabel1.setName("jLabel1"); // NOI18N

        EndereçoAtual.setEditable(false);
        EndereçoAtual.setName("EndereçoAtual"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        ArvoreSeleção.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        ArvoreSeleção.setName("ArvoreSeleção"); // NOI18N
        ArvoreSeleção.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ArvoreSeleçãoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(ArvoreSeleção);

        jButton1.setText("Ok");
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ajuda");
        jButton3.setName("jButton3"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EndereçoAtual, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(jButton3)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EndereçoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(603, 385));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ArvoreSeleçãoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArvoreSeleçãoMousePressed
      if (evt.getClickCount() == 2) {
           montaEndereço();
      }
    }//GEN-LAST:event_ArvoreSeleçãoMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed



        if(!EndereçoAtual.getText().trim().equals("Meu Computador"))
        endereçoSelecionado = EndereçoAtual.getText();
        else
        endereçoSelecionado = "";



        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        endereçoSelecionado = "";
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LocalizadordePastas dialog = new LocalizadordePastas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree ArvoreSeleção;
    private javax.swing.JTextField EndereçoAtual;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
