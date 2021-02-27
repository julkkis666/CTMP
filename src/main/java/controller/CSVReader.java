package controller;

import model.Loan;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * use me to read data
 */
public class CSVReader {

    private static final int MONTH = 1;
    private static final int YEAR = 12;


    private static List<String> getRecordFromLine(String line) {
        List<String> row = new LinkedList<>();

        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                row.add(rowScanner.next());
            }
        }
        if (row.size()<=2){
            return new ArrayList<>();//row;
        }
        return parseBigString(row);
    }

    public static List<Loan> readLoansWithHeader(File file){
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                List<String> record = getRecordFromLine(scanner.nextLine());
                if(!record.isEmpty()) { //removes all extra "records" that do not confirm to certain requierments.
                    records.add(record);
                }
            }
        }
        catch (IOException e){
            //TODO: error handling
            JOptionPane.showMessageDialog(null, "data loading error");
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
            if(!record.equals(records.get(0))){
                String customer = record.get(0);
                double totalLoan = Double.parseDouble(record.get(1));
                double interest = Double.parseDouble(record.get(2));
                int months = ((Integer.parseInt(record.get(3)))*monthMultiplier);

                boolean plural = false;
                if(!record.get(4).isEmpty()){
                    plural = true;
                }

                loans.add(new Loan(customer, totalLoan, interest, months, plural));
            }

        }
        return loans;
    }


    /**
     * used to parse "big strings" where citation marks("") are used to determine a string
     * @param row to parse
     * @return parses the row for a big string. (only combines one "word,signified,by,Citationmarks"). adds "and" to make more gramatical.
     */
    private static List<String> parseBigString(List<String> row){
        if(row.get(0).contains("\"")){
            try{
                int i = 1;
                while(row.get(i).contains("\"")){
                    row.set(0, row.get(0)+" and "+row.get(i));
                    i++;
                }
                row.set(0,row.get(0).replace("\"",""));//trimmer

                //TODO: prob doesn't work for words with multiple commas.
                for(int j = 1 ; j < i ; j++){ //removes unneccesary strings
                    row.remove(j);
                }

                //add plural identifier
                row.add(""+i);

            }catch(IndexOutOfBoundsException e){
            }
        }
        else{
            row.add("");
        }
    return row;
    }

}
