package com.stackroute.activitystream.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * The class "Message" will be acting as the data model for the message Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 */
@Entity
public class Message {

	/*
	 * This class should have eight fields
	 * (messageId,senderName,receiverId,circleName,postedDate,streamType,message
	 * ,tag). Out of these four fields, the field messageId should be
	 * auto-generated. This class should also contain the getters and setters
	 * for the fields. The value of postedDate should not be accepted from the
	 * user but should be always initialized with the system date
	 */
	@Id
	@GeneratedValue
	private int messageId;
	private String message;
	private String senderName;
	private int receiverId;
	private String circleName;
	private Date postedDate;
	private String streamType;
	private String tag;

	public Message(int messageId, String message, String senderName, int receiverId, String circleName, Date postedDate,
			String streamType, String tag) {
		this.messageId = messageId;
		this.message = message;
		this.senderName = senderName;
		this.receiverId = receiverId;
		this.circleName = circleName;
		this.postedDate = postedDate;
		this.streamType = streamType;
		this.tag = tag;
	}

	public void setMessage(String string) {
		this.message = string;
	}

	public void setStreamType(String string) {
		this.streamType = string;
	}

	public void setSenderName(String string) {
		senderName = string;
	}

	public void setTag(String string) {
		this.tag = string;
	}
	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		postedDate=new java.util.Date();
	}

	public String getMessage() {
		return message;
	}

	public String getSenderName() {
		return senderName;
	}

	public String getStreamType() {
		return streamType;
	}

	public String getTag() {
		return tag;
	}
}