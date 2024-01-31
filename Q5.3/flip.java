public class flip {
    //find the longest sequence of 1's that is seperated by one 0
    //in N time, we can walk down the number while keeping track of the longest sequence
    //When we hit our first 0, seq1 will continue counting while seq2 will start. 
    //When we hit our next 0, seq1 will restart, while seq2 will continue.

    public static int fliper(int num){
        //if division is odd, i was 1, if even, it was 0
        //first value is a special case. It will always be the opposite 
        //ex 1000 / 10 = 4
        //ex 1010 / 10 = 5 

        int max = 0;
        int seq1 = 0;
        boolean zero1 = false;
        int seq2 = 0;
        boolean zero2 = true; //we want these to be offset, so start seq2 on true
        int i = 1;

        System.out.println("i = " + Integer.toString(i, 2));

        //handle first case
        if((((num / i) % 2) == 0)){ //is odd, so bit was 0
            if(!zero1){//continue seq1
                zero1 = true;
            } else{//seq1 already saw a 0, so it must restart
                seq1 = 0;
                zero1 = false;
            }

            if(!zero2){//continue seq2
                zero2 = true;
            } else{//seq2 already saw a 0, so it must restart
                seq2 = 0;
                zero2 = false;
            }

        } else{ //is even
            num -= i;
            seq1++;
            seq2++;
        }

        i *= 2;
        if(seq1 > max){
            max = seq1;
        }
        if(seq2 > max){
            max = seq2;
        }

        //go from the bottom up
        while(num > 0){

            System.out.println("i = " + Integer.toString(i, 2));
            System.out.println("seq1 = " + seq1);
            System.out.println("seq2 = " + seq2);
            if((((num / i) % 2) == 0)){ //is even, so bit was 0
                if(!zero1){//continue seq1
                    zero1 = true;
                } else{//seq1 already saw a 0, so it must restart
                    seq1 = 0;
                    zero1 = false;
                }

                if(!zero2){//continue seq2
                    zero2 = true;
                } else{//seq2 already saw a 0, so it must restart
                    seq2 = 0;
                    zero2 = false;
                }

            } else{ //is odd
                seq1++;
                seq2++;
                num -= i;
            }

            i *= 2;
            if(seq1 > max){
                max = seq1;
            }
            if(seq2 > max){
                max = seq2;
            }
            System.out.println("num = " + Integer.toString(num, 2));
        }

        return max;

    }

    public static void main(String [] args){
        int num = Integer.parseInt("1101111100011011101110", 2);
        System.out.println("result is " + Integer.toString(fliper(num)));
    }
    
}
