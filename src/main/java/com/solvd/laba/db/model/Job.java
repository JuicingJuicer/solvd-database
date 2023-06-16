package main.java.com.solvd.laba.db.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "job")
@XmlAccessorType(XmlAccessType.FIELD)
public class Job {
	@XmlElement(name = "jobId")
	@JsonProperty("jobId")
	private int jobId;
	@XmlElement(name = "jobTitle")
	@JsonProperty("jobTitle")
	private String jobTitle;

	public Job() {
	}

	public Job(int jobId, String jobTitle) {
		this.setJobId(jobId);
		this.setJobTitle(jobTitle);
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getJobId() {
		return jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	@Override
	public String toString() {
		return "Job{jobId=" + jobId + ", jobTitle=" + jobTitle + "}";
	}
}
