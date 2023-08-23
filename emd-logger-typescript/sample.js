/// <reference path="Validation.ts" />
var Validation;
(function (Validation) {
    var lettersRegexp = /^[A-Za-z]+$/;
    var LettersOnlyValidator = /** @class */ (function () {
        function LettersOnlyValidator() {
        }
        LettersOnlyValidator.prototype.isAcceptable = function (s) {
            return lettersRegexp.test(s);
        };
        return LettersOnlyValidator;
    }());
    Validation.LettersOnlyValidator = LettersOnlyValidator;
})(Validation || (Validation = {}));
/// <reference path="Validation.ts" />
var Validation;
(function (Validation) {
    var globalHyphenRegexp = /-/g;
    var numbers5Regexp = /^[0-9]{5,5}$/;
    var numbers9Regexp = /^[0-9]{9,9}$/;
    var ZipCodeValidator = /** @class */ (function () {
        function ZipCodeValidator() {
        }
        ZipCodeValidator.prototype.isAcceptable = function (s) {
            return (numbers5Regexp.test(s) ||
                numbers9Regexp.test(s.replace(globalHyphenRegexp, '')));
        };
        return ZipCodeValidator;
    }());
    Validation.ZipCodeValidator = ZipCodeValidator;
})(Validation || (Validation = {}));
/// <reference path="./validation/Validation.ts" />
/// <reference path="./validation/LettersOnlyValidator.ts" />
/// <reference path="./validation/ZipCodeValidator.ts" />
var ValidationOriginal;
(function (ValidationOriginal) {
    var lettersRegexp = /^[A-Za-z]+$/;
    var numbersRegexp = /^[0-9]+$/;
    var LettersOnlyValidator = /** @class */ (function () {
        function LettersOnlyValidator() {
        }
        LettersOnlyValidator.prototype.isAcceptable = function (s) {
            return lettersRegexp.test(s);
        };
        return LettersOnlyValidator;
    }());
    ValidationOriginal.LettersOnlyValidator = LettersOnlyValidator;
    var ZipCodeValidator = /** @class */ (function () {
        function ZipCodeValidator() {
        }
        ZipCodeValidator.prototype.isAcceptable = function (s) {
            return (s.length === 5 || s.length === 9) && numbersRegexp.test(s);
        };
        return ZipCodeValidator;
    }());
    ValidationOriginal.ZipCodeValidator = ZipCodeValidator;
})(ValidationOriginal || (ValidationOriginal = {}));
var strings = ['Hello', '98052', '191', '22150-0241'];
var validators = {};
validators['ZIP Code'] = new Validation.ZipCodeValidator();
validators['Letters Only'] = new Validation.LettersOnlyValidator();
for (var _i = 0, strings_1 = strings; _i < strings_1.length; _i++) {
    var s = strings_1[_i];
    for (var name_1 in validators) {
        var isMatch = validators[name_1].isAcceptable(s);
        console.log("'".concat(s, "' - ").concat(isMatch ? 'matches' : 'does not match', " '").concat(name_1, "'."));
    }
}
