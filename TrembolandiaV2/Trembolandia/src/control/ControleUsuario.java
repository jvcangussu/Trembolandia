package control;

import java.time.LocalDate;
import java.util.ArrayList;

import data.DataUsuario;
import model.Usuario;

public class ControleUsuario {
    private DataUsuario dataUsuario = new DataUsuario();

    public String retornarUsername(Usuario u){
        return u.getUsername();
    }

    public void cadastrarUsuario(String username, String senha, String nome, boolean genero, LocalDate dataNasc){
        Usuario user = new Usuario(username, senha, nome, genero, dataNasc);
        dataUsuario.createUsuario(user);
    }

    public Usuario pesquisarUsuario(String username){
        return dataUsuario.readUsuario(username);
    }

    public void removerUsuario(String username){
        dataUsuario.deleteUsuario(pesquisarUsuario(username));
    }

    public void atualizarUsuario(Usuario usuario){
        dataUsuario.updateUsuario(usuario);
    }

    public boolean loginUsuario(String username, String senha){
        if(pesquisarUsuario(username) == null){
            return false;
        } else if(username.equals(pesquisarUsuario(username).getUsername())){
            if(senha.equals(pesquisarUsuario(username).getSenha())){
                return true;
            }
        }
        return false;
    }

    public String imprimirUsuarios(){
        ArrayList<Usuario> usuarios = dataUsuario.getAllUsuarios();
        String lista = "";
        for(int i = 0; i < usuarios.size(); i++){
            lista += usuarios.get(i).toString() + "\n";
        }
        return lista;
    }
}
