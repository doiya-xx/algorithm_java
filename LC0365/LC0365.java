package LC0365;

class Solution {
    
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        return z % gcd(x, y) == 0;
    }
    
    public int gcd(int x, int y) {
        int remainder = x % y;
        while (remainder != 0) {
            x = y;
            y = remainder;
            remainder = x % y;
        }
        return y;
    }
    
}

class MySolution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity == targetCapacity) {
            return true;
        }
        boolean res = false;
        
        if (jug1Capacity > jug2Capacity) {
            int temp = jug1Capacity;
            jug1Capacity = jug2Capacity;
            jug2Capacity = temp;
        }
        int x = jug2Capacity, y = 0;
        do {
            if (x == targetCapacity || y == targetCapacity || x + y == targetCapacity) {
                res = true;
                break;
            }
            
            if (x == jug2Capacity || y == 0) {
                if (x <= jug1Capacity) {
                    int temp = x;
                    x = y;
                    y = temp;
                } else {
                    x = x + y - jug1Capacity;
                    y = jug1Capacity;
                }
                continue;
            }
            
            if (x == 0 || y == jug1Capacity) {
                if (x == 0) {
                    x = jug2Capacity;
                }
                if (y == jug1Capacity) {
                    y = 0;
                }
            }
        } while (!(x == 0 && y == jug1Capacity));
        return res;
    }
}

public class LC0365 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.canMeasureWater(3, 5, 4);
        System.out.println(res);
    }
}
