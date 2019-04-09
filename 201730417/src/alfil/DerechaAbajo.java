
package alfil;

import java.awt.Color;
import static java.lang.Thread.sleep;
import javax.swing.JButton;
import ventanas.FinJuego;

//clase para realizar el movimiento a la derecha hacia abajo del alfil
public class DerechaAbajo extends Thread{

private long initialTime;
    
    
    int[][] arregloJuego;
    int dimension,pos2,pos1,x;
    private JButton[][] tablero;
    FinJuego fin = new FinJuego();
    
    //contructor que recibe los valores del tablero
    public DerechaAbajo(int[][] arregloJuego, int dimension, int pos1, int pos2, JButton[][] tablero) {
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
    @Override
    public void run(){ 
        //si la posicion 1 es mayor a si mismo y la posicion 2 es mayor a la posicion 1
        int fila,columna;
        fila = pos1+1;
        columna = pos2+1;
        if( fila >= fila && columna >= fila){       
            while(columna < dimension){
                if(arregloJuego[fila][columna] != 1){                                         
                    tablero[fila][columna].setBackground(Color.MAGENTA);
                    ventanaFin();
                }else{
                    tablero[fila][columna].setBackground(Color.red);
                }  
                
                fila++;
                columna++;            
            }
        }else{
            while(fila < dimension){  
                if(arregloJuego[fila][columna] != 1){           
                                  
                    tablero[fila][columna].setBackground(Color.MAGENTA);
                    ventanaFin();
                }else{
                    tablero[fila][columna].setBackground(Color.red);
                }                
                
                fila++;
                columna++;
            }
        }
        try {
            
            sleep(200);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        
    }    
    
}
