package fxmlControllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import control.ControleUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class TelaPrincipalController extends IController implements Initializable {

    @FXML
    private AnchorPane anchorPaneInfos;

    @FXML
    private AnchorPane anchorPaneMenu;

    @FXML
    private AnchorPane anchorPaneTesteLogin;

    @FXML
    private Label labelNome;

    @FXML
    private Button sairParaLogin;
    
    @FXML
    private Button botaoTreinos;

    @FXML
    private Button botaoMacronutrientes;

    @FXML
    private ImageView profilePhotoImageView;

    @FXML
    private Button botaoPlus;

    private Stage stage;

    public void onSelectProfilePhoto(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Photo", "*.jpg", "*.jpeg", "*.png"));

        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            String imagePath = selectedFile.toURI().toString();
            Image profilePhoto = new Image(imagePath);
            profilePhotoImageView.setImage(profilePhoto);
        }
    }

    @FXML
    void irParaLogin(ActionEvent event) throws IOException {
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("../fxml/login.fxml"));
        Parent login = loginLoader.load();
        anchorPaneTesteLogin.getChildren().setAll(login);
    }

    @FXML
    void irParaTreinos(ActionEvent event) throws IOException {
        FXMLLoader treinosLoader = new FXMLLoader(getClass().getResource("../fxml/telaTreinos.fxml"));
        Parent treinos = treinosLoader.load();
        anchorPaneInfos.getChildren().setAll(treinos);
    }
    
    @FXML
    void irParaMacronutrientes(ActionEvent event) throws IOException {
        FXMLLoader dietaLoader = new FXMLLoader(getClass().getResource("../fxml/telaDieta.fxml"));
        Parent dieta = dietaLoader.load();
        anchorPaneInfos.getChildren().setAll(dieta);
    }

    @FXML
    void irParaPlus(ActionEvent event) throws IOException {
        FXMLLoader plusLoader = new FXMLLoader(getClass().getResource("../fxml/telaPlus.fxml"));
        Parent plus = plusLoader.load();
        anchorPaneInfos.getChildren().setAll(plus);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ControleUsuario cUsuario = new ControleUsuario();
        labelNome.setText("Olá " + cUsuario.pesquisarUsuario(super.loginInstanciado).getNome());
    }

}
