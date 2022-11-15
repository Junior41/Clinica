/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica;

/**
 *
 * @author junior
 */
public class Parto {
    private Filho filho;
    private Medico medico;
    private Mae mae;

    public Parto() {
    }

    public Parto(Filho filho, Medico medico, Mae mae) {
        this.filho = filho;
        this.medico = medico;
        this.mae = mae;
    }

    public Filho getFilho() {
        return filho;
    }

    public Medico getMedico() {
        return medico;
    }

    public Mae getMae() {
        return mae;
    }

    public void setFilho(Filho filho) {
        this.filho = filho;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setMae(Mae mae) {
        this.mae = mae;
    }
    
    
}
