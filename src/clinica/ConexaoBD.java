
package clinica;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
            System.out.println("Conectado.");
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
    
}

