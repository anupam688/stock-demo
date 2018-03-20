# stock-demo
Stock Demo for PayConiq
-This Application is built with Spring Boot
-JCS is used to store stocks in memory
-Server port used is 8088
-Security configuration with user and Roles is commented code


Please find sample request with url
-Get Stocks
http://localhost:8088/api/stocks

-Get Specific Stock
http://localhost:8088/api/stocks/1

-Add a stock
http://localhost:8088/api/stocks

Sample request
 {
        "stockId": 3,
        "stockName": "Anupam1",
        "currentPrice": 20000
    }
    
-Update a stock
http://localhost:8088/api/stocks/1

Sample Request
 {
        "stockName": "Anupam Rao",
        "currentPrice": 20000
    }
    
-Front End List of Stocks
http://localhost:8088/index.html

Things to do to make it better
-Logger Implementation while catching exception
-Adding CSS and styling to Front end
-Junits
