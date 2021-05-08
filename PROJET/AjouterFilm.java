
package amine.bigpro;
import java.awt.Color;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.*;

public class AjouterFilm extends javax.swing.JFrame{
    private DVDFORM D;
    private ArrayList<Film> tmpFilms;

    public AjouterFilm(DVDFORM D) {
        this.D = D;
        tmpFilms = D.GetFilms();
        
        initComponents();
        Windowlistenner();
        
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // on empêche l'utilisation du scroll horizontal
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED); // on autorise le scroll vertical quand c'est nécessaire
        Synopsys.setLineWrap(true); // on permet le retour automatique à la ligne dès que le texte s'approche des bordures ( pour que le texte ne s'étale pas horizontalement)
        
        setChampsNULL();
                
    }
    
    public void setChampsNULL(){
        Titre.setText(null);
        Date.setText(null);
        Duree.setText(null);
        Synopsys.setText(null);
        Path.setText(null);
    }
    
    /*
        méthode qui permet d'affecter une valeur null aux champs, afin d'obtenir des champs vides
    */
    

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
        quand c'est le cas pour que l'utilisateur ne puisse pas arrêter le programme on récupère cette évènement et on ferme la fenêtre Ajouter tout en réaffichant la fenêtre principale
    */
    
    public boolean Isnumber(){
        try{
            int x = Integer.parseInt(Date.getText().strip());
            int y = Integer.parseInt(Duree.getText().strip());
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
    
    /*
        Méthode qui permet de vérifier si les données inscrites dans les champs date et durée sont des bien des Integer (elle retourne true si c'est le cas et false dans le cas contraire)
    */
    
    public boolean IsNotEmpty(){
        if(Titre.getText().isBlank() || Date.getText().isBlank() || Duree.getText().isBlank() || Synopsys.getText().isBlank() || Path.getText().isBlank()){
            return false; //peut mettre les labels en rouge pour signaler quand l'utilisateur a mal rempli
        }else return true; 
    }
    
    /* 
        Méthode qui vérifie si l'ensemble des champs sont remplies, elle retourne true si c'est le cas et false dans le cas ou le champs seraient nulle ou juste rempli d'espace.
    */
    
    public Boolean Verificationfilm(String titre, String date){
        for(int i=0;i<tmpFilms.size();i++){
            if(tmpFilms.get(i).getNom().equalsIgnoreCase(titre.strip())&& tmpFilms.get(i).getDate().equalsIgnoreCase(date.strip())){
                return false;
            }
        }
        return true;
    }

    /*
        méthode qui permet de vérifier si un film existe déjà dans notre base de données.
        On considère que le film existe déjà quand le nom et la date sont identiques.
    */

    public String WriteSysnopsysInFile(String synopsys){
        String[] lines = synopsys.split("\n");
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

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Quitter = new javax.swing.JButton();
        Titre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Date = new javax.swing.JTextField();
        Duree = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Synopsys = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        Path = new javax.swing.JTextField();
        ChoixPhoto = new javax.swing.JButton();
        Valider = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(111, 193, 193));

        jLabel1.setFont(new java.awt.Font("Linux Libertine Display G", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TITRE :");

        Quitter.setBackground(new java.awt.Color(255, 0, 0));
        Quitter.setFont(new java.awt.Font("Linux Libertine Display G", 2, 18)); // NOI18N
        Quitter.setText("Quitter");
        Quitter.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitterActionPerformed(evt);
            }
        });

        Titre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TitreActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Linux Libertine Display G", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DATE :");

        jLabel3.setFont(new java.awt.Font("Linux Libertine Display G", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DUREE :");

        Synopsys.setColumns(20);
        Synopsys.setRows(5);
        jScrollPane1.setViewportView(Synopsys);

        jLabel4.setFont(new java.awt.Font("Linux Libertine Display G", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SYNOPSYS :");

        Path.setEditable(false);
        Path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PathActionPerformed(evt);
            }
        });

        ChoixPhoto.setBackground(new java.awt.Color(0, 204, 204));
        ChoixPhoto.setFont(new java.awt.Font("Linux Libertine Display G", 2, 18)); // NOI18N
        ChoixPhoto.setForeground(new java.awt.Color(255, 255, 255));
        ChoixPhoto.setText("Choisir photo");
        ChoixPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoixPhotoActionPerformed(evt);
            }
        });

        Valider.setBackground(new java.awt.Color(102, 255, 153));
        Valider.setFont(new java.awt.Font("Linux Libertine Display G", 2, 18)); // NOI18N
        Valider.setText("Valider");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel5.setBackground(new java.awt.Color(0, 102, 102));
        jLabel5.setFont(new java.awt.Font("Linux Libertine Display G", 2, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ajouter votre film");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 94, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Path, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 94, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Duree, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ChoixPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(128, 128, 128))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Titre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(Valider, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(190, 190, 190)))
                                .addComponent(Quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Titre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChoixPhoto))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Duree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(Path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Valider, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TitreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TitreActionPerformed
        
    }//GEN-LAST:event_TitreActionPerformed

    private void QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitterActionPerformed
        this.dispose(); // on ferme cette fenêtre 
        D.setVisible(true); // on affiche la fenêtre principale (DVDFORM)
    }//GEN-LAST:event_QuitterActionPerformed
    /*
        Méthode qui permet de fermer cette fenêtre et de ré-afficher la fenêtre principale
    */ 
    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
        if(IsNotEmpty() && Isnumber()){
            if(Verificationfilm(Titre.getText().strip(), Date.getText().strip())){
                tmpFilms.add(new Film(Titre.getText().strip(), Date.getText().strip(), Duree.getText().strip(), WriteSysnopsysInFile(Synopsys.getText().strip()), Path.getText().strip()));
                D.addComboBox(tmpFilms.get(tmpFilms.size()-1)); // on ajoute le titre du film (qu'on vient d'enregistrer) à la ComboBox

                EcritureF Ajouterfilm = new EcritureF();
                Ajouterfilm.Ajouter(tmpFilms);// on ajoute ce nouveau film dans le fichier

                this.dispose(); // on ferme cette fenêtre 
                D.setVisible(true); // on affiche la fenêtre principale (DVDFORM)
                D.setButtonVisibleTrue();// on rend accessible les boutons lors d'un ajout (pour prévenir le cas où ils aient été désactivé)
            }
            else {
                JOptionPane erreur = new JOptionPane(); // message d'erreur quand le film existe déjà
                erreur.showMessageDialog(null, "IMPOSSIBLE! Ce film existe déjà dans notre gestionnaire\n Vous ne pouvez pas le rajouter", "Erreur", JOptionPane.ERROR_MESSAGE); 
                this.dispose();
                D.setVisible(true);
            }
        }
        else {
            JOptionPane erreur = new JOptionPane();
            erreur.showMessageDialog(null, "Vous n'avez pas ou mal rempli certaines cases !", "Erreur", JOptionPane.ERROR_MESSAGE); // message d'eereur quand au moins une case et vide et/ou le format est mauvais
        }
        
    }//GEN-LAST:event_ValiderActionPerformed
    /*
        Méthode qui permet de valider l'ajout du film (dans l'interface et dans le fichier) uniquement si les champs sont rempli, contiennent le bon format 
        et que le film ne soit pas déjà présent dans la base.
    */ 
    private void ChoixPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoixPhotoActionPerformed
        JFileChooser Photo = new JFileChooser(); //ouvre un explorateur de fichier
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG", "jpg", "png"); // initialise un filtre de format pour que seul les fichiers avec les formats jpg et png soient proposé
        Photo.setFileFilter(filter); // applique ce filtre
        if(Photo.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){ // permet de vérifier que le fichier a été selectionner
            Path.setText(Photo.getSelectedFile().getAbsolutePath());
        }
        else {
            JOptionPane Warning = new JOptionPane();
            Warning.showMessageDialog(null, "Le fichier n'a pas été ouvert veuillez recommencez", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_ChoixPhotoActionPerformed
    /*
        méthode qui permet de choisir la photo du film qu'on souhaite ajouter
    */
    private void PathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PathActionPerformed

    /**
     * @param args the command line arguments
     */
    public void Afficher() {
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
            java.util.logging.Logger.getLogger(AjouterFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjouterFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjouterFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjouterFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjouterFilm(D).setVisible(true);
            }
        });
    }
    /*
        Méthode qui permet d'ouvrir la fenêtre et d'afficher le contenu de celle ci
    */ 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChoixPhoto;
    private javax.swing.JTextField Date;
    private javax.swing.JTextField Duree;
    private javax.swing.JTextField Path;
    private javax.swing.JButton Quitter;
    private javax.swing.JTextArea Synopsys;
    private javax.swing.JTextField Titre;
    private javax.swing.JButton Valider;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
