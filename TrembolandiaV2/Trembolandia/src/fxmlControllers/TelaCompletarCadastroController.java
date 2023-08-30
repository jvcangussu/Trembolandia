package fxmlControllers;

import java.net.URL;
import java.util.ResourceBundle;

import control.ControleUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Treino;

public class TelaCompletarCadastroController extends IController implements Initializable {
    ControleUsuario cUsuario = new ControleUsuario();
    private Stage dialogStage;
    private double peso;
    private double altura;    
        
    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private Button botaoEnviarCadastro;

    @FXML
    private TextField campoAltura;

    @FXML
    private TextField campoPeso;
    
    @FXML
    private Label labelStatusCompletar;

    @FXML
    void enviarCadastro(ActionEvent event) {
        //Testa se os campos não estão vazios
        if (!campoAltura.getText().isEmpty() && !campoPeso.getText().isEmpty()){
            peso = Double.parseDouble(campoPeso.getText());
            altura = Double.parseDouble(campoAltura.getText());           
            this.dialogStage.close();
        }
        else{
            labelStatusCompletar.setText ("Dados Inválidos");
            campoPeso.requestFocus();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        campoPeso.setText(String.valueOf(cUsuario.pesquisarUsuario(loginInstanciado).getPeso()));
        campoAltura.setText(String.valueOf(cUsuario.pesquisarUsuario(loginInstanciado).getAltura()));
    }

}
