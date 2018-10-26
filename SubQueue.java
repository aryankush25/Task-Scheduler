public class SubQueue
{
    private int time;
    public LinkedQueue<Data> subQueue = new LinkedQueue<>();

    public SubQueue()
    {
    }

    public SubQueue(Data d)
    {
        time = 0;
        subQueue.enqueue(d);
    }

	public int getTime() {
		return this.time;
	}

	public void setTime(int time) {
		this.time = this.time + time;
	}

    public void enqueue(Data t)
    {
        subQueue.enqueue(t);
    }

    public Data dequeue()
    {
        return subQueue.dequeue();
    }

    public boolean isEmpty()
    {
        return subQueue.isEmpty();
    }
}
