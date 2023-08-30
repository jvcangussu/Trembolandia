package fxmlControllers;

import java.net.URL;
import java.util.ResourceBundle;

import control.ControleUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Treino;

public class TelaAddTreinoController extends IController implements Initializable{
    ControleUsuario cUsuario = new ControleUsuario();

    private Treino treino;
    
    public Treino getTreino() {
        return treino;
    }

    private Stage dialogStage;
        
    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private ChoiceBox<String> campoDiasTreino;
    private String[] dias = {"3 dias", "4 dias", "5 dias"};
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        campoDiasTreino.getItems().addAll(dias);
    }   

    @FXML
    private TextField campoNomeTreino;

    @FXML
    private Label labelStatusAddTreino;

    @FXML
    private Button botaoAdicionarTreino;

    @FXML
    private Button botaoCancelar;

    @FXML
    private void addTreino(ActionEvent event) throws Exception {
        //Testa se os campos não estão vazios
        if (!campoNomeTreino.getText().isEmpty() && !campoDiasTreino.getValue().isEmpty()){
            String nome = campoNomeTreino.getText().toUpperCase();
            int dias;
            if(campoDiasTreino.getValue().equals("3 dias")){
                dias = 3;
            } else if (campoDiasTreino.getValue().equals("4 dias")) {
                dias = 4;
            } else {
                dias = 5;
            }
            this.treino = new Treino(cUsuario.pesquisarUsuario(loginInstanciado), dias, nome);
           
            this.dialogStage.close();
        }
        else{
            labelStatusAddTreino.setText ("Dados Inválidos");
            campoNomeTreino.requestFocus();
        }
    }

    @FXML
    private void cancelarTreino(ActionEvent event) {
        this.dialogStage.close();
    }
}

