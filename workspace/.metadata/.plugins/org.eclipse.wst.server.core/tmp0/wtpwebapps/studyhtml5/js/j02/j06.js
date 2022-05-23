//문법을 타이트하게 검사
 'use strict';
 let char = 'java';
 let brendan ="brenden";
 const helloBrendan = 'Hello'+brendan;
 console.log(`char:${char},type:${typeof char}`);
 console.log(`brendan:${brendan}, type:${typeof brendan}`);
 console.log(`helloBrendan:${helloBrendan}, type:${typeof helloBrendan}`);

let str01 = '문자는 "문자"';
let str02 = "문자는 '문자'"
console.log(`str01:${str01}`);
console.log(`str01:${str02}`);