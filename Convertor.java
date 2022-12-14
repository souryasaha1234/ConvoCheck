//Interface of the Convo Check project
/*This Interface contains all the methods of the project to be implemented */
interface ConvertorInterf{
    String infixToPrefix(String expression);
    String prefixToInfix(String expression);
    String infixToPostfix(String expression);
    String postfixToInfix(String expression);
    int postfixEvaluation(String expression);
    int prefixEvaluation(String expression);
    String Convert(String num,int x,int y);
    int binToGray(int bin);
    int grayToBin(int gray);
    String decToBCD(int dec);
    int BCDToBin(int bcd);
    int binToExcess3(int bin);
    int Excess3ToBin(int Excess);
    int grayToExcess3(int gray);
    int Excess3ToGray(int excess);
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
    public int binToGray(int bin){
        return 0;
    }
    public int grayToBin(int gray){
        return 0;
    }
    public String decToBCD(int dec){
        return null;
    }
    public int BCDToBin(int bcd){
        return 0;
    }
    public int binToExcess3(int bin){
        return 0;
    }
    public int Excess3ToBin(int Excess){
        return 0;
    }
    public int grayToExcess3(int gray){
        return 0;
    }
    public int Excess3ToGray(int excess){
        return 0;
    }
}