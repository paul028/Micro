#include <SoftwareSerial.h>
SoftwareSerial bluetooth(2,3);
int gear=1,value=200;
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
      forward(value);
      delay(50);
      motorbreak();
    }
       if(i==50) //down 2
    {
       backward(value);
      delay(50);
         motorbreak();
    }
        if(i==51) //left 3
    {
         left(value);
        delay(50);
           motorbreak();
    }
        if(i==52) //right 4
    {
       right(value);
      delay(50);
         motorbreak();
    }   
    if(i==54)
    {
      gear++;
      if(gear >3)
      {
        gear=1;
      }
      if(gear==1)
      {
        value=170;
      }
      if(gear==2)
      {
          value=230;
      }
      if(gear==3)
      {
        value=255;
      }
    }

}

void forward(int value)
{
     analogWrite(6,value);  //L1
     digitalWrite(5,LOW);  //L2
     analogWrite(9,value);  //R1
     digitalWrite(10,LOW); //R2
}

void backward(int value)
{
       digitalWrite(6,LOW);  //L1
       analogWrite(5,value);  //L2
       digitalWrite(9,LOW);  //R1
       analogWrite(10,value); //R2
}

void left(int value)
{
  digitalWrite(6,LOW);  //L1
       analogWrite(5,value);  //L2
       analogWrite(9,value);  //R1
       digitalWrite(10,LOW); //R2
}

void right(int value)
{
       analogWrite(6,value);  //L1
       digitalWrite(5,LOW);  //L2
       digitalWrite(9,LOW);  //R1
       analogWrite(10,value); //R2
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
