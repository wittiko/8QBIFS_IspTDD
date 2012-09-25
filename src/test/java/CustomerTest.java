
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CustomerTest 
{
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	public void setup()
	{
		
	}
	
	@Test
	public void whenWeSetInvalidTransfers()
	{
		Customer c1 = new Customer();
		thrown.expect(NullPointerException.class);
		c1.setTransfers(null);
	}
	
	@Test
	public void whenWeSetInvalidQuotas()
	{
		Customer c1 = new Customer();
		thrown.expect(NullPointerException.class);
		c1.setQuota(null);
	}
	
	@Test
	public void whenWeCalculateQuotoSum()
	{
		Customer c1 = new Customer();
		//thrown.expect(NullPointerException.class);
		assertThat(c1.SumQuotas(), is(0));
		ArrayList<Integer> quotas = new ArrayList<Integer>();
		quotas.add(3000);
		quotas.add(5000);
		quotas.add(3000);
		quotas.add(10000);
		c1.setQuota(quotas);
		assertThat(c1.SumQuotas(), is(21000));
	}
	
	
	
	

}
