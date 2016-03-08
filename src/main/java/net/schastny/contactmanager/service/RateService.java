package net.schastny.contactmanager.service;

import java.util.Date;
import java.util.List;
import net.schastny.contactmanager.domain.Rate;

public interface RateService {

	public void addRate(Rate rate);

	public List<Rate> listContact();

	public List<Rate> listRatesById(Integer bankId);

	public List<Rate> listRatesByIdAndDate(Integer bankId, Date from, Date to);

	public Rate LastRateById(Integer bankId);

	public void removeContact(Integer id);
}
