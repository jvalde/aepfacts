package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.contains("hi") && !query.contains("04d115D0")) {
            return "hello";
        }
        if (query.contains("what is your name")) {
            return "Lean Fighter";
        }
        if (query.contains("plus")) {
            query = query.replaceAll("32b4e260: what is ", "");
            query = query.replaceAll("plus ", "");
            String[] numbersString = query.split(" ");
            int total = 0;
            for(String number : numbersString){
                total = total + Integer.parseInt(number);
            }
            return String.valueOf(total);
        }
        if (query.contains("04d115D0")) {
            query = query.replaceAll("04d115D0: which of the following numbers is the largest: ", "");
            String[] numbersString = query.split(", ");
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
