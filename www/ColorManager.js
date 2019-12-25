var exec = require('cordova/exec');

var ColorManager = function () {}

ColorManager.prototype.showRed = function () {
	exec(function () {}, function () {}, "ColorManager", "showRed", []);
};

ColorManager.prototype.showGreen = function () {
	exec(function () {}, function () {}, "ColorManager", "showGreen", []);
};

ColorManager.prototype.showOrange = function () {
	exec(function () {}, function () {}, "ColorManager", "showOrange", []);
};

ColorManager.prototype.closeColor = function () {
	exec(function () {}, function () {}, "ColorManager", "closeColor", []);
};

module.exports = new ColorManager();
