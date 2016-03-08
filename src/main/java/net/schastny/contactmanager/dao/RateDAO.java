package net.schastny.contactmanager.dao;

import java.util.Date;
import java.util.List;
import net.schastny.contactmanager.domain.Rate;
import org.springframework.transaction.annotation.Transactional;

public interface RateDAO {

	public void addRate(Rate rate);

	public List<Rate> listContact();

	public List listRatesById(Integer bankId);

	public List<Rate> listRatesByIdAndDate(Integer bankId, Date from, Date to);

	public void removeContact(Integer id);

	public Object lastRateById(Integer bankId);
}