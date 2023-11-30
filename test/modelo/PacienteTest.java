/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lenovo
 */
public class PacienteTest {

    public PacienteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testarInstancia() {

        try {
            int id = 1;
            String nome = "andre";
            String endereco = "rua osvaldo cruz";
            String data = "25/05/1980";
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formato.parse(data);
            String telefone = "51984795856";
            String cpf = "00077874056";
            String rg = "9825623111";
            String email = "aaaaa@gmail.com";
            int convenio = 1;

            Paciente paciente = new Paciente(id, nome, endereco, date, telefone, cpf, rg, email, convenio);

            assertEquals(id, paciente.getIdPaciente());
            assertEquals(nome, paciente.getNome());
            assertEquals(endereco, paciente.getEndereco());
            assertEquals(date, paciente.getDataNascimento());
            assertEquals(telefone, paciente.getTelefone());
            assertEquals(cpf, paciente.getCpf());
            assertEquals(rg, paciente.getRg());
            assertEquals(email, paciente.getEmail());
            assertEquals(convenio, paciente.getIdConvenio());
        } catch (ParseException ex) {
            Logger.getLogger(PacienteTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
