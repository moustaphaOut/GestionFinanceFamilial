/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionfinancefamilial;

public class Finance {

    private static String finance_nom_revenu;
    private static String finance_montant_revenu1;
    private static String finance_mois;
    private static Integer finance_annee;

    public static String getFinance_nom_revenu() {
        return finance_nom_revenu;
    }

    public static String getFinance_montant_revenu1() {
        return finance_montant_revenu1;
    }

    public static void setFinance_nom_revenu(String finance_revenu) {
        Finance.finance_nom_revenu = finance_revenu;
    }

    public static void setFinance_montant_revenu1(String finance_autre_revenu) {
        Finance.finance_montant_revenu1 = finance_autre_revenu;
    }

    public static String getFinance_mois() {
        return finance_mois;
    }

    public static void setFinance_mois(String finance_mois) {
        Finance.finance_mois = finance_mois;
    }

    public static Integer getFinance_annee() {
        return finance_annee;
    }

    public static void setFinance_annee(Integer finance_annee) {
        Finance.finance_annee = finance_annee;
    }

}
