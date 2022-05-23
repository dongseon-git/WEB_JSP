'use strict';
let info = {
  subject: 'javascript',
  credit:5,
  printOut:function(){
    return this.subject+','+this.credit;
} 
};
console.log(`info.subject : ${info.subject}`);
console.log(`info.credit:${info.credit}`);
console.log(`info.printOut:${info.printOut()}`);