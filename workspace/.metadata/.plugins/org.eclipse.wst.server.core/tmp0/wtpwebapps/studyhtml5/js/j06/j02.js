'use strict';
//생성자함수

function Triangle(b,h){
    this.base = b;
    this.height = h;
    
}
//동적추가된 함수
Triangle.prototype.area = function(){
    return this.base *this.height /2;
};
Triangle.prototype.printOut = function(){
    return '밑변:' +this.base+',높이:'+this.height+',넓이:'+this.area();
};

let triangle01 = new Triangle(10,10);
console.log(`triangle01.area():${triangle01.area()}`);
console.log(`triangle01.printOut:${triangle01.printOut()}`);