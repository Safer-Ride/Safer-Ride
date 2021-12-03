import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TimeBoundCosts {

     public static void updateWaitTimeCost(UserNode user) {
         final ScheduledExecutorService scheduler =
                    Executors.newScheduledThreadPool(1);

         final Runnable waitCost = new Runnable() {
             public void run() {
                 //time cost is updated
            	 if (user.getTimeCost() != 0.0) {
                 user.setTimeCost(user.getTimeCost()-5);
            	 }
            	 else {
            		 return;
            	 }
             }
         };
         final ScheduledFuture<?> waitTimeHandle =
                 scheduler.scheduleAtFixedRate(waitCost, 5, 30, SECONDS);
         if (user.isAccepted) {
             waitTimeHandle.cancel(true);
         }
     }
 }
