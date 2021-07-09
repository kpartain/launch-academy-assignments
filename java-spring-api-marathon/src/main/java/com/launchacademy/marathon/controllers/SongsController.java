package com.launchacademy.marathon.controllers;

import com.launchacademy.marathon.models.Song;
import com.launchacademy.marathon.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/songs")
public class SongsController {
    private SongRepository songRepository;

    @Autowired
    public SongsController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @GetMapping
    public Iterable<Song> getListSongs() {
        return songRepository.findAll();
    }

    @GetMapping("/songs")
    public Page<Song> getList(Pageable pageable) {
        return songRepository.findAll(pageable);
    }

    @GetMapping("/new")
    public String getNew(Model model) {
        Song song = new Song();
        model.addAttribute("song", song);
        return "songs/new";
    }

//    @PostMapping("/api/v1/songs")
//    public ResponseEntity create(@Valid @RequestBody Song song, BindingResult result) {
//        if(result.hasErrors()) {
//            return new ResponseEntity<List>(result.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
//        } else {
//            return new ResponseEntity<Song>(songRepository.save(song), HttpStatus.CREATED);
//        }
//    }

    @PostMapping
    public String create(@ModelAttribute @Valid Song song, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "songs/new";
        } else {
            songRepository.save(song);
            return "redirect:/songs/new";
        }
    }
}
