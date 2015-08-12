/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpablo.keys;

/**
 *
 * @author JP
 */
public class PalabrasBusqueda {
   private String word;
   
   public PalabrasBusqueda(){
       this.word="";
   }
   
   public PalabrasBusqueda(String word){
       this.word = word;
   }
   
   public void setWord(String word){
       this.word = word;
   }
   
   public String getWord(){
       return word;
   }
}