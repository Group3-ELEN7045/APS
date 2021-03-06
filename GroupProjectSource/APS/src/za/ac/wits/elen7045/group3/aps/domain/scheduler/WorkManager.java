package za.ac.wits.elen7045.group3.aps.domain.scheduler;


import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * 
 * 
 * @author Ronald Menya
 *
 */
public final class WorkManager implements Cloneable {
    
	/**
	 * 
	 * @author Ronald Menya
	 *
	 */
	private class Worker extends Thread {
		@Override
		public void run() {
			Runnable runnable = null;
			
            while (true) {
                synchronized(scrapeCommandsQueue) {
                	try
                    {
                		System.out.println("Thread " + Thread.currentThread().getName() + " taking commands off queue.");
	                	runnable = scrapeCommandsQueue.take();
                    } catch (InterruptedException ex) {
                    
                    }
                	
                    try {
                    	if (runnable != null) {
                    		runnable.run();	
						}
                    } catch (Exception ex) {
                    	((ScrapeTask) runnable).decrementRetryCount();
                    	
                        if (((ScrapeTask) runnable).getRetryCount() > 0) {
                        	System.out.println("Thread " + Thread.currentThread().getName() + " putting Task back to the Queue.");
    						scrapeCommandsQueue.offer(runnable);
    					}
                    }
                }
            }
		}
	}
	
	/**
	 * 
	 */
	private static WorkManager workManager = null;
	
	/**
	 * FIFO blocking queue
	 */
	private BlockingQueue<Runnable> scrapeCommandsQueue = new ArrayBlockingQueue<Runnable>(1024);
	
	/**
	 * Pool of worker threads
	 */
	private Collection<Worker> workers = new ArrayList<Worker>();
	
	/**
	 * 
	 * @param numOfWorkers
	 */
	private WorkManager(int numOfWorkers) {
		for (int i = 0; i < numOfWorkers; i++) {
			Worker worker = new Worker();
			workers.add(worker);
			worker.start();
		}
	}
	
	public static synchronized WorkManager getInstance(int numOfWorkers) {
		if (workManager == null) {
			workManager = new WorkManager(numOfWorkers);
		}
		
		return workManager;
	}
	
	/**
	 * 
	 * @param runnable
	 */
	public void add(Runnable runnable) {
		System.out.println("Adding scrape task to queue");
		scrapeCommandsQueue.offer(runnable);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}