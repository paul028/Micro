#include <SoftwareSerial.h>
SoftwareSerial bluetooth(2,3);
void setup() {
 bluetooth.begin(9600);
  pinMode(10,OUTPUT); //R2
  pinMode(9,OUTPUT); //R1
  pinMode(6,OUTPUT); //L1
  pinMode(5,OUTPUT); //L2
  Serial.begin(9600);
}

void loop() {
  short i;
  if(bluetooth.available()>0)
  {
     i=bluetooth.read();
  }

    if(i==49) //up 1
    {
      forward();
      delay(50);
      motorbreak();
    }
       if(i==50) //down 2
    {
       backward();
      delay(50);
         motorbreak();
    }
        if(i==51) //left 3
    {
         left();
        delay(50);
           motorbreak();
    }
        if(i==52) //right 4
    {
       right();
      delay(50);
         motorbreak();
    }   

}

void forward()
{
     digitalWrite(6,HIGH);  //L1
     digitalWrite(5,LOW);  //L2
     digitalWrite(9,HIGH);  //R1
     digitalWrite(10,LOW); //R2
}

void backward()
{
       digitalWrite(6,LOW);  //L1
       digitalWrite(5,HIGH);  //L2
       digitalWrite(9,LOW);  //R1
       digitalWrite(10,HIGH); //R2
}

void left()
{
  digitalWrite(6,LOW);  //L1
       digitalWrite(5,HIGH);  //L2
       digitalWrite(9,HIGH);  //R1
       digitalWrite(10,LOW); //R2
}

void right()
{
       digitalWrite(6,HIGH);  //L1
       digitalWrite(5,LOW);  //L2
       digitalWrite(9,LOW);  //R1
       digitalWrite(10,HIGH); //R2
}

void motorbreak()
{
      digitalWrite(10,LOW); //L1
      digitalWrite(9,LOW);  //L2
      digitalWrite(6,LOW);  //R1
      digitalWrite(5,LOW);  //R2
}

void kick()
{
  
}
