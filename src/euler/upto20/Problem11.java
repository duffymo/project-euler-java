package euler.upto20;

import euler.common.ArrayMatrix;
import euler.common.Matrix;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem11
 * <pre>
 * In the 2020 grid below, four numbers along a diagonal line have been marked in red.
 * The product of these numbers is 26  63  78  14 = 1788696.
 * What is the greatest product of four adjacent numbers in any direction (up, down, left, right, or diagonally)
 * in the 2020 grid?
 * </pre>
 * <pre>
 * </pre>
 * User: MOD
 * Date: Oct 15, 2008
 * Time: 10:18:24 PM
 * @link http://projecteuler.net/index.php?section=problems&id=11
 */
public class Problem11 {
    private static final Log LOGGER = LogFactory.getLog((Problem11.class));
    private static final String DEFAULT_PATH = "data/Problem11.in";
    private static final int DEFAULT_GROUP = 4;
    private static final int DEFAULT_SIZE = 20;

    public static void main(String[] args) {
        long begTime = System.currentTimeMillis();
        long endTime;

        try {
            // read in the number from the input file
            Matrix m = read(DEFAULT_PATH);
            double maxProduct;

            maxProduct = Math.max
                    (
                            Math.max(calculateMaxRowProduct(m, DEFAULT_GROUP), calculateMaxColProduct(m, DEFAULT_GROUP)),

                            Math.max(calculateMaxLeftDiagonalProduct(m, DEFAULT_GROUP), calculateMaxRightDiagonalProduct(m, DEFAULT_GROUP))
                    );

            System.out.println("max product: " + (long) maxProduct);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            endTime = System.currentTimeMillis();
            System.out.println("wall time: " + (endTime - begTime) + " msec");
        }
    }

    public static double calculateMaxRowProduct(Matrix m, int groupSize) {
        double maxProduct = Double.MIN_VALUE;

        LOGGER.info(" ");
        LOGGER.info("*** row products ***");
        for (int i = 0; i < m.getNumRows(); ++i) {
            for (int j = 0; j < m.getNumCols() - groupSize; ++j) {
                double product = 1.0;
                for (int k = 0; k < groupSize; ++k) {
                    product *= m.get(i, j + k);
                }

                if (product > maxProduct) {
                    maxProduct = product;
                    LOGGER.info("row: " + i + " col: " + j + " max row prod: " + product);
                }
            }
        }

        return maxProduct;
    }


    public static double calculateMaxColProduct(Matrix m, int groupSize) {
        double maxProduct = Double.MIN_VALUE;

        LOGGER.info(" ");
        LOGGER.info("*** col products ***");
        for (int j = 0; j < m.getNumCols(); ++j) {
            for (int i = 0; i < m.getNumRows() - groupSize; ++i) {
                double product = 1.0;
                for (int k = 0; k < groupSize; ++k) {
                    product *= m.get(i + k, j);
                }

                if (product > maxProduct) {
                    maxProduct = product;
                    LOGGER.info("row: " + i + " col: " + j + " max col prod: " + product);
                }
            }
        }

        return maxProduct;
    }

    public static double calculateMaxLeftDiagonalProduct(Matrix m, int groupSize) {
        double maxProduct = Double.MIN_VALUE;

        LOGGER.info(" ");
        LOGGER.info("*** falling diagonal products ***");
        for (int j = 0; j < m.getNumCols(); ++j) {
            for (int i = 0; i < m.getNumRows() - groupSize; ++i) {
                double product = 1.0;
                for (int k = 0; k < groupSize; ++k) {
                    product *= m.get(i + k, j + k);
                }

                if (product > maxProduct) {
                    maxProduct = product;
                    LOGGER.info("row: " + i + " col: " + j + " max col prod: " + product);
                }
            }
        }

        return maxProduct;
    }


    public static double calculateMaxRightDiagonalProduct(Matrix m, int groupSize) {
        double maxProduct = Double.MIN_VALUE;

        return maxProduct;
    }


    private static Matrix read(String path) throws IOException {
        Matrix m = new ArrayMatrix(DEFAULT_SIZE, DEFAULT_SIZE);

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(path));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\\s+");
                for (int j = 0; j < tokens.length; ++j) {
                    m.set(i, j, Double.valueOf(tokens[j]));
                }

                ++i;
            }
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return m;
    }
}
