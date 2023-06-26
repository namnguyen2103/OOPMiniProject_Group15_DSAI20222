package datastructure;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;


public class List 
{
	LinkedList<Integer> List_type = new LinkedList<>();
	
	public List()
	{
		
	}
	
	public void insert(int index, int num)
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
	
	public void add(int num)
	{
		List_type.add(num);
	}
	
	public void delete(int num)
	{
		List_type.remove(num);
	}
	
	public void random(int Num)
	{
		Random rand = new Random();
				
		for(int i = 1; i <= Num; ++i)
		{
			Integer ran_num = rand.nextInt();
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
				int Num_i =  List_type.get(i);
				int Num_j =  List_type.get(j);
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
	
	public int find(int num)
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
	
	public Object[] toArray_Listtype()
	{
		return List_type.toArray();
	}
	
}
