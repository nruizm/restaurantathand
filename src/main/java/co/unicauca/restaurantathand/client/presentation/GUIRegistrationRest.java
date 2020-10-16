/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurantathand.client.presentation;

import co.unicauca.restaurantathand.client.access.Factory;
import co.unicauca.restaurantathand.client.access.IRestaurantAccess;
import co.unicauca.restaurantathand.client.domain.services.RestaurantService;
import static co.unicauca.restaurantathand.client.infra.Messages.successMessage;
import co.unicauca.restaurantathand.commons.domain.Restaurant;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Michelle Vallejo
 */
public class GUIRegistrationRest extends javax.swing.JFrame {

    /**
     * Creates new form GUIRegistrationRest
     * 
     */
    public GUIRegistrationRest() {
        initComponents();
        setLocationRelativeTo(null);
        initIcons();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        lblFondoRest = new javax.swing.JLabel();
        pnlRegistrarRest = new javax.swing.JPanel();
        lblCheckRest = new javax.swing.JLabel();
        lblNitRes = new javax.swing.JLabel();
        lblNameRest = new javax.swing.JLabel();
        lblAddressRest = new javax.swing.JLabel();
        lblCityRest = new javax.swing.JLabel();
        lblPhoneRest = new javax.swing.JLabel();
        lblEmailRest = new javax.swing.JLabel();
        txtNitRest = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtNameRest = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtAddressRest = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtCityRest = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txtPhoneRest = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        txtEmailRest = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        btnCheckInRest = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFondoRest, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFondoRest, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        getContentPane().add(pnlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 470));

        pnlRegistrarRest.setBackground(new java.awt.Color(255, 255, 255));

        lblNitRes.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblNitRes.setForeground(new java.awt.Color(102, 102, 102));
        lblNitRes.setText("Nit:");

        lblNameRest.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblNameRest.setForeground(new java.awt.Color(102, 102, 102));
        lblNameRest.setText("Name:");

        lblAddressRest.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblAddressRest.setForeground(new java.awt.Color(102, 102, 102));
        lblAddressRest.setText("Address:");

        lblCityRest.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblCityRest.setForeground(new java.awt.Color(102, 102, 102));
        lblCityRest.setText("City:");

        lblPhoneRest.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblPhoneRest.setForeground(new java.awt.Color(102, 102, 102));
        lblPhoneRest.setText("Phone:");

        lblEmailRest.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblEmailRest.setForeground(new java.awt.Color(102, 102, 102));
        lblEmailRest.setText("Email:");

        txtNitRest.setBorder(null);

        txtNameRest.setBorder(null);

        txtAddressRest.setBorder(null);

        txtCityRest.setBorder(null);

        txtPhoneRest.setBorder(null);

        txtEmailRest.setBorder(null);

        btnCheckInRest.setBackground(new java.awt.Color(102, 102, 102));
        btnCheckInRest.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnCheckInRest.setText("Check in");
        btnCheckInRest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckInRestActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("Black");
        jButton1.setBorder(null);

        javax.swing.GroupLayout pnlRegistrarRestLayout = new javax.swing.GroupLayout(pnlRegistrarRest);
        pnlRegistrarRest.setLayout(pnlRegistrarRestLayout);
        pnlRegistrarRestLayout.setHorizontalGroup(
            pnlRegistrarRestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarRestLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(pnlRegistrarRestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNitRes)
                    .addComponent(lblNameRest)
                    .addComponent(lblCityRest)
                    .addComponent(lblPhoneRest)
                    .addComponent(lblEmailRest)
                    .addComponent(lblAddressRest))
                .addGap(26, 26, 26)
                .addGroup(pnlRegistrarRestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator6)
                    .addComponent(txtEmailRest)
                    .addComponent(jSeparator5)
                    .addComponent(txtPhoneRest)
                    .addComponent(jSeparator4)
                    .addComponent(txtCityRest)
                    .addComponent(jSeparator3)
                    .addComponent(txtAddressRest)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addComponent(txtNitRest)
                    .addComponent(txtNameRest, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistrarRestLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRegistrarRestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistrarRestLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(lblCheckRest, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistrarRestLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCheckInRest)
                        .addGap(98, 98, 98))))
        );
        pnlRegistrarRestLayout.setVerticalGroup(
            pnlRegistrarRestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarRestLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRegistrarRestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCheckRest, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(pnlRegistrarRestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNitRes)
                    .addComponent(txtNitRest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(pnlRegistrarRestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNameRest)
                    .addComponent(txtNameRest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(pnlRegistrarRestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddressRest)
                    .addComponent(txtAddressRest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRegistrarRestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCityRest)
                    .addComponent(txtCityRest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(pnlRegistrarRestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhoneRest)
                    .addComponent(txtPhoneRest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(pnlRegistrarRestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmailRest)
                    .addComponent(txtEmailRest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCheckInRest)
                .addGap(41, 41, 41))
        );

        getContentPane().add(pnlRegistrarRest, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 430, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckInRestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckInRestActionPerformed
        IRestaurantAccess service = Factory.getInstance().getRestaurantService();
        //Inyecta la dependencia
        
        RestaurantService restaurantService = new RestaurantService(service);
        
        Restaurant restaurant = new Restaurant();
        restaurant.setAtrNitRest(txtNitRest.getText());
        restaurant.setAtrAdmiRest("mfgranoble"); //Valor quemado (Se va a validar )
        restaurant.setAtrNameRest(txtNameRest.getText());
        restaurant.setAtrAddressRest(txtAddressRest.getText());
        restaurant.setAtrEmailRest(txtEmailRest.getText());
        restaurant.setAtrCityRest(txtCityRest.getText());
        restaurant.setAtrMobileRest(txtPhoneRest.getText());
        
        try{
            String response = restaurantService.createRestaurant(restaurant);
            successMessage("Restaurant" + response + "agregado con exito","Atencion");
            txtNitRest.setText("");
        }catch (Exception ex ){
            System.out.println(ex);
            successMessage(ex.getMessage() + "Error", "Atencion");
        }
        
        
        
    }//GEN-LAST:event_btnCheckInRestActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    /**
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIRegistrationRest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIRegistrationRest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIRegistrationRest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIRegistrationRest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIRegistrationRest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckInRest;
    private javax.swing.JButton jButton1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblAddressRest;
    private javax.swing.JLabel lblCheckRest;
    private javax.swing.JLabel lblCityRest;
    private javax.swing.JLabel lblEmailRest;
    private javax.swing.JLabel lblFondoRest;
    private javax.swing.JLabel lblNameRest;
    private javax.swing.JLabel lblNitRes;
    private javax.swing.JLabel lblPhoneRest;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlRegistrarRest;
    private javax.swing.JTextField txtAddressRest;
    private javax.swing.JTextField txtCityRest;
    private javax.swing.JTextField txtEmailRest;
    private javax.swing.JTextField txtNameRest;
    private javax.swing.JTextField txtNitRest;
    private javax.swing.JTextField txtPhoneRest;
    // End of variables declaration//GEN-END:variables
private void initIcons() {
    
    
        addIcon(lblFondoRest, "src/main/java/resource/fondo.png");
        addIcon(lblCheckRest, "src/main/java/resource/check.png");
        
    }
    private void addIcon(JLabel lb, String pathIcon) {
        ImageIcon img = new ImageIcon(pathIcon);
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(
                lb.getWidth(),
                lb.getHeight(),
                Image.SCALE_DEFAULT));
        lb.setIcon(icono);
        this.repaint();
    }
}
