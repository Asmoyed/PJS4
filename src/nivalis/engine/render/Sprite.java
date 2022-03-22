package nivalis.engine.render;

import nivalis.tools.transform.Transform;
import org.joml.Vector2f;
import org.joml.Vector4f;

public class Sprite {

   private Transform transform;
   private Vector4f baseColor;
   private Vector2f[] texCoords;
   private Texture texture;
   private int rotation;




   public Sprite(float x, float y, Vector4f color) {
      transform = new Transform(x,y,0);
      baseColor = color;
      texture = null;
      this.texCoords = new Vector2f[] {
         new Vector2f(1,0),
         new Vector2f(1,1),
         new Vector2f(0,1),
         new Vector2f(0,0)
      };
   }

   public Sprite(float x, float y,Texture texture, Vector2f[] texCoords, int rotation){
      transform = new Transform(x,y,0);
      baseColor = new Vector4f(1.0f);
      this.texture = texture;
      this.texCoords = texCoords;
      this.rotation = rotation;
   }


   public Vector4f getColor() {
      return baseColor;
   }

   public Transform getTransform() {
      return transform;
   }

   public Texture getTexture() {
      return texture;
   }

   public Vector2f[] getTexCoords() {
      return texCoords;
   }

   public int getRotation() { return rotation; }

}
