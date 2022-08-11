
import java.util.List;

import dao.FilmDao;
import daoimpl.FilmDaoImpl;
import model.Film;

@RestController
@RequestMapping("/film")
public class FilmRestController {
	
	@PostMapping("/add") 
	public ResponseEntity<String> save(@RequestBody Film f) { 
		FilmDao filmDao = new FilmDaoImpl();
		filmDao.save(f);

		return new ResponseEntity<String>("Inserimento Film effettuato", HttpStatus.CREATED); 
	}
	
	@GetMapping("/findbyregista/{regista}")
	public ResponseEntity<List<Film>> findByRegista(@PathVariable String regista) {
		FilmDao filmDao = new FilmDaoImpl();
		List<Film> f = filmDao.findByRegista(regista);

		return new ResponseEntity<List<Film>>(f, HttpStatus.OK);
	}
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Film> findById(@PathVariable Long id) {
		FilmDao filmDao = new FilmDaoImpl();
		Film f = filmDao.findById(id);

		return new ResponseEntity<Film>(f, HttpStatus.OK);
	}
	
	@GetMapping("/getallfilms")
	public ResponseEntity<List<Film>> getAllFilms() {
		FilmDao filmDao = new FilmDaoImpl();
		List<Film> f = filmDao.getAllFilms();

		return new ResponseEntity<List<Film>>(f, HttpStatus.OK);
	}
	
	@PutMapping("/put/{id}")
	public ResponseEntity<String> update(@RequestBody Film f, @PathVariable Long id) { 
		FilmDao filmDao = new FilmDaoImpl();
		Film film = filmDao.findById(id);
        film.setAnno(f.getAnno());
        film.setRegista(f.getRegista());
        film.setIncasso(f.getIncasso());
        film.setTipo(f.getTipo());
        film.setTitolo(f.getTitolo());
		filmDao.update(film);

		return new ResponseEntity<String>("Aggiornamento Film effettuato", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		FilmDao filmDao = new FilmDaoImpl();
		filmDao.delete(id);
		
		return new ResponseEntity<String>("Eliminazione effettuata correttamente", HttpStatus.OK);
	}
}