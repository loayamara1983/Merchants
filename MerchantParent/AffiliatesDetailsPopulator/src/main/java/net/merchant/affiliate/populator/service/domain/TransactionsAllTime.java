package net.merchant.affiliate.populator.service.domain;

public class TransactionsAllTime {

	private Long totalCommisions;
	private Long totalSales;
	private Long totalPendingCommisions;
	private Long totalUnpaidApprovedComm;
	private Long countPendingCommissions;
	private Long countUnpaidApprovedComm;
	/**
	 * @param totalCommisions
	 * @param totalSales
	 * @param totalPendingCommisions
	 * @param totalUnpaidApprovedComm
	 * @param countPendingCommissions
	 * @param countUnpaidApprovedComm
	 */
	public TransactionsAllTime(Long totalCommisions, Long totalSales, Long totalPendingCommisions,
			Long totalUnpaidApprovedComm, Long countPendingCommissions, Long countUnpaidApprovedComm) {
		super();
		this.totalCommisions = totalCommisions;
		this.totalSales = totalSales;
		this.totalPendingCommisions = totalPendingCommisions;
		this.totalUnpaidApprovedComm = totalUnpaidApprovedComm;
		this.countPendingCommissions = countPendingCommissions;
		this.countUnpaidApprovedComm = countUnpaidApprovedComm;
	}
	/**
	 * @return the totalCommisions
	 */
	public Long getTotalCommisions() {
		return totalCommisions;
	}
	/**
	 * @param totalCommisions the totalCommisions to set
	 */
	public void setTotalCommisions(Long totalCommisions) {
		this.totalCommisions = totalCommisions;
	}
	/**
	 * @return the totalSales
	 */
	public Long getTotalSales() {
		return totalSales;
	}
	/**
	 * @param totalSales the totalSales to set
	 */
	public void setTotalSales(Long totalSales) {
		this.totalSales = totalSales;
	}
	/**
	 * @return the totalPendingCommisions
	 */
	public Long getTotalPendingCommisions() {
		return totalPendingCommisions;
	}
	/**
	 * @param totalPendingCommisions the totalPendingCommisions to set
	 */
	public void setTotalPendingCommisions(Long totalPendingCommisions) {
		this.totalPendingCommisions = totalPendingCommisions;
	}
	/**
	 * @return the totalUnpaidApprovedComm
	 */
	public Long getTotalUnpaidApprovedComm() {
		return totalUnpaidApprovedComm;
	}
	/**
	 * @param totalUnpaidApprovedComm the totalUnpaidApprovedComm to set
	 */
	public void setTotalUnpaidApprovedComm(Long totalUnpaidApprovedComm) {
		this.totalUnpaidApprovedComm = totalUnpaidApprovedComm;
	}
	/**
	 * @return the countPendingCommissions
	 */
	public Long getCountPendingCommissions() {
		return countPendingCommissions;
	}
	/**
	 * @param countPendingCommissions the countPendingCommissions to set
	 */
	public void setCountPendingCommissions(Long countPendingCommissions) {
		this.countPendingCommissions = countPendingCommissions;
	}
	/**
	 * @return the countUnpaidApprovedComm
	 */
	public Long getCountUnpaidApprovedComm() {
		return countUnpaidApprovedComm;
	}
	/**
	 * @param countUnpaidApprovedComm the countUnpaidApprovedComm to set
	 */
	public void setCountUnpaidApprovedComm(Long countUnpaidApprovedComm) {
		this.countUnpaidApprovedComm = countUnpaidApprovedComm;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countPendingCommissions == null) ? 0 : countPendingCommissions.hashCode());
		result = prime * result + ((countUnpaidApprovedComm == null) ? 0 : countUnpaidApprovedComm.hashCode());
		result = prime * result + ((totalCommisions == null) ? 0 : totalCommisions.hashCode());
		result = prime * result + ((totalPendingCommisions == null) ? 0 : totalPendingCommisions.hashCode());
		result = prime * result + ((totalSales == null) ? 0 : totalSales.hashCode());
		result = prime * result + ((totalUnpaidApprovedComm == null) ? 0 : totalUnpaidApprovedComm.hashCode());
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
		TransactionsAllTime other = (TransactionsAllTime) obj;
		if (countPendingCommissions == null) {
			if (other.countPendingCommissions != null)
				return false;
		} else if (!countPendingCommissions.equals(other.countPendingCommissions))
			return false;
		if (countUnpaidApprovedComm == null) {
			if (other.countUnpaidApprovedComm != null)
				return false;
		} else if (!countUnpaidApprovedComm.equals(other.countUnpaidApprovedComm))
			return false;
		if (totalCommisions == null) {
			if (other.totalCommisions != null)
				return false;
		} else if (!totalCommisions.equals(other.totalCommisions))
			return false;
		if (totalPendingCommisions == null) {
			if (other.totalPendingCommisions != null)
				return false;
		} else if (!totalPendingCommisions.equals(other.totalPendingCommisions))
			return false;
		if (totalSales == null) {
			if (other.totalSales != null)
				return false;
		} else if (!totalSales.equals(other.totalSales))
			return false;
		if (totalUnpaidApprovedComm == null) {
			if (other.totalUnpaidApprovedComm != null)
				return false;
		} else if (!totalUnpaidApprovedComm.equals(other.totalUnpaidApprovedComm))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TransactionsAllTime [totalCommisions=" + totalCommisions + ", totalSales=" + totalSales
				+ ", totalPendingCommisions=" + totalPendingCommisions + ", totalUnpaidApprovedComm="
				+ totalUnpaidApprovedComm + ", countPendingCommissions=" + countPendingCommissions
				+ ", countUnpaidApprovedComm=" + countUnpaidApprovedComm + "]";
	}
	
	
}
