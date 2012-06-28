package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.equalsIgnoreCase("hi")) {
            return "hello";
        }
        if (query.contains("what is your name")) {
            return "Lean Fighter";
        }
        if (query.contains("plus")) {
            query = query.split(":")[1].replaceAll(" what is ", "");
            query = query.replaceAll("plus ", "");
            String[] numbersString = query.split(" ");
            int total = 0;
            for(String number : numbersString){
                total = total + Integer.parseInt(number);
            }
            return String.valueOf(total);
        }
        if (query.contains("multiplied")) {
            query = query.split(":")[1].replaceAll(" what is ", "");
            query = query.replaceAll("multiplied by ", "");
            String[] numbersString = query.split(" ");
            int total = Integer.parseInt(numbersString[0]) * Integer.parseInt(numbersString[1]);
            return String.valueOf(total);
        }
        if (query.contains("largest")) {
            String[] numbersString = query.split(":")[2].replaceAll(" ","").split(",");
            int biggestNumber = 0;
            for(String number : numbersString){
                if(Integer.parseInt(number) > 0){
                    biggestNumber = Integer.parseInt(number);
                }
            }

            return String.valueOf(biggestNumber);
        }
        return "";
    }

}
