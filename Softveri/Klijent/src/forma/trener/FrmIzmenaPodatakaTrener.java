/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.trener;

import domen.Trener;
import java.util.Date;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import sesija.Sesija;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Natasa
 */
public class FrmIzmenaPodatakaTrener extends javax.swing.JDialog {
    private Trener ulogovanTrener = Sesija.getInstance().getTrener();

    public void setUlogovanTrener(Trener ulogovanTrener) {
        this.ulogovanTrener = ulogovanTrener;
    }

    public Trener getUlogovanTrener() {
        return ulogovanTrener;
    }
   

    /**
     * Creates new form FrmIzmenaPodatakaTrener
     */
    public FrmIzmenaPodatakaTrener(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        popuniPodatke();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelIzmena = new javax.swing.JPanel();
        jTextFieldIme = new javax.swing.JTextField();
        jTextFieldPrezime = new javax.swing.JTextField();
        jDateChooserDatum = new com.toedter.calendar.JDateChooser();
        jTextFieldEmail = new javax.swing.JTextField();
        jButtonIzmena = new javax.swing.JButton();
        jLabelIme = new javax.swing.JLabel();
        jLabelPrezime = new javax.swing.JLabel();
        jLabelDatum = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelPass = new javax.swing.JLabel();
        jPasswordFieldPass = new javax.swing.JPasswordField();
        jLabelID = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jButtonNazad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Izmena podataka - trener");

        jPanelIzmena.setBorder(javax.swing.BorderFactory.createTitledBorder("Izmena podataka o treneru"));

        jDateChooserDatum.setDateFormatString("dd.MM.yyyy");

        jButtonIzmena.setText("Izmeni podatke o treneru");
        jButtonIzmena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzmenaActionPerformed(evt);
            }
        });

        jLabelIme.setText("Ime: ");

        jLabelPrezime.setText("Prezime: ");

        jLabelDatum.setText("Datum rođenja: ");

        jLabelEmail.setText("E-mail: ");

        jLabelPass.setText("Password: ");

        jLabelID.setText("ID: ");

        jTextFieldID.setEditable(false);

        javax.swing.GroupLayout jPanelIzmenaLayout = new javax.swing.GroupLayout(jPanelIzmena);
        jPanelIzmena.setLayout(jPanelIzmenaLayout);
        jPanelIzmenaLayout.setHorizontalGroup(
            jPanelIzmenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIzmenaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelIzmenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonIzmena, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                    .addGroup(jPanelIzmenaLayout.createSequentialGroup()
                        .addComponent(jLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(jTextFieldID))
                    .addGroup(jPanelIzmenaLayout.createSequentialGroup()
                        .addComponent(jLabelDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooserDatum, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
                    .addGroup(jPanelIzmenaLayout.createSequentialGroup()
                        .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldEmail))
                    .addGroup(jPanelIzmenaLayout.createSequentialGroup()
                        .addComponent(jLabelPass, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPasswordFieldPass))
                    .addGroup(jPanelIzmenaLayout.createSequentialGroup()
                        .addComponent(jLabelPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPrezime))
                    .addGroup(jPanelIzmenaLayout.createSequentialGroup()
                        .addComponent(jLabelIme, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextFieldIme)))
                .addContainerGap())
        );
        jPanelIzmenaLayout.setVerticalGroup(
            jPanelIzmenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIzmenaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelIzmenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelID)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelIzmenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIme)
                    .addComponent(jTextFieldIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelIzmenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrezime)
                    .addComponent(jTextFieldPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelIzmenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooserDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDatum))
                .addGap(18, 18, 18)
                .addGroup(jPanelIzmenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelIzmenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPass)
                    .addComponent(jPasswordFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jButtonIzmena)
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
                    .addComponent(jPanelIzmena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonNazad)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelIzmena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNazad)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIzmenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmenaActionPerformed

        Long trenerID = Long.parseLong(jTextFieldID.getText());
        String ime = jTextFieldIme.getText();
        String prezime = jTextFieldPrezime.getText();
        Date datumRodjenja = jDateChooserDatum.getDate();
        String email = jTextFieldEmail.getText();
        char[] nizPass = jPasswordFieldPass.getPassword(); //Sifra je data kao niz (osetljiv podatak), moramo da je pretvorimo u string
        String pass = String.copyValueOf(nizPass); //Sad nam je sifra string

        if(ime.isEmpty() || prezime.isEmpty() || datumRodjenja == null || email.isEmpty() || pass.isEmpty()){
            JOptionPane.showMessageDialog(this, "Morate popuniti sva polja!!");
            return;
        }

        if (!email.endsWith("@kbk.com")) {
            JOptionPane.showMessageDialog(this, "E-mail adresa se mora završavati sa @kbk.com", "Greška prilikom izmene podataka", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Trener izmenjen = new Trener(trenerID, ime, prezime, email, pass, datumRodjenja);
       
        ServerskiOdgovor so = Kontroler.getInstance().izmeniTrenera(izmenjen);
        JOptionPane.showMessageDialog(this, so.getPoruka());
        boolean uspesnost = so.isUspesnost();

        if(uspesnost){
            JOptionPane.showMessageDialog(this, "Sistem je sačuvao izmene!!");
        }else{
            JOptionPane.showMessageDialog(this, "Sistem nije sačuvao izmene!!");
        }
        
        this.dispose();

    }//GEN-LAST:event_jButtonIzmenaActionPerformed

    private void jButtonNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNazadActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonNazadActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIzmena;
    private javax.swing.JButton jButtonNazad;
    private com.toedter.calendar.JDateChooser jDateChooserDatum;
    private javax.swing.JLabel jLabelDatum;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelIme;
    private javax.swing.JLabel jLabelPass;
    private javax.swing.JLabel jLabelPrezime;
    private javax.swing.JPanel jPanelIzmena;
    private javax.swing.JPasswordField jPasswordFieldPass;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldIme;
    private javax.swing.JTextField jTextFieldPrezime;
    // End of variables declaration//GEN-END:variables

    private void popuniPodatke() {
        jTextFieldID.setText(ulogovanTrener.getTrenerID()+"");
        jTextFieldIme.setText(ulogovanTrener.getIme());
        jTextFieldPrezime.setText(ulogovanTrener.getPrezime());
        jDateChooserDatum.setDate(ulogovanTrener.getDatumRodjenja());
        jTextFieldEmail.setText(ulogovanTrener.getEmail());
        jPasswordFieldPass.setText(ulogovanTrener.getPassword());
    }
}