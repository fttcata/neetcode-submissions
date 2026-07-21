class Solution {
    public int evalRPN(String[] tokens) {
     // Stack to store numbers
     Stack<Integer> s = new Stack<>();

     //Traverse the Array
     for (int i = 0 ; i < tokens.length; i++)
     {
        // If numbers, push to stack
        if (!tokens[i].equals("+") &&
        !tokens[i].equals("-") &&
        !tokens[i].equals("*") &&
        !tokens[i].equals("/"))
        s.push(Integer.parseInt(tokens[i]));
        // If not, do operation between two last seen numbers
        else
        {
            int op1 = s.pop();
            if (tokens[i].equals("+"))
            op1 += s.pop();
            else if (tokens[i].equals("-"))
            op1  = s.pop() - op1;
            else if (tokens[i].equals("*"))
            op1 *= s.pop();
            else
            op1 = s.pop() / op1;
            // Push the result back into stack
            s.push(op1);
        }
     }
     return s.pop();   
    }
}
