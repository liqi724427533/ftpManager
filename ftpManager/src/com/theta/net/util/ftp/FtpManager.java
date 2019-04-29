package com.theta.net.util.ftp;

import java.io.IOException;
import java.net.SocketException;
import java.util.Properties;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;


public class FtpManager  {
	

	/**
	 * Description: 链接FTP服务器
	 * @author 李琦
	 * @param url FTP服务器hostname
	 * @param port FTP服务器端口
	 * @param userName FTP登录账号
	 * @param passWord FTP登录密码
	 * @return Manager
	 * @throws SocketException
	 * @throws IOException
	 */
	public static IFTPConnection getConnection(String url, int port,String userName, String passWord) throws SocketException, IOException {

		FTPClient ftpClient = new FTPClient();
		int reply;
		ftpClient.connect(url, port);
		ftpClient.login(userName, passWord);
		reply = ftpClient.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftpClient.disconnect();
			return null;
		}
		
		return new FTPConnection(ftpClient);
	}
	
	
	/**
	 * Description: 连接FTP服务器
	 * @author 李琦
	 * @param properties FTP登陆的账号、密码及端口号
	 * @return Manager
	 * @throws SocketException
	 * @throws IOException
	 */
	 public static IFTPConnection getConnection(Properties properties) throws SocketException, IOException {
		int port = 21;
		String url = properties.getProperty("url");
		String str = properties.getProperty("port");
		if (!"".equals(str) && str != null) {
			port = Integer.parseInt(str);
		}
		
		String userName = properties.getProperty("userName");
		String passWord = properties.getProperty("passWord");
		
		return getConnection(url, port, userName, passWord);
	}
	
	
	
}
