package net.merchant.affiliate.populator.service.domain;

public class BannersThisMonth {

	private Long impressions;
	private Long repeatedClicks;
	private Long uniqueClicks;
	private Long sales;
	private Long ctr;
	private Long actions;
	/**
	 * @param impressions
	 * @param repeatedClicks
	 * @param uniqueClicks
	 * @param sales
	 * @param ctr
	 * @param actions
	 */
	public BannersThisMonth(Long impressions, Long repeatedClicks, Long uniqueClicks, Long sales, Long ctr,
			Long actions) {
		super();
		this.impressions = impressions;
		this.repeatedClicks = repeatedClicks;
		this.uniqueClicks = uniqueClicks;
		this.sales = sales;
		this.ctr = ctr;
		this.actions = actions;
	}
	
	
	
	/**
	 * @return the impressions
	 */
	public Long getImpressions() {
		return impressions;
	}



	/**
	 * @param impressions the impressions to set
	 */
	public void setImpressions(Long impressions) {
		this.impressions = impressions;
	}



	/**
	 * @return the repeatedClicks
	 */
	public Long getRepeatedClicks() {
		return repeatedClicks;
	}



	/**
	 * @param repeatedClicks the repeatedClicks to set
	 */
	public void setRepeatedClicks(Long repeatedClicks) {
		this.repeatedClicks = repeatedClicks;
	}



	/**
	 * @return the uniqueClicks
	 */
	public Long getUniqueClicks() {
		return uniqueClicks;
	}



	/**
	 * @param uniqueClicks the uniqueClicks to set
	 */
	public void setUniqueClicks(Long uniqueClicks) {
		this.uniqueClicks = uniqueClicks;
	}



	/**
	 * @return the sales
	 */
	public Long getSales() {
		return sales;
	}



	/**
	 * @param sales the sales to set
	 */
	public void setSales(Long sales) {
		this.sales = sales;
	}



	/**
	 * @return the ctr
	 */
	public Long getCtr() {
		return ctr;
	}



	/**
	 * @param ctr the ctr to set
	 */
	public void setCtr(Long ctr) {
		this.ctr = ctr;
	}



	/**
	 * @return the actions
	 */
	public Long getActions() {
		return actions;
	}



	/**
	 * @param actions the actions to set
	 */
	public void setActions(Long actions) {
		this.actions = actions;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actions == null) ? 0 : actions.hashCode());
		result = prime * result + ((ctr == null) ? 0 : ctr.hashCode());
		result = prime * result + ((impressions == null) ? 0 : impressions.hashCode());
		result = prime * result + ((repeatedClicks == null) ? 0 : repeatedClicks.hashCode());
		result = prime * result + ((sales == null) ? 0 : sales.hashCode());
		result = prime * result + ((uniqueClicks == null) ? 0 : uniqueClicks.hashCode());
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
		BannersThisMonth other = (BannersThisMonth) obj;
		if (actions == null) {
			if (other.actions != null)
				return false;
		} else if (!actions.equals(other.actions))
			return false;
		if (ctr == null) {
			if (other.ctr != null)
				return false;
		} else if (!ctr.equals(other.ctr))
			return false;
		if (impressions == null) {
			if (other.impressions != null)
				return false;
		} else if (!impressions.equals(other.impressions))
			return false;
		if (repeatedClicks == null) {
			if (other.repeatedClicks != null)
				return false;
		} else if (!repeatedClicks.equals(other.repeatedClicks))
			return false;
		if (sales == null) {
			if (other.sales != null)
				return false;
		} else if (!sales.equals(other.sales))
			return false;
		if (uniqueClicks == null) {
			if (other.uniqueClicks != null)
				return false;
		} else if (!uniqueClicks.equals(other.uniqueClicks))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BannersThisMonthComisions [impressions=" + impressions + ", repeatedClicks=" + repeatedClicks
				+ ", uniqueClicks=" + uniqueClicks + ", sales=" + sales + ", ctr=" + ctr + ", actions=" + actions + "]";
	}
	
	
}
