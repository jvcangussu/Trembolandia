package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario implements Serializable{
    //Atributos
    private String username;
    private String senha;
    private String nome;
    private boolean genero;
    private LocalDate dataNascimento;
    private ArrayList<Treino> treinos = new ArrayList<>();
    
    //Construtores
    public Usuario(String username, String senha){
        this.username = username;
        this.senha = senha;
        this.nome = "";
        this.genero = false;
        this.dataNascimento = null;
    }
    public Usuario(String username, String senha, String nome){
        this.username = username;
        this.senha = senha;
        this.nome = nome;
        this.genero = false;
        this.dataNascimento = null;
    }
    public Usuario(String username, String senha, String nome, boolean genero, LocalDate dataNasc){
        this.username = username;
        this.senha = senha;
        this.nome = nome;
        this.genero = genero;
        this.dataNascimento = dataNasc;
    }

    //Getters e Setters
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public boolean isGenero() {
        return genero;
    }
    public void setGenero(boolean genero) {
        this.genero = genero;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Treino> getTreinos(){
        return treinos;
    }

    public void adicionarTreino(Treino treino){
        treinos.add(treino);
    }

    @Override
    public String toString(){
        String gen;
        if(isGenero())
            gen = "Masculino";
        else
            gen = "Feminino";

        return "Username: " + getUsername() + "\nNome: " + getNome() + "\nGênero: " + gen + "\nData de Nascimento: " + getDataNascimento().toString();
    }
}
