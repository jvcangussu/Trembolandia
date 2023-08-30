package fxmlControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import control.ControleUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Dieta;
import model.Treino;
import model.Usuario;

public class TelaDietaController extends IController implements Initializable {

    ControleUsuario cUsuario = new ControleUsuario();

    @FXML
    private Button botaoCompletarCadastro;

    @FXML
    private Button botaoVerDieta;

    @FXML
    private ChoiceBox<String> choiceAtividadeFisica;
    private String[] atividadesFisica = {"Entre 0 e 2 dias na semana", "Entre 3 e 5 dias na semana", "Entre 6 e 7 dias na semana"}; 

    @FXML
    private ChoiceBox<String> choiceObjetivo;
    private String[] objetivos = {"Manutenção do peso", "Emagrecer", "Ganhar massa"}; 

    @FXML
    private Label labelDieta;

    @FXML
    private Label labelStatusDieta;

    @FXML
    void completarCadastro(ActionEvent event) throws IOException {
        // Carrega o arquivo fxml e cria um novo stage para a janela popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TelaCompletarCadastroController.class.getResource("/fxml/telaCompletarCadastro.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            // Cria o palco dialogStage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Trembolândia - Dieta");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            TelaCompletarCadastroController controller = loader.getController();
            controller.setDialogStage(dialogStage);
           
            dialogStage.showAndWait();
            Usuario aux = cUsuario.pesquisarUsuario(loginInstanciado);
            aux.setPeso(controller.getPeso());
            aux.setAltura(controller.getAltura());
            cUsuario.atualizarUsuario(aux);
    }

    @FXML
    void mostrarDieta(ActionEvent event) {
        if (!(choiceAtividadeFisica.getValue() == null) && !(choiceObjetivo.getValue() == null)){
            labelStatusDieta.setText("");
            int opatividade = 0;
            switch(choiceAtividadeFisica.getValue()){
                case "Entre 0 e 2 dias na semana": {
                    opatividade = 1;
                    break;
                }
                case "Entre 3 e 5 dias na semana": {
                    opatividade = 2;
                    break;
                }
                case "Entre 6 e 7 dias na semana": {
                    opatividade = 3;
                    break;
                }
            }

            int opdieta = 1;
            switch(choiceObjetivo.getValue()){
                case "Manutenção do peso": {
                    opdieta = 1;
                    break;
                }
                case "Emagrecer": {
                    opdieta = 2;
                    break;
                }
                case "Ganhar massa": {
                    opdieta = 3;
                    break;
                }
            }
            Dieta dieta = new Dieta(cUsuario.pesquisarUsuario(loginInstanciado), opdieta, opatividade);
            String texto = "";
            texto += dieta.calcularIMC() + "\n";
            texto += dieta.imprimirDieta() + "\n";
            labelDieta.setText(texto);
        } else {
            labelStatusDieta.setText("Selecione ambos os campos");
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceAtividadeFisica.getItems().addAll(atividadesFisica);
        choiceObjetivo.getItems().addAll(objetivos);
    }

}
