
package amine.bigpro;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DVDFORM extends javax.swing.JFrame {
    private ArrayList<Film> films;


    public DVDFORM() {
        initComponents();
        LectureF f = new LectureF();
        f.Segmenter();
        String[][] result = f.Getresult();
        films = new ArrayList<Film>();

        jComboBox1.removeAllItems();

        for(int i=0; i<result.length; i++){
            films.add(new Film(result[i][0], result[i][1], result[i][2], result[i][3], result[i][4])); // on ajoute dans la liste une instance de Film, et on fait ça pour chaque film présent dans notre tableau
            jComboBox1.addItem(result[i][0]); // on range les titres des films dans la ComboBox
        }

        setChampsNULL();

        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // on empêche l'utilisation du scroll horizontal
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED); // on autorise le scroll vertical quand c'est nécessaire
        jTextArea1.setLineWrap(true); // on permet le retour automatique à la ligne dès que le texte s'approche des bordures ( pour que le texte ne s'étale pas horizontalement)
    }


    public void setChampsNULL(){
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextArea1.setText(null);
        jLabel1.setText(null);
        jLabel1.setIcon(null);
    }
    /*
        méthode qui permet d'affecter une valeur null aux champs, afin d'obtenir des champs vides
    */

    public ArrayList<Film> GetFilms(){
        return films;
    }

    /*
        Accesseur en lecture qui permet de récupérer la liste de films
    */

    public void addComboBox(Film f){
        jComboBox1.addItem(f.getNom());
    }

    /*
        méthode qui permet d'ajouter un item à la ComboBox (ajouter un titre de film)
    */

    public int index(){
        return jComboBox1.getSelectedIndex();
    }

    /*
        méthode qui permet de récupérer l'indice de l'item/film qu'on a sélectionné
    */

    public int NBItem(){
        return jComboBox1.getItemCount();
    }

    /*
        méthode qui permet de récupérer le nombre d'item de la ComboBox (soit le nombre de films restant dans la liste)
    */

    public void setButtonVisibleTrue(){
        ModifierInfos.setEnabled(true);
        ModifierJaquette.setEnabled(true);
        RetirerFilm.setEnabled(true);
    }

    /*
        méthode qui permet de rendre accessible les boutons (qui ont pu être désactiver dans les méthodes RetirerFilm, ModifierInfos, ModifierJaquette)
    */

    public void Ecrire_Donnees_Dans_Champs(int position){
        jTextField1.setText(films.get(position).getDate());
        jTextField2.setText(films.get(position).getDuree());
        jTextArea1.setText("Voici le Synopsys de cette oeuvre:\n");
        jTextArea1.append(films.get(position).getSynopsys());
    }

    /*
        méthode qui permet d'écrire l'ensemble des données du film sélectionné dans les différents champs prévu à cet égard
    */



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Quitter = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ModifierJaquette = new javax.swing.JButton();
        ModifierInfos = new javax.swing.JButton();
        Ajouter = new javax.swing.JButton();
        RetirerFilm = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        FilmSuivant = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        Actualiser = new javax.swing.JButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(219, 192, 246));

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setBackground(new java.awt.Color(255, 204, 204));
        jLabel5.setFont(new java.awt.Font("Linux Libertine Display G", 2, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("GESTIONNAIRE    DE    DVD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel5.getAccessibleContext().setAccessibleName("GESTIONNAIRE   DE    DVD");

        Quitter.setBackground(new java.awt.Color(255, 51, 51));
        Quitter.setText("Quitter");
        Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitterActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        ModifierJaquette.setBackground(new java.awt.Color(153, 0, 153));
        ModifierJaquette.setFont(new java.awt.Font("Linux Libertine Display G", 1, 18)); // NOI18N
        ModifierJaquette.setForeground(new java.awt.Color(255, 255, 255));
        ModifierJaquette.setText("Modifier la jaquette");
        ModifierJaquette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierJaquetteActionPerformed(evt);
            }
        });

        ModifierInfos.setBackground(new java.awt.Color(153, 0, 153));
        ModifierInfos.setFont(new java.awt.Font("Linux Libertine Display G", 1, 18)); // NOI18N
        ModifierInfos.setForeground(new java.awt.Color(255, 255, 255));
        ModifierInfos.setText("Modifier les informations");
        ModifierInfos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierInfosActionPerformed(evt);
            }
        });

        Ajouter.setBackground(new java.awt.Color(153, 0, 153));
        Ajouter.setFont(new java.awt.Font("Linux Libertine Display G", 1, 18)); // NOI18N
        Ajouter.setForeground(new java.awt.Color(255, 255, 255));
        Ajouter.setText("Ajouter");
        Ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterActionPerformed(evt);
            }
        });

        RetirerFilm.setBackground(new java.awt.Color(153, 0, 153));
        RetirerFilm.setFont(new java.awt.Font("Linux Libertine Display G", 1, 18)); // NOI18N
        RetirerFilm.setForeground(new java.awt.Color(255, 255, 255));
        RetirerFilm.setText("Retirer film");
        RetirerFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetirerFilmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(ModifierInfos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(ModifierJaquette)
                .addGap(108, 108, 108)
                .addComponent(RetirerFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ModifierJaquette, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ModifierInfos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RetirerFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(204, 0, 204));
        jLabel2.setFont(new java.awt.Font("Linux Libertine Display G", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DATE");

        jTextField1.setEditable(false);
        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(204, 0, 204));
        jLabel3.setFont(new java.awt.Font("Linux Libertine Display G", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DUREE");

        jTextField2.setEditable(false);
        jTextField2.setText("jTextField2");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Source Code Pro ExtraLight", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        FilmSuivant.setBackground(new java.awt.Color(153, 0, 153));
        FilmSuivant.setFont(new java.awt.Font("Linux Libertine Display G", 1, 18)); // NOI18N
        FilmSuivant.setForeground(new java.awt.Color(255, 255, 255));
        FilmSuivant.setText("film suivant");
        FilmSuivant.setToolTipText("");
        FilmSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilmSuivantActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(204, 0, 204));
        jLabel4.setFont(new java.awt.Font("Linux Libertine Display G", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("SYNOPSIS");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(120, 120));
        jLabel1.setPreferredSize(new java.awt.Dimension(120, 160));

        Actualiser.setBackground(new java.awt.Color(153, 0, 153));
        Actualiser.setFont(new java.awt.Font("Linux Libertine Display G", 1, 18)); // NOI18N
        Actualiser.setForeground(new java.awt.Color(255, 255, 255));
        Actualiser.setText("Actualiser");
        Actualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualiserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(FilmSuivant, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Actualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FilmSuivant, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Actualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(322, 322, 322)
                                .addComponent(Quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(57, 57, 57)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int position_item = 0;
        position_item = index();
        if(position_item >= 0 && films.get(position_item)!=null){
            Ecrire_Donnees_Dans_Champs(position_item);
            ImageIcon icone = new ImageIcon(new ImageIcon(films.get(position_item).getPicturePath()).getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH)); // on change la taille de la photo
            jLabel1.setIcon(icone);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed
    /*
        méthode qui permet de remplir tous les champs de la fenêtre (grâce à la métgode Ecrire_Données_Dans_Champs) dont la photo grâce à l'indice correspondant au film sélectionné
    */
    private void FilmSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilmSuivantActionPerformed
        int position = index();
        if(position < NBItem()-1) // si la position est inférieur ou égale à l'avant dernier item de la liste alors on passe au suivant
            jComboBox1.setSelectedIndex(position+1);
        else { // sinon on informe via une boîte de dialogue que l'utilisateur est arrivé au bout de la liste
            JOptionPane Infos = new JOptionPane();
            Infos.showMessageDialog(null, "Vous êtes à la fin de la liste vous ne pouvez plus \navancer !", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_FilmSuivantActionPerformed
    /*
        méthode qui permet d'accéder au film suivant de la liste et indique lorsqu'on est arrivé au bout de la liste
    */
    private void ModifierInfosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierInfosActionPerformed
        int position = index();
        int taille_combo = NBItem();
        if(taille_combo > 0 && position >=0 ){
            JOptionPane Infos = new JOptionPane();
            Infos.showMessageDialog(null, "Veuillez bien remplir toute les cases!!\n Dans les champs Date et Duree il faut mettre que des entiers", "Informations", JOptionPane.INFORMATION_MESSAGE);

            Modifications film = new Modifications(this);
            film.afficher();
            this.setVisible(false); // on fait disparaître la fenêtre principale pendant tout le processus de modification.
        }
        else { // dans le cas où le gestionnaire est vide on désactive le bouton Modifier Informations
            ModifierInfos.setEnabled(false);
            JOptionPane Infos = new JOptionPane();
            Infos.showMessageDialog(null, "Il n'y a pas de films dans votre gestionnaire", "Informations", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ModifierInfosActionPerformed
    /*
        méthode qui permet de modifier l'ensemble des informations du film sur lequel on se trouve (grâce à l'index de la ComboBox récupérer).
        Elle permet d'ouvrir une nouvelle fenêtre dans laquelle l'utilisateur peut modfier les informations qu'il souhaite.
    */
    private void AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterActionPerformed

        JOptionPane Infos = new JOptionPane();
        Infos.showMessageDialog(null, "Veuillez bien remplir toute les cases!!\n Dans les champs Date et Duree il faut mettre que des entiers", "Informations", JOptionPane.INFORMATION_MESSAGE);

        AjouterFilm film = new AjouterFilm(this);
        film.Afficher();
        this.setVisible(false);
    }//GEN-LAST:event_AjouterActionPerformed
    /*
        méthode qui permet d'ajouter un film, on ouvre une nouvelle fenêtre dans laquelle il est possible de saisir l'ensemble des informations nécessaire pour l'enregistrer
    */
    private void QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitterActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_QuitterActionPerformed
    /*
        méthode qui permet de fermer la fenêtre en question et de quitter le programme
    */
    private void RetirerFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetirerFilmActionPerformed

        int position = index();
        int taille_combo = NBItem();

        if(taille_combo > 0 && position >=0){
            JOptionPane confirmation = new JOptionPane();
            int option = confirmation.showConfirmDialog(null, "Voulez-vous vraiment retirer le films de la base ?","Supression film", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if(option == JOptionPane.OK_OPTION){
                jComboBox1.removeItemAt(position);
                films.remove(position);
                if(taille_combo==1){
                    setChampsNULL(); // on efface tous les champs quand on retire le dernier film de la liste (La ComboBox est donc désormais vide)
                }
                EcritureF movie = new EcritureF();
                movie.Retirer(films);
            }
        }

        else {
            RetirerFilm.setEnabled(false); // on bloque le bouton à l'utilisateur si la ComboBox est vide
            JOptionPane Infos = new JOptionPane();
            Infos.showMessageDialog(null, "Il n'y a pas de films dans votre gestionnaire", "Informations", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_RetirerFilmActionPerformed
    /*
        méthode qui permet de retirer le film sélectionné dans la fenêtre et dans le fichier
    */
    private void ModifierJaquetteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierJaquetteActionPerformed
        int taille_combo = NBItem();

        if(taille_combo > 0){
            JFileChooser Photo = new JFileChooser(); // ouvre un explorateur de fichier
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG", "jpg", "png"); // initialise un filtre de format pour que seul les fichiers avec les formats jpg et png soient proposés
            Photo.setFileFilter(filter); // applique ce filtre
            if(Photo.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){ // cette condition permet de vérifier que le fichier a été selectionné
                int position = index();
                films.get(position).ModifierImage(Photo.getSelectedFile().getAbsolutePath());
                ImageIcon icone = new ImageIcon(new ImageIcon(films.get(position).getPicturePath()).getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH));
                jLabel1.setIcon(icone);// on affiche la nouvelle jaquette

                EcritureF f= new EcritureF();
                f.Modifier(films); //on modifie le film dans le fichier
            }
            else {
                JOptionPane Warning = new JOptionPane();
                Warning.showMessageDialog(null, "Le fichier n'a pas été ouvert veuillez recommencez", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
        else {
            ModifierJaquette.setEnabled(false); // on bloque le bouton à l'utilisateur si la ComboBox est vide
            JOptionPane Infos = new JOptionPane();
            Infos.showMessageDialog(null, "Il n'y a pas de films dans votre gestionnaire", "Informations", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ModifierJaquetteActionPerformed
    /*
        méthode qui permet de modifier la photo du film sélectionné (à la fois sur l'interface et sur le fichier)
    */
    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void ActualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualiserActionPerformed
        int position = index();
        Ecrire_Donnees_Dans_Champs(position);
    }//GEN-LAST:event_ActualiserActionPerformed

    /*
        méthode qui permet d'actualiser la page et plus précisemment d'actualiser les informations du dernier film sélectionné (utile lorsqu'on modifie le film)
    */

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(DVDFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DVDFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DVDFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DVDFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DVDFORM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualiser;
    private javax.swing.JButton Ajouter;
    private javax.swing.JButton FilmSuivant;
    private javax.swing.JButton ModifierInfos;
    private javax.swing.JButton ModifierJaquette;
    private javax.swing.JButton Quitter;
    private javax.swing.JButton RetirerFilm;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
