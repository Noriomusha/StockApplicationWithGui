
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Edward Alvarado
 */
public class StockIO {

    //attributes
    private String fileName;

    // constructors
    public StockIO() {
        fileName = "Stocks.txt";
    }

    public StockIO(String fileName) {
        setFileName(fileName);
    }

    //behaviors
    public ArrayList<Stock> getData() {
        //create arraylist
        ArrayList<Stock> data = new ArrayList<Stock>();

        try {
            // load the arraylsit with the data from the file
            BufferedReader inFile = new BufferedReader(new FileReader(fileName));
            String inputLine = "";
            StringTokenizer tokens;
            
            //get the first line
            inputLine = inFile.readLine();
            
            // cycle through the file and read line by line
            while(inputLine !=null)
            {
                //break the line into parts -- IBM,10,500,800
                tokens = new StringTokenizer(inputLine, ",");
                String company = tokens.nextToken();
                double shares = Double.parseDouble(tokens.nextToken());
                double pPrice = Double.parseDouble(tokens.nextToken());
                double cPrice = Double.parseDouble(tokens.nextToken());
                
                //create a stock object and add it to the arraylist
                Stock stk = new Stock(company, shares, pPrice, cPrice);
                data.add(stk);
                
                // read the next line in the file
                inputLine = inFile.readLine();
            }
            
            // close the file
            inFile.close();
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error unable to write to the file" + ex.getMessage(), fileName, JOptionPane.ERROR_MESSAGE);
        }
        // reutrn the array list
        return data;
    }

    public void saveData(ArrayList<Stock> data) {
        // Apple,100,55.0,88.0

        try {
            // create a pipe to the file
            BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName));

            //write the stocks by cycling through the data
            for (int i = 0; i < data.size(); i++) {
                Stock stk = data.get(i);
                outFile.write(stk.getCompanyName() + ',');
                outFile.write("" + stk.getNumberOfShares() + ',');
                outFile.write("" + stk.getPurchasePrice() + ',');
                outFile.write("" + stk.getCurrentPrice() + ',');
                outFile.newLine();          // Enter key to drop to next line

            }

            //close the file
            outFile.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error unable to write to the file" + ex.getMessage(), fileName, JOptionPane.ERROR_MESSAGE);
        }

    }

    // getters and setters
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        if (fileName.length() > 0) {
            this.fileName = fileName;
        } else {
            this.fileName = "Stocks.txt";
        }

    }

}
