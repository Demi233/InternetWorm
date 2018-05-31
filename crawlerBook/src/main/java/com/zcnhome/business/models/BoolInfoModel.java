/**
 * BoolInfo.java 2018年3月28日
 * 
 * Copyright 2001-2018 织巢信息 All rights reserved. 
 * 织巢信息 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.zcnhome.business.models;

import com.zcnhome.common.models.BasicModel;

/**
 * <summary>
 * <description>
 * 
 * @author L.H.Z
 * @since 2018年3月28日
 * @see [Class/Method]
 *
 */
public class BoolInfoModel  extends BasicModel{

	private long id;
	private String num;
	private String title;
	private String image;
	private String author;
	private String press;
	private String pressDate;
	private String price;
	private String link;
	private String tag;
	private int status;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	
	/**
	 * @return the num
	 */
	public String getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(String num) {
		this.num = num;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the press
	 */
	public String getPress() {
		return press;
	}
	/**
	 * @param press the press to set
	 */
	public void setPress(String press) {
		this.press = press;
	}
	/**
	 * @return the pressDate
	 */
	public String getPressDate() {
		return pressDate;
	}
	/**
	 * @param pressDate the pressDate to set
	 */
	public void setPressDate(String pressDate) {
		this.pressDate = pressDate;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public String toString() {
		return "BoolInfo [id=" + id + ", num=" + num + ", status=" + status + ",title=" + title + ", image=" + image + ", author=" + author
				+ ", press=" + press + ", pressDate=" + pressDate + ", price=" + price + ", link=" + link + ", getId()="
				+ getId() + ", getNum()=" + getNum() + ", getStatus()="+ getStatus() + ",getTitle()=" + getTitle() + ", getImage()=" + getImage()
				+ ", getAuthor()=" + getAuthor() + ", getPress()=" + getPress() + ", getPressDate()=" + getPressDate()
				+ ", getPrice()=" + getPrice() + ", getLink()=" + getLink() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
}
