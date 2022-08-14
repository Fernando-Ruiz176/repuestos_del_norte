package cl.aiep.java.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {
	
	@Min(0)
	private int id;
	private String codigo;
	private String nombre;
	private int stock;
	private int precio;
	@NotNull
	private Categoria categoria;

}
