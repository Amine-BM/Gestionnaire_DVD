
package amine.bigpro;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;

public class Modifications extends javax.swing.JFrame {

    private DVDFORM D;
    private ArrayList<Film> Films;

    public Modifications(DVDFORM D) { 
        this.D=D;
        Films=D.GetFilms();
        
        initComponents();
        Windowlistenner();
        
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // on empêche l'utilisation du scroll horizontal
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED); // on autorise le scroll vertical quand c'est nécessaire
        synopsys1.setLineWrap(true); // on permet le retour automatique à la ligne dès que le texte s'approche des bordures ( pour que le texte ne s'étale pas horizontalement)
        
        int position=D.index();// permet de récupérer l'index du film qu'on souhaite modifier
        Ecrire_Donnees_Dans_Champs(position); // on insère toutes les données du film pour que l'utilisateur choisisse précisemment celles qu'il souhaite changer
    }
    
    public void Windowlistenner(){
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // par défaut l'utilisateur ne pourra pas fermer la fenêtre (via la croix rouge)
        this.addWindowListener(new java.awt.event.WindowAdapter(){
            public void windowClosing(java.awt.event.WindowEvent we){
                if(we.WINDOW_CLOSING == we.getID()){ // on vérifie que l'évènement qui est récupéré correspond bien à l'évènement de fermeture de fenêtre
                    dispose();
                    D.setVisible(true);
                }
            }
        });
    }
    
    /*
        Méthode qui permet de récupérer les évènements qui se déroulent sur la fenêtre et plus précisemment de savoir quand l'utilisateur cherche à fermer la fenêtre (via la croix rouge)
        quand c'est le cas pour que l'utilisateur ne puisse pas arrêter le programme on récupère cette évènement et on ferme la fenêtre Ajouter tout en réaffichant la fenêtre principale.
    */

    public boolean Isnumber(){
        try{
            int x = Integer.parseInt(date1.getText().strip());
            int y = Integer.parseInt(duree1.getText().strip());
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
    
    /*
        Méthode qui permet de vérifier si les données inscrites dans les champs date et durée sont bien des Integer (elle retourne true si c'est le cas et false dans le cas contraire)
    */
    
    public boolean IsNotEmpty(){
        if(nom1.getText().isBlank() || date1.getText().isBlank() || duree1.getText().isBlank() || synopsys1.getText().isBlank()){
            return false;
        }else return true; 
    }
    
    /* 
        Méthode qui vérifie si l'ensemble des champs sont remplis, elle retourne true si c'est le cas et false dans le cas ou l'un des champs seraient nulle ou juste rempli d'espace.
    */
    
    
    public void Ecrire_Donnees_Dans_Champs(int position){
        nom1.setText(Films.get(position).getNom());
        date1.setText(Films.get(position).getDate());
        duree1.setText(Films.get(position).getDuree());
        synopsys1.append(Films.get(position).getSynopsys());
    }

    /*
        méthode qui permet d'écrire l'ensemble des données du film sélectionné dans les différents champs prévu à cet égard
    */
    
    public String WriteSysnopsysInFile(String synopsys){
        String[] lines = synopsys.split("\n"); // on segmente le paragraphe selon les sauts de lignes pour par la suite concaténer l'ensemble de ces phrases sur une seule ligne
        String Synopfile = "";
        for(String i : lines){
            Synopfile += i + " ";
        }
        return Synopfile;
    }
    
    /*
        méthode qui permet d'écrire correctement le synopsis (c'est à dire sur une seul ligne) dans notre base de données
    */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nom1 = new javax.swing.JTextField();
        date1 = new javax.swing.JTextField();
        Quitter = new javax.swing.JButton();
        Valider = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        duree1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        synopsys1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setFont(new java.awt.Font("Linux Libertine Display G", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Modifier les informations que vous souhaitées.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        nom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom1ActionPerformed(evt);
            }
        });

        date1.setText("jTextField2");
        date1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date1ActionPerformed(evt);
            }
        });

        Quitter.setBackground(new java.awt.Color(255, 102, 102));
        Quitter.setText("EXIT");
        Quitter.setMaximumSize(new java.awt.Dimension(77, 23));
        Quitter.setMinimumSize(new java.awt.Dimension(77, 23));
        Quitter.setPreferredSize(new java.awt.Dimension(77, 23));
        Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitterActionPerformed(evt);
            }
        });

        Valider.setBackground(new java.awt.Color(204, 255, 204));
        Valider.setText("VALIDER");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(102, 102, 255));
        jLabel1.setFont(new java.awt.Font("Linux Libertine Display G", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TITRE");

        jLabel7.setFont(new java.awt.Font("Linux Libertine Display G", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DATE");

        jLabel8.setFont(new java.awt.Font("Linux Libertine Display G", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DUREE");

        jLabel10.setFont(new java.awt.Font("Linux Libertine Display G", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("SYNOPSYS");

        duree1.setText("jTextField3");
        duree1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duree1ActionPerformed(evt);
            }
        });

        synopsys1.setColumns(20);
        synopsys1.setRows(5);
        jScrollPane1.setViewportView(synopsys1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel10))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Valider))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nom1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(duree1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(duree1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Valider, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitterActionPerformed
      this.dispose(); 
      D.setVisible(true);
    }//GEN-LAST:event_QuitterActionPerformed
    /*
        Méthode qui permet de fermer cette fenêtre et de ré-afficher la fenêtre principale
    */ 
    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed

        if(IsNotEmpty() && Isnumber()){ 
            String nom = nom1.getText().strip();
            String date = date1.getText().strip();
            String duree = duree1.getText().strip();
            String synopsys = WriteSysnopsysInFile(synopsys1.getText().strip());
            
            int position=D.index();
            Films.get(position).ModifierFilm(nom, date, duree, synopsys); //on modifie le film dans la liste
            
            EcritureF f= new EcritureF();
            f.Modifier(Films); //on modifie le film dans le fichier
            
            this.dispose();//on ferme cette fenêtre
            D.setVisible(true);//on ré-affiche la fenêtre principale
        }
        else {
            JOptionPane erreur = new JOptionPane();
            erreur.showMessageDialog(null, "Vous n'avez pas ou mal rempli certaines cases !", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_ValiderActionPerformed
    /*
        Méthode qui permet de valider les modifications (dans l'interface et dans le fichier) uniquement si les champs sont rempli et contiennent le bon format
    */ 
    private void nom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom1ActionPerformed

    }//GEN-LAST:event_nom1ActionPerformed

    private void date1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_date1ActionPerformed

    private void duree1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duree1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duree1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public void afficher() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Modifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modifications(D).setVisible(true);
            }
        });
    }
    /*
        Méthode qui permet d'ouvrir la fenêtre et d'afficher le contenu de celle ci
    */ 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Quitter;
    private javax.swing.JButton Valider;
    private javax.swing.JTextField date1;
    private javax.swing.JTextField duree1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nom1;
    private javax.swing.JTextArea synopsys1;
    // End of variables declaration//GEN-END:variables
}
