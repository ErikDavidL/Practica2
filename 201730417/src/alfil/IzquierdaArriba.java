
package alfil;
    
import java.awt.Color;
import javax.swing.JButton;
import ventanas.FinJuego;

//clase para realizar el movimiento a la dizqueirda hacia arriba del alfil
public class IzquierdaArriba {
    
    int[][] arregloJuego;
    int dimension,pos2,pos1;
    private JButton[][] tablero;
    FinJuego fin = new FinJuego();

    //contructor que recibe los valores del tablero
    public IzquierdaArriba(int[][] arregloJuego, int dimension, int pos1, int pos2, JButton[][] tablero) {
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
    public void izquierdaArribaAlfil(){   
        int fila,columna;
        fila = pos1;
        columna = pos2;
        fila--;
        columna--;
        if( fila >= fila && columna >= fila){
             while(fila >= 0){     //este es para la diagonal que va hacia arriba para la izquierda
                if(arregloJuego[fila][columna] != 1){           
                                
                    tablero[fila][columna].setBackground(Color.MAGENTA);
                    ventanaFin();
                }else{
                    tablero[fila][columna].setBackground(Color.red);
                }
                fila--;
                columna--;
            }
         }else{         
            while(columna >= 0){     //este es para la diagonal que va hacia arriba para la izquierda
                if(arregloJuego[fila][columna] != 1){           
                                   
                    tablero[fila][columna].setBackground(Color.MAGENTA);
                    ventanaFin();
                }else{
                    tablero[fila][columna].setBackground(Color.red);
                }                
                fila--;
                columna--;
            }
         }    
    }
}
