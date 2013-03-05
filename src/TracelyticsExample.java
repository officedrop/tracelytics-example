import java.util.Scanner;

import com.tracelytics.api.Trace;
import com.tracelytics.api.TraceEvent;


public class TracelyticsExample {

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
		
		TraceEvent entryEvent1 = Trace.createEntryEvent("event_1");
		entryEvent1.report();

		TraceEvent exitEvent1 = Trace.createExitEvent("event_1");
		exitEvent1.report();
		
		TraceEvent entryEvent2 = Trace.createEntryEvent("event_2");
		entryEvent2.report();		

		TraceEvent exitEvent2 = Trace.createExitEvent("event_2");
		exitEvent2.report();		
		
		TraceEvent entryEvent3 = Trace.createEntryEvent("event_3");
		entryEvent3.report();		
		
		TraceEvent exitEvent3 = Trace.createExitEvent("event_3");
		exitEvent3.report();		
		
		System.out.printf("Finishing trace with id %s%n", Trace.getCurrentXTraceID());
		System.out.println();
		
		Trace.endTrace("example_trace");		
	}
	
}
