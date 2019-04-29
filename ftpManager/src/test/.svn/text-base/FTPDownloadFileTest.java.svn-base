package test;

import java.io.IOException;
import java.net.SocketException;

import com.theta.net.util.ftp.FtpManager;
import com.theta.net.util.ftp.IFTPConnection;

public class FTPDownloadFileTest {

	public static void main(String[] args) throws SocketException, IOException {
		IFTPConnection manager = FtpManager.getConnection("192.168.2.45", 21, "root", "theta123");
		manager.downloadFile(null, "18734817252.txt", "f:/FTPTest");
		manager.downloadFile(null, "18910412551.txt", "f:/FTPTest");
		manager.downloadFile(null, "Hadoop64.pdf", "f:/FTPTest");
		manager.downloadFile(null, "JavaPractice.pdf", "f:/FTPTest");
		manager.downloadFile(null, "Meeting.txt", "f:/FTPTest");
		manager.downloadFile(null, "newfile.txt", "f:/FTPTest");
		manager.downloadFile(null, "test.txt", "f:/FTPTest");
		manager.downloadFile(null, "Theta_JAVAProgramming_specification.pdf", "f:/FTPTest");
		manager.close();
	}
}
