public class Tuple {

    static float[] a = {4.3f, -4.2f, 3.1f, 0.0f};

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        
        float x = a[0];
        float y = a[1];
        float z = a[2];
        float w = a[3];

        if (w == 1.0f) {
            System.out.println("The tuple is Point");
            
        }else if (w == 0.0f) {
            System.out.println("The tuple is a vector");
        }
        
    }
}