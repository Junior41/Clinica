/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clinica;

/**
 *
 * @author junior
 */
public class Clinica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ConexaoBD conexao = new ConexaoBD();
        /*
        float peso = (float)3.4;
        float altura = (float)4.0;
        
        Mae mae = new Mae("15966898707", "Maria", "2001-07-24", "Jagauré ES", "27 996323381");
        conexao.cadastrarMae(mae);
        Medico medico = new Medico(145, "dadin", "clinico geral");
        conexao.cadastrarMedico(medico);
        Filho filho = new Filho("Junior", "2001-07-24 00:10:00", 'M', peso, altura);
        Parto parto = new Parto(filho, medico, mae);
        
        conexao.cadastrarParto(parto);
        */
        /*
        Mae mae = conexao.buscaMae("1596689870");
        if(mae != null)
            mae.imprimeMae();
        else
            System.out.println("Mae não encontrada.");
        
        Medico medico = conexao.buscaMedico(145);
        
        if(medico != null)
            medico.imprimeMedico();
        else
            System.out.println("Medico n encontrado");
        */
        /*
        Filho filho = conexao.buscaFilho(2);
        
        if(filho != null)
            filho.imprimeFilho();
        else
            System.out.println("Filho n encontrado");
        */
        //conexao.ListarPartos();
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
}
    
}
