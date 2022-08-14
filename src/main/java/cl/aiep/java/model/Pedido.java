package cl.aiep.java.model;

import java.time.LocalDate;

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
public class Pedido {
	
	@Min(0)
	private Long id;
	private LocalDate fecha;
	private String folio;
	private int detalle;
	private int total;
	@NotNull
	private Producto producto;
	@NotNull
	private Cliente cliente;
	@NotNull
	private Usuario vendedor;

}
