public class compareFloats {
    
    final static float Epsilon = 0.00001f;

    static float[] array1 = {3.6f, -8.5f, 6.2f, 0.0f};

    static float[] array2 = {3.600001f, 5.2f, -3.2f, 1.0f};

    public static void main(String[] args) {
        compare2Floats(array1, array2);
    }

    public static void compare2Floats(float[] floatArrayA, float[] floatArrayB) {

        if (floatArrayA.length == 4 && floatArrayB.length ==  4) {
            
            for (int i = 0; i < 4; i++ ){

                float result = floatArrayA[i] - floatArrayB[i];
                System.out.println("A: "+ floatArrayA[i] + " B: " + floatArrayB[i] + " Result: " + result);


                if (Math.abs(result) < Epsilon) {
                    System.out.println("Result: "+ Math.abs(result) + " Epsilon: " + Epsilon);
                    System.out.println(true);
                }else{
                    System.out.println("Result: "+ Math.abs(result) + " Epsilon: " + Epsilon);
                    System.out.println(false);
                }
                System.out.println("\n");
            }

        }else{
            System.err.println("You done fucked, 1 or 2 arrays doesnt have 4 elements");
            for (int i = 0; i < 4; i++ ){
                System.out.println("Array A number ["+i+"]: " + floatArrayA[i]);
                System.out.println("Array A number ["+i+"]: " + floatArrayB[i]);
            }
        }
    }
}
