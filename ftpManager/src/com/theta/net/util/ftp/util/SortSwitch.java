package com.theta.net.util.ftp.util;

public class SortSwitch {

	/**
	 * Description: ���������ת����list�ڲ��Ƚϵ�int����
	 * @author ����
	 * @param sort
	 * @return 1���� -1 ���� filed ���ֶ�����
	 */
	public static int imSwitch(String sort) {
		int result = 1;
		if ("asc".equals(sort.toLowerCase()) || "".equals(sort) || sort == null) {
			return result;
		}

		result = -1;
		return result;
	}
}
