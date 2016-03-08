package net.schastny.contactmanager.Banks;

/**
 * Created with IntelliJ IDEA.
 * User: админ
 * Date: 26.11.14
 * Time: 0:45
 * To change this template use File | Settings | File Templates.
 */
public class BankFactory {
    public Bank getBank(String bankName){
        Bank bank = null;
        if(bankName == null)
            bank = null;
        if(bankName.equalsIgnoreCase("UkrSibbank"))
            bank = new BankUkrSib();
        else if(bankName.equalsIgnoreCase("PravexBank"))
            bank =  new BankPravex();
        else if (bankName.equalsIgnoreCase("PrivatBank"))
            bank = new BankPrivat();
        else if (bankName.equalsIgnoreCase("XBank"))
            bank = new BankXCity();
        else if (bankName.equalsIgnoreCase("PUMB"))
            bank = new BankPUMB();
        else if (bankName.equalsIgnoreCase("AlfaBank"))
            bank = new BankAlfa();

        return bank;
    }
}
