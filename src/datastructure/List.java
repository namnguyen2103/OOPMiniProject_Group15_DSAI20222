package datastructure;
import java.util.*;


public class List 
{
	LinkedList<Number> List_type = new LinkedList<>();
	
	public List()
	{
		
	}
	
	public void insert(int index, Number num)
	{
		for(int i = 0; i < List_type.size(); ++i)
		{
			if(i == index)
			{
				List_type.add(index, num);
				List_type.remove(index + 1);
			}
			
		}
	}
	
	public void add(Number num)
	{
		List_type.add(num);
	}
	
	public void delete(Number num)
	{
		List_type.remove(num);
	}
	
	public void random(int Num)
	{
		Random rand = new Random();
				
		for(int i = 1; i <= Num; ++i)
		{
			Number ran_num = rand.nextInt();
			List_type.add(ran_num);
		}
	}
	
	public void print()
	{
		for(int i = 0; i < List_type.size(); ++i)
		{
			System.out.println(List_type.get(i));
		}
	}
	
	public void sort()
	{
		for(int i = 0; i < List_type.size(); ++i)
		{
			for(int j = i + 1; j < List_type.size(); ++j)
			{
				long Num_i = (long) List_type.get(i);
				long Num_j = (long) List_type.get(j);
				if(Num_i > Num_j)
				{
					List_type.add(i, Num_j);
					List_type.remove(i + 1);
					List_type.add(j, Num_i);
					List_type.remove(j + 1);
				}
			}
		}
		
	}
	
	public int find(Number num)
	{
		for(int i = 0; i < List_type.size(); ++i)
		{
			if(List_type.get(i).equals(num))
			{
				return i;
			}
			
		}
		
		return -1;
	}
	
}
