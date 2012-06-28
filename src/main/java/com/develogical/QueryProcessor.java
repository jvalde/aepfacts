package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.contains("hi")) {
            return "hello";
        }
        if (query.contains("what is your name")) {
            return "Lean Fighter";
        }
        if (query.contains("plus")) {
            query = query.replaceAll("what is ", "");
            query = query.replaceAll("plus ", "");
            String[] numbersString = query.split(" ");
            int total = 0;
            for(String number : numbersString){
                total = total + Integer.parseInt(number);
            }
            return String.valueOf(total);
        }
        return "";
    }

}
