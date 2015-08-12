/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpablo.runners;

import java.io.*;

import com.jpablo.test.NavigateWikipedia;
import com.jpablo.keys.PalabrasBusqueda;

/**
 *
 * @author JP
 */
public class WebRunner {
    
    public void searchOnWikipedia(){
        try{
            BufferedReader tecla = 
               new BufferedReader(new InputStreamReader(System.in));
            BufferedReader keyword = 
               new BufferedReader(new InputStreamReader(System.in));
            NavigateWikipedia nw = new NavigateWikipedia();
            try{
                do{
                    System.out.println("Busqueda automatizada de Wikipedia");
                    System.out.println("1. Busqueda de una palabra");
                    System.out.println("2. Busqueda de dos palabras");
                    System.out.println("3. Abrir Wikipedia en Mozilla Firefox");
                    System.out.println("4. Abrir Wikipedia en Internet Explorer");
                    System.out.println("5. Abrir Wikipedia en Chrome");
                    System.out.println("6. Uso Autosuggest en Firefox");
                    System.out.println("7. Uso Autosuggest en Firefox de un elemento");
                    System.out.println("8. Salir");

                    switch(Integer.parseInt(tecla.readLine())){
                        case 1:System.out.println("Busqueda de una palabra en Wikipedia");
                            PalabrasBusqueda word = new PalabrasBusqueda();
                            word.setWord(keyword.readLine());
                            nw.doSearchWikiENFF(word.getWord());
                            break;
                        case 2:System.out.println("Busqueda de dos palabras en Wikipedia");
                            PalabrasBusqueda word1 = new PalabrasBusqueda();
                            PalabrasBusqueda word2 = new PalabrasBusqueda();
                            System.out.println("Primera palabra");
                            word1.setWord(keyword.readLine());
                            System.out.println("Segunda palabra");
                            word2.setWord(keyword.readLine());
                            nw.doAnotherSearchFF(word1.getWord(),word2.getWord());
                            break;
                        case 3:
                            System.out.println("Abre Wikipedia en Mozilla");
                            nw.openWikiEnglishFirefox();
                            break;
                        case 4:
                            System.out.println("Abre Wikipedia en IE");
                            nw.openWikiEnglishIE();
                            break;
                        case 5:
                            System.out.println("Abre Wikipedia en Chrome");
                            nw.openWikiEnglishChrome();
                            break;
                        case 6:
                            PalabrasBusqueda pl = new PalabrasBusqueda();
                            System.out.println("Autosugerencias");
                            pl.setWord(keyword.readLine());
                            nw.doSearchAutoSuggest(pl.getWord());
                            break;
                        case 7:
                            PalabrasBusqueda pl1 = new PalabrasBusqueda();
                            System.out.println("Autosugerencias, elemento seleccionado");
                            pl1.setWord(keyword.readLine());
                            nw.doSearchAutoSuggestIndex(pl1.getWord());
                            break;
                        case 8:
                            System.out.println("Adios!!!");
                            break;
                        default:
                            break;
                    }
                }while(Integer.parseInt(tecla.readLine())!=8);
            }
            catch(IOException ioe){}
        }
        catch(InterruptedException ie){}
    }
    
    public static void main(String[] args){
        WebRunner wr = new WebRunner();
        wr.searchOnWikipedia();
    }
}