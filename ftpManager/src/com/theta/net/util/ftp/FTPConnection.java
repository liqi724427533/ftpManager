package com.theta.net.util.ftp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import com.theta.net.util.ftp.util.CompareUtil.ImComparator;

public class FTPConnection implements IFTPConnection{
	

	private FTPClient client = null;
	
	

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
	public boolean uploadFile(String path,String fileName,InputStream input) {
		boolean success = false;
		try {
			if (!"".equals(path) && path != null) {
				client.changeWorkingDirectory(path);
			}
			
			client.storeFile(fileName, input);
			input.close();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return success;
	}
	
	
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
	public boolean downloadFile(String remotePath,String fileName,String localPath) {
		boolean success = false; 
		try {
			if (!"".equals(remotePath) && remotePath != null) {
				client.changeWorkingDirectory(remotePath);
			}
			
			FTPFile[] fs = client.listFiles();
			for (FTPFile ff : fs) {
				if (ff.getName().equals(fileName)) {
					File localFile = new File(localPath + "/" + ff.getName());
					OutputStream is = new FileOutputStream(localFile);
					client.retrieveFile(ff.getName(), is);
					is.close();
					success = true;
				}
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return success;
	}

	/**
	 * Description: 从FTP服务器获取文件信息并排序
	 * @author 李琦
	 * @param path FTP服务器上的相对路径
	 * @param sort asc desc
	 * @param filed 排序字段
	 * @return List<FTPfile> 文件列表
	 */
	@SuppressWarnings("unchecked")
	public List<Filebean> readFileList(String path,String sort,String filed) {
		 List<Filebean> list = new ArrayList<Filebean>();
		 try {
				client.changeWorkingDirectory(path);
				
				FTPFile[] fs = client.listFiles();
				for (FTPFile ff : fs) {
					 if(ff.isFile()) { 
						 Filebean file = new Filebean();
						 file.setSize(ff.getSize());
						 file.setName(ff.getName());
						 file.setLastModified(ff.getTimestamp().getTime());
	                     list.add(file); 
	                 } 
				}
				
				Collections.sort(list, new ImComparator(sort, filed));
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return list;
	}
	

	public FTPConnection(FTPClient client) {
		super();
		try {
			client.setFileType(FTPClient.BINARY_FILE_TYPE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		client.setControlEncoding("GBK");
		this.client = client;
	}

	/**
	 * Description: 关闭FTP连接
	 * @author 李琦
	 * @exception IOException
	 */
	public void close() {
		if (client != null) {
			try {
				client.logout();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					client.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	
}
