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

public class sketch_161008 extends PApplet {

float t;
float theta;
float space = 25; /* space for the triangles */
float numb = 2; /* number of shapes */
int maxFrameCount = 200; /* how fast is goes */
int radius = 120; /* radius of the start (outer) circle */

public void setup() {
  
  background(238);
  noStroke();
}

public void draw() {
  background(0xffFECAA7);
  translate(width/2, height/2);  
  
  t = (float)frameCount/maxFrameCount;
  theta = TWO_PI*t;
  rotate(HALF_PI*3);

/* I just added 3 times a circle of shapes, could be done better  */
/* first ring */
  for (int i = 0; i < 360; i += 15) {
    float angle = radians(i);
    float x =  (cos(angle) * radius*1.5f);
    float y =  (sin(angle) * radius*1.5f);
   
   shape(x,y,HALF_PI+(radians(i)));
  }

/* middle ring */
  for (int i = 0; i < 360; i += 30) {
    float angle = radians(i);
    float x =  (cos(angle) * radius);
    float y =  (sin(angle) * radius);
   
    shape(x,y,HALF_PI+(radians(i)));
  }

/* inner ring */
  for (int i = 0; i < 360; i += 60) {
    float angle = radians(i);
    float x =  (cos(angle) * radius/2);
    float y =  (sin(angle) * radius/2);
   
    shape(x,y,HALF_PI+(radians(i)));
  }

 }


public void shape(float xpos,float ypos, float a){
  pushMatrix();
  translate(xpos,ypos);

  rotate(a); /* rotate the shapes around the center */

    for ( int x= -25; x <= 26; x += 50) {
      for (int y= -25; y <= 26; y += 50) {

        for (int i=0; i<=numb-1; i++) {

          float offSet = (TWO_PI/numb*i)+(a*3); 
          float offSet2 = offSet*2; 
          float pos1 = map(cos(-theta+offSet), -1, 1, -50, 50);

          /* modulo for two colors */
          if (i % 2 == 0) {
          fill(0xff335D66);
          } else{
          fill(0xffFF5D66);
          }
    
          triangle(0-space,0,0,0+pos1,0+space,0);      
      }
    }
  }
  
  popMatrix();
  
}
  public void settings() {  size(540, 540); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sketch_161008" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
