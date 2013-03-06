import java.io.File;
import java.util.Scanner;

import com.tracelytics.api.Trace;
import com.tracelytics.api.TraceEvent;


public class TracelyticsExample {

	static class SampleNonJsonableObject {
		
		SampleNonJsonableObject() {}
		
		private String name;
		private int other;
		private File file;
		
	}
	
	public static void main( String[] args ) {		
		
		Scanner s = new Scanner(System.in);
		
		boolean exit = false;
		
		while ( !exit ) {
			
			System.out.printf("Select how many times it should run:");
			int times = s.nextInt();
			
			if ( times <= 0 ) {
				exit = true;
			} else {
				for ( int x = 0; x < times; x++ ) {
					runTrace();
				}
			}
			
		}
		
		s.close();		
	}
	
	private static void runTrace() {
		TraceEvent trace = Trace.startTrace("example_trace");
		trace.report();
		
		System.out.printf("Starting trace with id %s%n", Trace.getCurrentXTraceID());
		
		System.out.printf("Starting event_1 trace with id %s%n", Trace.getCurrentXTraceID());
		TraceEvent entryEvent1 = Trace.createEntryEvent("event_1");
		entryEvent1.addInfo( "sample_data" , new SampleNonJsonableObject());
		entryEvent1.report();

		TraceEvent exitEvent1 = Trace.createExitEvent("event_1");
		exitEvent1.report();
		
		System.out.printf("Starting event_2 trace with id %s%n", Trace.getCurrentXTraceID());
		TraceEvent entryEvent2 = Trace.createEntryEvent("event_2");
		entryEvent2.report();		

		TraceEvent exitEvent2 = Trace.createExitEvent("event_2");
		exitEvent2.report();		
		
		System.out.printf("Starting event_3 trace with id %s%n", Trace.getCurrentXTraceID());
		TraceEvent entryEvent3 = Trace.createEntryEvent("event_3");
		entryEvent3.report();		
		
		TraceEvent exitEvent3 = Trace.createExitEvent("event_3");
		exitEvent3.report();		
		
		System.out.printf("Finishing trace with id %s%n", Trace.getCurrentXTraceID());
		System.out.println();
		
		Trace.endTrace("example_trace");		
	}
	
}
