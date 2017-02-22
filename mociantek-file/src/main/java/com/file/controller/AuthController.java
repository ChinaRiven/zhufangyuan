package com.file.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.file.util.Result;
import com.file.util.Strategy;
import com.qiniu.util.StringMap;


/**
 * 凭证 包括上传凭证,下载凭证,管理凭证
 * @author user
 *
 */
@RestController
@RequestMapping("/token")
public class AuthController {
  
	/**
     * scope = bucket:key
     * 同名文件覆盖操作、只能上传指定key的文件可以可通过此方法获取token
     * @param bucket 空间名
     * @param key    key,可为 null
     * @return 生成的上传token
     */
	@RequestMapping("/user/get")
	public String getCoverKeyToken(String key){
		String uploadToken = Strategy.getAuth().uploadToken(Strategy.scope,key);
		if(!StringUtils.isEmpty(uploadToken)){
			return Result.success("获取上传凭证成功",uploadToken);
		}else{
			return Result.fail("获取上传凭证失败");
		}
	}
	
	/**
	 * 生成上传token
	 * 指定用户的上传,获取token  比如上传用户的头像,签证等信息
	 * @param bucket  空间名
	 * @param key     key，可为 null  文件名称
	 * @param expires 有效时长，单位秒
	 * @param policy  上传策略的其它参数，如 new StringMap().put("endUser", "uid").putNotEmpty("returnBody", "")。
	 *                scope通过 bucket、key间接设置，deadline 通过 expires 间接设置
	 * @return 生成的上传token
	 */
	@RequestMapping("/user/get")
	public String getUserToken(StringMap policy){
		String uploadToken = Strategy.getAuth().uploadToken(Strategy.scope, null, 3600, policy);
		if(!StringUtils.isEmpty(uploadToken)){
			return Result.success("获取上传凭证成功",uploadToken);
		}else{
			return Result.fail("获取上传凭证失败");
		}
	}
	
	/**
	 * 下载签名凭证
	 * @param baseUrl 下载地址
	 * @return
	 */
	@RequestMapping("/download")
	public String downloadToken(String baseUrl){
		String uploadToken = Strategy.getAuth().privateDownloadUrl(baseUrl);
		if(!StringUtils.isEmpty(uploadToken)){
			return Result.success("获取下载凭证成功",uploadToken);
		}else{
			return Result.fail("获取下载凭证失败");
		}
	}
	
	/**
	 * 管理签名凭证
	 */
	@RequestMapping("/manager")
	public String managerToken(String baseUrl){
		StringMap map = Strategy.getAuth().authorization(baseUrl);
		return Result.success("获取管理凭证成功",map);
	}
	
}
