
import edu.uniandes.ecos.EstimadorTamRelativos.modelo.ArchivoDatos;
import edu.uniandes.ecos.EstimadorTamRelativos.modelo.CalculadorTamaniosRelativos;
import static spark.Spark.get;
import static spark.SparkBase.port;

/**
 * @name Main
 * @author Juan
 * @version 1.1
 * @date 14/03/2015
 * @description ejecuta los calculos de Estiimacion.
 */
public class Main {

    //method
    /**
     * Metodo principal del programa.
     *
     * @param args
     */
    public static void main(String[] args) {
        port(Integer.valueOf(System.getenv("PORT")));

        ArchivoDatos archivo1 = new ArchivoDatos("src/main/resources/data/test1.txt");
        ArchivoDatos archivo2 = new ArchivoDatos("src/main/resources/data/test2.txt");
        StringBuilder response = new StringBuilder();

        try {
            archivo1.cargarDatos();
            archivo2.cargarDatos();
            CalculadorTamaniosRelativos calculador1 = new CalculadorTamaniosRelativos(archivo1.getLstDatosTabla1(), archivo1.getLstDatosTabla2());
            CalculadorTamaniosRelativos calculador2 = new CalculadorTamaniosRelativos(archivo2.getLstDatosTabla1(), archivo2.getLstDatosTabla2());
            calculador1.calcularRangosTamRelativos();
            calculador2.calcularRangosTamRelativos();

            response.append("<style type=\"text/css\">");
            response.append(".tg  {border-collapse:collapse;border-spacing:0;}");
            response.append(".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}");
            response.append(".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}");
            response.append(".tg .tg-baqh{text-align:center;vertical-align:top}");
            response.append(".tg .tg-yw4l{vertical-align:top}");
            response.append(".tg .tg-amwm{font-weight:bold;text-align:center;vertical-align:top}");
            response.append(".tg .tg-9hbo{font-weight:bold;vertical-align:top}");
            response.append("</style>");
            response.append("<table class=\"tg\">");
            response.append("<tr>");
            response.append("<th class=\"tg-yw4l\"></th>");
            response.append("<th class=\"tg-amwm\" colspan=\"5\">Expected Values</th>");
            response.append("<th class=\"tg-amwm\" colspan=\"5\">Actual Values</th>");
            response.append("</tr>");
            response.append("<tr>");
            response.append("<td class=\"tg-yw4l\"></td>");
            response.append("<td class=\"tg-amwm\">VS</td>");
            response.append("<td class=\"tg-amwm\">S</td>");
            response.append("<td class=\"tg-amwm\">M</td>");
            response.append("<td class=\"tg-amwm\">L</td>");
            response.append("<td class=\"tg-amwm\">VL</td>");
            response.append("<td class=\"tg-yw4l\">VS</td>");
            response.append("<td class=\"tg-yw4l\">S</td>");
            response.append("<td class=\"tg-yw4l\">M</td>");
            response.append("<td class=\"tg-yw4l\">L</td>");
            response.append("<td class=\"tg-yw4l\">VL</td>");
            response.append("</tr>");
            response.append("<tr>");
            response.append("<td class=\"tg-9hbo\">LOC/Method</td>");
            response.append("<td class=\"tg-baqh\">4.3953</td>");
            response.append("<td class=\"tg-baqh\">8.5081</td>");
            response.append("<td class=\"tg-baqh\">16.4696</td>");
            response.append("<td class=\"tg-baqh\">31.8811</td>");
            response.append(" <td class=\"tg-baqh\">61.7137</td>");
            response.append("<td class=\"tg-yw4l\">");
            response.append(calculador1.getLstRangosTamanioRelativo().get(0));
            response.append("</td>");
            response.append("<td class=\"tg-yw4l\">");
            response.append(calculador1.getLstRangosTamanioRelativo().get(1));
            response.append("</td>");
            response.append("<td class=\"tg-yw4l\">");
            response.append(calculador1.getLstRangosTamanioRelativo().get(2));
            response.append("</td>");
            response.append("<td class=\"tg-yw4l\">");
            response.append(calculador1.getLstRangosTamanioRelativo().get(3));
            response.append("</td>");
            response.append("<td class=\"tg-yw4l\">");
            response.append(calculador1.getLstRangosTamanioRelativo().get(4));
            response.append("</td>");
            response.append("</tr>");
            response.append("<tr>");
            response.append("<td class=\"tg-9hbo\">Pgs/Chapter</td>");
            response.append("<td class=\"tg-baqh\">6.3375</td>");
            response.append("<td class=\"tg-baqh\">8.4393</td>");
            response.append("<td class=\"tg-baqh\">11.2381</td");
            response.append("<td class=\"tg-baqh\">14.9650</td>");
            response.append("<td class=\"tg-baqh\">19.9280</td>");
            response.append("<td class=\"tg-yw4l\">");
            response.append(calculador2.getLstRangosTamanioRelativo().get(0));
            response.append("</td>");
            response.append("<td class=\"tg-yw4l\">");
            response.append(calculador2.getLstRangosTamanioRelativo().get(0));
            response.append("</td>");
            response.append("<td class=\"tg-yw4l\">");
            response.append(calculador2.getLstRangosTamanioRelativo().get(0));
            response.append("</td>");
            response.append("<td class=\"tg-yw4l\">");
            response.append(calculador2.getLstRangosTamanioRelativo().get(0));
            response.append("</td>");
            response.append("<td class=\"tg-yw4l\">");
            response.append(calculador2.getLstRangosTamanioRelativo().get(0));
            response.append("</td>");
            response.append("</tr>");
            response.append("</table>");

            get("/", (req, res) -> response.toString());
        } catch (Exception ex) {
            response.append("No se han podido calcular los rangos debido a la siguiente excepcion: ");
            response.append(ex.getMessage());
            get("/", (req, res) -> response.toString());
        }
    }
}
