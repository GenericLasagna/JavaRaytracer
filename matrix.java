package JavaRaytracer;

public class matrix {
    float [][] values;

    public static void main(String[] args) {
        matrix m1 = new matrix(3,3);
        //matrix m2 = new matrix(4,4);


        //Tuple t1 = new Tuple(1f, 2f, 3f, 1f);

        //float[] c1 = {1f,2f,3f,4f,5f,6f,7f,8f,9f,8f,7f,6f,5f,4f,3f,2f};
        //float[] c2 = {-2f,1f,2f,3f,3f,2f,1f,-1f,4f,3f,6f,5f,1f,2f,7f,8f};
        float[] c3 = {3f,5f,0f,2f,-1f,-7f,6f,-1f,5f};
        //float[] c4 = {1f,5f,-3f,2f};

        setMatrix(m1,c3);
        //setMatrix(m2, c2);

        showMatrix(m1);

        System.out.println("\n");

        System.out.println((minor(m1, 1, 0)));

       
    }

    //creates a matrix object
    matrix(int x, int y){
        values = new float[x][y];
        for (int i = 0; i<x; i++){
            for(int j = 0; j<y;j++){
              values[i][j] = 0f;  
            }
            
        }
    }

    //modifues and individual element of the matrix
    public static void modifyMatrix(matrix m, int x, int y, float val) {
        m.values[x][y] = val;
        
    }

    //prints matrix in the console
    public static void showMatrix(matrix m) {
        //System.out.println("\n");
        for (int i = 0; i<m.values.length; i++){
            System.out.print("\n");
            for(int j = 0; j<m.values[0].length;j++){
              System.out.print(m.values[i][j]+"|"); 
            }
            
        }
    }


    //compares 2 matrixes together
    public static boolean compareMatrix(matrix mA, matrix mB) {
        if (mA.values.length == mB.values.length && mA.values[0].length == mB.values[0].length) {
            
            int correctAmount = 0;
            int expectedAmount = (mA.values.length * mA.values[0].length);

            //checks both matrixes contents to check if each element is  the same
            for (int i = 0; i<mA.values.length; i++){
                for(int j = 0; j<mB.values[0].length;j++){
                  if (mA.values[i][j] != mB.values[i][j]) {
                    return false;
                  }else{
                    correctAmount += 1;
                  }
                }
            }

            //checks if all the numbers are correct
            if (correctAmount == expectedAmount) {
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public static void setMatrix(matrix m,float[] contents) 
    {
        //gets how many numbers can the matrix hold
        int expectedAmount = (m.values.length * m.values[0].length);

        //checks if the expected amount of numbers is the same as the numbers recieved
        if (expectedAmount == contents.length) {

            int numberTurn = 0;

            for (int i = 0; i<m.values.length; i++){
                for(int j = 0; j<m.values[0].length;j++){
                    m.values[i][j] = contents[numberTurn]; 
                    numberTurn += 1;

                }
            }
            
        }else{
            System.out.println("matrix size and content size does not match");
        }
    }

    public static matrix multiplyMatrixes(matrix mA, matrix mB) {
        
        matrix resultingMatrix = new matrix(mA.values.length, mB.values.length);
        for (int i = 0; i<mA.values.length; i++){

            for(int j = 0; j<mB.values[0].length;j++){
              
                float res = (mA.values[i][0] * mB.values[0][j]) +
                (mA.values[i][1] * mB.values[1][j]) + 
                (mA.values[i][2] * mB.values[2][j]) +
                (mA.values[i][3] * mB.values[3][j]);

                resultingMatrix.values[i][j] = res;
              
            }
        }

        return resultingMatrix;
    }

    //multiplies a matrix with a tuple
    public static Tuple multiplyMatrixTuple(matrix m, Tuple t) {
        
        //starts the intermediate storage of the data for the tuple
        float[] floatArray = new float[4];
        
        for (int i = 0; i<m.values.length; i++){
            //gets the cross product ofeach element
            float res = (m.values[i][0] * t.x) +
            (m.values[i][1] * t.y) + 
            (m.values[i][2] * t.z) +
            (m.values[i][3] * t.w); 

            //stores the results in an array
            floatArray[i] = res;
        }

        //Starts a basic Tuple
        Tuple newTuple = new Tuple(floatArray[0], floatArray[1], floatArray[2], floatArray[3]);

        return newTuple;
        
    }
    
    //multiplies a maatrix with a matrix
    public static matrix identityMatrix(matrix m) {
        matrix identityM = new matrix(4, 4);
        
        float[] identityContents = new float[]{1f,0f,0f,0f,0f,1f,0f,0f,0f,0f,1f,0f,0f,0f,0f,1f};
        setMatrix(identityM, identityContents);
        return multiplyMatrixes(m, identityM);
    }
    
    //method for converting rows into columns and columns into rows
    public static matrix transposeMatrix(matrix m) {
        
        //new matrix that will hold the new transposed matrix
        matrix transposedMatrix = new matrix(4, 4);

        for (int i = 0; i<m.values.length; i++){
            for(int j = 0; j<m.values[0].length;j++){
                transposedMatrix.values[j][i] = m.values[i][j] ; 
                

            }
        }
        return transposedMatrix;
    }

    public static float determinant2by2Matrix(matrix m) {
        float res = (m.values[0][0] * m.values[1][1]) - (m.values[1][0] * m.values[0][1]);
        return res;
    }

    public static matrix Submatrix(matrix m, int rowToDelete, int columnToDelete) {
        matrix submat = new matrix(m.values.length-1, m.values[0].length-1);

        int subI =  0;
        int subJ = 0;

        for (int i = 0; i < m.values.length ; i++){
            for(int j = 0; j < m.values[0].length;j++){

                //checks if we are in the row and column to delete
                if (i != rowToDelete && j != columnToDelete){

                    submat.values[subI][subJ] = m.values[i][j]; 
                    subJ++;

                    //checks if the SubJ is equal to the length of the matrix colum -
                    if (subJ == m.values[0].length-1) {

                        //resets the subj to prevent index overflows
                        subJ = 0;

                        //moves to the next subI number
                        subI++;
                    }
                }
            }
        }
        
        return submat;
    }


    public static float minor(matrix m, int row, int colum) {
        return determinant2by2Matrix(Submatrix(m, row, colum));
    }

    public static void cofactor(matrix m,int row, int colum) {
        minor(m, row, colum);
    }
}
