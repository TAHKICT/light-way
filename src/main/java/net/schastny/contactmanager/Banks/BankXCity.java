package net.schastny.contactmanager.Banks;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Pandora
 * Date: 02.10.14
 * Time: 22:01
 * To change this template use File | Settings | File Templates.
 */
public class BankXCity extends Bank {
    static String HTMLadress = "http://www.xcitybank.com.ua/kursi-valyut/";
    int posU, posE;

    @Override
    public double getUSDbuy() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        String str = null;
        int pos = 0;
        char c;
        StringBuilder sb = new StringBuilder();
        String ssss = "USD (1 долар США)</td><td>";
        do {
            pos = HTMLpage.indexOf(ssss, pos);
            if (pos >= 0) {
                pos += ssss.length();

                do {
                    c = HTMLpage.charAt(pos++);
                    if (c != '<')
                        sb.append(c);
                } while (c != '<');

                str = sb.toString();
                posU = pos;
                sb.setLength(0);
            }
        } while (pos >= 0);
        USDbuy = Double.parseDouble(str);
        return USDbuy;
    }

    @Override
    public double getUSDsell() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        String str;
        int pos = posU + 8;
        char c;
        StringBuilder sb = new StringBuilder();
        do {
            c = HTMLpage.charAt(pos++);
            if (c != '<')
                sb.append(c);
        } while (c != '<');

        str = sb.toString();
        posU = pos;
        sb.setLength(0);
        USDsell = Double.parseDouble(str);
        return USDsell;
    }

    @Override
    public double getEURbuy() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        String str = null;
        int pos = 0;
        char c;
        StringBuilder sb = new StringBuilder();
        String ssss = "EUR (1 євро)</td><td>";


        do {
            pos = HTMLpage.indexOf(ssss, pos);
            if (pos >= 0) {
                pos += ssss.length();

                do {
                    c = HTMLpage.charAt(pos++);
                    if (c != '<')
                        sb.append(c);
                } while (c != '<');

                str = sb.toString();
                posE = pos;
                sb.setLength(0);
            }
        } while (pos >= 0);
        EURbuy = Double.parseDouble(str);
        return EURbuy;
    }

    @Override
    public double getEURsell() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        String str;
        int pos = posE + 8;
        char c;
        StringBuilder sb = new StringBuilder();
        do {
            c = HTMLpage.charAt(pos++);
            if (c != '<')
                sb.append(c);
        } while (c != '<');

        str = sb.toString();
        posE = pos;
        sb.setLength(0);
        EURsell = Double.parseDouble(str);
        return EURsell;
    }

    public static void main(String[] args) throws IOException {
        BankXCity bankXCity = new BankXCity();
        System.out.println(bankXCity.getUSDbuy());
        System.out.println(bankXCity.getUSDsell());
        System.out.println(bankXCity.getEURbuy());
        System.out.println(bankXCity.getEURsell());
    }
}
