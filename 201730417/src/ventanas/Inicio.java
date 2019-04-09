
package ventanas;


public class Inicio extends javax.swing.JFrame {
    //obetos iniciaizados
    Punteo tablaPunteo = new Punteo();
    Jugador jugador = new Jugador();
    public Inicio() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inicioJuego = new javax.swing.JButton();
        tablaPunteos = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inicioJuego.setBackground(new java.awt.Color(51, 51, 51));
        inicioJuego.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 14)); // NOI18N
        inicioJuego.setForeground(new java.awt.Color(255, 255, 255));
        inicioJuego.setText("INICIAR JUEGO");
        inicioJuego.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        inicioJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioJuegoActionPerformed(evt);
            }
        });
        getContentPane().add(inicioJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 170, 70));

        tablaPunteos.setBackground(new java.awt.Color(51, 51, 51));
        tablaPunteos.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 14)); // NOI18N
        tablaPunteos.setForeground(new java.awt.Color(255, 255, 255));
        tablaPunteos.setText("TABLA DE PUNTEOS");
        tablaPunteos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tablaPunteos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tablaPunteosActionPerformed(evt);
            }
        });
        getContentPane().add(tablaPunteos, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 170, 70));

        salir.setBackground(new java.awt.Color(51, 51, 51));
        salir.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 14)); // NOI18N
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setText("SALIR");
        salir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 170, 70));

        jLabel1.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EL ENIGMA DE LAS TORRES Y LOS ALFILES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 420, 60));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoAjedrez.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, 0, 1010, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        //accion para salir del juego
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void inicioJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioJuegoActionPerformed
        //accion para llamar a la ventana jugador
        jugador.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_inicioJuegoActionPerformed

    private void tablaPunteosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tablaPunteosActionPerformed
        //accion para llamar a la tabla de punteos
        tablaPunteo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tablaPunteosActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JButton inicioJuego;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton salir;
    private javax.swing.JButton tablaPunteos;
    // End of variables declaration//GEN-END:variables
}
