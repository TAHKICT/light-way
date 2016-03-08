package net.schastny.contactmanager.Banks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Pandora
 * Date: 02.10.14
 * Time: 16:08
 * To change this template use File | Settings | File Templates.
 */
public abstract class Bank {
    public static String HTMLpage;
    public String HTMLadress;
    public double USDbuy, USDsell, EURbuy, EURsell;


    public  String getHTML (String HTMLadress) throws IOException {
        URL url = new URL(HTMLadress);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            char[] buf = new char[1000];
            StringBuilder sb = new StringBuilder();
            int r;

            do {
                if ((r = br.read(buf)) > 0)
                    sb.append(new String(buf, 0, r));
            } while (r > 0);
            HTMLpage = sb.toString();
            return HTMLpage;

        } finally {
            http.disconnect();
        }
    }

    public double getUSDbuy() throws IOException {
         return USDbuy;
    }
    public double getUSDsell() throws IOException {
        return USDsell;
    }
    public double getEURbuy() throws IOException {
        return EURbuy;
    }
    public double getEURsell() throws IOException {
        return EURsell;
    }

}
