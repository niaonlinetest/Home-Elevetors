//
//  ExtractZipFilePlugin.m
//
//  Created by Shaun Rowe on 10/05/2012.
//  Modifyed by Alessio Dal Bianco (infoFACTORY) on 3/10/2013
//  Copyright (c) 2012 Pobl Creative Cyf. All rights reserved.
//

#import "ExtractZipFilePlugin.h"
#import "SSZipArchive.h"

@implementation ExtractZipFilePlugin



- (void)extract:(CDVInvokedUrlCommand*)command
{    
    _callbackID = command.callbackId;
    
    NSString *file = [command argumentAtIndex:0];
    NSString *destination = [command argumentAtIndex:1];

    CDVPluginResult *result;
    if([SSZipArchive unzipFileAtPath:file toDestination:destination delegate:nil]) {
        result = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:[destination stringByAddingPercentEscapesUsingEncoding:NSUTF8StringEncoding]];
        [self writeJavascript:[result toSuccessCallbackString:_callbackID]];
    } else {
        result = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:[@"Could not extract archive" stringByAddingPercentEscapesUsingEncoding:NSUTF8StringEncoding]];
        [self writeJavascript:[result toErrorCallbackString:_callbackID]];
    }
}

@end