package JavaRaytracer;

public class matrix {
    float [][] values;

    public static void main(String[] args) {
        matrix m1 = new matrix(4,4);
        matrix m2 = new matrix(4,4);
        
        float[] c1 = {1f,2f,3f,4f,5f,6f,7f,8f,9f,8f,7f,6f,5f,4f,3f,2f};
        float[] c2 = {-2f,1f,2f,3f,3f,2f,1f,-1f,4f,3f,6f,5f,1f,2f,7f,8f};

        setMatrix(m1,c1);
        setMatrix(m2, c2);

        showMatrix(m1);

        System.out.println("\n");
        showMatrix(m2);

        System.out.println("\n");

        showMatrix(multiplyMatrixes(m1, m2));


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

    
}
