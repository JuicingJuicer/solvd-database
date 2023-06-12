package main.java.com.solvd.laba.db.model;

public class Job {
	private int jobId;
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
