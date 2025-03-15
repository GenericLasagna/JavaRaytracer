public class Point {
    
    static float[] TupleVector = {4.0f  , -4.2f, 3.1f};
    
    public static void main(String[] args){
        createPoint(TupleVector);
    }

    public static float[] createPoint(float[] tupleToPoint) {

        //creates a new float array with 4 elements
        float[] newPoint = new float[4];

        //for that transfers all the elements of the tuple to a new array of 4 elements
        for (int i = 0 ; i < tupleToPoint.length; i++){
            if (i <= 2) {
                newPoint[i] = tupleToPoint[i];
            }
        }
        
        // Sets the 4th element, the W, as a 1.0, setting it as a point
        newPoint[3] = 1.0f;

        return newPoint;
    }
}
