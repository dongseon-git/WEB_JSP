'use strict';
function isPath(name,htmlScore,cssScore,jsScore){
 let comment = name+' 학생은';
 if(htmlScore>=60 && cssScore >=60 && jsScore >=0){
  comment += ' 전 과목 pass';
    
}else{
    if(htmlScore<60){
        comment +='html 재시험';
    }
    if(htmlScore<60){
        comment +='css 재시험';
        }
if(htmlScore<60){
        comment +='javaScript 재시험';
        }
}  
   return comment; 
}
console.log(isPath('이상무',80,90,95));
console.log(isPath('이상무2',59,40,95));