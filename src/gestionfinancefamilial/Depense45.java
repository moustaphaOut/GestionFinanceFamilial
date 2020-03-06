/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionfinancefamilial;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Depense45 {
   private final SimpleIntegerProperty depense_annee;
    private final SimpleStringProperty depense_mois;
    private final SimpleStringProperty depense_nom;
    private final SimpleStringProperty depense_montant;
  

   public Depense45(int annee2, String depense_mois, String depense_nom, String depense_montant ){
        this.depense_annee = new SimpleIntegerProperty(annee2);
        this.depense_mois = new SimpleStringProperty (depense_mois);
        this.depense_nom = new SimpleStringProperty (depense_nom);
        this.depense_montant = new SimpleStringProperty (depense_montant);
        
    }

    public int getDepense_annee() {
        return depense_annee.get();
    }

    public String getDepense_mois() {
        return depense_mois.get();
    }

    public String getDepense_nom() {
        return depense_nom.get();
    }

    public String getDepense_montant() {
        return depense_montant.get();
    }

    

    
}
