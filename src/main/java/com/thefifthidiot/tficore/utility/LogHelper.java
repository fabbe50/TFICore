package com.thefifthidiot.tficore.utility;

import com.thefifthidiot.tficore.core.reference.Reference;
import com.thefifthidiot.tficore.lib.Configs;

import net.minecraftforge.fml.common.FMLLog;

import org.apache.logging.log4j.Level;

public class LogHelper
{
	/*	Made for easy logging by Pahimar!
	 * 	Information/code obtained, modified and printed in class by fabbe50/Teemo
	 * 
	 * 	Usage: LogHelper.<level>(messageToPrint);
	 * 	@func all   - All events should be logged.
	 * 	@func debug - A general debugging event.
	 * 	@func error - An error in the application, possibly recoverable.
	 * 	@func fatal - A severe error that will prevent the application from continuing.
	 * 	@func info  - An event for informational purposes.
	 * 	@func finfo - An event for informational purposes, that overrides the mods config-option.
	 * 	@func off   - No events will be logged.
	 * 	@func trace - A fine-grained debug message, typically capturing the flow through the application.
	 * 	@func warn  - An event that might possible lead to an error.
	 */
	
    private static void log(Level logLevel, Object object) {
        FMLLog.log(Reference.MOD_NAME, logLevel, String.valueOf(object));
    }

    public static void all(Object object) {log(Level.ALL, object);}
    public static void debug(Object object) {log(Level.DEBUG, object);}
    public static void error(Object object) {log(Level.ERROR, object);}
    public static void fatal(Object object) {log(Level.FATAL, object);}
    public static void info(Object object) {if (Configs.infoLogging){log(Level.INFO, object);}}
    public static void finfo(Object object) {log(Level.INFO, object);}
    public static void off(Object object) {log(Level.OFF, object);}
    public static void trace(Object object) {log(Level.TRACE, object);}
    public static void warn(Object object) {log(Level.WARN, object);}
}