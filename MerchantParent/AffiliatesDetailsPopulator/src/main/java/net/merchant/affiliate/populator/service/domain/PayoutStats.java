package net.merchant.affiliate.populator.service.domain;

public class PayoutStats {

	private PayoutAllTime allTimeComisions;
	
	private PayoutThisMonth thisMonthComisions;

	/**
	 * @param allTimeComisions
	 * @param thisMonthComisions
	 */
	public PayoutStats(PayoutAllTime allTimeComisions, PayoutThisMonth thisMonthComisions) {
		super();
		this.allTimeComisions = allTimeComisions;
		this.thisMonthComisions = thisMonthComisions;
	}

	/**
	 * @return the allTimeComisions
	 */
	public PayoutAllTime getAllTimeComisions() {
		return allTimeComisions;
	}

	/**
	 * @param allTimeComisions the allTimeComisions to set
	 */
	public void setAllTimeComisions(PayoutAllTime allTimeComisions) {
		this.allTimeComisions = allTimeComisions;
	}

	/**
	 * @return the thisMonthComisions
	 */
	public PayoutThisMonth getThisMonthComisions() {
		return thisMonthComisions;
	}

	/**
	 * @param thisMonthComisions the thisMonthComisions to set
	 */
	public void setThisMonthComisions(PayoutThisMonth thisMonthComisions) {
		this.thisMonthComisions = thisMonthComisions;
	}

	
	
}
