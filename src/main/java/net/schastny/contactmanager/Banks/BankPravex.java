package net.schastny.contactmanager.Banks;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Pandora
 * Date: 02.10.14
 * Time: 18:25
 * To change this template use File | Settings | File Templates.
 */
public class BankPravex extends Bank {
    public static String currentParam(){
        SimpleDateFormat dateYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat dateMonth = new SimpleDateFormat("MM");
        SimpleDateFormat dateDay = new SimpleDateFormat("dd");

        String year = dateYear.format(new Date());
        String month = dateMonth.format(new Date());
        String day = dateDay.format(new Date());

        String pDay = "day=";
        String pMonth = "&month=";
        String pYear = "&year=";
        String parametr = pDay+day+pMonth+month+pYear+year;
        return parametr;
    }
    static String HTMLadress = "http://www.pravex.com.ua/rus/currency/macros_response";

    @Override
    public String getHTML(String HTMLadress) throws IOException {
        String urlParameters = "day=15&month=01&year=2015";
        urlParameters = currentParam();
        String request = "http://www.pravex.com.ua/rus/currency/macros_response";
        URL url = new URL(request);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("charset", "utf-8");
        connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
        connection.setUseCaches(false);

        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes(urlParameters);
        //System.out.println(connection.getOutputStream().toString());
        wr.flush();
        wr.close();


        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        connection.disconnect();
        HTMLpage = response.toString();
       /* System.out.println(HTMLpage.indexOf("16.200"));
        System.out.println(HTMLpage.indexOf("16.530"));
        System.out.println(HTMLpage.indexOf("19.90"));
        System.out.println(HTMLpage.indexOf("20.17"));*/
        return HTMLpage;
    }

    @Override
    public double getUSDbuy() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        if(HTMLpage.length()<10)
            return 0;
        else {
            int pos = 757;
            String str;
            char c;
            StringBuilder sb = new StringBuilder();

            do {
                c = HTMLpage.charAt(pos);
                if (c != '<')
                    sb.append(c);
                pos++;
            } while (c != '<');

            str = sb.toString();
            USDbuy = Double.parseDouble(str);
            return USDbuy;
        }
    }

    @Override
    public double getUSDsell() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        if(HTMLpage.length()<10)
            return 0;
        else {
            String str;
            int pos = 2804;
            char c;
            StringBuilder sb = new StringBuilder();

            do {
                c = HTMLpage.charAt(pos);
                if (c != '<')
                    sb.append(c);
                pos++;
            } while (c != '<');

            str = sb.toString();
            USDsell = Double.parseDouble(str);
            return USDsell;
        }
    }

    @Override
    public double getEURbuy() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        if(HTMLpage.length()<10)
            return 0;
        else {
            String str;
            int pos = 310;
            char c;
            StringBuilder sb = new StringBuilder();

            do {
                c = HTMLpage.charAt(pos);
                if (c != '<')
                    sb.append(c);
                pos++;
            } while (c != '<');

            str = sb.toString();
            EURbuy = Double.parseDouble(str);
            return EURbuy;
        }
    }

    @Override
    public double getEURsell() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        if(HTMLpage.length()<10)
            return 0;
        else {
            String str;
            int pos = 348;
            char c;
            StringBuilder sb = new StringBuilder();

            do {
                c = HTMLpage.charAt(pos);
                if (c != '<')
                    sb.append(c);
                pos++;
            } while (c != '<');

            str = sb.toString();
            EURsell = Double.parseDouble(str);
            return EURsell;
        }
    }
    public static void main(String[]args) throws IOException {
        Bank bank = new BankPravex();
        //System.out.println(bank.getHTML(HTMLadress));
        System.out.println(bank.getUSDbuy());
        System.out.println(bank.getUSDsell());
        System.out.println(bank.getEURbuy());
        System.out.println(bank.getEURsell());
    }
}
