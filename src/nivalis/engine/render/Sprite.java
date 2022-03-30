package nivalis.engine.render;

import nivalis.tools.transform.Transform;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;

public class Sprite {

   private Transform transform;
   private Vector4f baseColor;
   private Vector2f[] texCoords;
   private Texture texture;
   private boolean dirty = false;
   private float scale;




   public Sprite(float x, float y, Vector4f color, float scale) {
      transform = new Transform(x,y,0);
      baseColor = color;
      texture = null;
      this.texCoords = new Vector2f[] {
         new Vector2f(1,0),
         new Vector2f(1,1),
         new Vector2f(0,1),
         new Vector2f(0,0)
      };
      this.scale = scale;
   }

   public Sprite(float x, float y,Texture texture, Vector2f[] texCoords, float scale){
      transform = new Transform(x,y,0);
      baseColor = new Vector4f(1.0f);
      this.texture = texture;
      this.texCoords = texCoords;
      this.scale = scale;

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

   public float getScale() {
      return scale;
   }


   public void setColor(Vector4f color) {
      this.baseColor = color;
      dirty = true;
   }

   public void setTexCoords(Vector2f[] texCoords) {
      this.texCoords = texCoords;
      dirty = true;
   }

   public void setCoords(float x, float y) {
      transform.setPosition(new Vector3f(x,y,0));
      dirty = true;
   }

   public void setScale(float scale) {
      this.scale = scale;
      dirty = true;
   }

   public void setTexture(Texture texture) {
      this.texture = texture;
      dirty = true;
   }

   public boolean isDirty() {
      return dirty;
   }

   public void clean() {
      dirty = false;
   }


   public int x() {
      return (int) transform.getPosition().x;
   }

   public int y() {
      return (int) transform.getPosition().y;
   }
}
