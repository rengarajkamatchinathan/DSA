
import java.util.HashSet;
import java.util.PriorityQueue;

class Job{
    int id;
    int deadline;
    int profit;
    Job(int id, int deadline, int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
public class _5_job_sequence_problem {
    public static void main(String[] args) {
        int N = 4;
        Job[] Jobs = {new Job(1,4,20),new Job(2,1,10), new Job(3,1,40),new Job(4,1,30)};
        // Output:
        // 2 60

        PriorityQueue<Job> pq = new PriorityQueue<>((a,b)->b.profit - a.profit);
        for(Job j:Jobs){
            pq.add(j);
        }

        int cnt = 0;
        int maxProfit = 0;
        boolean[] days = new boolean[N+1];

        while (!pq.isEmpty()) {
            Job job = pq.poll();

            //new task for that day also not visited so far
            //what if there are deadline like 4-100 4-90 1-10 1-5
            //we cant miss day-4:100 and day-3:90 and day-1:10
            //so profit it should be <= dealine
            for(int i = Math.min(job.deadline, N); i>=1; i--){
                if (days[i]==false) {
                    days[i] = true;
                    maxProfit += job.profit;
                    cnt++;

                    //break cuz only once task done on <= deadline
                    break;
                }
            }
        }

        System.out.println(maxProfit);
        System.out.println(cnt);
    }
}
