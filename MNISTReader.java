import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MNISTReader {
    public static void main(String[] args) throws IOException {
        String filePath = "C:/Users/apoor/Downloads/MNIST/train-images.idx3-ubyte"; // Replace this with your file path

        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            // Read magic number
            int magicNumber = dis.readInt();
            if (magicNumber != 2051) {
                System.err.println("Invalid magic number, not a MNIST image file");
                return;
            }

            // Read number of images
            int numImages = dis.readInt();

            // Read number of rows
            int numRows = dis.readInt();

            // Read number of columns
            int numCols = dis.readInt();

            System.out.printf("Magic number: %d, Number of images: %d, Image dimensions: %d x %d\n", magicNumber, numImages, numRows, numCols);

            // Read image data
            for (int i = 0; i < 5; i++) {
                System.out.println("\nReading image #" + (i + 1));
                for (int row = 0; row < numRows; row++) {
                    for (int col = 0; col < numCols; col++) {
                        int pixelValue = dis.readUnsignedByte();
                        System.out.print(pixelValue + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
