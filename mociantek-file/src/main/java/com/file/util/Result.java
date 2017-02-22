package com.file.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
/**
 * 返回值结果工具类
 * @author user
 *
 */
		
public class Result {
			public static final SerializerFeature[] features = {//
			// 输出空置字段
					SerializerFeature.WriteMapNullValue,
					// list字段如果为null，输出为[]，而不是null
					SerializerFeature.WriteNullListAsEmpty,
					// 数值字段如果为null，输出为0，而不是null
					SerializerFeature.WriteNullNumberAsZero,
					// Boolean字段如果为null，输出为false，而不是null
					SerializerFeature.WriteNullBooleanAsFalse,
					// 字符类型字段如果为null，输出为""，而不是null
					SerializerFeature.WriteNullStringAsEmpty
					};
			protected static final SerializeConfig config;
			static {
				// 配置
				config = new SerializeConfig();
				config.put(java.util.Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd")); // 默认格式
				config.put(java.sql.Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd")); // 默认格式
			}
		public final static int success = 200;
		public final static int fail = 500;
		private Integer staCode;
		private String staMsg;
		private Object staResult;
		
		
		public static String success(String staMsg, Object staResult){
			Result result = new Result(success, staMsg, staResult);
			return JSON.toJSONString(result);
		}
		
		public static String success(String staMsg){
		    Result result = new Result(success,staMsg,"");
		    return JSON.toJSONString(result);
		}
		
		public static String fail(String staMsg, Object staResult){
			Result result = new Result(fail, staMsg, staResult);
			return JSON.toJSONString(result);
		}
		
		public static String fail(String staMsg){
		    Result result = new Result(fail,staMsg,"");
		    return JSON.toJSONString(result);
		}
		
		
		public Result(Integer staCode, String staMsg, Object staResult) {
			super();
			this.staCode = staCode;
			this.staMsg = staMsg;
			this.staResult = staResult;
		}
		public Integer getStaCode() {
			return staCode;
		}
		public void setStaCode(Integer staCode) {
			this.staCode = staCode;
		}
		public String getStaMsg() {
			return staMsg;
		}
		public void setStaMsg(String staMsg) {
			this.staMsg = staMsg;
		}
		public Object getStaResult() {
			return staResult;
		}
		public void setStaResult(Object staResult) {
			this.staResult = staResult;
		}
		public static SerializerFeature[] getFeatures() {
			return features;
		}
		public static SerializeConfig getConfig() {
			return config;
		}
		public static int getSuccess() {
			return success;
		}
		public static int getFail() {
			return fail;
		}
		
		
}
