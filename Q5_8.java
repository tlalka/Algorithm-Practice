public class Q5_8 {

    //array, each byte stores 8 bits of monitor color. 
    //the width of the screen is divisible by 8 so that no byte is split by row
    //h = bits / (W * 8)
    //draw a horizontal line from (x1, y) to (x2, y)

    public static void drawLine(byte[] screen, int width, int x1, int x2, int y){
        //we need to convert the information to the i-j of the array
        //ex. y = 1, x1 = 12, x2 = 24 (forgeting the byte-to-bit part for now)
        //00000000-00000000-00000000-00000000
        //00000000-00001111-11110000-00000000
        //00000000-00000000-00000000-00000000
        //00000000-00000000-00000000-00000000
        //step 1: account for y, so add y * width
        //now we are on the correct row, but we need to start on the correct x1
        //for this, we can add floor(x1 / 8) to start
        //we also want to end at x2, floor(x2 / 8) - 1
        //Now we need to handle when the start and end bits are uneven
        //for x1, get the remainder of x1 % 8. we'll have to add those bits to the first byte on the left
        //for x2, it's the same but for the last bit on the right
        //how to convert that to the binary we need?

        //otherwise
        int firstbits = (1 << (8 - (x1 % 8))) - 1;
        int lastbits = ((1 << (x2 % 8)) - 1) << (8 - (x2 % 8));
        //System.out.println(Integer.toString(firstbits, 2));
        //System.out.println(Integer.toString(lastbits, 2));

        int start = y * width + (int) Math.floor(x1 / 8) * 8;
        int end = (int) Math.ceil((x2 - x1) / 8) + 1;

        System.out.println(start / width);
        System.out.println(end + 1);

        //special case if x1 and x2 are in the same byte
        //00111110-00000000-00000000-00000000
        // then we can just iterate over that one byte
        if((start / width) == (end + 1)){
            int oneByte = 0;
            for (int j = 0; j < (x2 - x1); j++){
                oneByte += 1 << (8 % (x2 + 1)) + j;
            }
            System.out.println("hohooh " + Integer.toString(oneByte, 2));
            screen[start/8] = (byte) oneByte;
            return;
        }

        int i = 0;
        for(i = 0; i < end; i++){
            if(firstbits > 0){
                screen[i + (start / 8)] = (byte) firstbits;
                firstbits = 0;
            }
            else{
                screen[i + (start / 8)] = (byte) 0xFF;
            }
            //System.out.println(screen[i]);
        }
        if(lastbits > 0){
            screen[(i - 1) + (start / 8)] = (byte) lastbits; //add
        }
    }

        // Convert byte array to string of bits with newlines
        private static String byteArrayToBitsStringWithNewline(byte[] byteArray, int w) {
            StringBuilder bitsString = new StringBuilder();
    
            for (int i = 0; i < byteArray.length; i++) {
                for (int j = 7; j >= 0; j--) {
                    int bit = (byteArray[i] >> j) & 1;
                    bitsString.append(bit);
    
                    // Insert a newline character after the specified width
                    if ((i * 8 + (7 - j)) % w == w - 1) {
                        bitsString.append("\n");
                    }
                }
            }
    
            return bitsString.toString();
        }

    public static void main(String args []){
        byte[] test = new byte[16];
        int w = 32;
        drawLine(test, w, 10, 30, 2);
        System.out.println("Byte Array as String of Bits:");
        System.out.println(byteArrayToBitsStringWithNewline(test, w));

    }

}
