'use strict';
(function(){
    life();
})();
function life(){
    console.log('즉시실행함수1');
}
let instant = (function(){
    console.log('즉시실행함수2');  
})();