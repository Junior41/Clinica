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
    private String nome, especializacao;

    public Medico(int CRM, String nome, String especializacao) {
        this.CRM = CRM;
        this.nome = nome;
        this.especializacao = especializacao;
    }

    public Medico() {
    }

    public int getCRM() {
        return CRM;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setCRM(int CRM) {
        this.CRM = CRM;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
    
    
}
