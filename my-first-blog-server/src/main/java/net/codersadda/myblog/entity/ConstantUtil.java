package net.codersadda.myblog.entity;

public enum ConstantUtil {
	DBSUCCESS("Database is updated with entities of length"),
	DBERROR("Update was not successful on the database");
	
	private String response;
	
	ConstantUtil(String response){
		this.response = response;
	}
	
	public String response() {
		return response;
	}

}
