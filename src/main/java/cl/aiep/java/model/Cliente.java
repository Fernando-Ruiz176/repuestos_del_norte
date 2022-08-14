package cl.aiep.java.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
	
	@Min(0)
	private int id;
	private String rut;
	private String razonSocial;
	private String email;
	private String telefono;
	private String direccion;
	@Size(min = 1, max = 4, message = "Debe tener entre 1 y cuatro caracteres.")
	private String region;
	
	

}
