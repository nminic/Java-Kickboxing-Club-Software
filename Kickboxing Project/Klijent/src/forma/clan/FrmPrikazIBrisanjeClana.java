/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.clan;

import domen.Clan;
import domen.Grupa;
import domen.Trener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import model.TableModelClan;
import model.TableModelPrisustvo;
import sesija.Sesija;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Natasa
 */
public class FrmPrikazIBrisanjeClana extends javax.swing.JDialog {

    private Trener ulogovanTrener = Sesija.getInstance().getTrener();

    /**
     * Creates new form FrmPrikazIBrisanjeClana
     */
    public FrmPrikazIBrisanjeClana(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);

        popuniComboGrupa();

        //Za svako popunjavanje try/catch
        try {
            popuniTabelu();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Greška prilikom popunjavanja tabele: " + e.getMessage(), "Greška u učitavanju podataka", JOptionPane.ERROR_MESSAGE);
            this.dispose();
            throw e;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrikaz = new javax.swing.JPanel();
        jScrollPaneClan = new javax.swing.JScrollPane();
        jTableClan = new javax.swing.JTable();
        jButtonObrisi = new javax.swing.JButton();
        jButtonSvojiClanovi = new javax.swing.JButton();
        jButtonTrenerClanovi = new javax.swing.JButton();
        jLabelGrupa = new javax.swing.JLabel();
        jComboBoxGrupa = new javax.swing.JComboBox<>();
        jButtonGrupa = new javax.swing.JButton();
        jButtonDetaljno = new javax.swing.JButton();
        jLabelPoruka = new javax.swing.JLabel();
        jButtonNazad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Članovi");

        jPanelPrikaz.setBorder(javax.swing.BorderFactory.createTitledBorder("Prikaz članova"));

        jTableClan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPaneClan.setViewportView(jTableClan);

        jButtonObrisi.setText("Obriši člana");
        jButtonObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonObrisiActionPerformed(evt);
            }
        });

        jButtonSvojiClanovi.setText("Prikaži sve članove trenera");
        jButtonSvojiClanovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSvojiClanoviActionPerformed(evt);
            }
        });

        jButtonTrenerClanovi.setText("Prikaži sve članove");
        jButtonTrenerClanovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTrenerClanoviActionPerformed(evt);
            }
        });

        jLabelGrupa.setText("Grupa:");

        jComboBoxGrupa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonGrupa.setText("Prikaži članove po grupi");
        jButtonGrupa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGrupaActionPerformed(evt);
            }
        });

        jButtonDetaljno.setText("Detaljan prikaz članova i prisustva");
        jButtonDetaljno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetaljnoActionPerformed(evt);
            }
        });

        jLabelPoruka.setText("Možete obrisati člana samo ukoliko ne postoje evidentirana prisustva za istog!");

        javax.swing.GroupLayout jPanelPrikazLayout = new javax.swing.GroupLayout(jPanelPrikaz);
        jPanelPrikaz.setLayout(jPanelPrikazLayout);
        jPanelPrikazLayout.setHorizontalGroup(
            jPanelPrikazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrikazLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPrikazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneClan)
                    .addComponent(jButtonObrisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelPrikazLayout.createSequentialGroup()
                        .addGroup(jPanelPrikazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelPrikazLayout.createSequentialGroup()
                                .addComponent(jLabelGrupa)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxGrupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonGrupa, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonSvojiClanovi, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jPanelPrikazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonTrenerClanovi, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                            .addComponent(jButtonDetaljno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrikazLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelPoruka)))
                .addContainerGap())
        );
        jPanelPrikazLayout.setVerticalGroup(
            jPanelPrikazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrikazLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneClan, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanelPrikazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGrupa)
                    .addComponent(jComboBoxGrupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGrupa)
                    .addComponent(jButtonDetaljno))
                .addGap(18, 18, 18)
                .addGroup(jPanelPrikazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTrenerClanovi)
                    .addComponent(jButtonSvojiClanovi))
                .addGap(18, 18, 18)
                .addComponent(jButtonObrisi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPoruka)
                .addContainerGap())
        );

        jButtonNazad.setText("Nazad");
        jButtonNazad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNazadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelPrikaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonNazad)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPrikaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButtonNazad)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNazadActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonNazadActionPerformed

    private void jButtonObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonObrisiActionPerformed
        int red = jTableClan.getSelectedRow();

        if (red != -1) {

            TableModelClan tmc = (TableModelClan) jTableClan.getModel();

            Clan clan = tmc.uzmiClana(red);

            if (ulogovanTrener.getTrenerID().equals(clan.getGrupa().getTrener().getTrenerID())) {

                Long clanID = (Long) jTableClan.getValueAt(red, 0);
                Grupa grupa = (Grupa) jTableClan.getValueAt(red, 6);
                int brojClanova = grupa.getBrojClanova();
                int noviBrojClanova = brojClanova - 1;
                grupa.setBrojClanova(noviBrojClanova);

                tmc.obrisiClana(red);

                Clan obrisan = new Clan();
                obrisan.setClanID(clanID);
                obrisan.setGrupa(grupa);
                ServerskiOdgovor so = Kontroler.getInstance().obrisiClana(obrisan);
                so.getPoruka();

                if (so.isUspesnost()) {
                    ServerskiOdgovor so1 = Kontroler.getInstance().izmeniGrupu(grupa);
                    JOptionPane.showMessageDialog(this, "Sistem je obrisao izabranog člana!!");
                } else {
                    JOptionPane.showMessageDialog(this, "Sistem nije obrisao izabranog člana! Moguće je obrisati samo neaktivne članove! Aktivnost člana proverite u detaljnom prikazu članova i prisustva!");
                    return;
                }

            } else {
                JOptionPane.showMessageDialog(this, "Trener može obrisati samo svoje članove!!");
                return;
            }

        } else {
            JOptionPane.showMessageDialog(this, "Odaberite člana koga želite da obrišete!!");
            return;
        }
    }//GEN-LAST:event_jButtonObrisiActionPerformed

    private void jButtonSvojiClanoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSvojiClanoviActionPerformed
        pretrazi();
    }//GEN-LAST:event_jButtonSvojiClanoviActionPerformed

    private void jButtonTrenerClanoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTrenerClanoviActionPerformed
        popuniTabelu();
    }//GEN-LAST:event_jButtonTrenerClanoviActionPerformed

    private void jButtonGrupaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGrupaActionPerformed
        pretraziPoGrupi();
    }//GEN-LAST:event_jButtonGrupaActionPerformed

    private void jButtonDetaljnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetaljnoActionPerformed

        try {
            FrmPrikazClanovaSaPrisustvom formaDetaljanPrikaz = new FrmPrikazClanovaSaPrisustvom(null, true);
            formaDetaljanPrikaz.pack();
            formaDetaljanPrikaz.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrikazIBrisanjeClana.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonDetaljnoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDetaljno;
    private javax.swing.JButton jButtonGrupa;
    private javax.swing.JButton jButtonNazad;
    private javax.swing.JButton jButtonObrisi;
    private javax.swing.JButton jButtonSvojiClanovi;
    private javax.swing.JButton jButtonTrenerClanovi;
    private javax.swing.JComboBox<Object> jComboBoxGrupa;
    private javax.swing.JLabel jLabelGrupa;
    private javax.swing.JLabel jLabelPoruka;
    private javax.swing.JPanel jPanelPrikaz;
    private javax.swing.JScrollPane jScrollPaneClan;
    private javax.swing.JTable jTableClan;
    // End of variables declaration//GEN-END:variables

    private void popuniTabelu() {
        ServerskiOdgovor so = Kontroler.getInstance().vratiListuClanova();
        ArrayList<Clan> listaClanova = (ArrayList<Clan>) so.getOdgovor();
        TableModelClan tmc = new TableModelClan(listaClanova);
        jTableClan.setModel(tmc);
    }

    private void pretrazi() {
        ServerskiOdgovor so = Kontroler.getInstance().pretraziClanove();
        ArrayList<Clan> listaClanova = (ArrayList<Clan>) so.getOdgovor();
        ArrayList<Clan> prikaz = new ArrayList<>();

        for (Clan clan : listaClanova) {
            if (ulogovanTrener.getTrenerID().equals(clan.getGrupa().getTrener().getTrenerID())) {
                prikaz.add(clan);
            }
        }
        TableModelClan tmc = (TableModelClan) jTableClan.getModel();
        tmc.setListaClanova(prikaz);
    }

    private void pretraziPoGrupi() {
        Grupa grupa = (Grupa) jComboBoxGrupa.getSelectedItem();
        ServerskiOdgovor so = Kontroler.getInstance().pretraziClanove();
        ArrayList<Clan> listaClanova = (ArrayList<Clan>) so.getOdgovor();
        ArrayList<Clan> prikaz = new ArrayList<>();

        if (grupa == null) {
            JOptionPane.showMessageDialog(this, "Trener ne trenira nijednu grupu!! Napravi novu grupu!!");
            return;
        }

        for (Clan clan : listaClanova) {

            if (ulogovanTrener.getTrenerID().equals(clan.getGrupa().getTrener().getTrenerID())) {
                if (grupa.getGrupaID().equals(clan.getGrupa().getGrupaID())) {
                    prikaz.add(clan);
                }
            }

        }
        TableModelClan tmc = (TableModelClan) jTableClan.getModel();
        tmc.setListaClanova(prikaz);
    }

    private void popuniComboGrupa() {
        jComboBoxGrupa.removeAllItems(); //uklanjanje default vrednosti

        ServerskiOdgovor so = Kontroler.getInstance().vratiListuGrupa();
        ArrayList<Grupa> listaGrupa = (ArrayList<Grupa>) so.getOdgovor();

        for (Grupa g : listaGrupa) {

            if (g.getTrener().getTrenerID().equals(ulogovanTrener.getTrenerID())) {
                jComboBoxGrupa.addItem(g);
            }
        }
    }

}