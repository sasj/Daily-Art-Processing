import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sketch_161011 extends PApplet {

float t;
float theta;
int maxFrameCount = 250; // how fast the animation goes
float space = 30; // space for the quad
float numb = 4; // number of
int radius = 110;

public void setup() {
  
  noFill();
  strokeWeight(1);
}


public void draw() {
  background(0xffFAC864);
  translate(width/2, height/2);  

  t = (float)frameCount/maxFrameCount;
  theta = TWO_PI*t;

  for (int i = 0; i < 360; i += 30) {
    float angle = radians(i);
    float x =  (cos(angle) * radius);
    float y =  (sin(angle) * radius);

    shape(x, y, HALF_PI+(radians(i)));
  }
  
}

public void shape(float xpos, float ypos, float a) {
  pushMatrix();
  translate(xpos, ypos); // translate the position
  rotate(a); // we rotate the shapes in a circle what we declare in the draw
  for ( int x= -25; x <= 25; x += 25) {

      for (int i=0; i<=numb-1; i++) {
        float offSet = (TWO_PI/numb*i)+(a/3)+x; 
        float pos1 = map(sin(-theta+offSet), -1, 1, -50, 50);
        float pos2 = map(cos(-theta+offSet), -1, 1, 50, -50);

        // modulo for having two colors
        if (i % 2 == 0) {
          stroke(0xff0A1596);
        } else {
          stroke(0xffF51596);
        }
        // the shape
         quad(0,0+pos1,0-space,0,0,0-pos2,0+space,0);  
      }
    }
  popMatrix();
}
  public void settings() {  size(540, 540); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sketch_161011" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
