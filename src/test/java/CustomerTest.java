
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
	
	@Test
	public void whenWeCalculateTransfers()
	{
		Customer c1 = new Customer();
		assertThat(c1.SumTransfers(), is(0));
		ArrayList<Transfer> transfers = new ArrayList<Transfer>();
		Transfer t1 = new Transfer("213.129.232.1", "213.129.226.2", "IPv4", 400);
		Transfer t2 = new Transfer("213.129.232.1", "213.129.226.2", "IPv4", 600);
		Transfer t3 = new Transfer("213.129.232.1", "213.129.226.2", "IPv4", 300);
		Transfer t4 = new Transfer("213.129.232.1", "213.129.226.2", "IPv4", 1000);
		Transfer t5 = new Transfer("213.129.232.1", "213.129.226.2", "IPv4", 2500);
		Transfer t6 = new Transfer("2001:858:5:2c00::1", "2001:858:745::1", "IPv6", 2500);
		transfers.add(t1);
		transfers.add(t2);
		transfers.add(t3);
		transfers.add(t4);
		transfers.add(t5);
		transfers.add(t6);
		c1.setTransfers(transfers);
		// weighted value!
		assertThat(c1.SumTransfers(), is(12100));
	}
	
	@Test
	public void whenWeCalculateQuotaPrice()
	{
		Customer c1 = new Customer();
		// test without any quotas
		assertThat(c1.calculateQuotaPrice(), is(0));
		ArrayList<Integer> quotas = new ArrayList<Integer>();
		quotas.add(3000);
		quotas.add(5000);
		quotas.add(3000);
		quotas.add(10000);
		c1.setQuota(quotas);
		// test with some quotas
		assertThat(c1.calculateQuotaPrice(), is(350));
		
	}
	
	@Test
	public void whenWeCalculateOverQuotaPrice()
	{
		Customer c1 = new Customer();
		ArrayList<Transfer> transfers = new ArrayList<Transfer>();
		Transfer t1 = new Transfer("213.129.232.1", "213.129.226.2", "IPv4", 400);
		Transfer t2 = new Transfer("213.129.232.1", "213.129.226.2", "IPv4", 600);
		Transfer t3 = new Transfer("213.129.232.1", "213.129.226.2", "IPv4", 300);
		Transfer t4 = new Transfer("213.129.232.1", "213.129.226.2", "IPv4", 1000);
		Transfer t5 = new Transfer("213.129.232.1", "213.129.226.2", "IPv4", 2500);
		Transfer t6 = new Transfer("2001:858:5:2c00::1", "2001:858:745::1", "IPv6", 2500);
		transfers.add(t1);
		transfers.add(t2);
		transfers.add(t3);
		transfers.add(t4);
		transfers.add(t5);
		transfers.add(t6);
		c1.setTransfers(transfers);
		ArrayList<Integer> quotas = new ArrayList<Integer>();
		quotas.add(3000);
		quotas.add(5000);
		quotas.add(3000);
		c1.setQuota(quotas);
		assertThat(c1.calculateOverQuotaPrice(), is(1100));
		quotas.add(3000);
		c1.setQuota(quotas);
		assertThat(c1.calculateOverQuotaPrice(), is(0));
		// weighted value!
	}
	
	@Test
	public void whenWeCalculatePrice()
	{
		Customer c1 = new Customer();
		ArrayList<Transfer> transfers = new ArrayList<Transfer>();
		Transfer t1 = new Transfer("213.129.232.1", "213.129.226.2", "IPv4", 400);
		Transfer t2 = new Transfer("213.129.232.1", "213.129.226.2", "IPv4", 600);
		Transfer t3 = new Transfer("213.129.232.1", "213.129.226.2", "IPv4", 300);
		Transfer t4 = new Transfer("213.129.232.1", "213.129.226.2", "IPv4", 1000);
		Transfer t5 = new Transfer("213.129.232.1", "213.129.226.2", "IPv4", 2500);
		Transfer t6 = new Transfer("2001:858:5:2c00::1", "2001:858:745::1", "IPv6", 2500);
		transfers.add(t1);
		transfers.add(t2);
		transfers.add(t3);
		transfers.add(t4);
		transfers.add(t5);
		transfers.add(t6);
		c1.setTransfers(transfers);
		ArrayList<Integer> quotas = new ArrayList<Integer>();
		quotas.add(3000);
		quotas.add(5000);
		quotas.add(3000);
		c1.setQuota(quotas);
		assertThat(c1.calculatePrice(), is(1300));
		quotas.add(3000);
		c1.setQuota(quotas);
		assertThat(c1.calculatePrice(), is(250));
	}
	
	
	
	
	

}
