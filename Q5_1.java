
public class Q5_1 {
    //Given N and M (32 bit) and bit positions i and j
    //overwrite M into N such that it starts at bit j+1 and ends at bit i+1
    //assume M can always fit within j and i
    //ex: N=1111111111, M=000, i=2, j=4, result = 1111100011

    public static int insert(int N, int M, int i, int j){
        //shift M up by i
        //clear N from i through j
        //  create a mask that is all 1's except 0's i through j and and it to N
        //      take an int of all 1's and left shift it by j to get the necessary 0's
        //      create the 1's we need on the right by creating 1000...x and subbing 1 to get 0111...(x-1)
        //      add the left and right to get the mask
        //add this new M to N and return

        if (!(i < j && i > 0 && j < 32)) {
            throw new RuntimeException("Failed input validation.");
        }

        int M2 = M << i;
        int mask = ~0;
        int Rmask = mask << j;
        int Lmask = (1 << i) - 1;
        mask = Rmask | Lmask;
        int N2 = N & mask;
        return N2 | M2;
    }

    public static void main (String[] args){
        int N = Integer.parseInt("100000000000000000", 2);
        int M = Integer.parseInt("10011", 2);
        int i = 2;
        int j = 6;
        int solution = insert(N, M, i, j);
        System.out.println(Integer.toBinaryString(solution));
    }
}
