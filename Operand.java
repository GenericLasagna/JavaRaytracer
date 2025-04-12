package JavaRaytracer;

import JavaRaytracer.Tuple.*;



public class Operand {

    public static void main(String[] args) {
        RVector vector1 = new RVector(1f,2f,3f);
        RVector vector2 = new RVector(2f,3f,4f);

        Point point1 = new Point(3f,-2f,1f);
        Point point2 = new Point(5f,6f,7f);

        Tuple result = crossProductVector(vector2, vector1);

        System.out.println(result.x + " " +result.y + " " + result.z + " " + result.w);

    }

   
    public static Tuple addition(Tuple tupleA, Tuple tupleB){

        float x = tupleA.x + tupleB.x;
        float y = tupleA.y + tupleB.y;
        float z = tupleA.z + tupleB.z;    
        float w = tupleA.w + tupleB.w;



        if (tupleA instanceof Color){
            return new Color(x,y,z);
        }else if (w == 1f) {
            return new Point(x, y, z);
        }else if (w == 0f){
            return new RVector(x,y,z);
        }else{
            return null;
        }
        

    }

    public static Tuple subtraction(Tuple tupleA, Tuple tupleB) {

        float x = tupleA.x - tupleB.x;
        float y = tupleA.y - tupleB.y;
        float z = tupleA.z - tupleB.z;    
        float w = tupleA.w - tupleB.w;

        if (tupleA instanceof Color){
            return new Color(x,y,z);
        }else if (w == 0f){
            return new RVector(x,y,z);
        }else if (w == 1f) {
            return new Point(x, y, z);
        }else{
            return null;
        }

    }

    //allows to see the opposite direction of a vector
    public static Tuple negateTuples(Tuple tupleA) {
        float x = -tupleA.x;
        float y = -tupleA.y;
        float z = -tupleA.z;    
        float w = tupleA.w;

        if (w == 0f){
            return new RVector(x,y,z);
        }else if (w == 1f) {
            return new Point(x, y, z);
        }else{
            return null;
        }
    }

    public static Tuple multiplyTuple(Tuple tupleA, float multiplier) {
        float x = tupleA.x * multiplier;
        float y = tupleA.y * multiplier;
        float z = tupleA.z * multiplier;    
        float w = tupleA.w * multiplier;

        if (w == 0f){
            return new RVector(x,y,z);
        }else if (w == 1f) {
            return new Point(x, y, z);
        }else{
            return null;
        }
    
        
    }

    public static Tuple divideTuple(Tuple tupleA, float divider) {

        float x = tupleA.x / divider;
        float y = tupleA.y / divider;
        float z = tupleA.z / divider;    
        float w = tupleA.w / divider;

        if (w == 0f){
            return new RVector(x,y,z);
        }else if (w == 1f) {
            return new Point(x, y, z);
        }else{
            return null;
        }
        
    }

    public static Tuple normalizeTuple(Tuple tupleA) { 

        float x =   (float) Math.pow(tupleA.x, 2);
        float y =   (float) Math.pow(tupleA.y, 2) ;
        float z =   (float) Math.pow(tupleA.z, 2) ;    
        float w =   (float) Math.pow(tupleA.w, 2) ;

        
        float magnitud = 0;
        
        magnitud = x + y + z + w;     
    

        magnitud = (float) Math.sqrt(magnitud);
        
        //checks if the tuple is normalized, if its not, normalzie it
        if (magnitud != 1.0f) {

            
            float normalizedX = tupleA.x / magnitud;
            float normalizedY = tupleA.y / magnitud;
            float normalizedZ = tupleA.z / magnitud;
            float normalizedW = tupleA.w / magnitud;

            if (normalizedW == 0f){
                return new RVector(normalizedX,normalizedY,normalizedZ);
            }else if (normalizedW == 1f) {
                return new Point(x, y, z);
            }else{
                return null;
            }

        }else{
            System.out.println("Magnitud is 1, it is already normalized");
            return tupleA;
        }
        
        
    }

    public static float dotProductVector(Tuple tupleA, Tuple tupleB) {
        float x = tupleA.x * tupleB.x;
        float y = tupleA.y * tupleB.y;
        float z = tupleA.z * tupleB.z;    
        float w = tupleA.w * tupleB.w;

        float dotProduct = x + y + z + w;      
            
        return dotProduct;

    }

    public static RVector crossProductVector(Tuple tupleA, Tuple tupleB) {
        float x = tupleA.y * tupleB.z - tupleA.z * tupleB.y;
        float y = tupleA.z * tupleB.x - tupleA.x * tupleB.z;
        float z = tupleA.x * tupleB.y - tupleA.y * tupleB.x;
        return new RVector(x,y,z);
    }

    public static Color multiplyColor(Color tupleA, Color tupleB) {
        float r = tupleA.getRed() * tupleB.getRed();
        float g = tupleA.getGreen() * tupleB.getGreen();
        float b = tupleA.getBlue() * tupleB.getBlue();    

        return new Color(r,g,b);
    }
}
