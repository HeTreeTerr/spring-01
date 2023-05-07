package com.hss.domain;

/**
 * 数据源
 */
public class DateSource {

	private String driveName;

	private String ipPort;

	private String dbName;

	public DateSource() {
	}

	public DateSource(String driveName, String ipPort, String dbName) {
		this.driveName = driveName;
		this.ipPort = ipPort;
		this.dbName = dbName;
	}

	public String getDriveName() {
		return driveName;
	}

	public void setDriveName(String driveName) {
		this.driveName = driveName;
	}

	public String getIpPort() {
		return ipPort;
	}

	public void setIpPort(String ipPort) {
		this.ipPort = ipPort;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	@Override
	public String toString() {
		return "DateSource{" +
				"driveName='" + driveName + '\'' +
				", ipPort='" + ipPort + '\'' +
				", dbName='" + dbName + '\'' +
				'}';
	}
}
