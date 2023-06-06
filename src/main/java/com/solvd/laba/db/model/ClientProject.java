package main.java.com.solvd.laba.db.model;

public class ClientProject {
	private int clientProjectId;
	private Client client;
	private Project project;

	public ClientProject(int clientProjectId, Client client, Project project) {
		this.clientProjectId = clientProjectId;
		this.client = client;
		this.project = project;
	}

	public void setClientProjectId(int clientProjectId) {
		this.clientProjectId = clientProjectId;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public int getClientProjectId() {
		return clientProjectId;
	}

	public Client getClient() {
		return client;
	}

	public Project getProject() {
		return project;
	}

	@Override
	public String toString() {
		return "ClientProject{clientProjectId=" + clientProjectId + ", clientId=" + client.getClientId()
				+ ", projectId=" + project.getProjectId() + "}\n";
	}
}
