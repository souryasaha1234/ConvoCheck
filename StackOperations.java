/*This Stack.java file contains two classes
 * 1) Stack
 * The Stack class contains an integer Stack with basic push and pop operations
 * This Stack is implemented by using Arrays
 * 2) Operator Stack
 * The Operator Stack class contains a character Stack with basic push and pop operations
 * This Operator Stack is implemented by using Character Arrays
 */


class StackOperations{
    //Stack Class
    int[] array = new int[32];//The integer Stack
    int top = -1;//Setting the top value as -1 as there is no element initially
    public int isEmpty(){
        //To Check if the Stack is empty or not
        if(this.top == -1){
            return 1;
        }
        return 0;
    }
    public int isFull(){
        //To check if the Stack is Full or not
        if(this.top == 31){
            return 1;
        }
        return 0;
    }
    public int push(int item){
        //Pushing into the Stack
        if(this.isFull() == 1){
            //If the Stack is Full then it will be Stack Overflow and insertion is not possible
            System.out.println("Insertion not possible...");
            return 0;//Return 0 for unsuccessfull push
        }
        //If the Stack is not full Then push the element into the Stack
        this.array[++this.top] = item;
        return 1;//Return 1 for successfull push
    }
    public int pop(){
        /*if(this.isEmpty() == 1){
            System.out.println("Deletion not possible...");
            return 0;
        }*/
        //Poping the Stack top item
        int popItem = this.array[this.top];
        this.top--;//Decrementing the top value
        return popItem;//Returning The popped item
    }
    public void display(){
        //Displaying the Stack
        System.out.println("The items of the stack are as follows : ");
        for(int i = 0; i<=this.top; i++)
        {
            System.out.print(this.array[i]+" ");
        }
        System.out.println();
        return;
    }
}

class OperatorStack{
    char[] operatorStack = new char[32];//The character Stack
    int top = -1;//Setting the top value as -1 as there is no element initially
    public void pushOperatorStack(char item){
        //Pushing the Symbol into the operator Stack
        if(top == 31){
            //If the Stack is Full then Stack Overflow and no symbol will be inserted
            System.out.println("Stack Overflow...");
            return;
        }
        operatorStack[++top] = item;//Pushing into the Stack
        return;
    }
    public char popOperatorStack(){
        //Popping elements from the Stack
        if(top == -1){
            //If the Stack is empty then Stack Underflow and no deletions are possible
            System.out.println("Stack Underflow...");
            return '0';
        }
        return operatorStack[top--];//Returning the popped out element and decrementing the top value
    }
}
