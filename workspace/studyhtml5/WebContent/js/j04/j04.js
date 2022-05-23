'use strict';
function showSubject(){
    for(let i = 0;i<arguments.length;i++){
        console.log(`arguments[${i}] : ${arguments[i]}`);       
 }
}
//showSubject('html','css','javascript');
showSubject('html','css','javascript','jquery','jsp','spring');