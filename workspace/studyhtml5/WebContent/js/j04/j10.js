'use strict';
function factorial(n){
    //종료조건
    if(n === 0){
        console.log('호출 끝!');
    }else{
        console.log(`n=${n}`);
        factorial(n-1);
    }
}
factorial(4);
