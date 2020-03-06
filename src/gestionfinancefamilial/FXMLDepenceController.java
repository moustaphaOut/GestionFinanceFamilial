/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionfinancefamilial;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLDepenceController implements Initializable {

    @FXML
    private Button Enregistrer3;

    @FXML
    private Button retour2;
    @FXML
    private TextField champ_montant;
    @FXML
    private ComboBox<String> combobox1;
    public static Double d;
    Double k = 0.0;
    String monnaie = "$";

    ObservableList<String> listetatcivil = FXCollections.observableArrayList(
            "Transport et divertissement",
            "Loyer",
            "Nourriture",
            "Habillement",
            "Facture eau",
            "Facture électricité"
    );
    @FXML
    private Label label12;

    String[][] Tableau = new String[15][15];
    @FXML
    private TableView<Depense45> tableview2;
    @FXML
    private TableColumn<Depense45, String> type_de_depense;
    @FXML
    private TableColumn<Depense45, String> type_de_depense_montat;
    @FXML
    private Button actu;

    ObservableList<String> liste11 = FXCollections.observableArrayList(
            "Javier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre",
            "Octobre", "Novembre", "Decembre"
    );
   
    @FXML
    private ComboBox<String> mois2;
    @FXML
    private Spinner<Integer> annee2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        combobox1.setItems(listetatcivil);
        mois2.setItems(liste11);
        SpinnerValueFactory<Integer> Value3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 3000, 2018);
        this.annee2.setValueFactory(Value3);
        annee2.setEditable(true);
    }

    @FXML
    private void Enregistrer3(ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("FXMLReponce.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void retour2(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLfinance.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private void actu6(ActionEvent event) {
        
                try {

            // quoiqu'il arrive, on ferme le fichier
            BufferedWriter bf = new BufferedWriter(new FileWriter("Data_depense.txt", true));
            bf.write(mois2.getValue());
            bf.write(";;" + annee2.getValue());
            bf.write(";;" + combobox1.getValue());
            bf.write(";;" + champ_montant.getText());            
            // quoiqu'il arrive, on ferme le fichier
            bf.newLine();
            bf.close();
            
        } catch (Exception e) {
            System.out.println("Impossible de creer le fichier");
        }

        type_de_depense.setCellValueFactory(new PropertyValueFactory<Depense45, String>("depense_nom"));
        type_de_depense_montat.setCellValueFactory(new PropertyValueFactory<Depense45, String>("depense_montant"));
        GestionFinanceFamilial.liste6.add(new Depense45(annee2.getValue(), mois2.getValue(), combobox1.getValue(), champ_montant.getText()));
        tableview2.setItems(GestionFinanceFamilial.liste6);

        d = Double.parseDouble(champ_montant.getText());
        d = k + d;
        k = d;

        String v = String.valueOf(d);
        Depense1.setDepense_montant_revenu1(v);
        Depense1.setDepense_nom_revenu1(combobox1.getValue());
        Depense1.setDepense_mois1(mois2.getValue());
        Depense1.setDepense_annee1(annee2.getValue());

    }

}
