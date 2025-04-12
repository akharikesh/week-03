
public class compareconcatenate{
    public static void main(String[] args) {
		int n= 1_000_000;
        StringBuffer buffer = new StringBuffer();
		long startbuffer = System.nanoTime();
		for (int i=0; i<=n; i++){
			buffer.append("Hello");
		}
		long endbuffer = System.nanoTime();
		long timebuffer = endbuffer - startbuffer;
		System.out.println("Buffer time : " + timebuffer);
		StringBuilder builder = new StringBuilder();
		long startbuilder = System.nanoTime();
		for (int i=0; i<=n; i++){
			builder.append("Hello");
		}
		long endbuilder = System.nanoTime();
		long timebuilder = endbuilder - startbuilder;
		System.out.println("Builder Time : " + timebuilder);
      
    }
}