/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
    let pointer2 = n -1;
    let pointer1 = m- 1;
    let last = (m+n) - 1;

    while(pointer2 >= 0 && pointer1 >= 0){
        if(nums2[pointer2] >= nums1[pointer1]){
            nums1[last] = nums2[pointer2]
            last--;
            pointer2--
        }else if(nums2[pointer2] <= nums1[pointer1]){
            nums1[last] = nums1[pointer1]
            pointer1--;
            last--;
        }
    }

    while (pointer2 >= 0) {
        nums1[last] = nums2[pointer2];
        last--;
        pointer2--;
    }

    return(nums1)
};
