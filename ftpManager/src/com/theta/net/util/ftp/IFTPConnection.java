package com.theta.net.util.ftp;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface IFTPConnection {

	/**
	 * Description: 向FTP服务器上传文件 
	 * @author 李琦
	 * @param path FTP服务器上的相对路径
	 * @param fileName 上传到FTP服务器上的文件名
	 * @param input 输入流
	 * @return 成功返回true，否则返回false 
	 * @throws
	 * @exception IOException
	 */
	public boolean uploadFile(String path,String fileName,InputStream input);
	
	/**
	 * Description: 从FTP服务器下载文件
	 * @author 李琦
	 * @param remotePath FTP服务器上的相对路径
	 * @param fileName 要下载的文件名
	 * @param localPath 下载后保存到本地的路径
	 * @return 成功返回true，否则返回false
	 * @throws
	 * @exception IOException
	 */
	public boolean downloadFile(String remotePath,String fileName,String localPath);
	
	/**
	 * Description: 从FTP服务器获取文件信息并排序
	 * @author 李琦
	 * @param path FTP服务器上的相对路径
	 * @param sort asc desc
	 * @param filed 排序字段
	 * @return List<FTPfile> 文件列表
	 */
	public List<Filebean> readFileList(String path,String sort,String filed);
	
	/**
	 * Description: 关闭FTP连接
	 * @author 李琦
	 * @exception IOException
	 */
	public void close();
}
