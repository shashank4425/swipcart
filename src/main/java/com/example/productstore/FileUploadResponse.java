package com.example.productstore;

public class FileUploadResponse {

	String fileName;
	String ContentType;
	String Url;
	
	public FileUploadResponse(String fileName, String contentType, String url) {
		super();
		this.fileName = fileName;
		ContentType = contentType;
		Url = url;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContentType() {
		return ContentType;
	}
	public void setContentType(String contentType) {
		ContentType = contentType;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	@Override
	public String toString() {
		return "FileUploadResponse [fileName=" + fileName + ", ContentType=" + ContentType + ", Url=" + Url + "]";
	}
	
	
}
