'use strict';
class User{
    //생성자
    constructor(name,passwd,age){
        this.name = name;
        this.passwd = passwd;
        this.age = age;
    }
    get getAge(){
        return this.age;
    }
    set setAge(value){
        if(value < 0){
            value = 0;
        }
        this.age = value;
    }
}
const user01 = new User('PCWK','1234',-1);
console.log(`name: ${user01.name}`);
console.log(`passwd:${user01.passwd}`);
//setter
user01.setAge = -1;

//getter
//getter 에서 value < 0 이면 0이 되도록 구성.
//age:0
console.log(`age:${user01.getAge}`);