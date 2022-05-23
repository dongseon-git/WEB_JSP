'use strict';
class Person {
    //생성자
    constructor(name,age){
        //맴버변수
       this.name = name;
       this.age = age;
    }
    //메서드
   speak(){
    console.log(`name:${this.name},age:${this.age} speak!`);
}
}
const pcwk = new Person('PCWK',23);
//맴버변수
console.log(`pcwk.name:${pcwk.name}`);
console.log(`pcwk.age:${pcwk.age}`);

pcwk.speak();