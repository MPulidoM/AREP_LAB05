package co.edu.escuelaing.sparkdockerdemolive;

import static spark.Spark.get;
import static spark.Spark.port;

public class SparkWebServer {
    public static void main(String... args) {
        port(getPort());
        get("/formulario", (req, res) -> {
            String htmlForm = "<!DOCTYPE html>\n" +
                    "<html lang=\"es\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Calculadora</title>\n" +
                    "    <style>\n" +
                    "        body {\n" +
                    "            font-family: Arial, sans-serif;\n" +
                    "            background-color: #f0f0f0;\n" +
                    "            display: flex;\n" +
                    "            justify-content: center;\n" +
                    "            align-items: center;\n" +
                    "            height: 100vh;\n" +
                    "            margin: 0;\n" +
                    "        }\n" +
                    "        .container {\n" +
                    "            max-width: 400px;\n" +
                    "            margin: 0 auto;\n" +
                    "            padding: 20px;\n" +
                    "            background-color: #c990e1;\n" +
                    "            border-radius: 5px;\n" +
                    "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n" +
                    "        }\n" +
                    "        label {\n" +
                    "            display: block;\n" +
                    "            margin-top: 10px;\n" +
                    "        }\n" +
                    "        select, input {\n" +
                    "            width: 100%;\n" +
                    "            padding: 10px;\n" +
                    "            margin-top: 5px;\n" +
                    "            box-sizing: border-box;\n" +
                    "            border: 1px solid #ccc;\n" +
                    "            border-radius: 5px;\n" +
                    "        }\n" +
                    "        input[type=\"submit\"] {\n" +
                    "            margin-top: 10px;\n" +
                    "            background-color: white ;\n" +
                    "            color: white;\n" +
                    "            cursor: pointer;\n" +
                    "            transition: background-color 0.3s;\n" +
                    "        }\n" +
                    "        input[type=\"submit\"]:hover {\n" +
                    "            background-color: #c990e1;\n" +
                    "        }\n" +
                    "        :root {\n" +
                    "            --container-color: white;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <div class=\"container\">\n" +
                    "        <h2>Calculadora</h2>\n" +
                    "        <form action=\"/calcular\" method=\"get\">\n" +
                    "            <label for=\"operacion\">Seleccione la operación:</label>\n" +
                    "            <select name=\"operacion\" id=\"operacion\">\n" +
                    "                <option value=\"cos\">Coseno</option>\n" +
                    "                <option value=\"sin\">Seno</option>\n" +
                    "                <option value=\"palindrom\">Palíndromo</option>\n" +
                    "                <option value=\"magnitude\">Magnitud</option>\n" +
                    "            </select>\n" +
                    "            <br>\n" +
                    "            <label for=\"valor\">Número (o Palíndromo), X (si es magnitud):</label>\n" +
                    "            <input type=\"text\" name=\"valor\" id=\"valor\">\n" +
                    "            <br>\n" +
                    "            <label for=\"valorY\">Y (si es magnitud):</label>\n" +
                    "            <input type=\"text\" name=\"valorY\" id=\"valorY\">\n" +
                    "            <br>\n" +
                    "            <input type=\"submit\" value=\"Calcular\">\n" +
                    "        </form>\n" +
                    "    </div>\n" +
                    "</body>\n" +
                    "</html>";
            return htmlForm;
        });
        get("/calcular", (req, res) -> {
            String operacion = req.queryParams("operacion");
            String valor = req.queryParams("valor");
            switch (operacion) {
                case "cos":
                    return MyAppService.getCos(valor);
                case "sin":
                    return MyAppService.getSin(valor);
                case "palindrom":
                    return MyAppService.isPalindrome(valor);
                case "magnitude":
                    String valorX = req.queryParams("valor");
                    String valorY = req.queryParams("valorY");
                    return MyAppService.getMagnitude(valorX, valorY);
                default:
                    return "Operación no válida";
            }
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
