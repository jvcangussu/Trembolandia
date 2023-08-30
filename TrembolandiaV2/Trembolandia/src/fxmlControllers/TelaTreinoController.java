package fxmlControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import control.ControleTreino;
import control.ControleUsuario;
import data.DataTreino;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Treino;

public class TelaTreinoController extends IController implements Initializable {
    ControleUsuario cUsuario = new ControleUsuario();
    ControleTreino cTreino = new ControleTreino();

    @FXML
    private TableColumn<?, ?> tableColumnCodigo;

    @FXML
    private TableColumn<?, ?> tableColumnDivisao;

    @FXML
    private TableColumn<?, ?> tableColumnNome;

    @FXML
    private TableView<Treino> tableTreinos;
    private DataTreino dataTreino = new DataTreino();

    @FXML
    private Button botaoAddTreino;

    @FXML
    private Button botaoDeleteTreino;

    @FXML
    private Button botaoShowTreino;

    public void iniciarTabelaTreinos(){
        tableColumnCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        tableColumnNome.setCellValueFactory(new PropertyValueFactory("nome"));
        tableColumnDivisao.setCellValueFactory(new PropertyValueFactory("dias"));
        try{
            ArrayList<Treino> listaTreinos = (ArrayList<Treino>)cTreino.listarTreinos();
            ArrayList<Treino> treinosUsuario = new ArrayList<>();
            for(Treino t: listaTreinos){
                if(cUsuario.retornarUsername(cTreino.retornarUsuario(t)).equals(loginInstanciado)){
                    treinosUsuario.add(t);
                }
            }
            ObservableList obsListTreinos = FXCollections.observableArrayList(treinosUsuario);
            tableTreinos.setItems(obsListTreinos);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void adicionarTreino(ActionEvent event) throws IOException, Exception {
        // Carrega o arquivo fxml e cria um novo stage para a janela popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TelaAddTreinoController.class.getResource("/fxml/telaAddTreino.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            // Cria o palco dialogStage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Trembolândia - Treino");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            TelaAddTreinoController controller = loader.getController();
            controller.setDialogStage(dialogStage);
           
            dialogStage.showAndWait();
            Treino treino = controller.getTreino();
            if (treino!=null){
                this.dataTreino.createTreino(treino);
            }
            
            iniciarTabelaTreinos();
    }

    @FXML
    private void mostrarTreino(ActionEvent event) throws IOException, Exception {
        Treino treino = tableTreinos.getSelectionModel().getSelectedItem();
        super.codigoTreinoInstanciado = treino.getCodigo();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(TelaMostrarTreinoController.class.getResource("/fxml/telaMostrarTreino.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Trembolândia - Treino");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        TelaMostrarTreinoController controller = loader.getController();
        controller.setDialogStage(dialogStage);
           
        dialogStage.showAndWait();            
        iniciarTabelaTreinos();
    }

    @FXML
    private void removerTreino(ActionEvent event) throws Exception {
        Treino treino = tableTreinos.getSelectionModel().getSelectedItem();
        dataTreino.deleteTreino(treino);
        iniciarTabelaTreinos();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciarTabelaTreinos();
    }

}
