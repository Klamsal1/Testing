package com.focused.demofocused.Controller;


import com.focused.demofocused.Model.Notes;
import com.focused.demofocused.Repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NoteController {


     @Autowired
    NotesRepository notesRepository;

     @PostMapping("/addNotes")
     public ResponseEntity<Notes> addNotes(@RequestBody Notes notes){
             // Save the note to the database
             Notes savedNote = notesRepository.save(notes);
             // Return the saved note with a CREATED status code
             return new ResponseEntity<>(savedNote, HttpStatus.CREATED);
     }

    @GetMapping("/geAlltNotesById")
    public ResponseEntity<List<Notes>> getAllNotes(){
        // Save the note to the database
        List<Notes> getNote = notesRepository.findAll();
        // Return the saved note with a CREATED status code
        return new ResponseEntity<>(getNote,HttpStatus.OK);
    }

    @GetMapping("/note/{id}")
    public ResponseEntity<Notes> getNoteById( @PathVariable Long id){
        // Save the note to the database
        Notes getNote = notesRepository.findById(id).orElse(null);
        // Return the saved note with a CREATED status code
        if(getNote !=null) {
            return new ResponseEntity<>(getNote, HttpStatus.OK);
        } else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

    }
//change is done.
