package net.schastny.contactmanager.Banks;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Pandora
 * Date: 02.10.14
 * Time: 16:24
 * To change this template use File | Settings | File Templates.
 */
public class BankPrivat extends Bank {
    static String HTMLadress = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";

    @Override
    public double getUSDbuy() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        int pos = 264;
        String str;
        char c;
        StringBuilder sb = new StringBuilder();

        do {
            c = HTMLpage.charAt(pos);
            if (c != '"')
                sb.append(c);
            pos++;
        } while (c != '"');

        str = sb.toString();
        USDbuy = Double.parseDouble(str);
        return USDbuy;    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public double getUSDsell() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        int pos = 280;
        String str;
        char c;
        StringBuilder sb = new StringBuilder();

        do {
            c = HTMLpage.charAt(pos);
            if (c != '"')
                sb.append(c);
            pos++;
        } while (c != '"');

        str = sb.toString();
        USDsell = Double.parseDouble(str);
        return USDsell;    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public double getEURbuy() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        int pos = 182;
        String str;
        char c;
        StringBuilder sb = new StringBuilder();

        do {
            c = HTMLpage.charAt(pos);
            if (c != '"')
                sb.append(c);
            pos++;
        } while (c != '"');

        str = sb.toString();
        EURbuy = Double.parseDouble(str);
        return EURbuy;
    }

    @Override
    public double getEURsell() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        int pos = 198;
        String str;
        char c;
        StringBuilder sb = new StringBuilder();

        do {
            c = HTMLpage.charAt(pos);
            if (c != '"')
                sb.append(c);
            pos++;
        } while (c != '"');

        str = sb.toString();
        EURsell = Double.parseDouble(str);
        return EURsell;    //To change body of overridden methods use File | Settings | File Templates.
    }

    public static void main(String[] args) throws IOException {
        BankPrivat bankPrivat = new BankPrivat();
        System.out.println("USD buy = " + bankPrivat.getUSDbuy());
        System.out.println("USD sell = " + bankPrivat.getUSDsell());
        System.out.println("EUR buy = " + bankPrivat.getEURbuy());
        System.out.println("EUR sell = " + bankPrivat.getEURsell());
    }
}
