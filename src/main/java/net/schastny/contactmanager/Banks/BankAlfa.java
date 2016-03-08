package net.schastny.contactmanager.Banks;

import java.io.IOException;

/**
 * Created by админ on 09.01.2015.
 */
public class BankAlfa extends Bank{
    static String HTMLadress = "http://www.alfabank.ua/ua/";
     static String[] partsUSD;
     static String[] partsEUR;


    public String[] getUSD() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        char c;
        StringBuilder sb = new StringBuilder();
        int pos = HTMLpage.indexOf("<strong>USD</strong>")+111;
        do {
            c = HTMLpage.charAt(pos);
            if (c != '<')
                sb.append(c);
            pos++;
        } while (c != '<');

        String str = sb.toString();
        partsUSD = str.split("/");
        return partsUSD;
    }
    public String[] getEUR() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        char c;
        StringBuilder sb = new StringBuilder();
        int pos = HTMLpage.indexOf("<strong>EUR</strong>")+111;
        do {
            c = HTMLpage.charAt(pos);
            if (c != '<')
                sb.append(c);
            pos++;
        } while (c != '<');

        String str = sb.toString();
        partsEUR = str.split("/");
        return partsEUR;
    }

    @Override
    public double getUSDbuy() throws IOException {
        BankAlfa bankAlfa = new BankAlfa();
        bankAlfa.getUSD();
        double USDbuy = Double.parseDouble(partsUSD[0]);
        return USDbuy;
    }

    @Override
    public double getUSDsell() throws IOException {

        double USDsell = Double.parseDouble(partsUSD[1]);
        return USDsell;
    }

    @Override
    public double getEURbuy() throws IOException {
        BankAlfa bankAlfa = new BankAlfa();
        bankAlfa.getEUR();
        double EURbuy = Double.parseDouble(partsEUR[0]);
        return EURbuy;
    }

    @Override
    public double getEURsell() throws IOException {

        double EURsell = Double.parseDouble(partsEUR[1]);
        return EURsell;
    }

    public static void main(String[] args) throws IOException {
        BankAlfa bankAlfa = new BankAlfa();
        System.out.println(bankAlfa.getUSDbuy() + " " + bankAlfa.getUSDsell());
        System.out.println(bankAlfa.getEURbuy() + " " + bankAlfa.getEURsell());
    }

}
