'use strict';
//변수, 함수 호이스팅(hoisting)
//var변수와 함수는 컴파일러에 의해 호이스팅이 발생!
//선언 전에 실행 가능!

//compute();
function compute(){
    let x = 10;
    let y = 100;
    let result = x/y;
    console.log(`result:${result}`);
}
compute();