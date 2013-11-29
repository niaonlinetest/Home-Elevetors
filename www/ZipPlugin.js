/**
 * ZipPlugin.js
 *
 * Phonegap Extract Zip File plugin
 *
 * Created by Shaun Rowe on 10/05/2012.
 * Modified for Phonegap 3.0 by Alessio Dal Bianco (infoFACTORY) on 3/10/2013
 * Copyright (c) Pobl Creative Cyf. 2012
 * @param {string} file full path
 * @param {string} directory fullpath
 * @param {Function} successCallback
 * @param {Function} errorCallback
 */
var extractZipFile = function(file, destination, successCallback, errorCallback){
    return cordova.exec(successCallback, errorCallback, "ExtractZipFilePlugin", "extract", [file, destination]);
}

module.exports = extractZipFile;
});
