package com.appx.work.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.series.numberseries.util.AppxUtil;
import com.series.numberseries.util.SeriesDefinitionTO;
import com.series.numberseries.util.SeriesTO;

public class GetSeriesTest extends Assert {

	@BeforeClass
	public static void uploadDefinition() {
		AppxUtil.loadDefinitions();
	}

	@Test
	public void IncrementWithN() {

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName("IncrementWithOne");
		String series = AppxUtil.definitionMap.get("IncrementWithN");

		definition.setEncodedSeries(series);
		definition.setExplanation("IncrementWithOne.MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("1");
		definition.setIncrement("1");

		String result = AppxUtil.getSeriesResult(definition);

		assertTrue("1,2,3,4,5,6,7".equals(result));

	}

	@Test
	public void IncrementWithN1() {

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName("IncrementWithOne");
		String series = AppxUtil.definitionMap.get("IncrementWithN");

		definition.setEncodedSeries(series);
		definition.setExplanation("IncrementWithOne.MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("11");
		definition.setIncrement("7");

		String result = AppxUtil.getSeriesResult(definition);

		assertTrue("11,18,25,32,39,46,53".equals(result));

	}

	//

	@Test
	public void DecrementWithN() {

		String name = "DecrementWithN";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("100");
		definition.setIncrement("1");

		String result = AppxUtil.getSeriesResult(definition);

		assertTrue("100,99,98,97,96,95,94".equals(result));

	}

	@Test
	public void DecrementWithN1() {

		String name = "DecrementWithN";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("97");
		definition.setIncrement("5");

		String result = AppxUtil.getSeriesResult(definition);

		assertTrue("97,92,87,82,77,72,67".equals(result));

	}

	//

	@Test
	public void Square() {

		String name = "Square";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("2");
		definition.setIncrement("1");

		String result = AppxUtil.getSeriesResult(definition);

		assertTrue("4,9,16,25,36,49,64".equals(result));

	}

	@Test
	public void Square1() {

		String name = "Square";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("3");
		definition.setIncrement("2");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("9,16,25,36,49,64,81".equals(result));

	}

	// SquareWithIncrement

	@Test
	public void SquareWithIncrement() {

		String name = "SquareWithIncrement";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("2");
		definition.setIncrement("2");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("6,11,18,27,38,51,66".equals(result));

	}

	@Test
	public void SquareWithIncrement1() {

		String name = "SquareWithIncrement";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("2");
		definition.setIncrement("5");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("9,14,21,30,41,54,69".equals(result));

	}

	// SquareWithDecrement

	@Test
	public void SquareWithDecrement() {

		String name = "SquareWithDecrement";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("2");
		definition.setIncrement("1");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("3,8,15,24,35,48,63".equals(result));

	}

	@Test
	public void SquareWithDecrement1() {

		String name = "SquareWithDecrement";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("3");
		definition.setIncrement("2");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("7,14,23,34,47,62,79".equals(result));

	}

	@Test
	public void Cube() {

		String name = "Cube";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("1");
		definition.setIncrement("1");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("1,8,27,64,125,216,343".equals(result));

	}

	@Test
	public void Cube1() {

		String name = "Cube";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("2");
		definition.setIncrement("1");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("8,27,64,125,216,343,512".equals(result));

	}

	// CubeWithIncrement

	@Test
	public void CubeWithIncrement() {

		String name = "CubeWithIncrement";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("1");
		definition.setIncrement("1");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("2,9,28,65,126,217,344".equals(result));

	}

	@Test
	public void CubeWithIncrement2() {

		String name = "CubeWithIncrement";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("1");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("4,11,30,67,128,219,346".equals(result));

	}

	// CubeWithDecrement,x * x * x - n,(x+1)*(x+1) * (x+1) - n,(x+2)*(x+2)*(x+2)
	// - n,(x+3)*(x+3)*(x+3) - n,(x+4)*(x+4)*(x+4) - n,(x+5)*(x+5)*(x+5) -
	// n,(x+6)*(x+6)*(x+6) - n

	@Test
	public void CubeWithDecrement() {

		String name = "CubeWithDecrement";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("2");
		definition.setIncrement("1");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("7,26,63,124,215,342,511".equals(result));

	}

	@Test
	public void CubeWithDecrement1() {

		String name = "CubeWithDecrement";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("3");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("24,61,122,213,340,509,726".equals(result));

	}

	// MultiplyByN,x1*n,(x+1) * n,(x+2) * n,(x+3) * n,(x+4) * n,(x + 5 ) * n,(x
	// + 6 ) * n
	@Test
	public void MultiplyByN() {

		String name = "MultiplyByN";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("3");
		definition.setIncrement("2");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("6,8,10,12,14,16,18".equals(result));

	}

	@Test
	public void MultiplyByN1() {

		String name = "MultiplyByN";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("3");
		definition.setIncrement("7");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("21,28,35,42,49,56,63".equals(result));

	}

	// AlternateIncrease,x,x+5+n,x1+n,x2+n,x3+n,x4+n,x5+n

	@Test
	public void AlternateIncrease() {

		String name = "AlternateIncrease";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("3");
		definition.setIncrement("7");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("3,15,10,22,17,29,24".equals(result));

	}

	@Test
	public void AlternateIncrease1() {

		String name = "AlternateIncrease";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("13");
		definition.setIncrement("7");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("13,25,20,32,27,39,34".equals(result));

	}

	// AlterenateDecrease,x,x-5-n,x1-n,x2-n,x3-n,x4-n,x5-n

	@Test
	public void AlterenateDecrease() {

		String name = "AlterenateDecrease";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("40");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("40,32,37,29,34,26,31".equals(result));

	}
	// AlternateIncDecr,x,x+100-n,x1+n,x2-n,x3+n,x4-n,x5+n

	@Test
	public void AlternateIncDecr() {

		String name = "AlternateIncDecr";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("40");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("40,137,43,134,46,131,49".equals(result));

	}

	// SameneighbourIncr,x,x1,x2+n,x2+n,x3+n,x3+n,x4+n

	@Test
	public void SameneighbourIncr() {

		String name = "SameneighbourIncr";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("40");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("40,40,43,43,46,46,49".equals(result));

	}

	// SameneighbourDecr,x,x1,x2-n,x2-n,x3-n,x3-n,x4-n
	@Test
	public void SameneighbourDecr() {

		String name = "SameneighbourDecr";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("40");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("40,40,37,37,34,34,31".equals(result));

	}

	// PlusMultiply,x,(x+1) + n ,(x+2) * n,(x+3) + n,(x+4) * n,(x+5) + n,(x+6) *
	// n

	@Test
	public void PlusMultiply() {

		String name = "PlusMultiply";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("2");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("2,6,12,8,18,10,24".equals(result));

	}

	// MinusMultiple,x,(x+1) - n ,(x+2) * n,(x+3) - n,(x+4) * n,(x+5) - n,(x+6)
	// * n

	@Test
	public void MinusMultiple() {

		String name = "MinusMultiple";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("2");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("2,0,12,2,18,4,24".equals(result));

	}

	// IncrementAndAdd,x,n,x1+n,n+1,x3 + x4,n+2,x5+x6

	@Test
	public void IncrementAndAdd() {

		String name = "IncrementAndAdd";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("2");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("2,3,5,4,9,5,14".equals(result));

	}

	// DecrementAndAdd,x,n,x1-x2,n+1,x3 - x4,n+2,x5-x6

	@Test
	public void DecrementAndAdd() {

		String name = "DecrementAndAdd";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("23");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("23,3,20,4,16,5,11".equals(result));

	}

	// SumOfPrevious,x,x1,x2+x1,x3+x2,x4+x3,x5+x4,x6+x5

	@Test
	public void SumOfPrevious() {

		String name = "SumOfPrevious";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("23");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("23,23,46,69,115,184,299".equals(result));

	}

	// DecrementAndMultiply,x,x1 - n,x2 * n,x3 -n ,x4 * n,x5 - n ,x6 * n

	@Test
	public void DecrementAndMultiply() {

		String name = "DecrementAndMultiply";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("23");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("23,20,60,57,171,168,504".equals(result));

	}

	// IncrementAndMultiply,x,x1 + n,x2 * n,x3 + n,x4 * n,x5 + n,x6 * n

	@Test
	public void IncrementAndMultiply() {

		String name = "IncrementAndMultiply";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("23");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("23,26,78,81,243,246,738".equals(result));

	}

	// Kolakoski,x,x1+n,x1+n,x1+5,x4+n,x4+n,x4+5

	@Test
	public void Kolakoski() {

		String name = "Kolakoski";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("12");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("12,15,15,17,20,20,22".equals(result));

	}

	// TwoInSequence,x,x1,x1+n,x1+n,x3+n,x3+n,x5+n

	@Test
	public void TwoInSequence() {

		String name = "TwoInSequence";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("12");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("12,12,15,15,18,18,21".equals(result));

	}

	// DecreasingThree,x,x-n,x2-n,x,x -n ,x1-n,x

	@Test
	public void DecreasingThree() {

		String name = "DecreasingThree";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("12");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("12,9,6,12,9,6,12".equals(result));

	}

	// Tribonnaci,x,x1,x1+x2,x1+x2+x3,x2+x3+x4,x3+x4+x5,x4+x5+x6

	@Test
	public void Tribonnaci() {

		String name = "Tribonnaci";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("12");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("12,12,24,48,84,156,288".equals(result));

	}

	// ThreeInSequence,x,x,x,x+n,x+n,x+n,x+n+n

	@Test
	public void ThreeInSequence() {

		String name = "ThreeInSequence";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("12");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("12,12,12,15,15,15,18".equals(result));

	}

	// Factorial,x,x1*x1,x2*x1,x3*x2,x4*x3,x5*x4,x6*x5

	@Test
	public void Factorial() {

		String name = "Factorial";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("2");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("2,4,8,32,256,8192,2097152".equals(result));

	}

	// TriangularNumbers,x*n*(n+1)/2,(x+1)*n*(n+1)/2,(x+2)*n*(n+1)/2,(x+3)*n*(n+1)/2,(x+4)*n*(n+1)/2,(x+5)*n*(n+1)/2,(x+6)*n*(n+1)/2

	@Test
	public void TriangularNumbers() {

		String name = "TriangularNumbers";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("2");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("12,18,24,30,36,42,48".equals(result));

	}

	// SameSameAdd,x,x,x1+x2,x+n,x+n,x4+x4,x4+n

	@Test
	public void SameSameAdd() {

		String name = "SameSameAdd";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("2");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("2,2,4,5,5,10,8".equals(result));

	}

	// DecreasingN,x,x-1-n,x-2-n,x-3-n,x-4-n,x-5-n,x-6-n

	@Test
	public void DecreasingN() {

		String name = "DecreasingN";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("72");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("72,68,67,66,65,64,63".equals(result));

	}

	// IncreasingN,x,x+1+n,x+2+n,x+3+n,x+4+n,x+5+n,x+6+n

	@Test
	public void IncreasingN() {

		String name = "IncreasingN";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("72");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("72,76,77,78,79,80,81".equals(result));

	}

	// PowerSeries,x,x*x,x2*x,x3*x ,x4*x ,x5*x ,x6*x

	@Test
	public void PowerSeries() {

		String name = "PowerSeries";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("2");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("2,4,8,16,32,64,128".equals(result));

	}

	// AddByDecimalPosition,x,x+10,x+100,x+1000,x+10000,x+100000,x+1000000

	@Test
	public void AddByDecimalPosition() {

		String name = "AddByDecimalPosition";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("2");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("2,12,102,1002,10002,100002,1000002".equals(result));

	}

	// DiffSquareOfNPlusOne,x,x1+n*n,x2+(n+1)*(n+1),x3+(n+2)*(n+2),x3+(n+3)*(n+3),x3+(n+4)*(n+4),x3+(n+5)*(n+5)

	@Test
	public void DiffSquareOfNPlusOne() {

		String name = "DiffSquareOfNPlusOne";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("2");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("2,11,27,52,63,76,91".equals(result));

	}

	// Undulating,101,111,121,131,141,151,161

	@Test
	public void Undulating() {

		String name = "Undulating";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("2");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("101,111,121,131,141,151,161".equals(result));

	}

	// Prime,2,3,5,7,11,13,17

	@Test
	public void Prime() {

		String name = "Prime";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("2");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("2,3,5,7,11,13,17".equals(result));

	}

	// Prime1,19,23,29,31,37,41,47

	@Test
	public void Prime1() {

		String name = "Prime1";

		SeriesDefinitionTO definition = new SeriesDefinitionTO();

		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);

		definition.setEncodedSeries(series);
		definition.setExplanation(name + ".MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("2");
		definition.setIncrement("3");

		String result = AppxUtil.getSeriesResult(definition);

		System.out.println(result);

		assertTrue("19,23,29,31,37,41,47".equals(result));

	}

}