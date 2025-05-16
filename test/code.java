import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class code {
    
    // 编码器：将文件转换为图片
    public static void encodeFileToImage(String filePath, String imagePath) throws IOException {
        // 读取文件内容
        Path path = Paths.get(filePath);
        byte[] data = Files.readAllBytes(path);
        System.out.println("data = " + Arrays.toString(data));
        
        // 使用Base64编码
        String encodedString = Base64.getEncoder().encodeToString(data);
        System.out.println("encodedString = " + encodedString);
        
        // 转为byte流
        byte[] bytes = encodedString.getBytes();
        
        // 计算图像的长和宽，使其与字符串长度相关
        int length = bytes.length;
        int width = (int) Math.sqrt(length);
        int height = (int) Math.ceil((double)length / width);
        
        // 创建一个 BufferedImage 对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        
        // 获取图像的 Graphics2D 对象
        int idx = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (idx < length) {
                    image.setRGB(x, y, bytes[idx]);
                    idx += 3;
                } else {
                    // 如果字符串长度小于图像的像素数，则用黑色填充剩余的像素
                    // image.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
        }
        
        // 将图像写入文件
        File outputImage = new File(imagePath);
        try {
            ImageIO.write(image, "png", outputImage);
            System.out.println("图像已成功写入文件: " + outputImage.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    // 解码器：将图片还原为文件
    public static void decodeImageToFile(String imagePath, String targetFilePath) throws IOException {
        // 读取图片
        BufferedImage image = ImageIO.read(new File(imagePath));
        
        // 将图片转换为Base64编码的字符串
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        
        String encodedString = new String(imageInByte);
        
        // 解码Base64字符串
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        
        // 写入目标文件
        FileOutputStream fos = new FileOutputStream(targetFilePath);
        fos.write(decodedBytes);
        fos.close();
    }
    
    public static void main(String[] args) throws Exception {
        File from = new File("test", "code.java");// 设定为当前文件夹
        File to = new File("test", "encoded_image.png");// 设定为当前文件夹
        System.out.println(from.getAbsolutePath());// 获取绝对路径
        System.out.println(to.getAbsolutePath());// 获取绝对路径
        
        // 编码器示例
        encodeFileToImage(from.getCanonicalPath(), to.getAbsolutePath());
        
        // 解码器示例
        // decodeImageToFile("encoded_image.png", "output.txt");
    }
}
