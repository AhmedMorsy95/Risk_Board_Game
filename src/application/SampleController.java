package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SampleController {

    @FXML
    private Button sim;

    @FXML
    private ImageView riskimage;
    @FXML
    private Button playingButton;

    @FXML
    void simulationClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AgentChoice.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }
    
    @FXML
    void playClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("player2Choice.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply1_passive_button(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Player2Choice.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply1_aggressive_button(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Player2Choice.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply1_pacifist_button(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Player2Choice.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply1_greedy_button(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Player2Choice.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply1_astars_button(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Player2Choice.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply1_realtime_button(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Player2Choice.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply1_minimax_button(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Player2Choice.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }
    
      @FXML
    void ply2_passive_button(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MapChoice.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply2_aggressive_button(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MapChoice.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply2_pacifist_button(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MapChoice.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply2_greedy_button(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MapChoice.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply2_astars_button(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MapChoice.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply2_realtime_button(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MapChoice.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply2_minimax_button(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MapChoice.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }
    
      @FXML
    void egyptSelected(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/risk/FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void USASelected(ActionEvent event) {

    }

}
