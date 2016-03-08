package net.schastny.contactmanager.web;

import java.util.Date;
import java.util.Map;

import net.schastny.contactmanager.domain.Rate;
import net.schastny.contactmanager.service.RateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {

	@Autowired
	private RateService rateService;

	@RequestMapping("/index")
	public String listContacts(Map<String, Object> map) {

		map.put("rate", new Rate());
		map.put("contactList", rateService.listContact());
		map.put("allRates1", rateService.listRatesById(1));
		map.put("allRates2", rateService.listRatesById(2));
		map.put("allRates3", rateService.listRatesById(3));
		map.put("allRates4", rateService.listRatesById(4));
		return "contact";
	}
	@RequestMapping("/privatbank")
	public String list1(Map<String, Object> map) {
		map.put("allRates1", rateService.listRatesById(1));
		return "allrates1";
	}

	@RequestMapping(value = "/select1", method = RequestMethod.GET)
	public String selectRates1(Map<String, Object> map, Date from, Date to) {
		map.put("selectRates1",rateService.listRatesByIdAndDate(1, from, to));
		return "redirect:/privatbank";
	}

	@RequestMapping("/pravexbank")
	public String list2(Map<String, Object> map) {
		map.put("allRates2", rateService.listRatesById(2));
		return "allrates2";
	}
	@RequestMapping("/xcitybank")
	public String list3(Map<String, Object> map) {
		map.put("allRates3", rateService.listRatesById(3));
		return "allrates3";
	}
	@RequestMapping("/ukrsibbank")
	public String list4(Map<String, Object> map) {
		map.put("allRates4", rateService.listRatesById(4));
		return "allrates4";
	}
	@RequestMapping("/pumb")
	public String list5(Map<String, Object> map) {
		map.put("allRates5", rateService.listRatesById(5));
		return "allrates5";
	}
	@RequestMapping("/alfabank")
	public String list6(Map<String, Object> map) {
		map.put("allRates6", rateService.listRatesById(6));
		return "allrates6";
	}
	@RequestMapping("/rates")
	public String listRates(Map<String, Object> map) {

		map.put("rate", new Rate());
		map.put("contactList", rateService.listContact());
		map.put("current1", rateService.LastRateById(1));
		map.put("current2", rateService.LastRateById(2));
		map.put("current3", rateService.LastRateById(3));
		map.put("current4", rateService.LastRateById(4));
		map.put("current5", rateService.LastRateById(5));
		map.put("current6", rateService.LastRateById(6));
		return "currency";
	}

	@RequestMapping("/")
	public String home() {
		return "redirect:http://light-way.org/main.html";
	}



	@RequestMapping("/delete/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer contactId) {

		rateService.removeContact(contactId);

		return "redirect:/index";
	}

}
