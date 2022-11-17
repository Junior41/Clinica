/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica;

/**
 *
 * @author junior
 */
public class Medico {
    private int CRM;
    private String nome, especialidade;

    public Medico(int CRM, String nome, String especialidade) {
        this.CRM = CRM;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public Medico() {
    }
    
    public void imprimeMedico(){
        System.out.println("CRM: " + this.CRM + 
                "\nNome: " + this.nome + 
                "\nEspecializacao: " + this.especialidade);
    }

    public int getCRM() {
        return CRM;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setCRM(int CRM) {
        this.CRM = CRM;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    
}
