'use strict';

let age = 20;
let admissionFee = "";

if(age < 13){
    admissionFee = '2,000원';
}else if(age>=13 && age<=19){
    admissionFee = '4,000원';
}else{
    admissionFee = '6,000원';
}
console.log(`age:${age}, admissionFee:${admissionFee}`);

//파비콘(favicon) *.ico
//<link rel = "short icon" type="image/x-icon" href="/favicon.ico">
