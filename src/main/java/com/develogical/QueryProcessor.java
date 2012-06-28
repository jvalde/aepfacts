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
        if (query.contains("minus")) {
            query = query.split(":")[1].replaceAll(" what is ", "");
            query = query.replaceAll("minus ", "");
            String[] numbersString = query.split(" ");
            int total = Integer.parseInt(numbersString[0]) - Integer.parseInt(numbersString[1]);
            return String.valueOf(total);
        }
        if (query.contains("to the power of")) {
            query = query.split(":")[1].replaceAll(" what is ", "");
            query = query.replaceAll("to the power of ", "");
            String[] numbersString = query.split(" ");
            double total = Math.pow(new Double(numbersString[0]), new Double(numbersString[1]));
            return String.valueOf(total);
        }
        if (query.contains("multiplied")) {
            query = query.split(":")[1].replaceAll(" what is ", "");
            query = query.replaceAll("multiplied by ", "");
            String[] numbersString = query.split(" ");
            int total = Integer.parseInt(numbersString[0]) * Integer.parseInt(numbersString[1]);
            return String.valueOf(total);
        }
        if (query.contains("Fibonacci")) {
            query = query.split(":")[1].replaceAll(" what is the", "");
            query = query.replaceAll("th number in the Fibonacci sequence", "");
            query = query.replaceAll(" ", "");
            int total = fibonacci(Integer.parseInt(query));
            return String.valueOf(total);
        }
        if (query.contains("largest")) {
            String[] numbersString = query.split(":")[2].replaceAll(" ","").split(",");
            int biggestNumber = 0;
            for(String number : numbersString){
                if(Integer.parseInt(number) > biggestNumber){
                    biggestNumber = Integer.parseInt(number);
                }
            }

            return String.valueOf(biggestNumber);
        }
        if (query.contains("prime")) {
            String[] numbersString = query.split(":")[2].replaceAll(" ","").split(",");

            String primeNumbers = "";
            for(String number : numbersString){
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

        //"dc0d00b0: which of the following numbers is both a square and a cube: 55, 1"
        return "";
    }

    private boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public static int fibonacci(int n){
        int a=0,b=1;

        for (int i=0;i<n;i++){
            a=a+b;
            b=a-b;
        }
        return a;
    }

}
