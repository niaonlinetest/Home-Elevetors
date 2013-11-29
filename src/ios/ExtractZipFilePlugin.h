//
//  ExtractZipFilePlugin.h
//
//  Created by Shaun Rowe on 10/05/2012.
//  Modifyed by Alessio Dal Bianco (infoFACTORY) on 3/10/2013
//  Copyright (c) 2012 Pobl Creative Cyf. All rights reserved.
//

#import <Cordova/CDVPlugin.h>
#import "SSZipArchive.h"

@interface ExtractZipFilePlugin : CDVPlugin
{
    NSString* _callbackId;
}

@property (nonatomic, copy) NSString* callbackID;

- (void)extract: (CDVInvokedUrlCommand*)command;

@end
