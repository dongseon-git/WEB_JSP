 'use strict';
//논리연산자
let local01, local02, local03, local04, local05, local06;
//ture 
local01 = (3>2) &&(5>3);
console.log(`local01:${local01}`);
local02 = (3<2) &&(5>3);
console.log(`local01:${local02}`);
local03 = (3>2) || (5>3);
console.log(`local01:${local03}`);
local04 = (3<2) || (5>3);
console.log(`local01:${local04}`);
local05 = !(3<2);
console.log(`local01:${local05}`);
local06 = !(3>2);
console.log(`local01:${local06}`);