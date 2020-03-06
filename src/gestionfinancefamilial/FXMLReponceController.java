package gestionfinancefamilial;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLReponceController implements Initializable {

    @FXML
    private Label label0;

    @FXML
    private Button retour;
    @FXML
    private Button resultat;
    @FXML
    private Button enresgistrer;

    Map data = new HashMap<String, Finanse46>();
    @FXML
    private Label label_prenom;
    @FXML
    private Label label_nom;

    String[][] Tableau = new String[100][10];

    String som1 = "";
    String som2 = Finance.getFinance_nom_revenu();
    public static Double x, y, z, s;
    Integer an;

    @FXML
    private Button revenu23;
    @FXML
    private Button depense23;
    @FXML
    private AnchorPane anchorpane_revenu;

    @FXML
    private AnchorPane anchorpane_depense1;
    @FXML
    private AnchorPane anchorpane_total_resultat;
    @FXML
    private Button cache1;
    @FXML
    private Button cache2;
    @FXML
    private Button cache3;

   
    @FXML
    private TableView<Finanse46> tableau_Revenu;
    @FXML
    private TableColumn<Finanse46, Integer> revenu_annee;
    @FXML
    private TableColumn<Finanse46, String> revenu_mois;
    @FXML
    private TableColumn<Finanse46, String> revenu_nom;
    @FXML
    private TableColumn<Finanse46, String> revenu_montant;
    @FXML
    private TableView<Depense45> tableau_Depense;
    @FXML
    private TableColumn<Depense45, Integer> depense_annee;
    @FXML
    private TableColumn<Depense45, String> depense_mois;
    @FXML
    private TableColumn<Depense45, String> depense_nom;
    @FXML
    private TableColumn<Depense45, String> depense_montant;
    @FXML
    private TableView<Resultat> Resultat;
    @FXML
    private TableColumn<Resultat, String> resultat_revenu;
    @FXML
    private TableColumn<Resultat, String> resutat_depense;
    @FXML
    private TableColumn<Resultat, String> resultat_reste;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        label_nom.setText(loader.getNom1());
        label_prenom.setText(loader.getPrenom1());
        
        revenu_annee.setCellValueFactory(new PropertyValueFactory<Finanse46, Integer>("revenu_annee"));
        revenu_mois.setCellValueFactory(new PropertyValueFactory<Finanse46, String>("revenu_mois"));
        revenu_nom.setCellValueFactory(new PropertyValueFactory<Finanse46, String>("revenu_nom"));
        revenu_montant.setCellValueFactory(new PropertyValueFactory<Finanse46, String>("revenu_montant"));
        tableau_Revenu.setItems(GestionFinanceFamilial.liste4);
        
        depense_annee.setCellValueFactory(new PropertyValueFactory<Depense45, Integer>("depense_annee"));
        depense_mois.setCellValueFactory(new PropertyValueFactory<Depense45, String>("depense_mois"));
        depense_nom.setCellValueFactory(new PropertyValueFactory<Depense45, String>("depense_nom"));
        depense_montant.setCellValueFactory(new PropertyValueFactory<Depense45, String>("depense_montant"));
        tableau_Depense.setItems(GestionFinanceFamilial.liste6);
        
        resultat_revenu.setCellValueFactory(new PropertyValueFactory<Resultat, String>("revenu"));
        resutat_depense.setCellValueFactory(new PropertyValueFactory<Resultat, String>("depenes"));
        resultat_reste.setCellValueFactory(new PropertyValueFactory<Resultat, String>("reste"));
        
              y = Double.parseDouble(Finance.getFinance_montant_revenu1());
        z = Double.parseDouble(Depense1.getDepense_montant_revenu1());
       s = y - z ;
     String res = String.valueOf(s);
      String depense = Depense1.getDepense_montant_revenu1();
         GestionFinanceFamilial.liste8.add(new Resultat(Finance.getFinance_montant_revenu1() ,depense, res));
  
        Resultat.setItems(GestionFinanceFamilial.liste8);

        

    }

    @FXML
    private void retour(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDepence.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void resultat(ActionEvent event) throws IOException {

        anchorpane_total_resultat.setVisible(true);
    }

    @FXML
    private void enresgistrer(ActionEvent event) throws IOException {

    }

    @FXML
    private void revenuu23(ActionEvent event) throws IOException {
        anchorpane_revenu.setVisible(true);

    }

    @FXML
    private void depensee23(ActionEvent event) throws IOException {
        anchorpane_depense1.setVisible(true);
    }

    @FXML
    private void cachee1(ActionEvent event) {
        anchorpane_revenu.setVisible(false);
    }

    @FXML
    private void cachee2(ActionEvent event) {
        anchorpane_depense1.setVisible(false);
    }

    @FXML
    private void cachee3(ActionEvent event) {
        anchorpane_total_resultat.setVisible(false);
    }

}
