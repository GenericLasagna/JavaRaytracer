package JavaRaytracer;

public class matrix {
    float [][] values;

    public static void main(String[] args) {
        matrix m1 = new matrix(3,3);
        matrix m2 = new matrix(3,3);

        modifyMatrix(m1, 0, 0 ,1f);
        
        showMatrix(m1);
        showMatrix(m2);

        System.out.println("\n"+compareMatrix(m1, m2));


    }

    matrix(int x, int y){
        values = new float[x][y];
        for (int i = 0; i<x; i++){
            for(int j = 0; j<y;j++){
              values[i][j] = 0f;  
            }
            
        }
    }


    public static void modifyMatrix(matrix m, int x, int y, float val) {
        m.values[x][y] = val;
        
    }

    public static void showMatrix(matrix m) {
        for (int i = 0; i<m.values.length; i++){
            System.out.print("\n");
            for(int j = 0; j<m.values[0].length;j++){
              System.out.print(m.values[i][j]+"|"); 
            }
            
        }
    }

    public static boolean compareMatrix(matrix mA, matrix mB) {
        if (mA.values.length == mB.values.length && mA.values[0].length == mB.values[0].length) {
            
            int correctAmount = 0;
            int expectedAmount = (mA.values.length * mA.values[0].length);
            for (int i = 0; i<mA.values.length; i++){
                for(int j = 0; j<mB.values[0].length;j++){
                  if (mA.values[i][j] != mB.values[i][j]) {
                    return false;
                  }else{
                    correctAmount += 1;
                  }
                }
            }
            if (correctAmount == expectedAmount) {
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    
}
