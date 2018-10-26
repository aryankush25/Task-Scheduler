import java.util.ArrayList;

public class DivideTask
{
    private ArrayList<SubQueue> array = new ArrayList<>();
    private int numberOfQueues;
    private int maxQueues = 4;
    DivideTask()
    {
        numberOfQueues = 0;
    }

    DivideTask(LinkedQueue<Data> mainQueue)
    {
        numberOfQueues = 0;
        addInSubQueue(mainQueue);
    }

    private static int Time(String subj)
    {
        switch(subj)
        {
            case "C":
            return 1;

            case "CPP":
            return 2;

            case "Java":
            return 3;

            case "Python":
            return 4;
        }

        return 0;
    }

    private int lowestTimeTakingQueue()
    {
        int i = 0;
        int s = array.get(i).getTime();
        int si = i;

        for(i = 1; i < numberOfQueues; i++)
        {
            if (s > array.get(i).getTime()) {
                s = array.get(i).getTime();
                si = i;
            }
        }

        return si;
    }

    public void addInSubQueue(LinkedQueue<Data> mainQueue)
    {

        for(int j = 0; j < maxQueues; j++)
        {
            if (mainQueue.isEmpty()) {
                return ;
            }
            numberOfQueues++;
            Data d = mainQueue.dequeue();
            SubQueue s = new SubQueue();
            s.enqueue(d);
            s.setTime(Time(d.getSubj()));
            array.add(j, s);
        }

        while (!mainQueue.isEmpty())
        {
            int i = lowestTimeTakingQueue();
            Data d = mainQueue.dequeue();
            array.get(i).enqueue(d);
            array.get(i).setTime(Time(d.getSubj()));
        }
    }

    public void ShowData()
    {
        for(int i = 0; i < numberOfQueues; i++)
        {
            while(!array.get(i).isEmpty())
            {
                Data d = array.get(i).dequeue();
                System.out.println("Name " + d.getName() + " Subject " + d.getSubj());
            }
            System.out.println("Time By These " + array.get(i).getTime());
        }
    }
}
