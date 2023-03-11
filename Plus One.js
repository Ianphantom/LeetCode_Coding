/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    let remainder=0;
    let result = [];

    for(let i=digits.length-1; i>= 0; i--){
        let number = digits[i];

        if(i == digits.length-1){
            number++;
        }
        number = number + remainder;
        if(number > 9){
            number = 0;
            remainder = 1;
            result.unshift(number);
        }else{
            remainder = 0;
            result.unshift(number)
        }
    }

    if(remainder == 1){
        result.unshift(1);
    }
    return result
};
