package ar.com.educacionit.generic;

import java.io.IOException;
import java.util.Collection;

import ar.com.educacionit.domain.Articulos;

public interface IParser<T> {
	public T parse() throws ParseException;
	
	public Collection<Articulos> parseV2() throws ParseException, IOException;
}
