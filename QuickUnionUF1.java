public class  QuickUnionUF1{

	private  int []parent;


	public QuickUnionUF1(int n)
	{
		parent=new int[n];
		for(int i=0; i<n; i++)
		{
			parent[i]=i;
		}
	}

	public  int find(int p)
	{

			    validate( p);

		while(p != parent[p])
			 p = parent[p];
        return p;
    }

    
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ; 
       
    }
     public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
	


	public  static  void main(String[] args)
	{
		 int n = StdIn.readInt();
		QuickUnionUF1 uf = new QuickUnionUF1(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
	}
}