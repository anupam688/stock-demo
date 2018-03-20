package com.payconiq.demo.entities;

import java.util.Date;

/**
 * The Class StockInfo.
 */
public class StockInfo {

	/** The stock id. */
	Integer stockId;

	/** The stock name. */
	String stockName;

	/** The current price. */
	Double currentPrice;

	/** The last update. */
	Date lastUpdate;

	/**
	 * Gets the stock id.
	 *
	 * @return the stock id
	 */
	public Integer getStockId() {
		return stockId;
	}

	/**
	 * Sets the stock id.
	 *
	 * @param stockId
	 *            the new stock id
	 */
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	/**
	 * Gets the stock name.
	 *
	 * @return the stock name
	 */
	public String getStockName() {
		return stockName;
	}

	/**
	 * Sets the stock name.
	 *
	 * @param stockName
	 *            the new stock name
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	/**
	 * Gets the current price.
	 *
	 * @return the current price
	 */
	public Double getCurrentPrice() {
		return currentPrice;
	}

	/**
	 * Sets the current price.
	 *
	 * @param currentPrice
	 *            the new current price
	 */
	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}

	/**
	 * Gets the last update.
	 *
	 * @return the last update
	 */
	public Date getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * Sets the last update.
	 *
	 * @param lastUpdate
	 *            the new last update
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
