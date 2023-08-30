package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Usuario;

public class DataUsuario {    
    String nomeArq = "usuarios.ser";

    private void updateArq(ArrayList<Usuario> usuarios){
        try{
            FileOutputStream fluxo = new FileOutputStream(nomeArq);
            ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
            escreverObj.writeObject(usuarios);
            escreverObj.close();          
           } catch (FileNotFoundException ex) {
            System.out.println ("Erro ao atualizar usuários");
           } catch (IOException ex) {
            System.out.println ("Erro ao atualizar usuários");
        }
    }
    
    public ArrayList<Usuario> getAllUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        FileInputStream fluxo;
        ObjectInputStream lerObj = null;

        try{
            fluxo = new FileInputStream(nomeArq);
            lerObj = new ObjectInputStream(fluxo);
            usuarios = (ArrayList<Usuario>)lerObj.readObject();            
        } catch(ClassNotFoundException | IOException ex) {
            System.out.println ("Erro ao listar os usuários");
        }
        return usuarios;
    }

    public void createUsuario(Usuario user){
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>)getAllUsuarios();
        usuarios.add(user);
        try{
            FileOutputStream fluxo = new FileOutputStream(nomeArq);
            ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
            escreverObj.writeObject(usuarios);
            escreverObj.close();          
        } catch (IOException ex) {
            System.out.println ("Erro ao cadastrar usuário");
        }
    }

    public Usuario readUsuario(String username){
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>)getAllUsuarios();
        Usuario user = null;
        for (int i = 0; i < usuarios.size(); i++){
            if (username.equals(usuarios.get(i).getUsername())){
                user = usuarios.get(i);
                break;
            }
        }
        return user;
    }
    
    public void updateUsuario(Usuario user){
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>)getAllUsuarios();
        boolean achou = false;
        for (int i = 0; i < usuarios.size(); i++){
            if (user.getUsername().equals(usuarios.get(i).getUsername())){
                usuarios.remove(i);
                usuarios.add(user);
                achou=true;
                break;
            }
        }
        if(achou){
            updateArq(usuarios);
        }
    }
    
    public void deleteUsuario(Usuario user){
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>)getAllUsuarios();
        boolean achou=false;
        for (int i = 0; i < usuarios.size(); i++){
            if(user.getUsername().equals(usuarios.get(i).getUsername())){
                usuarios.remove(i);
                achou=true;
                break;
            }
        }
        if (achou){
            updateArq(usuarios);
        }
    }
}
