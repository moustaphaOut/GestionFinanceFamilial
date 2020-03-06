/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionfinancefamilial;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private Button enregistrer1;
    @FXML
    private TextField espace_nom;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label enfant;
    @FXML
    private Label sexe;
    @FXML
    private Label age;
    @FXML
    private TextField espace_prenom;
    @FXML
    private DatePicker espace_age;
    @FXML
    private Label etat;
    @FXML
    private TextField espace_enfant;

    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private ComboBox<String> choix_sexe;
    @FXML
    private ComboBox<String> choix_etat_civil;

    String Nom;
    String Prenom;
    LocalDate DatedeNaissance;
    String etat_civil;
    String sex;
    String nombre_enfant;

    ObservableList<String> listetatcivil = FXCollections.observableArrayList(
            "Marié",
            "Celibataire"
    );

    ObservableList<String> list_sex = FXCollections.observableArrayList(
            "Homme",
            "Femme"
    );
    @FXML
    private Button connexion;
    @FXML
    private TextField nom_connexion;
    @FXML
    private TextField prenom_connexion;
    @FXML
    private Button connexion2;
    @FXML
    private AnchorPane connexion_anchorpane;
    @FXML
    private Label nom_incorrect;
    @FXML
    private Label prenom_incorrect;

    String[][] Tableau1 = new String[100][15];
    String[][] Tableau2 = new String[100][15];
    @FXML
    private Button annule;
    @FXML
    private Button passer;
    @FXML
    private AnchorPane anchorpane5;
    @FXML
    private Button enregistrer5;
    @FXML
    private Button annule5;
    @FXML
    private Button modifier5;
    File dataClient = new File("DonneClient.txt");

    private ArrayList<Personne> personnelist = new ArrayList<Personne>();
    HashMap<String, String> accounts = new HashMap();
    
    public void loadAccount() {
        File file = new File("account.txt");
        Scanner sc = null;

        try {

            sc = new Scanner(file);
            while (sc.hasNext()) {
                String s = sc.nextLine();
                String[] compte = s.split(";");
                accounts.put(compte[0], compte[1]);

            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 404 ");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //    loadAccount();

                File file = new File("account.txt");
        Scanner sc = null;

        try {

            sc = new Scanner(file);
            while (sc.hasNext()) {
                String s = sc.nextLine();
                String[] compte = s.split(";");
                //accounts.put(compte[0], compte[1]);
             accounts.get(compte[0]);
          
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 404 ");
        }
        
        choix_etat_civil.setItems(listetatcivil);

        choix_sexe.setItems(list_sex);

    }

    @FXML
    private void enregistrer1(ActionEvent event) throws IOException, FileNotFoundException {
        Personne p1 = new Personne(espace_nom.getText(), espace_prenom.getText(), espace_age.getValue().toString(), choix_etat_civil.getValue(), choix_sexe.getValue(), espace_enfant.getText());

        BufferedWriter fichier2 = new BufferedWriter(new FileWriter("account.txt", true));
        fichier2.write(espace_nom.getText() + ";" + espace_prenom.getText());

        fichier2.newLine();
        fichier2.close();

        
        BufferedWriter temp = new BufferedWriter(new FileWriter("donneClient.txt", true));
        temp.write(espace_nom.getText() + ";;" + espace_prenom.getText() + ";;" + espace_age.getValue().toString() + ";;" + choix_etat_civil.getValue() + ";;" + choix_sexe.getValue() + ";;" + espace_enfant.getText());

        temp.newLine();
        temp.close();
        
        personnelist.add(p1);

        FileOutputStream fos = new FileOutputStream("test1.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(personnelist.toString());

        oos.close();
        fos.close();
        
           loader.setNom1(espace_nom.getText());
            loader.setPrenom1(espace_prenom.getText());
           

        Parent root = FXMLLoader.load(getClass().getResource("FXMLfinance.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
 
    }

    private void suivant(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLfinacnce.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }


    @FXML
    private void connexion(ActionEvent event) {
        connexion_anchorpane.setVisible(true);

    }

    @FXML
    private void connexion2(ActionEvent event) throws IOException, ClassNotFoundException {
        
        if (!accounts.keySet().equals(nom_connexion.getText())) {
//||accounts.getKey(prenom_connexion.getText()).equals(prenom_connexion.getText(nom_connexion.getText()))
           anchorpane5.setVisible(true);
        
            loader.setNom1(nom_connexion.getText());
            loader.setPrenom1(prenom_connexion.getText());
        } else {
            System.out.println(accounts.keySet());
            nom_incorrect.setText("nom_incorrect");
            prenom_incorrect.setText("prenom_incorrect");
        }
 // if (accounts.get(nom_connexion.getText()).equals(prenom_connexion.getText())) 
        /* FileInputStream fis = new FileInputStream("test1.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Personne> pi = (ArrayList<Personne>) ois.readObject();

        for (int ic = 0; ic < pi.size(); ic++) {

            if (pi.get(ic).getNom().equals(nom_connexion.getText()) && pi.get(ic).getPrenom().equals(prenom_connexion.getText())) {
                JOptionPane.showMessageDialog(null, "valide");
                anchorpane5.setVisible(true);
                break;
            } else {
                String ben = pi.get(ic).getNom();
                System.out.printf(ben);
                nom_incorrect.setText("nom_incorrect");
                prenom_incorrect.setText("prenom_incorrect");
            }

        }*/
    }

    @FXML
    private void annule(ActionEvent event) {

        connexion_anchorpane.setVisible(false);
    }

    @FXML
    private void passer(ActionEvent event) {

        anchorpane5.setVisible(true);
    }

    @FXML
    private void enregistrerr5(ActionEvent event) {
    }

    @FXML
    private void annulee5(ActionEvent event) {
        anchorpane5.setVisible(false);
        connexion_anchorpane.setVisible(false);
    }

    @FXML
    private void modifierr5(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLfinance.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

}
