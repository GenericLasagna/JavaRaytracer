package JavaRaytracer;

class Tuple {
    float x, y, z, w;

    Tuple(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public static class RVector extends Tuple {
    
        RVector(float x, float y, float z) {
            super(x, y, z, 0.0f);
        }
    
        
    }

    public static class Point extends Tuple {
        Point(float x, float y, float z){
            super(x, y, z, 1.0f);
        }
        
    }

    public static class Color extends Tuple {

        Color(float red, float green, float blue){
            super(red,green,blue,0);
        }
        public float getRed() { return this.x; }
        public float getGreen() { return this.y; }
        public float getBlue() { return this.z; }
    }
}

