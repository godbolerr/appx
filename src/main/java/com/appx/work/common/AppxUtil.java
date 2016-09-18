package com.appx.work.common;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appx.work.domain.Series;
import com.appx.work.domain.SeriesDefinition;
import com.appx.work.service.AppxService;

public class AppxUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppxUtil.class);

	public static AppxService service;

	public AppxUtil() {

	}

	public static List<Long> loadDefinitions() {

		List<Long> definitionIdList = new ArrayList<Long>();

		SeriesDefinition definition = new SeriesDefinition();

		definition.setName("IncrementWithOne");
		definition.setDescription("Each number increments by 1");
		definition.setEncodedSeries("x, x1+1 , x1+2, x1+3, x1+4, x1+5");
		definition.setExplanation("Number in the series is incremented by 1");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());

		definition = new SeriesDefinition();

		definition.setName("SquareSeries");
		definition.setDescription("Square of numbers");
		definition.setEncodedSeries(
				"x, (x1+1) * (x1+1) , (x1+2) * (x1+2) , (x1+3) * (x1+3) , (x1+4) * (x1+4) , (x1+5) * (x1+5)");
		definition.setExplanation("Each number is square of base number. Base number is incremented by 1");
		definition.setLevel(1);
		definition.setStartNumber("");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());

		definition = new SeriesDefinition();

		definition.setName("CubeSeries");
		definition.setDescription("Series of cubes");
		definition.setEncodedSeries(
				"x, (x1+1) * (x1+1) * (x1+1) , (x1+2) * (x1+2) * (x1+2) , (x1+3) * (x1+3) * (x1+3), (x1+4) * (x1+4) * (x1+4), (x1+5) * (x1+5)* (x1+5)");
		definition.setExplanation("Each number is cube of some base number. Base number increments by 1");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());

		definition = new SeriesDefinition();
		definition.setName("SquareSeriesPlusN");
		definition.setDescription("Squares of base number plus increment");
		definition.setEncodedSeries(
				"x, (x1+1) * (x1+1) +n , (x1+2) * (x1+2) + n , (x1+3) * (x1+3) +n , (x1+4) * (x1+4) +n  , (x1+5) * (x1+5) +n");
		definition.setExplanation("Each number is a square of some number plus n added to it.");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("SquareSeriesMinusN");
		definition.setDescription("Each number is a square of some number with N substracted from it.");
		definition.setEncodedSeries(
				"x, (x1+1) * (x1+1) - n , (x1+2) * (x1+2) - n , (x1+3) * (x1+3) - n , (x1+4) * (x1+4) - n  , (x1+5) * (x1+5) - n");
		definition.setExplanation("Each number is a square of some number with N substracted from it.");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("SeriesMultiplyN");
		definition.setDescription("Series is multiplied by N");
		definition.setEncodedSeries("x, (x1+1) *  n , (x1+2) *  n , (x1+3) *  n , (x1+4) *  n  , (x1+5) * n ");
		definition.setExplanation("Series is multiplied by N");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("AlternateIncrease");
		definition.setDescription("Alternate number increases by n");
		definition.setEncodedSeries("x, x1 + 5, x1 + n, x2 + n, x3 + n ,x4 + n,x5 + n,x6 + n");
		definition.setExplanation("Alternate number increases by n");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("DecreasingNumbers");
		definition.setDescription("");
		definition.setEncodedSeries("x, x1 -n , x2 -n , x3 - n , x4 -n , x5 - n");
		definition.setExplanation("Numbers are decreasing by n");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("IncreaseDecreaseAlternate");
		definition.setDescription("");
		definition.setEncodedSeries("x, x1 + 5, x1 + n, x2 - n, x3 + n, x4 - n, x5 + n , x6 - n");
		definition.setExplanation("Series is increasing and decreasing in alternate order");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("DecreaseSteps");
		definition.setDescription("");
		definition.setEncodedSeries("x , x1 - n , x2 - 2 * n , x3 - n , x4 - 2 *n , x5 - n , x6 - 2 * n ");
		definition.setExplanation("Decreasing in steps");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("StepDecreaseSameNeighbour");
		definition.setDescription("");
		definition.setEncodedSeries("x , x1 , x2 - n , x2 - n , x3 - n , x3 - n , x5 - n , x5 -n ");
		definition.setExplanation("DecreasingWithSameNeighbour");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("AlternateSameIncreasing");
		definition.setDescription("");
		definition.setEncodedSeries("x , x1 + n , x1 , x2 + n , x1 , x4 + n , x1");
		definition.setExplanation("Alternate numbers are same and are in increasing order");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("AlternateDecreasing");
		definition.setDescription("");
		definition.setEncodedSeries("x , x1 - n , x2 - 2 * n , x3 - n , x4 - 2 * n , x5 - n ");
		definition.setExplanation("Alternate numbers in decreasing order");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("AlternateDouble");
		definition.setDescription("");
		definition.setEncodedSeries("x , x1 * n , x1 + 7 , x3 * n , x3 + 7 , x5 * n");
		definition.setExplanation("Alternate increase as per pattern");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("DiffNextNumber");
		definition.setDescription("");
		definition.setEncodedSeries("x , n , x1 + x2 , n * 2 , x3 + x4 , n * 3, x5 + x6 , n * 4  ");
		definition.setExplanation("Difference is next number.");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());

		definition = new SeriesDefinition();
		definition.setName("MultOfPrevious");
		definition.setDescription("");
		definition.setEncodedSeries("x , x1 * x1 , x1 * x2 , x2 * x3 , x3 * x4 , x4 * x5 ");
		definition.setExplanation("Number is multiple of previous number");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("SumOfPrevious");
		definition.setDescription("");
		definition.setEncodedSeries(" , x1 + x1 , x1 + x2 , x2 + x3 , x3 + x4 , x4 + x5 ");
		definition.setExplanation("Number is sum of previous numbres");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());

		return definitionIdList;

	}

	public static List<Long> loadData() {

		List<Long> result = new ArrayList<Long>();

		multipleLoads( service.getSeriesDefinitionByName("IncrementWithOne") , new String[] {"3", "7", "9", "21", "27", "91", "101", "103"} , new Integer[] { 1 } , result);
		multipleLoads( service.getSeriesDefinitionByName("SquareSeries") , new String[] {"2", "3", "4", "5", "6", "7", "8", "9"} , new Integer[] { 1 } , result);
		multipleLoads( service.getSeriesDefinitionByName("CubeSeries") , new String[] {"2", "3", "4", "5", "6", "7", "8", "9"} , new Integer[] { 1 } , result);
		multipleLoads( service.getSeriesDefinitionByName("SquareSeriesPlusN") , new String[] {"2", "3", "4", "5", "6", "7", "8", "9"} , new Integer[] { 1 ,3 , 5 , 7 , 9 } , result);
		multipleLoads( service.getSeriesDefinitionByName("SquareSeriesMinusN") , new String[] {"2", "3", "4", "5", "6", "7", "8", "9"} , new Integer[] { 1 ,3 , 5 , 7 , 9 } , result);
		multipleLoads( service.getSeriesDefinitionByName("SeriesMultiplyN") , new String[] {"2", "3", "4", "5", "6", "7", "8", "9"} , new Integer[] { 1 ,3 , 5 , 7 , 9 } , result);
		multipleLoads( service.getSeriesDefinitionByName("AlternateIncrease") , new String[] {"2", "3", "4", "5", "6", "7", "8", "9"} , new Integer[] { 1 ,3 , 5 , 7 , 9 } , result);
		multipleLoads( service.getSeriesDefinitionByName("AlternateDecreasing") , new String[] {"100","90","80","70","60"} , new Integer[] { 1 ,3 , 5 , 7 , 9 } , result);		
		multipleLoads( service.getSeriesDefinitionByName("AlternateIncrease") , new String[] {"12", "32", "24", "45", "56", "37", "18", "92"} , new Integer[] { 1,4,6,7 } , result);
		multipleLoads( service.getSeriesDefinitionByName("DecreasingNumbers") , new String[] {"100","90","80","70","60"} , new Integer[] { 1 } , result);
		
		return result;
	}

	
	private static void multipleLoads(SeriesDefinition definition, String[] startNumbers,Integer[] increments,List<Long> result ) {
		
		for (int i = 0; i < startNumbers.length; i++) {

			String startNo = startNumbers[i];

			for (int j = 0; j < increments.length; j++) {
				int increment = increments[j];
				Series series = service.saveSeries(definition, startNo, increment);
				result.add(series.getId());
			}

		}

	}
}
