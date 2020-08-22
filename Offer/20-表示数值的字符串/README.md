# 20. 表示数值的字符串

请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。





## 解析

带有数值的字符串可以分为A: 整数部分, B: 紧跟小数点为数值的小数部分, C紧跟着'e'或'E'为数值的指数部分. 其中A并不是必须的, 小数.123 等于 0.123. 如果一个数没有整数部分, 那么小数部分不能为空. 

```c++
bool isNumeric(const char* str){
  	if(str == nullptr)
      	return false;
  	
  	bool numeric = scanInteger(&str);
  	
  	//如果出现. , 那么接下来是数字的小数部分.
  	if(*str == '.'){
      	++str;
      
      	numberic = scanUnsignedInteger(&str) || numeric;
    }
  
  	//如果出现'e'或者'E'. 则接下来是数字的指数部分.
  	if(*str == 'e' || *str == 'E'){
      	++str;
      	numeric = numeric && scanInteger(&str);
    }
  
  	return number && *str == '\0';
}

//用来扫描字符串0-9的数位, 可以用来匹配前面数值中的B部分.
bool scanUnsignedInteger(const char** str){
  	const char* before = *str;
  	while(**str != '\0' && **str >= '0' && **str <= '9')
      	++(*str);
  
  	return *str > before;
}

bool scanInteger(const char** str){
  	if(**str == '+' || **str == '-'){
      	++(*str);
    }
  	return scanUnsignedInteger(str);
}
```

