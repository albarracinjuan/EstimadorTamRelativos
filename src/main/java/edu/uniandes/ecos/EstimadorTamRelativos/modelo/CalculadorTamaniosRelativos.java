package edu.uniandes.ecos.EstimadorTamRelativos.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * @name ArchivoDatos
 * @author Juan
 * @version 1.0
 * @date 14/03/2015
 * @description Calcula los rangos de tamanios relativos.
 */
public class CalculadorTamaniosRelativos {
    
    /**
     * Lista de datos a procesar
     */
    private List<Double> lstDatos;
    /**
     * Lista de logaritmos naturales de los datos
     */
    private List<Double> lstLogNaturalDatos;
    /**
     * Promedio de logaritmos naturales
     */
    private double mediaLogNaturales;
    /**
     * Varianza de los datos
     */
    private double varianza;
    /**
     * Desviacion estandar de los datos;
     */
    private double desvEstandar;
    /**
     * Lista con los rangos logaritmicos calculados.
     */
    private List<Double> lstRangosLogaritmicos;
    /**
     * Lista con rangos de tamanios relativos
     */
    private List<Double> lstRangosTamanioRelativo;

    //method
    /**
     * Metodo constructor de la clase con los parametros cargados del archivo
     * 
     * @param lstLocClase
     * @param lstNumitems 
     * @throws java.lang.Exception 
     */
    public CalculadorTamaniosRelativos(List<Double> lstLocClase, List<Double> lstNumitems) throws Exception{
        this.lstDatos = new ArrayList<>();
        this.lstLogNaturalDatos = new ArrayList<>();
        this.lstRangosLogaritmicos = new ArrayList<>();
        this.lstRangosTamanioRelativo = new ArrayList<>();
        obtenerParametros(lstLocClase, lstNumitems);
    }
    
    //method
    /**
     * Ejecuta las operaciones para hallar las variables necesarias
     * en el calculo de rangos de tamanios relativos.
     * 
     * @throws java.lang.Exception 
     */
    private void obtenerParametros(List<Double> lstLocClase, List<Double> lstNumItems) throws Exception{
        for (int i = 0; i < lstLocClase.size(); i++) {
            if (lstNumItems.get(i) != 0) {
                double dato = obtenerPromLOCItem(lstLocClase.get(i), lstNumItems.get(i));
                this.lstDatos.add(dato);
                this.lstLogNaturalDatos.add(Math.log(dato));
            }else{
                this.lstDatos.add(lstLocClase.get(i));
                this.lstLogNaturalDatos.add(Math.log(lstLocClase.get(i)));
            }
        }
        
        //Se calculan parametros.
        this.mediaLogNaturales = OperadorFunciones.obtenerMedia(this.lstLogNaturalDatos);
        this.varianza = OperadorFunciones.obtenerVarianza(this.lstLogNaturalDatos, this.mediaLogNaturales);
        this.desvEstandar = OperadorFunciones.obtenerDesvEstandar(this.varianza);
    }
    
    //method
    /**
     * Ejecuta el calculo de los tamanios relativos
     */
    public void calcularRangosTamRelativos(){
        this.lstRangosLogaritmicos = OperadorFunciones.obtenerRangosLogaritmicos(this.mediaLogNaturales, this.desvEstandar);
        this.lstRangosTamanioRelativo = OperadorFunciones.obtenerRangosTamanioRelativo(this.lstRangosLogaritmicos);
    }
    
    //method
    /**
     * Calcula el tamanio promedio de LOC´s en los items de una clase.
     * 
     * @param tamLOCClase
     * @param numItems
     * @return 
     * @throws java.lang.Exception 
     */
    private static double obtenerPromLOCItem(double tamLOC, double numItems) throws  Exception{
        if (numItems == 0) {
            throw new Exception("El numero de items de la clase no puede ser 0. Por favor verifique el archivo.");
        }else{
            return tamLOC / numItems;
        }
    }

    /**
     * @return 
     */
    public List<Double> getLstDatos() {
        return lstDatos;
    }

    /** 
     * @return 
     */
    public List<Double> getLstLogNaturalDatos() {
        return lstLogNaturalDatos;
    }

    /**
     * @return 
     */
    public double getMediaLogNaturales() {
        return mediaLogNaturales;
    }

    /**
     * @return 
     */
    public double getVarianza() {
        return varianza;
    }

    /**
     * @return 
     */
    public double getDesvEstandar() {
        return desvEstandar;
    }
    
    /**
     * @return 
     */
    public List<Double> getLstRangosLogaritmicos() {
        return lstRangosLogaritmicos;
    }
    
    /**
     * @return 
     */
    public List<Double> getLstRangosTamanioRelativo() {
        return lstRangosTamanioRelativo;
    }   
}
