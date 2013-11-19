/*
 	Author: Vishal Rajpal
 	Filename: ZipPlugin.js
 	Created Date: 22-01-2013
 	Modified Date: 22-01-2013
*/

var ExtractZipFilePlugin=function(){
};

cordova.addConstructor(function() 
{
	cordova.addPlugin('ExtractZipFilePlugin', new ExtractZipFilePlugin());
});

ExtractZipFilePlugin.prototype.extractFile = function(file, successCallback, errorCallback) 
{
    return cordova.exec(successCallback, errorCallback, "ExtractZipFilePlugin", "extract", [file]);
};