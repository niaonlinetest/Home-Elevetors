/*
 	Author: Vishal Rajpal
 	Filename: ExtractZipFilePlugin.java
 	Created Date: 22-01-2013
 	Modified Date: 22-01-2013
*/

package com.phonegap.plugin.ExtractZipFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.json.JSONArray;
import org.json.JSONException;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;

import android.util.Log;

public class ExtractZipFilePlugin extends CordovaPlugin {

	
	@Override
	public boolean execute(String action, JSONArray args,CallbackContext callbackContext) throws JSONException {
		// TODO Auto-generated method stub
		if (action.equals("extract")) {
			 try {
					String filename = args.getString(0);
					File file = new File(filename);
					String[] dirToSplit=filename.split(File.separator);
					String dirToInsert="";
					for(int i=0;i<dirToSplit.length-1;i++)
					{
						dirToInsert+=dirToSplit[i]+File.separator;
					}
					BufferedOutputStream dest = null;
					BufferedInputStream is = null;
					ZipEntry entry;
					ZipFile zipfile;
					try {
						zipfile = new ZipFile(file);
						Enumeration e = zipfile.entries();
						while (e.hasMoreElements()) 
						  {
							  entry = (ZipEntry) e.nextElement();
							  is=new BufferedInputStream(zipfile.getInputStream(entry), 8192);
							//  is = new BufferedInputStream(zipfile.getInputStream(entry));
							  int count;
							  byte data[] = new byte[102222];
							  String fileName = dirToInsert + entry.getName();
							  File outFile = new File(fileName);
							  if (entry.isDirectory()) 
							  {
								  outFile.mkdirs();
							  } 
							  else 
							  {
								  FileOutputStream fos = new FileOutputStream(outFile);
								  dest = new BufferedOutputStream(fos, 102222);
								  while ((count = is.read(data, 0, 102222)) != -1)
								  {
									  dest.write(data, 0, count);
								  }
								  dest.flush();
								  dest.close();
								  is.close();
							  }
						  }
						callbackContext.success();
					} catch (ZipException e1) {
						// TODO Auto-generated catch block
						callbackContext.error(PluginResult.Status.MALFORMED_URL_EXCEPTION.toString());
						return false;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						callbackContext.error(PluginResult.Status.IO_EXCEPTION.toString());
						return false;
					}
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					callbackContext.error(PluginResult.Status.JSON_EXCEPTION.toString());
					return false;
				}
		}
		return super.execute(action, args, callbackContext);
	}
}
