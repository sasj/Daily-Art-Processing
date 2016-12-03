float t;
float theta;
float numb = 2;
int maxFrameCount = 200;
int radius = 137;

void setup() {
  size(540, 540);
  noFill();
  strokeWeight(2);
  strokeJoin(ROUND);
  strokeCap(ROUND);
}

void draw() {
  background(#515B5E);
  translate(width/2, height/2);  

  t = (float)frameCount/maxFrameCount;
  theta = TWO_PI*t;

  for (int i = 0; i < 360; i += 20) {
    float angle = radians(i);
    float x =  (cos(angle) * radius);
    float y =  (sin(angle) * radius);

    shape(x, y, HALF_PI+(radians(i)));
  }
}

void shape(float xpos, float ypos, float a) {
  pushMatrix();
  translate(xpos, ypos);
  rotate(a);
  
  for ( int x= -50; x <= 56; x += 100) {
    for (int y= -50; y <= 56; y += 100) {
      for (int i=0; i<=numb-1; i++) {
        
        float offSet = (TWO_PI/numb*i); 
        float offSet2 = (TWO_PI/numb*i)*2; 
        float pos1 = map(sin(-theta+offSet), -1, 1, -75, 75);
        float pos2 = map(cos(-theta+offSet), -1, 1, 50, -50);
        float pos3 = map(sin(-theta+offSet2), -1, 1, -50, 50);
        float pos4 = map(sin(-theta+offSet), -1, 1, 100, -50);

        /* modulo for two colors */
        if (i % 2 == 0) {
          stroke(#F28C6C);
        } else {
          stroke(#2E3233);
        }
        triangle(0, pos4, pos2, pos3, pos1, pos2);
      }
    }
  }

  popMatrix();
}