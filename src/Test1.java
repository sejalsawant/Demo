import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.beust.jcommander.JCommander;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
	
	//@Test
	public void regular()
	{
	//finding names starting with a
		
	ArrayList<String> names=new ArrayList<String>();
	names.add("Abhijeet");
	names.add("Don");
	names.add("Akshay");
	names.add("Adam");
	names.add("Ram");
	
	for(int i=0; i<names.size();i++)
	{
		String value=names.get(i);
		if(value.startsWith("A"))
		{
			System.out.println(value);
		}
	}
	}
	
	//@Test
	public void streamFilter()
	{
	//finding names starting with a
		
	ArrayList<String> names=new ArrayList<String>();
	names.add("Abhijeet");
	names.add("Don");
	names.add("Akshay");
	names.add("Adam");
	names.add("Ram");
	//intermediate operation has no life without terminal operation
	//terminal operation will execute only if all intermediate operation(eg filter) returns true
	Long c=names.stream().filter(s->s.startsWith("A")).count();
	System.out.println(c);
	
	/*Long d=Stream.of("Adam","Abhi","Ram").filter(s->
	{
		s.startsWith("A");
	}).count();
	System.out.println(d);  */
	
	//to print names which has length more than 3
	names.stream().filter(s->s.length()>3).forEach(s->System.out.println(s));
}
	
	//@Test
	public void streamMap()
	{
		ArrayList<String> names=new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Akshay");
		names.add("Adam");
		names.add("Ram");
		//words end with a and convert them to upercase
		//Stream.of("Adam","Akshaya","Ram","Abhijeeta").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		names.stream().filter(s->s.endsWith("m")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//start with a, covert to uppercase and thn sort
		names.stream().filter(s->s.startsWith("A")).map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));
	}
	
	//@Test
	public void streamConcat()
	{
		ArrayList<String> names=new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		
		List<String> names1=Arrays.asList("Adam","Akshaya");
		
		Stream<String> newstream=Stream.concat(names.stream(), names1.stream());
		//to check don is present or not. if present return true
		Boolean flag=newstream.anyMatch(s->s.equalsIgnoreCase("Don"));
		Assert.assertTrue(flag);
	}
	
	//@Test
	public void streamCollect()
	{
		List<String> ls=Stream.of("Adam","Akshaya","Ram","Abhijeeta").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
	}
	
	@Test
	public void streamAssignment()
	{
		List<Integer> values=Arrays.asList(1,2,3,4,2,5,1,6,8,7,5,9,4);
		//print unique, sort
		values.stream().distinct().sorted().forEach(s->System.out.println(s));
		//unique, sort and print 3rd index
		List<Integer> li=values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
	}
	
	
}
