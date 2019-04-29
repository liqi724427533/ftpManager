package com.theta.net.util.ftp;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface IFTPConnection {

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
	public boolean uploadFile(String path,String fileName,InputStream input);
	
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
	public boolean downloadFile(String remotePath,String fileName,String localPath);
	
	/**
	 * Description: ��FTP��������ȡ�ļ���Ϣ������
	 * @author ����
	 * @param path FTP�������ϵ����·��
	 * @param sort asc desc
	 * @param filed �����ֶ�
	 * @return List<FTPfile> �ļ��б�
	 */
	public List<Filebean> readFileList(String path,String sort,String filed);
	
	/**
	 * Description: �ر�FTP����
	 * @author ����
	 * @exception IOException
	 */
	public void close();
}
