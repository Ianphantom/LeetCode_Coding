/**
 * @param {number} n
 * @return {number}
 */

var climbStairs = function(n) {
    let way = [1,2];
    result = 0;
    if(n == 1){
        return 1
    }else if(n == 2){
        return 2
    }
    for(let i=3; i <= n; i++){
        result = way[way.length - 1] + way[way.length - 2];
        way.push(result) 
    }

    return result
};
