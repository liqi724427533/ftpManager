package test;

import java.io.IOException;
import java.net.SocketException;
import java.util.List;

import com.theta.net.util.ftp.Filebean;
import com.theta.net.util.ftp.FtpManager;
import com.theta.net.util.ftp.IFTPConnection;

public class FTPReadFileList {

	public static void main(String[] args) throws SocketException, IOException {
		IFTPConnection manager = FtpManager.getConnection("192.168.2.45", 21, "root", "theta123");
		List<Filebean> list = manager.readFileList(null, "asc", "size");
		System.out.println(list);
	}
}
