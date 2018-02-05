package rpa.models;

import java.util.Date;

import com.sun.istack.internal.Nullable;

public class Permissions {
	private int userId;
	private int[]  pageIds;
	private int createdBy ;
	private Date  DateCreated ;
	private byte isDeleted;
	@Nullable
	private int  UpdatedBy;
	@Nullable
	private Date DateUpdated;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int[] getPageIds() {
		return pageIds;
	}
	public void setPageIds(int[] pageIds) {
		this.pageIds = pageIds;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getDateCreated() {
		return DateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		DateCreated = dateCreated;
	}
	public int getUpdatedBy() {
		return UpdatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		UpdatedBy = updatedBy;
	}
	public Date getDateUpdated() {
		return DateUpdated;
	}
	public void setDateUpdated(Date dateUpdated) {
		DateUpdated = dateUpdated;
	}
        public byte getIsDeleted()
        {
                return isDeleted;
        }
        public void setIsDeleted(byte isDeleted)
        {
                this.isDeleted = isDeleted;
        }
	
}
