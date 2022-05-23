'use strict';
let str = 'Javascript';
console.log(`str:${str}`);
console.log(`str.length:${str.length}`);
//charAt(n): n과 같은 index 번호에 위치한 문자를 반환
console.log(`str.charAt(8):${str.charAt(8)}`);
//indexOf('a')
//'a'를 왼쪽부터 문자를 검색해서 일치하는 index에 해당하는 문자인덱스 반환
console.log(`str.indexOf('a'):${str.indexOf('a')}`);
//'a'를 오른쪽부터 문자를 검색해서 일치하는 index에 해당하는 문자인덱스 반환
console.log(`str.lastIndexOf('a'):${str.lastIndexOf('a')}`);

//substring(4,9): 문자열 index번호 4부터 index 9 이전까지 출력
console.log(`str.substring(4,9):${str.substring(4,9)}`);

console.log(`str.substr(4,6):${str.substr(4,6)}`);

str = '010-1234-5678';
let phoneNumArray = str.split('-');
console.log(phoneNumArray[0]+''+phoneNumArray[1]+''+phoneNumArray[2]);

//replace('x','y'): 'x'문자를 'y'문자로 치환

str = 'Javascript';
console.log(`str.replace('a','A'):${str.replace('a','A')}`);

//trim(); 문자열의앞뒤 공백 제거
str = 'Javascript';
console.log(`str.trim():${str.trim()}`);

//toLowerCase(); 소문자로
//toUpperCase(); 대문자로
console.log(`str.toUpperCase():${str.toUpperCase()}`);
console.log(`str.toLowerCase():${str.toLowerCase()}`);