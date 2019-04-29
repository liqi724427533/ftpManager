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
	 * Description: ��FTP�������ϴ��ļ� 
	 * @author ����
	 * @param path FTP�������ϵ����·��
	 * @param fileName �ϴ���FTP�������ϵ��ļ���
	 * @param input ������
	 * @return �ɹ�����true�����򷵻�false 
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
	 * Description: ��FTP�����������ļ�
	 * @author ����
	 * @param remotePath FTP�������ϵ����·��
	 * @param fileName Ҫ���ص��ļ���
	 * @param localPath ���غ󱣴浽���ص�·��
	 * @return �ɹ�����true�����򷵻�false
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
	 * Description: ��FTP��������ȡ�ļ���Ϣ������
	 * @author ����
	 * @param path FTP�������ϵ����·��
	 * @param sort asc desc
	 * @param filed �����ֶ�
	 * @return List<FTPfile> �ļ��б�
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
	 * Description: �ر�FTP����
	 * @author ����
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
