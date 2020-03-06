/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionfinancefamilial;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Resultat {
    
      private final SimpleStringProperty revenu;
      private final SimpleStringProperty depense;
      private final SimpleStringProperty reste;
      
         public Resultat(String champ_montant_revenu, String champ_montant, String resultat ){
             this.revenu = new SimpleStringProperty(champ_montant_revenu);
             this.depense = new SimpleStringProperty(champ_montant);
             this.reste = new SimpleStringProperty(resultat);
         }

   

    public String getRevenu() {
        return revenu.get();
    }

    public String getDepense() {
        return depense.get();
    }

    public String getReste() {
        return reste.get();
    }
         
         
}
