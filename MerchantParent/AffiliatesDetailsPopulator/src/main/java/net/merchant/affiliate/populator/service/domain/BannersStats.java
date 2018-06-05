package net.merchant.affiliate.populator.service.domain;

public class BannersStats {

	private BannersAllTime allTimeComisions;
	
	private BannersThisMonth thisMonthComisions;

	/**
	 * @param allTimeComisions
	 * @param thisMonthComisions
	 */
	public BannersStats(BannersAllTime allTimeComisions, BannersThisMonth thisMonthComisions) {
		super();
		this.allTimeComisions = allTimeComisions;
		this.thisMonthComisions = thisMonthComisions;
	}

	/**
	 * @return the allTimeComisions
	 */
	public BannersAllTime getAllTimeComisions() {
		return allTimeComisions;
	}

	/**
	 * @param allTimeComisions the allTimeComisions to set
	 */
	public void setAllTimeComisions(BannersAllTime allTimeComisions) {
		this.allTimeComisions = allTimeComisions;
	}

	/**
	 * @return the thisMonthComisions
	 */
	public BannersThisMonth getThisMonthComisions() {
		return thisMonthComisions;
	}

	/**
	 * @param thisMonthComisions the thisMonthComisions to set
	 */
	public void setThisMonthComisions(BannersThisMonth thisMonthComisions) {
		this.thisMonthComisions = thisMonthComisions;
	}

	
	
}
