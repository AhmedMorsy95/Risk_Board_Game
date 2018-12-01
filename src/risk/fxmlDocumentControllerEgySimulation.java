/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//For the damaged *code* :(
package risk;

import java.net.URL;
import java.util.ResourceBundle;

import application.SampleController;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author smsm
 */
public class fxmlDocumentControllerEgySimulation implements Initializable {

    GameSimulator riskEgy = new GameSimulator(SampleController.player1, SampleController.player2, Player.EGYPT_TERRITORIES, 5);

    @FXML
    private Label turn2;

    @FXML
    private Label turn1;

    @FXML
    private ImageView dice2_1;

    @FXML
    private ImageView dice2_2;

    @FXML
    private ImageView dice2_3;

    @FXML
    private ImageView dice1_1;

    @FXML
    private ImageView dice1_2;

    @FXML
    private ImageView dice1_3;

    @FXML
    private Button yallaButton;
    @FXML
    private MenuButton startMenu;
    @FXML
    private MenuButton endMenu;
    @FXML
    private TextArea gameStatus;

    @FXML
    private TextField player1_soldiers;

    @FXML
    private TextField player2_soldiers;

    @FXML
    private ImageView distribute;
    @FXML
    private Rectangle rec0 = new Rectangle();
    @FXML
    private Rectangle rec1 = new Rectangle();
    @FXML
    private Rectangle rec2 = new Rectangle();
    @FXML
    private Rectangle rec3 = new Rectangle();
    @FXML
    private Rectangle rec4 = new Rectangle();
    @FXML
    private Rectangle rec5 = new Rectangle();
    @FXML
    private Rectangle rec6 = new Rectangle();
    @FXML
    private Rectangle rec7 = new Rectangle();
    @FXML
    private Rectangle rec8 = new Rectangle();
    @FXML
    private Rectangle rec9 = new Rectangle();
    @FXML
    private Rectangle rec10 = new Rectangle();
    @FXML
    private Rectangle rec11 = new Rectangle();
    @FXML
    private Rectangle rec12 = new Rectangle();
    @FXML
    private Rectangle rec13 = new Rectangle();
    @FXML
    private Rectangle rec14 = new Rectangle();
    @FXML
    private Rectangle rec15 = new Rectangle();
    @FXML
    private Rectangle rec16 = new Rectangle();
    @FXML
    private Rectangle rec17 = new Rectangle();
    @FXML
    private Rectangle rec18 = new Rectangle();
    @FXML
    private Rectangle rec19 = new Rectangle();
    @FXML
    private Rectangle rec20 = new Rectangle();
    @FXML
    private Rectangle rec21 = new Rectangle();
    @FXML
    private Rectangle rec22 = new Rectangle();
    @FXML
    private Rectangle rec23 = new Rectangle();
    @FXML
    private Rectangle rec24 = new Rectangle();
    @FXML
    private Rectangle rec25 = new Rectangle();
    @FXML
    private Rectangle rec26 = new Rectangle();

    private Rectangle countryLabels[] = new Rectangle[Player.EGYPT_TERRITORIES];



    ArrayList<Image> dices = new ArrayList<>();

    public void load() {
        for (int i = 1; i < 7; i++) {
            dices.add(new Image(getClass().getResource("/media/"+ i +".png").toExternalForm()));
        }
    }

    public void loadRect() {
        countryLabels[0] = rec0;
        countryLabels[1] = rec1;
        countryLabels[2] = rec2;
        countryLabels[3] = rec3;
        countryLabels[4] = rec4;
        countryLabels[5] = rec5;
        countryLabels[6] = rec6;
        countryLabels[7] = rec7;
        countryLabels[8] = rec8;
        countryLabels[9] = rec9;
        countryLabels[10] = rec10;
        countryLabels[11] = rec11;
        countryLabels[12] = rec12;
        countryLabels[13] = rec13;
        countryLabels[14] = rec14;
        countryLabels[15] = rec15;
        countryLabels[16] = rec16;
        countryLabels[17] = rec17;
        countryLabels[18] = rec18;
        countryLabels[19] = rec19;
        countryLabels[20] = rec20;
        countryLabels[21] = rec21;
        countryLabels[22] = rec22;
        countryLabels[23] = rec23;
        countryLabels[24] = rec24;
        countryLabels[25] = rec25;
        countryLabels[26] = rec26;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void yalla(MouseEvent action) {
        riskEgy.play();
        //printing soldiers
        System.out.println("Attacking Mode");
        for (int i = 0; i < GameSimulator.first.soldier_of_each_territory.length; i++) {
            System.out.print(GameSimulator.first.soldier_of_each_territory[i] + " ");
        }
        System.out.println("\n");

        for (int i = 0; i < GameSimulator.second.soldier_of_each_territory.length; i++) {
            System.out.print(GameSimulator.second.soldier_of_each_territory[i] + " ");
        }
        System.out.println("\n");
        load();
        checkTheRectangles();
        changeGameStatus();
    }

    public void checkTheRectangles() {

        loadRect();
        for (int i = 0; i < Player.EGYPT_TERRITORIES; i++) {
            if (GameSimulator.first.getTerritories().contains(i)) {
                countryLabels[i].setFill(GameSimulator.first.getColor());
            } else {
                countryLabels[i].setFill(GameSimulator.second.getColor());
            }

        }
    }



    public void changeGameStatus() {
        gameStatus.clear();
        if (GameSimulator.first.isMyTurn()) {
            turn2.setVisible(false); // <---------ok  asdk en hwa mshhowa m7 shby
            turn1.setVisible(true); // Feh moshkla fel stren ly wra b3 d? ah fhmt bs msh dh m3nah en turn mt8yrsh ?
        } else if (GameSimulator.second.isMyTurn()) {//turn msh htt8yyr ella lw first et8yyrt .. "*first turn mt8yyrsh*" ok let's C3
            turn1.setVisible(false);
            turn2.setVisible(true);
        }

        dice1_1.setImage(new Image(getClass().getResource("/media/No.png").toExternalForm()));
        dice1_2.setImage(new Image(getClass().getResource("/media/No.png").toExternalForm()));
        dice1_3.setImage(new Image(getClass().getResource("/media/No.png").toExternalForm()));
        dice2_1.setImage(new Image(getClass().getResource("/media/No.png").toExternalForm()));
        dice2_2.setImage(new Image(getClass().getResource("/media/No.png").toExternalForm()));
        dice2_3.setImage(new Image(getClass().getResource("/media/No.png").toExternalForm()));

        if (GameSimulator.status.didAttack == false) {
            gameStatus.appendText("Couldn't attack");
            return;
        }
        System.out.println(GameSimulator.status.dice1);
        switch (GameSimulator.status.dice1.size()) {
            case 3:
                dice1_1.setImage(dices.get(GameSimulator.status.dice1.get(0)-1));
                dice1_2.setImage(dices.get(GameSimulator.status.dice1.get(1)-1));
                dice1_3.setImage(dices.get(GameSimulator.status.dice1.get(2)-1));
                break;
            case 2:
                dice1_1.setImage(dices.get(GameSimulator.status.dice1.get(0)-1));
                dice1_2.setImage(dices.get(GameSimulator.status.dice1.get(1)-1));
                break;
            case 1:
                dice1_1.setImage(dices.get(GameSimulator.status.dice1.get(0)-1));
                break;
            default:
                break;
        }
        System.out.println(GameSimulator.status.dice2);
        switch (GameSimulator.status.dice2.size()) {
            case 3:
                dice2_1.setImage(dices.get(GameSimulator.status.dice2.get(0)-1));
                dice2_2.setImage(dices.get(GameSimulator.status.dice2.get(1)-1));
                dice2_3.setImage(dices.get(GameSimulator.status.dice2.get(2)-1));
                break;

            case 2:
                dice2_1.setImage(dices.get(GameSimulator.status.dice2.get(0)-1));
                dice2_2.setImage(dices.get(GameSimulator.status.dice2.get(1)-1));
                break;
            case 1:
                dice2_1.setImage(dices.get(GameSimulator.status.dice2.get(0)-1));
                break;
            default:
                break;
        }

        gameStatus.appendText("Attacking Soldiers: " + GameSimulator.status.soldiersFrom + "\r\n"
                + "Defending Soldiers:\n" + GameSimulator.status.soldiersTo + "\r\n"
                + "From: " + GameSimulator.status.from + "\r\n"
                + "To: " + GameSimulator.status.to + "\r\n"
                + "didAttackerInvade:\n " + GameSimulator.status.didAttackerInvade + "\r\n"
                + "didAttackerWin:\n " + GameSimulator.status.didAttackerWin + "\r\n"
        );
    }
}
