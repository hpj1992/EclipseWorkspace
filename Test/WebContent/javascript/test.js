function strict1(str){
  "use strict";
  return eval(str); 
}
function strict2(f, str){
  "use strict";
  return f(str); 
}
function nonstrict(str){
  return eval(str);
}

function useStrictFunctionality()
{
alert(strict1("'This is Strict mode code!'"));
alert(strict1("'use strict'; 'This is Strict mode code!'"));
alert(strict2(eval, "'This is Non-strict code.'"));
alert(strict2(eval, "'use strict'; ' This is Strict mode code!'"));
alert(nonstrict("' This is Non-strict code.'"));
alert(nonstrict("'use strict'; ' This is Strict mode code!'"));
}
