'use strict';
//더하기
function add(num1,num2){
   return num1+num2;
}
//곱하기
function multiply(num1,num2){
    return num1*num2;
}

function surprise(callback){
    const result = callback(11,10);
    console.log(`result:${result}`);
}

//result:21
surprise(multiply);