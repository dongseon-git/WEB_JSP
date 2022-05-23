'use strict';
let kor = 90;
function getScore(){
    kor = 100;
    console.log(`kor:${kor}`);
}
getScore();
console.log(`kor:${kor}`); //전역변수
console.clear();
let eng = 90;
function getEngScore(){
    let eng = 100;//지역변수
    console.log(`eng=${eng}`);
}
getEngScore();
console.log(`eng:${eng}`); 
