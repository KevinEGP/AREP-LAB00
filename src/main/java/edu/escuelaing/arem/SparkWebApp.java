package edu.escuelaing.arem;

import static spark.Spark.*;

public class SparkWebApp 
{
    public static void main( String[] args )
    {
        port(getPort());
        get("/celsius", (req, res) -> {
            return convertToCelsius(req.queryparams('degrees');
        });
    }

    public static int getPort() {
        if (System.getenv("PORT") != null) {
        return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static String convertToCelsius(degrees: int) {
        System.out.println(degrees);
        return (degrees°C × 9/5) + 32;
    }
}
