package com.example.client.performancetestutil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//import java.util.concurrent.TimeUnit;

public class PerformanceTestUtil {

	private String filename = null;
	private String appName;
	// private ConcurrentMap<String, Timer> timerList = new ConcurrentHashMap();
	private Map<String, Timer> timerList = new HashMap<String, Timer>();

	public PerformanceTestUtil(String appName) {
		this.appName = new String(appName);
		filename = getFileName();
		createFile();
	}

	private String getFileName() {

		if (null == filename) {
			filename = "PerformanceTestUtil_" + appName + "_"
					+ System.currentTimeMillis() + ".csv";
		} else if (filename.isEmpty()) {
			filename = "PerformanceTestUtil_NoAppName_"
					+ System.currentTimeMillis() + ".csv";
		}

		return filename;

	}

	private void createFile() {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(filename, true));
			writer.write("Execution Type" + "," + "Algorithm Name" + ","
					+ "No of Execution" + "," + "Nano Seconds" + ","
					+ "Seconds" + "," + "Minutes");
			writer.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (null != writer)
					writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private String formatMessage(String Executiontype, String algoName,
			long noCall, long nanoTime, double seconds, double minutes) {
		String message = Executiontype + "," + algoName + "," + noCall + ","
				+ nanoTime + "," + seconds + "," + minutes + "\n";
		return message;
	}

	public void recordTime(String recordname, String algoName, Long noCall,
			long startTime, long endTime) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(filename, true));
			if (null == filename)
				getFileName();

			Long elapsedTime = Long.valueOf(endTime) - Long.valueOf(startTime);
			// double seconds = (double) elapsedTime / 1000000000.0;
			// Long elapsedTime = Long.parseLong("60000000000");
			double seconds = (double) elapsedTime * 0.000000001;
			double minutes = (double) elapsedTime * 0.0000000000166667;
			System.out.println("Nano Elapsed Time:" + elapsedTime);
			System.out.println("second Elapsed Time:" + seconds);
			System.out.println("Minutes Elapsed Time:" + minutes);

			//long second = TimeUnit.NANOSECONDS.toSeconds(elapsedTime);
			//long minu = TimeUnit.NANOSECONDS.toMinutes(elapsedTime);

			writer.write(formatMessage(recordname, algoName, noCall,
					elapsedTime, seconds, minutes));

		} catch (IOException e) {			
			e.printStackTrace();
		} finally {

			try {
				if (null != writer)
					writer.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}

	}

	public void StartTimer(String recordname, String algoName, Long volume) {
		Timer timer;
		if (timerList.containsKey(recordname)) {
			timer = timerList.get(recordname);
			System.out.println("Already Timer exist");
		} else {
			timer = new Timer(recordname);
			timer.setAlgoName(algoName);
			timer.setVolume(volume);
		}
		timer.startTimer();

		timerList.put(recordname, timer);

	}

	public void EndTimer(String recordname) {
		if (timerList.containsKey(recordname)) {
			Timer timer = timerList.get(recordname);
			timer.endTimer();
		} else {
			System.out.println("NoTimer Found to end");
		}
	}

	public void recordTimer(String recordname) {
		if (timerList.containsKey(recordname)) {
			Timer timer = timerList.get(recordname);
			recordTime(timer.getTimerName(), timer.getAlgoName(),
					timer.getVolume(), timer.getStartTime(), timer.getEndTime());
			timerList.remove(recordname);
		}
	}

	public static void main(String[] args) {
		//long startTime = System.nanoTime();
		//long endTime;
		// PerformanceTestUtil perf = new PerformanceTestUtil("Testing");
		PerformanceTestUtil perf1 = new PerformanceTestUtil("TestingTimer");
		Long j = (long) 0;
		// Long cout = Long.parseLong("10000000000");
		Long cout = Long.parseLong("1000");
		perf1.StartTimer("TestingTimer", "dummy", cout);

		for (Long i = (long) 0; i < cout; i++) {
			j++;
		}
		//endTime = System.nanoTime();
		perf1.EndTimer("TestingTimer");
		// perf.recordTime("Testing Perf Util", "dummy", cout, startTime,
		// endTime);
		perf1.recordTimer("TestingTimer");
		perf1.StartTimer("TestingTimerSecond", "dummySecond", cout);
		for (Long i = (long) 0; i < cout; i++) {
			j++;
		}
		perf1.EndTimer("TestingTimerSecond");
		perf1.recordTimer("TestingTimerSecond");
		perf1.StartTimer("TestingTimerSecond", "dummySecond", cout);
		for (Long i = (long) 0; i < cout; i++) {
			j++;
		}
		perf1.EndTimer("TestingTimerSecond");
		perf1.recordTimer("TestingTimerSecond");
	}

}

class Timer {
	private long startTime;
	private long endTime;
	private String timerName;
	private String algoName;
	private Long volume;
	private timerStatus timerRunStatus;

	public enum timerStatus {
		STAT_COMPLETE, STAT_STARTED, STAT_NOTSTARTED
	};

	Timer(String timerName) {
		this.timerName = timerName;
		this.startTime = 0;
		this.endTime = 0;
		this.timerRunStatus = timerStatus.STAT_NOTSTARTED;
	}

	public void startTimer() {
		if (timerRunStatus == timerStatus.STAT_NOTSTARTED) {
			startTime = System.nanoTime();
			endTime = System.nanoTime();
			timerRunStatus = timerStatus.STAT_STARTED;
		}
	}

	public void endTimer() {
		if (timerRunStatus == timerStatus.STAT_STARTED) {
			endTime = System.nanoTime();
			timerRunStatus = timerStatus.STAT_COMPLETE;
		}
	}

	/**
	 * @return the timerName
	 */
	public final String getTimerName() {
		return timerName;
	}

	/**
	 * @param timerName
	 *            the timerName to set
	 */
	public final void setTimerName(String timerName) {
		this.timerName = timerName;
	}

	/**
	 * @return the algoName
	 */
	public final String getAlgoName() {
		return algoName;
	}

	/**
	 * @param algoName
	 *            the algoName to set
	 */
	public final void setAlgoName(String algoName) {
		this.algoName = algoName;
	}

	/**
	 * @return the volume
	 */
	public final Long getVolume() {
		return volume;
	}

	/**
	 * @param volume
	 *            the volume to set
	 */
	public final void setVolume(Long volume) {
		this.volume = volume;
	}

	/**
	 * @return the timerRunStatus
	 */
	public final timerStatus getTimerRunStatus() {
		return timerRunStatus;
	}

	/**
	 * @param timerRunStatus
	 *            the timerRunStatus to set
	 */
	public final void setTimerRunStatus(timerStatus timerRunStatus) {
		this.timerRunStatus = timerRunStatus;
	}

	/**
	 * @return the startTime
	 */
	public final long getStartTime() {
		return startTime;
	}

	/**
	 * @return the endTime
	 */
	public final long getEndTime() {
		return endTime;
	}

}
