'use strict';
let sum = 0;
for(let i=1;i<=10;i++){
    sum+=i;
    if(sum>=30){
        console.log(`sum30이상:${sum}, i:${i}`);
        break;
    }
}