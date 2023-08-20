package src.unit_test;
import static org.junit.Assert.*;

import org.junit.Test;

import src.PriorityQueue;

public class MyUnitTest3 {

	@Test
	public void TestEmpty(){
		PriorityQueue<Contact> pq = new PriorityQueue<>(new MyComparator<Contact>());
		assertTrue(pq.empty());
	}

	@Test
	public void TestPush(){
		PriorityQueue<Contact> pq = new PriorityQueue<>(new MyComparator<Contact>());
		Contact mark = new Contact("Marco", "Schiavone", 3303303301L, "via Roma", 0);
		Contact andre = new Contact("Andrea", "Schiavone", 332343301L, "via Roma, 6", 2);
		Contact ale = new Contact("Alessia", "Barone", 312343781L, "via Aurelia", 1);
		assertTrue(pq.push(mark));		
		assertTrue(pq.push(andre));
		assertTrue(pq.push(ale));
		assertFalse(pq.empty());
	}

	@Test
	public void TestPush2(){
		PriorityQueue<Contact> pq = new PriorityQueue<>(new MyComparator<Contact>());
		Contact mark = new Contact("Marco", "Schiavone", 3303303301L, "via Roma", 0);
		Contact andre = new Contact("Andrea", "Schiavone", 332343301L, "via Roma, 6", 2);
		Contact ale = new Contact("Alessia", "Barone", 312343781L, "via Aurelia", 1);
		Contact ale2 = new Contact("Alessandra", "Basdasad", 312303781L, "via Aurelia, 9", 1);
		assertTrue(pq.push(mark));		
		assertTrue(pq.push(andre));
		assertTrue(pq.push(ale));
		assertTrue(pq.push(ale2));
		assertFalse(pq.empty());
	}

	@Test
	public void TestContains(){
		PriorityQueue<Contact> pq = new PriorityQueue<>(new MyComparator<Contact>());
		Contact mark = new Contact("Marco", "Schiavone", 3303303301L, "via Roma", 0);
		Contact andre = new Contact("Andrea", "Schiavone", 332343301L, "via Roma, 6", 2);
		Contact ale = new Contact("Alessia", "Barone", 312343781L, "via Aurelia", 1);
		assertTrue(pq.push(mark));		
		assertTrue(pq.push(andre));
		assertTrue(pq.push(ale));
		assertTrue(pq.contains(andre));
	}

	@Test
	public void TestContains2(){
		PriorityQueue<Contact> pq = new PriorityQueue<>(new MyComparator<Contact>());
		Contact mark = new Contact("Marco", "Schiavone", 3303303301L, "via Roma", 0);
		Contact andre = new Contact("Andrea", "Schiavone", 332343301L, "via Roma, 6", 2);
		Contact ale = new Contact("Alessia", "Barone", 312343781L, "via Aurelia", 1);
		Contact ale2 = new Contact("Alessia", "Barone", 312343781L, "via Aurelia", 2);
		assertTrue(pq.push(mark));		
		assertTrue(pq.push(andre));
		assertTrue(pq.push(ale));
		assertTrue(pq.contains(ale));
		assertTrue(pq.contains(ale2));
	}

	@Test
	public void TestContains3(){
		PriorityQueue<Contact> pq = new PriorityQueue<>(new MyComparator<Contact>());
		Contact mark = new Contact("Marco", "Schiavone", 3303303301L, "via Roma", 0);
		assertFalse(pq.contains(mark));
		assertTrue(pq.push(mark));		
		assertTrue(pq.contains(mark));
	}

	@Test
	public void TestContains4(){
		PriorityQueue<Contact> pq = new PriorityQueue<>(new MyComparator<Contact>());
		Contact mark = new Contact("Marco", "Schiavone", 3303303301L, "via Roma", 0);
		assertTrue(pq.push(mark));		
		assertTrue(pq.contains(mark));
		pq.pop();
		assertFalse(pq.contains(mark));
	}

	@Test
	public void TestContains5(){
		PriorityQueue<Contact> pq = new PriorityQueue<>(new MyComparator<Contact>());
		Contact mark = new Contact("Marco", "Schiavone", 3303303301L, "via Roma", 0);
		assertTrue(pq.push(mark));		
		assertTrue(pq.contains(mark));
		assertTrue(pq.remove(mark));
		assertFalse(pq.contains(mark));
	}

	@Test
	public void TestTop(){
		PriorityQueue<Contact> pq = new PriorityQueue<>(new MyComparator<Contact>());
		Contact mark = new Contact("Marco", "Schiavone", 3303303301L, "via Roma", 0);
		Contact andre = new Contact("Andrea", "Schiavone", 332343301L, "via Roma, 6", 2);
		Contact ale = new Contact("Alessia", "Barone", 312343781L, "via Aurelia", 1);
		assertTrue(pq.push(mark));		
		assertTrue(pq.push(andre));
		assertTrue(pq.push(ale));
		assertSame(pq.top(), mark);
	}

	@Test
	public void TestTop2(){
		PriorityQueue<Contact> pq = new PriorityQueue<>(new MyComparator<Contact>());
		assertSame(pq.top(), null);
	}

	@Test
	public void TestTopRemove(){
		PriorityQueue<Contact> pq = new PriorityQueue<>(new MyComparator<Contact>());
		Contact mark = new Contact("Marco", "Schiavone", 3303303301L, "via Roma", 0);
		Contact andre = new Contact("Andrea", "Schiavone", 332343301L, "via Roma, 6", 2);
		Contact ale = new Contact("Alessia", "Barone", 312343781L, "via Aurelia", 1);
		assertTrue(pq.push(mark));		
		assertTrue(pq.push(andre));
		assertTrue(pq.push(ale));
		assertSame(pq.top(), mark);
		assertTrue(pq.remove(mark));
		assertSame(pq.top(), ale);
	}

	@Test
	public void TestTopPop(){
		PriorityQueue<Contact> pq = new PriorityQueue<>(new MyComparator<Contact>());
		Contact mark = new Contact("Marco", "Schiavone", 3303303301L, "via Roma", 0);
		Contact andre = new Contact("Andrea", "Schiavone", 332343301L, "via Roma, 6", 2);
		Contact ale = new Contact("Alessia", "Barone", 312343781L, "via Aurelia", 1);
		Contact ale2 = new Contact("Alessandra", "Basdasad", 312303781L, "via Aurelia, 9", 3);
		assertTrue(pq.push(mark));		
		assertTrue(pq.push(andre));
		assertTrue(pq.push(ale));
		assertTrue(pq.push(ale2));
		assertSame(pq.top(), mark);
		pq.pop();
		assertSame(pq.top(), ale);
	}

	@Test
	public void TestRemove(){
		PriorityQueue<Contact> pq = new PriorityQueue<>(new MyComparator<Contact>());
		Contact mark = new Contact("Marco", "Schiavone", 3303303301L, "via Roma", 0);
		Contact andre = new Contact("Andrea", "Schiavone", 332343301L, "via Roma, 6", 2);
		Contact ale = new Contact("Alessia", "Barone", 312343781L, "via Aurelia", 1);
		assertTrue(pq.push(mark));		
		assertTrue(pq.push(andre));
		assertTrue(pq.push(ale));
		assertTrue(pq.remove(andre));
		assertTrue(pq.remove(mark));
		assertTrue(pq.remove(ale));
	}

	@Test
	public void TestPop(){
		PriorityQueue<Contact> pq = new PriorityQueue<>(new MyComparator<Contact>());
		Contact mark = new Contact("Marco", "Schiavone", 3303303301L, "via Roma", 0);
		Contact andre = new Contact("Andrea", "Schiavone", 332343301L, "via Roma, 6", 2);
		Contact ale = new Contact("Alessia", "Barone", 312343781L, "via Aurelia", 1);
		assertTrue(pq.push(mark));		
		assertTrue(pq.push(andre));
		assertTrue(pq.push(ale));
		pq.pop();
		pq.pop();
		pq.pop();
	}

	@Test
	public void TestIncreasePriority(){
		PriorityQueue<Contact> pq = new PriorityQueue<>(new MyComparator<Contact>());
		Contact mark = new Contact("Marco", "Schiavone", 3303303301L, "via Roma", 0);
		Contact andre = new Contact("Andrea", "Schiavone", 332343301L, "via Roma, 6", 2);
		Contact ale = new Contact("Alessia", "Barone", 312343781L, "via Aurelia", 3);
		Contact ale2 = new Contact("Alessandra", "Basdasad", 312303781L, "via Aurelia, 9", 1);
		assertTrue(pq.push(mark));		
		assertTrue(pq.push(andre));
		assertTrue(pq.push(ale));
		assertTrue(pq.increasePriority(ale, ale2));
	}

	@Test
	public void TestIncreasePriority2(){
		PriorityQueue<Contact> pq = new PriorityQueue<>(new MyComparator<Contact>());
		Contact mark = new Contact("Marco", "Schiavone", 3303303301L, "via Roma", 0);
		Contact andre = new Contact("Andrea", "Schiavone", 332343301L, "via Roma, 6", 2);
		Contact ale = new Contact("Alessia", "Barone", 312343781L, "via Aurelia", 1);
		Contact ale2 = new Contact("Alessandra", "Basdasad", 312303781L, "via Aurelia, 9", 1);
		assertTrue(pq.push(mark));		
		assertTrue(pq.push(andre));
		assertTrue(pq.push(ale));
		assertFalse(pq.increasePriority(ale, ale2)); // false because they have same priority! --> not good
	}

	@Test
	public void TestIncreasePriority3(){
		PriorityQueue<Contact> pq = new PriorityQueue<>(new MyComparator<Contact>());
		Contact mark = new Contact("Marco", "Schiavone", 3303303301L, "via Roma", 5);
		Contact andre = new Contact("Andrea", "Schiavone", 332343301L, "via Roma, 6", 2);
		Contact ale = new Contact("Alessia", "Barone", 312343781L, "via Aurelia", 3);
		Contact ale2 = new Contact("Alessia", "Barone", 312343781L, "via Aurelia", 1);
		assertTrue(pq.push(mark));		
		assertTrue(pq.push(andre));
		assertTrue(pq.push(ale));
		assertSame(pq.top(), andre);
		assertTrue(pq.increasePriority(ale, ale2));		// true because ale2 has higher priority
		assertSame(pq.top(), ale2);
	}

	@Test
	public void TestIncreasePriority4(){
		PriorityQueue<Contact> pq = new PriorityQueue<>(new MyComparator<Contact>());
		Contact mark = new Contact("Marco", "Schiavone", 3303303301L, "via Roma", 5);
		Contact andre = new Contact("Andrea", "Schiavone", 332343301L, "via Roma, 6", 3);
		Contact ale = new Contact("Alessia", "Barone", 312343781L, "via Aurelia", 1);
		Contact ale2 = new Contact("Alessia", "Barone", 312343781L, "via Aurelia", 10);
		assertTrue(pq.push(mark));		
		assertTrue(pq.push(andre));
		assertTrue(pq.push(ale));
		assertSame(pq.top(), ale);
		assertFalse(pq.increasePriority(ale, ale2));
		assertSame(pq.top(), ale);
	}

	/* -------------------------------------------------------------------------------------  */
	/* -------------------------------------------------------------------------------------  */
	/* -------------------------------------------------------------------------------------  */
	/* -------------------------------------------------------------------------------------  */
	/* -------------------------------------------------------------------------------------  */
	/* -------------------------------------------------------------------------------------  */
	/* -------------------------------------------------------------------------------------  */
	/* -------------------------------------------------------------------------------------  */
	/* -------------------------------------------------------------------------------------  */

	public static final double delta = 0.000001;

	@Test
	public void TestEmptyDouble(){
		PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> {return Double.compare(a,b);});
		assertTrue(pq.empty());
	}

	@Test
	public void TestPushDouble(){
		PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> {return Double.compare(a,b);});
		assertTrue(pq.push(20.4));		
		assertTrue(pq.push(21.3));
		assertTrue(pq.push(0.9));
		assertFalse(pq.empty());
	}

	@Test
	public void TestPush2Double(){
		PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> {return Double.compare(a,b);});
		assertTrue(pq.push(0.2));		
		assertTrue(pq.push(0.1));
		assertTrue(pq.push(0.0));
		assertFalse(pq.push(0.0));
		assertFalse(pq.empty());
	}

	@Test
	public void TestContainsDouble(){
		PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> {return Double.compare(a,b);});
		assertTrue(pq.push(10.7));		
		assertTrue(pq.push(12.412));
		assertTrue(pq.push(6.78));
		assertTrue(pq.contains(12.412));
	}

	@Test
	public void TestContains2Double(){
		PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> {return Double.compare(a,b);});
		assertTrue(pq.push(0.8765));		
		assertTrue(pq.push(456.23));
		assertTrue(pq.push(18.0));
		assertTrue(pq.contains(0.8765));
		assertTrue(pq.contains(18.0));
		assertFalse(pq.contains(18.0000001));
	}

	@Test
	public void TestContains3Double(){
		PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> {return Double.compare(a,b);});
		assertFalse(pq.contains(12.01));
		assertTrue(pq.push(18.3));		
		assertTrue(pq.contains(18.30));
	}

	@Test
	public void TestContains4Double(){
		PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> {return Double.compare(a,b);});
		assertTrue(pq.push(10.1));		
		assertTrue(pq.contains(10.1));
		pq.pop();
		assertFalse(pq.contains(10.1));
	}

	@Test
	public void TestContains5Double(){
		PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> {return Double.compare(a,b);});
		assertTrue(pq.push(103.425));		
		assertTrue(pq.contains(103.425));
		assertTrue(pq.remove(103.425));
		assertFalse(pq.contains(103.425));
	}

	@Test
	public void TestTopDouble(){
		PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> {return Double.compare(a,b);});
		assertTrue(pq.push(103.425));		
		assertTrue(pq.push(1034.91));
		assertTrue(pq.push(103.426));
		assertEquals((Double)pq.top(), (Double)103.425, delta);
	}

	@Test
	public void TestTop2Double(){
		PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> {return Double.compare(a,b);});
		assertEquals((Double)pq.top(), null);
	}

	@Test
	public void TestTopRemoveDouble(){
		PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> {return Double.compare(a,b);});
		assertTrue(pq.push(19.3456));		
		assertTrue(pq.push(149.34));
		assertTrue(pq.push(124.123));
		assertEquals((Double)pq.top(), (Double)19.3456, delta);
		assertTrue(pq.remove(19.3456));
		assertEquals((Double)pq.top(), (Double)124.123, delta);
	}

	@Test
	public void TestTopPopDouble(){
		PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> {return Double.compare(a,b);});
		assertTrue(pq.push(0.12324));		
		assertTrue(pq.push(4632.1));
		assertTrue(pq.push(342.1));
		assertTrue(pq.push(12.35454));
		assertEquals((Double)pq.top(), (Double)0.12324, delta);
		pq.pop();
		assertEquals((Double)pq.top(), (Double)12.35454, delta);
	}

	@Test
	public void TestRemoveDouble(){
		PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> {return Double.compare(a,b);});
		assertTrue(pq.push(120.3));		
		assertTrue(pq.push(1234.1222));
		assertTrue(pq.push(12.309));
		assertTrue(pq.remove(1234.1222));
		assertTrue(pq.remove(120.3));
		assertTrue(pq.remove(12.309));
	}

	@Test
	public void TestPopDouble(){
		PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> {return Double.compare(a,b);});
		assertTrue(pq.push(923.29));		
		assertTrue(pq.push(0.1341));
		assertTrue(pq.push(23.64));
		pq.pop();
		assertEquals((Double)pq.top(), (Double)23.64, delta);
		pq.pop();
		assertEquals((Double)pq.top(), (Double)923.29, delta);
		pq.pop();
		assertTrue(pq.empty());
	}

	@Test
	public void TestIncreasePriorityDouble(){
		PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> {return Double.compare(a,b);});
		assertTrue(pq.push(23.93));		
		assertTrue(pq.push(934.201));
		assertTrue(pq.push(34.2));
		assertEquals((Double)pq.top(), (Double)23.93, delta);
		assertTrue(pq.increasePriority(34.2, 14.0));
		assertEquals((Double)pq.top(), (Double)14.0, delta);
	}

	@Test
	public void TestIncreasePriority2Double(){
		PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> {return Double.compare(a,b);});
		assertTrue(pq.push(0.39453));		
		assertTrue(pq.push(312.1));
		assertTrue(pq.push(12.3));
		assertEquals((Double)pq.top(), (Double)0.39453, delta);
		assertFalse(pq.increasePriority(12.3, 12.3)); // false because they have same priority! --> not good
		assertEquals((Double)pq.top(), (Double)0.39453, delta);
	}

	@Test
	public void TestIncreasePriority3Double(){
		PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> {return Double.compare(a,b);});
		assertTrue(pq.push(876.543));		
		assertTrue(pq.push(42.051));
		assertTrue(pq.push(123.32));
		assertEquals((Double)pq.top(), (Double)42.051, delta);
		assertTrue(pq.increasePriority(123.32, 42.052));		// true because ale2 has higher priority
		assertEquals((Double)pq.top(), (Double)42.051, delta);
	}

	@Test
	public void TestIncreasePriority4Double(){
		PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> {return Double.compare(a,b);});
		assertTrue(pq.push(1238.23));		
		assertTrue(pq.push(1240.9304));
		assertTrue(pq.push(10.123));
		assertEquals((Double)pq.top(), (Double)10.123, delta);
		assertFalse(pq.increasePriority(10.123, 124.324));
		assertEquals((Double)pq.top(), (Double)10.123, delta);
	}
}