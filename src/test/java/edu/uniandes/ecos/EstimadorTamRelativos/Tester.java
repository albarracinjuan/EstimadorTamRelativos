package edu.uniandes.ecos.EstimadorTamRelativos;

import edu.uniandes.ecos.EstimadorTamRelativos.modelo.ArchivoDatos;
import edu.uniandes.ecos.EstimadorTamRelativos.modelo.CalculadorTamaniosRelativos;
import edu.uniandes.ecos.EstimadorTamRelativos.modelo.OperadorFunciones;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @name Tester
 * @author Juan
 * @version 1.0
 * @date 014/03/2015
 * @description clase encargada de ejecutar los test de prueba a traves de JUnit.
 */
public class Tester extends TestCase{

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Tester( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( Tester.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    //method
    /**
     * Ejeucta el caso de prueba 1
     */
    @org.junit.Test
    public void test1(){
        
        try {
            ArchivoDatos archivoPrueba = new ArchivoDatos("src/main/resources/data/test1.txt");
            archivoPrueba.cargarDatos();
            CalculadorTamaniosRelativos calculador = new CalculadorTamaniosRelativos(archivoPrueba.getLstDatosTabla1(), archivoPrueba.getLstDatosTabla2());
            calculador.calcularRangosTamRelativos();
            
            assertEquals(4.3953, OperadorFunciones.redondear(calculador.getLstRangosTamanioRelativo().get(0), 4));
            assertEquals(8.5081, OperadorFunciones.redondear(calculador.getLstRangosTamanioRelativo().get(1), 4));
            assertEquals(16.4696, OperadorFunciones.redondear(calculador.getLstRangosTamanioRelativo().get(2), 4));
            assertEquals(31.8811, OperadorFunciones.redondear(calculador.getLstRangosTamanioRelativo().get(3), 4));
            assertEquals(61.7137, OperadorFunciones.redondear(calculador.getLstRangosTamanioRelativo().get(4), 4));
        } catch (Exception ex) {
            fail(ex.getMessage());
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //method
    /**
     * Ejeucta el caso de prueba 2
     */
    @org.junit.Test
    public void test2(){
        
        try {
            ArchivoDatos archivoPrueba = new ArchivoDatos("src/main/resources/data/test2.txt");
            archivoPrueba.cargarDatos();
            CalculadorTamaniosRelativos calculador = new CalculadorTamaniosRelativos(archivoPrueba.getLstDatosTabla1(), archivoPrueba.getLstDatosTabla2());
            calculador.calcularRangosTamRelativos();
            
            assertEquals(6.3375, OperadorFunciones.redondear(calculador.getLstRangosTamanioRelativo().get(0), 4));
            assertEquals(8.4393, OperadorFunciones.redondear(calculador.getLstRangosTamanioRelativo().get(1), 4));
            assertEquals(11.2381, OperadorFunciones.redondear(calculador.getLstRangosTamanioRelativo().get(2), 4));
            assertEquals(14.9650, OperadorFunciones.redondear(calculador.getLstRangosTamanioRelativo().get(3), 4));
            assertEquals(19.9280, OperadorFunciones.redondear(calculador.getLstRangosTamanioRelativo().get(4), 4));
        } catch (Exception ex) {
            fail(ex.getMessage());
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

