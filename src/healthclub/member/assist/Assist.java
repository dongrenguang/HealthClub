package healthclub.member.assist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assist {
	public final static String path="E:/workspace/JavaEE/HealthClub/WebContent/";
	
	public static java.sql.Date getNowDate(){
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd"); 
	    Calendar calendar=Calendar.getInstance();
	    java.util.Date date=calendar.getTime();
	    String str=sdf.format(date);  
	    @SuppressWarnings("deprecation")
		java.sql.Date startDate2=new java.sql.Date(java.sql.Date.parse(str))	;
	    return startDate2;
	}
	
	public static int String2Int(String s){
		return Integer.valueOf(s).intValue();
	}
	
	@SuppressWarnings({ "unused", "deprecation" })
	public static java.sql.Date getBirthday(String birthday) {
		//String  birth=birthday.replace("-","/");
		//birth=birth.substring(0,10);
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd"); 
			java.sql.Date d=new java.sql.Date(java.sql.Date.parse(birthday));
			return d;
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
		}
		return null;
	}
	
    @SuppressWarnings("resource")
	public static String savePicture(String savePath,String username,String uploadFileName,File upload){
    	String returnPath=savePath+"/"+username+getPictureType(uploadFileName);
    	String newPath=path+returnPath;
		try {
			
			FileOutputStream fos = new FileOutputStream(newPath);
            
			FileInputStream fis=new FileInputStream(upload);
            byte[] buffer=new byte[1024];
            int len=0;
            while((len=fis.read(buffer))>0){
        	fos.write(buffer,0,len);
            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return returnPath;
    }
    
    public static String getPictureType(String picName){//分割字符串，得到图片的格式，比如“.png”
    	String[] strArr = picName.split("\\.");
    	int count=strArr.length;
    	return "."+strArr[count-1];  	
    }
    
//    public static getStringOrNull(String s){
//    	
//    }
    public static String transform(String birthday){
    	try {
        	String  birth=birthday.replace("-","/");
        	return birth;
		} catch (Exception e) {
			// TODO: handle exception
		}
        return null;
    }
    
    public static String getNowDateTime(){
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String nowDateTime=df.format(new Date());// new Date()为获取当前系统时间
		return nowDateTime;
    }
    
    public static int getAge(java.sql.Date date){
    	int age=0;
    	try {
    		String dateString=date.toString();
    		String yearString=dateString.substring(0,4);
    		int year=Integer.parseInt(yearString);
    		
    		java.sql.Date nowDate=getNowDate();
    		String nowDateString=nowDate.toString();
    		String nowYearString=nowDateString.substring(0,4);
    		int nowYear=Integer.parseInt(nowYearString);
    		
    		age=nowYear-year;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return age;
    }
    
    public static List<Map.Entry<String, Integer>> lineSort(HashMap<String, Integer> map){
    	List<Map.Entry<String, Integer>> infoIds =
    		    new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
    	
    	        //排序
    			Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {   
    			    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {      
    			        //return (o2.getValue() - o1.getValue()); 
    			        return (o1.getKey()).toString().compareTo(o2.getKey());
    			    }
    			}); 
    			
    			return infoIds;
    }
    
    public static String getMonth(String time){
        //String time="21 March 2014 - 10:30";
	    String[] strarray=time.split(" "); 
	    String month=strarray[1];
	    String year=strarray[2];
	    return month+" "+year;
    }
    
    public static String getCurrentMonthDay(String time){
    	//String time="21 March 2014 - 10:30";
	    String[] strarray=time.split(" "); 
	    int day=Integer.parseInt(strarray[0]);
	    String month=strarray[1];
	    int year=Integer.parseInt(strarray[2]);
	    int monthInt=0;
	    
	    if(month.equals("January")){
	    	monthInt=1;
	    }else if(month.equals("February")){
	    	monthInt=2;
	    }else if(month.equals("March")){
	    	monthInt=3;
	    }else if(month.equals("April")){
	    	monthInt=4;
	    }else if(month.equals("May")){
	    	monthInt=5;
	    }else if(month.equals("June")){
	    	monthInt=6;
	    }else if(month.equals("July")){
	    	monthInt=7;
	    }else if(month.equals("August")){
	    	monthInt=8;
	    }else if(month.equals("September")){
	    	monthInt=9;
	    }else if(month.equals("October")){
	    	monthInt=10;
	    }else if(month.equals("November")){
	    	monthInt=11;
	    }else if(month.equals("December")){
	    	monthInt=12;
	    }
	    
	    Calendar c=Calendar.getInstance();
		int current_year = c.get(Calendar.YEAR);    //获取年
		int current_month = c.get(Calendar.MONTH) + 1;   //获取月份，0表示1月份
		
		if(current_year!=year || current_month!=monthInt){
			return "";
		}else{
			return day+" "+month+" "+year;
		}
    }
    
    public static String getNowMonth(){
    	Calendar c=Calendar.getInstance();
		int current_year = c.get(Calendar.YEAR);    //获取年
		int current_month = c.get(Calendar.MONTH) + 1;   //获取月份，0表示1月份
		
		return current_year+"-"+current_month;
    }
    
}
