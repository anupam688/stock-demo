package com.payconiq.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payconiq.demo.entities.StockInfo;

/**
 * The Class StockController.
 */
@RestController
public class StockController {

	/**
	 * Gets the stocks.
	 *
	 * @return the stocks
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/api/stocks", method = RequestMethod.GET)
	@GetMapping
	public List<StockInfo> getStocks() {
		List<StockInfo> stockInfoList = null;
		try {
			stockInfoList = (List<StockInfo>) JCS.getInstance("default").get("StockInfoList");
		} catch (CacheException e) {
			e.printStackTrace();
		}
		return stockInfoList;
	}

	/**
	 * Gets the stocks.
	 *
	 * @param stockId
	 *            the stock id
	 * @return the stocks
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/api/stocks/{stockId}")
	@GetMapping
	public StockInfo getStocks(@PathVariable("stockId") Integer stockId) {
		List<StockInfo> stockInfoList = null;
		StockInfo matchedStockInfo = new StockInfo();
		try {
			stockInfoList = (List<StockInfo>) JCS.getInstance("default").get("StockInfoList");
		} catch (CacheException e) {

			return matchedStockInfo;
		}
		if (stockInfoList != null) {
			for (StockInfo stockInfo : stockInfoList) {
				if (stockInfo.getStockId() == stockId) {
					matchedStockInfo = stockInfo;
				}
			}
		}
		return matchedStockInfo;
	}

	/**
	 * Adds the stocks.
	 *
	 * @param stockInfo
	 *            the stock info
	 * @return the string
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/api/stocks", method = RequestMethod.POST, consumes = "application/json", produces = "application/json", headers = "Content-Type=application/json")
	public String addStocks(@RequestBody StockInfo stockInfo) {
		List<StockInfo> stockInfoList = null;
		try {
			stockInfoList = (List<StockInfo>) JCS.getInstance("default").get("StockInfoList");
			if (stockInfo != null) {
				stockInfo.setLastUpdate(new Date());
				stockInfoList.add(stockInfo);
				JCS.getInstance("default").put("StockInfoList", stockInfoList);
			}
		} catch (CacheException e) {

			return "Stock Couldn't be added due to technical reasons";
		}
		return "Stock Added Scucessfully";
	}

	/**
	 * Update stocks.
	 *
	 * @param stockId
	 *            the stock id
	 * @param stockInfo
	 *            the stock info
	 * @return the string
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/api/stocks/{stockId}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json", headers = "Content-Type=application/json")
	public String updateStocks(@PathVariable("stockId") Integer stockId, @RequestBody StockInfo stockInfo) {
		List<StockInfo> stockInfoList = null;
		List<StockInfo> stockInfoUpdatedList = new ArrayList<StockInfo>();
		try {
			stockInfoList = (List<StockInfo>) JCS.getInstance("default").get("StockInfoList");
			if (stockInfoList != null) {
				for (StockInfo currentStockInfo : stockInfoList) {
					if (currentStockInfo.getStockId() == stockId) {
						stockInfo.setStockId(stockId);
						stockInfo.setLastUpdate(new Date());
						stockInfoUpdatedList.add(stockInfo);
					} else {
						stockInfoUpdatedList.add(currentStockInfo);
					}
				}
				JCS.getInstance("default").put("StockInfoList", stockInfoUpdatedList);
			}
		} catch (CacheException e) {

			return "Stock Couldn't be Updated due to technical reasons";
		}
		return "Stock Updated Scucessfully";
	}

}
