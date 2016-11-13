package com.appx.work.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.series.numberseries.util.AppxUtil;
import com.series.numberseries.util.SeriesDefinitionTO;

public class GenerateSeriesDataTest extends Assert {

	// int[] incrArray = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
	// 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
	// 97 };

	int[] incrArray = { 2, 3, 5, 7, 11, 13, 17, 19 };

	@BeforeClass
	public static void uploadDefinition() {
		AppxUtil.loadDefinitions();
	}

	public static List<String> seriesData = new ArrayList<String>();

	

	@Test
	public void generateIncrementWithN() {

		List<String> dataList = new ArrayList<String>();

		SeriesDefinitionTO definition = new SeriesDefinitionTO();
		String result = null;
		String name = "IncrementWithN";
		int id = name.hashCode();
		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);
		definition.setEncodedSeries(series);
		definition.setExplanation(name + "MESSAGE");

		int level = 1;
		for (int i = 2; i < 99; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 2;
		for (int i = 101; i < 501; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 3;
		for (int i = 601; i < 801; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			// System.out.println(string);

		}
		writeFile(name,dataList);
	}

	@Test
	public void DecrementWithN() {

		List<String> dataList = new ArrayList<String>();

		SeriesDefinitionTO definition = new SeriesDefinitionTO();
		String result = null;
		String name = "DecrementWithN";
		int id = name.hashCode();
		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);
		definition.setEncodedSeries(series);
		definition.setExplanation(name + "MESSAGE");

		int level = 1;
		for (int i = 101; i < 501; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 2;
		for (int i = 601; i < 801; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 3;
		for (int i = 801; i < 999; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);

			}
		}

		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			// System.out.println(string);

		}
		writeFile(name,dataList);
	}

	@Test
	public void Square() {

		List<String> dataList = new ArrayList<String>();

		SeriesDefinitionTO definition = new SeriesDefinitionTO();
		String result = null;
		String name = "Square";
		int id = name.hashCode();
		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);
		definition.setEncodedSeries(series);
		definition.setExplanation(name + "MESSAGE");

		int level = 1;
		for (int i = 1; i < 9; i++) {
			definition.setStartNumber(i + "");
			definition.setLevel(level);
			result = AppxUtil.getSeriesResult(definition);
			String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement() + ","
					+ result;
			dataList.add(data);
		}

		level = 2;
		for (int i = 10; i < 19; i++) {
			definition.setStartNumber(i + "");

			definition.setLevel(level);
			result = AppxUtil.getSeriesResult(definition);
			String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement() + ","
					+ result;
			dataList.add(data);
		}

		level = 3;
		for (int i = 19; i < 30; i++) {
			definition.setStartNumber(i + "");

			definition.setLevel(level);
			result = AppxUtil.getSeriesResult(definition);
			String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement() + ","
					+ result;
			dataList.add(data);
		}

		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			// System.out.println(string);

		}
		writeFile(name,dataList);
	}

	@Test
	public void Cube() {

		List<String> dataList = new ArrayList<String>();

		SeriesDefinitionTO definition = new SeriesDefinitionTO();
		String result = null;
		String name = "Cube";
		int id = name.hashCode();
		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);
		definition.setEncodedSeries(series);
		definition.setExplanation(name + "MESSAGE");

		int level = 1;
		for (int i = 1; i < 9; i++) {
			definition.setStartNumber(i + "");
			definition.setLevel(level);
			result = AppxUtil.getSeriesResult(definition);
			String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement() + ","
					+ result;
			dataList.add(data);
		}

		level = 2;
		for (int i = 10; i < 19; i++) {
			definition.setStartNumber(i + "");

			definition.setLevel(level);
			result = AppxUtil.getSeriesResult(definition);
			String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement() + ","
					+ result;
			dataList.add(data);
		}

		level = 3;
		for (int i = 19; i < 30; i++) {
			definition.setStartNumber(i + "");

			definition.setLevel(level);
			result = AppxUtil.getSeriesResult(definition);
			String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement() + ","
					+ result;
			dataList.add(data);
		}

		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			// System.out.println(string);

		}
		writeFile(name,dataList);
	}

	@Test
	public void MultiplyByN() {

		List<String> dataList = new ArrayList<String>();

		SeriesDefinitionTO definition = new SeriesDefinitionTO();
		String result = null;
		String name = "MultiplyByN";
		int id = name.hashCode();
		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);
		definition.setEncodedSeries(series);
		definition.setExplanation(name + "MESSAGE");

		int level = 1;
		for (int i = 1; i < 9; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 2;
		for (int i = 10; i < 19; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 3;
		for (int i = 19; i < 30; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			// System.out.println(string);

		}
		writeFile(name,dataList);
	}

	@Test
	public void AlternateIncrease() {

		List<String> dataList = new ArrayList<String>();

		SeriesDefinitionTO definition = new SeriesDefinitionTO();
		String result = null;
		String name = "AlternateIncrease";
		int id = name.hashCode();
		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);
		definition.setEncodedSeries(series);
		definition.setExplanation(name + "MESSAGE");

		int level = 1;
		for (int i = 2; i < 99; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 2;
		for (int i = 101; i < 501; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 3;
		for (int i = 601; i < 801; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			// System.out.println(string);

		}
		writeFile(name,dataList);
	}

	@Test
	public void AlterenateDecrease() {

		List<String> dataList = new ArrayList<String>();

		SeriesDefinitionTO definition = new SeriesDefinitionTO();
		String result = null;
		String name = "AlterenateDecrease";
		int id = name.hashCode();
		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);
		definition.setEncodedSeries(series);
		definition.setExplanation(name + "MESSAGE");

		int level = 1;
		for (int i = 101; i < 501; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 2;
		for (int i = 601; i < 801; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 3;
		for (int i = 801; i < 999; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);

			}
		}

		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			// System.out.println(string);

		}
		writeFile(name,dataList);
	}

	@Test
	public void AlternateIncDecr() {

		List<String> dataList = new ArrayList<String>();

		SeriesDefinitionTO definition = new SeriesDefinitionTO();
		String result = null;
		String name = "AlterenateDecrease";
		int id = name.hashCode();
		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);
		definition.setEncodedSeries(series);
		definition.setExplanation(name + "MESSAGE");

		int level = 1;
		for (int i = 101; i < 501; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 2;
		for (int i = 601; i < 801; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 3;
		for (int i = 801; i < 999; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);

			}
		}

		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			// System.out.println(string);

		}
		writeFile(name,dataList);
	}

	// SameneighbourIncr

	@Test
	public void SameneighbourIncr() {

		List<String> dataList = new ArrayList<String>();

		SeriesDefinitionTO definition = new SeriesDefinitionTO();
		String result = null;
		String name = "SameneighbourIncr";
		int id = name.hashCode();
		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);
		definition.setEncodedSeries(series);
		definition.setExplanation(name + "MESSAGE");

		int level = 1;
		for (int i = 101; i < 501; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 2;
		for (int i = 601; i < 801; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 3;
		for (int i = 801; i < 999; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);

			}
		}

		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			// System.out.println(string);

		}
		writeFile(name,dataList);
	}

	// SameneighbourDecr

	@Test
	public void SameneighbourDecr() {

		List<String> dataList = new ArrayList<String>();

		SeriesDefinitionTO definition = new SeriesDefinitionTO();
		String result = null;
		String name = "SameneighbourDecr";
		int id = name.hashCode();
		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);
		definition.setEncodedSeries(series);
		definition.setExplanation(name + "MESSAGE");

		int level = 1;
		for (int i = 101; i < 501; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 2;
		for (int i = 601; i < 801; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 3;
		for (int i = 801; i < 999; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);

			}
		}

		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			// System.out.println(string);

		}
		writeFile(name,dataList);
	}

	// IncrementAndAdd

	@Test
	public void IncrementAndAdd() {

		List<String> dataList = new ArrayList<String>();

		SeriesDefinitionTO definition = new SeriesDefinitionTO();
		String result = null;
		String name = "IncrementAndAdd";
		int id = name.hashCode();
		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);
		definition.setEncodedSeries(series);
		definition.setExplanation(name + "MESSAGE");

		int level = 1;
		for (int i = 101; i < 501; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 2;
		for (int i = 601; i < 801; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 3;
		for (int i = 801; i < 999; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);

			}
		}

		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			// System.out.println(string);

		}
		writeFile(name,dataList);
	}

	// DecrementAndAdd

	@Test
	public void DecrementAndAdd() {

		List<String> dataList = new ArrayList<String>();

		SeriesDefinitionTO definition = new SeriesDefinitionTO();
		String result = null;
		String name = "DecrementAndAdd";
		int id = name.hashCode();
		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);
		definition.setEncodedSeries(series);
		definition.setExplanation(name + "MESSAGE");

		int level = 1;
		for (int i = 101; i < 501; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 2;
		for (int i = 601; i < 801; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 3;
		for (int i = 801; i < 999; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);

			}
		}

		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			// System.out.println(string);

		}
		writeFile(name,dataList);
	}

	// SumOfPrevious
	@Test
	public void SumOfPrevious() {

		List<String> dataList = new ArrayList<String>();

		SeriesDefinitionTO definition = new SeriesDefinitionTO();
		String result = null;
		String name = "SumOfPrevious";
		int id = name.hashCode();
		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);
		definition.setEncodedSeries(series);
		definition.setExplanation(name + "MESSAGE");

		int level = 1;
		for (int i = 10; i < 100; i++) {

			definition.setStartNumber(i + "");

			definition.setLevel(level);
			result = AppxUtil.getSeriesResult(definition);
			String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement() + ","
					+ result;
			dataList.add(data);

		}

		level = 2;
		for (int i = 101; i < 200; i++) {

			definition.setStartNumber(i + "");

			definition.setLevel(level);
			result = AppxUtil.getSeriesResult(definition);
			String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement() + ","
					+ result;
			dataList.add(data);

		}

		level = 3;
		for (int i = 201; i < 333; i++) {

			definition.setStartNumber(i + "");

			definition.setLevel(level);
			result = AppxUtil.getSeriesResult(definition);
			String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement() + ","
					+ result;
			dataList.add(data);

		}

		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			// System.out.println(string);

		}
		writeFile(name,dataList);
	}

	// Kolakoski

	@Test
	public void Kolakoski() {

		List<String> dataList = new ArrayList<String>();

		SeriesDefinitionTO definition = new SeriesDefinitionTO();
		String result = null;
		String name = "Kolakoski";
		int id = name.hashCode();
		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);
		definition.setEncodedSeries(series);
		definition.setExplanation(name + "MESSAGE");

		int level = 1;
		for (int i = 3; i < 501; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 2;
		for (int i = 601; i < 801; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 3;
		for (int i = 801; i < 999; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);

			}
		}

		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			// System.out.println(string);

		}
		writeFile(name,dataList);
	}

	// TwoInSequence

	@Test
	public void TwoInSequence() {

		List<String> dataList = new ArrayList<String>();

		SeriesDefinitionTO definition = new SeriesDefinitionTO();
		String result = null;
		String name = "TwoInSequence";
		int id = name.hashCode();
		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);
		definition.setEncodedSeries(series);
		definition.setExplanation(name + "MESSAGE");

		int level = 1;
		for (int i = 3; i < 501; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 2;
		for (int i = 601; i < 801; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 3;
		for (int i = 801; i < 999; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);

			}
		}

		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			// System.out.println(string);

		}
		writeFile(name,dataList);
	}

	@Test
	public void ThreeInSequence() {

		List<String> dataList = new ArrayList<String>();

		SeriesDefinitionTO definition = new SeriesDefinitionTO();
		String result = null;
		String name = "ThreeInSequence";
		int id = name.hashCode();
		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);
		definition.setEncodedSeries(series);
		definition.setExplanation(name + "MESSAGE");

		int level = 1;
		for (int i = 3; i < 501; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 2;
		for (int i = 601; i < 801; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 3;
		for (int i = 801; i < 999; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);

			}
		}

		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			// System.out.println(string);

		}
		writeFile(name,dataList);
	}

	// DecreasingThree
	@Test
	public void DecreasingThree() {

		List<String> dataList = new ArrayList<String>();

		SeriesDefinitionTO definition = new SeriesDefinitionTO();
		String result = null;
		String name = "DecreasingThree";
		int id = name.hashCode();
		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);
		definition.setEncodedSeries(series);
		definition.setExplanation(name + "MESSAGE");

		int level = 1;
		for (int i = 3; i < 501; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 2;
		for (int i = 601; i < 801; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 3;
		for (int i = 801; i < 999; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);

			}
		}

		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			// System.out.println(string);

		}
		writeFile(name,dataList);
	}

	// Tribonnaci
	//
	@Test
	public void Tribonnaci() {

		List<String> dataList = new ArrayList<String>();

		SeriesDefinitionTO definition = new SeriesDefinitionTO();
		String result = null;
		String name = "Tribonnaci";
		int id = name.hashCode();
		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);
		definition.setEncodedSeries(series);
		definition.setExplanation(name + "MESSAGE");

		int level = 1;
		for (int i = 3; i < 100; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 2;
		for (int i = 100; i < 199; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);
			}
		}

		level = 3;
		for (int i = 200; i < 250; i++) {
			for (int j = 0; j < incrArray.length; j++) {
				definition.setStartNumber(i + "");
				definition.setIncrement(incrArray[j] + "");
				definition.setLevel(level);
				result = AppxUtil.getSeriesResult(definition);
				String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement()
						+ "," + result;
				dataList.add(data);

			}
		}

		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			// System.out.println(string);

		}
		writeFile(name,dataList);
	}

	// PowerSeries
	//

	//

	@Test
	public void PowerSeries() {

		List<String> dataList = new ArrayList<String>();

		SeriesDefinitionTO definition = new SeriesDefinitionTO();
		String result = null;
		String name = "PowerSeries";
		int id = name.hashCode();
		definition.setName(name);
		String series = AppxUtil.definitionMap.get(name);
		definition.setEncodedSeries(series);
		definition.setExplanation(name + "MESSAGE");

		int level = 1;
		for (int i = 2; i < 5; i++) {
			definition.setStartNumber(i + "");
			definition.setLevel(level);
			result = AppxUtil.getSeriesResult(definition);
			String data =  level + "," + definition.getStartNumber() + "," + definition.getIncrement() + ","
					+ result;
			dataList.add(data);
		}

		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			// System.out.println(string);

		}
		writeFile(name,dataList);
	}
	
	public static void writeFile(String id,List<String> list ){
		
		try {

			File file = new File(id + ".csv");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			String content = null;
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				 content = (String) iterator.next();
				bw.write(content);
				bw.write("\n");
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}