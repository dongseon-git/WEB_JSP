'use strict';
let dateObj = new Date(2022,6,12,14,10,45);
let dateInfo = {
    year : dateObj.getFullYear(),//년도 4자리
    month: dateObj.getMonth()+1 , //월 0~11 +1 필요
    day : dateObj.getDate(), //일(1~31)
    week : dateObj.getDay(), //요일(0은 일요일~ 6은 토요일)
    hours: dateObj.getHours(), // 시간
    minutes: dateObj.getMinutes(), // 분
    seconds: dateObj.getSeconds(),
    milliseconds: dateObj.getMilliseconds()
    
};
for (let i in dateInfo){
   console.log(`${i}:${dateInfo[i]}`);
}