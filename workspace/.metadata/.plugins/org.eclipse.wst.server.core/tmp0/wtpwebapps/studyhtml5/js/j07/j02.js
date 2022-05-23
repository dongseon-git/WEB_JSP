'use strict';
let city = ['미국','영국','필리핀','아이슬란드'];
for(let i in city){
    console.log(`i:${i},city[${i}]: ${city[i]}`);
}
for(let i of city){
    console.log(`i:${i}`);
}
