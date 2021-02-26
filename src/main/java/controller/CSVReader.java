package controller;

import model.Loan;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * use me to read data
 */
public class CSVReader {

    private static final int MONTH = 1;
    private static final int YEAR = 12;


    public static List<Loan> readLoansWithHeader(File file){
        //List<Loan> loans = new ArrayList<>();

        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("book.csv"))) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        }
        catch (IOException e){
            //TODO: error handling
        }
        int monthMultiplier = headerParser(records.get(0));

        return loanParser(records, monthMultiplier);

    }

    /**
     * figures out if we're talking about years or months (assumed that intrest given is monthly)
     * @param headers header of file to read
     * @return returns approriate multiplier (YEAR constant if it finds "Years")
     */
    private static int headerParser(List<String> headers) {
        int header = MONTH;
        if(headers.get(3).equals("Years")){
            header = YEAR;
        }
        return header;
    }

    private static List<Loan> loanParser(List<List<String>> records, int monthMultiplier) {
        List<Loan> loans = new ArrayList<>();
                                            //Customer,Total loan,Interest,Years
        for(List<String> record : records){ //Karvinen,4356,1.27,6
            String customer = record.get(0);
            double totalLoan = Double.parseDouble(record.get(1));
            double interest = Double.parseDouble(record.get(2));
            int months = ((Integer.parseInt(record.get(3)))*monthMultiplier);
            loans.add(new Loan(customer, totalLoan, interest, months));
        }


        return loans;
    }

    private static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
