package tp1.ejercicio1;

public class estructuras {
   public static void conFor(int a, int b) {
	   System.out.print("Con for");
	   for(int i=a;i <=b;i++) {
		   System.out.print(i);
		   System.out.print("\n");
	   }
   }
   public static void conWhile(int a, int b) {
	   System.out.print("Con while");
	   while(a <= b) {
		   System.out.print(a);
		   System.out.print("\n");
		   a+=1;
	   }
   } 
   public static void conRecur(int a,int b) {
	   if(a <= b) {
		   System.out.print(a);
		   System.out.print("\n");
		   conRecur(a+1,b);
	   }
   }
}
