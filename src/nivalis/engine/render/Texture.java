package nivalis.engine.render;

import org.lwjgl.BufferUtils;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.stb.STBImage.stbi_image_free;
import static org.lwjgl.stb.STBImage.stbi_load;

/**
 * @author Esilff
 */

public class Texture {
    private String filepath;

    private int id;
    private int width;
    private int height;

    /**
     * Get the pixels of an image and put it in a texture2D. It is used to load and bind an image to the model.
     * @param filename The path of the file.
     */

    public Texture(String filename) {
        filepath = filename;
        id = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, id);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

        IntBuffer width = BufferUtils.createIntBuffer(1);
        IntBuffer height = BufferUtils.createIntBuffer(1);
        IntBuffer channels = BufferUtils.createIntBuffer(1);
        ByteBuffer image = stbi_load(filepath, width, height, channels, 0);
        if (image != null) {
            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width.get(0), height.get(0), 0, GL_RGBA, GL_UNSIGNED_BYTE, image);
        }
        else {
            assert false : "Error : could not load image " + filepath + ".";
        }

        stbi_image_free(image);
        /*BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new File(filename));
            width = bufferedImage.getWidth();
            height = bufferedImage.getHeight();
            int[] pixels_raw;
            pixels_raw = bufferedImage.getRGB(0,0,width, height, null, 0, width);
            ByteBuffer pixels = BufferUtils.createByteBuffer(width * height * 4);
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    int pixel = pixels_raw[i * width + j];
                    pixels.put((byte) ((pixel >> 16) & 0xFF));
                    pixels.put((byte) ((pixel >> 8) & 0xFF));
                    pixels.put((byte)(pixel & 0xFF));
                    pixels.put((byte) ((pixel >> 24) & 0xFF));
                }
            }
            pixels.flip();
            id = glGenTextures();
            glBindTexture(GL_TEXTURE_2D, id);
            glTexParameterf(GL_TEXTURE_2D,GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, pixels);
        }
        catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    /**
     * Pass the texture in a shader.
     */

    public void bind(){
        glBindTexture(GL_TEXTURE_2D, id);
    }

    public void detach() {
        glBindTexture(GL_TEXTURE_2D, 0);
    }
}
