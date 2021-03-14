package actividad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import actividad.service.ReservaServiceImpl;
import actividad.dto.Reserva;

@RestController
@RequestMapping("/api")
public class ReservaController {
	
	@Autowired
	ReservaServiceImpl ReservaServiceImpl;
	
	@GetMapping("/reserva")
	public List<Reserva> listarReserva(){
		return ReservaServiceImpl.listarReserva();
	}
	
	
	@PostMapping("/reserva")
	public Reserva guardarReserva(@RequestBody Reserva reserva) {
		
		return ReservaServiceImpl.guardarReserva(reserva);
	}
	
	
	@GetMapping("/reserva/{id}")
	public Reserva ReservaXID(@PathVariable(name="id") int id) {
		
		Reserva Reserva_xid= new Reserva();
		
		Reserva_xid=ReservaServiceImpl.reservaXID(id);
		
		System.out.println("Reserva XID: "+Reserva_xid);
		
		return Reserva_xid;
	}
	
	@PutMapping("/reserva/{id}")
	public Reserva actualizarReserva(@PathVariable(name="id")int id,@RequestBody Reserva reserva) {
		
		Reserva Reserva_seleccionado= new Reserva();
		Reserva Reserva_actualizado= new Reserva();
		
		Reserva_seleccionado= ReservaServiceImpl.reservaXID(id);
		
		Reserva_seleccionado.setInvestigador(reserva.getInvestigador());
		Reserva_seleccionado.setEquipo(reserva.getEquipo());
		Reserva_seleccionado.setComienzo(reserva.getComienzo());
		Reserva_seleccionado.setFin(reserva.getFin());
		
		
		Reserva_actualizado = ReservaServiceImpl.actualizarReserva(Reserva_seleccionado);
		
		System.out.println("La Reserva actualizada es: "+ Reserva_actualizado);
		
		return Reserva_actualizado;
	}
	
	@DeleteMapping("/reserva/{id}")
	public void eleiminarReserva(@PathVariable(name="id")int id) {
		ReservaServiceImpl.eliminarReserva(id);
	}
	
	
}
