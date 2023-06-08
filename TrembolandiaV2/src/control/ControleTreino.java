package control;

import java.util.ArrayList;
import data.DataTreino;
import data.DataUsuario;
import model.Treino;
import model.Usuario;
import control.ControleUsuario;

public class ControleTreino{
    private DataTreino dataTreino = new DataTreino();
    private DataUsuario dataUsuario = new DataUsuario();

    public Treino criarTreino(Usuario u, int dias, String nome) throws Exception{
        Treino t = new Treino(u, dias, nome);
        dataTreino.createTreino(t);
        return t;
    }

    public ArrayList<Treino> listarTreinos() throws Exception{
        ArrayList <Treino> treinos = (ArrayList<Treino>)dataTreino.getAllTreinos();
        return treinos;
    }

    public Treino pesquisarTreino(int codigo) throws Exception{
        Treino t = dataTreino.readTreino(codigo);
        return t;
    }

    public int retornarCodigo(Treino t){
        return t.getCodigo();
    }

    public Usuario retornarUsuario(Treino t){
        return t.getUsuario();
    }

    public void atualizarTreino(int cod) throws Exception{
        Treino t = pesquisarTreino(cod);
        dataTreino.updateTreino(t);
    }

    /*public Treino pesquisarTreino(Usuario u) throws Exception{
        ArrayList <Usuario> usuarios = dataUsuario.getAllUsuarios();
        String username = pesquisarUsuario(u);
        return t;
    }*/


    public void trocarExercicio(int codigo, String exercicioTrocado) throws Exception{
        Treino t = pesquisarTreino(codigo);
        t.trocarExercicio(exercicioTrocado);
        dataTreino.updateTreino(t);
    }

    public String imprimirTreino(int codigo) throws Exception{
        Treino t = pesquisarTreino(codigo);
        return t.imprimirTreino();
    }

    public void deletarTreino(int codigo) throws Exception{
        Treino t = pesquisarTreino(codigo);
        dataTreino.deleteTreino(t);
    }
}
