package ch.rasc.eds.starter.bean;

import java.time.OffsetDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class FormBean {

	private String osName;

	private String osVersion;

	private Integer availableProcessors;

	private String remarks;

	@DateTimeFormat(pattern = "EEE MMM dd yyyy HH:mm:ss 'GMT'Z (zzzz)")
	private OffsetDateTime date;

	public String getOsName() {
		return this.osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public String getOsVersion() {
		return this.osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public Integer getAvailableProcessors() {
		return this.availableProcessors;
	}

	public void setAvailableProcessors(Integer availableProcessors) {
		this.availableProcessors = availableProcessors;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public OffsetDateTime getDate() {
		return this.date;
	}

	public void setDate(OffsetDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "FormBean [osName=" + this.osName + ", osVersion=" + this.osVersion
				+ ", availableProcessors=" + this.availableProcessors + ", remarks="
				+ this.remarks + ", date=" + this.date + "]";
	}

}
