package com.develogical;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    public String process(String query) {
        if (query.equalsIgnoreCase("hi")) {
            return "hello";
        }
        if (query.contains("what is your name")) {
            return "Lean Fighter";
        }
        if (query.contains("what colour is a banana")) {
            return "yellow";
        }
        if (query.contains("which city is the Eiffel tower in")) {
            return "Paris";
        }
        if (query.contains("what currency did spain")) {
            return "Peseta";
        }
        if (query.contains("who played James Bond")) {
            return "Sean Connery";
        }
        if (query.contains("plus")) {
            int total = 0;
            for(String number : getParameters(cleanKey(query))){
                total = total + Integer.parseInt(number);
            }
            return String.valueOf(total);
        }
        List <String> parameters;
        if (query.contains("minus")) {
            parameters = getParameters(cleanKey(query));
            int total = Integer.parseInt(parameters.get(0)) - Integer.parseInt(parameters.get(1));
            return String.valueOf(total);
        }
        if (query.contains("to the power of")) {
            parameters = getParameters(cleanKey(query));
            double total = Math.pow(new Double(parameters.get(0)), new Double(parameters.get(1)));

            return String.valueOf(new BigDecimal(total));
        }
        if (query.contains("multiplied")) {
            parameters = getParameters(cleanKey(query));
            int total = Integer.parseInt(parameters.get(0)) * Integer.parseInt(parameters.get(1));
            return String.valueOf(total);
        }
        if (query.contains("Fibonacci")) {
            parameters = getParameters(cleanKey(query));
            int total = fibonacci(Integer.parseInt(parameters.get(0)));
            return String.valueOf(total);
        }
        if (query.contains("largest")) {
            parameters = getParameters(cleanKey(query));
            int biggestNumber = 0;
            for(String number : parameters){
                if(Integer.parseInt(number) > biggestNumber){
                    biggestNumber = Integer.parseInt(number);
                }
            }

            return String.valueOf(biggestNumber);
        }
        if (query.contains("prime")) {
            parameters = getParameters(cleanKey(query));

            String primeNumbers = "";
            for(String number : parameters){
                if(isPrime(Integer.parseInt(number))){
                    if(primeNumbers.equalsIgnoreCase("")){
                        primeNumbers = number;
                    }else{
                        primeNumbers = primeNumbers + ", " + number;
                    }

                }
            }

            return primeNumbers;
        }
        if (query.contains("square and a cube")) {
            String[] numbersString = query.split(":")[2].replaceAll(" ","").split(",");
            int primeNumer = 0;
            for(String number : numbersString){
                if(isPrime(Integer.parseInt(number))){
                    primeNumer = Integer.parseInt(number);
                }
            }

            return String.valueOf(primeNumer);
        }
        return "";
    }

    private boolean isPrime(int number) {
        boolean isPrime = false;
        int i;
        for (i=2; i < number ;i++ ){
            int n = number%i;
            if (n==0){
                isPrime = false;
                break;
            }
        }
        if(i == number){
            isPrime = true;
        }

        return isPrime;
    }

    public static int fibonacci(int n){
        int a=0,b=1;

        for (int i=0;i<n;i++){
            a=a+b;
            b=a-b;
        }
        return a;
    }
    
    private String cleanKey(String queryString){
        return queryString.substring(queryString.indexOf(':'), queryString.length());
    }
    
    private List<String> getParameters(String queryString){
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(queryString);
        List<String> parameters = new ArrayList<String>();

        while(m.find()){

            parameters.add(m.group());

        }
        
        return parameters;
    }

}
