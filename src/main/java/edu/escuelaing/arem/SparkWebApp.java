package edu.escuelaing.arem;

import static spark.Spark.*;

import org.json.JSONObject;

public class SparkWebApp 
{
    public static void main( String[] args )
    {   
        
        // port(getPort());
        port(4567);
        staticFiles.location("/public");

        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        get("/", "text/html", (req, res) -> {
            res.redirect("index.html");            
            return null;
        });
        
        get("/to-fahrenheit", (req, res) -> {
            
            return convertCelsiusToFahrenheit(req.queryParams("degrees"));
        });

        get("/to-celsius", (req, res) -> {
            return convertFahrenheitToCelsius(req.queryParams("degrees"));
        });
    }

    public static int getPort() {
        if (System.getenv("PORT") != null) {
        return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static JSONObject convertCelsiusToFahrenheit(String degrees) {
        JSONObject response = new JSONObject();
        response.put("degrees", (Float.valueOf(degrees) * 1.8) + 32);
        response.put("success", true);
        return response;
    }

    private static JSONObject convertFahrenheitToCelsius(String degrees) {
        JSONObject response = new JSONObject();
        response.put("degrees", (Float.valueOf(degrees) - 32 ) / 1.8);
        response.put("success", true);
        return response;
    }

    private static String renderIndex() {
        return "";
    }


}
