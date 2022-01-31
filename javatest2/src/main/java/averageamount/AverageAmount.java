package averageamount;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This program is to load the data from the file and
 *  determines the average amount in Euros(EUR)
 * grouped by Country and Credit Rating

 */

public class AverageAmount {
    public static void main(String[] args) throws FileNotFoundException {

        AverageAmount avgAmount = new AverageAmount();

        /**
         * reading the contents of the file in readFile() and
         *  store the contents in an array list of strings
         */

        ArrayList<String> infoFromFile = avgAmount.readFile();

        //All the contents of file are in infoFromFile
//        for(int i=0;i<infoFromFile.size();i++){
//            System.out.println(infoFromFile.get(i));
//        }

        //Creating ArrayList of  class Info objects and adding contents to it
        ArrayList<Info> informationList = new ArrayList<Info>();
        for(int i=0;i<infoFromFile.size();i++){
            String curLine=infoFromFile.get(i);
            String[] splitted = curLine.split("\t");

            int companyCode = Integer.parseInt(splitted[0]);
            int  account = Integer.parseInt(splitted[1]);
            double amount = Double.parseDouble(splitted[6]);

            String currenyType = splitted[5].trim();

            // converting current currency to euros based on the exchange rate
            if (currenyType.equals("CHF")) {
                amount = amount * 1.10;
            } else if (currenyType.equals("GBP")) {
                amount = amount * 1.654;
            }
            amount = amount / 1.35;

            informationList.add(new Info(companyCode, account, splitted[2].trim(),
                    splitted[3].trim(), splitted[4].trim(), splitted[5].trim(), amount));
        }

        //Replacing country value with city if it is empty
        for (int i = 0; i < informationList.size(); i++) {

            if (informationList.get(i).getCountry().equals("")) {
                informationList.get(i).setCountry(informationList.get(i).getCity());
            }
        }

        //grouping by country and credit rating
        Map<String, Map<String, Double>> countryCreditRatingMap = informationList.stream()
                .collect(
                        Collectors.groupingBy(Info::getCountry,
                                Collectors.groupingBy(Info::getCreditRating,
                                        Collectors.averagingDouble(Info::getAmount))));

        //Displaying the amount
        System.out.println("Displaying average amount grouping by Country and Credit Rating");
        for(Map.Entry<String, Map<String, Double>> entry : countryCreditRatingMap.entrySet()) {
            String key = entry.getKey();
            Map<String, Double> values = entry.getValue();
            System.out.println("Country : " + key);
            for (Map.Entry<String, Double> newentry : values.entrySet()) {
                String newkey = newentry.getKey();
                Double newvalue = newentry.getValue();
                System.out.println("Credit Rating "+newkey+" : "+newvalue+" Euros");

            }
            System.out.println("-----------------------------------------");
        }

    }

    public  ArrayList<String> readFile() {

        Scanner scanner = null;
        ArrayList<String> infoFromFile = new ArrayList<String>();
        try {

            //reading the contents of the file and add these contents to the ArrayList of Strings
            File file= new File(new File("src/test/resources/FILE.DAT").getAbsolutePath());
            scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNext()) {
                String curLine = scanner.nextLine();
                infoFromFile.add(curLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }finally {
            scanner.close();
        }
        return infoFromFile;

    }
}





