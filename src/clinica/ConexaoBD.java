
package clinica;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConexaoBD {
    
    // Seção Atributos/Variaveis iniciais
    
    private String caminho = "172.17.0.2"; //  indica que usaremos o serve na maquina local
    private String porta = "3306"; // Porta padrão do MySQL
    private String nome = "clinica";
    private String usuario = "root";
    private String senha = "root";
    private String FusoHoraio = "?useTimeZone=true&serverTimezone=UTC"; //ajustar horario com a Oracle
    
    private String URL = "jdbc:mysql://"+caminho+":"+porta+"/"+nome+FusoHoraio;
    
    
    public ConexaoBD(){
        
    }
    
    public Connection realizaConexaoMySQL(){
        try{
            Connection connection =  DriverManager.getConnection(URL, usuario, senha);
            //System.out.println("Conectado.");
            return connection;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e, "erro", 0);
            return null;
        }
    }
    
    public void desconectaMySQL(Connection conexao){
         try{
            if(conexao != null)
                conexao.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e, "erro", 0);
        }
    }
    public List<Mae> ListarMaes(){
        List<Mae> maes = new ArrayList<Mae>();
        
        Connection conexao = realizaConexaoMySQL();
        
        String selecionaMaes = "SELECT * FROM clinica.mae";

        try {
            PreparedStatement preparadorMae = conexao.prepareStatement(selecionaMaes);

            ResultSet resultadoMae = preparadorMae.executeQuery();
            
            while(resultadoMae.next()){

                Mae mae = new Mae(resultadoMae.getString("CPF"),
                        resultadoMae.getString("nome"),
                        resultadoMae.getString("dataNacimento"),
                        resultadoMae.getNString("endereco"),
                        resultadoMae.getNString("telefone"));
                
                //mae.imprimeMae();
                
                maes.add(mae);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e, "erro", 0);
        }
        
        desconectaMySQL(conexao);
        
        return maes;
    }
    
    public List<Medico> ListarMedicos(){
        List<Medico> medicos = new ArrayList<Medico>();
        
        Connection conexao = realizaConexaoMySQL();
        
        String selecionaMedicos = "SELECT * FROM clinica.medico";

        try {
            PreparedStatement preparadorMedico = conexao.prepareStatement(selecionaMedicos);

            ResultSet resultadoMedico = preparadorMedico.executeQuery();
            
            while(resultadoMedico.next()){

                Medico medico = new Medico(resultadoMedico.getInt("CRM"),
                        resultadoMedico.getString("nome"),
                        resultadoMedico.getString("especialidade"));
                
                //medico.imprimeMedico();
                
                medicos.add(medico);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e, "erro", 0);
        }
        
        desconectaMySQL(conexao);
        
        return medicos;
    }
    
    
    public boolean cadastrarMae(Mae mae){
        
        Connection conexao = realizaConexaoMySQL();
        
        String insereMae = "INSERT INTO clinica.mae (nome, dataNacimento,"
                + "CPF, telefone, endereco) VALUES (?,?,?,?,?)";
        
        try{
            
            PreparedStatement preparadorMae = conexao.prepareStatement(insereMae);
            
            preparadorMae.setString(1, mae.getNome());
            preparadorMae.setString(2, mae.getDataNascimento());
            preparadorMae.setString(3, mae.getCPF());
            preparadorMae.setString(4, mae.getTelefone());
            preparadorMae.setString(5, mae.getEndereco());
            
            preparadorMae.execute();
            
            desconectaMySQL(conexao);
            
            return true;
        }catch(java.sql.SQLIntegrityConstraintViolationException e){
            JOptionPane.showMessageDialog(null, "O CPF informado já foi cadastrado.","erro", 0);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e, "erro", 0);
        }
        
        desconectaMySQL(conexao);
        
        return false;
    }
    
    public boolean cadastrarMedico(Medico medico){
        
        Connection conexao = realizaConexaoMySQL();
        
        String insereMae = "INSERT INTO clinica.medico (nome, CRM,"
                + "especialidade) VALUES (?,?,?)";
        
        try{
            
            PreparedStatement preparadorMae = conexao.prepareStatement(insereMae);
            
            preparadorMae.setString(1, medico.getNome());
            preparadorMae.setInt(2, medico.getCRM());
            preparadorMae.setString(3, medico.getEspecialidade());
            
            preparadorMae.execute();
            
            desconectaMySQL(conexao);
            
            return true;
        }catch(java.sql.SQLIntegrityConstraintViolationException e){
            JOptionPane.showMessageDialog(null, "O CRM informado já foi cadastrado.","erro", 0);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e, "erro", 0);
        }
        
        desconectaMySQL(conexao);
        
        return false;
    }
     
    public Mae buscaMae(String CPF){
        Mae resultado =  null;
        Connection conexao = realizaConexaoMySQL();
        resultado = null;
        
        String sql = "SELECT * FROM clinica.mae WHERE mae.CPF='"+ CPF + "';";
        
        try{
            PreparedStatement preparador = conexao.prepareStatement(sql);
            
            ResultSet res = preparador.executeQuery();
            
            while (res.next()){
                resultado = new Mae();
                resultado.setCPF(CPF);
                resultado.setNome(res.getString("nome"));
                resultado.setDataNascimento(res.getString("dataNacimento"));
                resultado.setEndereco(res.getString("endereco"));
                resultado.setTelefone(res.getString("telefone"));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e,"erro",0);
        }
        
        desconectaMySQL(conexao);
        
        return resultado;
        
    }
    public Filho buscaFilho(int id){
        Filho resultado =  null;
        Connection conexao = realizaConexaoMySQL();
        resultado = null;
        
        String sql = "SELECT * FROM clinica.filho WHERE filho.idFilho='"+ id + "';";
        
        try{
            PreparedStatement preparador = conexao.prepareStatement(sql);
            
            ResultSet res = preparador.executeQuery();
            
            while (res.next()){
                resultado = new Filho();
                resultado.setNome(res.getString("nome"));
                resultado.setDataNascimento(res.getString("dataNascimento"));
                resultado.setSexo(res.getString("sexo").toCharArray()[0]);
                resultado.setPeso(res.getFloat("peso"));
                resultado.setAltura(res.getFloat("altura"));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e,"erro",0);
        }
        
        desconectaMySQL(conexao);
        
        return resultado;
        
    }
    public Medico buscaMedico(int CRM){
        Medico resultado =  null;
        Connection conexao = realizaConexaoMySQL();
        resultado = null;
        
        String sql = "SELECT * FROM clinica.medico WHERE medico.CRM='"+ CRM + "';";
        
        try{
            PreparedStatement preparador = conexao.prepareStatement(sql);
            
            ResultSet res = preparador.executeQuery();
            
            while (res.next()){
                resultado = new Medico();
                resultado.setCRM(CRM);
                resultado.setEspecialidade(res.getString("especialidade"));
                resultado.setNome(res.getString("nome"));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e,"erro",0);
        }
        
        desconectaMySQL(conexao);
        
        return resultado;
        
    }
    
    public boolean cadastrarParto(Parto parto){
        
        Connection conexao = realizaConexaoMySQL();
        Filho filho = parto.getFilho();
        
        String insereParto = "INSERT INTO clinica.parto (CPFMae, CRM, idFilho)"
                + " VALUES (?,?,?)";
        
        String insereFilho = "INSERT INTO clinica.filho (nome, dataNascimento,"
                + "altura, peso, sexo) VALUES (?,?,?,?,?)";
        
        try{
            
            PreparedStatement preparadorParto = conexao.prepareStatement(insereParto);
            PreparedStatement preparadorFilho = conexao.prepareStatement(insereFilho, Statement.RETURN_GENERATED_KEYS);
            
            preparadorParto.setString(1, parto.getMae().getCPF());
            preparadorParto.setInt(2, parto.getMedico().getCRM());
            
            preparadorFilho.setString(1, filho.getNome());
            preparadorFilho.setString(2, filho.getDataNascimento());
            preparadorFilho.setFloat(3, filho.getAltura());
            preparadorFilho.setFloat(4, filho.getPeso());
            preparadorFilho.setString(5, String.valueOf(filho.getSexo()));

            
            preparadorFilho.execute();
            ResultSet rs = preparadorFilho.getGeneratedKeys();
            // pegando o id do filho
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
            }		

            preparadorParto.setInt(3, id);
            
            preparadorParto.execute();
            
            desconectaMySQL(conexao);
            
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e, "erro", 0);
        }
        
        desconectaMySQL(conexao);
        
        return false;
    }
    
    public List<Parto> ListarPartos(){
        List<Parto> partos = new ArrayList<Parto>();
        
        Connection conexao = realizaConexaoMySQL();
        
        String selecionaPartos = "SELECT * FROM clinica.parto";

        try {
            PreparedStatement preparadorParto = conexao.prepareStatement(selecionaPartos);

            ResultSet resultadoParto = preparadorParto.executeQuery();
            
            while(resultadoParto.next()){
                Mae mae = buscaMae(resultadoParto.getString("CPFMae"));
                Medico medico = buscaMedico(resultadoParto.getInt("CRM"));
                Filho filho = buscaFilho(resultadoParto.getInt("idFilho"));
                
                Parto parto = new Parto(filho, medico, mae);
                /*
                System.out.println("--- Parto ---");
                medico.imprimeMedico();
                filho.imprimeFilho();
                mae.imprimeMae();
                System.out.println("----------");
                */
                partos.add(parto);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e, "erro", 0);
        }
        
        desconectaMySQL(conexao);
        
        return partos;
    }
    
}

