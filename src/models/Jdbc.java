package models;

public class Jdbc {
	private String dms;
	private String ipAddress;
	private String port;
	private String databaseName;
	
	public Jdbc() {
	}

	public Jdbc(String dms, String ipAddress, String port, String databaseName) {
		this.dms = dms;
		this.ipAddress = ipAddress;
		this.port = port;
		this.databaseName = databaseName;
	}

	public String getDms() {
		return dms;
	}

	public void setDms(String dms) {
		this.dms = dms;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	@Override
	public String toString() {
		return "Jdbc [dms=" + dms + ", ipAddress=" + ipAddress + ", port=" + port + ", databaseName=" + databaseName
				+ "]";
	}
	
}
