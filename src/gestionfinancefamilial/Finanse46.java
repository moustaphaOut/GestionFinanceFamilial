
package gestionfinancefamilial;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Finanse46 {
     private final SimpleIntegerProperty revenu_annee;
    private final SimpleStringProperty revenu_mois;
    private final SimpleStringProperty revenu_nom;
    private final SimpleStringProperty revenu_montant;
    
    public Finanse46(int annee, String revenu_mois, String revenu_nom, String revenu_montant ){
        this.revenu_annee = new SimpleIntegerProperty(annee);
        this.revenu_mois = new SimpleStringProperty (revenu_mois);
        this.revenu_nom = new SimpleStringProperty (revenu_nom);
        this.revenu_montant = new SimpleStringProperty (revenu_montant);
        
    }

    public int getRevenu_annee() {
        return revenu_annee.get();
    }

    public String getRevenu_mois() {
        return revenu_mois.get();
    }

    public String getRevenu_nom() {
        return revenu_nom.get();
    }

    public String getRevenu_montant() {
        return revenu_montant.get();
    }


    
}
