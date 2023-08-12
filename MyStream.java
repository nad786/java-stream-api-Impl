import java.util.ArrayList;
import java.util.List;

class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}
public class MyStream {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		 List<Product> productsList = new ArrayList<Product>();  
	        //Adding Products  
	        productsList.add(new Product(1,"HP Laptop",25000f));  
	        productsList.add(new  Product(2,"Dell Laptop",30000f));  
	        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
	        productsList.add(new Product(4,"Sony Laptop",28000f));  
	        productsList.add(new Product(5,"Apple Laptop",90000f));  
	        
	        MyStreamImpl<Product> me = new MyStreamImpl<Product>(productsList);
	        
	        System.out.println(me.filter(p -> p.id > 4).map(p -> p.price).reduce(0.0, (p,c) -> p+c));
		
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
//		list.add(6);	
//		list.add(7);
//		list.add(8);
//		list.add(9);
//		list.add(10);
//		
//		MyStreamImpl<Integer> me = new MyStreamImpl<Integer>(list);
//		me.filter(p ->  p<3 ).map(p -> p+1).forEach(p -> {
//			System.out.println(p);
//		});;
//		
//		System.out.println(me.filter(p ->  p<3 ).map(p -> p).noneMatch(p -> p < 4));

	}

}
