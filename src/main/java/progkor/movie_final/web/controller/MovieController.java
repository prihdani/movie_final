package progkor.movie_final.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import progkor.movie_final.data.model.Movie;
import progkor.movie_final.service.MovieService;

import java.util.List;

@Controller
@RequestMapping("/movie_final")
public class MovieController {

    private final MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public String getMovieById(Model model, @PathVariable Long id){
    Movie movie = movieService.retrieveByMovieId(id);
        model.addAttribute("movie",movie);
        return "edit"; }

    @GetMapping
    public String getAllMovie(Model model) {
        List<Movie> allMovie = movieService.retrieveAllMovie();
        model.addAttribute("movie",allMovie);
        return "list";

    }



    @GetMapping("/create")
    public String createMovie( Model model){
        return "create";

    }

    @PostMapping("/create")
    public String createMovie(Model model, @RequestBody Movie movie){
        Movie newMovie = movieService.createMovie(movie);
        model.addAttribute("movie",newMovie);
        return "edit";
    }



    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateMovie(Model model ,@RequestBody Movie movie){
        Movie updateMovie = movieService.update(movie);
        return "edit";
    }

    @GetMapping("/{id}/delete")
    public String deleteMovieById(Model model, @PathVariable Long id){
        movieService.deleteMovieById(id);
        List<Movie> allMovie = movieService.retrieveAllMovie();
        model.addAttribute("movie",allMovie);
        return "list";
    }

}
