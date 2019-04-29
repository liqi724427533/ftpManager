package com.theta.net.util.ftp;

import java.util.Date;

public class Filebean implements Comparable<Filebean> {

	private String name; // 文件名
	private long size; // 文件大小
	private Date lastModified; // 最后修改时间

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "FTPfile [name=" + name + ", size=" + size + ", lastModified="
				+ lastModified + "]";
	}

	@Override
	public int compareTo(Filebean ftPfile) {

		return this.lastModified.compareTo(ftPfile.getLastModified());
	}

}
