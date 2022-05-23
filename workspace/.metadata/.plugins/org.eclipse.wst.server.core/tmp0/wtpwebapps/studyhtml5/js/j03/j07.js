'use strict';

let i = 1;
let sum = 0;
do{
    sum+=i;
    i++;
    console.log(`sum:${sum}`);
}while(i<=10);
console.log(`sum:${sum}`);