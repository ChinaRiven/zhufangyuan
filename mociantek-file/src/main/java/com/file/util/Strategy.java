package com.file.util;

import com.qiniu.util.Auth;


/**
 * 七牛策略类
 * @author user
 *
 */
public class Strategy {
	public final static String ACCESS_KEY = "";
	public final static String SECRET_KEY = "";
	public final static String scope   = "";
	public final static String deadline ="";
	public final static String insertOnly ="";
	public final static String endUser="";
	public final static String returnUrl="";
	public final static String returnBody="";
	public final static String callbackUrl="";
	public final static String callbackHost="";
	public final static String callbackBody="";
	public final static String callbackBodyType="";
	public final static String callbackFetchKey="";
	public final static String persistentOps="";
	public final static String persistentNotifyUrl="";
	public final static String persistentPipeline="";
	public final static String saveKey="";
	public final static String fsizeMin="";
	public final static String fsizeLimit="";
	public final static String detectMime="";
	public final static String mimeLimit="";
	public final static String deleteAfterDays="";
	
	
	
	public Strategy() {
		super();
	}
   
    public static Auth  getAuth(){
    	 return Auth.create(ACCESS_KEY, SECRET_KEY);
    }
	 
}
