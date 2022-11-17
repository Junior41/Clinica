/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica;

/**
 *
 * @author junior
 */
public class Filho {
    private String nome, dataNascimento;
    private char sexo;
    private float altura, peso;

    public Filho() {
    }

    public Filho(String nome, String dataNascimento, char sexo, float altura, float peso) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    public void imprimeFilho(){
        System.out.println("Nome: " + this.nome + 
                "\nData Nascimento: " + this.dataNascimento +
                "\nSexo: " + this.sexo +
                "\nAltura: " + this.altura +
                "\nPeso: " + this.peso);
    }
    
    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public float getAltura() {
        return altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    
    
}
