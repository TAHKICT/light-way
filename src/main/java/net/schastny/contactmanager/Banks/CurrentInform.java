package net.schastny.contactmanager.Banks;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Pandora
 * Date: 02.10.14
 * Time: 16:53
 * To change this template use File | Settings | File Templates.
 */
public class CurrentInform {
    static BankFactory bankFactory = new BankFactory();
    static Bank privat = bankFactory.getBank("privatbank");
    static Bank pravex = bankFactory.getBank("pravexbank");
    static Bank ukrsib = bankFactory.getBank("ukrsibbank");
    static Bank xrest = bankFactory.getBank("xbank");
    static Bank pumb = bankFactory.getBank("pumb");
    static Bank alfa = bankFactory.getBank("AlfaBank");
       //PrivatBank
    public CurrentInform()
    {
        System.out.println("In current inform");
    }
    public double getPrivatUSDbuy() throws IOException {
        return privat.getUSDbuy();
    }
    public double getPrivatUSDsell() throws IOException {
        return privat.getUSDsell();
    }
    public double getPrivatEURbuy() throws IOException {
        return privat.getEURbuy();
    }
    public double getPrivatEURsell() throws IOException {
        return privat.getEURsell();
    }
    //UKRSIBBNAK
    public double getUKRSIBBNAKUSDbuy() throws IOException{
        return ukrsib.getUSDbuy();
    }
    public double getUKRSIBBNAKUSDsell() throws IOException{
        return ukrsib.getUSDsell();
    }
    public double getUKRSIBBNAKEURbuy() throws IOException{
        return ukrsib.getEURbuy();
    }
    public double getUKRSIBBNAKEURsell() throws IOException{
        return ukrsib.getEURsell();
    }
    //PravexBank
    public double getPravexUSDbuy() throws IOException{
        return pravex.getUSDbuy();
    }
    public double getPravexUSDsell() throws IOException{
        return pravex.getUSDsell();
    }
    public double getPravexEURbuy() throws IOException{
        return pravex.getEURbuy();
    }
    public double getPravexEURsell() throws IOException{
        return pravex.getEURsell();
    }
    public String getHTML() throws IOException{
        return pravex.getHTML("");
    }
    //XCityBank
    public double getXCityUSDbuy() throws IOException {
        return  xrest.getUSDbuy();
    }
    public double getXCityUSDsell() throws IOException {
        return  xrest.getUSDsell();
    }
    public double getXCityEURbuy() throws IOException {
        return  xrest.getEURbuy();
    }
    public double getXCityEURsell() throws IOException {
        return  xrest.getEURsell();
    }
    //PUMB
    public double getPUMBUSDbuy() throws IOException {
        return  pumb.getUSDbuy();
    }
    public double getPUMBUSDsell() throws IOException {
        return  pumb.getUSDsell();
    }
    public double getPUMBEURbuy() throws IOException {
        return  pumb.getEURbuy();
    }
    public double getPUMBEURsell() throws IOException {
        return  pumb.getEURsell();
    }
    //AlfaBank
    public double getAlfaBankUSDbuy() throws IOException {
        return  alfa.getUSDbuy();
    }
    public double getAlfaBankUSDsell() throws IOException {
        return  alfa.getUSDsell();
    }
    public double getAlfaBankEURbuy() throws IOException {
        return  alfa.getEURbuy();
    }
    public double getAlfaBankEURsell() throws IOException {
        return  alfa.getEURsell();
    }

    public static void main (String[] args) throws IOException {
           CurrentInform c = new CurrentInform();
       /* System.out.println(c.getXCityUSDbuy() + " " + c.getXCityUSDsell());
        System.out.println(c.getXCityEURbuy() + " " + c.getXCityEURsell());
        System.out.println(c.getAlfaBankEURbuy() + " " + c.getAlfaBankEURsell());
        System.out.println(c.getAlfaBankUSDbuy() + " " + c.getAlfaBankUSDsell());*/
        System.out.println(c.getPrivatUSDbuy());
    }
}
