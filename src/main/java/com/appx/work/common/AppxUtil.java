package com.appx.work.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.appx.work.domain.Series;
import com.appx.work.domain.SeriesDefinition;
import com.appx.work.service.AppxService;
import com.appx.work.to.SeriesDefinitionTO;

public class AppxUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppxUtil.class);

	public static AppxService service;

	public AppxUtil() {

	}

	public static List<Long> loadDefinitionsFromFile() {

		List<Long> definitionIdList = new ArrayList<Long>();

		InputStream is = AppxUtil.class.getResourceAsStream("/rules.csv");

		List<String> exprList = getStringFromInputStream(is);

		for (Iterator iterator = exprList.iterator(); iterator.hasNext();) {
			String line = (String) iterator.next();
			
			if ( line.startsWith("#")){
				continue;
			}

			String[] cols = line.split(",");

			String name = cols[0];
			String startNum = cols[1];
			String increment = cols[2];
			String expression = "";

			for (int i = 3; i < cols.length; i++) {
				expression = expression + cols[i] + ",";
			}

			expression = expression.substring(0, expression.lastIndexOf(","));

			System.out.println(name + ":" + startNum + ":" + increment + ":" + expression);

			SeriesDefinition definition = new SeriesDefinition();

			definition.setName(name);
			definition.setDescription(name + " description");
			definition.setEncodedSeries(expression);
			definition.setExplanation(name + "  Explanation");
			definition.setLevel(1);
			definition.setStartNumber(startNum);
			definition.setIncrement(Integer.parseInt(increment));

			definition = service.saveDefinition(definition);

			definitionIdList.add(definition.getId());

		}

		return definitionIdList;

	}

	public static List<Long> loadDefinitions() {

		List<Long> definitionIdList = new ArrayList<Long>();

		SeriesDefinition definition = new SeriesDefinition();

		definition.setName("IncrementWithOne");
		definition.setDescription("Each number increments by 1");
		definition.setEncodedSeries("x, x1+1 , x1+2, x1+3, x1+4, x1+5");
		definition.setExplanation("IncrementWithOne.MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());

		definition = new SeriesDefinition();

		definition.setName("SquareSeries");
		definition.setDescription("Square of numbers");
		definition.setEncodedSeries(
				"x, (x1+1) * (x1+1) , (x1+2) * (x1+2) , (x1+3) * (x1+3) , (x1+4) * (x1+4) , (x1+5) * (x1+5)");
		definition.setExplanation("SquareSeries.MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());

		definition = new SeriesDefinition();

		definition.setName("CubeSeries");
		definition.setDescription("Series of cubes");
		definition.setEncodedSeries(
				"x, (x1+1) * (x1+1) * (x1+1) , (x1+2) * (x1+2) * (x1+2) , (x1+3) * (x1+3) * (x1+3), (x1+4) * (x1+4) * (x1+4), (x1+5) * (x1+5)* (x1+5)");
		definition.setExplanation("CubeSeries.MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());

		definition = new SeriesDefinition();
		definition.setName("SquareSeriesPlusN");
		definition.setDescription("Squares of base number plus increment");
		definition.setEncodedSeries(
				"x, (x1+1) * (x1+1) +n , (x1+2) * (x1+2) + n , (x1+3) * (x1+3) +n , (x1+4) * (x1+4) +n  , (x1+5) * (x1+5) +n");
		definition.setExplanation("SquareSeriesPlusN.MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("SquareSeriesMinusN");
		definition.setDescription("Each number is a square of some number with N substracted from it.");
		definition.setEncodedSeries(
				"x, (x1+1) * (x1+1) - n , (x1+2) * (x1+2) - n , (x1+3) * (x1+3) - n , (x1+4) * (x1+4) - n  , (x1+5) * (x1+5) - n");
		definition.setExplanation("SquareSeriesMinusN.MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("SeriesMultiplyN");
		definition.setDescription("Series is multiplied by N");
		definition.setEncodedSeries("x, (x1+1) *  n , (x1+2) *  n , (x1+3) *  n , (x1+4) *  n  , (x1+5) * n ");
		definition.setExplanation("SeriesMultiplyN.MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("AlternateIncrease");
		definition.setDescription("Alternate number increases by n");
		definition.setEncodedSeries("x, x1 + 5, x1 + n, x2 + n, x3 + n ,x4 + n,x5 + n,x6 + n");
		definition.setExplanation("AlternateIncrease.MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("DecreasingNumbers");
		definition.setDescription("");
		definition.setEncodedSeries("x, x1 -n , x2 -n , x3 - n , x4 -n , x5 - n");
		definition.setExplanation("DecreasingNumbers.MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("IncreaseDecreaseAlternate");
		definition.setDescription("");
		definition.setEncodedSeries("x, x1 + 5, x1 + n, x2 - n, x3 + n, x4 - n, x5 + n , x6 - n");
		definition.setExplanation("IncreaseDecreaseAlternate.MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("DecreaseSteps");
		definition.setDescription("");
		definition.setEncodedSeries("x , x1 - n , x2 - 2 * n , x3 - n , x4 - 2 *n , x5 - n , x6 - 2 * n ");
		definition.setExplanation("DecreaseSteps.MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("StepDecreaseSameNeighbour");
		definition.setDescription("");
		definition.setEncodedSeries("x , x1 , x2 - n , x2 - n , x3 - n , x3 - n , x5 - n , x5 -n ");
		definition.setExplanation("StepDecreaseSameNeighbour.MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("AlternateSameIncreasing");
		definition.setDescription("");
		definition.setEncodedSeries("x , x1 + n , x1 , x2 + n , x1 , x4 + n , x1");
		definition.setExplanation("AlternateSameIncreasing.MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("AlternateDecreasing");
		definition.setDescription("");
		definition.setEncodedSeries("x , x1 - n , x2 - 2 * n , x3 - n , x4 - 2 * n , x5 - n ");
		definition.setExplanation("AlternateDecreasing.MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("AlternateDouble");
		definition.setDescription("");
		definition.setEncodedSeries("x , x1 * n , x1 + 7 , x3 * n , x3 + 7 , x5 * n");
		definition.setExplanation("AlternateDouble.MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("DiffNextNumber");
		definition.setDescription("");
		definition.setEncodedSeries("x , n , x1 + x2 , n * 2 , x3 + x4 , n * 3, x5 + x6 , n * 4  ");
		definition.setExplanation("DiffNextNumber.MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());

		definition = new SeriesDefinition();
		definition.setName("MultOfPrevious");
		definition.setDescription("");
		definition.setEncodedSeries("x , x1 * x1 , x1 * x2 , x2 * x3 , x3 * x4 , x4 * x5 ");
		definition.setExplanation("MultOfPrevious.MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());
		definition = new SeriesDefinition();
		definition.setName("SumOfPrevious");
		definition.setDescription("");
		definition.setEncodedSeries(" , x1 + x1 , x1 + x2 , x2 + x3 , x3 + x4 , x4 + x5 ");
		definition.setExplanation("SumOfPrevious.MESSAGE");
		definition.setLevel(1);
		definition.setStartNumber("1");

		definition = service.saveDefinition(definition);

		definitionIdList.add(definition.getId());

		return definitionIdList;

	}

	public static List<Long> loadData() {

		List<Long> result = new ArrayList<Long>();
		Integer[] nArray = { 1, 3, 5, 7, 9, 11 };

		multipleLoads(service.getSeriesDefinitionByName("IncrementWithN"),
				new String[] { "3", "7", "9", "21", "27", "91", "101", "103" }, nArray, result);
		multipleLoads(service.getSeriesDefinitionByName("DecrementWithN"),
				new String[] { "100", "90", "80", "70", "60", "50" }, nArray, result);
		multipleLoads(service.getSeriesDefinitionByName("Square"),
				new String[] { "2", "3", "4", "5", "6", "7", "8", "9" }, new Integer[] { 1 }, result);
		multipleLoads(service.getSeriesDefinitionByName("SquareWithIncrement"),
				new String[] { "2", "3", "4", "5", "6", "7", "8", "9" }, nArray, result);
		multipleLoads(service.getSeriesDefinitionByName("SquareWithDecrement"),
				new String[] { "2", "3", "4", "5", "6", "7", "8", "9" }, nArray, result);
		multipleLoads(service.getSeriesDefinitionByName("Cube"), new String[] { "2", "3", "4", "5", "6" },
				new Integer[] { 1 }, result);
		multipleLoads(service.getSeriesDefinitionByName("CubeWithIncrement"), new String[] { "2", "3", "4", "5", "6" },
				nArray, result);
		multipleLoads(service.getSeriesDefinitionByName("CubeWithDecrement"), new String[] { "2", "3", "4", "5", "6" },
				nArray, result);
		multipleLoads(service.getSeriesDefinitionByName("MultiplyByN"),
				new String[] { "2", "3", "4", "5", "6", "7", "8", "9" }, nArray, result);
		multipleLoads(service.getSeriesDefinitionByName("AlternateIncrease"),
				new String[] { "3", "7", "9", "21", "27", "91", "101", "103" }, nArray, result);
		multipleLoads(service.getSeriesDefinitionByName("AlterenateDecrease"),
				new String[] { "100", "90", "80", "70", "60", "50" }, nArray, result);
		multipleLoads(service.getSeriesDefinitionByName("AlternateIncDecr"),
				new String[] { "100", "90", "80", "70", "60", "50" }, nArray, result);
		multipleLoads(service.getSeriesDefinitionByName("SameneighbourIncr"),
				new String[] { "3", "7", "9", "21", "27", "91", "101", "103" }, nArray, result);
		multipleLoads(service.getSeriesDefinitionByName("SameneighbourDecr"),
				new String[] { "100", "90", "80", "70", "60", "50" }, nArray, result);
		multipleLoads(service.getSeriesDefinitionByName("PlusMultiply"),
				new String[] { "2", "3", "4", "5", "6", "7", "8", "9" }, nArray, result);
		multipleLoads(service.getSeriesDefinitionByName("MinusMultiple"),
				new String[] { "2", "3", "4", "5", "6", "7", "8", "9" }, nArray, result);
		multipleLoads(service.getSeriesDefinitionByName("IncrementAndAdd"),
				new String[] { "2", "3", "4", "5", "6", "7", "8", "9" }, nArray, result);
		multipleLoads(service.getSeriesDefinitionByName("DecrementAndAdd"),
				new String[] { "100", "90", "80", "70", "60", "50" }, nArray, result);
		multipleLoads(service.getSeriesDefinitionByName("SumOfPrevious"),
				new String[] { "3", "7", "9", "21", "27", "91", "101", "103" }, nArray, result);

		return result;
	}

	private static void multipleLoads(SeriesDefinitionTO definition, String[] startNumbers, Integer[] increments,
			List<Long> result) {
		
		if ( definition == null ) {
			return;
		}

		for (int i = 0; i < startNumbers.length; i++) {

			String startNo = startNumbers[i];

			for (int j = 0; j < increments.length; j++) {
				int increment = increments[j];

				SeriesDefinition defn = new SeriesDefinition();
				BeanUtils.copyProperties(definition, defn);
				List<Series> seriesList = service.saveSeries(defn, startNo, increment);
				for (Iterator iterator = seriesList.iterator(); iterator.hasNext();) {
					Series series = (Series) iterator.next();
					result.add(series.getId());
				}

			}

		}

	}

	private static List<String> getStringFromInputStream(InputStream is) {

		List<String> list = new ArrayList<String>();

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				list.add(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return list;

	}

}
