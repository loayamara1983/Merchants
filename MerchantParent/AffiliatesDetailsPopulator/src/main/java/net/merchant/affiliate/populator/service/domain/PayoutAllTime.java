package net.merchant.affiliate.populator.service.domain;

public class PayoutAllTime {

	private Long paid;
	private Long unpaidApprovedComm;
	private Long unpaidPendingComm;
	private Long unpaidDeclinedComm;
	
	/**
	 * @param paid
	 * @param unpaidApprovedComm
	 * @param unpaidPendingComm
	 * @param unpaidDeclinedComm
	 */
	public PayoutAllTime(Long paid, Long unpaidApprovedComm, Long unpaidPendingComm, Long unpaidDeclinedComm) {
		super();
		this.paid = paid;
		this.unpaidApprovedComm = unpaidApprovedComm;
		this.unpaidPendingComm = unpaidPendingComm;
		this.unpaidDeclinedComm = unpaidDeclinedComm;
	}
	/**
	 * @return the paid
	 */
	public Long getPaid() {
		return paid;
	}
	/**
	 * @param paid the paid to set
	 */
	public void setPaid(Long paid) {
		this.paid = paid;
	}
	/**
	 * @return the unpaidApprovedComm
	 */
	public Long getUnpaidApprovedComm() {
		return unpaidApprovedComm;
	}
	/**
	 * @param unpaidApprovedComm the unpaidApprovedComm to set
	 */
	public void setUnpaidApprovedComm(Long unpaidApprovedComm) {
		this.unpaidApprovedComm = unpaidApprovedComm;
	}
	/**
	 * @return the unpaidPendingComm
	 */
	public Long getUnpaidPendingComm() {
		return unpaidPendingComm;
	}
	/**
	 * @param unpaidPendingComm the unpaidPendingComm to set
	 */
	public void setUnpaidPendingComm(Long unpaidPendingComm) {
		this.unpaidPendingComm = unpaidPendingComm;
	}
	/**
	 * @return the unpaidDeclinedComm
	 */
	public Long getUnpaidDeclinedComm() {
		return unpaidDeclinedComm;
	}
	/**
	 * @param unpaidDeclinedComm the unpaidDeclinedComm to set
	 */
	public void setUnpaidDeclinedComm(Long unpaidDeclinedComm) {
		this.unpaidDeclinedComm = unpaidDeclinedComm;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paid == null) ? 0 : paid.hashCode());
		result = prime * result + ((unpaidApprovedComm == null) ? 0 : unpaidApprovedComm.hashCode());
		result = prime * result + ((unpaidDeclinedComm == null) ? 0 : unpaidDeclinedComm.hashCode());
		result = prime * result + ((unpaidPendingComm == null) ? 0 : unpaidPendingComm.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PayoutAllTime other = (PayoutAllTime) obj;
		if (paid == null) {
			if (other.paid != null)
				return false;
		} else if (!paid.equals(other.paid))
			return false;
		if (unpaidApprovedComm == null) {
			if (other.unpaidApprovedComm != null)
				return false;
		} else if (!unpaidApprovedComm.equals(other.unpaidApprovedComm))
			return false;
		if (unpaidDeclinedComm == null) {
			if (other.unpaidDeclinedComm != null)
				return false;
		} else if (!unpaidDeclinedComm.equals(other.unpaidDeclinedComm))
			return false;
		if (unpaidPendingComm == null) {
			if (other.unpaidPendingComm != null)
				return false;
		} else if (!unpaidPendingComm.equals(other.unpaidPendingComm))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PayoutAllTime [paid=" + paid + ", unpaidApprovedComm=" + unpaidApprovedComm + ", unpaidPendingComm="
				+ unpaidPendingComm + ", unpaidDeclinedComm=" + unpaidDeclinedComm + "]";
	}
	
	
}
