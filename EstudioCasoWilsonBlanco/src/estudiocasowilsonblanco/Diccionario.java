/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudiocasowilsonblanco;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author wilsonblanco
 */
public class Diccionario implements Serializable {

    private ArrayList<Termino> terminos;

    public Diccionario(ArrayList<Termino> terminos) {
        this.terminos = new ArrayList<Termino>(terminos);
    }

    public Diccionario() {
        
    }
    

    public ArrayList<Termino> getTerminos() {
        return terminos;
    }

    public void setTerminos(ArrayList<Termino> terminos) {
        this.terminos = terminos;
    }

    public void ordenarAlfabeticamente() {
        for (int i = 0; i < terminos.size() - 1; i++) {
            for (int j = 0; j < terminos.size() - i - 1; j++) {
                if (terminos.get(j).getPalabra().compareTo(terminos.get(j + 1).getPalabra()) > 0) {
                    Termino temp = terminos.get(j);
                    terminos.set(j, terminos.get(j + 1));
                    terminos.set(j + 1, temp);
                }
            }
        }
    } // Orden metodo burbuja. 
    public String buscarPalabra(String palabra){
        boolean buscador = false;
        for(int i = 0; i < terminos.size(); i++){
            if(palabra.equals(terminos.get(i).getPalabra())){
                buscador = true;
                return terminos.get(i).getConcepto();
                
            }
        
        }
        if(!buscador){
            return "No se ha encontrado ninguna palabra";
        }
        return "";
    }
}
