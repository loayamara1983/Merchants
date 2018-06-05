package net.merchant.affiliate.populator.service.domain;

public class TransactionsStats {

	private TransactionsAllTime allTimeComisions;
	
	private TransactionsThisMonth thisMonthComisions;

	/**
	 * @param allTimeComisions
	 * @param thisMonthComisions
	 */
	public TransactionsStats(TransactionsAllTime allTimeComisions, TransactionsThisMonth thisMonthComisions) {
		super();
		this.allTimeComisions = allTimeComisions;
		this.thisMonthComisions = thisMonthComisions;
	}

	/**
	 * @return the allTimeComisions
	 */
	public TransactionsAllTime getAllTimeComisions() {
		return allTimeComisions;
	}

	/**
	 * @param allTimeComisions the allTimeComisions to set
	 */
	public void setAllTimeComisions(TransactionsAllTime allTimeComisions) {
		this.allTimeComisions = allTimeComisions;
	}

	/**
	 * @return the thisMonthComisions
	 */
	public TransactionsThisMonth getThisMonthComisions() {
		return thisMonthComisions;
	}

	/**
	 * @param thisMonthComisions the thisMonthComisions to set
	 */
	public void setThisMonthComisions(TransactionsThisMonth thisMonthComisions) {
		this.thisMonthComisions = thisMonthComisions;
	}

	
	
}
