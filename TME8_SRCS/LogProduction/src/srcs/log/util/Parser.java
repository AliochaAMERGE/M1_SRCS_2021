package srcs.log.util;

import java.io.File;


public final  class Parser {

	
	private Parser() {}
	
	public static String getMachine(String file){
		return  new File(file).getName().split(".log")[0];
	}
		
	public static String getLevel(String logline){
		return  logline.split(" ")[2];
	}
	
	public static int getYear(String logline) {
		return Integer.parseInt(logline.split(" ")[0].split("-")[0]);
		
	}
	public static int getMonth(String logline) {
		return Integer.parseInt(logline.split(" ")[0].split("-")[1]);
	}
	public static int getDay(String logline) {
		return Integer.parseInt(logline.split(" ")[0].split("-")[2]);
	}
	public static int getHour(String logline) {
		return Integer.parseInt(logline.split(" ")[1].split(":")[0]);
	}
	public static int getMinute(String logline) {
		return Integer.parseInt(logline.split(" ")[1].split(":")[1]);
	}
	public static int getSecond(String logline) {
		return Integer.parseInt(logline.split(" ")[1].split(":")[2].split(",")[0]);
	}
	public static int getMilliSecond(String logline) {
		return Integer.parseInt(logline.split(" ")[1].split(":")[2].split(",")[1]);
	}
	public static String getNameClasse(String logline) {
		return  logline.split(" ")[3].split(":")[0];
	}
	public static String getMessage(String logline) {
		String[] words =  logline.split(" ");
		StringBuilder sb = new StringBuilder(words[4]);
		for(int i =5;i<words.length;i++) {
			sb.append(" "+words[i]);
		}
		return sb.toString();
	}
	
}
