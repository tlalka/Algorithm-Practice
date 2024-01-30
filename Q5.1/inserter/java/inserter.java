
public class inserter {
    //Given N and M (32 bit) and bit potsitions i and j
    //overwrite M into N such that it starts at bit j+1 and ends at bit i+1
    //assume M can always fit within j and i
    //ex: N=1111111111, M=000, i=2, j=4, result = 1111100011

    public static void insert(int N, int M, int i, int j){
        //shift M up by i
        //clear N from i through j
        //  create N2 such that it is 0 from i to j and AND it to N
        //      to create N2, right shift N by i, then left shift by i, thus clearing the left. Re-add from j to the end.
        //add this new M to N and return

        if (!(i > j && i > 0 && j < 32)) {
            throw new RuntimeException("Failed input validation.");
        }

        System.out.println(Integer.toBinaryString(N));
        

    }

    public static void main (String[] args){
        int N = Integer.parseInt("11111", 2);
        int M = Integer.parseInt("00000", 2);
        int i = 2;
        int j = 1;
        insert(N, M, i, j);
    }
}
