import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;
import java.awt.Desktop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    List<Integer> kockice = new ArrayList<Integer>();
    private Integer k;
    Random rand = new Random();
    polje p = new polje();
    
    // private boolean brojacDrugiKrug = true; // nije potreban
    private Integer clicked1 = 0;
    private Integer clicked2 = 0;
    private Integer clicked3 = 0;
    private Integer clicked4 = 0;
    private Integer clicked5 = 0;
    private Integer clicked6 = 0;
    private Boolean checkPrvaKockica = false;
    private Boolean checkDrugaKockica = false;
    private Boolean checkTrecaKockica = false;
    private Boolean checkCetvrtaKockica = false;
    private Boolean checkPetaKockica = false;
    private Boolean checkSestaKockica = false;

    // provera za novi krug
    private boolean pressNewTurn = false;

    // provera da se ne moze vise vrednosti upisati u jednom krugu
    private boolean writeNewField = true;

    //provera da mozemo maksimalno 3 puta da bacimo kockice po krugu
    private Integer brojacBacanja = 0;

    // roll dugme
    @FXML
    private Button roll;

    // new turn dugme
    @FXML
    private Button newTurnBtn;

    // donja kolona
    // jedinice
    @FXML
    private Button jediniceDole;
    private boolean checkJediniceDole = false;
    private Integer jediniceDoleBroj;

    // dvojke
    @FXML
    private Button dvojkeDole;
    private boolean checkDvojkeDole = false;
    private Integer dvojkeDoleBroj;
    // trojke

    @FXML
    private Button trojkeDole;
    private boolean checkTrojkeDole = false;
    private Integer trojkeDoleBroj;
    // cetvorke
    @FXML
    private Button cetvorkeDole;
    private boolean checkCetvorkeDole = false;
    private Integer cetvorkeDoleBroj;
    // petice
    @FXML
    private Button peticeDole;
    private boolean checkPeticeDole = false;
    private Integer peticeDoleBroj;
    // sestice
    @FXML
    private Button sesticeDole;
    private boolean checkSesticeDole = false;
    private Integer sesticeDoleBroj;
    // max
    @FXML
    private Button maxDole;
    private boolean checkMaxDole = false;
    private Integer maxDoleBroj = 0;
    // min
    @FXML
    private Button minDole;
    private Boolean checkMinDole = false;
    private Integer minDoleBroj = 0;
    // kenta
    @FXML
    private Button kentaDole;
    private boolean checkKentaDole = false;
    private Integer kentaDoleBroj;
    // full
    @FXML
    private Button fullDole;
    private boolean checkFullDole = false;
    private Integer fullDoleBroj;
    // poker
    @FXML
    private Button pokerDole;
    private Boolean checkPokerDole = false;
    private Integer pokerDoleBroj;
    // yamb
    @FXML
    private Button yambDole;
    private boolean checkYambDole = false;
    private Integer yambDoleBroj;

    // najava kolona
    @FXML
    private Button najava;
    private boolean najavljeno = false;
    private Integer n = 1;

    // jedinice

    @FXML
    private Button cetvorkeGore;
    private boolean checkCetvorkeGore = false;
    private Integer cetvorkeGoreBroj;

    @FXML
    private Button cetvorkeNajava;
    private boolean checkCetvorkeNajava = false;
    private Integer cetvorkeNajavaBroj;
    @FXML
    private Button cetvorkeRucna;
    private boolean checkCetvorkeRucna = false;
    private Integer cetvorkeRucnaBroj;

    @FXML
    private Button cetvorkeSlobodna;
    private boolean checkCetvorkeSlobodna = false;
    private Integer cetvorkeSlobodnaBroj;

    @FXML
    private Button dvojkeGore;
    private boolean checkDvojkeGore = false;
    private Integer dvojkeGoreBroj;

    @FXML
    private Button dvojkeNavaja;
    private boolean checkDvojkeNajava = false;
    private Integer dvojkeNajavaBroj;

    @FXML
    private Button dvojkeRucna;
    private boolean checkDvojkeRucna = false;
    private Integer dvojkeRucnaBroj;

    @FXML
    private Button dvojkeSlobodna;
    private boolean checkDvojkeSlobodna = false;
    private Integer dvojkeSlobodnaBroj;

    @FXML
    private Button fullGore;
    private boolean checkFullGore = false;
    private Integer fullGoreBroj;

    @FXML
    private Button fullNajava;
    private boolean checkFullNajava = false;
    private Integer fullNajavaBroj;

    @FXML
    private Button fullRucna;
    private boolean checkFullRucna = false;
    private Integer fullRucnaBroj;

    @FXML
    private Button fullSlobodna;
    private boolean checkFullSlobodna = false;
    private Integer fullSlobodnaBroj;

    @FXML
    private Button jediniceGore;
    private boolean checkJediniceGore = false;
    private Integer jediniceGoreBroj;

    @FXML
    private Button jediniceNajava;
    private boolean checkJediniceNajava = false;
    private Integer jediniceNajavaBroj;

    @FXML
    private Button jediniceRucna;
    private boolean checkJedinicRucna = false;
    private Integer jediniceRucnaBroj;

    @FXML
    private Button jediniceSlobodna;
    private boolean checkJediniceSlobodna = false;
    private Integer jediniceSlobodnaBroj;

    @FXML
    private Button kentaGore;
    private boolean checkKentaGore = false;
    private Integer kentaGoreBroj;

    @FXML
    private Button kentaNajava;
    private boolean checkKentaNajava = false;
    private Integer kentaNajavaBroj;

    @FXML
    private Button kentaRucna;
    private boolean checkKentaRucna = false;
    private Integer kentaRucnaBroj;

    @FXML
    private Button kentaSlobodna;
    private boolean checkKentaSlobodna = false;
    private Integer kentaSlobodnaBroj;

    @FXML
    private Button maxGore;
    private boolean checkMaxGore = false;
    private Integer maxGoreBroj = 0;

    @FXML
    private Button maxNajava;
    private boolean checkMaxNajava = false;
    private Integer maxNajavaBroj = 0;

    @FXML
    private Button maxRucna;
    private boolean checkMaxRucna = false;
    private Integer maxRucnaBroj = 0;

    @FXML
    private Button maxSlobodna;
    private boolean checkMaxSlobodna = false;
    private Integer maxSlobodnaBroj = 0;

    @FXML
    private Button minGore;
    private boolean checkMinGore = false;
    private Integer minGoreBroj = 0;

    @FXML
    private Button minNajava;
    private boolean checkMinNajava = false;
    private Integer minNajavaBroj = 0;

    @FXML
    private Button minRucna;
    private boolean checkMinRucna = false;
    private Integer minRucnaBroj = 0;

    @FXML
    private Button minSlobodna;
    private boolean checkMinSlobodna = false;
    private Integer minSlobodnaBroj = 0;

    @FXML
    private Button peticeGore;
    private boolean checkPeticeGore = false;
    private Integer peticeGoreBroj;

    @FXML
    private Button peticeNajava;
    private boolean checkPeticeNajava = false;
    private Integer peticeNajavaBroj;

    @FXML
    private Button peticeRucna;
    private boolean checkPeticeRucna = false;
    private Integer peticeRucnaBroj;

    @FXML
    private Button peticeSlobodna;
    private boolean checkPeticeSlobodna = false;
    private Integer peticeSlobodnaBroj;

    @FXML
    private Button pokerGore;
    private boolean checkPPokerGore = false;
    private Integer pokerGoreBroj;

    @FXML
    private Button pokerNajava;
    private boolean checkPPokerNajava = false;
    private Integer pokerNajavaBroj;

    @FXML
    private Button pokerRucna;
    private boolean checkPPokerRucna = false;
    private Integer pokerRucnaBroj;

    @FXML
    private Button pokerSlobodna;
    private boolean checkPPokerSlobodna = false;
    private Integer pokerSlobodnaBroj;

    @FXML
    private Button sesticeGore;
    private boolean checkSesticeGore = false;
    private Integer sesticeGoreBroj;

    @FXML
    private Button sesticeNajava;
    private boolean checkSesticeNajava = false;
    private Integer sesticeNajavaBroj;

    @FXML
    private Button sesticeRucna;
    private boolean checkSesticeRucna = false;
    private Integer sesticeRucnaBroj;

    @FXML
    private Button sesticeSlobodna;
    private boolean checkSesticeSlobodna = false;
    private Integer sesticeSlobodnaBroj;

    @FXML
    private Button trojkeGore;
    private boolean checkTrojkeeGore = false;
    private Integer trojkeGoreBroj;

    @FXML
    private Button trojkeNavaja;
    private boolean checkTrojkeeNajava = false;
    private Integer trojkeNajavaBroj;

    @FXML
    private Button trojkeRucna;
    private boolean checkTrojkeeRucna = false;
    private Integer trojkeRucnaBroj;

    @FXML
    private Button trojkeSlobodna;
    private boolean checkTrojkeeSlobodna = false;
    private Integer trojkeSlobodnaBroj;

    @FXML
    private Button yambGore;
    private boolean checkYambeGore = false;
    private Integer yambGoreBroj;

    @FXML
    private Button yambNajava;
    private boolean checkYambeNajava = false;
    private Integer yambNajavaBroj;

    @FXML
    private Button yambRucna;
    private boolean checkYambeRucna = false;
    private Integer yambRucnaBroj;

    @FXML
    private Button yambSlobodna;
    private boolean checkYambeSlobodna = false;
    private Integer yambSlobodnaBroj;

    @FXML
    private TextField ukupanZbir;

    @FXML
    private Label zbir1;

    @FXML
    private Label zbir2;

    @FXML
    private Label zbir3;

    @FXML
    private Label zbirGore1;

    @FXML
    private Label zbirGore2;

    @FXML
    private Label zbirGore3;

    @FXML
    private Label zbirNajava1;

    @FXML
    private Label zbirNajava2;

    @FXML
    private Label zbirNajava3;

    @FXML
    private Label zbirRucna1;

    @FXML
    private Label zbirRucna2;

    @FXML
    private Label zbirRucna3;

    @FXML
    private Label zbirSlobodna1;

    @FXML
    private Label zbirSlobodna2;

    @FXML
    private Label zbirSlobodna3;

    @FXML
    private Label zbirdole1;

    @FXML
    private Label zbirdole2;

    @FXML
    private Label zbirdole3;

    @FXML
    private TextField nameOfPlayer;

    @FXML
    private Button SaveScoreBtn;

    @FXML
    private Button ScoreButton;

    private Integer flag;

    @FXML
    private ImageView KockicaPrva;
    @FXML
    private ImageView KockicaDruga;
    @FXML
    private ImageView KockicaTreca;
    @FXML
    private ImageView KockicaCetvrta;
    @FXML
    private ImageView KockicaPeta;
    @FXML
    private ImageView KockicaSesta;

    private Integer brojPrvaKockica;
    private Integer brojDrugaaKockica;
    private Integer brojTrecaaKockica;
    private Integer brojCetvrtaaKockica;
    private Integer brojPetaKockica;
    private Integer brojSestaKockica;

    private boolean noviKrug = true;
    private Integer najavaCLicked = 0;
    private boolean checkNajavaJedinice = false;
    private boolean checkNajavaDvojke = false;
    private boolean checkNajavaTrojke = false;
    private boolean checkNajavaCetvorke = false;
    private boolean checkNajavaPetice = false;
    private boolean checkNajavaSestice = false;
    private boolean checkNajavaMax = false;
    private boolean checkNajavaMin = false;
    private boolean checkNajavaKenta = false;
    private boolean checkNajavaFull = false;
    private boolean checkNajavaPoker = false;
    private boolean checkNajavaYamb = false;

    public void switchToGame(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene.fxml"));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToMainMenu(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Menu.fxml"));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void HighScore(ActionEvent event) throws IOException {
        String s = "";
        File file = new File("score");
        try {
            FileReader fin = new FileReader(file);
            Scanner myReader = new Scanner(fin);
            while (myReader.hasNext()) {
                s += myReader.next();
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, s, "Najbolji postignuti rezultat", JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    void WriteScore(MouseEvent event) {
        System.out.println("save");
        if (jediniceDole.getText() != "" && jediniceGore.getText() != "" && jediniceNajava.getText() != ""
                && jediniceRucna.getText() != "" && jediniceSlobodna.getText() != "" &&
                dvojkeDole.getText() != "" && dvojkeGore.getText() != "" && dvojkeNavaja.getText() != ""
                && dvojkeRucna.getText() != "" && dvojkeSlobodna.getText() != "" &&
                trojkeDole.getText() != "" && trojkeGore.getText() != "" && trojkeNavaja.getText() != ""
                && trojkeRucna.getText() != "" && trojkeSlobodna.getText() != "" &&
                cetvorkeDole.getText() != "" && cetvorkeGore.getText() != "" && cetvorkeNajava.getText() != ""
                && cetvorkeRucna.getText() != "" && cetvorkeSlobodna.getText() != "" &&
                peticeDole.getText() != "" && peticeGore.getText() != "" && peticeNajava.getText() != ""
                && peticeRucna.getText() != "" && peticeSlobodna.getText() != "" &&
                sesticeDole.getText() != "" && sesticeGore.getText() != "" && sesticeNajava.getText() != ""
                && sesticeRucna.getText() != "" && sesticeSlobodna.getText() != "" &&
                maxDole.getText() != "" && maxGore.getText() != "" && maxNajava.getText() != ""
                && maxRucna.getText() != "" && maxSlobodna.getText() != "" &&
                minDole.getText() != "" && minGore.getText() != "" && minNajava.getText() != ""
                && minRucna.getText() != "" && minSlobodna.getText() != "" &&
                kentaDole.getText() != "" && kentaGore.getText() != "" && kentaNajava.getText() != ""
                && kentaRucna.getText() != "" && kentaSlobodna.getText() != "" &&
                fullDole.getText() != "" && fullGore.getText() != "" && fullNajava.getText() != ""
                && fullRucna.getText() != "" && fullSlobodna.getText() != "" &&
                pokerDole.getText() != "" && pokerGore.getText() != "" && pokerNajava.getText() != ""
                && pokerRucna.getText() != "" && pokerSlobodna.getText() != "" &&
                yambDole.getText() != "" && yambGore.getText() != "" && yambNajava.getText() != ""
                && yambRucna.getText() != "" && yambSlobodna.getText() != "") {
            File file = new File("score");

            if (nameOfPlayer.getText() == "") {
                JOptionPane.showMessageDialog(null, "Niste uneli ime!");
            } else {
                try {
                    FileWriter myWriter = new FileWriter(file);
                    myWriter.write("xxx : 0");

                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

                try {
                    FileReader fin = new FileReader(file);
                    Scanner myReader = new Scanner(fin);
                    while (myReader.hasNext()) {
                        String s = myReader.next();
                        try {

                            System.out.println(s + " is a valid integer");
                            flag = Integer.parseInt(s);
                        } catch (NumberFormatException e) {
                            System.out.println(s + " is not a valid integer");
                        }
                    }

                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

                System.out.println(flag);

                try {
                    FileWriter myWriter = new FileWriter(file);
                    if (Integer.parseInt(ukupanZbir.getText()) > flag) {
                        myWriter.write(nameOfPlayer.getText() + " " + ":" + " " + ukupanZbir.getText() + "\n");
                    } else {
                        JOptionPane.showMessageDialog(null, "Mozete vi to bolje!");
                    }

                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Niste zavrsili partiju!");
        }
        ;

    }

    @FXML
    void setValue(ActionEvent event) {

        System.out.println(brojacBacanja);

        if (brojacBacanja < 3 && noviKrug == true) {
            kockice.clear();
            if (checkPrvaKockica == false) {
                k = rand.nextInt(6) + 1;
                kockice.add(k);
                if (k == 1) {
                    KockicaPrva.setImage(new Image("images/jedan.png"));
                    brojPrvaKockica = 1;
                } else if (k == 2) {
                    KockicaPrva.setImage(new Image("images/dva.png"));
                    brojPrvaKockica = 2;
                } else if (k == 3) {
                    KockicaPrva.setImage(new Image("images/tri.png"));
                    brojPrvaKockica = 3;
                } else if (k == 4) {
                    KockicaPrva.setImage(new Image("images/cetiri.png"));
                    brojPrvaKockica = 4;
                } else if (k == 5) {
                    KockicaPrva.setImage(new Image("images/pet.png"));
                    brojPrvaKockica = 5;
                } else {
                    KockicaPrva.setImage(new Image("images/sest.png"));
                    brojPrvaKockica = 6;
                }

            } else {
                if (brojPrvaKockica == 1) {
                    kockice.add(1);
                } else if (brojPrvaKockica == 2) {
                    kockice.add(2);
                } else if (brojPrvaKockica == 3) {
                    kockice.add(3);
                } else if (brojPrvaKockica == 4) {
                    kockice.add(4);
                } else if (brojPrvaKockica == 5) {
                    kockice.add(5);
                } else {
                    kockice.add(6);
                }

            }

            if (checkDrugaKockica == false) {
                k = rand.nextInt(6) + 1;
                kockice.add(k);
                if (k == 1) {
                    KockicaDruga.setImage(new Image("images/jedan.png"));
                    brojDrugaaKockica = 1;
                } else if (k == 2) {
                    KockicaDruga.setImage(new Image("images/dva.png"));
                    brojDrugaaKockica = 2;
                } else if (k == 3) {
                    KockicaDruga.setImage(new Image("images/tri.png"));
                    brojDrugaaKockica = 3;
                } else if (k == 4) {
                    KockicaDruga.setImage(new Image("images/cetiri.png"));
                    brojDrugaaKockica = 4;
                } else if (k == 5) {
                    KockicaDruga.setImage(new Image("images/pet.png"));
                    brojDrugaaKockica = 5;
                } else {
                    KockicaDruga.setImage(new Image("images/sest.png"));
                    brojDrugaaKockica = 6;
                }
            } else {
                if (brojDrugaaKockica == 1) {
                    kockice.add(1);
                } else if (brojDrugaaKockica == 2) {
                    kockice.add(2);
                } else if (brojDrugaaKockica == 3) {
                    kockice.add(3);
                } else if (brojDrugaaKockica == 4) {
                    kockice.add(4);
                } else if (brojDrugaaKockica == 5) {
                    kockice.add(5);
                } else {
                    kockice.add(6);
                }
            }

            if (checkTrecaKockica == false && brojacBacanja < 3) {
                k = rand.nextInt(6) + 1;
                kockice.add(k);
                if (k == 1) {
                    KockicaTreca.setImage(new Image("images/jedan.png"));
                    brojTrecaaKockica = 1;
                } else if (k == 2) {
                    KockicaTreca.setImage(new Image("images/dva.png"));
                    brojTrecaaKockica = 2;
                } else if (k == 3) {
                    KockicaTreca.setImage(new Image("images/tri.png"));
                    brojTrecaaKockica = 3;
                } else if (k == 4) {
                    KockicaTreca.setImage(new Image("images/cetiri.png"));
                    brojTrecaaKockica = 4;
                } else if (k == 5) {
                    KockicaTreca.setImage(new Image("images/pet.png"));
                    brojTrecaaKockica = 5;
                } else {
                    KockicaTreca.setImage(new Image("images/sest.png"));
                    brojTrecaaKockica = 6;
                }
            } else {
                if (brojTrecaaKockica == 1) {
                    kockice.add(1);
                } else if (brojTrecaaKockica == 2) {
                    kockice.add(2);
                } else if (brojTrecaaKockica == 3) {
                    kockice.add(3);
                } else if (brojTrecaaKockica == 4) {
                    kockice.add(4);
                } else if (brojTrecaaKockica == 5) {
                    kockice.add(5);
                } else {
                    kockice.add(6);
                }
            }

            if (checkCetvrtaKockica == false && brojacBacanja < 3) {
                k = rand.nextInt(6) + 1;
                kockice.add(k);
                if (k == 1) {
                    KockicaCetvrta.setImage(new Image("images/jedan.png"));
                    brojCetvrtaaKockica = 1;
                } else if (k == 2) {
                    KockicaCetvrta.setImage(new Image("images/dva.png"));
                    brojCetvrtaaKockica = 2;
                } else if (k == 3) {
                    KockicaCetvrta.setImage(new Image("images/tri.png"));
                    brojCetvrtaaKockica = 3;
                } else if (k == 4) {
                    KockicaCetvrta.setImage(new Image("images/cetiri.png"));
                    brojCetvrtaaKockica = 4;
                } else if (k == 5) {
                    KockicaCetvrta.setImage(new Image("images/pet.png"));
                    brojCetvrtaaKockica = 5;
                } else {
                    KockicaCetvrta.setImage(new Image("images/sest.png"));
                    brojCetvrtaaKockica = 6;
                }
            } else {
                if (brojCetvrtaaKockica == 1) {
                    kockice.add(1);
                } else if (brojCetvrtaaKockica == 2) {
                    kockice.add(2);
                } else if (brojCetvrtaaKockica == 3) {
                    kockice.add(3);
                } else if (brojCetvrtaaKockica == 4) {
                    kockice.add(4);
                } else if (brojCetvrtaaKockica == 5) {
                    kockice.add(5);
                } else {
                    kockice.add(6);
                }
            }

            if (checkPetaKockica == false && brojacBacanja < 3) {
                k = rand.nextInt(6) + 1;
                kockice.add(k);
                if (k == 1) {
                    KockicaPeta.setImage(new Image("images/jedan.png"));
                    brojPetaKockica = 1;
                } else if (k == 2) {
                    KockicaPeta.setImage(new Image("images/dva.png"));
                    brojPetaKockica = 2;
                } else if (k == 3) {
                    KockicaPeta.setImage(new Image("images/tri.png"));
                    brojPetaKockica = 3;
                } else if (k == 4) {
                    KockicaPeta.setImage(new Image("images/cetiri.png"));
                    brojPetaKockica = 4;
                } else if (k == 5) {
                    KockicaPeta.setImage(new Image("images/pet.png"));
                    brojPetaKockica = 5;
                } else {
                    KockicaPeta.setImage(new Image("images/sest.png"));
                    brojPetaKockica = 6;
                }
            } else {
                if (brojPetaKockica == 1) {
                    kockice.add(1);
                } else if (brojPetaKockica == 2) {
                    kockice.add(2);
                } else if (brojPetaKockica == 3) {
                    kockice.add(3);
                } else if (brojPetaKockica == 4) {
                    kockice.add(4);
                } else if (brojPetaKockica == 5) {
                    kockice.add(5);
                } else {
                    kockice.add(6);
                }
            }

            if (checkSestaKockica == false && brojacBacanja < 3) {
                k = rand.nextInt(6) + 1;
                kockice.add(k);
                if (k == 1) {
                    KockicaSesta.setImage(new Image("images/jedan.png"));
                    brojSestaKockica = 1;
                } else if (k == 2) {
                    KockicaSesta.setImage(new Image("images/dva.png"));
                    brojSestaKockica = 2;
                } else if (k == 3) {
                    KockicaSesta.setImage(new Image("images/tri.png"));
                    brojSestaKockica = 3;
                } else if (k == 4) {
                    KockicaSesta.setImage(new Image("images/cetiri.png"));
                    brojSestaKockica = 4;
                } else if (k == 5) {
                    KockicaSesta.setImage(new Image("images/pet.png"));
                    brojSestaKockica = 5;
                } else {
                    KockicaSesta.setImage(new Image("images/sest.png"));
                    brojSestaKockica = 6;
                }
            } else {
                if (brojSestaKockica == 1) {
                    kockice.add(1);
                } else if (brojSestaKockica == 2) {
                    kockice.add(2);
                } else if (brojSestaKockica == 3) {
                    kockice.add(3);
                } else if (brojSestaKockica == 4) {
                    kockice.add(4);
                } else if (brojSestaKockica == 5) {
                    kockice.add(5);
                } else {
                    kockice.add(6);
                }
            }
            brojacBacanja++;
            System.out.println(brojacBacanja);
            // brojacDrugiKrug = false;
            System.out.println(kockice);

        }
        else{
            JOptionPane.showMessageDialog(null, "Pocnite novi potez");
        }

    }

    @FXML
    void ClickedCetvrtaKockica(MouseEvent event) {
        clicked4++;
        if (clicked4 % 2 == 1) {
            KockicaCetvrta.setTranslateY(-10);
            checkCetvrtaKockica = true;
        } else {
            KockicaCetvrta.setTranslateY(10);
            checkCetvrtaKockica = false;
        }
    }

    @FXML
    void ClickedDrugaKockica(MouseEvent event) {
        clicked2++;
        if (clicked2 % 2 == 1) {
            KockicaDruga.setTranslateY(-10);
            checkDrugaKockica = true;
        } else {
            KockicaDruga.setTranslateY(10);
            checkDrugaKockica = false;
        }
    }

    @FXML
    void ClickedPetaKockica(MouseEvent event) {
        clicked5++;
        if (clicked5 % 2 == 1) {
            KockicaPeta.setTranslateY(-10);
            checkPetaKockica = true;
        } else {
            KockicaPeta.setTranslateY(10);
            checkPetaKockica = false;
        }
    }

    @FXML
    void ClickedPrvaKockica(MouseEvent event) {
        clicked1++;
        if (clicked1 % 2 == 1) {
            KockicaPrva.setTranslateY(-10);
            checkPrvaKockica = true;
        } else {
            KockicaPrva.setTranslateY(10);
            checkPrvaKockica = false;
        }
    }

    @FXML
    void ClickedSestaKockica(MouseEvent event) {
        clicked6++;
        if (clicked6 % 2 == 1) {
            KockicaSesta.setTranslateY(-10);
            checkSestaKockica = true;
        } else {
            KockicaSesta.setTranslateY(10);
            checkSestaKockica = false;
        }
    }

    @FXML
    void ClickedTrecaKockica(MouseEvent event) {
        clicked3++;
        if (clicked3 % 2 == 1) {
            KockicaTreca.setTranslateY(-10);
            checkTrecaKockica = true;
        } else {
            KockicaTreca.setTranslateY(10);
            checkTrecaKockica = false;
        }
    }

    @FXML
    void RestartKockice(ActionEvent event) {
        if (brojacBacanja >= 3 && pressNewTurn == true) {

            if (sesticeDole.getText() == "") {
                if (jediniceDole.getText() == "") {
                    jediniceDoleBroj = 0;
                }
                if (dvojkeDole.getText() == "") {
                    dvojkeDoleBroj = 0;
                }
                if (trojkeDole.getText() == "") {
                    trojkeDoleBroj = 0;
                }
                if (cetvorkeDole.getText() == "") {
                    cetvorkeDoleBroj = 0;
                }
                if (peticeDole.getText() == "") {
                    peticeDoleBroj = 0;
                }
                sesticeDoleBroj = 0;

            }
            if (minDole.getText() == "") {
                if (maxDole.getText() == "") {
                    maxDoleBroj = 0;
                }
                minDoleBroj = 0;

            }
            if (yambDole.getText() == "") {
                if (kentaDole.getText() == "") {
                    kentaDoleBroj = 0;
                }
                if (fullDole.getText() == "") {
                    fullDoleBroj = 0;
                }
                if (pokerDole.getText() == "") {
                    pokerDoleBroj = 0;
                }
                yambDoleBroj = 0;

            }

            // slobodna

            if (jediniceSlobodna.getText() == "") {
                jediniceSlobodnaBroj = 0;
            }
            if (dvojkeSlobodna.getText() == "") {
                dvojkeSlobodnaBroj = 0;
            }
            if (trojkeSlobodna.getText() == "") {
                trojkeSlobodnaBroj = 0;
            }
            if (cetvorkeSlobodna.getText() == "") {
                cetvorkeSlobodnaBroj = 0;
            }
            if (peticeSlobodna.getText() == "") {
                peticeSlobodnaBroj = 0;
            }
            if (sesticeSlobodna.getText() == "") {
                sesticeSlobodnaBroj = 0;
            }
            if (maxSlobodna.getText() == "") {
                maxSlobodnaBroj = 0;
            }
            if (minSlobodna.getText() == "") {
                minSlobodnaBroj = 0;
            }
            if (kentaSlobodna.getText() == "") {
                kentaSlobodnaBroj = 0;
            }
            if (fullSlobodna.getText() == "") {
                fullSlobodnaBroj = 0;
            }
            if (pokerSlobodna.getText() == "") {
                pokerSlobodnaBroj = 0;
            }
            if (yambSlobodna.getText() == "") {
                yambSlobodnaBroj = 0;
            }

            // gornja
            if (kentaGore.getText() == "") {
                if (kentaGore.getText() == "") {
                    kentaGoreBroj = 0;
                }
                if (fullGore.getText() == "") {
                    fullGoreBroj = 0;
                }
                if (pokerGore.getText() == "") {
                    pokerGoreBroj = 0;
                }
                if (yambGore.getText() == "") {
                    yambGoreBroj = 0;
                }
            }
            if (maxGore.getText() == "") {
                maxGoreBroj = 0;
                if (minGore.getText() == "") {
                    minGoreBroj = 0;
                }

            }
            if (jediniceGore.getText() == "") {
                jediniceGoreBroj = 0;

                if (dvojkeGore.getText() == "") {
                    dvojkeGoreBroj = 0;
                }
                if (trojkeGore.getText() == "") {
                    trojkeGoreBroj = 0;
                }
                if (cetvorkeGore.getText() == "") {
                    cetvorkeGoreBroj = 0;
                }
                if (peticeGore.getText() == "") {
                    peticeGoreBroj = 0;
                }
                if (sesticeGore.getText() == "") {
                    sesticeGoreBroj = 0;
                }

            }

            // rucna

            if (jediniceRucna.getText() == "") {
                jediniceRucnaBroj = 0;
            }
            if (dvojkeRucna.getText() == "") {
                dvojkeRucnaBroj = 0;
            }
            if (trojkeRucna.getText() == "") {
                trojkeRucnaBroj = 0;
            }
            if (cetvorkeRucna.getText() == "") {
                cetvorkeRucnaBroj = 0;
            }
            if (peticeRucna.getText() == "") {
                peticeRucnaBroj = 0;
            }
            if (sesticeRucna.getText() == "") {
                sesticeRucnaBroj = 0;
            }
            if (maxRucna.getText() == "") {
                maxRucnaBroj = 0;
            }
            if (minRucna.getText() == "") {
                minRucnaBroj = 0;
            }
            if (kentaRucna.getText() == "") {
                kentaRucnaBroj = 0;
            }
            if (fullRucna.getText() == "") {
                fullRucnaBroj = 0;
            }
            if (pokerRucna.getText() == "") {
                pokerRucnaBroj = 0;
            }
            if (yambRucna.getText() == "") {
                yambRucnaBroj = 0;
            }

            // najava

            if (jediniceNajava.getText() == "") {
                jediniceNajavaBroj = 0;
            }
            if (dvojkeNavaja.getText() == "") {
                dvojkeNajavaBroj = 0;
            }
            if (trojkeNavaja.getText() == "") {
                trojkeNajavaBroj = 0;
            }
            if (cetvorkeNajava.getText() == "") {
                cetvorkeNajavaBroj = 0;
            }
            if (peticeNajava.getText() == "") {
                peticeNajavaBroj = 0;
            }
            if (sesticeNajava.getText() == "") {
                sesticeNajavaBroj = 0;
            }
            if (maxNajava.getText() == "") {
                maxNajavaBroj = 0;
            }
            if (minNajava.getText() == "") {
                minNajavaBroj = 0;
            }
            if (kentaNajava.getText() == "") {
                kentaNajavaBroj = 0;
            }
            if (fullNajava.getText() == "") {
                fullNajavaBroj = 0;
            }
            if (pokerNajava.getText() == "") {
                pokerNajavaBroj = 0;
            }
            if (yambNajava.getText() == "") {
                yambNajavaBroj = 0;
            }

            zbirdole1.setText(String.valueOf(jediniceDoleBroj + dvojkeDoleBroj + trojkeDoleBroj + cetvorkeDoleBroj
                    + peticeDoleBroj + sesticeDoleBroj));
            zbirdole2.setText(String.valueOf((maxDoleBroj - minDoleBroj) * jediniceDoleBroj));
            zbirdole3.setText(String.valueOf(kentaDoleBroj + fullDoleBroj + pokerDoleBroj + yambDoleBroj));

            zbirSlobodna1.setText(String.valueOf(jediniceSlobodnaBroj + dvojkeSlobodnaBroj + trojkeSlobodnaBroj
                    + cetvorkeSlobodnaBroj + peticeSlobodnaBroj + sesticeSlobodnaBroj));
            zbirSlobodna2.setText(String.valueOf((maxSlobodnaBroj - minSlobodnaBroj) * jediniceSlobodnaBroj));
            zbirSlobodna3.setText(
                    String.valueOf(kentaSlobodnaBroj + fullSlobodnaBroj + pokerSlobodnaBroj + yambSlobodnaBroj));

            zbirGore1.setText(String.valueOf(jediniceGoreBroj + dvojkeGoreBroj + trojkeGoreBroj + cetvorkeGoreBroj
                    + peticeGoreBroj + sesticeGoreBroj));
            zbirGore2.setText(String.valueOf((maxGoreBroj - minGoreBroj) * jediniceGoreBroj));
            zbirGore3.setText(String.valueOf(kentaGoreBroj + fullGoreBroj + pokerGoreBroj + yambGoreBroj));

            zbirRucna1.setText(String.valueOf(jediniceRucnaBroj + dvojkeRucnaBroj + trojkeRucnaBroj + cetvorkeRucnaBroj
                    + peticeRucnaBroj + sesticeRucnaBroj));
            zbirRucna2.setText(String.valueOf((maxRucnaBroj - minRucnaBroj) * jediniceRucnaBroj));
            zbirRucna3.setText(String.valueOf(kentaRucnaBroj + fullRucnaBroj + pokerRucnaBroj + yambRucnaBroj));

            zbirNajava1.setText(String.valueOf(jediniceNajavaBroj + dvojkeNajavaBroj + trojkeNajavaBroj
                    + cetvorkeNajavaBroj + peticeNajavaBroj + sesticeNajavaBroj));
            zbirNajava2.setText(String.valueOf((maxNajavaBroj - minNajavaBroj) * jediniceNajavaBroj));
            zbirNajava3.setText(String.valueOf(kentaNajavaBroj + fullNajavaBroj + pokerNajavaBroj + yambNajavaBroj));

            zbir1.setText(String.valueOf(jediniceDoleBroj + dvojkeDoleBroj + trojkeDoleBroj + cetvorkeDoleBroj
                    + peticeDoleBroj + sesticeDoleBroj +
                    jediniceSlobodnaBroj + dvojkeSlobodnaBroj + trojkeSlobodnaBroj + cetvorkeSlobodnaBroj
                    + peticeSlobodnaBroj + sesticeSlobodnaBroj +
                    jediniceGoreBroj + dvojkeGoreBroj + trojkeGoreBroj + cetvorkeGoreBroj + peticeGoreBroj
                    + sesticeGoreBroj +
                    jediniceRucnaBroj + dvojkeRucnaBroj + trojkeRucnaBroj + cetvorkeRucnaBroj + peticeRucnaBroj
                    + sesticeRucnaBroj +
                    jediniceNajavaBroj + dvojkeNajavaBroj + trojkeNajavaBroj + cetvorkeNajavaBroj + peticeNajavaBroj
                    + sesticeNajavaBroj));

            zbir2.setText(String.valueOf(Integer.parseInt(zbirGore2.getText()) + Integer.parseInt(zbirdole2.getText()) +
                    Integer.parseInt(zbirSlobodna2.getText()) + Integer.parseInt(zbirRucna2.getText())
                    + Integer.parseInt(zbirNajava2.getText())));

            zbir3.setText(String.valueOf(kentaDoleBroj + fullDoleBroj + pokerDoleBroj + yambDoleBroj +
                    kentaSlobodnaBroj + fullSlobodnaBroj + pokerSlobodnaBroj + yambSlobodnaBroj +
                    kentaGoreBroj + fullGoreBroj + pokerGoreBroj + yambGoreBroj +
                    kentaRucnaBroj + fullRucnaBroj + pokerRucnaBroj + yambRucnaBroj +
                    kentaNajavaBroj + fullNajavaBroj + pokerNajavaBroj + yambNajavaBroj));

            ukupanZbir.setText(String.valueOf(Integer.parseInt(zbir2.getText()) + Integer.parseInt(zbir1.getText())
                    + Integer.parseInt(zbir3.getText())));

            if (checkPrvaKockica == true) {
                KockicaPrva.setTranslateY(10);
            }
            if (checkDrugaKockica == true) {
                KockicaDruga.setTranslateY(10);
            }
            if (checkTrecaKockica == true) {
                KockicaTreca.setTranslateY(10);
            }
            if (checkCetvrtaKockica == true) {
                KockicaCetvrta.setTranslateY(10);
            }
            if (checkPetaKockica == true) {
                KockicaPeta.setTranslateY(10);
            }
            if (checkSestaKockica == true) {
                KockicaSesta.setTranslateY(10);
            }

            checkPrvaKockica = false;
            checkCetvrtaKockica = false;
            checkDrugaKockica = false;
            checkSestaKockica = false;
            checkTrecaKockica = false;
            checkPetaKockica = false;

            // brojacDrugiKrug = true;
            pressNewTurn = false;
            writeNewField = true;

            najavljeno = false;
            najava.setText("najavi");

            brojacBacanja = 0;

            kockice.clear();
        }
        else{
            JOptionPane.showMessageDialog(null, "Niste zavrsili potez!");
        }

    }

    // PETA KOLONA - NAJAVA
    @FXML
    void Najavi(ActionEvent event) {
        n++;
        if (n % 2 == 0 && brojacBacanja == 1) {
            najavljeno = true;
            najava.setText("odustani");
            JOptionPane.showMessageDialog(null, "Stisnite polje koje zelite da najavite", null,
                    JOptionPane.INFORMATION_MESSAGE);
            noviKrug = false;
            najavaCLicked++;
        } else if (brojacBacanja == 1) {
            najavljeno = false;
            najava.setText("najavi");
            noviKrug = true;
            najavaCLicked = 0;
            checkNajavaJedinice = false;
            checkNajavaDvojke = false;
            checkNajavaTrojke = false;
            checkNajavaCetvorke = false;
            checkNajavaPetice = false;
            checkNajavaSestice = false;
            checkNajavaMax = false;
            checkNajavaMin = false;
            checkNajavaKenta = false;
            checkNajavaFull = false;
            checkNajavaPoker = false;
            checkNajavaYamb = false;

        }

    }

    // PRVA KOLONA - NA DOLE
    @FXML
    void JediniceDoleF(ActionEvent event) {
        jediniceDoleBroj = Collections.frequency(kockice, 1);
        if(jediniceDoleBroj > 5){
            jediniceDoleBroj = 5;
        }
        if (checkJediniceDole == false && writeNewField == true && najavljeno == false) {
            jediniceDole.setText(String.valueOf(jediniceDoleBroj));
            checkJediniceDole = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void DvojkeDoleF(ActionEvent event) {
        dvojkeDoleBroj = ((Collections.frequency(kockice, 2)) * 2);
        if(dvojkeDoleBroj > 10){
            dvojkeDoleBroj = 10;
        }
        if (checkDvojkeDole == false && jediniceDole.getText() != "" && writeNewField == true && najavljeno == false) {
            dvojkeDole.setText(String.valueOf(dvojkeDoleBroj));
            checkDvojkeDole = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void TrojkeDoleF(ActionEvent event) {
        trojkeDoleBroj = ((Collections.frequency(kockice, 3)) * 3);
        if(trojkeDoleBroj > 15){
            trojkeDoleBroj = 15;
        }
        if (checkTrojkeDole == false && dvojkeDole.getText() != "" && writeNewField == true && najavljeno == false) {
            trojkeDole.setText(String.valueOf(trojkeDoleBroj));
            checkTrojkeDole = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void CetvorkeDoleF(ActionEvent event) {
        cetvorkeDoleBroj = ((Collections.frequency(kockice, 4)) * 4);
        if(cetvorkeDoleBroj > 20){
            cetvorkeDoleBroj = 20;
        }
        if (checkCetvorkeDole == false && trojkeDole.getText() != "" && writeNewField == true && najavljeno == false) {
            cetvorkeDole.setText(String.valueOf(cetvorkeDoleBroj));
            checkCetvorkeDole = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void PeticeDoleF(ActionEvent event) {
        peticeDoleBroj = ((Collections.frequency(kockice, 5)) * 5);
        if(peticeDoleBroj > 25){
            peticeDoleBroj = 25;
        }
        if (checkPeticeDole == false && cetvorkeDole.getText() != "" && writeNewField == true && najavljeno == false) {
            peticeDole.setText(String.valueOf(peticeDoleBroj));
            checkPeticeDole = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void SesticeDoleF(ActionEvent event) {
        sesticeDoleBroj = ((Collections.frequency(kockice, 6)) * 6);
        if(sesticeDoleBroj > 30){
            sesticeDoleBroj = 30;
        }
        if (checkSesticeDole == false && peticeDole.getText() != "" && writeNewField == true && najavljeno == false) {
            sesticeDole.setText(String.valueOf(sesticeDoleBroj));
            checkSesticeDole = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }

    }

    @FXML
    void MaxDoleF(ActionEvent event) {
        Collections.sort(kockice, Collections.reverseOrder());
        for (int i = 0; i < 5; i++) {
            maxDoleBroj += kockice.get(i);
        }
        System.out.println(maxDoleBroj);
        System.out.println(kockice);
        if (checkMaxDole == false && sesticeDole.getText() != "" && writeNewField == true && najavljeno == false) {
            maxDole.setText(String.valueOf(maxDoleBroj));
            checkMaxDole = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void MinDoleF(ActionEvent event) {
        Collections.sort(kockice);
        for (int i = 0; i < 5; i++) {
            minDoleBroj += kockice.get(i);
        }
        if (checkMinDole == false && maxDole.getText() != "" && writeNewField == true && najavljeno == false) {
            minDole.setText(String.valueOf(minDoleBroj));
            checkMinDole = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }

    }

    @FXML
    void KentaDoleF(ActionEvent event) {
        List<Integer> bezDuplikata = new ArrayList<>(new LinkedHashSet<>(kockice));
        if (checkKentaDole == false && minDole.getText() != "" && writeNewField == true && najavljeno == false) {
            kentaDoleBroj = p.getKenta(bezDuplikata, brojacBacanja);
            kentaDole.setText(String.valueOf(kentaDoleBroj));
            checkKentaDole = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }

    }

    @FXML
    void FullDoleF(ActionEvent event) {
        if (checkFullDole == false && kentaDole.getText() != "" && writeNewField == true && najavljeno == false) {
            fullDoleBroj = p.getFull(kockice);
            fullDole.setText(String.valueOf(fullDoleBroj));
            checkFullDole = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void PokerDoleF(ActionEvent event) {
        if (checkPokerDole == false && fullDole.getText() != "" && writeNewField == true && najavljeno == false) {
            pokerDoleBroj = p.getPoker(kockice);
            pokerDole.setText(String.valueOf(pokerDoleBroj));
            checkPokerDole = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void YambDoleF(ActionEvent event) {
        if (checkYambDole == false && pokerDole.getText() != "" && writeNewField == true && najavljeno == false) {
            yambDoleBroj = p.getYamb(kockice);
            yambDole.setText(String.valueOf(yambDoleBroj));
            checkYambDole = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void CetvorkeGoreF(ActionEvent event) {
        cetvorkeGoreBroj = ((Collections.frequency(kockice, 4)) * 4);
        if(cetvorkeGoreBroj > 20){
            cetvorkeGoreBroj = 20;
        }
        if (checkCetvorkeGore == false && peticeGore.getText() != "" && writeNewField == true && najavljeno == false) {
            cetvorkeGore.setText(String.valueOf(cetvorkeGoreBroj));
            checkCetvorkeGore = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void CetvorkeNajavaF(ActionEvent event) {
        cetvorkeNajavaBroj = ((Collections.frequency(kockice, 4)) * 4);
        if(cetvorkeNajavaBroj > 20){
            cetvorkeNajavaBroj = 20;
        }
        if (checkCetvorkeNajava == false && writeNewField == true && najavljeno == true
                && checkNajavaCetvorke == true) {
            cetvorkeNajava.setText(String.valueOf(cetvorkeNajavaBroj));
            checkCetvorkeNajava = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
        if (najavaCLicked == 1) {
            checkNajavaCetvorke = true;
            noviKrug = true;
            najavaCLicked = 0;
        }

    }

    @FXML
    void CetvorkeRucnaF(ActionEvent event) {
        cetvorkeRucnaBroj = ((Collections.frequency(kockice, 4)) * 4);
        if(cetvorkeRucnaBroj > 20){
            cetvorkeRucnaBroj = 20;
        }
        if (checkCetvorkeRucna == false && brojacBacanja == 1 && writeNewField == true && najavljeno == false) {
            cetvorkeRucna.setText(String.valueOf(cetvorkeRucnaBroj));
            checkCetvorkeRucna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void CetvorkeSlobodnaF(ActionEvent event) {
        cetvorkeSlobodnaBroj = ((Collections.frequency(kockice, 4)) * 4);
        if(cetvorkeSlobodnaBroj > 20){
            cetvorkeSlobodnaBroj = 20;
        }
        if (checkCetvorkeSlobodna == false && writeNewField == true && najavljeno == false) {
            cetvorkeSlobodna.setText(String.valueOf(cetvorkeSlobodnaBroj));
            checkCetvorkeSlobodna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void DvojkeGoreF(ActionEvent event) {
        dvojkeGoreBroj = ((Collections.frequency(kockice, 2)) * 2);
        if(dvojkeGoreBroj > 10){
            dvojkeGoreBroj = 10;
        }
        if (checkDvojkeGore == false && trojkeGore.getText() != "" && writeNewField == true && najavljeno == false) {
            dvojkeGore.setText(String.valueOf(dvojkeGoreBroj));
            checkDvojkeGore = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void DvojkeNavajaF(ActionEvent event) {
        dvojkeNajavaBroj = ((Collections.frequency(kockice, 2)) * 2);
        if(dvojkeNajavaBroj > 10){
            dvojkeNajavaBroj = 10;
        }
        if (checkDvojkeNajava == false && writeNewField == true && najavljeno == true && checkNajavaDvojke == true) {
            dvojkeNavaja.setText(String.valueOf(dvojkeNajavaBroj));
            checkDvojkeNajava = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
        if (najavaCLicked == 1) {
            checkNajavaDvojke = true;
            noviKrug = true;
            najavaCLicked = 0;
        }

    }

    @FXML
    void DvojkeRucnaF(ActionEvent event) {
        dvojkeRucnaBroj = ((Collections.frequency(kockice, 2)) * 2);
        if(dvojkeRucnaBroj > 10){
            dvojkeRucnaBroj = 10;
        }
        if (checkDvojkeRucna == false && brojacBacanja == 1 && writeNewField == true && najavljeno == false) {
            dvojkeRucna.setText(String.valueOf(dvojkeRucnaBroj));
            checkDvojkeRucna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void DvojkeSlobodnaF(ActionEvent event) {
        dvojkeSlobodnaBroj = ((Collections.frequency(kockice, 2)) * 2);
        if(dvojkeSlobodnaBroj > 10){
            dvojkeSlobodnaBroj = 10;
        }
        if (checkDvojkeSlobodna == false && writeNewField == true && najavljeno == false) {
            dvojkeSlobodna.setText(String.valueOf(dvojkeSlobodnaBroj));
            checkDvojkeSlobodna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void FullGoreF(ActionEvent event) {
        if (checkFullGore == false && pokerGore.getText() != "" && writeNewField == true && najavljeno == false) {
            fullGoreBroj = p.getFull(kockice);
            fullGore.setText(String.valueOf(fullGoreBroj));
            checkFullGore = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void FullNajavaF(ActionEvent event) {
        if (checkFullNajava == false && writeNewField == true && najavljeno == true && checkNajavaFull == true) {
            fullNajavaBroj = p.getFull(kockice);
            fullNajava.setText(String.valueOf(fullNajavaBroj));
            checkFullNajava = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
        if (najavaCLicked == 1) {
            checkNajavaFull = true;
            noviKrug = true;
            najavaCLicked = 0;
        }
    }

    @FXML
    void FullRucnaF(ActionEvent event) {
        if (checkFullRucna == false && brojacBacanja == 1 && writeNewField == true && najavljeno == false) {
            fullRucnaBroj = p.getFull(kockice);
            fullRucna.setText(String.valueOf(fullRucnaBroj));
            checkFullRucna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void FullSlobodnaF(ActionEvent event) {
        if (checkFullSlobodna == false && writeNewField == true && najavljeno == false) {
            fullSlobodnaBroj = p.getFull(kockice);
            fullSlobodna.setText(String.valueOf(fullSlobodnaBroj));
            checkFullSlobodna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void JediniceGoreF(ActionEvent event) {
        jediniceGoreBroj = Collections.frequency(kockice, 1);
        if(jediniceGoreBroj > 5){
            jediniceGoreBroj = 5;
        }
        if (checkJediniceGore == false && dvojkeGore.getText() != "" && writeNewField == true && najavljeno == false) {
            jediniceGore.setText(String.valueOf(jediniceGoreBroj));
            checkJediniceGore = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void JediniceNajavaF(ActionEvent event) {

        jediniceNajavaBroj = Collections.frequency(kockice, 1);
        if(jediniceNajavaBroj > 5){
            jediniceNajavaBroj = 5;
        }
        if (checkJediniceNajava == false && writeNewField == true && najavljeno == true
                && checkNajavaJedinice == true) {
            jediniceNajava.setText(String.valueOf(jediniceNajavaBroj));
            checkJediniceNajava = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
        if (najavaCLicked == 1) {
            checkNajavaJedinice = true;
            noviKrug = true;
            najavaCLicked = 0;
        }
    }

    @FXML
    void JediniceRucnaF(ActionEvent event) {
        jediniceRucnaBroj = Collections.frequency(kockice, 1);
        if(jediniceRucnaBroj > 5){
            jediniceRucnaBroj = 5;
        }
        if (checkJedinicRucna == false && brojacBacanja == 1 && writeNewField == true && najavljeno == false) {
            jediniceRucna.setText(String.valueOf(jediniceRucnaBroj));
            checkJedinicRucna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }

    }

    @FXML
    void JediniceSlobodnaF(ActionEvent event) {
        jediniceSlobodnaBroj = Collections.frequency(kockice, 1);
        if(jediniceSlobodnaBroj > 5){
            jediniceSlobodnaBroj = 5;
        }
        if (checkJediniceSlobodna == false && writeNewField == true && najavljeno == false) {
            jediniceSlobodna.setText(String.valueOf(jediniceSlobodnaBroj));
            checkJediniceSlobodna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void KentaGoreF(ActionEvent event) {
        List<Integer> bezDuplikata = new ArrayList<>(new LinkedHashSet<>(kockice));
        if (checkKentaGore == false && fullGore.getText() != "" && writeNewField == true && najavljeno == false) {
            kentaGoreBroj = p.getKenta(bezDuplikata, brojacBacanja);
            kentaGore.setText(String.valueOf(kentaGoreBroj));
            checkKentaGore = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }

    }

    @FXML
    void KentaNajavaF(ActionEvent event) {
        List<Integer> bezDuplikata = new ArrayList<>(new LinkedHashSet<>(kockice));
        if (checkKentaNajava == false && writeNewField == true && najavljeno == true && checkNajavaKenta == true) {
            kentaNajavaBroj = p.getKenta(bezDuplikata, brojacBacanja);
            kentaNajava.setText(String.valueOf(kentaNajavaBroj));
            checkKentaNajava = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
        if (najavaCLicked == 1) {
            checkNajavaKenta = true;
            noviKrug = true;
            najavaCLicked = 0;
        }
    }

    @FXML
    void KentaRucnaF(ActionEvent event) {
        List<Integer> bezDuplikata = new ArrayList<>(new LinkedHashSet<>(kockice));
        if (checkKentaRucna == false && brojacBacanja == 1 && writeNewField == true && najavljeno == false) {
            kentaRucnaBroj = p.getKenta(bezDuplikata, brojacBacanja);
            kentaRucna.setText(String.valueOf(kentaRucnaBroj));
            checkKentaRucna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void KentaSlobodnaF(ActionEvent event) {
        List<Integer> bezDuplikata = new ArrayList<>(new LinkedHashSet<>(kockice));
        if (checkKentaSlobodna == false && writeNewField == true && najavljeno == false) {
            kentaSlobodnaBroj = p.getKenta(bezDuplikata, brojacBacanja);
            kentaSlobodna.setText(String.valueOf(kentaSlobodnaBroj));
            checkKentaSlobodna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void MaxGoreF(ActionEvent event) {
        Collections.sort(kockice, Collections.reverseOrder());
        for (int i = 0; i < 5; i++) {
            maxGoreBroj += kockice.get(i);
        }
        if (checkMaxGore == false && minGore.getText() != "" && writeNewField == true && najavljeno == false) {
            maxGore.setText(String.valueOf(maxGoreBroj));
            checkMaxGore = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void MaxNajavaF(ActionEvent event) {

        if (checkMaxNajava == false && writeNewField == true && najavljeno == true && checkNajavaMax == true) {
            Collections.sort(kockice, Collections.reverseOrder());
            for (int i = 0; i < 5; i++) {
                maxNajavaBroj += kockice.get(i);
            }
            maxNajava.setText(String.valueOf(maxNajavaBroj));
            checkMaxNajava = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
        if (najavaCLicked == 1) {
            checkNajavaMax = true;
            noviKrug = true;
            najavaCLicked = 0;
        }
    }

    @FXML
    void MaxRucnaF(ActionEvent event) {
        Collections.sort(kockice, Collections.reverseOrder());
        for (int i = 0; i < 5; i++) {
            maxRucnaBroj += kockice.get(i);
        }
        if (checkMaxRucna == false && brojacBacanja == 1 && writeNewField == true && najavljeno == false) {
            maxRucna.setText(String.valueOf(maxRucnaBroj));
            checkMaxRucna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void MaxSlobodnaF(ActionEvent event) {
        Collections.sort(kockice, Collections.reverseOrder());
        for (int i = 0; i < 5; i++) {
            maxSlobodnaBroj += kockice.get(i);
        }
        if (checkMaxSlobodna == false && writeNewField == true && najavljeno == false) {
            maxSlobodna.setText(String.valueOf(maxSlobodnaBroj));
            checkMaxSlobodna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void MinGoreF(ActionEvent event) {
        Collections.sort(kockice);
        for (int i = 0; i < 5; i++) {
            minGoreBroj += kockice.get(i);
        }
        if (checkMinGore == false && kentaGore.getText() != "" && writeNewField == true && najavljeno == false) {
            minGore.setText(String.valueOf(minGoreBroj));
            checkMinGore = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void MinNajavaF(ActionEvent event) {
        if (checkMinNajava == false && writeNewField == true && najavljeno == true && checkNajavaMin == true) {

            Collections.sort(kockice);
            for (int i = 0; i < 5; i++) {
                minNajavaBroj += kockice.get(i);
            }
            minNajava.setText(String.valueOf(minNajavaBroj));
            checkMinNajava = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
        if (najavaCLicked == 1) {
            checkNajavaMin = true;
            noviKrug = true;
            najavaCLicked = 0;
        }
    }

    @FXML
    void MinRucnaF(ActionEvent event) {
        Collections.sort(kockice);
        for (int i = 0; i < 5; i++) {
            minRucnaBroj += kockice.get(i);
        }
        if (checkMinRucna == false && brojacBacanja == 1 && writeNewField == true && najavljeno == false) {
            minRucna.setText(String.valueOf(minRucnaBroj));
            checkMinRucna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void MinSlobodnaF(ActionEvent event) {
        Collections.sort(kockice);
        for (int i = 0; i < 5; i++) {
            minSlobodnaBroj += kockice.get(i);
        }
        if (checkMinSlobodna == false && writeNewField == true && najavljeno == false) {
            minSlobodna.setText(String.valueOf(minSlobodnaBroj));
            checkMinSlobodna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void PeticeGoreF(ActionEvent event) {
        peticeGoreBroj = ((Collections.frequency(kockice, 5)) * 5);
        if(peticeGoreBroj > 25){
            peticeGoreBroj = 25;
        }
        if (checkPeticeGore == false && sesticeGore.getText() != "" && writeNewField == true && najavljeno == false) {
            peticeGore.setText(String.valueOf(peticeGoreBroj));
            checkPeticeGore = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void PeticeNajavaF(ActionEvent event) {
        peticeNajavaBroj = ((Collections.frequency(kockice, 5)) * 5);
        if(peticeNajavaBroj > 25){
            peticeNajavaBroj = 25;
        }
        if (checkPeticeNajava == false && writeNewField == true && najavljeno == true && checkNajavaPetice == true) {
            peticeNajava.setText(String.valueOf(peticeNajavaBroj));
            checkPeticeNajava = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
        if (najavaCLicked == 1) {
            checkNajavaPetice = true;
            noviKrug = true;
            najavaCLicked = 0;
        }
    }

    @FXML
    void PeticeRucnaF(ActionEvent event) {
        peticeRucnaBroj = ((Collections.frequency(kockice, 5)) * 5);
        if(peticeRucnaBroj > 25){
            peticeRucnaBroj = 25;
        }
        if (checkPeticeRucna == false && brojacBacanja == 1 && writeNewField == true && najavljeno == false) {
            peticeRucna.setText(String.valueOf(peticeRucnaBroj));
            checkPeticeRucna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void PeticeSlobodnaF(ActionEvent event) {
        peticeSlobodnaBroj = ((Collections.frequency(kockice, 5)) * 5);
        if(peticeSlobodnaBroj > 25){
            peticeSlobodnaBroj = 25;
        }
        if (checkPeticeSlobodna == false && writeNewField == true && najavljeno == false) {
            peticeSlobodna.setText(String.valueOf(peticeSlobodnaBroj));
            checkPeticeSlobodna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void PokerGoreF(ActionEvent event) {
        if (checkPPokerGore == false && yambGore.getText() != "" && writeNewField == true && najavljeno == false) {
            pokerGoreBroj = p.getPoker(kockice);
            pokerGore.setText(String.valueOf(pokerGoreBroj));
            checkPPokerGore = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void PokerNajavaF(ActionEvent event) {
        if (checkPPokerNajava == false && writeNewField == true && najavljeno == true && checkNajavaPoker == true) {
            pokerNajavaBroj = p.getPoker(kockice);
            pokerNajava.setText(String.valueOf(pokerNajavaBroj));
            checkPPokerGore = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
        if (najavaCLicked == 1) {
            checkNajavaPoker = true;
            noviKrug = true;
            najavaCLicked = 0;
        }
    }

    @FXML
    void PokerRucnaF(ActionEvent event) {
        if (checkPPokerRucna == false && brojacBacanja == 1 && writeNewField == true && najavljeno == false) {
            pokerRucnaBroj = p.getPoker(kockice);
            pokerRucna.setText(String.valueOf(pokerRucnaBroj));
            checkPPokerRucna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void PokerSlobodnaF(ActionEvent event) {
        if (checkPPokerSlobodna == false && writeNewField == true && najavljeno == false) {
            pokerSlobodnaBroj = p.getPoker(kockice);
            pokerSlobodna.setText(String.valueOf(pokerSlobodnaBroj));
            checkPPokerSlobodna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void SesticeGoreF(ActionEvent event) {
        sesticeGoreBroj = ((Collections.frequency(kockice, 6)) * 6);
        if(sesticeGoreBroj > 30){
            sesticeGoreBroj = 30;
        }
        if (checkSesticeGore == false && maxGore.getText() != "" && writeNewField == true && najavljeno == false) {
            sesticeGore.setText(String.valueOf(sesticeGoreBroj));
            checkSesticeGore = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void SesticeNajavaF(ActionEvent event) {
        sesticeNajavaBroj = ((Collections.frequency(kockice, 6)) * 6);
        if(sesticeNajavaBroj > 30){
            sesticeNajavaBroj = 30;
        }
        if (checkSesticeNajava == false && writeNewField == true && najavljeno == true && checkNajavaSestice == true) {
            sesticeNajava.setText(String.valueOf(sesticeNajavaBroj));
            checkSesticeNajava = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
        if (najavaCLicked == 1) {
            checkNajavaSestice = true;
            noviKrug = true;
            najavaCLicked = 0;
        }
    }

    @FXML
    void SesticeRucnaF(ActionEvent event) {
        sesticeRucnaBroj = ((Collections.frequency(kockice, 6)) * 6);
        if(sesticeRucnaBroj > 30){
            sesticeRucnaBroj = 30;
        }
        if (checkSesticeRucna == false && brojacBacanja == 1 && writeNewField == true && najavljeno == false) {
            sesticeRucna.setText(String.valueOf(sesticeRucnaBroj));
            checkSesticeRucna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void SesticeSlobodnaF(ActionEvent event) {
        sesticeSlobodnaBroj = ((Collections.frequency(kockice, 6)) * 6);
        if(sesticeSlobodnaBroj > 30){
            sesticeSlobodnaBroj = 30;
        }
        if (checkSesticeSlobodna == false && writeNewField == true && najavljeno == false) {
            sesticeSlobodna.setText(String.valueOf(sesticeSlobodnaBroj));
            checkSesticeSlobodna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void TrojkeGoreF(ActionEvent event) {
        trojkeGoreBroj = ((Collections.frequency(kockice, 3)) * 3);
        if(trojkeGoreBroj > 15){
            trojkeGoreBroj = 15;
        }
        if (checkTrojkeeGore == false && cetvorkeGore.getText() != "" && writeNewField == true && najavljeno == false) {
            trojkeGore.setText(String.valueOf(trojkeGoreBroj));
            checkTrojkeeGore = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }

    }

    @FXML
    void TrojkeNajavaF(ActionEvent event) {
        trojkeNajavaBroj = ((Collections.frequency(kockice, 3)) * 3);
        if(trojkeNajavaBroj > 15){
            trojkeNajavaBroj = 15;
        }
        if (checkTrojkeeNajava == false && writeNewField == true && najavljeno == true && checkNajavaTrojke == true) {
            trojkeNavaja.setText(String.valueOf(trojkeNajavaBroj));
            checkTrojkeeNajava = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
        if (najavaCLicked == 1) {
            checkNajavaTrojke = true;
            noviKrug = true;
            najavaCLicked = 0;
        }
    }

    @FXML
    void TrojkeRucnaF(ActionEvent event) {
        trojkeRucnaBroj = ((Collections.frequency(kockice, 3)) * 3);
        if(trojkeRucnaBroj > 15){
            trojkeRucnaBroj = 15;
        }
        if (checkTrojkeeRucna == false && brojacBacanja == 1 && writeNewField == true && najavljeno == false) {
            trojkeRucna.setText(String.valueOf(trojkeRucnaBroj));
            checkTrojkeeRucna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void TrojkeSlobodnaF(ActionEvent event) {
        if(trojkeSlobodnaBroj > 15){
            trojkeSlobodnaBroj = 15;
        }
        trojkeSlobodnaBroj = ((Collections.frequency(kockice, 3)) * 3);
        if (checkTrojkeeSlobodna == false && writeNewField == true && najavljeno == false) {
            trojkeSlobodna.setText(String.valueOf(trojkeSlobodnaBroj));
            checkTrojkeeSlobodna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void YambGoreF(ActionEvent event) {
        if (checkYambeGore == false && writeNewField == true && najavljeno == false) {
            yambGoreBroj = p.getYamb(kockice);
            yambGore.setText(String.valueOf(yambGoreBroj));
            checkYambeGore = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void YambNajavaF(ActionEvent event) {
        if (checkYambeNajava == false && writeNewField == true && najavljeno == true && checkNajavaYamb == true) {
            yambNajavaBroj = p.getYamb(kockice);
            yambNajava.setText(String.valueOf(yambNajavaBroj));
            checkYambeNajava = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
        if (najavaCLicked == 1) {
            checkNajavaYamb = true;
            noviKrug = true;
            najavaCLicked = 0;
        }
    }

    @FXML
    void YambRucnaF(ActionEvent event) {
        if (checkYambeRucna == false && brojacBacanja == 1 && writeNewField == true && najavljeno == false) {
            yambRucnaBroj = p.getYamb(kockice);
            yambRucna.setText(String.valueOf(yambRucnaBroj));
            checkYambeRucna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void YambSlobodnaF(ActionEvent event) {
        if (checkYambeSlobodna == false && writeNewField == true && najavljeno == false) {
            yambSlobodnaBroj = p.getYamb(kockice);
            yambSlobodna.setText(String.valueOf(yambSlobodnaBroj));
            checkYambeSlobodna = true;
            pressNewTurn = true;
            writeNewField = false;
            brojacBacanja = 3;
        }
    }

    @FXML
    void HelpSign(MouseEvent event) {
        try {
            File file = new File("ZnaciYamb.txt");
            if (!Desktop.isDesktopSupported()) {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (file.exists())
                desktop.open(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void OpenRules(ActionEvent event) {
        try {
            File file = new File("PravilaYamb.txt");
            if (!Desktop.isDesktopSupported()) {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (file.exists())
                desktop.open(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ExitGame(ActionEvent event) {
        System.exit(0);
    }

}
