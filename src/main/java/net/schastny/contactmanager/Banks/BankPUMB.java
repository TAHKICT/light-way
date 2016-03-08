package net.schastny.contactmanager.Banks;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;

/**
 * Created by админ on 23.12.2014.
 */
public class BankPUMB extends Bank {
    static String HTMLadress = "http://pumb.ua/m/ru/currency_converter/";

    @Override
    public double getUSDbuy() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        String str = null;
        String ssss = "USD</td>";
        int pos = HTMLpage.indexOf(ssss)+31;
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
        return USDbuy;    //To change body of overridden methods use File | Settings | File Templates.
    }
    @Override
    public double getUSDsell() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        String str = null;
        String ssss = "USD</td>";
        int pos = HTMLpage.indexOf(ssss)+73;
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
        return USDsell;    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public double getEURbuy() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        String str = null;
        String ssss = "EUR</td>";
        int pos = HTMLpage.indexOf(ssss)+31;
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

    @Override
    public double getEURsell() throws IOException {
        HTMLpage = getHTML(HTMLadress);
        HTMLpage = getHTML(HTMLadress);
        String str = null;
        String ssss = "EUR</td>";
        int pos = HTMLpage.indexOf(ssss)+73;
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
        return EURsell;    //To change body of overridden methods use File | Settings | File Templates.
    }

    public static void main(String[] args) throws IOException {
        BankPUMB bankPUMB = new BankPUMB();
        //System.out.println(bankPUMB.HTMLpage);
        //System.out.println(bankPUMB.getUSDsell());
       // System.out.println(bankPUMB.getUSDbuyy());
        System.out.println(bankPUMB.getUSDbuy());
        System.out.println(bankPUMB.getUSDsell());
        System.out.println(bankPUMB.getEURbuy());
        System.out.println(bankPUMB.getEURsell());
       /* System.out.println(bankPUMB.getUSDsell());
        System.out.println(bankPUMB.getEURbuy());
        System.out.println(bankPUMB.getEURsell());*/
    }
}
