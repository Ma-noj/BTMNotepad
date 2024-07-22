package edu.jsp.btm.eca;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowedHeaders = "*", exposedHeaders = "*")
@RequestMapping("/api/notes")
public class NotepadController {
	@Autowired
	private NotePadRepository respository;

	@PostMapping("/save")
	public ResponseEntity<ResponseStrcture<Notepad>> saveNotepad(@RequestBody Notepad notepad) {
		notepad = respository.save(notepad);

		ResponseStrcture<Notepad> strcture = new ResponseStrcture<Notepad>();
		strcture.setStatusCode(HttpStatus.CREATED.value());
		strcture.setMessage("Created");
		strcture.setData(notepad);
		return new ResponseEntity<ResponseStrcture<Notepad>>(strcture, HttpStatus.CREATED);
	}

	@GetMapping("/findAll")
	public List<Notepad> findAllNotepad() {
		return respository.findAll();
	}

	@GetMapping("/findById")
	public Notepad findById(@RequestParam int notePadId) {
		Optional<Notepad> optional = respository.findById(notePadId);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new NotePadIdNotFoundException("Noted With the Given Id = " + notePadId + 
				"  Not Present");

	}

	@DeleteMapping("/delete")
	public String deleteById(@RequestParam int notePadId) {
		if (respository.existsById(notePadId)) {
			respository.deleteById(notePadId);
			return "NotePad Delted ";
		}
		return "Notepad WIth the Given Id = " + notePadId + " Is Not Present";
	}

	@PutMapping("/modify")
	public String modifyNotePad(@RequestBody Notepad notepad) {
//		1) Checking NotePad is NOt Null
//		2) NotePad Is Not 0
//		3) Is NotePad with the Given Id Present Or Not

		if (notepad != null && notepad.getNotepadId() != 0 && 
				respository.existsById(notepad.getNotepadId())) {
			respository.save(notepad);
			return "NotePad Updetd";
		}
		return "Invlid Info";

	}

}
