package net.schastny.contactmanager.Banks;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Pandora
 * Date: 02.10.14
 * Time: 18:01
 * To change this template use File | Settings | File Templates.
 */
public class BankCityCommerce extends Bank {
    static String HTMLadress = "http://www.citycommercebank.com/";
    int posU;
    int posE;

    @Override
    public double getUSDbuy() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        int pos = HTMLpage.indexOf("USD");
        String str;
        char c;
        StringBuilder sb = new StringBuilder();
        String ssss = "\">";

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
                USDbuy = Double.parseDouble(str);
                posU = pos;
                break;
            }

        } while (pos >= 0);
        return USDbuy;
    }

    @Override
    public double getUSDsell() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        int pos = posU;
        String str;
        char c;
        StringBuilder sb = new StringBuilder();
        String ssss = "\">";

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
                USDsell = Double.parseDouble(str);
                break;
            }

        } while (pos >= 0);
        return USDsell;
    }

    @Override
    public double getEURbuy() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        int pos = HTMLpage.indexOf("EUR");
        String str;
        char c;
        StringBuilder sb = new StringBuilder();
        String ssss = "\">";

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
                EURbuy = Double.parseDouble(str);
                posE = pos;
                break;
            }

        } while (pos >= 0);
        return EURbuy;
    }

    @Override
    public double getEURsell() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        int pos = posE;
        String str;
        char c;
        StringBuilder sb = new StringBuilder();
        String ssss = "\">";

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
                EURsell = Double.parseDouble(str);
                break;
            }

        } while (pos >= 0);
        return EURsell;

    }
}
