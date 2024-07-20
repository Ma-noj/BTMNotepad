package edu.jsp.btm.eca;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowedHeaders = "*", exposedHeaders = "*")
public class NotepadController {
	@Autowired
	private NotePadRepository respository;

	@PostMapping("/notes/save")
	public Notepad saveNotepad(@RequestBody Notepad notepad) {
		notepad = respository.save(notepad);
		return notepad;
	}

	@GetMapping("/notes/findAll")
	public List<Notepad> findAllNotepad() {
		return respository.findAll();
	}

	@GetMapping("/notes/findById")
	public Notepad findById(@RequestParam int notePadId) {
		Optional<Notepad> optional = respository.findById(notePadId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;

	}

	@DeleteMapping("/notes/delete")
	public String deleteById(@RequestParam int notePadId) {
		if (respository.existsById(notePadId)) {
			respository.deleteById(notePadId);
			return "NotePad Delted ";
		}
		return "Notepad WIth the Given Id = " + notePadId + " Is Not Present";
	}

}
