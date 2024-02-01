public class Q5_4 {

    //print the next largest and next smallest number with the same number of 1's
    //ex 1011 = 11
    //largest = 1101. Take the rightmost zero and move the 1 on the right into it. so 0100 = 1000
    //smallest = 0111. Take the rightmost 0 and move the 1 on the left into it. so 1000 = 0100

    public static int findHigher(int num){
        String binaryString = Integer.toBinaryString(num);
        int bitsNum = binaryString.length();

        //What if we never found a 0?
        //Then add a 0 to the end
        if(num == (1 << (bitsNum)) - 1){
            return num << 1;
        }

        //walk down the bits right to left
        //find the first 0
        for (int i = 0; i < bitsNum; i++) {
            // Use bitwise AND to check if the bit is 1 or 0
            int bitValue = (num >> i) & 1;
            //System.out.println("Bit at position " + i + ": " + bitValue);

            if(bitValue == 0){//look for a one to the right
                int lastBitValue = (num >> (i-1)) & 1;
                if(i > 0 && (lastBitValue == 1)){ //only works if bit exists and is a 1
                    int finalNum = num & ~(1 << (i-1)); //clear the i-1th bit
                    //System.out.println(Integer.toString((finalNum), 2));
                    finalNum = finalNum | (1 << i) ;//set 1 to the ith bit
                    //System.out.println(Integer.toString((finalNum), 2));
                    return finalNum;

                }
            }
        }
        return 0; //never found a 0
    }

    public static int findLower(int num){
        String binaryString = Integer.toBinaryString(num);
        int bitsNum = binaryString.length();

        //What if we never found a 0?
        //Then it can't be done
        if(num == (1 << (bitsNum)) - 1){
            return 0;
        }

        //walk down the bits right to left
        //find the first 0
        for (int i = 0; i < bitsNum; i++) {
            // Use bitwise AND to check if the bit is 1 or 0
            int bitValue = (num >> i) & 1;
            //System.out.println("Bit at position " + i + ": " + bitValue);
            if(bitValue == 0){//look for a one to the left
                int nextBitValue = (num >> (i+1)) & 1;
                if(i < bitsNum && (nextBitValue == 1)){ //only works if bit exists and is a 1
                    int finalNum = num & ~(1 << (i+1)); //clear the i-1th bit
                    //System.out.println(Integer.toString((finalNum), 2));
                    finalNum = finalNum | (1 << i) ;//set 1 to the ith bit
                    //System.out.println(Integer.toString((finalNum), 2));
                    return finalNum;

                }
            }
        }
        return 0; //never found a 0
    }

    public static void main(String [] args){
        int num = Integer.parseInt("1110100111", 2);
        System.out.println("higher result is " + Integer.toString(findHigher(num), 2));
        System.out.println("lower result is " + Integer.toString(findLower(num), 2));
        //System.out.println("oof " + Integer.toString(num & ~(1 << 3), 2));
    }

}
