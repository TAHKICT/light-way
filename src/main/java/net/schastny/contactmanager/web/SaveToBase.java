package net.schastny.contactmanager.web;

import net.schastny.contactmanager.Banks.CurrentInform;
import net.schastny.contactmanager.domain.Rate;
import net.schastny.contactmanager.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by админ on 27.12.2014.
 */
@EnableScheduling
public class SaveToBase {

    @Autowired
    private RateService rateService;

    private static CurrentInform current = new CurrentInform();
    public String getTime () throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return (dateFormat.format(date).toString());
    }

  //  @Scheduled(cron = "0 0 9 * *  ?")
    public void savePrivat() throws IOException {
        Rate putInBase = new Rate();
        putInBase.setBankId(1);
        putInBase.setTTime(getTime());
        putInBase.setEURbuy((float) current.getPrivatEURbuy());
        putInBase.setEURsell((float) current.getPrivatEURsell());
        putInBase.setUSDbuy((float) current.getPrivatUSDbuy());
        putInBase.setUSDsell((float) current.getPrivatUSDsell());
        System.out.println("id===="+putInBase.getId());
        System.out.println("time===="+putInBase.getTTime());
        System.out.println("usd===="+putInBase.getUSDbuy());
        rateService.addRate(putInBase);
    }
   /* @Scheduled(cron = "0 59 10 * *  ?")
    public void savePravex() throws IOException {
        Rate putInBase = new Rate(2,getTime(),current.getPravexUSDbuy(),current.getPravexUSDsell(),current.getPrivatEURbuy(),current.getPravexEURsell());
        rateService.addRate(putInBase);
    }
    @Scheduled(cron = "0 30 9 * *  ?")
    public void saveUkrSib() throws IOException {
        Rate putInBase = new Rate(3,getTime(),current.getUKRSIBBNAKUSDbuy(),current.getUKRSIBBNAKUSDsell(),current.getUKRSIBBNAKEURbuy(),current.getUKRSIBBNAKEURsell());
        rateService.addRate(putInBase);
    }
    @Scheduled(cron = "0 30 9 * *  ?")
    public void saveXBank() throws IOException {
        Rate putInBase = new Rate(4,getTime(),current.getXCityUSDbuy(),current.getXCityUSDsell(),current.getXCityEURbuy(),current.getXCityEURsell());
        rateService.addRate(putInBase);
    }
    @Scheduled(cron = "0 0 9 * *  ?")
    public void savePUMB() throws IOException {
        Rate putInBase = new Rate(5,getTime(),current.getPUMBUSDbuy(),current.getPUMBUSDsell(),current.getPUMBEURbuy(),current.getPUMBEURsell());
        rateService.addRate(putInBase);
    }
    @Scheduled(cron = "0 0 9 * *  ?")
    public void saveAlfaBank() throws IOException {
        Rate putInBase = new Rate(6,getTime(),current.getAlfaBankUSDbuy(),current.getAlfaBankUSDsell(),current.getAlfaBankEURbuy(),current.getAlfaBankEURsell());
        rateService.addRate(putInBase);
    }
*/
    public static void main(String[] args) throws IOException {
        SaveToBase saveToBase = new SaveToBase();
        saveToBase.savePrivat();
    }

}
