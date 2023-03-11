/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    let longest = "";
    let currentWord = "";
    for(let i=0; i< strs[0].length; i++){
        currentWord += strs[0][i];
        let checkCounter = 0;
        
        for(let j=0; j <strs.length; j++){

            if(strs[j].indexOf(currentWord) == 0){
                checkCounter++;
            }
        }

        if(checkCounter == strs.length){
            longest = currentWord;
        }
    }
    return longest
};
