
package torre;

import java.awt.Color;


import javax.swing.JButton;

import ventanas.FinJuego;

//clase para realizar el movimiento hacia la derecha de la torre
public class DerechaTorre {   
    
    int[][] arregloJuego;
    int dimension,pos2,pos1;
    private JButton[][] tablero;
    FinJuego fin = new FinJuego();

    //contructor que recibe los valores del tablero
    public DerechaTorre(int[][] arregloJuego, int dimension, int pos1, int pos2, JButton[][] tablero) {
        this.arregloJuego = arregloJuego;
        this.dimension = dimension;
        this.pos2 = pos2;
        this.pos1 = pos1;
        this.tablero = tablero;
    }
    //metodo para llamar a la ventana fin del juego
    public void ventanaFin(){
        
        fin.setVisible(true);
        //this.dispose();
    }
    
    //metodo para generar las lineas 
    public void derechaTorre(){
        
        for(int x = pos2+1; x < dimension ; x ++){   
            
            if(arregloJuego[pos1][x] != 1){                             
                tablero[pos1][x].setBackground(Color.MAGENTA);
                
                ventanaFin();                
            }else{
                tablero[pos1][x].setBackground(Color.CYAN);
            tablero[pos1][x].repaint();    
            }
            tablero[pos1][x].updateUI();
        }        
            
        
        
    }

   
}
