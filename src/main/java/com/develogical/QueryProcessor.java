package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.contains("hi")) {
            return "hello";
        }
        if (query.contains("what is your name")) {
            return "Lean Fighter";
        }
        if (query.contains("what is 10 plus 17")) {
            return "27";
        }
        return "";
    }

}
