/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.Convenio;
import persistencia.ConexaoBanco;
import servicos.PacienteServicos;

/**
 *
 * @author senacead
 */


/*A classe ConvenioDAO é responsável pela comunicação entre a aplicação e o banco de dados, ou seja,
ela é responsável por realizar as operações de cadastro e busca de convenio  no banco de dados.
*/
public class ConvenioDAO {

    private ConexaoBanco conexao;
   // private Connection con;

      /*No construtor da classe, a instância de ConexaoBanco é criada e 
    armazenada no atributo conexao. 
    Essa instância será usada posteriormente para obter a conexão com o banco de dados.
    */
    public ConvenioDAO() {
        this.conexao = new ConexaoBanco();
    }

       public Connection criaConexaoComBancoDados() {
        Connection conexao = null;
           try {
               conexao = new ConexaoBanco().getConnection();
           } catch (SQLException ex) {
               Logger.getLogger(PacienteServicos.class.getName()).log(Level.SEVERE, null, ex);
           }

        return conexao;
    }
    public ArrayList<Convenio> buscarcConvenios(Connection conexao) throws SQLException {

        /*
         * ResultSet - Criando obj. capaz de executar instruções
         * SQL no banco de dados
         */
        ResultSet rs;

        try {
            // String que receberá instrução SQL
            String sql = "SELECT * FROM CONVENIO";
           // this.con = this.conexao.getConexao();

            //Preparando a instrução SQL
            PreparedStatement pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            //Criando um ArrayList para armazenar os objetos do tipo Convenio
            ArrayList<Convenio> listaConvenios = new ArrayList<Convenio>();

            /* Enquanto houver uma próxima linha no banco de dados o while roda */
            while (rs.next()) {

                //Criando um novo objeto do tipo Convenio
                Convenio convenio = new Convenio();

                /* Mapeando a tabela do banco para objeto convenio */
                convenio.setIdConvenio(rs.getInt("ID_CONVENIO"));
                convenio.setNomeConvenio(rs.getString("NOME_CONVENIO"));
                convenio.setTempoCarencia(rs.getString("TEMPO_CARENCIA"));
                convenio.setCnpj(rs.getString("CNPJ"));

                /* Adicionando o objeto convenio no ArrayList listaConvenios */
                listaConvenios.add(convenio);
            }

            // retorna o resultado da consulta ao banco de dados em forma de um ArrayList contendo objetos do tipo Convenio
            return listaConvenios;
        } catch (SQLException se) {

            // Se houver algum erro na busca, lança uma exceção SQLException
            throw new SQLException("Erro ao buscar dados do Banco! " + se.getMessage());
        } finally {

            //Fechando a conexão com o banco de dados
            conexao.close();
        }

    }

    public Convenio buscarConvenioFiltro(String query, Connection conexao) throws SQLException {
        ResultSet rs;

        try {
            // Monta a consulta SQL com base na String query e armazena na variável sql

            String sql = "SELECT * FROM CONVENIO WHERE NOME_CONVENIO LIKE '%" + query + "%';";

            // Obtém uma conexão com o banco de dados e prepara uma instrução SQL
            //this.con = this.conexao.getConexao();
            PreparedStatement pst = conexao.prepareStatement(sql);

            // Executa a instrução SQL e armazena o resultado em um objeto ResultSet chamado rs
            rs = pst.executeQuery();

            // Verifica se a consulta retornou algum resultado
            if (rs.next()) {

                // Cria um objeto Convenio com os dados retornados na consulta
                Convenio convenio = new Convenio();

                convenio.setIdConvenio(rs.getInt("ID_CONVENIO"));
                convenio.setNomeConvenio(rs.getString("NOME_CONVENIO"));
                convenio.setTempoCarencia(rs.getString("TEMPO_CARENCIA"));
                convenio.setCnpj(rs.getString("CNPJ"));

                // Retorna o objeto Convenio criado
                return convenio;
            }

            // Se não houver resultado na consulta, retorna null
            return null;
        } catch (SQLException se) {

            // Se houver algum erro na busca, lança uma exceção SQLException
            throw new SQLException("Erro ao buscar dados do Banco! " + se.getMessage());
        } finally {
            conexao.close();
        }

    }

}
