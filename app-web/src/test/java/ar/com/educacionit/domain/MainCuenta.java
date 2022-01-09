package ar.com.educacionit.domain;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import ar.com.educacionit.services.Impl.SociosServicesImpl;

public class MainCuenta {

	public static void main(String[] args) throws Exception {
		
		//Quiero tomar una clase .class y setear los datos (atributos)
		//dentro de una template
		
		Cuenta miCuenta = new Cuenta(100l,"Caja de ahorros", 150000f);
		
		String template = buildTemplate(Cuenta.class,  miCuenta);
		System.out.println(template);
		
		//Construir un string que tenga
		// atributo = valor, atributo2 = valor, atributon = valorn
		
		Socios socios = new SociosServicesImpl().getOne(1l);
		//Accediendo a la base y consulta el id=1
		
		template = buildTemplate(Socios.class,socios);
		System.out.println(template);
		
		Categorias cat = new Categorias();
		cat.setCodigo("100");
		cat.setId(1500l);
		cat.setDescripcion("desc100");
		
		template = buildTemplateWithMethod(Categorias.class,cat);
		System.out.println(template);
		
		
		
		
		
	}
	
	public static String buildTemplate(Class clazz, Object data) throws Exception {
		
		//Con un Objeto podemos obtener la clase
		
		Class claxx = data.getClass();
		
		String nombre_clase = clazz.getSimpleName();
		StringBuffer template = new StringBuffer(nombre_clase);
		
		
		
		template.append("={");
		//Tomo los atributos del class
		  Field[] Fields = clazz.getDeclaredFields(); //atributos
		  
		  
		  for(Field field: Fields) {
			  field.setAccessible(true);//Le digo que sea accesible
			  String name = field.getName(); //Nombre del atributo
			  Object value = field.get(data);// Valor de ese campo, Para saber cual es el valor necesito el objeto
			  
			  template.append(name).append("=");
			  
			  if(value != null){
				  template.append(value.toString());
			  }else {
				  template.append("null");
			  }
			  
			  template.append("|");
		  }
		  
		  template.append("}");
		  
		  return template.toString();
	}

	public static String buildTemplateWithMethod(Class clazz, Object data) throws Exception {
		
		//Con un Objeto podemos obtener la clase
		
		Class claxx = data.getClass();
		
		String nombre_clase = clazz.getSimpleName();
		StringBuffer template = new StringBuffer(nombre_clase);
		
		
		
		template.append("={");
		//Tomo los atributos del class
		  Method[] methods = clazz.getDeclaredMethods(); //atributos
		  
		  
		  for(Method method: methods) {
			  method.setAccessible(true);//Le digo que sea accesible
			  String name = method.getName(); //Nombre del atributo
			  Object value = null;
			  if(name.startsWith("get")){
				  //El invoke necesita el objeto sobre el cual necesita 
				  //invocar
				  value = method.invoke(data);
				  template.append(name).append("=");
				  
				  if(value != null){
					  template.append(value.toString());
				  }else {
					  template.append("null");
				  }
			  }
			  /*Object value = method.invoke()// Valor de ese campo, Para saber cual es el valor necesito el objeto
			  */
			  
			  template.append("|");
		  }
		  
		  template.append("}");
		  
		  return template.toString();
		}

}

