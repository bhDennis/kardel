package multi.chapter6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * p.124 Ԥ��ʱ�����������α���
 * ʹ����֧����ʱ��invokeAll����
 * @author ahs2
 *
 */
public class TravelPrice {

	private final ExecutorService executorService = Executors.newFixedThreadPool(100);
	
	private class QuoteTask implements Callable<TravelQuote>{
		
		private final TravelCompany company;
		private final TraveInfo travelInfo;
		
		public QuoteTask(TravelCompany company,TraveInfo travelInfo){
			this.company = company;
			this.travelInfo = travelInfo;
		}
		public TravelQuote call(){
			return company.solicitQuote(travelInfo);
		}
	}
	
	public List<TravelQuote> getRankedTraveQuotes(TraveInfo travelInfo,
			      Set<TravelCompany> companies,
		          Comparator<TravelQuote> ranking,long time,TimeUnit unit) throws InterruptedException{
		
		List<QuoteTask> tasks = new ArrayList<QuoteTask>();
		for(TravelCompany company : companies){
			tasks.add(new QuoteTask(company,travelInfo));
		}
		
		List<Future<TravelQuote>> futures = executorService.invokeAll(tasks,time,unit);	
		List<TravelQuote> quotes = new ArrayList<TravelQuote>(tasks.size());	
		Iterator<QuoteTask> taskIter = tasks.iterator();
		
		for(Future<TravelQuote> f : futures){
			QuoteTask task = taskIter.next();
			try {
				quotes.add(f.get());
			} catch (InterruptedException e) {
//				quotes.add(task.getFailureQuote(e.getCause()));
			} catch (ExecutionException e) {
//				quotes.add(task.getTimeoutQuote(e));
			}
		}
		
		Collections.sort(quotes,ranking);
		return quotes;
		
	}
	

	class TravelQuote{
		
	}
	
	class TravelCompany{
		
		public TravelQuote solicitQuote(TraveInfo traveInfo){
			return null;
		}
	}
	
	class TraveInfo{
		
	}
}
