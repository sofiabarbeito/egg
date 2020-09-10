
package libreria;

import libreria.interfaz.InterfazLibreria;

public class Libreria {

    public static void main(String[] args) {
        
        InterfazLibreria interfaz = new InterfazLibreria();
        while(true){
            interfaz.menu();
        }
    }
    
}
