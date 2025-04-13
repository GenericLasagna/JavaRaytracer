package JavaRaytracer;

public class matrix {
    float [][] values;

    public static void main(String[] args) {
        matrix m1 = new matrix();

        modifyMatrix(m1, 0, 0 ,1f);
        modifyMatrix(m1, 0, 3 ,4f);
        modifyMatrix(m1, 1, 3 ,5f);
        modifyMatrix(m1, 2, 1 ,7.5f);
        modifyMatrix(m1, 3, 2 ,1f);

        
        showMatrix(m1);

    }

    matrix(){
        values = new float[4][4];
        for (int i = 0; i<4; i++){
            for(int j = 0; j<4;j++){
              values[i][j] = 0f;  
            }
            
        }
    }


    public static void modifyMatrix(matrix m, int x, int y, float val) {
        m.values[x][y] = val;
        
    }

    public static void showMatrix(matrix m) {
        for (int i = 0; i<4; i++){
            System.out.print("\n");
            for(int j = 0; j<4;j++){
              System.out.print(m.values[i][j]+" "); 
            }
            
        }
    }

    
}
