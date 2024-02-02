public class Q5_7b {
    //flip odd and even bits in as few steps as possible
    //ex  abcd = badc
    //0110 = 1001
    //brute force: walk up the int, switching each bit
    //start at the smallest, remember it, go to the next and place it down, then place the remembered bit


    public static int fliparoo(int num){

        int solution = 0;
        int bit = 0;
        boolean even = true; //when true, we must remember the bit, and not place a new one down
        int i = 0; //needed for correct incrementing of new
        while(num > 0){
            if(even){
                bit = num & 1;
                even = false;
            }
            else{
                solution += (num & 1) << i-1;
                solution += bit << i;
                even = true;
            }

            num = num >> 1;
            i++;
        }
        //check if final item to add
        if(!even){
            solution += (num & 1) << i-1;
            solution += bit << i;
        }

        return solution;
    }
    public static void main(String[] args){
        int b = Integer.parseInt("11001100", 2);
        System.out.println("result is " + Integer.toString(fliparoo(b), 2));
    }

}
