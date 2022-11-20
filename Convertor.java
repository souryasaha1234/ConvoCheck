//Interface of the Convo Check project
interface ConvertorInterf{
    String infixToPrefix(String expression);
    String prefixToInfix(String expression);
    String infixToPostfix(String expression);
    String postfixToInfix(String expression);
    int postfixEvaluation(String expression);
    int prefixEvaluation(String expression);
    String Convert(String num,int x,int y);
}

//Adapter class implementing the interface methods
abstract class AdapterClass implements ConvertorInterf{
    public String infixToPrefix(String expression){
        return null;
    }
    public String prefixToInfix(String expression){
        return null;
    }
    public String infixToPostfix(String expression){
        return null;
    }
    public String postfixToInfix(String expression){
        return null;
    }
    public int postfixEvaluation(String expression){
        return 0;
    }
    public int prefixEvaluation(String expression){
        return 0;
    }
    public String Convert(String num,int x,int y){
        return null;
    }
}