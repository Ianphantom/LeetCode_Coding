var addBinary = function(a, b) {
    let res = '';
    let carry = 0;
    let i = a.length - 1, j = b.length - 1;

    while (i >= 0 || j >= 0 || carry) {
        const sum = (+a[i] || 0) + (+b[j] || 0) + carry;
        res = (sum % 2) + res;
        carry = sum > 1 ? 1 : 0;
        i--;
        j--;
    }

    return res;
};
