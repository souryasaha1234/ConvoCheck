class Stack{
    int[] array = new int[32];
    int top = -1;
    public int isEmpty(){
        if(this.top == -1){
            return 1;
        }
        return 0;
    }
    public int isFull(){
        if(this.top == 31){
            return 1;
        }
        return 0;
    }
    public int push(int item){
        if(this.isFull() == 1){
            System.out.println("Insertion not possible...");
            return 0;
        }
        this.array[++this.top] = item;
        return 1;
    }
    public int pop(){
        /*if(this.isEmpty() == 1){
            System.out.println("Deletion not possible...");
            return 0;
        }*/
        int popItem = this.array[this.top];
        this.top--;
        //System.out.println("The poped item from the stack is : "+popItem);
        return popItem;
    }
    public void display(){
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
    char[] operatorStack = new char[32];
    int top = -1;
    public void pushOperatorStack(char item){
        if(top == 31){
            System.out.println("Stack Overflow...");
            return;
        }
        operatorStack[++top] = item;
        return;
    }
    public char popOperatorStack(){
        if(top == -1){
            System.out.println("Stack Underflow...");
            return '0';
        }
        return operatorStack[top--];
    }
}
