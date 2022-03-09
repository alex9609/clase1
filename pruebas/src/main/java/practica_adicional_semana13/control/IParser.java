package practica_adicional_semana13.control;

import practica_adicional_semana13.Exceptions.ParseException;

public interface IParser<T> {
	
	public T parse() throws ParseException;

}
