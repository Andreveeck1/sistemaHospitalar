/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import dao.DAOFactory;
import dao.PacienteDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Paciente;
import persistencia.ConexaoBanco;

/**
 *
 * @author senacead
 */
/*
A classe PacienteServicos representa a camada de serviços da aplicação, ela utiliza a classe PacienteDAO para realizar
operações de leitura e escrita no banco de dados.
 */
public class PacienteServicos {
    
       public Connection criaConexaoComBancoDados() {
        Connection conexao = null;
           try {
               conexao = new ConexaoBanco().getConnection();
           } catch (SQLException ex) {
               Logger.getLogger(PacienteServicos.class.getName()).log(Level.SEVERE, null, ex);
           }

        return conexao;
    }

    // Método para cadastrar um paciente
    public void cadastrarPaciente(Paciente pac, Connection conexao) throws SQLException {

        // Busca da Fábrica um obj. PacienteDAO
        PacienteDAO pacDAO = DAOFactory.getPacienteDAO();
        // conexao =  this.criaConexaoComBancoDados();

        // Chamando método cadastrarPaciente para enviar o obj. pac
        pacDAO.cadastrarPaciente(pac,conexao);
    }

    // Método para buscar um paciente por ID
    public ArrayList<Paciente> buscarPacienteFiltro(String query, Connection conexao) throws SQLException {

        // Busca da Fábrica um obj. PacienteDAO
        PacienteDAO pacDAO = DAOFactory.getPacienteDAO();
        // conexao =  this.criaConexaoComBancoDados();

        // Chamando método buscarPaciente para buscar o paciente pelo ID
        return pacDAO.buscarPacienteFiltro(query,conexao);
    }

    // Método para buscar todos os pacientes
    public ArrayList<Paciente> buscarPaciente(Connection conexao) throws SQLException {

        // Busca da Fábrica um obj. PacienteDAO
        PacienteDAO pacDAO = DAOFactory.getPacienteDAO();
      // conexao =  this.criaConexaoComBancoDados();

        // Chamando método buscarPaciente para buscar todos os pacientes
        return pacDAO.buscarPaciente(conexao);
    }

}
