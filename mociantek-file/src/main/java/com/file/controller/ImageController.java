package com.file.controller;

import java.io.InputStream;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.file.util.Result;
import com.file.util.Strategy;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.StringMap;

@RestController
@RequestMapping("/api/image")
public class ImageController {
	
	
    /**
     * 服务端单文件上传
     * @param inputStream
     * @param Map<String,String> map 业务参数
     * @return
     */
	@RequestMapping("/post")
	public String uploadImage(InputStream inputStream,Map<String,String> map){
	    String result = null;
		//构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone0());
		UploadManager uploadManager = new UploadManager(cfg);
		//封装其他业务参数
		StringMap policy = new StringMap().put("endUser", "uid").putNotEmpty("returnBody", "");
		String uploadToken = Strategy.getAuth().uploadToken(Strategy.scope, null, 3600, policy);
		//String uploadToken = Strategy.getAuth().uploadToken(Strategy.scope,null);
		try {
	        Response response = uploadManager.put(inputStream,null,uploadToken,null,null);
	        //如果自定义了returnbody 返回值      {\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}"
	    result = Result.success("上传成功", response);
	    } catch (QiniuException ex) {
	        Response r = ex.response;
	        System.err.println(r.toString());
	        try {
	            System.err.println(r.bodyString());
	        } catch (QiniuException ex2) {
	           
	        }
	    }
		return result;
	}
    
	
	
}
