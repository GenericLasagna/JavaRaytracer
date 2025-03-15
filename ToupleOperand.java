public class ToupleOperand {
    
    static float[] array1 = {3f, -2f, 5f, 1f};

    static float[] array2 = {-2f, 3f, 1f, 0f};



    @SuppressWarnings("unused")
    public static void main(String[] args) {

        float[] testPoint1 = Point.createPoint( new float[] {3f,2f,1f});
        float[] testPoint2 = Point.createPoint( new float[] {5f,6f,7f});
        float[] testVector1 = Vector.createVector(new float[] {5f,6f,7f});
        float[] testVector2 = Vector.createVector(new float[] {3f,2f,1f});
        
        /*float[] resultingTuple = magnitudeTuple(new float[] {1f,2f,3f});

        for (int i = 0 ; i < resultingTuple.length ; i++){  
            
            System.out.println(resultingTuple[i]);
        }
        */

        float[] result = crossProductVector( Vector.createVector(new float[] {2f,3f,4f}),Vector.createVector(new float[] {1f,2f,3f}));

        for (int i = 0 ; i < result.length ; i++){  
            
            System.out.println(result[i]);
        }

    }

    public static void addTuples(float[] tupleA, float[] tupleB){

        if (tupleA.length == 4 && tupleB.length ==  4) {

            float[] resultTuple = new float[4];
            
            for (int i = 0; i < 4; i++ ){

                float result = tupleA[i] + tupleB[i];

                System.out.println("A: "+ tupleA[i] + " B: " + tupleB[i] + " Result: " + result);

                resultTuple[i] = result;
            }

        }else{
            System.err.println("You done fucked, 1 or 2 arrays doesnt have 4 elements");
            for (int i = 0; i < 4; i++ ){
                System.out.println("Array A number ["+i+"]: " + tupleA[i]);
                System.out.println("Array A number ["+i+"]: " + tupleB[i]);
            }
        }
    }

    public static void subtractingTuples(float[] tupleA, float[] tupleB) {
        if (tupleA.length == 4 && tupleB.length ==  4) {

            float[] resultTuple = new float[4];
            
            for (int i = 0; i < 4; i++ ){

                float result = tupleA[i] - tupleB[i];

                System.out.println("A: "+ tupleA[i] + " B: " + tupleB[i] + " Result: " + result);

                resultTuple[i] = result;
            }

        }else{
            System.err.println("You done fucked, 1 or 2 arrays doesnt have 4 elements");
            for (int i = 0; i < 4; i++ ){
                System.out.println("Array A number ["+i+"]: " + tupleA[i]);
                System.out.println("Array A number ["+i+"]: " + tupleB[i]);
            }
        }
    }

    //allows to see the opposite direction of a vector
    public static void negateTuples(float[] tupleA) {
        
        //final float[] zero = {0f,0f,0f,0f};

        float[] testVector = Vector.createVector(new float[] {1f,-2f,3f});

        float[] resultingVector = new float[4];

        //subtractingTuples(zero, testVector);


        for (int i = 0; i < 3; i++ ){

            float result = -tupleA[i];

            resultingVector[i] = result;
            System.out.println(resultingVector[i]);
        }

        resultingVector[3] = 0;
        System.out.println(resultingVector[3]);
    }

    public static void multiplyTuple(float[] tupleA, float multiplier) {

        float[] resultingVector = new float[4];

        for (int i = 0; i < 4; i++ ){

            float result = tupleA[i] * multiplier;

            resultingVector[i] = result;
            System.out.println(resultingVector[i]);
        }
        
    }

    public static void divideTuple(float[] tupleA, float divider) {

        float[] resultingVector = new float[4];

        for (int i = 0; i < 4; i++ ){

            float result = tupleA[i] / divider;

            resultingVector[i] = result;
            System.out.println(resultingVector[i]);
        }
        
    }

    public static float[] magnitudeTuple(float[] tupleA) { 

        float[] results = new float[4];

        for (int i = 0 ; i < tupleA.length ; i++){
            
            results[i] = (float) Math.pow(tupleA[i], 2);
            System.out.println(results[i]);
        }
        float magnitud = 0;
        
        for (int i = 0 ; i< results.length ; i++){
            magnitud = magnitud + results[i];     
        }

        magnitud = (float) Math.sqrt(magnitud);
        
        //checks if the tuple is normalized, if its not, normalzie it
        if (magnitud != 1.0f) {

            float[] normalizedTuple = new float[tupleA.length];

            System.out.println("Magnitud isnt 1, must normalize: " + magnitud);
            for (int i = 0 ; i < tupleA.length ; i++){
                
                normalizedTuple[i] = tupleA[i] / magnitud;
            }

            return normalizedTuple;

        }else{
            System.out.println("Magnitud is 1, it is already normalized");
            return tupleA;
        }
        
        
    }

    public static float dotProductVector(float[] tupleA, float[] tupleB) {
        if (tupleA.length == tupleB.length) {
            float[] results = new float[4];
            for (int i = 0 ; i < tupleA.length ; i++){
            
                results[i] = tupleA[i] * tupleB[i];
                System.out.println(results[i]);
            }
            float dotProduct = 0;

            for (int i = 0 ; i< results.length ; i++){
                dotProduct = dotProduct + results[i];     
            }

            return dotProduct;
        }else{
            System.err.println("You done fucked, the 2 arrays dont have the same amount of digits");
            for (int i = 0; i < 4; i++ ){
                System.out.println("Array A number ["+i+"]: " + tupleA[i]);
                System.out.println("Array A number ["+i+"]: " + tupleB[i]);
            }

            return 0f;
        }
    }

    public static float[] crossProductVector(float[] tupleA, float[] tupleB) {
        if (tupleA.length == tupleB.length) {
            float[] results = new float[3];
           
            results[0]= (tupleA[1] * tupleB[2]) - (tupleA[2] * tupleB[1]);
            results[1]= (tupleA[2] * tupleB[0]) - (tupleA[0] * tupleB[2]);
            results[2]= (tupleA[0] * tupleB[1]) - (tupleA[1] * tupleB[0]);
            return results;
        }else{
            System.err.println("You done fucked, the 2 arrays dont have the same amount of digits");
            for (int i = 0; i < 4; i++ ){
                System.out.println("Array A number ["+i+"]: " + tupleA[i]);
                System.out.println("Array A number ["+i+"]: " + tupleB[i]);
            }

            return tupleB ;
        }
    }
}
