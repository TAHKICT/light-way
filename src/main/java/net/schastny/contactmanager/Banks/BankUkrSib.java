package net.schastny.contactmanager.Banks;

import java.io.IOException;

/**
 * Created by админ on 22.12.2014.
 */
public class BankUkrSib extends Bank {
    static String HTMLadress = "https://my.ukrsibbank.com/ua/personal/operations/currency_exchange/";
    static int posUbuy = 20207;
    static int posUsell = posUbuy + 16;
    static int posEbuy = 20286;
    static int posEsell = posEbuy + 16;

    public double getUSDbuy() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        int pos = posUbuy;
            String str = null;
            char c;
            StringBuilder sb = new StringBuilder();
        do {
            c = HTMLpage.charAt(pos);
            if (c != '<')
                sb.append(c);
            pos++;
        } while (c != '<');

        String Nstr = sb.toString();
        str = Nstr.replace(',','.');
        USDbuy = Double.parseDouble(str);
        return USDbuy;
    }
    public double getUSDsell() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        int pos = posUsell;
        String str = null;
        char c;
        StringBuilder sb = new StringBuilder();
        do {
            c = HTMLpage.charAt(pos);
            if (c != '<')
                sb.append(c);
            pos++;
        } while (c != '<');
        String Nstr = sb.toString();
        str = Nstr.replace(',', '.');
        USDsell = Double.parseDouble(str);
        return USDsell;
    }
    public double getEURbuy() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        int posE = posEbuy;
        String str = null;
        char c;
        StringBuilder sb = new StringBuilder();
        do {
            c = HTMLpage.charAt(posE);
            if (c != '<')
                sb.append(c);
            posE++;
        } while (c != '<');

        String Nstr = sb.toString();
        str = Nstr.replace(',', '.');
        EURbuy = Double.parseDouble(str);
        return EURbuy;
    }
    public String getEURbuyy() throws IOException {
        HTMLpage = getHTML(HTMLadress);
       // System.out.println(HTMLpage);
        System.out.println(HTMLpage.indexOf("18,7500"));
        int pos = posEbuy;
        String str = null;
        char c;
        StringBuilder sb = new StringBuilder();
        do {
            c = HTMLpage.charAt(pos);
            if (c != '<')
                sb.append(c);
            pos++;
        } while (c != '<');

        String Nstr = sb.toString();
        str = Nstr.replace(',', '.');
        //EURbuy = Double.parseDouble(str);
        return Nstr;
    }
    public double getEURsell() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        int pos = posEsell;
        String str = null;
        char c;
        StringBuilder sb = new StringBuilder();
        do {
            c = HTMLpage.charAt(pos);
            if (c != '<')
                sb.append(c);
            pos++;
        } while (c != '<');

        String Nstr = sb.toString();
        str = Nstr.replace(',', '.');
        EURsell = Double.parseDouble(str);
        return EURsell;
    }

    public static void main(String... args)  {
       // BankUkrSib bankUkrSib = new BankUkrSib();
        /*System.out.println(bankUkrSib.getUSDbuy());
        System.out.println(bankUkrSib.getUSDsell());
        System.out.println(bankUkrSib.getEURbuy());
        System.out.println(bankUkrSib.getEURsell());*/
       // System.out.println(bankUkrSib.getEURbuyy());

    }
}
