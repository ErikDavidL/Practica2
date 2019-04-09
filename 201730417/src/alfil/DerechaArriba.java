
package alfil;

import java.awt.Color;
import javax.swing.JButton;
import ventanas.FinJuego;

//clase para realizar el movimiento a la derecha hacia arriba del alfil
public class DerechaArriba {
 
    int[][] arregloJuego;
    int dimension,pos2,pos1;
    private JButton[][] tablero;
    FinJuego fin = new FinJuego();

    //contructor que recibe los valores del tablero
    public DerechaArriba(int[][] arregloJuego, int dimension, int pos1, int pos2, JButton[][] tablero) {
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
    public void derechaArribaAlfil(){   
        int fila,columna;
        fila = pos1;
        columna = pos2;
        fila--;
        columna++;
        int y;
        y = dimension - pos2;
            if(fila >= y-1){
                for (int i = columna; i< dimension; i++) {        //parte de arriba
                    if(arregloJuego[i][columna] != 1){                                                   
                        tablero[fila][i].setBackground(Color.MAGENTA);
                        ventanaFin();
                    }else{
                        tablero[fila][i].setBackground(Color.red);
                    }
                    //tablero[fila][i].setBackground(Color.red);
                    fila--;
                } 
            }
            else{
                for (int i = fila; i>= 0; i--){   // parte de abajo
                    if(arregloJuego[i][columna] != 1){                                                   
                        tablero[i][columna].setBackground(Color.MAGENTA);
                        ventanaFin();
                    }else{
                        tablero[i][columna].setBackground(Color.red);
                    }
                    //tablero[i][columna].setBackground(Color.red);
                    columna++;
                }
                
            }         
    }
}
