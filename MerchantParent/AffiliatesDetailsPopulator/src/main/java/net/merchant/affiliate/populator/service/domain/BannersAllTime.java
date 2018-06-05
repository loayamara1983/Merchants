package net.merchant.affiliate.populator.service.domain;

public class BannersAllTime {

	private Long links;
	private Long textLinks;
	private Long imageBanner;
	private Long flashBanner;
	private Long htmlBanner;
	private Long promoEmail;
	private Long simplePdf;
	/**
	 * @param links
	 * @param textLinks
	 * @param imageBanner
	 * @param flashBanner
	 * @param htmlBanner
	 * @param promoEmail
	 * @param simplePdf
	 */
	public BannersAllTime(Long links, Long textLinks, Long imageBanner, Long flashBanner, Long htmlBanner,
			Long promoEmail, Long simplePdf) {
		super();
		this.links = links;
		this.textLinks = textLinks;
		this.imageBanner = imageBanner;
		this.flashBanner = flashBanner;
		this.htmlBanner = htmlBanner;
		this.promoEmail = promoEmail;
		this.simplePdf = simplePdf;
	}
	/**
	 * @return the links
	 */
	public Long getLinks() {
		return links;
	}
	/**
	 * @param links the links to set
	 */
	public void setLinks(Long links) {
		this.links = links;
	}
	/**
	 * @return the textLinks
	 */
	public Long getTextLinks() {
		return textLinks;
	}
	/**
	 * @param textLinks the textLinks to set
	 */
	public void setTextLinks(Long textLinks) {
		this.textLinks = textLinks;
	}
	/**
	 * @return the imageBanner
	 */
	public Long getImageBanner() {
		return imageBanner;
	}
	/**
	 * @param imageBanner the imageBanner to set
	 */
	public void setImageBanner(Long imageBanner) {
		this.imageBanner = imageBanner;
	}
	/**
	 * @return the flashBanner
	 */
	public Long getFlashBanner() {
		return flashBanner;
	}
	/**
	 * @param flashBanner the flashBanner to set
	 */
	public void setFlashBanner(Long flashBanner) {
		this.flashBanner = flashBanner;
	}
	/**
	 * @return the htmlBanner
	 */
	public Long getHtmlBanner() {
		return htmlBanner;
	}
	/**
	 * @param htmlBanner the htmlBanner to set
	 */
	public void setHtmlBanner(Long htmlBanner) {
		this.htmlBanner = htmlBanner;
	}
	/**
	 * @return the promoEmail
	 */
	public Long getPromoEmail() {
		return promoEmail;
	}
	/**
	 * @param promoEmail the promoEmail to set
	 */
	public void setPromoEmail(Long promoEmail) {
		this.promoEmail = promoEmail;
	}
	/**
	 * @return the simplePdf
	 */
	public Long getSimplePdf() {
		return simplePdf;
	}
	/**
	 * @param simplePdf the simplePdf to set
	 */
	public void setSimplePdf(Long simplePdf) {
		this.simplePdf = simplePdf;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flashBanner == null) ? 0 : flashBanner.hashCode());
		result = prime * result + ((htmlBanner == null) ? 0 : htmlBanner.hashCode());
		result = prime * result + ((imageBanner == null) ? 0 : imageBanner.hashCode());
		result = prime * result + ((links == null) ? 0 : links.hashCode());
		result = prime * result + ((promoEmail == null) ? 0 : promoEmail.hashCode());
		result = prime * result + ((simplePdf == null) ? 0 : simplePdf.hashCode());
		result = prime * result + ((textLinks == null) ? 0 : textLinks.hashCode());
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
		BannersAllTime other = (BannersAllTime) obj;
		if (flashBanner == null) {
			if (other.flashBanner != null)
				return false;
		} else if (!flashBanner.equals(other.flashBanner))
			return false;
		if (htmlBanner == null) {
			if (other.htmlBanner != null)
				return false;
		} else if (!htmlBanner.equals(other.htmlBanner))
			return false;
		if (imageBanner == null) {
			if (other.imageBanner != null)
				return false;
		} else if (!imageBanner.equals(other.imageBanner))
			return false;
		if (links == null) {
			if (other.links != null)
				return false;
		} else if (!links.equals(other.links))
			return false;
		if (promoEmail == null) {
			if (other.promoEmail != null)
				return false;
		} else if (!promoEmail.equals(other.promoEmail))
			return false;
		if (simplePdf == null) {
			if (other.simplePdf != null)
				return false;
		} else if (!simplePdf.equals(other.simplePdf))
			return false;
		if (textLinks == null) {
			if (other.textLinks != null)
				return false;
		} else if (!textLinks.equals(other.textLinks))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BannersAllTimeComisions [links=" + links + ", textLinks=" + textLinks + ", imageBanner=" + imageBanner
				+ ", flashBanner=" + flashBanner + ", htmlBanner=" + htmlBanner + ", promoEmail=" + promoEmail
				+ ", simplePdf=" + simplePdf + "]";
	}
	
	
}
