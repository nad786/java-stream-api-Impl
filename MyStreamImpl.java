import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class MyStreamImpl<T> {
	
	List<T> output;
	
	public MyStreamImpl(List<T> l) {
		// TODO Auto-generated constructor stub
		this.output = l;
	}
	
	public <R> MyStreamImpl<R> map(Function<T, R> mapper) throws Exception {
		List<R> list = new ArrayList<R>();
		for (T item : output) {
			list.add(mapper.apply(item));
        }
        return new MyStreamImpl<R>(list);
	}
	
	public <R> R reduce(R identity, BiFunction<R, T, R> accumulator) throws Exception {
		 
		R result = identity;
		  for (T item : output) {
				result = accumulator.apply(result, item);
			}
	 	return result;
	}
	
	public void forEach(Consumer<T> consumer) throws Exception {
			for(T item: output) {
				consumer.accept(item);
			}
	}
	
	public boolean noneMatch(Predicate<T> predicate) {
		boolean flag = true;
		
		for(T item: output) {
			if(!predicate.test(item)) {
				flag = false;
				break;
			}
		}
		
		return flag;
	}

	
	public MyStreamImpl<T> filter(Function<T, Boolean> mapper) throws Exception {
		List<T> list = new ArrayList<T>();
		for (T item : output) {
			if((boolean) mapper.apply(item)) {
				list.add(item);
			}
        }
        return new MyStreamImpl<T>(list);
	}
	

	public List<?> toList() {
		return output;
	}

}
