import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static algorithms.math.Matrix.*;

public class MatrixTest {

    @Test
    public void testMatrixF() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Rotate the matrix
        rotateMatrixClockwise1(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }
}
