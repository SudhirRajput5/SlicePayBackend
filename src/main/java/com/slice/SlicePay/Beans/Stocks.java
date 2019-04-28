package com.slice.SlicePay.Beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Stocks")
public class Stocks {

	@Id
	@Column
	private int id;
	
	@Column(name = "date")
	private Date date;
	
	@Column
	private String symbol;
	
	@Column
	private Double open;
	
	@Column
	private Double close;
	
	@Column
	private Double low;
	
	@Column
	private Double high;
	
	@Column
	private Double volume;
	
	
	public Stocks(int id, Date date, String symbol, Double open, Double close, Double low, Double high, Double volume) {
		this.id = id;
		this.date = date;
		this.symbol = symbol;
		this.open = open;
		this.close = close;
		this.low = low;
		this.high = high;
		this.volume = volume;
	}
	
	public Stocks()
	{
		this(0, new Date(), "AAA", 0.0, 0.0, 0.0, 0.0, 0.0);
	}


	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}


	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}


	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	/**
	 * @return the open
	 */
	public Double getOpen() {
		return open;
	}


	/**
	 * @param open the open to set
	 */
	public void setOpen(Double open) {
		this.open = open;
	}


	/**
	 * @return the close
	 */
	public Double getClose() {
		return close;
	}


	/**
	 * @param close the close to set
	 */
	public void setClose(Double close) {
		this.close = close;
	}


	/**
	 * @return the low
	 */
	public Double getLow() {
		return low;
	}


	/**
	 * @param low the low to set
	 */
	public void setLow(Double low) {
		this.low = low;
	}


	/**
	 * @return the high
	 */
	public Double getHigh() {
		return high;
	}


	/**
	 * @param high the high to set
	 */
	public void setHigh(Double high) {
		this.high = high;
	}


	/**
	 * @return the volume
	 */
	public Double getVolume() {
		return volume;
	}


	/**
	 * @param volume the volume to set
	 */
	public void setVolume(Double volume) {
		this.volume = volume;
	}
	
	
}
