package net.schastny.contactmanager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exchange")
public class Rate {

	@Id
	@Column(name = "enumId")
	@GeneratedValue
	private Integer id;

	@Column(name = "bankId")
	private Integer bankId;

	@Column(name = "TTime")
	private String TTime;

	@Column(name = "USDbuy")
	private double USDbuy;

	@Column(name = "USDsell")
	private double USDsell;

	@Column(name = "EURbuy")
	private double EURbuy;

	@Column(name = "EURsell")
	private double EURsell;

	/*public Rate(){}
	public Rate(Integer bankId, String TTime, double USDbuy, double USDsell, double EURbuy, double EURsell){
		System.out.println("in rate");
		this.bankId = bankId;
		this.TTime = TTime;
		this.USDbuy = USDbuy;
		this.USDsell = USDsell;
		this.EURbuy = EURbuy;
		this.EURsell = EURsell;
	}*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public String getTTime() {
		return TTime;
	}

	public void setTTime(String TTime) {
		this.TTime = TTime;
	}

	public double getUSDbuy() {
		return USDbuy;
	}

	public void setUSDbuy(float USDbuy) {
		this.USDbuy = USDbuy;
	}

	public double getUSDsell() {
		return USDsell;
	}

	public void setUSDsell(float USDsell) {
		this.USDsell = USDsell;
	}

	public double getEURbuy() {
		return EURbuy;
	}

	public void setEURbuy(float EURbuy) {
		this.EURbuy = EURbuy;
	}

	public double getEURsell() {
		return EURsell;
	}

	public void setEURsell(float EURsell) {
		this.EURsell = EURsell;
	}

}
