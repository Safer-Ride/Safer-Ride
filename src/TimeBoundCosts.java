import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

	public class TimeBoundCosts {
		 
		 public static void updateWaitTimeCost(UserNode user) {
			 final ScheduledExecutorService scheduler =
						Executors.newScheduledThreadPool(1);
			 
			 final Runnable waitCost = new Runnable() {
				 public void run() { 
					 //time cost is updated
					 user.setTimeCost(user.getTimeCost()-5);
					 
				 }
			 };
			 final ScheduledFuture<?> waitTimeHandle =
					 scheduler.scheduleAtFixedRate(waitCost, 150, 150, SECONDS);
			 if (user.isAccepted) {
				 waitTimeHandle.cancel(true);
			 }
		 }
	 }
