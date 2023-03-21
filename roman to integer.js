/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
    const checkNumber = (roman) => {
        if(roman === "I") return 1
        else if(roman ==="V") return 5
        else if(roman ==="X") return 10
        else if(roman ==="L") return 50
        else if(roman ==="C") return 100
        else if(roman ==="D") return 500
        else if(roman ==="M") return 1000
    }

    let number = 0;

    for(let i=0; i< s.length; i++){
        if(checkNumber(s[i]) < checkNumber(s[i+1])){
            number += checkNumber(s[i+1]) - checkNumber(s[i]);
            i+=1;
        }else{
            number += checkNumber(s[i]);
        }
    }

    return number;
};
