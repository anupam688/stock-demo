package com.payconiq.demo;

import java.util.ArrayList;
import java.util.Date;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.payconiq.demo.entities.StockInfo;

/**
 * The Class StockDemoApplication.
 */
@SpringBootApplication
public class StockDemoApplication {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws CacheException
	 *             the cache exception
	 */
	public static void main(String[] args) throws CacheException {
		//Initializing cache and adding Initial stocks 
		JCS.getInstance("default").clear();
		ArrayList<StockInfo> stockInfoList = new ArrayList<StockInfo>();
		StockInfo stockInfo = new StockInfo();
		stockInfo.setStockId(1);
		stockInfo.setStockName("Anupam");
		stockInfo.setCurrentPrice(20000.0);
		stockInfo.setLastUpdate(new Date());
		stockInfoList.add(stockInfo);
		stockInfo = new StockInfo();
		stockInfo.setStockId(2);
		stockInfo.setStockName("Eva");
		stockInfo.setCurrentPrice(30000.0);
		stockInfo.setLastUpdate(new Date());
		stockInfoList.add(stockInfo);
		JCS.getInstance("default").put("StockInfoList", stockInfoList);
		SpringApplication.run(StockDemoApplication.class, args);
	}
}
