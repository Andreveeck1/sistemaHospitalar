/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelo;

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
public class ConvenioTest {

    public ConvenioTest() {
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
        int id = 2;
        String convenio = "unimed";
        String carencia = "1 ano";
        String cnpj = "qqqqqqq";

        Convenio conv = new Convenio(id, convenio, carencia, cnpj);

        assertEquals(id, conv.getIdConvenio());
        assertEquals(convenio, conv.getNomeConvenio());
        assertEquals(carencia, conv.getTempoCarencia());
        assertEquals(cnpj, conv.getCnpj());

    }
    
    

}
