
package ventanas;

import alfil.DerechaAbajo;
import alfil.DerechaArriba;
import alfil.IzquierdaAbajo;
import alfil.IzquierdaArriba;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import torre.AbajoTorre;
import torre.ArribaTorre;
import torre.DerechaTorre;
import torre.IzquierdaTorre;

public class Tablero extends javax.swing.JFrame {

    //llamamos a metodos del paquete torre para realizar los movimientos
    AbajoTorre abajoTorre;
    ArribaTorre arribaTorre;
    DerechaTorre derechaTorre;
    IzquierdaTorre izquierdaTorre;
    //llamamos a metodos del paquete alfil para realizar sus respectivos movimientos
    DerechaAbajo derechaAbajo;
    DerechaArriba derechaArriba;
    IzquierdaAbajo izquierdaAbajo;
    IzquierdaArriba izquierdaArriba;
    
    int[][] arregloJuego;
        
    Thread tiempoLinea;
    JButton[][] tablero;
    ImageIcon imagen;
    Icon imagenPieza,copiaImagen;
    JButton copiaBoton,botonNegro,botonBlanco;
    
    //variables a utilizar en el proceso de generacion del tablero
    private int dimension;
    private int color1,color2;
    private int contador = 0;
    private int pos1,pos2,datoPunteo;
    private int contadorTorre = 0,contadorAlfil = 0;
    private final String infoTorre = "                  TORRE"; 
    private final String infoAlfil = "                  ALFIL"; 
    private final String sinSeleccion = "SIN PIEZA SELECCIONADA";
    private String cambioIcono, movPiezas,punteoFinal;
    
    String name;
    String size;
    
    //metodo constructor donde se inicializa el frame tablero
    public Tablero() {
        initComponents();
        this.setLocationRelativeTo(null);
        informacionPieza.setText(sinSeleccion);
        cambioIcono = sinSeleccion;
        dimension = Integer.parseInt(Jugador.dimension.getText());
        name = Jugador.nombreJugador.getText();
        generarTablero();                
    }
    //metodo para mandar el valor del punteo obtenido al frame FinJuego
    public void punteo(){
       FinJuego fin = new FinJuego(); 
       FinJuego.punteo.setText(punteoFinal);
    }
    //metodo mediante el cual se genera el tablero de ajedrez
    public void generarTablero(){
        tablero = new JButton[dimension][dimension];
        arregloJuego = new int[dimension][dimension];
        for (int fila = 0; fila < dimension; fila++) {
            for (int columna = 0; columna < dimension; columna++) {
                arregloJuego[fila][columna] = 1;
                tablero[fila][columna] = new JButton();
                tablero[fila][columna].setBounds(75*fila,75*columna,75,75);
                //con estas condiciones generamos los colores blanco y negro del tablero              
                color1 = columna;
                color2 = fila;                
                if( color1%2 == 0 && color2%2 == 0){
                    tablero[fila][columna].setBackground(Color.black);
                }
                if(color1%2 != 0 && color2%2 != 0){
                    tablero[fila][columna].setBackground(Color.black);
                }                                
                //creamos un objeto del tipo ActionListener
                Pieza piezaAjedrez = new Pieza();
                //iniciamos el ActionListener
                tablero[fila][columna].addActionListener(piezaAjedrez);
                //agregamos el boton del arreglo de botones en el panel Tablero                
                panelTablero.add(tablero[fila][columna]);
                //redimensionamos el tamaño del tablero de ajedrez conforme al panel
                panelTablero.setLayout(new GridLayout(dimension, dimension));
                //actualizamos el panel
                panelTablero.updateUI();
            }
        }
        
    }
    //clase ActionListener donde se inicia la generacion de lineas
    private class Pieza implements ActionListener{
        //metodo para realizar una accion al momento de hacer click
        @Override
        public void actionPerformed(ActionEvent click) {
            for( int fila = 0 ; fila < dimension ; fila ++ ) {            
                for( int columna = 0 ; columna < dimension ; columna ++ ) {
                    if(click.getSource().equals(tablero[fila][columna])){
                        pos1 = fila;
                        pos2 = columna;                                                            
                        //llamamos al metodo para generar el icono de la pieza y las lineas
                        seleccionPieza();                        
                        //variables para el contador de movimientos                      
                        contador = contador + (contadorAlfil + contadorTorre);
                        movPiezas = Integer.toString(contador);
                        movimientos.setText(movPiezas);
                        datoPunteo = contador -1;
                        punteoFinal = Integer.toString(datoPunteo);
                        punteo();  
                        //agregamos el icono al boton especificado
                        tablero[fila][columna].setIcon(imagenPieza);
                        panelTablero.updateUI();  
                    }
                }
            }
        }     
    }
    //metodo en el cual seleccionamos el icono y a su vez generamos las lineas dependiendo de la pieza
    public Icon seleccionPieza(){
        //objetos para el movimiento de la torre ya inicializados
        abajoTorre = new AbajoTorre(arregloJuego,dimension,pos1,pos2,tablero);
        arribaTorre = new ArribaTorre(arregloJuego,dimension,pos1,pos2,tablero);
        derechaTorre = new DerechaTorre(arregloJuego,dimension,pos1,pos2,tablero);
        izquierdaTorre = new IzquierdaTorre(arregloJuego,dimension,pos1,pos2,tablero);
        //objetos para el movimiento de alfil ya inicializados
        derechaAbajo = new DerechaAbajo(arregloJuego,dimension,pos1,pos2,tablero);
        derechaArriba = new DerechaArriba(arregloJuego,dimension,pos1,pos2,tablero);
        izquierdaAbajo = new IzquierdaAbajo(arregloJuego,dimension,pos1,pos2,tablero);
        izquierdaArriba = new IzquierdaArriba(arregloJuego,dimension,pos1,pos2,tablero);
        //sentencia para elegir el tipo de icono y el movimiento mediante 
        if(cambioIcono.equals(sinSeleccion)){
            vacio();  
        }
        //si es igual a torre realiza los movimientos de torre
        if(cambioIcono.equals(infoTorre)){
            tablero[pos1][pos2].setBackground(Color.CYAN);
            arregloJuego[pos1][pos2] = 0;
            
            torre();   
                abajoTorre.abajoTorre();
                arribaTorre.arribaTorre();
                derechaTorre.derechaTorre();
                izquierdaTorre.izquierdaTorre();
            
        }
        //si es igual a alfil realiza movimientos de alfil
        if(cambioIcono.equals(infoAlfil)){
            tablero[pos1][pos2].setBackground(Color.RED);
            arregloJuego[pos1][pos2] = 0;
            alfil();    
                derechaAbajo.start();
                panelTablero.updateUI();
                derechaArriba.derechaArribaAlfil();
                izquierdaAbajo.izquierdaAbajoAlfil();
                izquierdaArriba.izquierdaArribaAlfil();         
        }
        return imagenPieza;       
    }
    //metodo para generar la imagen de la torre
    public Icon torre(){
        imagen = new ImageIcon(getClass().getResource("/imagenes/Torre.png"));
        imagenPieza = new ImageIcon(imagen.getImage().getScaledInstance(72, 72, Image.SCALE_DEFAULT));
        return imagenPieza;
    }
    //metodo para generar la imagen del alfil
    public Icon alfil(){
        imagen = new ImageIcon(getClass().getResource("/imagenes/Alfil.png"));
        imagenPieza = new ImageIcon(imagen.getImage().getScaledInstance(72, 72, Image.SCALE_DEFAULT));
        return imagenPieza;
    }
    //metodo para generar una imagen vacia cuando no se ha seleccionado nada
    public Icon vacio(){
        imagen = new ImageIcon(getClass().getResource("/imagenes/Nada.png"));
        imagenPieza = new ImageIcon(imagen.getImage().getScaledInstance(72, 72, Image.SCALE_DEFAULT));
        return imagenPieza;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatos = new javax.swing.JPanel();
        infoDimension = new javax.swing.JLabel();
        torre = new javax.swing.JButton();
        alfil = new javax.swing.JButton();
        infoSeleccion = new javax.swing.JLabel();
        movimientos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        informacionPieza = new javax.swing.JLabel();
        jugador = new javax.swing.JLabel();
        nombreJ = new javax.swing.JLabel();
        dimTablero = new javax.swing.JLabel();
        panelScroll = new javax.swing.JScrollPane();
        panelTablero = new javax.swing.JPanel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("  ALFILES Y TORRES");
        setBackground(new java.awt.Color(102, 102, 102));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelDatos.setBackground(new java.awt.Color(102, 102, 102));

        infoDimension.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 14)); // NOI18N
        infoDimension.setForeground(new java.awt.Color(255, 255, 255));
        infoDimension.setText("TAMAÑO DEL TABLERO: ");

        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/Torre.png"));
        Icon icoimagen = new ImageIcon(imagen.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        torre.setIcon(icoimagen);
        torre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                torreActionPerformed(evt);
            }
        });

        ImageIcon alfilImagen = new ImageIcon(getClass().getResource("/imagenes/Alfil.png"));
        Icon iconoAlfil = new ImageIcon(alfilImagen.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        alfil.setIcon(iconoAlfil);
        alfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alfilActionPerformed(evt);
            }
        });

        infoSeleccion.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 14)); // NOI18N
        infoSeleccion.setForeground(new java.awt.Color(255, 255, 255));
        infoSeleccion.setText("PIEZA SELECCIONADA");

        movimientos.setBackground(new java.awt.Color(255, 255, 255));
        movimientos.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 14)); // NOI18N
        movimientos.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MOVIMIENTOS REALIZADOS");

        informacionPieza.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 14)); // NOI18N
        informacionPieza.setForeground(new java.awt.Color(0, 0, 0));

        jugador.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 14)); // NOI18N
        jugador.setForeground(new java.awt.Color(255, 255, 255));
        jugador.setText("JUGADOR :");

        nombreJ.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 14)); // NOI18N
        nombreJ.setForeground(new java.awt.Color(0, 0, 0));

        dimTablero.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 14)); // NOI18N
        dimTablero.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jugador, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(infoDimension))
                .addGap(34, 34, 34)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dimTablero, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreJ, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(torre, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(alfil, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(informacionPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(movimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(infoSeleccion)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jugador, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                            .addComponent(nombreJ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(dimTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(infoDimension, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(infoSeleccion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(movimientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(informacionPieza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(alfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(torre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(panelDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1240, -1));

        panelTablero.setBackground(new java.awt.Color(102, 102, 102));
        panelTablero.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                panelTableroAncestorResized(evt);
            }
        });
        panelTablero.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                panelTableroComponentResized(evt);
            }
        });

        javax.swing.GroupLayout panelTableroLayout = new javax.swing.GroupLayout(panelTablero);
        panelTablero.setLayout(panelTableroLayout);
        panelTableroLayout.setHorizontalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1634, Short.MAX_VALUE)
        );
        panelTableroLayout.setVerticalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
        );

        panelScroll.setViewportView(panelTablero);

        getContentPane().add(panelScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 1240, 770));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoGeneral.jpg"))); // NOI18N
        fondo.setText("jLabel2");
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 890));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelTableroComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelTableroComponentResized
     
    }//GEN-LAST:event_panelTableroComponentResized

    private void panelTableroAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_panelTableroAncestorResized
       
    }//GEN-LAST:event_panelTableroAncestorResized

    private void torreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_torreActionPerformed
        //al presionar este boton seleccina la informacion de torre que es la condicion en el metodo de seleccion de piezas
        informacionPieza.setText(infoTorre);
        cambioIcono = infoTorre;      
        contadorTorre = 1;
        contadorAlfil = 0;
    }//GEN-LAST:event_torreActionPerformed

    private void alfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alfilActionPerformed
        //al presionar este boton seleccina la informacion de alfil que es la condicion en el metodo de seleccion de piezas
        informacionPieza.setText(infoAlfil);
        cambioIcono = infoAlfil;       
        contadorAlfil = 1;
        contadorTorre = 0;
    }//GEN-LAST:event_alfilActionPerformed

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
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alfil;
    public static javax.swing.JLabel dimTablero;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel infoDimension;
    private javax.swing.JLabel infoSeleccion;
    private javax.swing.JLabel informacionPieza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jugador;
    public static javax.swing.JLabel movimientos;
    public static javax.swing.JLabel nombreJ;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JScrollPane panelScroll;
    private javax.swing.JPanel panelTablero;
    private javax.swing.JButton torre;
    // End of variables declaration//GEN-END:variables
}
