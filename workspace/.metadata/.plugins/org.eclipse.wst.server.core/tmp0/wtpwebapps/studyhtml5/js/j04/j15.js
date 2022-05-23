//'use strict';
//문자를 자바스크립트 코드로 변경
var str01 = 'var num01 = 11';
let str02 = 'var num02 = 13';

eval(str01);
eval(str02);
console.log(`num01+num02=${num01+num02}`);