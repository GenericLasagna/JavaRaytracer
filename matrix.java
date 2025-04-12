package JavaRaytracer;

public class matrix {
    float [][] values;

    public static void main(String[] args) {
        matrix m1 = new matrix();

        modifyMatrix(m1, 0, 0 ,1f);

    }

    matrix(){
        values = new float[4][4];
        for (int i = 0; i<4; i++){
            for(int j = 0; j<4;i++){
              values[i][j] = 0f;  
            }
            
        }
    }


    public static void modifyMatrix(matrix m, int x, int y, float val) {
        m.values[x][y] = val;
        
    }

    
}
