'use strict';
function multiply(n){
    return function(){
        return n *= n;
    }
}
let num01 = multiply(10);
console.log(`num01: ${num01()}`);

console.log(`num01: ${num01()}`);

let num02 = multiply(3);
console.log(`num02: ${num02()}`);
console.log(`num02: ${num02()}`);