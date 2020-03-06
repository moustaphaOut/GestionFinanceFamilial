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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLfinanceController implements Initializable {

    @FXML
    private AnchorPane finance;

    @FXML
    private Button enregistrer2;

    @FXML
    private Button retour;

    @FXML
    private Spinner<Integer> annee;
    @FXML
    private TableView<Finanse46> tableview;
    @FXML
    private TableColumn<Finanse46, String> teble_type_depense;
    @FXML
    private TableColumn<Finanse46, String> table_type_revenu_montant;
    @FXML
    private ComboBox<String> mois;
    @FXML
    private ComboBox<String> champ_type_revenu;
    @FXML
    private TextField champ_montant_revenu;
    @FXML
    private Button actualiser;

     public static Double g, x;
    Double t = 0.0;

    ObservableList<String> liste1 = FXCollections.observableArrayList(
            "Javier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre",
            "Octobre", "Novembre", "Decembre"
    );

    ObservableList<String> liste3 = FXCollections.observableArrayList(
            "Salaire_mensuel", "Immobilier", "Affaire"
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mois.setItems(liste1);
        champ_type_revenu.setItems(liste3);

        SpinnerValueFactory<Integer> gradeValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 3000, 2018);
        this.annee.setValueFactory(gradeValue);
        annee.setEditable(true);

    }

    @FXML
    private void enregistrer2(ActionEvent event) throws IOException {
        /*
        try {
            // Creation du fichier

            BufferedWriter fichier2 = new BufferedWriter(new FileWriter("Data_finance.txt", true));

            fichier2.write(mois.getValue());
            fichier2.write(";;" + annee.getValue());
            fichier2.write(";;" + champ_type_revenu.getValue());
            fichier2.write(";;" + champ_montant_revenu.getText());

            // quoiqu'il arrive, on ferme le fichier
            fichier2.newLine();
            fichier2.close();
            
           BufferedWriter temp = new BufferedWriter(new FileWriter("donneClient.txt", true));

            temp.write(";;"+mois.getValue()+";;"+annee.getValue()+";;"+champ_type_revenu.getValue()+";;"+champ_montant_revenu.getText());
            temp.newLine();
            temp.close();
        } catch (Exception e) {
            System.out.println("Impossible de creer le fichier");
        }  */
 /*
        x = Double.parseDouble(champ_montant_revenu.getText());

        g = x + t;
        t = g;
      
           File file4 = new File("test3.txt");
       Scanner sc4 = null;
      
       String valeur;
       String s4 = "";
       
       try{
          
           sc4 = new Scanner(file4);
           while(sc4.hasNext()){
              s4 += (sc4.nextLine()+"\n");
           
           }
     Finance.setFinance_nom_revenu(s4);
       }catch(FileNotFoundException ex){
           JOptionPane.showMessageDialog(null, "ERROR 404 ");
       }
          

        String m = String.valueOf(g);
        Finance.setFinance_montant_revenu1(m);
        Finance.setFinance_mois(mois.getValue());
        Finance.setFinance_annee(annee.getValue());
         Finance.setFinance_nom_revenu(champ_type_revenu.getValue());  */

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDepence.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void suivant(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDepence.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void actualiser5(ActionEvent eventA) throws IOException {

        try {
            // Creation du fichier

            BufferedWriter fichier2 = new BufferedWriter(new FileWriter("Data_finance.txt", true));

            fichier2.write(mois.getValue());
            fichier2.write(";;" + annee.getValue());
            fichier2.write(";;" + champ_type_revenu.getValue());
            fichier2.write(";;" + champ_montant_revenu.getText());

            // quoiqu'il arrive, on ferme le fichier
            fichier2.newLine();
            fichier2.close();
        } catch (Exception e) {
            System.out.println("Impossible de creer le fichier");
        }

        teble_type_depense.setCellValueFactory(new PropertyValueFactory<Finanse46, String>("revenu_nom"));
        table_type_revenu_montant.setCellValueFactory(new PropertyValueFactory<Finanse46, String>("revenu_montant"));
        GestionFinanceFamilial.liste4.add(new Finanse46(annee.getValue(), mois.getValue(), champ_type_revenu.getValue(), champ_montant_revenu.getText()));
        tableview.setItems(GestionFinanceFamilial.liste4);

        x = Double.parseDouble(champ_montant_revenu.getText());

        g = x + t;
        t = g;

        String m = String.valueOf(g);
        Finance.setFinance_montant_revenu1(m);
        Finance.setFinance_mois(mois.getValue());
        Finance.setFinance_nom_revenu(champ_type_revenu.getValue());
        Finance.setFinance_annee(annee.getValue());

    }

}
