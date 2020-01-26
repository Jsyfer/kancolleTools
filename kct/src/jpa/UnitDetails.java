package jpa;

public class UnitDetails {
	private int uId;
	private String uName;
	private int uStatus;
	private String typeName;
	private int tagId;
	private String tagName;
	private String tagColor;
	private String tagPic;
	
	
	public UnitDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UnitDetails(int uId, String uName, int uStatus, String typeName) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uStatus = uStatus;
		this.typeName = typeName;
	}


	public UnitDetails(int uId, String uName, int uStatus, String typeName, int tagId, String tagName,
			String tagColor, String tagPic) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uStatus = uStatus;
		this.typeName = typeName;
		this.tagId = tagId;
		this.tagName = tagName;
		this.tagColor = tagColor;
		this.tagPic = tagPic;
	}


	public int getuId() {
		return uId;
	}


	public void setuId(int uId) {
		this.uId = uId;
	}


	public String getuName() {
		return uName;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}


	public int getuStatus() {
		return uStatus;
	}


	public void setuStatus(int uStatus) {
		this.uStatus = uStatus;
	}


	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public int getTagId() {
		return tagId;
	}


	public void setTagId(int tagId) {
		this.tagId = tagId;
	}


	public String getTagName() {
		return tagName;
	}


	public void setTagName(String tagName) {
		this.tagName = tagName;
	}


	public String getTagColor() {
		return tagColor;
	}


	public void setTagColor(String tagColor) {
		this.tagColor = tagColor;
	}


	public String getTagPic() {
		return tagPic;
	}


	public void setTagPic(String tagPic) {
		this.tagPic = tagPic;
	}

	
}
