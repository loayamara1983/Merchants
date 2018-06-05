package net.merchant.affiliate.populator.service.domain;

public class AffiliatesAllTimeComisions {

	private Long countAffiliates;
	private Long approvedAffiliates;
	private Long pendingAffiliates;
	private Long totalSales;
	private Long approvedCommissions;
	private Long pendingCommissions;
	/**
	 * @param countAffiliates
	 * @param approvedAffiliates
	 * @param pendingAffiliates
	 * @param totalSales
	 * @param approvedCommissions
	 * @param pendingCommissions
	 */
	public AffiliatesAllTimeComisions(Long countAffiliates, Long approvedAffiliates, Long pendingAffiliates,
			Long totalSales, Long approvedCommissions, Long pendingCommissions) {
		super();
		this.countAffiliates = countAffiliates;
		this.approvedAffiliates = approvedAffiliates;
		this.pendingAffiliates = pendingAffiliates;
		this.totalSales = totalSales;
		this.approvedCommissions = approvedCommissions;
		this.pendingCommissions = pendingCommissions;
	}
	/**
	 * @return the countAffiliates
	 */
	public Long getCountAffiliates() {
		return countAffiliates;
	}
	/**
	 * @param countAffiliates the countAffiliates to set
	 */
	public void setCountAffiliates(Long countAffiliates) {
		this.countAffiliates = countAffiliates;
	}
	/**
	 * @return the approvedAffiliates
	 */
	public Long getApprovedAffiliates() {
		return approvedAffiliates;
	}
	/**
	 * @param approvedAffiliates the approvedAffiliates to set
	 */
	public void setApprovedAffiliates(Long approvedAffiliates) {
		this.approvedAffiliates = approvedAffiliates;
	}
	/**
	 * @return the pendingAffiliates
	 */
	public Long getPendingAffiliates() {
		return pendingAffiliates;
	}
	/**
	 * @param pendingAffiliates the pendingAffiliates to set
	 */
	public void setPendingAffiliates(Long pendingAffiliates) {
		this.pendingAffiliates = pendingAffiliates;
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
	 * @return the approvedCommissions
	 */
	public Long getApprovedCommissions() {
		return approvedCommissions;
	}
	/**
	 * @param approvedCommissions the approvedCommissions to set
	 */
	public void setApprovedCommissions(Long approvedCommissions) {
		this.approvedCommissions = approvedCommissions;
	}
	/**
	 * @return the pendingCommissions
	 */
	public Long getPendingCommissions() {
		return pendingCommissions;
	}
	/**
	 * @param pendingCommissions the pendingCommissions to set
	 */
	public void setPendingCommissions(Long pendingCommissions) {
		this.pendingCommissions = pendingCommissions;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approvedAffiliates == null) ? 0 : approvedAffiliates.hashCode());
		result = prime * result + ((approvedCommissions == null) ? 0 : approvedCommissions.hashCode());
		result = prime * result + ((countAffiliates == null) ? 0 : countAffiliates.hashCode());
		result = prime * result + ((pendingAffiliates == null) ? 0 : pendingAffiliates.hashCode());
		result = prime * result + ((pendingCommissions == null) ? 0 : pendingCommissions.hashCode());
		result = prime * result + ((totalSales == null) ? 0 : totalSales.hashCode());
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
		AffiliatesAllTimeComisions other = (AffiliatesAllTimeComisions) obj;
		if (approvedAffiliates == null) {
			if (other.approvedAffiliates != null)
				return false;
		} else if (!approvedAffiliates.equals(other.approvedAffiliates))
			return false;
		if (approvedCommissions == null) {
			if (other.approvedCommissions != null)
				return false;
		} else if (!approvedCommissions.equals(other.approvedCommissions))
			return false;
		if (countAffiliates == null) {
			if (other.countAffiliates != null)
				return false;
		} else if (!countAffiliates.equals(other.countAffiliates))
			return false;
		if (pendingAffiliates == null) {
			if (other.pendingAffiliates != null)
				return false;
		} else if (!pendingAffiliates.equals(other.pendingAffiliates))
			return false;
		if (pendingCommissions == null) {
			if (other.pendingCommissions != null)
				return false;
		} else if (!pendingCommissions.equals(other.pendingCommissions))
			return false;
		if (totalSales == null) {
			if (other.totalSales != null)
				return false;
		} else if (!totalSales.equals(other.totalSales))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AffiliatesAllTimeComisions [countAffiliates=" + countAffiliates + ", approvedAffiliates="
				+ approvedAffiliates + ", pendingAffiliates=" + pendingAffiliates + ", totalSales=" + totalSales
				+ ", approvedCommissions=" + approvedCommissions + ", pendingCommissions=" + pendingCommissions + "]";
	}
	
	
}
