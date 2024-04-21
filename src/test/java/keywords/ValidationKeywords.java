package keywords;

import org.testng.Assert;

public class ValidationKeywords extends GenericKeywords{

	public void validateTitle(String Title)
	{
		Assert.assertEquals(driver.getTitle(), Title);
	}
}
