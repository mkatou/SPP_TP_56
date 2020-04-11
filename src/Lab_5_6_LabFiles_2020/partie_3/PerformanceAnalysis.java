package Lab_5_6_LabFiles_2020.partie_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Lab_5_6_LabFiles_2020.interfaces.IFilter;
import Lab_5_6_LabFiles_2020.interfaces.IImageFilteringEngine;

public class PerformanceAnalysis {

	
	static double preformance_time(IImageFilteringEngine FilteringEngine, IFilter filter) throws Exception {
		long begin= System.nanoTime();
		FilteringEngine.applyFilter(filter);
		long end = System.nanoTime() - begin;
		return end * Math.pow(10, -9);
	}

	static void CSVOutput(String file, double[] times) throws IOException {
		BufferedWriter Output_File = new BufferedWriter(new FileWriter(file, false));
		Output_File.append("Thread,time");
		for (int i = 1; i < times.length; i++) {
			Output_File.append("\n").append(String.valueOf(i)).append(",").append(String.valueOf(times[i]) + " s");
		}
		Output_File.close();
	}

} //PerformanceAnalysis
