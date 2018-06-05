package net.merchant.affiliate.populator.service.domain;

public class AffiliatesComisionsStats {

	private AffiliatesAllTimeComisions allTimeComisions;
	
	private AffiliatesThisMonthComisions thisMonthComisions;
	
	public AffiliatesComisionsStats(AffiliatesAllTimeComisions allTimeComisions, AffiliatesThisMonthComisions thisMonthComisions) {
		super();
		this.allTimeComisions = allTimeComisions;
		this.thisMonthComisions = thisMonthComisions;
	}

	/**
	 * @return the allTimeComisions
	 */
	public AffiliatesAllTimeComisions getAllTimeComisions() {
		return allTimeComisions;
	}

	/**
	 * @param allTimeComisions the allTimeComisions to set
	 */
	public void setAllTimeComisions(AffiliatesAllTimeComisions allTimeComisions) {
		this.allTimeComisions = allTimeComisions;
	}

	/**
	 * @return the thisMonthComisions
	 */
	public AffiliatesThisMonthComisions getThisMonthComisions() {
		return thisMonthComisions;
	}

	/**
	 * @param thisMonthComisions the thisMonthComisions to set
	 */
	public void setThisMonthComisions(AffiliatesThisMonthComisions thisMonthComisions) {
		this.thisMonthComisions = thisMonthComisions;
	}
	
	
}
