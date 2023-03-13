package sbjp.rest.sbjprestful.payload.request;

public class TodoSearchRequest {
	
	private int linkId;
	private int type;

	public TodoSearchRequest() {
		super();
	}

	public int getLinkId() {
		return linkId;
	}

	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TodoSearchRequest [linkId=" + linkId + ", type=" + type + "]";
	}

}
