package edu.uniandes.ecos.EstimadorTamRelativos.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * @name OperadorFunciones
 * @author Juan
 * @version 1.5
 * @date 14/03/2015
 * @description brinda operaciones matematicas comunes.
 */
public final class OperadorFunciones {

    //method
    /**
     * Obtiene la media de los numeros contenidos en la lista.
     *
     * @param lstDatos
     * @return
     */
    public static double obtenerMedia(List<Double> lstDatos) throws Exception {
        if (!lstDatos.isEmpty()) {
            double sumatoria = 0.0;
            for (Double dato : lstDatos) {
                sumatoria += dato;
            }
            double media = sumatoria / lstDatos.size();

            return media;
        } else {
            throw new Exception("La lista no tiene datos, por favor verifique.");
        }
    }
    
    //method
    /**
     * Calcula la varianza de la lista de datos ingresados por parametro.
     * 
     * @param lstDatos
     * @param media
     * @return varianza de los datos.
     */
    public static double obtenerVarianza(List<Double> lstDatos, double media){
        double varianza;
        double sumLogMenosMedia = 0.0;
        
        for (Double dato : lstDatos) {
            sumLogMenosMedia += Math.pow((dato-media), 2);
        }
        
        //Se calcula la varianza
        varianza = sumLogMenosMedia/(lstDatos.size()-1);
        
        return varianza;
    }
    
    //method
    /**
     * Calcula la desviacion estandar da la varianza ingresada por parametro
     * 
     * @param varianza
     * @return desviacion estandar
     */
    public static double obtenerDesvEstandar(double varianza){
        double desvEstandar = Math.sqrt(varianza);
        
        return desvEstandar;
    }
    
    //method
    /**
     * Calcula los rangos logaritmicos Very Small(VS), Small(S), Medium(M),
     * Large(L) y Very Large(VL). Ubicandolos en las posiciones 0,1,2,3 y 4 de la lista
     * respectivamente.
     * 
     * @param media
     * @param desvEstandar
     * @return lista con rangos logaritmicos.
     */
    public static List<Double> obtenerRangosLogaritmicos(double media, double desvEstandar){
        List<Double> lstRangosLogaritmicos = new ArrayList<>();
        
        lstRangosLogaritmicos.add(media-2*desvEstandar); //Very Small(VS)
        lstRangosLogaritmicos.add(media-desvEstandar); //Small (S)
        lstRangosLogaritmicos.add(media); //Medium (M)
        lstRangosLogaritmicos.add(media+desvEstandar); //Large (L)
        lstRangosLogaritmicos.add(media+2*desvEstandar); //Very Large (VL)
        
        return lstRangosLogaritmicos;
    }
    
    //method
    /**
     * Calcula el antilogaritmo para cada uno de los rangos logaritmicos
     * ubicando los valores para Very Small(VS), Small(S), Medium(M),
     * Large(L) y Very Large(VL) en las posiciones 0,1,2,3 y 4 de la lista respectivamente. 
     * 
     * @param lstRangosLogaritmicos
     * @return lista con valores de los rangos de tamanios relativos. 
     */
    public static List<Double> obtenerRangosTamanioRelativo(List<Double> lstRangosLogaritmicos){
        List<Double> lstRangosTamanioRelativo = new ArrayList<>();
        
        lstRangosTamanioRelativo.add(Math.exp(lstRangosLogaritmicos.get(0))); //Very Small(VS)
        lstRangosTamanioRelativo.add(Math.exp(lstRangosLogaritmicos.get(1))); //Small (S)
        lstRangosTamanioRelativo.add(Math.exp(lstRangosLogaritmicos.get(2))); //Medium (M)
        lstRangosTamanioRelativo.add(Math.exp(lstRangosLogaritmicos.get(3))); //Large (L)
        lstRangosTamanioRelativo.add(Math.exp(lstRangosLogaritmicos.get(4))); //Very Large (VL)
        
        return lstRangosTamanioRelativo;
    }
    
    //method
    /**
     * Redondea el valor ingresado por parametro al numero de decimales seleccionado. 
     * 
     * @param valor
     * @param numDecimales
     * @return 
     */
    public static double redondear(double valor, int numDecimales){
        int decimales = (int) Math.pow(10, numDecimales);
        return Math.rint(valor * decimales) / decimales;
    }

}

