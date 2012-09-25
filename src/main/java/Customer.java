import java.util.ArrayList;


public class Customer 
{
	private ArrayList<Transfer> transfers;
	private ArrayList<Integer> quota;
	
	public Customer()
	{
		transfers = new ArrayList<Transfer>();
		quota = new ArrayList<Integer>();
	}
	
	
	// getter
	
	/**
	 * @return the transfers
	 */
	public ArrayList<Transfer> getTransfers() 
	{
		return transfers;
	}



	/**
	 * @return the quota
	 */
	public ArrayList<Integer> getQuota() 
	{
		return quota;
	}



	// setter
	
	/**
	 * @param transfers the transfers to set
	 */
	public void setTransfers(ArrayList<Transfer> transfers) 
	{
		if(transfers != null)
		{
			this.transfers = transfers;
		}
		else
		{
			throw new NullPointerException("NULL @ setTransfers");
		}
		
	}



	/**
	 * @param quota the quota to set
	 */
	public void setQuota(ArrayList<Integer> quota) 
	{
		if(quota != null)
		{
			this.quota = quota;
		}
		else
		{
			throw new NullPointerException("NULL @ setQuota");
		}
	}
	
	
	public Integer SumQuotas()
	{
		Integer res = new Integer(0);
		int count = 0;
		while (count < quota.size()) 
		{
			res += quota.get(count);
			count++;
				
		}
		return res;
	}
	
	public Integer SumTransfers()
	{
		Integer res = new Integer(0);
		int count = 0;
		while(count < transfers.size())
		{
			res += transfers.get(count).calculateWeightedSize();
			count++;
		}
		return res;
	}

	public Integer calculateQuotaPrice()
	{
		Integer res = new Integer(0);
		int counter = 0;
		while(counter < quota.size())
		{
			if(quota.get(counter) == 3000)
			{
				res += 50;
			}
			if(quota.get(counter) == 5000)
			{
				res += 100;
			}
			if(quota.get(counter) == 10000)
			{
				res += 150;
			}
			counter++;
		}
		
		return res;
	}

		
	
}
