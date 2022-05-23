'use strict';
class Shape{
   constructor(width,height,color){
    this.width = width;//넓이
    this.height= height;//높이
    this.color = color;//색상
}
draw(){
    console.log(`drawing:${this.color} color!`);
}
getArea(){
    return this.width *this.height;
}
}
//사각형
class Rectangle extends Shape{
    
}
//사각형 class
const rectangle = new Rectangle(10,10,'Red');
rectangle.draw();
console.log(`rectangle.getArea():${rectangle.getArea()}`);

//삼각형
class Triangle extends Shape{
    draw(){
       super.draw();
       console.log(`Triangle drawing Blue color!`);
    }
    //getArea()재정의
    getArea(){
        //삼각형 넓이 구하기!
        return(this.width*this.height)/2;
    }
    toString(){
        return `Triangle:color:${this.color}`;
    }
}
const triangle = new Triangle(10,10,'yellow');
triangle.draw();
console.log(`triangle.getArea():${triangle.getArea()}`);
console.log(`triangle.toString():${triangle.toString()}`);

//instanceof
console.log(`triangle instanceof Shape:${triangle instanceof Shape}`);

//사각형, 삼각형
console.log(`triangle instanceof rectangle:${triangle instanceof Rectangle}`);