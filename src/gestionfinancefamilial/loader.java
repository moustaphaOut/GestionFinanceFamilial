/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionfinancefamilial;

/**
 *
 * @author user
 */
class loader {
  
   private static String nom1;
    private static String prenom1;
 
public loader (String nom1, String prenom1){
    this.nom1 = nom1;
    this.prenom1 = prenom1;
}
    public static String getNom1() {
        return nom1;
    }

    public static String getPrenom1() {
        return prenom1;
    }

    public static void setNom1(String nom1) {
        loader.nom1 = nom1;
    }

    public static void setPrenom1(String prenom1) {
        loader.prenom1 = prenom1;
    }



  
    
    
    
}
