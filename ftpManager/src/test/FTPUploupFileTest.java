package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import com.theta.net.util.ftp.FtpManager;
import com.theta.net.util.ftp.IFTPConnection;

public class FTPUploupFileTest {

	public static void main(String[] args) throws SocketException, IOException {
		IFTPConnection manager = FtpManager.getConnection("192.168.2.45", 21, "root", "theta123");
		InputStream input1 = new FileInputStream(new File("F:/FTPfile/18734817252.txt"));
		InputStream input2 = new FileInputStream(new File("F:/FTPfile/18910412551.txt"));
		InputStream input3 = new FileInputStream(new File("F:/FTPfile/Hadoop64.pdf"));
		InputStream input4 = new FileInputStream(new File("F:/FTPfile/JavaPractice.pdf"));
		InputStream input5 = new FileInputStream(new File("F:/FTPfile/Meeting.txt"));
		InputStream input6 = new FileInputStream(new File("F:/FTPfile/newfile.txt"));
		InputStream input7 = new FileInputStream(new File("F:/FTPfile/test.txt"));
		InputStream input8 = new FileInputStream(new File("F:/FTPfile/Theta_JAVAProgramming_specification.pdf"));
		manager.uploadFile(null, "18734817252.txt", input1);
		manager.uploadFile(null, "18910412551.txt", input2);
		manager.uploadFile(null, "Hadoop64.pdf", input3);
		manager.uploadFile(null, "JavaPractice.pdf", input4);
		manager.uploadFile(null, "Meeting.txt", input5);
		manager.uploadFile(null, "newfile.txt", input6);
		manager.uploadFile(null, "test.txt", input7);
		manager.uploadFile(null, "Theta_JAVAProgramming_specification.pdf", input8);
		System.out.println(manager.readFileList(null, "asc", "size"));
		manager.close();
	}
}
