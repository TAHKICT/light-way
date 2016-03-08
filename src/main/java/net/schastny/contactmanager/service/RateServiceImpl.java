package net.schastny.contactmanager.service;
 
import java.util.Date;
import java.util.List;

import net.schastny.contactmanager.domain.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import net.schastny.contactmanager.dao.RateDAO;

@Service
public class RateServiceImpl implements RateService {
 
    @Autowired
    private RateDAO rateDAO;
 
    @Transactional
    public void addRate(Rate rate) {
        Rate newRate = new Rate();
        newRate.setBankId(rate.getBankId());
        newRate.setTTime(rate.getTTime());
        newRate.setUSDbuy((float) rate.getUSDbuy());
        newRate.setUSDsell((float) rate.getUSDbuy());
        newRate.setEURbuy((float) rate.getUSDbuy());
        newRate.setEURsell((float) rate.getUSDbuy());
        rateDAO.addRate(newRate);
    }
 
    @Transactional
    public List<Rate> listContact() {
        return rateDAO.listContact();
    }

    @Transactional
    public List<Rate> listRatesById(Integer bankId) {
        return rateDAO.listRatesById(bankId);
    }

    @Transactional
    public List<Rate> listRatesByIdAndDate(Integer bankId, Date from, Date to) {
        return rateDAO.listRatesByIdAndDate(bankId,from,to);
    }

    @Transactional
    public Rate LastRateById(Integer bankId) {
        return (Rate) rateDAO.lastRateById(bankId);
    }



    @Transactional
    public void removeContact(Integer id) {
        rateDAO.removeContact(id);
    }
}
