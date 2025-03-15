public class Vector {

    static float[] TupleVector = {4.0f  , -4.2f, 3.1f};
    
    public static void main(String[] args){
        createVector(TupleVector);
    }

    public static float[] createVector(float[] tupleToVector) {

        //creates a new float array with 4 elements
        float[] newPoint = new float[4];

        //for that transfers all the elements of the tuple to a new array of 4 elements
        for (int i = 0 ; i < tupleToVector.length; i++){
            
            if (i <= 2) {
                newPoint[i] = tupleToVector[i];
            }
            
        }
        
        // Sets the 4th element, the W, as a 0.0, setting it as a vector
        newPoint[3] = 0.0f;
        
        return newPoint;
    }
}
