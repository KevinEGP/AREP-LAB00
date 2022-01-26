package edu.escuelaing.arem;

import static spark.Spark.*;

public class Spark 
{
    public static void main( String[] args )
    {
        port(getPort());
        get("/hello", (req, res) -> "Hello Heroku");
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
        return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
