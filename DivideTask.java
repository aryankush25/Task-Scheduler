import java.util.ArrayList;

public class DivideTask
{
    private ArrayList<SubQueue> array = new ArrayList<>();

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

        for(i = 1; i < 4; i++)
        {
            if (s > array.get(i).getTime()) {
                s = array.get(i).getTime();
                si = i;
            }
        }

        return si;
    }

    DivideTask(LinkedQueue<Data> mainQueue)
    {
        int i = 0;

        for(int j = 0; j < 4; j++)
        {
            if (mainQueue.isEmpty()) {
                return ;
            }
            Data d = mainQueue.dequeue();
            SubQueue s = new SubQueue();
            s.enqueue(d);
            s.setTime(Time(d.getSubj()));
            array.add(j, s);
        }

        while (!mainQueue.isEmpty())
        {
            i = lowestTimeTakingQueue();
            Data d = mainQueue.dequeue();
            array.get(i).enqueue(d);
            array.get(i).setTime(Time(d.getSubj()));
        }
    }

    public void ShowData()
    {
        for(int i = 0; i < 4; i++)
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
