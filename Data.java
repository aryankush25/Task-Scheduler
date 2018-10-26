public class Data
{
    private String name;
    private String subj;

    public Data(String name, String subj)
    {
        setName(name);
        setSubj(subj);
    }
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubj() {
		return this.subj;
	}

	public void setSubj(String subj) {
		this.subj = subj;
	}

}
