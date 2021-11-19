import org.rascalmpl.interpreter.IEvaluatorContext;

import io.usethesource.vallang.IConstructor;
import io.usethesource.vallang.IList;
import io.usethesource.vallang.IValueFactory;
import io.usethesource.vallang.type.Type;
import io.usethesource.vallang.type.TypeFactory;
import io.usethesource.vallang.type.TypeStore;

public class Factory {

	private final IValueFactory vf;
	
	public static TypeStore ts = new TypeStore();
	public static TypeFactory tf = TypeFactory.getInstance();
	
	public Factory(IValueFactory vf) {
		this.vf = vf; 
	}
	
	public IList createValues(IEvaluatorContext ctx) {
		return vf.list().append(left1()).append(left2()).append(rightFoo());
	}
	
	public IConstructor left1() {
		return vf.constructor(left(), vf.integer(1));
	}
	
	public IConstructor left2() {
		return vf.constructor(left(), vf.integer(2));
	}
	
	public IConstructor rightFoo() {
		return vf.constructor(right(), vf.string("foo"));
	}
	
	private Type left() {
		return tf.constructor(ts, getVallangType("Either"), "left");
	}
	
	private Type right() {
		return tf.constructor(ts, getVallangType("Either"), "right");
	}
	
	private Type getVallangType(String baseType) {
		return tf.abstractDataType(ts, baseType);
	}
}
