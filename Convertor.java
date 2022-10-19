//Interface of the Convo Check project
interface ConvertorInterf{
    void infixToPrefix(String expression);
    void prefixToInfix(String expression);
    void infixToPostfix(String expression);
    void postfixToInfix(String expression);
    int postfixEvaluation(String expression);
    int prefixEvaluation(String expression);
}

//Adapter class implementing the interface methods
abstract class AdapterClass implements ConvertorInterf{
    public void infixToPrefix(String expression){}
    public void prefixToInfix(String expression){}
    public void infixToPostfix(String expression){}
    public void postfixToInfix(String expression){}
    public int postfixEvaluation(String expression){
        return 0;
    }
    public int prefixEvaluation(String expression){
        return 0;
    }
}