import java.util.Scanner;

class TaskSchedular
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedQueue<Data> mainQueue = new LinkedQueue<>();

        int i = 0, n = sc.nextInt();
        while(i < n)
        {
            String name = sc.next();
            String subj = sc.next();

            Data d = new Data(name, subj);

            mainQueue.enqueue(d);
            i++;
        }

        while(!mainQueue.isEmpty())
        {
            Data d = mainQueue.dequeue();
            System.out.println(d.getName() + " " + d.getSubj());
        }

        sc.close();
    }
}
