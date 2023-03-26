/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**************************************************** 
Program Name: Stocks4UGUI.java 
Programmer's Name: Edward Alvarado 
Program Description: This GUI takes in stock parameters, stores those stocks into a JList using a stock model and displays the current profit/loss of each stock. 
***********************************************************/
public class Stock 
{
    private String companyName;
    private double numberOfShares, purchasePrice, currentPrice;
    
    //constructors
    
    public Stock(){
        companyName = "n/a";
        numberOfShares = 0.0;
        purchasePrice = 0.0;
        currentPrice = 0.0;
    } // end of default constructor
    
    public Stock(String companyName, double numberOfShares, double purchasePrice, double currentPrice){
        setPurchasePrice(purchasePrice);
        setCurrentPrice(currentPrice);
        setCompanyName(companyName);
        setNumberOfShares(numberOfShares);
    }
    
    // behaviors
    public double getProfitLoss(){
        return numberOfShares * (currentPrice - purchasePrice);
    }
    
    @Override
    public String toString(){
        return companyName;
    }
    // getters and setters
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(double numberOfShares) {
        if(numberOfShares >0.0)
            this.numberOfShares = numberOfShares;
        else
            this.numberOfShares = 0.0;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        if(purchasePrice > 0.0)
            this.purchasePrice = purchasePrice;
        else
            this.purchasePrice = 0.0;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        if(currentPrice > 0)
            this.currentPrice = currentPrice;
        else
            this.currentPrice = 0.0;
    }
    
    
}// end of stock class
