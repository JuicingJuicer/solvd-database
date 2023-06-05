package main.java.com.solvd.laba.db.model;

public class Job {
	private long jobId;
	private String jobTitle;

	public Job() {
	};

	public Job(long jobId, String jobTitle) {
		this.setJobId(jobId);
		this.setJobTitle(jobTitle);
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public long getJobId() {
		return jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	@Override
	public String toString() {
		return "Job{jobId=" + jobId + ", jobTitle=" + jobTitle + "}\n";
	}
}
