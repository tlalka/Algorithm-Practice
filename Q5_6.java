public class Q5_6 {

    //how many bits would you need to flip to covert number A to B?
    //brute force: walk down the A and B counting how many to flip O(n)
    //start at the smallest bit so we can handle trailing 0's

    public static int flipper(int a, int b){

        int start = a;
        int end = b;
        int num = 0;

        while(start > 0 || end > 0){
            if(!((start & 1) == (end & 1))){
                num++;
            }
            start = start >> 1;
            end = end >> 1;
        }

        return num;
    }

    public static void main(String [] args){
        int a = Integer.parseInt("0000", 2);
        int b = Integer.parseInt("11001", 2);
        System.out.println("result is " + Integer.toString(flipper(a, b)));
    }
    
}
